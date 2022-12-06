package practica7.ibrow.ontology.impl;


import jade.content.Concept;
import practica7.ibrow.ontology.*;
/**
* Protege name: Libro
* @author OntologyBeanGenerator v4.1
* @version 2021/12/24, 19:05:07
*/
public class DefaultLibro implements Concept {

  private static final long serialVersionUID = -1819682795856872433L;

  private String _internalInstanceName = null;

  public DefaultLibro() {
    this._internalInstanceName = "";
  }

  public DefaultLibro(String instance_name) {
    this._internalInstanceName = instance_name;
  }

  public String toString() {
    return _internalInstanceName;
  }

   /**
   * Protege name: Precio
   */
   private float precio;
   public void setPrecio(float value) { 
    this.precio=value;
   }
   public float getPrecio() {
     return this.precio;
   }

   /**
   * Protege name: NombreLibro
   */
   private String nombreLibro;
   public void setNombreLibro(String value) { 
    this.nombreLibro=value;
   }
   public String getNombreLibro() {
     return this.nombreLibro;
   }

}
