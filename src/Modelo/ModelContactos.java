
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author danlo
 */
public class ModelContactos {
    
    private static PreparedStatement ps;
    private static ResultSet rs;
    
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
