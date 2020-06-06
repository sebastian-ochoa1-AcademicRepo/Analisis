/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.db.ClienteDB;
import model.db.CuentaDB;
import model.db.OperacionDB;
import model.model.Ahorros;
import model.model.Cajero;
import model.model.Cliente;
import model.model.Cuenta;
import model.model.ManejadorCuenta;
import view.Vista;

/**
 *
 * @author b4st4rd
 */
public class Controlador implements ActionListener{
    
    private Vista view;
    private Cajero cajero=new Cajero();
    private Cliente clienteActual = new Cliente();
    private Cuenta cuentaActual;// = new Cuenta();
    private int iCuentaActual;
//    private modelos
    
    public Controlador(Vista view){
        this.view=view;
        listeners();
        iniciar();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()== view.bAceptarR){
            if(this.view.txContraseña.getText().equals(this.view.txContraseña1.getText())){
                clienteActual.setContraseña(this.view.txContraseña.getText());
                clienteActual.setSuscrito(false);
                cajero.añadirCliente(clienteActual.getId(), clienteActual.getContraseña(), clienteActual.getNombre(), clienteActual.getTelefono(), clienteActual.getDireccion(), clienteActual.getOcupacion(), null, null, null);
                Vista.notificar("Registrado con exito");
                this.view.panelRegistro1.setVisible(false);
                this.view.panelInicial.setVisible(true);
            }else{
                Vista.notificar("Las contraseñas no coinciden");
            }
        }
        
        if(ae.getSource()== view.bActivarC){
            if(cuentaActual.isActiva()){
                Vista.notificar("La cuenta ya está activada");
            }else if(cuentaActual.getBalance()>=20000){
                ManejadorCuenta.activarCuenta(cuentaActual.getId().substring(cuentaActual.getId().length()-4));
                cuentaActual.setActiva(true);
                Vista.notificar("Cuenta activada con exito");
            }else{
                int i = Vista.confirmacion("Para activar esta cuenta, debe consignar $20.000 \nEstá seguro de realizar esta operacion?");
                
                if(i==0){
                    this.cuentaActual.consignar(20000, iCuentaActual);
                    ManejadorCuenta.activarCuenta(cuentaActual.getId().substring(cuentaActual.getId().length()-4));
                    cuentaActual.setActiva(true);
                    Vista.notificar("Consignación realizada con exito");
                    this.view.labSaldo.setText(String.valueOf(cuentaActual.getBalance()));
                }
            }
        }
        
