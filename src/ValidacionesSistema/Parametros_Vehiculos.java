/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesSistema;

/**
 *  This class stored the parameters that will be used in the system.
 * @author 50377
 */
public class Parametros_Vehiculos {
    
    /**
     *  Integer variable
     */
    public static int idvehiculo;

    /**
     *  String variable
     */
    public static String personal;

    /**
     *  String variable
     */
    public static String Carnet;

    /**
     *  String variable
     */
    public static String placa;

    /**
     *  String variable
     */
    public static String color;

    /**
     *  Integer variable
     */
    public static int idPersonal;

    /**
     * Gets the vehicle ID
     * @return an integer
     */
    public static int getIdvehiculo() {
        return idvehiculo;
    }

    /**
     *  Set the vehicle ID
     * @param idvehiculo referring to the vehicle ID
     */
    public static void setIdvehiculo(int idvehiculo) {
        Parametros_Vehiculos.idvehiculo = idvehiculo;
    }

    /**
     *  Gets the staff
     * @return a String
     */
    public static String getPersonal() {
        return personal;
    }

    /**
     *  Set the Staff
     * @param personal referring to the staff
     */
    public static void setPersonal(String personal) {
        Parametros_Vehiculos.personal = personal;
    }

    /**
     *  Gets the id - card
     * @return a String
     */
    public static String getCarnet() {
        return Carnet;
    }

    /**
     *  Set the id - card 
     * @param Carnet referring the id - card
     */
    public static void setCarnet(String Carnet) {
        Parametros_Vehiculos.Carnet = Carnet;
    }

    /**
     *  Gets the license plate
     * @return a String
     */
    public static String getPlaca() {
        return placa;
    }

    /**
     *  Set the license plate
     * @param placa referring to the license plate
     */
    public static void setPlaca(String placa) {
        Parametros_Vehiculos.placa = placa;
    }

    /**
     *  Gets the color of the vehicle
     * @return a String
     */
    public static String getColor() {
        return color;
    }

    /**
     *  Set the vehicle Color
     * @param color referring to the color of the vehicle
     */
    public static void setColor(String color) {
        Parametros_Vehiculos.color = color;
    }

    /**
     *  Gets the staff ID
     * @return an Integer
     */
    public static int getIdPersonal() {
        return idPersonal;
    }

    /**
     *  Set the staff ID
     * @param idPersonal referring to the staff ID
     */
    public static void setIdPersonal(int idPersonal) {
        Parametros_Vehiculos.idPersonal = idPersonal;
    }
    
    
    
}
