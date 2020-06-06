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
public class PersonaNatural extends Cliente {
    
    public PersonaNatural(String id, String contraseña, String nombre, String telefono, String direccion, String ocupacion){
        this.id = id;
        this.contraseña = contraseña;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ocupacion = ocupacion;
        this.suscrito = false;
    }
    
}
