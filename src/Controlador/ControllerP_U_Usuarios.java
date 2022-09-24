/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelP_U_Usuarios;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelP_U_Usuarios with the view, and makes possible the communication between both
 * @author danlo
 */
public class ControllerP_U_Usuarios {
    ModelP_U_Usuarios objController=new ModelP_U_Usuarios();

    /**
     * Check the existence of users
     * @return a Boolean
     */
    public Boolean checkControllerUsuario(){
        return  objController.checkUsuario();
    }

    /**
     *  String variable 
     */
    public String Usuario;

    /**
     *  Integer variable
     */
    public int idPersonal;

    /**
     *  String variable
     */
    public String PIN;

    /**
     *  String variable
     */
    public String Clave;

    /**
     *  Integer variable
     */
    public int idusuario;

    /**
     *  Byte[] variable
     */
    public byte[] foto;

    /**
     *  Gets the user PIN
     * @return a String
     */
    public String getPIN() {
        return PIN;
    }

    /**
     *  Set the user PIN
     * @param PIN referring to the combination of numbers that the system provide to the user
     */
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    /**
     *  Gets the ID of the user
     * @return an Integer
     */
    public int getIdusuario() {
        return idusuario;
    }

    /**
     *  Set user ID
     * @param idusuario referring to the user ID
     */
    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    /**
     *  Gets the staff ID
     * @return an Integer
     */
    public int getIdPersonal() {
        return idPersonal;
    }

    /**
     *  Set the staff ID
     * @param idPersonal referring to the staff ID
     */
    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    /**
     *  Gets the user 
     * @return a String
     */
    public String getUsuario() {
        return Usuario;
    }

    /**
     *  Set the username of the user
     * @param Usuario referring to the username
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    /**
     *  Gets the user password
     * @return a String
     */
    public String getClave() {
        return Clave;
    }

    /**
     *  Set the password of the user
     * @param Clave referring to the user password
     */
    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    /**
     *  Gets the user image
     * @return a Byte[]
     */
    public byte[] getFoto() {
        return foto;
    }

    /**
     *  Set the user image
     * @param foto referring to the user image
     */
    public void setFoto(byte[] foto) {
        this.foto = foto;
    }
    
    /**
     *  Save the user in the database
     * @return a Boolean
     */
    public boolean IngresarPUsuarioController(){
        return objController.IngresarPUsuario(Usuario, foto, Clave,PIN,idPersonal);
    }

    /**
     *  Obtains the staff ID 
     * @return a ResultSet
     */
    public ResultSet ObtenerIdPersonal(){
        return objController.GetIdPersonal();
    }

    /**
     *  Validate the password change
     * @return a Boolean
     */
    public boolean CambiandoClave(){
        return objController.CambiarClave(Usuario, Clave);
    }
    
}
