/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import model.db.ClienteDB;
import model.db.CuentaDB;

/**
 *
 * @author b4st4rd
 */
public class Cajero {
    
    
    public void añadirCliente(String id, String contraseña, String nombre, String telefono, String direccion, String ocupacion, String nit, String nombreCompañia, String seccionComercial){
        ClienteDB.addCliente(id, contraseña, nombre, telefono, direccion, ocupacion, nit, nombreCompañia, seccionComercial);
    }
    
    
    public boolean revisarCliente(String idCliente, String Contraseña){
        Cliente cliente = ClienteDB.cliente(idCliente);
        if(cliente==null)return false;
        return cliente.getContraseña().equals(Contraseña);
    }
    
}
