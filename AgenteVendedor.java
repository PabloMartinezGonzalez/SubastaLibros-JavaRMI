package practica7;

import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.AID;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import practica7.ibrow.ontology.IbrowOntology;
import practica7.ibrow.ontology.impl.*;


public class AgenteVendedor extends Agent {

    private Ontology onto;
    private Codec codec;
    
    
    private HashMap<String, Float> libros;

    // The list of known seller agents
    private AID[] agentesCompradores;

    VVendedor vvendedor;
    String nombre;

    public AgenteVendedor() {
        this.libros = new HashMap<>();

    }

    public HashMap<String, Float> getCatalogue() {
        return libros;
    }

    // Put agent initializations here
    @Override
    protected void setup() {
        // Printout a welcome message
        String[] n = getAID().getName().split("@");
        nombre = n[0];
        vvendedor = new VVendedor(nombre, this);
        vvendedor.setVisible(true);

        codec = new SLCodec();
        onto = IbrowOntology.getInstance();
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(onto);
        
        DFAgentDescription template = new DFAgentDescription();
        template.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Subasta de libro");
        template.addServices(sd);

    }

    public void anadirLibro(String libroSubasta, Float precio) {
        
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                libros.put(libroSubasta, precio);
                System.out.println(libroSubasta + " inserted into catalogue. Price = " + precio);
            }
        });
        
        addBehaviour(new TickerBehaviour(this, 10000) {
            @Override
            protected void onTick() {
                Subasta subasta = vvendedor.getSubasta(libroSubasta);
                if (!subasta.isVendido()) {
                    vvendedor.actualizarTabla(subasta.getNombreLibro(), subasta.getPrecioActual(), subasta.getGanadorProvisional());
                    DFAgentDescription template = new DFAgentDescription();
                    ServiceDescription sd = new ServiceDescription();
                    sd.setType("Subasta de libro");
                    template.addServices(sd);
                    try {
                        DFAgentDescription[] result = DFService.search(myAgent, template);

                        agentesCompradores = new AID[result.length];
                        for (int i = 0; i < result.length; ++i) {
                            agentesCompradores[i] = result[i].getName();
                        }
                    } catch (FIPAException fe) {
                        Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, fe);
                    }

                    myAgent.addBehaviour(new RequestPerformer(this, subasta));
                    vvendedor.actualizarTabla(subasta.getNombreLibro(), subasta.getPrecioActual(), subasta.getGanadorProvisional());
                } else {
                    libros.remove(subasta.getNombreLibro());
                    vvendedor.actualizarSubastas(subasta.getNombreLibro());
                    myAgent.removeBehaviour(this);
                }
            }

        });
    }


