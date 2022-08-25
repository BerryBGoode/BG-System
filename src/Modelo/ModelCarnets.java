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

/**
 *
 * @author danlo
 */
public class ModelCarnets {

    PreparedStatement ps;
    Connection con;

    public ResultSet cargarTablaConCarnet() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM vwPConCarnet";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("No se logro cargar la informacion de la tabla");
            return null;
        }
    }

    public ResultSet cargarTablaSinCarnet() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM vwPSinCarnet";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println("Error"+e.toString());
            return null;
        }
    }
    public ResultSet generabarra(int idPersonal){
        try {
            con=ModelConexion.getConnection();
            String query="SELECT Carnet FROM tbPersonal WHERE idPersonal=? ";
            ps=con.prepareStatement(query);
            ps.setInt(1, idPersonal);
            ResultSet rs=ps.executeQuery();
            return  rs;
        } catch (Exception e) {
            System.out.println("Error codigo de barras ModelCarnets "+e.toString());
            return  null;
        }
    }
    public boolean IngresandoCarnet(int idpersonal, String carnet){
        try {
            con=ModelConexion.getConnection();
            String query="UPDATE tbPersonal SET Carnet=? WHERE idPersonal=?";
            ps=con.prepareStatement(query);
            ps.setString(1, carnet);
            ps.setInt(2, idpersonal);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al registrar Carné"+e.toString());
            return false;
        }
    }

}
