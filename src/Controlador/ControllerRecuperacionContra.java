/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelRecuperacionContra;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author danlo
 */
public class ControllerRecuperacionContra {
    
    private String usuario;
    private String contra;
    private String PIN;
    private String documento;
    private int idTipoDoc;
    Connection con = ControllerConexion.getConnectionModel();
    
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }
        
    
    
    public int RecuperarContraPINController (){
        return ModelRecuperacionContra.RecuperarContraPIN_ValidarDatos(usuario, PIN);
    }
    
        
    public boolean RecuperarContraController (){
        return ModelRecuperacionContra.RecuperarContra(usuario, contra);
    }
    
    public ResultSet CargarTipoDocumentoController(){
        return ModelRecuperacionContra.CargarTipoDocumento(con);
    }
    
    public int ValidarDocumentoController(){
        return ModelRecuperacionContra.ValidarDocumento(usuario, documento, idTipoDoc, con);
    }
}
