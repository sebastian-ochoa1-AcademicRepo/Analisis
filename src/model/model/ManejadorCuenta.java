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
public class ManejadorCuenta {
    
    public static void activarCuenta(String idCuenta){
        int i = CuentaDB.iCuenta(idCuenta);
        Cuenta[] cuentas = CuentaDB.cuentas();
        cuentas[i].setActiva(true);
        CuentaDB.actualizarCuentas(cuentas);
    }
    
    public static void desactivarCuenta(String idCuenta){
        int i = CuentaDB.iCuenta(idCuenta);
        Cuenta[] cuentas = CuentaDB.cuentas();
        cuentas[i].setActiva(false);
        CuentaDB.actualizarCuentas(cuentas);
    }
    
}
