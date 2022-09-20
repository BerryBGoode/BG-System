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
 *
 * @author danlo
 */
public class ModelParqueo {

    ResultSet rs;
    PreparedStatement sql;
    Connection con;

    //con este método recupero el ID del parqueo con el número de parqueo (el que sale en el cmb de configPark)
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

    public boolean insertPark(int idacces, int idcar, int idstation) {
        int avalible = 2;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("INSERT INTO tbDetalle_Acceso VALUES (?,?,?,?)");

            sql.setInt(1, idstation);
            sql.setInt(2, idacces);
            sql.setInt(3, idcar);
            sql.setInt(4, avalible);
            sql.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return false;
        } catch (Exception r) {
            System.out.println("Error: " + r.toString());
            return false;
        }
    }

    public boolean updatePark(int idpark, int idacces, int idcar,  int idstation, int iddetail) {
        int busy = 1;
        boolean result;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("UPDATE tbDetalle_Acceso SET  IDEstacionamiento =  ?, IDAcceso = ? , IDVehiculo = ?, IDEstado = ? WHERE IDDetalle  = ? ");
            System.out.println("Model: "+idstation+" "+idacces+" "+idcar+" "+iddetail);
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

    public int checkState(int park) {
        int result;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT idEstado FROM tbEstacionamientos WHERE idParqueo = ? ");
            sql.setInt(1, park);
            rs = sql.executeQuery();
            if (rs.next()) {
                switch (rs.getInt("idEstado")) {
                    case 0:
                        result = 0;
                        //no esta regristado ni por primera vez
                        //o desocupad
                        break;
                    case 1:
                        result = 1;
                        //esta regristrado y esta disponible
                        break;
                    case 2:
                        result = 2;
                        //esta registrado y ocupado
                        break;
                    default:
                        result = 3;
                        //no se evaluan en niguno
                        break;
                }
            } else {
                result = 0;
                //no hay dats
            }
            return result;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return -1;
        }
    }

    public boolean deletePark(int IDStation) {
        int availeble = 2;
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("UPDATE tbDetalle_Acceso SET idEstado = ? WHERE idEstacionamiento = ?");
            sql.setInt(1, availeble);
            sql.setInt(2, IDStation);
            sql.execute();
            return true;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return false;
        }
    }
    //con este método recupero los vehiculos que tenga registrado el personal con el carnet que se selecciono
    public ResultSet getCarByPersonal(String viewname, String parametername, String carnet){
        try {
            con = ModelConexion.getConnection();
            sql = con.prepareStatement("SELECT * FROM "+viewname+" WHERE "+parametername+" = ?");
            sql.setString(1, carnet);
            rs  = sql.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: "+e.toString());
            return null;
        }
    }
    
}
