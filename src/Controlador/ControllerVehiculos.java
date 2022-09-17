
package Controlador;

import java.sql.ResultSet;

import Modelo.ModelVehiculos;

/**
 *
 * @author Eam
 */
public class ControllerVehiculos {
    
    public static int idvehiculo;
    public static String personal;
    public static String Carnet;
    public static String placa;
    public static String color;
    public static int idPersonal;

    public static int getIdvehiculo() {
        return idvehiculo;
    }

    public static void setIdvehiculo(int idvehiculo) {
        ControllerVehiculos.idvehiculo = idvehiculo;
    }

    public static String getPersonal() {
        return personal;
    }

    public static void setPersonal(String personal) {
        ControllerVehiculos.personal = personal;
    }

    public static String getCarnet() {
        return Carnet;
    }

    public static void setCarnet(String Carnet) {
        ControllerVehiculos.Carnet = Carnet;
    }

    public static String getPlaca() {
        return placa;
    }

    public static void setPlaca(String placa) {
        ControllerVehiculos.placa = placa;
    }

    public static String getColor() {
        return color;
    }

    public static void setColor(String color) {
        ControllerVehiculos.color = color;
    }

    public static int getIdPersonal() {
        return idPersonal;
    }

    public static void setIdPersonal(int idPersonal) {
        ControllerVehiculos.idPersonal = idPersonal;
    }

    public static ResultSet CargarTabla() {
        return ModelVehiculos.CargarTabla();
    }
    
    public static ResultSet CargarTabla_Personal() {
        return ModelVehiculos.CargarTabla_Personal();
    }
    
    public static boolean RegistrarVehiculo_Controller() {
        return ModelVehiculos.RegistrarVehiculo(idPersonal, placa, color);
    }
    
    public static boolean ActualizarVehiculo_Controller() {
        return ModelVehiculos.ActualizarVehiculo(idvehiculo, idPersonal, placa, color);
    }
    
    public static boolean EliminarVehiculo_Controller() {
        return ModelVehiculos.EliminarVehiculo(idvehiculo);
    }
}
