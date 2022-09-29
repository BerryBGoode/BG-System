/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelBuscador;
import java.sql.ResultSet;

/**
 * This class stores and connects the ModelBuscador with the view, and makes
 * possible the communication between both
 *
 * @author danlo
 */
public class ControllerBuscador {

    String CarnetVehiculo;
    String N_Usuarios;
    String Doc;
    String Nombre_p;
    String Placa;
    String cont;
    String Park;
    String Acc;

    /**
     * Gets the access parameter
     *
     * @return a String
     */
    public String getAcc() {
        return Acc;
    }

    /**
     * Set the access parameter
     *
     * @param Acc referring to the access parameter
     */
    public void setAcc(String Acc) {
        this.Acc = Acc;
    }

    /**
     * Gets the parking parameter
     *
     * @return a String
     */
    public String getPark() {
        return Park;
    }

    /**
     * Set the parking parameter
     *
     * @param Park referring to the parking parameter
     */
    public void setPark(String Park) {
        this.Park = Park;
    }

    /**
     * Gets the contact parameter
     *
     * @return a String
     */
    public String getCont() {
        return cont;
    }

    /**
     * Set the contact parameter
     *
     * @param cont referring to the contact parameter
     */
    public void setCont(String cont) {
        this.cont = cont;
    }

    /**
     * Gets the placa parameter
     *
     * @return a String
     */
    public String getPlaca() {
        return Placa;
    }

    /**
     * Set the placa
     *
     * @param Placa referring to the placa
     */
    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    /**
     * Gets the name parameter
     *
     * @return a String
     */
    public String getNombre_p() {
        return Nombre_p;
    }

    /**
     * Set the name parameter
     *
     * @param Nombre_p referring to the name parameter
     */
    public void setNombre_p(String Nombre_p) {
        this.Nombre_p = Nombre_p;
    }

    /**
     * Gets the document parameter
     *
     * @return a String
     */
    public String getDoc() {
        return Doc;
    }

    /**
     * Set the document parameter
     *
     * @param Doc referring to the document parameter
     */
    public void setDoc(String Doc) {
        this.Doc = Doc;
    }

    /**
     * Gets the username parameter
     *
     * @return a String
     */
    public String getN_Usuarios() {
        return N_Usuarios;
    }

    /**
     * Set the username parameter
     *
     * @param N_Usuarios referring to the username parameter
     */
    public void setN_Usuarios(String N_Usuarios) {
        this.N_Usuarios = N_Usuarios;
    }

    /**
     * Gets the id- card
     *
     * @return a String
     */
    public String getCarnetVehiculo() {
        return CarnetVehiculo;
    }

    /**
     * Set the id - card to the register
     *
     * @param CarnetVehiculo referring to the id - card
     */
    public void setCarnetVehiculo(String CarnetVehiculo) {
        this.CarnetVehiculo = CarnetVehiculo;
    }

    ModelBuscador mdlS = new ModelBuscador();

    /**
     * ResultSet
     *
     * @param Doc ResultSet parameter
     * @return a ResulSet
     */
    public ResultSet CargarVehiculosCarnetController(String Doc) {
        return mdlS.ResPersonal(Doc);
    }

    /**
     * ResultSet
     *
     * @param nombreU ResultSet parameter
     * @return a ResultSet
     */
    public ResultSet CargarUsuariosController(String nombreU) {
        return mdlS.ResUsuarios(nombreU);
    }

    /**
     * ResultSet
     *
     * @param carnet ResultSet parameter
     * @return a ResultSet
     */
    public ResultSet CargarEstudiantesController(String carnet) {
        return mdlS.ResEstudiantes(carnet);
    }

    /**
     * ResultSet
     *
     * @param nombre ResultSet parameter
     * @return a ResultSet
     */
    public ResultSet CargarCarnetsController(String nombre) {
        return mdlS.ResCarnet(nombre);
    }

    /**
     * ResultSet
     *
     * @param placa ResultSet parameter
     * @return a ResultSet
     */
    public ResultSet CargarVehiculosPlacaController(String placa) {
        return mdlS.ResVeh(placa);
    }

    /**
     * ResultSet
     *
     * @param cont ResultSet parameter
     * @return a ResultSet
     */
    public ResultSet cargarContactos(String cont) {
        return mdlS.ResCon(cont);
    }

    /**
     *ResultSet
     * @return a ResultSet
     */
    public ResultSet cargarGraficaController() {
        return mdlS.GraficaAccesos();
    }

    /**
     *  ResultSet
     * @param parq ResultSet parameter
     * @return a ResultSet
     */
    public ResultSet cargarParqueosController(String parq) {
        return mdlS.ResPark(parq);
    }

    /**
     *  ResultSet
     * @return a ResultSet
     */
    public ResultSet cargarSalidasController() {
        return mdlS.GraficaSalidas();
    }

    /**
     *  ResultSet
     * @return a ResultSet
     */
    public ResultSet cargarAdminsController() {
        return mdlS.CargarAdmins();
    }

    /**
     *  ResultSet
     * @return a ResultSet
     */
    public ResultSet cargarProfesController() {
        return mdlS.CargarProfes();
    }

    /**
     *  ResultSet
     * @return a ResultSet
     */
    public ResultSet cargarAlumnosController() {
        return mdlS.CargarAlumnos();
    }

    /**
     *  ResultSet
     * @return a ResultSet
     */
    public ResultSet cargarSeguridadController() {
        return mdlS.CargarSeguridad();
    }
}
