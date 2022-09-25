/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelAjustes;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author Rober
 */
public class ControllerAjustes {
    Connection con = ControllerConexion.getConnectionModel();
    ModelAjustes objmodel = new ModelAjustes();
    
    private String usuario;
    private String PIN;
    private String contra;

    public String getContra() {
        return contra;
    }

    public void setContra(String contra) {
        this.contra = contra;
    }
    
    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public boolean CambiarContra(){
        return objmodel.CambiarContra(contra, usuario, con);
    }
    
    public boolean CambiarPIN(){
        return objmodel.CambiarPIN(PIN, usuario, con);
    }
    
    public ResultSet BuscarContraAntigua(){
        return objmodel.BuscarContraAntigua(usuario, con);
    }
}
