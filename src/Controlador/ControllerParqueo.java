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
    private int IDAcceso;
    private static int IDParqueo;
    private static int numberPark;
            
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
        
    ModelParqueo mdpark = new ModelParqueo();
    
    public ResultSet getID(int NParqueo){
        return mdpark.getIDPark(NParqueo);
    }
    
    public ResultSet loadPark(){
        return mdpark.loadPark();
    }
    
    public ResultSet getLocationPark(String park){
        return mdpark.getLocation(park);
    }
    
    public boolean insertPark(){
        return mdpark.insertPark(getIDParqueo(), getIDAcceso(), getIDVehiculo(),getNumberPark());
    }
    
    public int checkStatePark(){
        return mdpark.checkState(getNumberPark());
    }
    
    public ResultSet getIDStation(){
        return mdpark.getIDStation();
    }
    
    public boolean deletePark(){
        return mdpark.deletePark(getID());
    }
}
