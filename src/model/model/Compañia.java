/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

/**
 *
 * @author b4st4rd
 */
public class Compañia extends Cliente{

    private String nit;
    private String nombreCompañia;
    private String seccionComercial;
    
    public Compañia(String id, String contraseña, String nombre, String telefono, String direccion, String ocupacion, String nit, String nombreCompañia, String seccionComercial){
        this.id = id;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ocupacion = ocupacion;
        this.nit = nit;
        this.nombreCompañia = nombreCompañia;
        this.seccionComercial = seccionComercial;
        this.suscrito = false;
    }
    
    /**
     * @return the nit
     */
    public String getNit() {
        return nit;
    }

    /**
     * @param nit the nit to set
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * @return the nombreCompañia
     */
    public String getNombreCompañia() {
        return nombreCompañia;
    }

    /**
     * @param nombreCompañia the nombreCompañia to set
     */
    public void setNombreCompañia(String nombreCompañia) {
        this.nombreCompañia = nombreCompañia;
    }

    /**
     * @return the seccionComercial
     */
    public String getSeccionComercial() {
        return seccionComercial;
    }

    /**
     * @param seccionComercial the seccionComercial to set
     */
    public void setSeccionComercial(String seccionComercial) {
        this.seccionComercial = seccionComercial;
    }
    
}
