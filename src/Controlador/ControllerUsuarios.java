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
 * @author danlo
 */
public class ControllerUsuarios {
    
    Connection con = ControllerConexion.getConnectionModel();
    ModelUsuarios mdlusu = new ModelUsuarios();
    
    public ResultSet CargarTipoUsuarios_C(){
        return mdlusu.CargarTipoUsuarios(con);
    }
    
    public ResultSet CargarEstadoUsuarios_C(){
        return mdlusu.CargarEstadoUsuarios(con);
    }  
    
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

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDPersonal() {
        return IDPersonal;
    }

    public void setIDPersonal(int IDPersonal) {
        this.IDPersonal = IDPersonal;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getPIN() {
        return PIN;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public int getIDTipoUsu() {
        return IDTipoUsu;
    }

    public void setIDTipoUsu(int IDTipoUsu) {
        this.IDTipoUsu = IDTipoUsu;
    }

    public int getIDEstadoUsu() {
        return IDEstadoUsu;
    }

    public void setIDEstadoUsu(int IDEstadoUsu) {
        this.IDEstadoUsu = IDEstadoUsu;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }
     
    //Constructores

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

    public ControllerUsuarios(int ID, int IDPersonal, String nombre_usuario, int IDTipoUsu, int IDEstadoUsu, byte[] imagen) {
        this.ID = ID;
        this.IDPersonal = IDPersonal;
        this.nombre_usuario = nombre_usuario;
        this.IDTipoUsu = IDTipoUsu;
        this.IDEstadoUsu = IDEstadoUsu;
        this.imagen = imagen;
    }

    public ControllerUsuarios(int ID) {
        this.ID = ID;
    }

    public ControllerUsuarios() {
    }
    
    
    //Incersion de datos
     public boolean NuevoUsuario_C(){
         return mdlusu.AgregarUsuario(IDPersonal, nombre_usuario, contraseña, PIN, IDTipoUsu, IDEstadoUsu, imagen, intentos, con);
    }
     
     //Cargar datos
    public ResultSet CargarUsuarios_C(){
        return mdlusu.CargarUsuarios(con);
    }
    
    //Actualizar datos
    public boolean ActualizarUsuario_C(){
        return mdlusu.ActualizarUsuario(IDPersonal, nombre_usuario, IDTipoUsu, IDEstadoUsu, imagen, ID, con);
    }
    
    //Eliminar datos
    public boolean EliminarUsuario_C(){
         return mdlusu.EliminarUsuario(ID, con);
    }
    
    //Buscar imagen
    public ResultSet BuscarImagen_C(){
        return mdlusu.BuscarImagen(ID, con);
    }
}
