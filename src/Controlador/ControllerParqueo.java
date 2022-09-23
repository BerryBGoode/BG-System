/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelParqueo;
import java.awt.Color;
import java.sql.ResultSet;

/**
 *
 * @author danlo
 */
public class ControllerParqueo {

    private int ID;
    private int IDVehiculo;
    private int IDEstacionamiento;
    private int IDAcceso;
    private static int IDParqueo;
    private static int numberPark;
    private static int IDDetail;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getIDVehiculo() {
        return IDVehiculo;
    }

    public void setIDVehiculo(int IDVehiculo) {
        this.IDVehiculo = IDVehiculo;
    }

    public int getIDEstacionamiento() {
        return IDEstacionamiento;
    }

    public void setIDEstacionamiento(int IDEstacionamiento) {
        this.IDEstacionamiento = IDEstacionamiento;
    }

    public int getIDAcceso() {
        return IDAcceso;
    }

    public void setIDAcceso(int IDAcceso) {
        this.IDAcceso = IDAcceso;
    }

    public static int getIDParqueo() {
        return IDParqueo;
    }

    public static void setIDParqueo(int IDParqueo) {
        ControllerParqueo.IDParqueo = IDParqueo;
    }

    public static int getNumberPark() {
        return numberPark;
    }

    public static void setNumberPark(int numberPark) {
        ControllerParqueo.numberPark = numberPark;
    }

    public static int getIDDetail() {
        return IDDetail;
    }

    public static void setIDDetail(int IDDetail) {
        ControllerParqueo.IDDetail = IDDetail;
    }    
    
    ModelParqueo mdpark = new ModelParqueo();

    public ResultSet getID(int NParqueo) {
        return mdpark.getIDPark(NParqueo);
    }

    public ResultSet loadPark() {
        return mdpark.loadPark();
    }

    public ResultSet getLocationPark(String park) {
        return mdpark.getLocation(park);
    }

    public boolean insertPark() {
        return mdpark.insertPark(getIDAcceso(), getIDVehiculo(), getIDEstacionamiento());
    }

    public boolean updatePark() {
        return mdpark.updatePark(getIDParqueo(), getIDAcceso(), getIDVehiculo(), getNumberPark(), getID());
    }

    public int checkStatePark() {
        return mdpark.checkState(getNumberPark());
    }

    public ResultSet getIDStation() {
        return mdpark.getIDStation();
    }

    public ResultSet getSingleIDStation(int idstation, int idpark) {
        return mdpark.getIDStation(idstation, idpark);
    }

    public boolean deletePark() {
        return mdpark.deletePark(getIDDetail());
    }

    public ResultSet getCarByPersonal(String viewname, String parametername, String carnet) {
        return mdpark.getCarByPersonal(viewname, parametername, carnet);
    }
}
