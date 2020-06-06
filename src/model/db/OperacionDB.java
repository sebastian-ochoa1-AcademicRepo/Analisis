/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.db;

import model.json.OperacionJson;
import model.model.Consignacion;
import model.model.Desactivacion;
import model.model.Operacion;
import model.model.Retiro;
/**
 *
 * @author b4st4rd
 */
public class OperacionDB {
    
    public static void addOperacion(float valor){
        Operacion operacion;
         
        if (valor==0){
            operacion = new Desactivacion();
        }else if(valor<0){
            operacion = new Retiro(valor);
        }else {
            operacion = new Consignacion(valor);
        }
        
        OperacionJson.writeJson(operacion);  
    }
    
    public static Operacion[] operaciones(){
        return OperacionJson.readJson();
    }
}
