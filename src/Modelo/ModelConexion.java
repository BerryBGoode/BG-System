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
public class ModelConexion {
    
    private static String username;
    private static String password;
    private static String ip;
    private static String host;
    private static String db;

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ModelConexion.username = username;
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ModelConexion.password = password;
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        ModelConexion.ip = ip;
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        ModelConexion.host = host;
    }

    public static String getDb() {
        return db;
    }

    public static void setDb(String db) {
        ModelConexion.db = db;
    }
     
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
