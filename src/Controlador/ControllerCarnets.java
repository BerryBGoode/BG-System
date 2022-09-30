/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelCarnets;
import java.sql.ResultSet;

/**
 * This class stores and connects the ModelCarnets with the view, and makes possible the communication between both
 * @author danlo
 */
public class ControllerCarnets {

    ModelCarnets ObjModel = new ModelCarnets();
    
    /**
     * Variables to use in class methods
     */
    private int idPersonal;
    private String carnet;

    /**
     * Gets the id - card of the user 
     * @return a String
     */
    public String getCarnet() {
        return carnet;
    }

    /**
     * Set the id - card of the user 
     * @param carnet referring to the unique character string that identifies the user in the institution
     */
    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    /**
     *  Get the staff id
     * @return an Integer
     */
    public int getIdPersonal() {
        return idPersonal;
    }

    /**
     *  Set the staff id
     * @param idPersonal referring to the staff register identifier
     */
    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

    /**
     * Fill in the information table with the records that have an assigned id - card
     * @return a ResultSet 
     */
    public ResultSet cargarTablaController() {
        return ObjModel.cargarTablaConCarnet();
    }

    /**
     * Fill in the information table with the records that do not have an assigned id - card
     * @return a ResultSet
     */
    public ResultSet SinCarnetController() {
        return ObjModel.cargarTablaSinCarnet();
    }

    /**
     *  Generates the barcode with the idPersonal as a search parameter
     * @return a ResultSet
     */
    public ResultSet generarBarraController() {
        return ObjModel.generabarra(getIdPersonal());
    }

    /**
     *  save the barcode
     * @return a Boolean
     */
    public boolean IngresarCarnet(){
        return ObjModel.IngresandoCarnet(getIdPersonal(), getCarnet());
    }
    
    public ResultSet BuscarID(){
        return ObjModel.BuscarID(carnet);
    }
    
    public ResultSet BuscarImagen(){
        return ObjModel.BuscarImagen(idPersonal);
    }
}
