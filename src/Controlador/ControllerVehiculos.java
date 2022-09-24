
package Controlador;

import java.sql.ResultSet;

import Modelo.ModelVehiculos;

/**
 *  This class stores and connects the ModelVehiculos with the view, and makes possible the communication between both
 * @author Eam
 */
public class ControllerVehiculos {
    
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
     *String variable
     */
    public static String color;

    /**
     *  Integer variable
     */
    public static int idPersonal;

    /**
     *  Gets the vehicle ID
     * @return an Integer
     */
    public static int getIdvehiculo() {
        return idvehiculo;
    }

    /**
     *  Set the vehicle ID
     * @param idvehiculo referring to the vehicle ID
     */
    public static void setIdvehiculo(int idvehiculo) {
        ControllerVehiculos.idvehiculo = idvehiculo;
    }

    /**
     *  Gets the Staff
     * @return a String
     */
    public static String getPersonal() {
        return personal;
    }

    /**
     *  Set staff vehicle
     * @param personal referring to the staff that will be registering their vehicle
     */
    public static void setPersonal(String personal) {
        ControllerVehiculos.personal = personal;
    }

    /**
     *  Gets the staff id - card
     * @return a String
     */
    public static String getCarnet() {
        return Carnet;
    }

    /**
     *  Set the staff id - card
     * @param Carnet referring to the staff id - card
     */
    public static void setCarnet(String Carnet) {
        ControllerVehiculos.Carnet = Carnet;
    }

    /**
     *  Gets the license plate of the user
     * @return a String
     */
    public static String getPlaca() {
        return placa;
    }

    /**
     *  Set user license plate
     * @param placa referring to the user's license plate
     */
    public static void setPlaca(String placa) {
        ControllerVehiculos.placa = placa;
    }

    /**
     *  Gets the vehicle color
     * @return a String
     */
    public static String getColor() {
        return color;
    }

    /**
     *  Set the vehicle color
     * @param color referring to the vehicle color
     */
    public static void setColor(String color) {
        ControllerVehiculos.color = color;
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
        ControllerVehiculos.idPersonal = idPersonal;
    }

    /**
     *  Load the information table
     * @return a ResultSet
     */
    public static ResultSet CargarTabla() {
        return ModelVehiculos.CargarTabla();
    }
    
    /**
     *  Load the information of a different view
     * @return a ResultSet
     */
    public static ResultSet CargarTabla_Personal() {
        return ModelVehiculos.CargarTabla_Personal();
    }
    
    /**
     *  Save the new registers of vehicles
     * @return a Boolean
     */
    public static boolean RegistrarVehiculo_Controller() {
        return ModelVehiculos.RegistrarVehiculo(idPersonal, placa, color);
    }
    
    /**
     *  Update the registers of the vehicles
     * @return a Boolean
     */
    public static boolean ActualizarVehiculo_Controller() {
        return ModelVehiculos.ActualizarVehiculo(idvehiculo, idPersonal, placa, color);
    }
    
    /**
     *  Delete the registers of the vehicles
     * @return a Boolean
     */
    public static boolean EliminarVehiculo_Controller() {
        return ModelVehiculos.EliminarVehiculo(idvehiculo);
    }
}