        if(ae.getSource()== view.bAhorros){
            Vista.notificar("Cuenta con id:"+clienteActual.añadirCuenta(true)+" creada exitosamente");
            this.view.panelCreaCuenta.setVisible(false);
            this.view.panelCliente.setVisible(true);
        }
        if(ae.getSource()== view.bSalir){
            this.view.panelCliente.setVisible(false);
            this.view.panelIngreso.setVisible(true);
        }
        if(ae.getSource()== view.bSalirC){
            this.view.panelCuenta.setVisible(false);
            this.view.panelIngresoCuenta.setVisible(true);
        }
        if(ae.getSource()== view.bCancelarC2){
            this.view.panelCreaCuenta.setVisible(false);
            this.view.panelCliente.setVisible(true);
        }
        if(ae.getSource()== view.bCancelarI){
            this.view.panelIngreso.setVisible(false);
            this.view.panelInicial.setVisible(true);
        }
        if(ae.getSource()== view.bCancelarIC){
            this.view.panelIngresoCuenta.setVisible(false);
            this.view.panelCliente.setVisible(true);
        }
        if(ae.getSource()== view.bCancelarO){
            this.view.panelOperacion.setVisible(false);
            this.view.panelCuenta.setVisible(true);
        }
        if(ae.getSource()== view.bCancelarR){
            this.view.panelRegistro.setVisible(false);
            this.view.panelInicial.setVisible(true);
        }
        if(ae.getSource()== view.bConsignar){
            this.view.panelCuenta.setVisible(false);
            this.view.panelOperacion.setVisible(true);
            this.view.bOperacion.setText("Consignar");
        }
        if(ae.getSource()== view.bCorriente){
            Vista.notificar("Cuenta con id:"+clienteActual.añadirCuenta(false)+" creada exitosamente");
            this.view.panelCreaCuenta.setVisible(false);
            this.view.panelCliente.setVisible(true);
        }
        if(ae.getSource()== view.bCrearC){
            this.view.panelCliente.setVisible(false);
            this.view.panelCreaCuenta.setVisible(true);
        }
        if(ae.getSource()== view.bCualesC){
            //Mostrar cuentas del men
        }
        if(ae.getSource()== view.bDesactivarC){
            if(cuentaActual.isActiva()){
                ManejadorCuenta.desactivarCuenta(cuentaActual.getId().substring(cuentaActual.getId().length()-4));
                cuentaActual.setActiva(false);
                OperacionDB.addOperacion(0);
                Vista.notificar("Cuenta desactivada con exito");
            }else{
                Vista.notificar("La cuenta ya está inactiva");
            }
        }
        if(ae.getSource()== view.bElegirC){
            this.view.panelCliente.setVisible(false);
            this.view.panelIngresoCuenta.setVisible(true);
        }
        if(ae.getSource()== view.bIngresar){
            this.view.panelInicial.setVisible(false);
            this.view.panelIngreso.setVisible(true);
        }        
        if(ae.getSource()== view.bIngresarI){
            if(cajero.revisarCliente(this.view.txIDing.getText(), this.view.txContraseñaIng.getText())){
                clienteActual = ClienteDB.cliente(this.view.txIDing.getText());
                this.view.panelIngreso.setVisible(false);
                this.view.panelCliente.setVisible(true);
            }else{
                Vista.notificar("Datos incorrectos, revise e intentelo de nuevo");
            }
        }
        if(ae.getSource()== view.bIngresarC2){
            
            if(CuentaDB.iCuenta(this.view.txCuentaIng.getText())!=0){
                if(CuentaDB.cuenta(this.view.txCuentaIng.getText()).getId().contains(clienteActual.getId())){
                    cuentaActual = CuentaDB.cuenta(this.view.txCuentaIng.getText());
                    iCuentaActual = CuentaDB.iCuenta(this.view.txCuentaIng.getText());
                    this.view.labSaldo.setText(String.valueOf(cuentaActual.getBalance()));
                    this.view.panelIngresoCuenta.setVisible(false);
                    this.view.panelCuenta.setVisible(true);
                }else{
                    Vista.notificar("La cuenta no existe, revise e intentelo de nuevo");
                }
            }else{
                Vista.notificar("La cuenta no existe, revise e intentelo de nuevo");
            }
            
            
            
        }
        
        if(ae.getSource()== view.bOperacion){
            if(this.view.bOperacion.getText().equals("Consignar")){
                if(cuentaActual.isActiva()){
                    cuentaActual.consignar(Float.parseFloat(this.view.txOperacion.getText()), iCuentaActual);
                    this.view.labSaldo.setText(String.valueOf(cuentaActual.getBalance()));
                    Vista.notificar("Consignacion realizada con exito");
                    this.view.panelOperacion.setVisible(false);
                    this.view.panelCuenta.setVisible(true);
                }else{
                    Vista.notificar("Esta cuenta está inactiva\nActivela e intentelo de nuevo");
                }
            }else{
              if(Float.parseFloat(this.view.txOperacion.getText())%10000==0){
                float inter;
                if(cuentaActual.getClass()==Ahorros.class){inter=0.02f;}else{inter=0.017f;}
                if(cuentaActual.isActiva()){
                    if(cuentaActual.retirar(Float.parseFloat(this.view.txOperacion.getText()), iCuentaActual, inter)){
                        Vista.notificar("Retiro exitoso");
                        this.view.labSaldo.setText(String.valueOf(cuentaActual.getBalance()));
                        this.view.panelOperacion.setVisible(false);
                        this.view.panelCuenta.setVisible(true);
                    }else{
                        Vista.notificar("No tiene permitido retirar tanto dinero");
                    }
                }else{
                    if(cuentaActual.retirar(Float.parseFloat(this.view.txOperacion.getText()), iCuentaActual, inter)){
                        Vista.notificar("Retiro exitoso");
                        this.view.labSaldo.setText(String.valueOf(cuentaActual.getBalance()));
                        this.view.panelOperacion.setVisible(false);
                        this.view.panelCuenta.setVisible(true);
                    }else{
                        int permitido = (int) (cuentaActual.getBalance()/10000);
                        permitido = permitido*10000;
                        
                        if(cuentaActual.getClass()==Ahorros.class){
                            if((float)permitido+(float)((float)permitido*0.02f)>cuentaActual.getBalance())permitido-=10000;
                            Vista.notificar("En esta cuenta solo tienes permitido\nun retiro de: "+permitido);
                        }else{
                            if((float)permitido+(float)((float)permitido*0.017f)>cuentaActual.getBalance())permitido-=10000;
                            Vista.notificar("En esta cuenta solo tienes permitido\nun retiro de: "+permitido);
                        }
                    }
                }
              }else{
                  Vista.notificar("Debe ser un valor multiplo de 10.000");
              }
            }
        }
        
