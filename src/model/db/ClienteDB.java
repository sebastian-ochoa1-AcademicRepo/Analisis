/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db;

import model.model.PersonaNatural;
import model.model.Compañia;
import model.model.Cliente;
import model.json.ClienteJson;

/**
 *
 * @author b4st4rd
 */
public class ClienteDB {
    
    public static void addCliente(String id, String contraseña, String nombre, String telefono, String direccion, String ocupacion, String nit, String nombreCompañia, String seccionComercial){
        Cliente Client;
        
        if (nit!=null){
            Client = new Compañia(id, contraseña, nombre, telefono, direccion, ocupacion, nit, nombreCompañia, seccionComercial);
        }else{
            Client= new PersonaNatural(id, contraseña, nombre, telefono, direccion, ocupacion);
        }
        ClienteJson.writeJson(Client);
        
    }
    
    public static Cliente[] clientes(){
        return ClienteJson.readJson();
    }
    
    public static Cliente cliente(String id){
        Cliente[] clientes = ClienteJson.readJson();
        int i=1;
        while((i<clientes.length)&&(!clientes[i].getId().equals(id))){
            i++;
        }
        if(i==clientes.length){
            return null;
        }else{
            return clientes[i];
        }
        
    }
}
