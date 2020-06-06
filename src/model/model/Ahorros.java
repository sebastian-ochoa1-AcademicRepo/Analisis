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
public class Ahorros extends Cuenta{
    
    private final float interes= 0.007f;
    
    public Ahorros(String id){
        this.id=id;
        this.balance=0;
        this.activa=false;
    }
    



    
}