        if(ae.getSource()== view.bRegistrar){
            this.view.panelInicial.setVisible(false);
            this.view.panelRegistro.setVisible(true);
        }
        
        if(ae.getSource()== view.bRegistrar1){
            
            if(ClienteDB.cliente(this.view.txID.getText())==null){
                clienteActual.setId(this.view.txID.getText());
                clienteActual.setNombre(this.view.txNombre.getText());
                clienteActual.setTelefono(this.view.txTelefono.getText());
                clienteActual.setOcupacion(this.view.txOcupacion.getText());
                clienteActual.setDireccion(this.view.txDireccion.getText());
                this.view.panelRegistro.setVisible(false);
                this.view.panelRegistro1.setVisible(true);
            }else{
                Vista.notificar("Tu id ya está registrado");
            }
            
        }
        
        if(ae.getSource()== view.bRetirar){
            this.view.panelCuenta.setVisible(false);
            this.view.panelOperacion.setVisible(true);
            this.view.bOperacion.setText("Retirar");
        }
    }
    
    
    public void iniciar(){
        this.view.setLocationRelativeTo(null);
        this.view.panelCliente.setVisible(false);
        this.view.panelCreaCuenta.setVisible(false);
        this.view.panelCuenta.setVisible(false);
        this.view.panelIngreso.setVisible(false);
        this.view.panelRegistro.setVisible(false);
        this.view.panelRegistro1.setVisible(false);
        this.view.panelIngresoCuenta.setVisible(false);
        this.view.panelOperacion.setVisible(false);
        this.view.panelInicial.setVisible(true);
        
        this.view.setVisible(true);
    }

    public void listeners(){
        this.view.bAceptarR.addActionListener(this);
        this.view.bActivarC.addActionListener(this);
        this.view.bAhorros.addActionListener(this);
        this.view.bSalir.addActionListener(this);
        this.view.bCancelarC2.addActionListener(this);
        this.view.bCancelarI.addActionListener(this);
        this.view.bCancelarIC.addActionListener(this);
        this.view.bCancelarO.addActionListener(this);
        this.view.bCancelarR.addActionListener(this);
        this.view.bConsignar.addActionListener(this);
        this.view.bCorriente.addActionListener(this);
        this.view.bCrearC.addActionListener(this);
        this.view.bCualesC.addActionListener(this);
        this.view.bDesactivarC.addActionListener(this);
        this.view.bElegirC.addActionListener(this);
        this.view.bIngresar.addActionListener(this);
        this.view.bIngresarI.addActionListener(this);
        this.view.bIngresarC2.addActionListener(this);
        this.view.bOperacion.addActionListener(this);
        this.view.bRegistrar.addActionListener(this);
        this.view.bRegistrar1.addActionListener(this);
        this.view.bRetirar.addActionListener(this);
        this.view.bSalirC.addActionListener(this);
    }
    
}
