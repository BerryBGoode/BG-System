
package Controlador;

import java.sql.ResultSet;

import Modelo.ModelVehiculos;

/**
 *
 * @author Eam
 */
public class ControllerVehiculos {
    
    private int idvehiculo;
    private int idpersonal;
    private String placa;
    private String color;

    public int getIdpersonal() {
        return idpersonal;
    }

    public void setIdpersonal(int idpersonal) {
        this.idpersonal = idpersonal;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public ControllerVehiculos(int idpersonal, String placa, String color) {
        this.idpersonal = idpersonal;
        this.placa = placa;
        this.color = color;
    }

    /**
     * 
     * @return 
     */
    
    public ControllerVehiculos(int idvehiculo, int idpersonal, String placa, String color) {
        this.idvehiculo = idvehiculo;
        this.idpersonal = idpersonal;
        this.placa = placa;
        this.color = color;
    }
    
    /**
     * 
     * @return 
     */

    public ControllerVehiculos(int idvehiculo) {
        this.idvehiculo = idvehiculo;
    }
    
    /**
     * 
     * @return 
     */

    public ControllerVehiculos() {
    }

    public static ResultSet CargarTablaVehiculos_Controller() {
        return ModelVehiculos.CargarTabla();
    }
    
    public static ResultSet CargarCMBPersonal_Controller() {
        return ModelVehiculos.CargarCMBPersonal();
    }
    
    public int RegistrarVehiculo_Controller() {
        return ModelVehiculos.RegistrarVehiculo(idpersonal, placa, color);
    }
    
    public boolean ActualizarVehiculo_Controller() {
        return ModelVehiculos.ActualizarVehiculo(idvehiculo, idpersonal, placa, color);
    }
    
    public boolean EliminarVehiculo_Controller() {
        return ModelVehiculos.EliminarVehiculo(idvehiculo);
    }
}
