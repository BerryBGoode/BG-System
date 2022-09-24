/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;

/**
 *
 * @author danlo
 */
public class ModelAccesos {

    static ResultSet rs;
    static PreparedStatement sql;
    static Connection con;

    public static ResultSet getdata(String tablename) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT * FROM " + tablename);
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    //Method for insert access of staff
    public static boolean insertAccess(int ID, int typeaccess, String date, String hour, String justif) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("INSERT INTO tbAccesos VALUES (?,?,?,?,?)");
            sql.setInt(1, ID);
            sql.setString(2, date);
            sql.setString(3, hour);
            sql.setInt(4, typeaccess);
            sql.setString(5, justif);
            sql.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error " + e.toString());
            return false;
        }
    }

    public static boolean updateAccess(int personal, int acceso, String notification, int ID) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("UPDATE tbAccesos SET idPersonal = ?, idTipoAcceso = ?, notificacion = ? WHERE idAcceso = ?");
            sql.setInt(1, personal);
            sql.setInt(2, acceso);
            sql.setString(3, notification);
            sql.setInt(4, ID);
            sql.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    public static boolean deleteAccess(int ID) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("DELETE tbAccesos WHERE idAcceso = ?");
            sql.setInt(1, ID);
            sql.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return false;
        }
    }
}
