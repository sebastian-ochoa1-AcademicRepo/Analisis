/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import model.db.CuentaDB;

/**
 *
 * @author b4st4rd
 */
public class Corriente extends Cuenta{
    
    public Corriente(String id){
        this.id=id;
        this.balance=0;
        this.activa=false;
    }
    
    
}
