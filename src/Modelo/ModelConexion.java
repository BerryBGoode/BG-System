/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;
/**
 *  This class stores all the sentences necessary for the correct functioning of the database connection
 * @author danlo
 */
public class ModelConexion {
    
    private static String username;
    private static String password;
    private static String ip;
    private static String host;
    private static String db;

    /**
     * Gets the username for the database connection
     * @return a String
     */
    public static String getUsername() {
        return username;
    }

    /**
     *  Set the username for the database connection
     * @param username referring to the username of the user
     */
    public static void setUsername(String username) {
        ModelConexion.username = username;
    }

    /**
     * Gets the password for the database connection
     * @return a String
     */
    public static String getPassword() {
        return password;
    }

    /**
     *  Set the password for the database connection
     * @param password referring to the password 
     */
    public static void setPassword(String password) {
        ModelConexion.password = password;
    }

    /**
     * Gets the IP for the database Connection
     * @return a String
     */
    public static String getIp() {
        return ip;
    }

    /**
     *  Set the IP for the database connection
     * @param ip referring to the IP for the connection
     */
    public static void setIp(String ip) {
        ModelConexion.ip = ip;
    }

    /**
     *  Gets the host for the database connection
     * @return a String
     */
    public static String getHost() {
        return host;
    }

    /**
     *  Set the host for the database connection
     * @param host referring to the host for the connection
     */
    public static void setHost(String host) {
        ModelConexion.host = host;
    }

    /**
     *  Gets the database name for the connection
     * @return a String
     */
    public static String getDb() {
        return db;
    }

    /**
     *  Set the database name for the connection
     * @param db referring to the database name
     */
    public static void setDb(String db) {
        ModelConexion.db = db;
    }
     
    /**
     *  Method that makes the connection to the database
     * @return a Connection
     */
    public static Connection getConnection(){        
        setDb("dbBG");
        String url = "jdbc:sqlserver://"+getIp()+":"+getHost()+";"
                + "database= "+getDb()+";"
                + "user= "+getUsername()+";"
                + "password= "+getPassword()+";"
                + "loginTimeout = 10";
        
        Connection connection;
        try {
            connection = DriverManager.getConnection(url);
            return connection;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }
}
