/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelQR;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelQR with the view, and makes possible the communication between both
 * @author hp
 */
public class ControllerQR {
    ModelQR modelQR=new ModelQR();
    private String usuario;
    private String clave;

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     *  Gets the Username
     * @return a String
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     *  Set the username
     * @param usuario referring to the username
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    /**
     *  Validates the password recovery
     * @return a ResultSet
     */
    public ResultSet RecuperarContraQR(){
        return modelQR.ReucContraQR(getUsuario());
    }
    public boolean ActualizarcontraQR(){
        return modelQR.Actualizar(clave, usuario);
    }
    
}
