/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import model.db.CuentaDB;
import model.db.OperacionDB;

/**
 *
 * @author b4st4rd
 */
public class Cuenta implements PuedeRetirar{
    protected String id;
    protected float balance;
    protected boolean activa;
    
    public void consignar(float valor, int iCuenta){
        Cuenta[] c = CuentaDB.cuentas();
        crearOperacion((this.balance+valor)-this.balance);
        this.balance += valor;
        c[iCuenta].setBalance(this.balance);
        CuentaDB.actualizarCuentas(c);
    }
    
    
    public void crearOperacion(float valor){
        OperacionDB.addOperacion(valor);
    }

    public boolean retirar(float valor, int iCuenta, float inter){
        Cuenta[] c = CuentaDB.cuentas();
        
        if(PuedeRetirar.puedeRetirar(this, valor, inter)){
            crearOperacion((this.balance-valor)-this.balance);
            this.balance -= (valor+(valor*inter));
            c[iCuenta].setBalance(this.balance);
            CuentaDB.actualizarCuentas(c);
            return true;
        }else{
            return false;
        }
    }

    
    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the balance
     */
    public float getBalance() {
        return balance;
    }

    /**
     * @param balance the balance to set
     */
    public void setBalance(float balance) {
        this.balance = balance;
    }

    /**
     * @return the activa
     */
    public boolean isActiva() {
        return activa;
    }

    /**
     * @param activa the activa to set
     */
    public void setActiva(boolean activa) {
        this.activa = activa;
    }
    
}
