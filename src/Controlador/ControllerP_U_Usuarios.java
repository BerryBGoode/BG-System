/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelP_U_Usuarios;
import java.sql.ResultSet;

/**
 *
 * @author danlo
 */
public class ControllerP_U_Usuarios {
    ModelP_U_Usuarios objController=new ModelP_U_Usuarios();
    public Boolean checkControllerUsuario(){
        return  objController.checkUsuario();
    }
    public String Usuario;
    public int idPersonal;
    public String PIN;
    public String Clave;
    public int idusuario;
    public byte[] foto;

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    
    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    public boolean IngresarPUsuarioController(){
        return objController.IngresarPUsuario(Usuario, foto, Clave,PIN,idPersonal);
    }
    public ResultSet ObtenerIdPersonal(){
        return objController.GetIdPersonal();
    }
    public boolean CambiandoClave(){
        return objController.CambiarClave(Usuario, Clave);
    }
    
}
