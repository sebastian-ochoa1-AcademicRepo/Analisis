/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.json;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.model.Cuenta;

/**
 *
 * @author b4st4rd
 */
public class CuentaJson {
    
    static Gson gson = new Gson();
    
    public static Cuenta[] readJson(){

        String json = ""; 
        
        try (BufferedReader br = new BufferedReader(new FileReader("Cuenta.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        

        
        Cuenta[] cuenta = gson.fromJson(json, Cuenta[].class);
        return cuenta;
        
    }
    
    public static void writeJson(Cuenta p){
        
        Cuenta[] cuenta = CuentaJson.readJson();
        
        if(cuenta==null)cuenta=new Cuenta[1];
        
        Cuenta[] cuenta1;
        cuenta1 = new Cuenta[cuenta.length + 1];
        
        for (int i = 0; i<cuenta.length ; i++) {
             
             cuenta1[i] = cuenta[i];
            
         }
        
        cuenta1[cuenta.length] = p;
        
        modificarCuentas(cuenta1);
    }
    
    public static void modificarCuentas(Cuenta[] cuentas){
        
        String json= gson.toJson(cuentas);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Cuenta.json"))) {
            bw.write(json);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
