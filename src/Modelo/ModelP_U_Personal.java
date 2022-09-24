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
 *  This class stores all the sentences necessary for the correct functioning of the staff checking process
 * @author Ander
 */
public class ModelP_U_Personal {

    PreparedStatement ps;
    Connection con;

    /**
     * Method to enter the id - card in a staff register (IDPersonal)
     * @param id referring to the staff ID
     * @param Carne referring to the id - card 
     * @return a Boolean
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
     * Method to obtain the registers stored in the table tbTipoDocumento
     * @return a ResultSet
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
     * Method to check if a register exists in the tbPersonal table
     * @return a Boolean
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
     * Method to obtain the registers stored in the tbGeneros table
     * @return a ResultSet
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
     * Method to obtain the companyID (used when the first use is closed in the middle of the process)
     * @return a ResultSet
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
     * Method to register a staff
     * @param idempresa referring to the company ID
     * @param nombrep referring to the staff name
     * @param apellidop referring to the staff last name
     * @param fecha referring to the birth date of the staff
     * @param Correo referring to the email of the staff
     * @param direccion referring to the address of the staff
     * @param DUI referring to the DUI of the staff
     * @param genero referring to the Gender of the staff
     * @param idtipod referring to the type of staff
     * @return a Boolean
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
     * Method to retrieve the document type by means of its ID
     * @param ID referring to the ID
     * @return a ResultSet
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
