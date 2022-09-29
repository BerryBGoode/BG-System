/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelLogin;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelLogin with the view, and makes possible the communication between both
 * @author danlo
 */
public class ControllerLogin {
    
    /**
     * Variables that will be used in the methods of the class
     */
    public static String usuario;
    private String contraseña;
    private int idusuario;
    private int idestado;
    private int intentos;

    /**
     *  Gets the username
     * @return a String
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Gets the password of the user
     * @return a String
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Set the username to be compared with the information of the database
     * @param usuario referring to the username 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     *  Set the password of the user
     * @param contraseña referring to the password of the user
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public int getIdestado() {
        return idestado;
    }

    public void setIdestado(int idestado) {
        this.idestado = idestado;
    }

    /**
     *  Gets the number of attempts 
     * @return an Integer
     */
    public int getIntentos() {
        return intentos;
    }

    /**
     *  Set the number of attempts
     * @param intentos referring to the number of attempts 
     */
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
    
    /**
     *  Validate that the user exist in the database
     * @return an integer
     */
    public int validarUsuarioController(){
        return ModelLogin.ValidarUsuario(usuario);
    }
    
    /**
     *  Validates that the username and password exist in the database
     * @return an Integer
     */
    public int validarLoginC(){
        return ModelLogin.ValidarLogin(usuario, contraseña);
     }   
 
    /**
     *  Validates that the user state is Active
     * @return an integer
     */
    public int ValidarUsuarioActivoController(){
        return ModelLogin.ValidarUsuarioActivo(usuario);
    }
    
    /**
     *  Change the user state to blocked
     * @return a Boolean
     */
    public boolean BloquearUsuarioController(){
        return ModelLogin.BloquearUsuario(usuario);
    }

    /**
     *  Update the attempts of the user to login
     * @return a Boolean
     */
    public boolean IntentosController(){
        return ModelLogin.Intentos(intentos, usuario);
    }
    
    /**
     *Count the attempts of the user to login
     * @return a ResultSet
     */
    public ResultSet CapturarIntentosController(){
       return ModelLogin.CapturarIntentos(usuario);
    }
    
    /**
     *  Capture all the user information
     * @return a ResultSet
     */
    public ResultSet CapturarDatosController(){
        return ModelLogin.CapturarDatos(usuario);
    }
    
    /**
     *  Capture the user type
     * @return a ResultSet
     */
    public ResultSet CapturarTipoUsController(){
        return ModelLogin.CapturarTipoUs(usuario);
    }
    public ResultSet validaruseractive(){
        return ModelLogin.validaruseractive(usuario);
    }
    public boolean ActualizarEstado(){
        return ModelLogin.ActualizarEstadoUserLogin(idestado, idusuario);
    }

}
