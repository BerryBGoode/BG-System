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
 *  This class stores and connects the ModelRecuperacionContra with the view, and makes possible the communication between both
 * @author danlo
 */
public class ControllerRecuperacionContra {
    
    private String usuario;
    private String contra;
    private String PIN;
    private String documento;
    private int idTipoDoc;
    Connection con = ControllerConexion.getConnectionModel();
    
    /**
     *  Gets the username 
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
     *  Gets the user's PIN
     * @return a String
     */
    public String getPIN() {
        return PIN;
    }

    /**
     *  Set the user's PIN
     * @param PIN referring to the user's PIN
     */
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    /**
     *  Gets user's password
     * @return a String
     */
    public String getContra() {
        return contra;
    }

    /**
     *  Set the user's password
     * @param contra referring to user's password
     */
    public void setContra(String contra) {
        this.contra = contra;
    }

    /**
     *  Gets the user's document
     * @return a String
     */
    public String getDocumento() {
        return documento;
    }

    /**
     *  Set the user's document
     * @param documento referring to the user's document
     */
    public void setDocumento(String documento) {
        this.documento = documento;
    }

    /**
     *  Gets the document type ID
     * @return an Integer
     */
    public int getIdTipoDoc() {
        return idTipoDoc;
    }

    /**
     *  Set the document type ID
     * @param idTipoDoc referring to the document type ID
     */
    public void setIdTipoDoc(int idTipoDoc) {
        this.idTipoDoc = idTipoDoc;
    }
        
    /**
     *  Validates user and password to complete the process of password recovery
     * @return an Integer
     */
    public int RecuperarContraPINController (){
        return ModelRecuperacionContra.RecuperarContraPIN_ValidarDatos(usuario, PIN);
    }
    
    /**
     *  Check the password recovery
     * @return a Boolean
     */
    public boolean RecuperarContraController (){
        return ModelRecuperacionContra.RecuperarContra(usuario, contra);
    }
    
    /**
     *  Load the Document types
     * @return  a ResultSet
     */
    public ResultSet CargarTipoDocumentoController(){
        return ModelRecuperacionContra.CargarTipoDocumento(con);
    }
    
    /**
     *  Validates the document
     * @return an Integer
     */
    public int ValidarDocumentoController(){
        return ModelRecuperacionContra.ValidarDocumento(usuario, documento, idTipoDoc, con);
    }
    
     public ResultSet TipoDocumento(){
       return ModelRecuperacionContra.TipoDocumento(idTipoDoc);
   }
}
