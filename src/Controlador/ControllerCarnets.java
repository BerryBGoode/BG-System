/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelCarnets;
import java.sql.ResultSet;

/**
 *
 * @author danlo
 */
public class ControllerCarnets {

    ModelCarnets ObjModel = new ModelCarnets();

    private int idPersonal;
    private String carnet;

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    public int getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(int idPersonal) {
        this.idPersonal = idPersonal;
    }

        public ResultSet cargarTablaController() {
        return ObjModel.cargarTablaConCarnet();
    }

    public ResultSet SinCarnetController() {
        return ObjModel.cargarTablaSinCarnet();
    }

    public ResultSet generarBarraController() {
        return ObjModel.generabarra(getIdPersonal());
    }
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
