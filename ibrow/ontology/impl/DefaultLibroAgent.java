package practica7.ibrow.ontology.impl;


import jade.content.AgentAction;
import practica7.ibrow.ontology.*;

/**
* Protege name: LibroAgent
* @author OntologyBeanGenerator v4.1
* @version 2021/12/24, 19:05:07
*/
public class DefaultLibroAgent implements AgentAction {

  private static final long serialVersionUID = -1819682795856872433L;

  private String _internalInstanceName = null;

  public DefaultLibroAgent() {
    this._internalInstanceName = "";
  }

  public DefaultLibroAgent(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: libro
   */
   private DefaultLibro libro;
   public void setLibro(DefaultLibro value) { 
    this.libro=value;
   }
   public DefaultLibro getLibro() {
     return this.libro;
   }

}
