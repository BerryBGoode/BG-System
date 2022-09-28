/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;

/**
 * This class stores all the sentences necessary for the correct functioning of the access section
 * @author danlo
 */
public class ModelAccesos {

    static ResultSet rs;
    static PreparedStatement sql;
    static Connection con;

    /**
     *  Creation of a ResultSet for the general information of the table
     * @param tablename referring to the table name as a search parameter
     * @return a ResultSet
     */
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

    /**
     *  Creation of a ResultSet for the specific information of the table
     * @param tablename referring to the table name as a search parameter
     * @return a ResulSet
     */
    public static ResultSet getdataEntry(String tablename) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT * FROM " + tablename + " WHERE idTipoAcceso=1");
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    /**
     *  Creation of a ResultSet for the specific information of the table
     * @param tablename referring to the table name as a search parameter
     * @return a ResulSet
     */
    public static ResultSet getdataExit(String tablename) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT * FROM " + tablename + " WHERE idTipoAcceso=2");
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    //Method for insert access of staff

    /**
     * Method for insert access of staff
     * @param ID referring to the access ID
     * @param typeaccess referring to the access type
     * @param date referring to the access date
     * @param hour referring to the access hour
     * @param justif referring to the access justification
     * @return a Boolean
     */
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

    /**
     *  Method for update the access of staff
     * @param personal referring to the staff ID
     * @param acceso referring to the access registered
     * @param notification referring to the justification
     * @param ID referring to the access registered ID
     * @return a Boolean
     */
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

    /**
     * Method for delete access of staff
     * @param ID referring to the access ID
     * @return a Boolean
     */
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

    /**
     *  Method for search the staff by their id - card number
     * @param carne referring to the id - card
     * @return a ResultSet
     */
    public static ResultSet LookingForId_Personal(String carne) {
        ResultSet rs;
        Connection con;
        PreparedStatement ps;
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM tbPersonal WHere Carnet=?";
            ps = con.prepareStatement(query);
            ps.setString(1, carne);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }

    }

    /**
     * Method for insert the barcode at the access attempt
     * @param ID referring to the access ID
     * @param typeaccess referring to the access type 
     * @param date referring to the access date
     * @param hour referring to the access hour
     * @param justif referring to the access justification
     * @return a Boolean
     */
    public static boolean insertAccessBarCode(int ID, int typeaccess, String date, String hour, String justif) {
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
}
