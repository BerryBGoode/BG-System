/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelUsuarios;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelUsuarios with the view, and makes possible the communication between both
 * @author Rober
 */
public class ControllerUsuarios {
    
    Connection con = ControllerConexion.getConnectionModel();
    ModelUsuarios mdlusu = new ModelUsuarios();
    
    /**
     * Method to load the registers stored in the tbTipoUsuario table
     * @return a ResultSet
     */
    public ResultSet CargarTipoUsuarios_C(){
        return mdlusu.CargarTipoUsuarios(con);
    }
    
    /**
     * Method to load the registers stored in the tbEstadoUsuario table
     * @return a ResultSet
     */
    public ResultSet CargarEstadoUsuarios_C(){
        return mdlusu.CargarEstadoUsuarios(con);
    }  
    
    /**
     * Method to load the registers stored in the tbPersonal table
     * @return a ResultSet
     */
     public ResultSet CargarPersonal_C(){
        return mdlusu.CargarPersonal(con);
    }
     protected int ID;
     private int IDPersonal;
     private String nombre_usuario;
     private String contraseña;
     private String PIN;
     private int IDTipoUsu;
     private int IDEstadoUsu;
     private byte[] imagen;
     private int intentos;
     
     //Getter y setter

     /**
      * Method to obtain the IDUuser
      * @return an Integer
      */
    public int getID() {
        return ID;
    }

    /**
     * Method to set the userID
     * @param ID referring to the user ID
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Method to obtain the Staff ID
     * @return an Integer
     */
    public int getIDPersonal() {
        return IDPersonal;
    }

    /**
     * Method to set the userID
     * @param IDPersonal referring to the staff ID
     */
    public void setIDPersonal(int IDPersonal) {
        this.IDPersonal = IDPersonal;
    }

    /**
     * Method to get username
     * @return a String
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    
    /**
     * Method to set username
     * @param nombre_usuario referring to the username 
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * Method to get the password
     * @return a String
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Method to set the password
     * @param contraseña referring to the password
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Method to obtain the user's PIN
     * @return a String
     */
    public String getPIN() {
        return PIN;
    }

    /**
     * Method to set the PIN
     * @param PIN referring to the user's PIN
     */
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    /**
     * Method to obtain the type of user
     * @return an Integer
     */
    public int getIDTipoUsu() {
        return IDTipoUsu;
    }

    /**
     * Method to set user type
     * @param IDTipoUsu referring to the user type ID
     */
    public void setIDTipoUsu(int IDTipoUsu) {
        this.IDTipoUsu = IDTipoUsu;
    }

    /**
     * Method to get user status
     * @return an Integer
     */
    public int getIDEstadoUsu() {
        return IDEstadoUsu;
    }

    /**
     * Method to set user status
     * @param IDEstadoUsu referring to the user's status ID
     */
    public void setIDEstadoUsu(int IDEstadoUsu) {
        this.IDEstadoUsu = IDEstadoUsu;
    }

    /**
     * Method to get the user image
     * @return a Byte[]
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Method to set the user image
     * @param imagen referring to the user's image
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * Method to get remaining login attempts
     * @return an Integer
     */
    public int getIntentos() {
        return intentos;
    }

    /**
     * Method to set remaining login attempts
     * @param intentos referring to the attempts
     */
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
     
    //Constructores

    /**
     * Constructor for data insertion
     * @param IDPersonal referring to the staff ID
     * @param nombre_usuario referring to the username
     * @param contraseña referring to the password
     * @param PIN referring to the user's PIN
     * @param IDTipoUsu referring to the user type
     * @param IDEstadoUsu referring to the user state
     * @param imagen referring to the user's image
     * @param intentos referring to the user's attempts
     */
    public ControllerUsuarios(int IDPersonal, String nombre_usuario, String contraseña, String PIN, int IDTipoUsu, int IDEstadoUsu, byte[] imagen, int intentos) {
        this.IDPersonal = IDPersonal;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
        this.PIN = PIN;
        this.IDTipoUsu = IDTipoUsu;
        this.IDEstadoUsu = IDEstadoUsu;
        this.imagen = imagen;
        this.intentos = intentos;
    }

    /**
     * Constructor for data update
     * @param ID referring to the user iD
     * @param IDPersonal referring to the staff ID
     * @param nombre_usuario referring to the username
     * @param IDTipoUsu referring to the user type ID
     * @param IDEstadoUsu referring to the user state ID
     * @param imagen referring to the user's image
     */
    public ControllerUsuarios(int ID, int IDPersonal, String nombre_usuario, int IDTipoUsu, int IDEstadoUsu, byte[] imagen) {
        this.ID = ID;
        this.IDPersonal = IDPersonal;
        this.nombre_usuario = nombre_usuario;
        this.IDTipoUsu = IDTipoUsu;
        this.IDEstadoUsu = IDEstadoUsu;
        this.imagen = imagen;
    }

    /**
     * Constructor for data removal
     * @param ID referring to the user ID
     */
    public ControllerUsuarios(int ID) {
        this.ID = ID;
    }

    /**
     * empty constructor
     */
    public ControllerUsuarios() {
    }
    
    
    /**
     * Method for inserting data
     * @return a Boolean
     */
     public boolean NuevoUsuario_C(){
         return mdlusu.AgregarUsuario(IDPersonal, nombre_usuario, contraseña, PIN, IDTipoUsu, IDEstadoUsu, imagen, intentos, con);
    }
     
    /**
     * Method to load the registers in the tbUsuarios table
     * @return a ResultSet
     */
    public ResultSet CargarUsuarios_C(){
        return mdlusu.CargarUsuarios(nombre_usuario, con);
    }
    
    /**
     * Method for updating data
     * @return a Boolean
     */
    public boolean ActualizarUsuario_C(){
        return mdlusu.ActualizarUsuario(IDPersonal, nombre_usuario, IDTipoUsu, IDEstadoUsu, imagen, ID, con);
    }
    
    /**
     * Method for deleting a user
     * @return a Boolean
     */
    public boolean EliminarUsuario_C(){
         return mdlusu.EliminarUsuario(ID, con);
    }
    
    /**
     * Method to load the bytes of the image of the selected user
     * @return a ResultSet
     */
    public ResultSet BuscarImagen_C(){
        return mdlusu.BuscarImagen(ID, con);
    }
    
    /**
     * Method to load the id - card of the selected user
     * @return a ResultSet
     */
    public ResultSet BuscarCarnet_C(){
        return mdlusu.BuscaCarnet(IDPersonal, con);
    }
    
    /**
     * Method to find the register that contains the Active ID in the tbEstadoUsuario table
     * @return a ResultSet
     */
    public ResultSet BuscarIDActivo_C(){
        return mdlusu.BuscarIDActivo(con);
    }
    
    /**
     * Method to find the register that contains the StudentID in the tbTipoUsuario table
     * @return a ResultSet
     */
    public ResultSet BuscarIDEstudiante_C(){
        return mdlusu.BuscarIDEstudiante(con);
    }
}
