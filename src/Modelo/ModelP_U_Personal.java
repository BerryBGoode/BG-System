/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Ander
 */
public class ModelP_U_Personal {

    PreparedStatement ps;
    Connection con;

    /**
     * Metodo para ingresar el carnet en algún registro de un personal (IDPersonal)
     * @param id
     * @param Carne
     * @return 
     */
    public boolean CarnetPersonal(int id, String Carne) {
        try {
            con = ModelConexion.getConnection();
            String query = "UPDATE tbPersonal SET Carnet=? WHERE idPersonal=?";
            ps = con.prepareStatement(query);
            ps.setString(1, Carne);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    /**
     * Metodo para obtener los registros ingresados en la tabla tbTipoDocumento
     * @return 
     */
    public ResultSet cargarTipD() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM tbTipoDocumento";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la lista " + e.toString());
            return null;
        }
    }

    /**
     * Metodo para comprobar si existe un registro en la tabla tbPersonal
     * @return 
     */
    public boolean checkPersonal() {

        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM tbPersonal");
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    /**
     * Metodo para obtener los registros ingresados en la tabla tbGeneros
     * @return 
     */
    public ResultSet cargarGeneroP() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM tbGeneros";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al cargar la lista" + e.toString());
            return null;
        }
    }

    /**
     * Metodo para obtener el IDEmpresa (se usa cuando el primer uso se cierra a medio proceso)
     * @return 
     */
    public ResultSet getEnterprise() {
        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT idEmpresa FROM tbEmpresas");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    /**
     * Metodo para ingresar un personal
     * @param idempresa
     * @param nombrep
     * @param apellidop
     * @param fecha
     * @param Correo
     * @param direccion
     * @param DUI
     * @param genero
     * @param idtipod
     * @return 
     */
    public boolean IngresarPPersonal(int idempresa, String nombrep, String apellidop, String fecha, String Correo, String direccion, String DUI, int genero, int idtipod) {
        try {
            int idtipopersonal = 2;
            con = ModelConexion.getConnection();
            String query = "INSERT INTO tbPersonal (nombre_p,apellido_p,fecha_nacimiento, correo, direccion, documento, idTipoDocumento, idTipoPersonal, idGenero, idEmpresa)VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombrep);
            ps.setString(2, apellidop);
            ps.setString(3, fecha);
            ps.setString(4, Correo);
            ps.setString(5, direccion);
            ps.setString(6, DUI);
            ps.setInt(7, idtipod);
            ps.setInt(8, idtipopersonal);
            ps.setInt(9, genero);
            ps.setInt(10, idempresa);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al realizar el proceso" + e.toString(), "Proceso incompleto", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    
    /**
     * Metodo para recuperar el tipo de documento por medio de su ID
     * @param ID
     * @return 
     */
        public ResultSet TipoDocumento(int ID){
            try{
                con = ModelConexion.getConnection();
                String query = "SELECT tipo_documento FROM tbTipoDocumento WHERE idTipoDocumento = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, ID);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
}
