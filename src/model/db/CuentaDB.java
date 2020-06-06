/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db;

import model.json.CuentaJson;
import model.model.Ahorros;
import model.model.Corriente;
import model.model.Cuenta;

/**
 *
 * @author b4st4rd
 */
public class CuentaDB {
    static int cuentas=CuentaJson.readJson().length;
    
    
    public static String addCuenta(String id,boolean type){
        Cuenta cuenta;
        String idCuenta;
        if(cuentas>9){
            if(cuentas>99){
                if(cuentas>999)
                {
                    idCuenta = ""+cuentas;
                }else{
                    idCuenta = "0"+cuentas;
                }
            }else{
                idCuenta = "00"+cuentas;
            }
        }else{
            idCuenta = "000"+cuentas;
        }
        
        if (type){
            cuenta = new Ahorros(id+"_"+idCuenta);
        }else{
            cuenta = new Corriente(id+"_"+idCuenta);
        }
        CuentaJson.writeJson(cuenta);
        cuentas++;
        return idCuenta;
    }
    
    public static Cuenta[] cuentas(){
        return CuentaJson.readJson();
    }
    
    public static int iCuenta(String id){
        Cuenta[] cuentas = CuentaJson.readJson();
        int i= 1;
        while((i<cuentas.length)&&(!cuentas[i].getId().substring(cuentas[i].getId().length()-4).equals(id))){
            i++;
        }
        if(i==cuentas.length){
            return 0;
        }else{
            return i;
        }
        
    }
    
    public static Cuenta cuenta(String id){
        Cuenta[] cuentas = CuentaJson.readJson();
        int i=1;
        while((i<cuentas.length)&&(!cuentas[i].getId().substring(cuentas[i].getId().length()-4).equals(id))){
            i++;
        }
        if(i==cuentas.length){
            return null;
        }else{
            return cuentas[i];
        }
        
    }
    
    public static void actualizarCuentas(Cuenta[] cuentas){
        CuentaJson.modificarCuentas(cuentas);
    }
    
}
