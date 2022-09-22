/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelQR;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class ControllerQR {
    ModelQR modelQR=new ModelQR();
    private String usuario;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public ResultSet RecuperarContraQR(){
        return modelQR.ReucContraQR(getUsuario());
    }
    
}
