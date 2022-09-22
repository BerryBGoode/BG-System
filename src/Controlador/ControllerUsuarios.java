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
 *
 * @author Rober
 */
public class ControllerUsuarios {
    
    Connection con = ControllerConexion.getConnectionModel();
    ModelUsuarios mdlusu = new ModelUsuarios();
    
    /**
     * Metodo para cargar los registros almacenados en la tabla de tbTipoUsuario
     * @return 
     */
    public ResultSet CargarTipoUsuarios_C(){
        return mdlusu.CargarTipoUsuarios(con);
    }
    
    /**
     * Metodo para cargar los registros almacenados en la tabla de tbEstadoUsuario
     * @return 
     */
    public ResultSet CargarEstadoUsuarios_C(){
        return mdlusu.CargarEstadoUsuarios(con);
    }  
    
    /**
     * Metodo para cargar los registros almacenados en la tabla de tbPersonal
     * @return 
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
      * Metodo para obtener el IDUsuario
      * @return 
      */
    public int getID() {
        return ID;
    }

    /**
     * Metodo para establecer el IDUsuario
     * @param ID 
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     * Metodo para obtener el IDPersonal
     * @return 
     */
    public int getIDPersonal() {
        return IDPersonal;
    }

    /**
     * Metodo para establecer el IDUsuario
     * @param IDPersonal 
     */
    public void setIDPersonal(int IDPersonal) {
        this.IDPersonal = IDPersonal;
    }

    /**
     * Metodo para obtener el nombre de usuario
     * @return 
     */
    public String getNombre_usuario() {
        return nombre_usuario;
    }
    
    /**
     * Metodo para establecer el nombre de usuario
     * @param nombre_usuario 
     */
    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    /**
     * Metodo para obtener la contraseña
     * @return 
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * Metodo para establecer la contraseña
     * @param contraseña 
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * Metodo para obtener el PIN del usuario
     * @return 
     */
    public String getPIN() {
        return PIN;
    }

    /**
     * Metodo para establecer el PIN
     * @param PIN 
     */
    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    /**
     * Metodo para obtener el tipo de usuario
     * @return 
     */
    public int getIDTipoUsu() {
        return IDTipoUsu;
    }

    /**
     * Metodo para establecer el tipo de usuario
     * @param IDTipoUsu 
     */
    public void setIDTipoUsu(int IDTipoUsu) {
        this.IDTipoUsu = IDTipoUsu;
    }

    /**
     * Metodo para obtener el estado del usuario
     * @return 
     */
    public int getIDEstadoUsu() {
        return IDEstadoUsu;
    }

    /**
     * Metodo para establecer el estado del usuario
     * @param IDEstadoUsu 
     */
    public void setIDEstadoUsu(int IDEstadoUsu) {
        this.IDEstadoUsu = IDEstadoUsu;
    }

    /**
     * Metodo para obtener la imagen del usuario
     * @return 
     */
    public byte[] getImagen() {
        return imagen;
    }

    /**
     * Metodo para establecer la imagen del usuario
     * @param imagen 
     */
    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    /**
     * Metodo para obtener los intentos de inicio de sesión restantes
     * @return 
     */
    public int getIntentos() {
        return intentos;
    }

    /**
     * Metodo para establecer los intentos de inicio de sesión restantes
     * @param intentos 
     */
    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
     
    //Constructores

    /**
     * Constructor para la inserción de datos
     * @param IDPersonal
     * @param nombre_usuario
     * @param contraseña
     * @param PIN
     * @param IDTipoUsu
     * @param IDEstadoUsu
     * @param imagen
     * @param intentos 
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
     * Constructor para la actualización de datos
     * @param ID
     * @param IDPersonal
     * @param nombre_usuario
     * @param IDTipoUsu
     * @param IDEstadoUsu
     * @param imagen 
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
     * Constructor para la eliminación de datos
     * @param ID 
     */
    public ControllerUsuarios(int ID) {
        this.ID = ID;
    }

    /**
     * Constructor vacio
     */
    public ControllerUsuarios() {
    }
    
    
    /**
     * Metodo para la inserción de datos
     * @return 
     */
     public boolean NuevoUsuario_C(){
         return mdlusu.AgregarUsuario(IDPersonal, nombre_usuario, contraseña, PIN, IDTipoUsu, IDEstadoUsu, imagen, intentos, con);
    }
     
    /**
     * Metodo para cargar los registros en la tabla tbUsuarios
     * @return 
     */
    public ResultSet CargarUsuarios_C(){
        return mdlusu.CargarUsuarios(con);
    }
    
    /**
     * Metodo para la actualización de datos
     * @return 
     */
    public boolean ActualizarUsuario_C(){
        return mdlusu.ActualizarUsuario(IDPersonal, nombre_usuario, IDTipoUsu, IDEstadoUsu, imagen, ID, con);
    }
    
    /**
     * Metodo para la eliminación de un usuario
     * @return 
     */
    public boolean EliminarUsuario_C(){
         return mdlusu.EliminarUsuario(ID, con);
    }
    
    /**
     * Metodo para cargar los bytes de la imagen del usuario seleccionado
     * @return 
     */
    public ResultSet BuscarImagen_C(){
        return mdlusu.BuscarImagen(ID, con);
    }
    
    /**
     * Metodo para cargar el carnet del usuario seleccionado
     * @return 
     */
    public ResultSet BuscarCarnet_C(){
        return mdlusu.BuscaCarnet(IDPersonal, con);
    }
    
    /**
     * Metodo para buscar el registro que contenga el IDActivo en la tabla de tbEstadoUsuario
     * @return 
     */
    public ResultSet BuscarIDActivo_C(){
        return mdlusu.BuscarIDActivo(con);
    }
    
    /**
     * Metodo para buscar el registro que contenga el IDEstudiante en la tabla de tbTipoUsuario
     * @return 
     */
    public ResultSet BuscarIDEstudiante_C(){
        return mdlusu.BuscarIDEstudiante(con);
    }
}
