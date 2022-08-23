/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelPersonal;
import java.sql.ResultSet;

/**
 *
 * @author danlo
 */
public class ControllerPersonal {
       ModelPersonal objModelP = new ModelPersonal();

    public ResultSet MostrarProfesoresController() {
        return objModelP.MostrarProfesores();
    }

    public ResultSet MostrarEstudiantesController() {
        return objModelP.MostrarEstudiantes();
    }

    public ResultSet CargarGenero() {
        return objModelP.CargarGenero();
    }

    public ResultSet CargarTipoDoController() {
        return objModelP.CargarTipodOC();
    }

    public ResultSet CargarTipoPersonalController() {
        return objModelP.CargarTipoP();
    }
    public  int idpersonal;
    public String nombre;
    public String apellido;
    public String fechanac;
    public String correo;
    public String direccion;
    public String documento;
    public int idtipoDoc;
    public int idTipoPersonal;
    public int idgenero;
    public int idempresa;
    public String Carnet;

    public boolean IngresarProfesores() {
        return objModelP.IngresarProfesores(nombre, apellido, fechanac, correo, direccion, documento, idtipoDoc,idTipoPersonal, idgenero, idempresa);
    }

    public boolean IngresarEstudiante() {
        return objModelP.IngresarEstudiantes(nombre, apellido, fechanac, correo, direccion, documento, idtipoDoc, idgenero, idempresa);
    }
    public boolean AgregarCarnetController(){
        return objModelP.AgregarCarnet(idpersonal, Carnet);
    }
    public ResultSet GetEmpresa() {
        return objModelP.getidEmpresa();
    }

    public ResultSet capturaridpersonalcontroller() {
        return objModelP.capturaridpersonal(nombre);
    }
    public boolean ActualizarEstudiantesController(){
        return objModelP.ActualizarAlumno(idpersonal, nombre, apellido, fechanac, correo, direccion, documento, idtipoDoc, idgenero, idempresa);
    }
    public boolean ActualizarPersonalControiller(){
        return objModelP.ActualizarPersonal(idpersonal, nombre, apellido, fechanac, correo, direccion, documento, idtipoDoc, idgenero, idempresa, idTipoPersonal);
    }
    public boolean EliminarRegistroController(){
        return objModelP.EliminarRegistro(idpersonal);
    }
}