//     Put agent clean-up operations here
    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException ex) {
            Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Cerrando  " + getAID().getName() + nombre);
    }

    /**
     * Inner class RequestPerformer. This is the behaviour used by Book-buyer
     * agents to request seller agents the target book.
     */
    private class RequestPerformer extends Behaviour {

        private ArrayList<AID> compradoresPujando;
        private AID mejorPujador;
        private int respuestas;
        private MessageTemplate mt; 
        
        private TickerBehaviour padre;
        private Subasta subasta;
        
        private int step;
        private boolean continuar = false;

        public RequestPerformer(TickerBehaviour padre, Subasta subasta) {
            this.subasta = subasta;
            this.padre = padre;
            this.compradoresPujando = new ArrayList<>();
            this.mejorPujador = null;
            this.respuestas = 0;
            this.step = 0;
        }

        @Override
        public void action() {
            switch (step) {
                case 0:
   
                    ACLMessage cfp = new ACLMessage(ACLMessage.CFP);
                    
                    cfp.setOntology(onto.getName());
                    cfp.setLanguage(codec.getName());
                    
                    DefaultLibro libro = new DefaultLibro();
                    DefaultLibroAgent agenteLibro = new DefaultLibroAgent();
                    
                    libro.setNombreLibro(subasta.getNombreLibro());
                    libro.setPrecio(subasta.getPrecioActual());
                    
                    agenteLibro.setLibro(libro);
                    
                    for (AID agentesCompradore : agentesCompradores) {
                        cfp.addReceiver(agentesCompradore);
                    }
                    cfp.setConversationId(onto.getName());
                    cfp.setReplyWith("cfp" + System.currentTimeMillis());

                    try {
                        getContentManager().fillContent(cfp, new Action(getAID(), agenteLibro));
                    } catch (Codec.CodecException | OntologyException ex) {
                        Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cfp.setPerformative(ACLMessage.CFP);
                    myAgent.send(cfp);
                    
                    mt = MessageTemplate.and(MessageTemplate.MatchOntology(onto.getName()), MessageTemplate.MatchLanguage(codec.getName()));
                    step = 1;
                    break;
                case 1:
                    // Recibir propuestas o rechazos de los compradores
                    ACLMessage reply = myAgent.receive(mt);
                    try {
                        if (reply != null) {
                            
                            Action a = (Action) getContentManager().extractContent(reply);
                            DefaultLibroAgent infoParticipar = (DefaultLibroAgent) a.getAction();
                            
                            String libroSubasta = infoParticipar.getLibro().getNombreLibro();
                            Float estado = infoParticipar.getLibro().getPrecio();
                            
                            if (libroSubasta.equals(subasta.getNombreLibro())) {
                                if (reply.getPerformative() == ACLMessage.PROPOSE) {

                                    if (estado == 1.0f) {
                                        if (mejorPujador == null) {
                                            mejorPujador = reply.getSender();
                                        }
                                        compradoresPujando.add(reply.getSender());
                                        
                                        System.out.println(reply.getSender().getName());
                                        
                                    }
                                }
                                respuestas++;

                                if (!compradoresPujando.isEmpty()) {
                                    subasta.setInteresadosRonda(compradoresPujando);
                                }
                                if (respuestas >= agentesCompradores.length) {
                                    step = 2;
                                }
                            }
                        } else {
                            block();
                        }
                    } catch (Codec.CodecException | OntologyException ex) {
                        Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 2:
                    
                    if (compradoresPujando.size() == 1) {
                        subasta.setGanadorProvisional(mejorPujador);
                        step = 3;
                    } else if (compradoresPujando.size() > 1) {
                        
                        subasta.setGanadorProvisional(mejorPujador);
                        ACLMessage accept = new ACLMessage(ACLMessage.ACCEPT_PROPOSAL);
                        ACLMessage reject = new ACLMessage(ACLMessage.REJECT_PROPOSAL);

                        accept.setOntology(onto.getName());
                        accept.setLanguage(codec.getName());
                        reject.setOntology(onto.getName());
                        reject.setLanguage(codec.getName());
           
                        DefaultLibro libroGanar = new DefaultLibro();
                        DefaultLibroAgent agenteLibroGanar = new DefaultLibroAgent();
                        DefaultLibro libroPerder = new DefaultLibro();
                        DefaultLibroAgent agenteLibroPerder = new DefaultLibroAgent();
                        
                        libroGanar.setNombreLibro(subasta.getNombreLibro());
                        libroGanar.setPrecio(subasta.getPrecioActual());
                        agenteLibroGanar.setLibro(libroGanar);
                        libroPerder.setNombreLibro(subasta.getNombreLibro());
                        libroPerder.setPrecio(subasta.getPrecioActual());
                        agenteLibroPerder.setLibro(libroPerder);

                        for (AID posibleComprador : compradoresPujando) {
                            accept.clearAllReceiver();
                            accept.addReceiver(posibleComprador);
                            reject.clearAllReceiver();
                            reject.addReceiver(posibleComprador);
                            if (posibleComprador.equals(subasta.getGanadorProvisional())) {

                                accept.setConversationId(onto.getName());
                                accept.setReplyWith("aceptar" + System.currentTimeMillis());
                                try {
                                    getContentManager().fillContent(accept, new Action(getAID(), agenteLibroGanar));
                                } catch (Codec.CodecException | OntologyException ex) {
                                    Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                accept.setPerformative(ACLMessage.ACCEPT_PROPOSAL);
                                myAgent.send(accept);
              
                            } else {
                                reject.setConversationId(onto.getName());
                                reject.setReplyWith("rechazar" + System.currentTimeMillis()); // Unique value
                                try {
                                    getContentManager().fillContent(reject, new Action(getAID(), agenteLibroPerder));
                                } catch (Codec.CodecException | OntologyException ex) {
                                    Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                reject.setPerformative(ACLMessage.REJECT_PROPOSAL);
                                myAgent.send(reject);
                                // Prepare the template to get proposals
                                
                            }
                            mt = MessageTemplate.and(MessageTemplate.MatchOntology(onto.getName()), MessageTemplate.MatchLanguage(codec.getName()));
                        }
                        
                        subasta.setPrecioActual(subasta.getPrecioActual() + subasta.getIncremento());
                        libros.put(subasta.getNombreLibro(), subasta.getPrecioActual());
                        continuar = true;

                    } else if (compradoresPujando.isEmpty()) {
                        if (subasta.getGanadorProvisional() == null) {
                            continuar = true;
                            block();
                        } else {
                            subasta.setPrecioActual(subasta.getPrecioActual() - subasta.getIncremento());
                            compradoresPujando = subasta.getInteresadosRonda();
                            step = 3;
                        }
                    }
                    break;
                case 3:
                    ACLMessage request = new ACLMessage(ACLMessage.REQUEST);
                    request.setOntology(onto.getName());
                    request.setLanguage(codec.getName());
                    DefaultLibro libroGanar = new DefaultLibro();
                    DefaultLibroAgent agenteLibroGanar = new DefaultLibroAgent();
                    libroGanar.setNombreLibro(subasta.getNombreLibro());
                    libroGanar.setPrecio(subasta.getPrecioActual());
                    agenteLibroGanar.setLibro(libroGanar);
                    
                    ACLMessage inform = new ACLMessage(ACLMessage.INFORM);
                    inform.setOntology(onto.getName());
                    inform.setLanguage(codec.getName());
                    DefaultLibro libroPerder = new DefaultLibro();
                    DefaultLibroAgent agenteLibroPerder = new DefaultLibroAgent();
                    libroPerder.setNombreLibro(subasta.getNombreLibro());
                    libroPerder.setPrecio(subasta.getPrecioActual());
                    agenteLibroPerder.setLibro(libroGanar);

                    request.addReceiver(subasta.getGanadorProvisional());

                    for (AID posibleComprador : compradoresPujando) 
                        if (!posibleComprador.equals(subasta.getGanadorProvisional())) 
                            inform.addReceiver(posibleComprador);
                    

                    request.setConversationId(onto.getName());
                    request.setReplyWith("order" + System.currentTimeMillis());
                    try {
                        getContentManager().fillContent(request, new Action(getAID(), agenteLibroGanar));
                    } catch (Codec.CodecException | OntologyException ex) {
                        Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    request.setPerformative(ACLMessage.REQUEST);
                    myAgent.send(request);
                    mt = MessageTemplate.and(MessageTemplate.MatchOntology(onto.getName()), MessageTemplate.MatchLanguage(codec.getName()));
                    vvendedor.vendido(subasta.getNombreLibro());
                    
                    
                    inform.setConversationId(onto.getName());
                    inform.setReplyWith("inform" + System.currentTimeMillis());
                    try {
                        getContentManager().fillContent(inform, new Action(getAID(), agenteLibroPerder));
                    } catch (Codec.CodecException | OntologyException ex) {
                        Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    inform.setPerformative(ACLMessage.INFORM);
                    myAgent.send(inform);
                    mt = MessageTemplate.and(MessageTemplate.MatchOntology(onto.getName()), MessageTemplate.MatchLanguage(codec.getName()));

                    step = 4;
                    break;
            }

        }

        @Override
        public boolean done() {
            return (step == 4 || continuar == true);
        }
    }  // End of inner class RequestPerformer
}
