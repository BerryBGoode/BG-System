/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelConexion;
/**
 *
 * @author ferna
 */
public class ControllerConfig {    
       
    private static String username;
    private static String password;
    private static String ip;
    private static String host;

    //no estoy seguro si sería bueno que por medio de los setters asignar 
    //valores a los attr de la conexión en el modelo...
    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ControllerConfig.username = username;
        ModelConexion.setUsername(username);
    }

    public static String getPassword() {
        return password;
    }

    public static void setPassword(String password) {
        ControllerConfig.password = password;
        ModelConexion.setPassword(password);
    }

    public static String getIp() {
        return ip;
    }

    public static void setIp(String ip) {
        ControllerConfig.ip = ip;
        ModelConexion.setIp(ip);
    }

    public static String getHost() {
        return host;
    }

    public static void setHost(String host) {
        ControllerConfig.host = host;
        ModelConexion.setHost(host);
    }
    
       
}
