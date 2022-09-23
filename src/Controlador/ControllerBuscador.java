/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelBuscador;
import java.sql.ResultSet;

/**
 *
 * @author danlo
 */
public class ControllerBuscador {
    
    String CarnetVehiculo;

    public String getCarnetVehiculo() {
        return CarnetVehiculo;
    }

    public void setCarnetVehiculo(String CarnetVehiculo) {
        this.CarnetVehiculo = CarnetVehiculo;
    }
    
    ModelBuscador mdlS = new ModelBuscador();
    
    public ResultSet CargarVehiculosCarnetController(String Carnet)
    {
        return mdlS.ResPersonal(Carnet);
    }
    
}
