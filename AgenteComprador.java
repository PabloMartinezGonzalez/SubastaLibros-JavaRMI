

package practica7;

import jade.content.lang.Codec;
import jade.content.onto.Ontology;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.core.behaviours.*;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.domain.DFService;
import jade.domain.FIPAException;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import practica7.ibrow.ontology.IbrowOntology;
import practica7.ibrow.ontology.impl.*;

public class AgenteComprador extends Agent {

    private Ontology onto;
    private Codec codec;
    VComprador vcomprador;
    String[] n;
    String nombre;
    private HashMap<String, Float> libros;
    private HashMap<String, Float> subastas;

    public AgenteComprador() {
        this.libros = new HashMap<>();
        this.subastas = new HashMap<>();
    }

    public HashMap<String, Float> getLibros() {
        return libros;
    }

    @Override
    protected void setup() {
        // Create and show the GUI 
        n = getAID().getName().split("@");
        nombre = n[0];
        this.libros = new HashMap<>();
        vcomprador = new VComprador(nombre, this);
        vcomprador.setVisible(true);

        codec = new SLCodec();
        onto = IbrowOntology.getInstance();
        getContentManager().registerLanguage(codec);
        getContentManager().registerOntology(onto);

        DFAgentDescription dfd = new DFAgentDescription();
        dfd.setName(getAID());
        ServiceDescription sd = new ServiceDescription();
        sd.setType("Subasta de libro");
        sd.setName("JADE-book-trading");
        dfd.addServices(sd);
        try {
            DFService.register(this, dfd);
        } catch (FIPAException ex) {
            Logger.getLogger(AgenteComprador.class.getName()).log(Level.SEVERE, null, ex);
        }

        addBehaviour(new OfertasSubastas());

    }

    @Override
    protected void takeDown() {
        try {
            DFService.deregister(this);
        } catch (FIPAException ex) {
            Logger.getLogger(AgenteComprador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void anadirListaDeseos(String title, Float price) {
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                libros.put(title, price);

            }
        });

    }

    public void eliminarListaDeseos(final String title) {
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                libros.remove(title);
                subastas.remove(title);

            }
        });

    }

    /**
     * This is invoked by the GUI when the user adds a new book for sale
     *
     * @param title
     * @param price
     */
    private class OfertasSubastas extends CyclicBehaviour {

        MessageTemplate mt;

        @Override
        public void action() {
            ACLMessage msg = myAgent.receive(mt);
            if (msg != null) {
                try {
                    Action a = (Action) getContentManager().extractContent(msg);
                    DefaultLibroAgent infoLibro = (DefaultLibroAgent) a.getAction();

                   
                    String libroSubasta = infoLibro.getLibro().getNombreLibro();
                    Float precioVendedor = infoLibro.getLibro().getPrecio();
                    Float precio = vcomprador.precioSubasta(libroSubasta);
                    
                    ACLMessage reply = msg.createReply();
                    reply.setOntology(onto.getName());
                    reply.setLanguage(codec.getName());
                    
                    DefaultLibroAgent agenteRespuesta = new DefaultLibroAgent();
                    DefaultLibro respuesta = new DefaultLibro();
                    respuesta.setNombreLibro(libroSubasta);

                    DefaultLibro libro = new DefaultLibro();
                    libro.setNombreLibro(libroSubasta);
                    switch (msg.getPerformative()) {
                        case ACLMessage.CFP:
                            
                            if (precio != null) {
                                
                                libro.setPrecio(precio);
                                
                                if (libros.keySet().contains(infoLibro.getLibro().getNombreLibro())) {
                                    
                                    if (precio >= precioVendedor) {
                                        
                                        respuesta.setPrecio(1.0f);
                                        subastas.put(libroSubasta, precioVendedor);
                                        vcomprador.anadirSubasta(libroSubasta, precioVendedor);
                                        agenteRespuesta.setLibro(respuesta);
                                        try {
                                            getContentManager().fillContent(reply, new Action(getAID(), agenteRespuesta));
                                        } catch (Codec.CodecException | OntologyException ex) {
                                            Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        reply.setPerformative(ACLMessage.PROPOSE);
                                        myAgent.send(reply);
                                        
                                    } else {
                                        respuesta.setPrecio(0.0f);
                                        if (subastas.containsKey(libroSubasta)) {
                                            subastas.remove(libroSubasta);
                                            vcomprador.eliminarSubasta(libroSubasta);

                                            agenteRespuesta.setLibro(respuesta);
                                            reply.setConversationId(onto.getName());
                                            reply.setReplyWith("reply" + System.currentTimeMillis());
                                            try {
                                                getContentManager().fillContent(reply, new Action(getAID(), agenteRespuesta));
                                            } catch (Codec.CodecException | OntologyException ex) {
                                                Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            reply.setPerformative(ACLMessage.PROPOSE);
                                            myAgent.send(reply);
                                        }
                                    }
                                } else {
                                    respuesta.setPrecio(0.0f);
                                    if (subastas.containsKey(libroSubasta)) {
                                        subastas.remove(libroSubasta);
                                        vcomprador.eliminarSubasta(libroSubasta);
                                        agenteRespuesta.setLibro(respuesta);
                                        try {
                                            getContentManager().fillContent(reply, new Action(getAID(), agenteRespuesta));
                                        } catch (Codec.CodecException | OntologyException ex) {
                                            Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                                        }
                                        reply.setPerformative(ACLMessage.PROPOSE);
                                        myAgent.send(reply);
                                    }
                                }
                            } else {

                                respuesta.setPrecio(0.0f);
                                agenteRespuesta.setLibro(respuesta);
                                try {
                                    getContentManager().fillContent(reply, new Action(getAID(), agenteRespuesta));
                                } catch (Codec.CodecException | OntologyException ex) {
                                    Logger.getLogger(AgenteVendedor.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                reply.setPerformative(ACLMessage.PROPOSE);
                                myAgent.send(reply);
                            }

                            break;

                        case ACLMessage.ACCEPT_PROPOSAL:
                            vcomprador.crearNotificacion(libroSubasta + " -- vas ganando la subasta a precio de: "+ precioVendedor);
                            break;
                        case ACLMessage.REJECT_PROPOSAL:
                            vcomprador.crearNotificacion(libroSubasta + " -- vas perdiendo la subasta a precio de: "+ precioVendedor);

                            break;
                        case ACLMessage.REQUEST:
                            vcomprador.crearNotificacion(libroSubasta + " -- Has ganado la subasta a precio de: "+ precioVendedor);
                            libros.remove(libroSubasta);
                            subastas.remove(libroSubasta);
                            vcomprador.eliminarLibro(libroSubasta);
                            break;
                        case ACLMessage.INFORM:
                            vcomprador.crearNotificacion(libroSubasta + " -- Has perdido la subasta.");
                            vcomprador.eliminarSubasta(libroSubasta);
                            subastas.remove(libroSubasta);
                            break;

                        default:
                            reply.setPerformative(ACLMessage.NOT_UNDERSTOOD);
                            System.out.println(reply.getContent());
                            break;
                    }
                } catch (Codec.CodecException | OntologyException ex) {
                    Logger.getLogger(AgenteComprador.class.getName()).log(Level.SEVERE, null, ex);
                }

            } // End of inner class OfferRequestsServer
            else {
                block();
            }

        }
    }

}
