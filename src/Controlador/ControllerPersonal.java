/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelPersonal;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelPersonal with the view, and makes possible the communication between both
 * @author danlo
 */
public class ControllerPersonal {
       ModelPersonal objModelP = new ModelPersonal();

    /**
     *  Load the information table with the professors registers
     * @return a ResultSet
     */
    public ResultSet MostrarProfesoresController() {
        return objModelP.MostrarProfesores();
    }

    /**
     *  Load the information table with the students registers
     * @return a ResultSet
     */
    public ResultSet MostrarEstudiantesController() {
        return objModelP.MostrarEstudiantes();
    }

    /**
     *  Load the genders on the Combobox
     * @return a ResultSet
     */
    public ResultSet CargarGenero() {
        return objModelP.CargarGenero();
    }

    /**
     *  Load the Document type on the Combobox
     * @return a ResultSet
     */
    public ResultSet CargarTipoDoController() {
        return objModelP.CargarTipodOC();
    }

    /**
     *  Load the Staff type on the Combobox
     * @return a ResultSet
     */
    public ResultSet CargarTipoPersonalController() {
        return objModelP.CargarTipoP();
    }

    /**
     *  Integer variable
     */
    public  int idpersonal;

    /**
     *  String variable
     */
    public String nombre;

    /**
     *  String variable
     */
    public String apellido;

    /**
     *  String variable
     */
    public String fechanac;

    /**
     *  String variable
     */
    public String correo;

    /**
     *  String variable
     */
    public String direccion;

    /**
     *  String variable
     */
    public String documento;

    /**
     *  Integer variable    
     */
    public int idtipoDoc;

    /**
     *  Integer variable   
     */
    public int idTipoPersonal;

    /**
     *  Integer variable
     */
    public int idgenero;

    /**
     *  Integer variable
     */
    public int idempresa;

    /**
     *  String variable
     */
    public String Carnet;

    /**
     *  Save the registers of professors
     * @return a Boolean
     */
    public boolean IngresarProfesores() {
        return objModelP.IngresarProfesores(nombre, apellido, fechanac, correo, direccion, documento, idtipoDoc,idTipoPersonal, idgenero, idempresa);
    }

    /**
     *  Save the registers of students
     * @return a Boolean
     */
    public boolean IngresarEstudiante() {
        return objModelP.IngresarEstudiantes(nombre, apellido, fechanac, correo, direccion, documento, idtipoDoc, idgenero, idempresa);
    }

    /**
     *  Save registers of id - cards
     * @return a Boolean
     */
    public boolean AgregarCarnetController(){
        return objModelP.AgregarCarnet(idpersonal, Carnet);
    }

    /**
     *  Gets the company's ID
     * @return  a ResultSet
     */
    public ResultSet GetEmpresa() {
        return objModelP.getidEmpresa();
    }

    /**
     *  Capture the staff ID with a search parameter
     * @return a ResultSet
     */
    public ResultSet capturaridpersonalcontroller() {
        return objModelP.capturaridpersonal(nombre);
    }

    /**
     *  Update students registers
     * @return a Boolean
     */
    public boolean ActualizarEstudiantesController(){
        return objModelP.ActualizarAlumno(idpersonal, nombre, apellido, correo, direccion, documento, idtipoDoc, idgenero, idempresa);
    }

    /**
     *  Update staff registers
     * @return  a Boolean
     */
    public boolean ActualizarPersonalControiller(){
        return objModelP.ActualizarPersonal(idpersonal, nombre, apellido, correo, direccion, documento, idtipoDoc, idgenero, idempresa, idTipoPersonal);
    }

    /**
     *  Delete registers
     * @return a Boolean
     */
    public boolean EliminarRegistroController(){
        return objModelP.EliminarRegistro(idpersonal);
    }
}
