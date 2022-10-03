/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * This class stores all the sentences necessary for the correct functioning of the parking section
 *
 * @author danlo
 */
public class ModelParqueo {

    ResultSet rs;
    PreparedStatement sql;
    Connection con;

    //con este método recupero el ID del parqueo con el número de parqueo (el que sale en el cmb de configPark)
    /**
     * With this method the ID of the parking lot is retrieved with the parking number
     *
     * @param park referring to the parking lot ID
     * @return a ResultSet
     */
    public ResultSet getIDPark(int park) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT idParqueo FROM tbParqueos WHERE numero_parqueo = ?");
            sql.setInt(1, park);
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    //cargar los datos que se leen en el textfield y en el cmb de configpark
    /**
     * Load the data that is read in the textfield and in the cmb of configpark
     *
     * @return a ResultSet
     */
    public ResultSet loadPark() {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT idParqueo, numero_parqueo FROM tbParqueos");
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Erorr: " + e.toString());
            return null;
        }
    }

    //método para obtener el idestacionamiento, por medio del numero de estacionamiento y el IDparqueo
    /**
     * Method to obtain the identification, by the parking number and the IDparqueo
     *
     * @param station referring to the spot of the parking lot
     * @param idpark referring to the park ID
     * @return a ResultSet
     */
    public ResultSet getIDStation(int station, int idpark) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT  idEstacionamiento FROM tbEstacionamientos WHERE numero_estacionamiento = ? AND idParqueo = ?");

            sql.setInt(1, station);
            sql.setInt(2, idpark);
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    //cargar la ubicación del parqueo a partir del número de parqueo, (cuando se seleccione un parqueo en el cmb, se traera los datos que saque este método)
    /**
     * Load the location of the parking lot from the parking number, (when a parking lot is selected in the cmb, the data obtained by this method will be brought)
     *
     * @param parkString referring to the location
     * @return a ResultSet
     */
    public ResultSet getLocation(String parkString) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT Ubicacion FROM tbParqueos WHERE numero_parqueo = ? ");
            sql.setString(1, parkString);
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    /**
     * This method save the registers of parking
     *
     * @param idacces referring to the access ID
     * @param idcar referring to the car ID
     * @param idstation referring to the spot ID
     * @return a Boolean
     */
    public boolean insertPark(int idacces, int idcar, int idstation) {
        int avalible = 1;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("INSERT INTO tbDetalle_Acceso VALUES (?,?,?,?)");

            sql.setInt(1, idstation);
            sql.setInt(2, idacces);
            sql.setInt(3, idcar);
            sql.setInt(4, avalible);
            System.out.println(idcar);
            
            sql.execute();
            busyStateStation(idstation);
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return false;
        } catch (Exception r) {
            System.out.println("Error: " + r.toString());
            return false;
        }
    }

    /**
     * This method save the registers of parking*
     * @param idpark referring to the park ID
     * @param idacces referring to the access ID
     * @param idcar referring to the car ID
     * @param idstation referring to the spot ID
     * @param iddetail referring to the detail ID
     * @return a Boolean
     */
    public boolean updatePark(int idacces, int idcar, int idstation, int iddetail) {
        int busy = 1;
        boolean result;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("UPDATE tbDetalle_Acceso SET  IDEstacionamiento =  ?, IDAcceso = ? , IDVehiculo = ?, IDEstado = ? WHERE IDDetalle  = ? ");
            System.out.println("Model: " + idstation + " " + idacces + " " + idcar + " " + iddetail);
            sql.setInt(1, idstation);
            sql.setInt(2, idacces);
            sql.setInt(3, idcar);
            sql.setInt(4, busy);
            sql.setInt(5, iddetail);

            sql.execute();
            return result = true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return result = false;
        }
    }

    /**
     * Gets the spot ID
     *
     * @return a ResultSet
     */
    public ResultSet getIDStation() {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT idEstacionamiento FROM tbEstacionamientos");
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    /**
     * Check the parking spot State
     *
     * @param idpark referring to the park spot
     * @param idstation
     * @return an ResultSet
     */
    public ResultSet checkState(int idpark, int idstation) {       
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT * FROM tbEstacionamientos WHERE idParqueo = ? AND numero_estacionamiento = ?");
            sql.setInt(1, idpark);
            sql.setInt(2, idstation);

            rs = sql.executeQuery();
            
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    /**
     *  This method delete the information filtered by the ID of the park spot
     * @param   iddetail  referring to the spot in the parking lot
     * @return a Boolean
     */
    public boolean deletePark(int iddetail, int idstation) {
        int disable = 2;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("UPDATE tbDetalle_Acceso SET idEstado = ? WHERE IDDetalle = ?");
            System.out.println("Eliminar");
            sql.setInt(1, disable);
            sql.setInt(2, iddetail);
            sql.execute();
            deleteStateStion(idstation);
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return false;
        }
    }

    //con este método recupero los vehiculos que tenga registrado el personal con el carnet que se selecciono
    /**
     * With this method, the vehicles registered by the staff with the card that was selected are recovered.
     *
     * @param viewname referring to the view of the database
     * @param parametername referring to the parameters
     * @param carnet referring to the id - card of the user
     * @return a ResultSet
     */
    public ResultSet getCarByPersonal(String viewname, String parametername, String carnet) {
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT * FROM " + viewname + " WHERE " + parametername + " = ?");
            sql.setString(1, carnet);
            rs = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    /**
     * With this method set update in tbestacionamientos, this method chage the state on this table on database, for checked state where the user wannna to enter a data
     *
     * @param idpark
     * @param idstation
     * @return
     */
    public boolean busyStateStation(int idstation) {
        int busy = 2;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("UPDATE tbEstacionamientos SET idEstado = ? WHERE  idEstacionamiento = ? ");
            sql.setInt(1, busy);
            sql.setInt(2, idstation);
            sql.execute();
            System.out.println(idstation);
            return true;
        } catch (SQLException e) {
            System.out.println("Error Model: " + e.toString());
            return false;
        }
    }
    
    /**
     * 
     * this method chage the state on busy to avalible  in tbEstacionamientos
     * @param idstation
     * @return 
     */
    public boolean deleteStateStion(int idstation){
         int avalible = 1;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("UPDATE tbEstacionamientos SET idEstado = ? WHERE  idEstacionamiento = ? ");
            sql.setInt(1, avalible);
            sql.setInt(2, idstation);
            sql.execute();
            System.out.println(idstation);
            return true;
        } catch (SQLException e) {
            System.out.println("Error Model: " + e.toString());
            return false;
        }
    }
    
}
