/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelBuscador;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelBuscador with the view, and makes possible the communication between both
 * @author danlo
 */
public class ControllerBuscador {
    
    String CarnetVehiculo;

    /**
     *Gets the id- card
     * @return a String
     */
    public String getCarnetVehiculo() {
        return CarnetVehiculo;
    }

    /**
     *  Set the id - card to the register
     * @param CarnetVehiculo referring to the id - card
     */
    public void setCarnetVehiculo(String CarnetVehiculo) {
        this.CarnetVehiculo = CarnetVehiculo;
    }
    
    ModelBuscador mdlS = new ModelBuscador();
    
    /**
     *  Load the information on the table
     * @param Carnet referring to the id - card
     * @return a ResultSet
     */
    public ResultSet CargarVehiculosCarnetController(String Carnet)
    {
        return mdlS.ResPersonal(Carnet);
    }
    
}
