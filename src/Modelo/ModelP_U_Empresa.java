/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author danlo
 */
public class ModelP_U_Empresa {
    
    //Hermoso papucho
    PreparedStatement ps;    
    Connection con;

    /**
     * Metodo para comprobar si hay una empresa ingresada en la base de datos
     * @return 
     */
    public boolean checkEnterprise(){
    
        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM tbEmpresas");            
            ResultSet rs = ps.executeQuery();            
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }
    
    //Crear parametro tipo byte
    
    /**
     * Metodo para ingresar una empresa
     * @param nombre
     * @param representante_Legal
     * @param direccion
     * @param NIT
     * @param CNR
     * @param logo
     * @return 
     */
    public boolean IngresarPEmpresa(String nombre, String representante_Legal, String direccion, String NIT, String CNR, byte[] logo) {
        
        try {
            con = ModelConexion.getConnection();
            String query = ("INSERT INTO tbEmpresas (nombre_empresa,representante_legal, direccion_empresa, NIT_representante_legal, CNR, logo) VALUES (?,?,?,?,?,?)");
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, representante_Legal);
            ps.setString(3, direccion);
            ps.setString(4, NIT);
            ps.setString(5, CNR);
            ps.setBytes(6, logo);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar el proceso" + e.toString(),"Proceso incompleto",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
}
