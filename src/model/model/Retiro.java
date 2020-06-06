/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.model;

import java.util.Date;

/**
 *
 * @author b4st4rd
 */
public class Retiro extends Operacion{
    private float valor;

    public Retiro(float valor)
    {
        this.nombre="Retiro";
        this.valor=valor;
        this.date = new Date();
    }
    /**
     * @return the valor
     */
    public float getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
