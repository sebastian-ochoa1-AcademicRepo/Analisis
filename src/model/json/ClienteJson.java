/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.json;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import model.model.Cliente;
import model.model.PersonaNatural;

/**
 *
 * @author juanes
 */
public class ClienteJson {
    
    
    public static Cliente[] readJson(){
        Gson gson = new Gson();

        String json = ""; 
        
        try (BufferedReader br = new BufferedReader(new FileReader("Clientes.json"))){
            String line;
            while ((line = br.readLine()) != null) {
                json+= line;
            }

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        

        Cliente[] clients = gson.fromJson(json, Cliente[].class);
        
        return clients;
        
    }
    
    public static void writeJson(Cliente p){
        Gson gson = new Gson();
        Cliente[] client = ClienteJson.readJson();
        
        if(client==null)client=new Cliente[1];
        
        Cliente[] client1;
        client1 = new Cliente[client.length + 1];
        
        for (int i = 0; i<client.length; i++) {
             
             client1[i] = client[i];
            
         }
        
        client1[client.length] = p;
        
        String json= gson.toJson(client1);
        
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("Clientes.json"))) {
            bw.write(json);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }   
    }
    
    
    
    
}
