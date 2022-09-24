/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import Modelo.ModelConexion;
/**
 * This class stores and connects the ModelConexion with the view, and makes possible the communication between both
 * @author danlo and Ferna
 */
public class ControllerConexion {
    
    /**
     * Check the connection data and run it
     * @return a Connection
     */
    public static Connection getConnectionModel(){
                
        return ModelConexion.getConnection();
    }
}
