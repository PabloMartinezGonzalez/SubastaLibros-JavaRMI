/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica7;

import jade.core.AID;
import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Subasta {

    private String nombreLibro;
    private Float precioInicial;
    private Float incremento;
    private Float precioActual;
    private boolean vendido;
    private AID ganadorProvisional;
    private ArrayList<AID> interesadosRonda;

    public Subasta(String nombreLibro, Float precioInicial, boolean vendido, Float incremento) {
        this.nombreLibro = nombreLibro;
        this.precioInicial = precioInicial;
        this.vendido = vendido;
        this.precioActual = precioInicial;
        this.incremento = incremento;
        this.interesadosRonda = new ArrayList<>();
    }

    public ArrayList<AID> getInteresadosRonda() {
        return interesadosRonda;
    }

    public void setInteresadosRonda(ArrayList<AID> interesadosRonda) {
        this.interesadosRonda = interesadosRonda;
    }



    public AID getGanadorProvisional() {
        return ganadorProvisional;
    }

    public void setGanadorProvisional(AID ganadorProvisional) {
        this.ganadorProvisional = ganadorProvisional;
    }

    public Float getIncremento() {
        return incremento;
    }

    public void setIncremento(Float incremento) {
        this.incremento = incremento;
    }

    public String getNombreLibro() {
        return nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    public Float getPrecioInicial() {
        return precioInicial;
    }

    public void setPrecioInicial(Float precio) {
        this.precioInicial = precio;
    }

    public boolean isVendido() {
        return vendido;
    }

    public void setVendido(boolean vendido) {
        this.vendido = vendido;
    }

    public Float getPrecioActual() {
        return precioActual;
    }

    public void setPrecioActual(Float precioActual) {
        this.precioActual = precioActual;
    }

}
