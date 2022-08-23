/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import Modelo.ModelConexion;
/**
 *
 * @author danlo and Ferna
 */
public class ControllerConexion {
    
    
    public static Connection getConnectionModel(){
                
        return ModelConexion.getConnection();
    }
}
