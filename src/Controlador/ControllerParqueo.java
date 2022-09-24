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
 *  This class stores and connects the ModelParqueo with the view, and makes possible the communication between both
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

    /**
     *  Gets the parking ID
     * @return an Integer
     */
    public int getID() {
        return ID;
    }

    /**
     *  Set the parking ID
     * @param ID referring to the parking ID 
     */
    public void setID(int ID) {
        this.ID = ID;
    }

    /**
     *  Gets the vehicle ID
     * @return an Integer
     */
    public int getIDVehiculo() {
        return IDVehiculo;
    }

    /**
     *  Set the vehicle ID
     * @param IDVehiculo referring to the vehicle ID
     */
    public void setIDVehiculo(int IDVehiculo) {
        this.IDVehiculo = IDVehiculo;
    }

    /**
     *  Gets the parking lot ID
     * @return an Integer
     */
    public int getIDEstacionamiento() {
        return IDEstacionamiento;
    }

    /**
     *  Set the parking lot ID
     * @param IDEstacionamiento referring to the parking lot ID
     */
    public void setIDEstacionamiento(int IDEstacionamiento) {
        this.IDEstacionamiento = IDEstacionamiento;
    }

    /**
     *  Gets the access ID
     * @return an Integer
     */
    public int getIDAcceso() {
        return IDAcceso;
    }

    /**
     *  Set the access ID
     * @param IDAcceso referring to the access ID
     */
    public void setIDAcceso(int IDAcceso) {
        this.IDAcceso = IDAcceso;
    }

    /**
     *  Gets the parking ID
     * @return an Integer
     */
    public static int getIDParqueo() {
        return IDParqueo;
    }

    /**
     *  Set the parking ID
     * @param IDParqueo referring to the parking ID
     */
    public static void setIDParqueo(int IDParqueo) {
        ControllerParqueo.IDParqueo = IDParqueo;
    }

    /**
     *  Gets the parking spot number
     * @return an Integer
     */
    public static int getNumberPark() {
        return numberPark;
    }

    /**
     *  Set the parking spot number
     * @param numberPark referring to the parking spot number
     */
    public static void setNumberPark(int numberPark) {
        ControllerParqueo.numberPark = numberPark;
    }

    /**
     *  Gets the detail ID
     * @return an Integer
     */
    public static int getIDDetail() {
        return IDDetail;
    }

    /**
     *  Set the detail ID
     * @param IDDetail referring to the detail ID
     */
    public static void setIDDetail(int IDDetail) {
        ControllerParqueo.IDDetail = IDDetail;
    }    
    
    ModelParqueo mdpark = new ModelParqueo();

    /**
     *
     * @param NParqueo referring to the parking spot number
     * @return a ResultSet
     */
    public ResultSet getID(int NParqueo) {
        return mdpark.getIDPark(NParqueo);
    }

    /**
     *  Load the parking spot that are occupied
     * @return a ResultSet
     */
    public ResultSet loadPark() {
        return mdpark.loadPark();
    }

    /**
     *
     * @param park referring to the location of the parking spot
     * @return a ResultSet
     */
    public ResultSet getLocationPark(String park) {
        return mdpark.getLocation(park);
    }

    /**
     *  Save the information for the parking lot
     * @return a Boolean
     */
    public boolean insertPark() {
        return mdpark.insertPark(getIDAcceso(), getIDVehiculo(), getIDEstacionamiento());
    }

    /**
     *  Update the information for the parking lot
     * @return a Boolean
     */
    public boolean updatePark() {
        return mdpark.updatePark(getIDParqueo(), getIDAcceso(), getIDVehiculo(), getNumberPark(), getID());
    }

    /**
     *  Check the occupied spots in the parking lot
     * @return an Integer
     */
    public int checkStatePark() {
        return mdpark.checkState(getNumberPark());
    }

    /**
     *  Gets the station ID
     * @return a ResultSet
     */
    public ResultSet getIDStation() {
        return mdpark.getIDStation();
    }

    /**
     * Parameters for the parking lot processes
     * @param idstation referring to the spot ID
     * @param idpark referring to the parking lot ID
     * @return a ResultSet
     */
    public ResultSet getSingleIDStation(int idstation, int idpark) {
        return mdpark.getIDStation(idstation, idpark);
    }

    /**
     *  Delete the parking information
     * @return a Boolean
     */
    public boolean deletePark() {
        return mdpark.deletePark(getID());
    }

    /**
     *  Filters the spots assign to a specific user
     * @param viewname referring to the group of information required
     * @param parametername referring to the search parameters
     * @param carnet referring to the id - card of the user
     * @return a ResultSet
     */
    public ResultSet getCarByPersonal(String viewname, String parametername, String carnet) {
        return mdpark.getCarByPersonal(viewname, parametername, carnet);
    }
}
