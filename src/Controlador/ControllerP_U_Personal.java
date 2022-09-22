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
 *
 * @author Ander
 */
public class ControllerP_U_Personal {
    
    ModelP_U_Personal useControllerP=new ModelP_U_Personal();
    
    /**+
     * Metodo para obtener los registros en la tabla de tipo documento
     * @return 
     */
    public ResultSet cargarTipoDocumentoController(){
        return useControllerP.cargarTipD();
    }
    
    /**
     * Metodo para obtener los registros en la tabla de géneros
     * @return 
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
     * Metodo para obtener el IDPersonal
     * @return 
     */
    public int getIdpersonal() {
        return idpersonal;
    }

    /**
     * Metodo para establecer el IDPersonal
     * @param idpersonal 
     */
    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    /**
     * Metodo para obtener los nombres del personal
     * @return 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo para establecer los nombres del personal
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para obtener los apellidos del personal
     * @return 
     */
    public String getApellido() {
        return apellido;
    }

    /**
     * Metodo para establecer los apellidos del personal
     * @param apellido 
     */
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    
    /**
     * Metodo para obtener el IDEmpresa
     * @return 
     */
    public int getEmpresa() {
        return empresa;
    }

    /**
     * Metodo para establecer el IDEmpresa
     * @param empresa 
     */
    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    
    /**
     * Metodo para obtener la fecha de nacimiento del personal
     * @return 
     */
    public String getFechanac() {
        return fechanac;
    }

    /**
     * Metodo para establecer la fecha de nacimiento del personal
     * @param fechanac 
     */
    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    /**
     * Metodo para obtener el correo del personal
     * @return 
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Metodo para establecer el correo del personal
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Metodo para obtener la dirección del personal
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo para establecer la dirección del personal
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo para obtener el documento del personal (dui/nit)
     * @return 
     */
    public String getDui() {
        return dui;
    }

    /**
     * Metodo para establecer el documento del personal (dui/nit)
     * @param dui 
     */
    public void setDui(String dui) {
        this.dui = dui;
    }

    /**
     * Metodo para obtener el idTipoDocumento (categoriza al campo del documento)
     * @return 
     */
    public int getIdtipoDocumento() {
        return idtipoDocumento;
    }

    /**
     * Metodo para establecer el idTipoDocumento (categoriza al campo del documento)
     * @param idtipopersonal 
     */
    public void setIdtipoDocunmento(int idtipopersonal) {
        this.idtipoDocumento = idtipopersonal;
    }

    /**
     * Metodo para obtener el genero del personal (ID)
     * @return 
     */
    public int getIdgenero() {
        return idgenero;
    }

    /**
     * Metodo para establecer el genero del personal (ID)
     * @param idgenero 
     */
    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    /**
     * Metodo para obtener la imagen del usuario
     * @return 
     */
    public byte[] getLogo() {
        return foto;
    }
    
    /**
     * Metodo para establecer la imagen del usuario
     * @param foto 
     */
    public void setLogo(byte[] foto) {
        this.foto = foto;
    }
    
    /**
     * Metodo para comprobar si existe un registro en la tabla tbPersonal
     * @return 
     */
    public Boolean checkcontrollerPersonal(){
    return useControllerP.checkPersonal();
    }

    /**
     * Metodo para obtener el Carnet del personal
     * @return 
     */
    public String getCarnet() {
        return Carnet;
    }

    /**
     * Metodo para establecer el carnet del personal
     * @param Carnet 
     */
    public void setCarnet(String Carnet) {
        this.Carnet = Carnet;
    }
    
    /**
     * Metodo para hacer una inserción en la tabla tbPersonal
     * @return 
     */
    public boolean IngresarPPersonalController(){
        return useControllerP.IngresarPPersonal(empresa,nombre, apellido, fechanac, correo, direccion, dui, idgenero, idtipoDocumento);
    }
    
    /**
     * Metodo para obtener el IDEmpresa (en caso de que el programa se cierre a la mitad del primer uso)
     * @return 
     */
    public ResultSet ObteneridEmpresa(){
        return useControllerP.getEnterprise();
    }
    
    /**
     * Metodo para asignar un carnet a un registro en la tabla tbPersonal
     * @return 
     */
    public boolean IngresarCarnet(){
        return useControllerP.CarnetPersonal(idpersonal, Carnet);
    }
    
    /**
     * Metodo para recuperar el tipo de documento por medio de su ID
     * @return 
     */
    public ResultSet TipoDocumento(){
        return useControllerP.TipoDocumento(idtipoDocumento);
    }
}