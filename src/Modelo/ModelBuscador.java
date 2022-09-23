/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.sun.org.apache.bcel.internal.generic.SWITCH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danlo
 */
public class ModelBuscador {
   
    Connection con;
    PreparedStatement ps;
    
    public ResultSet ResPersonal(String Carnet)
    {
        String identificacion;
        try 
        {
            con = ModelConexion.getConnection();
            String cons = "SELECT * FROM vwProfesores WHERE Carnet = ?";
            ps = con.prepareStatement(cons);
            ps.setString(1, Carnet);
            
            ResultSet res = ps.executeQuery();
            return res;
            
        } catch (SQLException e) 
        {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base","Verifique la clase ModelSearch - Metodo ResVehiculos", 2);
            return null;
        }
    }
}
