/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelCorreo;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelCorreo with the view, and makes possible the communication between both
 * @author danlo
 */
public class ControllerCorreo {
    
    //Variable String que contiene el usuario recibido

    /**
     * String variable 
     */
    public String Usuario;

    //Gettter  correspondientes a la variable Usuario

    /**
     *  Gets the user to send the email
     * @return a String
     */
    public String getUsuario() {
        return Usuario;
    }
    //Setter correspondientes a la variable Usuario

    /**
     *  Set the user to send the email
     * @param Usuario referring to the user that the system will send the email
     */
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    /**
     * String variable 
     */
    public String Correo;

    /**
     *  Get the email from the user
     * @return a String
     */
    public String getCorreo() {
        return Correo;
    }

    /**
     *  Set the email from the user to complete the process
     * @param Correo referring to the email of the user
     */
    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    /**
     *  String variable
     */
    public String Clave;

    /**
     * Get the new password that will be assign to the user
     * @return a String
     */
    public String getClave() {
        return Clave;
    }

    /**
     * Set the new password that will be assign to the user
     * @param Clave referring to the new user password
     */
    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    /**
     * Integer variable
     */
    public int id;

    /**
     *  This id will be used to the methods of this class 
     * @return an Integer
     */
    public int getId() {
        return id;
    }

    /**
     *  Set the id
     * @param id referring to the id that will be used to complete different kind of process
     */
    public void setId(int id) {
        this.id = id;
    }
    
    
    
    //Objeto de la clase ModelCorreo (Nos brinda acceso a los metodos contenidos en dicha clase)
    ModelCorreo mdlCorreo = new ModelCorreo();
    
    //Metodo de retorno del Resultset

    /**
     *  Complete the password recovery process
     * @return a ResultSet
     */
    public ResultSet Recuperar(){
        
        //return: Devuelve algo.
        //mdlCorreo: Objeto de la clase ModelCorreo.
        //.Recuperar: Nombre del metodo que se retorna desde el modelo.
        //(Usuario): Devolvemos la variable que contiene la informacion que se enviara como parametro en el modelo.
        return mdlCorreo.Recuperar(Usuario);
    }
    
    /**
     *  Capture the information to verify that it exists in the database
     * @return a ResultSet
     */
    public ResultSet capturar()
    {
        return mdlCorreo.CapDatos(Correo);
    }
    
    /**
     *  Update the password of the user
     * @return a Boolean
     */
    public boolean Actualizar()
    {
        return ModelCorreo.ActualizarContra(id, Clave);
    }
    
    /**
     *  Capture the mail to verify that it exists in the database
     * @return a ResultSet
     */
    public ResultSet ComprobarCorreo()
    {
        return mdlCorreo.CapCorreo(id);
    }

    /**
     *  Capture the ID of the staff to verify that it exists in the database
     * @return a ResultSet
     */
    public ResultSet CapId()
    {
        return mdlCorreo.CapturarIdPersonal(Correo);
    }

}
