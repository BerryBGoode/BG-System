/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelConexion;
/**
 *  This class stores and connects the ModelConexion with the view, and makes possible the communication between both
 * @author ferna
 */
public class ControllerConfig {    
       
    /**
     * Variables to use in class methods
     */
    private static String username;
    private static String password;
    private static String ip;
    private static String host;

    /**
     * Gets the username to Database Connection
     * @return a String
     */
    public static String getUsername() {
        return username;
    }

    /**
     *  Set the username to Database Connection
     * @param username referring to the username with which you log in to the database
     */
    public static void setUsername(String username) {
        ControllerConfig.username = username;
        ModelConexion.setUsername(username);
    }

    /**
     *  Get the password to Database Connection
     * @return a String
     */
    public static String getPassword() {
        return password;
    }

    /**
     * Set the password to Database Connection
     * @param password referring to the password with which you log in to the database
     */
    public static void setPassword(String password) {
        ControllerConfig.password = password;
        ModelConexion.setPassword(password);
    }

    /**
     *  Gets the IP address to Database Connection
     * @return a String
     */
    public static String getIp() {
        return ip;
    }

    /**
     * Set the IP to Database Connection
     * @param ip referring to the IP address with which you log in to the database
     */
    public static void setIp(String ip) {
        ControllerConfig.ip = ip;
        ModelConexion.setIp(ip);
    }

    /**
     * Gets the host to Database Connection
     * @return a String
     */
    public static String getHost() {
        return host;
    }

    /**
     * Set the host to Database Connection
     * @param host referring to the host with which you log in to the database
     */
    public static void setHost(String host) {
        ControllerConfig.host = host;
        ModelConexion.setHost(host);
    }
    
       
}
