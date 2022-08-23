/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelRecuperacionContra;

/**
 *
 * @author danlo
 */
public class ControllerRecuperacionContra {
    
    private String usuario;
    private String contra;
    private String PIN;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
       this.usuario = usuario;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
        
    public int RecuperarContraPINController (){
        return ModelRecuperacionContra.RecuperarContraPIN_ValidarDatos(usuario, PIN);
    }
    
        
    public boolean RecuperarContraController (){
        return ModelRecuperacionContra.RecuperarContra(usuario, contra);
    }
}
