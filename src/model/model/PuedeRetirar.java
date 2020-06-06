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
public interface PuedeRetirar {
    
    public static boolean puedeRetirar(Cuenta cuenta, float valor, float interes){
        float min;
        min= valor + (valor*interes);
        
        if(cuenta.isActiva()){
            if (cuenta.getBalance()>=min+10000)return true;
        }else{
            int permitido = (int)(cuenta.getBalance()/10000);
            permitido = permitido*10000;
            if((float)permitido+(float)((float)permitido*interes)>cuenta.getBalance())permitido-=10000;
            if((valor==permitido)&&(float)permitido+(float)((float)permitido*interes)<=cuenta.getBalance())return true;
        }
        
        return false;
    }
    
}
