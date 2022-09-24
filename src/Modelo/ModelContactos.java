
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * This class stores all the sentences necessary for the correct functioning of the contacts section
 * @author danlo
 */
public class ModelContactos {
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    
    /**
     * Load the contact table with the information stored in the view
     * @return a ResultSet
     */
    public static ResultSet CargarTablaContactos() {
        
        Connection connect;
        
        try {
            connect = ModelConexion.getConnection();
            String query = "SELECT * FROM vwContactos";
            ps = connect.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, "No se han podido cargar los datos");
            return null;    
        }   
        
    }
    
    /**
     *  Load the contact table with the information stored in the view
     * @return a ResultSet
     */
    public static ResultSet CargarTablaPersonal() {
        Connection connect;
        try {
            connect = ModelConexion.getConnection();
            ps = connect.prepareStatement("SELECT * FROM vwPersonal_Contactos");
            rs = ps.executeQuery();
            return rs;
        }catch (Exception e){
            System.out.println("Error: " + e.toString());
            return null;
        }
    }
    
    /**
     *  Load the contact type combobox with the information stored in the table
     * @return a ResultSet
     */
    public static ResultSet CargarCMBTipoContacto() {
        
        Connection connect;
        
        try {
            connect = ModelConexion.getConnection();
            String query = "SELECT * FROM tbTipoContacto";
            ps = connect.prepareStatement(query);
            rs = ps.executeQuery();
            return rs;
        } catch(Exception e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
        
    }
    
    /**
     *  This method registers the contacts of the users
     * @param contacto referring to the contact String
     * @param idpersonal referring to the staff ID
     * @param idtipocontacto referring to the contact type ID
     * @return a Boolean
     */
    public static boolean RegistrarContacto(String contacto, int idpersonal, int idtipocontacto) {
        
        Connection connect;
        
        try {
            connect = ModelConexion.getConnection();
            String query = "INSERT INTO tbContactos VALUES (?,?,?)";
            ps = connect.prepareStatement(query);
            ps.setString(1, contacto);
            ps.setInt(2, idpersonal);
            ps.setInt(3, idtipocontacto);
            ps.execute();
            return true;
        } catch(SQLException e) {
            System.out.println(e.toString());
            return false;
        }
        
    }
    
    /**
     * This method capture the staff ID from the database table
     * @param contacto referring to the contact String
     * @return a ResultSet
     */
    public static ResultSet capturar_idPersonal(String contacto){
        Connection connect;
        try{
            connect = ModelConexion.getConnection();
            ps = connect.prepareStatement("SELECT idPersonal FROM tbContactos");
            rs = ps.executeQuery();
            return rs;
        } catch(Exception e){
            System.out.print("Error: " + e.toString());
            return null;
        }
    }
    
    /**
     *  This method load the information filtered by a search parameter
     * @param idper referring to the staff ID
     * @return a ResultSet
     */
    public static ResultSet cap_idPersonal_tbPersonal(String idper){
        Connection connect;
        try{
            connect = ModelConexion.getConnection();
            ps = connect.prepareStatement("SELECT idPersonal FROM tbContactos WHERE contacto=?");
            ps.setString(1, idper);
            rs = ps.executeQuery();
            return rs;
        } catch(Exception e){
            System.out.print("Error: " + e.toString());
            return null;
        }
    }
    
    /**
     *  This method update the contact information stored in the database
     * @param idcontacto referring to the contact ID
     * @param contacto referring to the contact String
     * @param idpersonal referring to the staff ID
     * @param idtipocontacto referring to the contact type ID
     * @return a Boolean
     */
    public static boolean ActualizarContacto(int idcontacto, String contacto, int idpersonal, int idtipocontacto) {
        
        Connection connect;
        
        try {
            connect = ModelConexion.getConnection();
            String query = "UPDATE tbContactos SET contacto = ?, idPersonal = ?, idTipoContacto = ? WHERE idContacto = ?";
            ps = connect.prepareStatement(query);
            ps.setString(1, contacto);
            ps.setInt(2, idpersonal);
            ps.setInt(3, idtipocontacto);
            ps.setInt(4, idcontacto);
            ps.execute();
            return true;
        } catch(SQLException e) {
            return false;
        }
        
    }
    
    /**
     *  This method recovers the contact ID
     * @return a ResultSet
     */
    public static ResultSet capturar_idContacto(){
        Connection connect;
        try{
            connect = ModelConexion.getConnection();
            ps = connect.prepareStatement("SELECT idContacto FROM tbContactos");
            rs = ps.executeQuery();
            return rs;
        } catch(Exception e){
            System.out.print("Error: " + e.toString());
            return null;
        }
    }
    
    /**
     *  This method delete the information stored in the database by a search parameter
     * @param idcontacto referring to the contact ID
     * @return a Boolean
     */
    public static boolean EliminarContacto(int idcontacto) {
        
        Connection connect;
        
        try {
            connect = ModelConexion.getConnection();
            String query = "DELETE tbContactos WHERE idContacto = ?";
            ps = connect.prepareStatement(query);
            ps.setInt(1, idcontacto);
            ps.execute();
            return true;
        } catch(SQLException e) {
            return false;
        }
        
    }
    
    
}
