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
import model.model.Operacion;

/**
 *
 * @author b4st4rd
 */
public class OperacionJson {
    
    public static Operacion[] readJson(){
        Gson gson = new Gson();

        String json = ""; 
        
        try (BufferedReader br = new BufferedReader(new FileReader("Operacion.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        

        
        Operacion[] operacion = gson.fromJson(json, Operacion[].class);
        return operacion;
        
    }
    
    public static void writeJson(Operacion p){
        Gson gson = new Gson();
        Operacion[] operacion = OperacionJson.readJson();
        
        if(operacion==null)operacion=new Operacion[1];
        
        Operacion[] operacion1;
        operacion1 = new Operacion[operacion.length + 1];
        
        for (int i = 0; i<operacion.length ; i++) {
             
             operacion1[i] = operacion[i];
            
         }
        
        operacion1[operacion.length] = p;
        
        String json= gson.toJson(operacion1);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Operacion.json"))) {
            bw.write(json);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }   
    }
}
