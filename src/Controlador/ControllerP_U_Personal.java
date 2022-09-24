/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelP_U_Personal;
import java.sql.Date;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelP_U_Personal with the view, and makes possible the communication between both
 * @author Ander
 */
public class ControllerP_U_Personal {
    
    ModelP_U_Personal useControllerP=new ModelP_U_Personal();
    
    /**
     * Method to obtain the records in the document type table
     * @return a ResultSet
     */
    public ResultSet cargarTipoDocumentoController(){
        return useControllerP.cargarTipD();
    }
    
    /**
     * Method to obtain registers in the gender table
     * @return a ResultSet
     */
    public ResultSet cargarGeneroController(){
        return useControllerP.cargarGeneroP();
    }
    
    public int idpersonal;
    public String nombre;
    public String apellido;
    public String fechanac;
    public String correo;
    public String direccion;
    public int empresa;
    public String dui;
    public int idtipoDocumento;
    public int idgenero;
    public byte[] foto;
    public String Carnet;

    /**
     * Method to obtain the Personal ID
     * @return an Integer
     */
    public int getIdpersonal() {
        return idpersonal;
    }

    /**
     * Method to set the Personal ID
     * @param idpersonal referring to the Personal ID
     */
    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    /**
     * Method to get staff names
     * @return a String
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Method to set staff names
     * @param nombre referring to the staff names
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Method to obtain the last names of the staff
     * @return a String
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Method to set staff last names
     * @param apellido referring to the staff last names
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * Method to obtain the company ID
     * @return an Integer
     */
    public int getEmpresa() {
        return empresa;
    }

    /**
     * Method to establish the company ID
     * @param empresa referring to the company ID
     */
    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    
    /**
     * Method to obtain the date of birth of the staff
     * @return a String
     */
    public String getFechanac() {
        return fechanac;
    }

    /**
     * Method for establishing the birth date of the staff
     * @param fechanac referring to the birth date
     */
    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    /**
     * Method to obtain staff mail
     * @return a String
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Method to establish staff mail
     * @param correo referring to the mail of the user
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Method to obtain the address of the staff
     * @return a String
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Method for setting staff address
     * @param direccion referring to the address of the user
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Method to obtain the staff document (dui/nit)
     * @return a String
     */
    public String getDui() {
        return dui;
    }

    /**
     * Method to establish the staff document (dui/nit)
     * @param dui referring to the document type
     */
    public void setDui(String dui) {
        this.dui = dui;
    }

    /**
     * Method to obtain the idTipoDocumento (categorizes the document field)
     * @return an Integer
     */
    public int getIdtipoDocumento() {
        return idtipoDocumento;
    }

    /**
     * Method to establish the idTipoDocumento (categorizes the document field)
     * @param idtipopersonal referring to the staff type of the user
     */
    public void setIdtipoDocunmento(int idtipopersonal) {
        this.idtipoDocumento = idtipopersonal;
    }

    /**
     * Method to obtain the staff gender (ID)
     * @return an Integer
     */
    public int getIdgenero() {
        return idgenero;
    }

    /**
     * Method to establish the staff gender (ID)
     * @param idgenero referring to the gender of the user
     */
    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    /**
     * Method to get the user image
     * @return a Byte[]
     */
    public byte[] getLogo() {
        return foto;
    }
    
    /**
     * Method to set the user image
     * @param foto referring to the image of the user
     */
    public void setLogo(byte[] foto) {
        this.foto = foto;
    }
    
    /**
     * Method to check if a register exists in the tbPersonal table
     * @return a Boolean
     */
    public Boolean checkcontrollerPersonal(){
    return useControllerP.checkPersonal();
    }

    /**
     * Method to obtain the staff id - card
     * @return a String
     */
    public String getCarnet() {
        return Carnet;
    }

    /**
     * Method to establish the staff id - card
     * @param Carnet referring to the id - card
     */
    public void setCarnet(String Carnet) {
        this.Carnet = Carnet;
    }
    
    /**
     * Method to make an insert in the tbPersonal table
     * @return a Boolean
     */
    public boolean IngresarPPersonalController(){
        return useControllerP.IngresarPPersonal(empresa,nombre, apellido, fechanac, correo, direccion, dui, idgenero, idtipoDocumento);
    }
    
    /**
     * Method to obtain the companyID (in case the program is closed in the middle of the first use)
     * @return a ResultSet
     */
    public ResultSet ObteneridEmpresa(){
        return useControllerP.getEnterprise();
    }
    
    /**
     * Method to assign a id - card to a register in the tbPersonal table
     * @return a Boolean
     */
    public boolean IngresarCarnet(){
        return useControllerP.CarnetPersonal(idpersonal, Carnet);
    }
    
    /**
     * Method to retrieve the document type by means of its ID
     * @return a ResultSet
     */
    public ResultSet TipoDocumento(){
        return useControllerP.TipoDocumento(idtipoDocumento);
    }
}