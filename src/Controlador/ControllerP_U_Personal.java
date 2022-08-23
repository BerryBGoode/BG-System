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
 * @author danlo
 */
public class ControllerP_U_Personal {
    ModelP_U_Personal useControllerP=new ModelP_U_Personal();
    public ResultSet cargarTipoDocumentoController(){
        return useControllerP.cargarTipD();
    }
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

    public int getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public int getEmpresa() {
        return empresa;
    }

    public void setEmpresa(int empresa) {
        this.empresa = empresa;
    }
    public String getFechanac() {
        return fechanac;
    }

    public void setFechanac(String fechanac) {
        this.fechanac = fechanac;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }

    public int getIdtipoDocumento() {
        return idtipoDocumento;
    }

    public void setIdtipoDocunmento(int idtipopersonal) {
        this.idtipoDocumento = idtipopersonal;
    }

    public int getIdgenero() {
        return idgenero;
    }

    public void setIdgenero(int idgenero) {
        this.idgenero = idgenero;
    }

    public byte[] getLogo() {
        return foto;
    }

    public void setLogo(byte[] foto) {
        this.foto = foto;
    }
    public Boolean checkcontrollerPersonal(){
    return useControllerP.checkPersonal();
    }
    public boolean IngresarPPersonalController(){
        return useControllerP.IngresarPPersonal(empresa,nombre, apellido, fechanac, correo, direccion, dui, idgenero, idtipoDocumento);
    }
    public ResultSet ObteneridEmpresa(){
        return useControllerP.getEnterprise();
    }
}