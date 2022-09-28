/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.ResultSet;
import Modelo.ModelAccesos;

/**
 * This class stores and connects the ModelAccesos with the view, and makes possible the communication between both
 * @author danlo
 */
public class ControllerAccesos {

    /**
     * Variables to use in class methods
     */
    private static int ID;
    private static int typeAccess;
    private static String date;
    private static String Carnet;
    private static String hour;
    private static String justification;
    private static int staff;

    /**
     * Stores the id of the user registering access
     * @return an Integer
     */
    public static int getID() {
        return ID;
    }

    /**
     * Set the id of the user registering the access
     * @param ID referring to the id of access registered
     */
    public static void setID(int ID) {
        ControllerAccesos.ID = ID;
    }

    /**
     * Gets the access type of the user
     * @return an Integer
     */
    public static int getTypeAccess() {
        return typeAccess;
    }

    /**
     * Set the type of user access
     * @param typeAccess referring to the type of access registered
     */
    public static void setTypeAccess(int typeAccess) {
        ControllerAccesos.typeAccess = typeAccess;
    }

    /**
     * Gets the date the access is registered
     * @return a String
     */
    public static String getDate() {
        return date;
    }

    /**
     * Set the date on which access is registered
     * @param date referring to the date on which access is registered
     */
    public static void setDate(String date) {
        ControllerAccesos.date = date;
    }

    /**
     * Gets the time when access is registered
     * @return a String
     */
    public static String getHour() {
        return hour;
    }

    /**
     * Set the time when access is registered
     * @param hour referring to the time at which access is registered
     */
    public static void setHour(String hour) {
        ControllerAccesos.hour = hour;
    }

    /**
     *  Gets the justification of the registered access
     * @return a String
     */
    public static String getJustification() {
        return justification;
    }

    /**
     * Set the justification of the registered access
     * @param justification referring to the user's justification at the time of registering an access
     */
    public static void setJustification(String justification) {
        ControllerAccesos.justification = justification;
    }

    /**
     *  Gets the staff type of the user registered access
     * @return an Integer
     */
    public static int getStaff() {
        return staff;
    }

    /**
     * Set the staff type of the user registered access
     * @param staff referring to the type of personal that register the access
     */
    public static void setStaff(int staff) {
        ControllerAccesos.staff = staff;
    }

    /**
     * Gets the id - card of the user that registered the access
     * @return a String
     */
    public static String getCarnet() {
        return Carnet;
    }

    /**
     * Set the id - card of the user that registered the access
     * @param Carnet referring to the unique character string that identifies the user in the institution
     */
    public static void setCarnet(String Carnet) {
        ControllerAccesos.Carnet = Carnet;
    }

    /**
     * Get general information of the specified table
     * @param tablename referring to the table name
     * @return a ResultSet with the information obtained
     */
    public static ResultSet getdata(String tablename) {
        return ModelAccesos.getdata(tablename);
    }

    /**
     *  Filter the information obtained by a search result parameter idTipoAcceso = 1
     * @param tablename referring to the table name
     * @return a ResultSet with the information obtained
     */
    public static ResultSet getdataEntry(String tablename) {
        return ModelAccesos.getdataEntry(tablename);
    }

    /**
     * Filter the information obtained by a search result parameter idTipoAcceso = 2
     * @param tablename referring to the table name
     * @return a ResultSet with the information obtained
     */
    public static ResultSet getdataExit(String tablename) {
        return ModelAccesos.getdataExit(tablename);
    }

    /**
     * Performs the insertion method taking the user information as parameters
     * @return a boolean data type
     */
    public static boolean insertAccess() {
        return ModelAccesos.insertAccess(getID(), getTypeAccess(), getDate(), getHour(), getJustification());
    }

    /**
     * Performs the update method taking the user information as parameters
     * @return a boolean data type
     */
    public static boolean updateAccess() {
        return ModelAccesos.updateAccess(getStaff(), getTypeAccess(), justification, getID());
    }

    /**
     * Performs the record deletion method taking the user information as parameters
     * @return a boolean data type
     */
    public static boolean deleteAccess() {
        return ModelAccesos.deleteAccess(getID());
    }

    /**
     * Performs the search of records through a search parameter that is the user's id - card
     * @return a ResultSet with the information obtained
     */
    public static ResultSet LookiingForPersonal() {
        return ModelAccesos.LookingForId_Personal(Carnet);
    }
}
