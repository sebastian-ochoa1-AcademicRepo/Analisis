/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package starbank;

import controller.Controlador;
import model.db.ClienteDB;
import model.db.CuentaDB;
import model.db.OperacionDB;
import model.model.Cliente;
import model.model.Cuenta;
import model.model.Operacion;
import view.Vista;

/**
 *
 * @author b4st4rd
 */
public class StarBank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Vista vista=new Vista();
        Controlador crtl=new Controlador(vista);
    }
    
}
