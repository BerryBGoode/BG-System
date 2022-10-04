/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 * This class stores all the sentences necessary for the correct functioning of the user's section
 * @author Rober
 */
public class ModelUsuarios {
        PreparedStatement ps;
    
        /**
         * Method to obtain the records of the table tbTipoUsuario
         * @param con referring to the Connection
         * @return a ResultSet
         */
        public ResultSet CargarTipoUsuarios(Connection con){
            try{
                String query = "SELECT * FROM tbTipoUsuario";
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
       
        /**
         * Method to obtain the data of the table tbEstadoUsuario
         * @param con referring to Connection
         * @return a ResultSet
         */
        public ResultSet CargarEstadoUsuarios(Connection con){
            try{
                String query = "SELECT * FROM tbEstadoUsuario";
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        /**
         * Method to obtain the records of the tbPersonal table (in this case, names and last names)
         * @param con referring to Connection
         * @return a ResultSet
         */
        public ResultSet CargarPersonal(Connection con){
            try{
                String query = "SELECT idPersonal, CONCAT(nombre_p, ' ', apellido_p) as nombre_completo FROM tbPersonal";
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        /**
         * Method to obtain the records in the tbUsuarios table
         * @param con referring to Connection
         * @return a ResultSet
         */
        public ResultSet CargarUsuarios(String usuario, Connection con){
            try{
                String query = "SELECT * FROM vwUsuarios WHERE nombre_usuario != ?";
                ps = con.prepareStatement(query);
                ps.setString(1, usuario);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        /**
         * Method to save a user
         * @param idPersonal referring to the staff ID
         * @param nombre_usuario referring to the username
         * @param contraseña referring to the password
         * @param PIN referring to the PIN
         * @param idTipoUsuario referring to the user type ID
         * @param idEstadoUsuario referring to the user status ID
         * @param imagen referring to the user image
         * @param intentos referring to the attempts 
         * @param con referring to Connection
         * @return a Boolean
         */
        public boolean AgregarUsuario(int idPersonal, String nombre_usuario, String contraseña, String PIN, int idTipoUsuario, int idEstadoUsuario, byte[] imagen, int intentos, Connection con){
            try{
                String query = "INSERT INTO tbUsuarios VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                ps = con.prepareStatement(query);
                ps.setInt(1, idPersonal);
                ps.setString(2, nombre_usuario);
                ps.setString(3, contraseña);
                ps.setString(4, PIN);
                ps.setInt(5, idTipoUsuario);
                ps.setInt(6, idEstadoUsuario);
                ps.setBytes(7, imagen);
                ps.setInt(8, intentos);
                if(ps.executeUpdate() == 1){
                    return true;
                }else{
                    return false;
                }
                
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
        }
        
        /**
         * Method to update a user
         * @param idPersonal referring to the staff ID
         * @param nombre_usuario referring to the username
         * @param idTipoUsuario referring to the user type
         * @param idEstadoUsuario referring to user status ID
         * @param imagen referring to the user image
         * @param ID referring to the ID
         * @param con referring to the Connection
         * @return  a Boolean
         */
         public boolean ActualizarUsuario(int idPersonal, String nombre_usuario, int idTipoUsuario, int idEstadoUsuario, byte[] imagen, int ID, Connection con){
            try{
                String query = "UPDATE tbUsuarios SET idPersonal = ?, nombre_usuario = ?, idTipoUsuario = ?, idEstadoUsuario = ?, imagen = ? WHERE idUsuario = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, idPersonal);
                ps.setString(2, nombre_usuario);
                ps.setInt(3, idTipoUsuario);
                ps.setInt(4, idEstadoUsuario);
                ps.setBytes(5, imagen);
                ps.setInt(6, ID);
                ps.execute();
                return true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
        }
        
         /**
          * Method to delete a user
          * @param ID referring to the ID
          * @param con referring to the Connection
          * @return a Boolean
          */
        public boolean EliminarUsuario(int ID, Connection con){
            try{
                String query = "DELETE FROM tbUsuarios WHERE idUsuario = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, ID);
                ps.execute();
                return true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
        }
        
        /**
         * Method to get the bytes of the user image
         * @param ID referring to the ID
         * @param con referring to Connection
         * @return a ResultSet
         */
        public ResultSet BuscarImagen(int ID, Connection con){
            try{
                String query = "SELECT imagen FROM tbUsuarios WHERE idUsuario = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, ID);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        /**
         * Method to obtain the card of the staff to which the selected user belongs (must be a student user)
         * @param ID referring to the ID
         * @param con referring to Connection
         * @return a ResultSet
         */
        public ResultSet BuscaCarnet(int ID, Connection con){
            try{
                String query = "SELECT a.Carnet FROM tbPersonal a, tbTipoPersonal b WHERE a.idPersonal =  ? AND b.tipo_personal = 'Alumnos' AND a.idTipoPersonal = b.idTipoPersonal";
                ps = con.prepareStatement(query);
                ps.setInt(1, ID);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        /**
         * Method to obtain the ID of the "Active" state
         * @param con referring to Connection
         * @return a ResultSet
         */
        public ResultSet BuscarIDActivo(Connection con){
            try{
                String query = "SELECT idEstadoUsuario FROM tbEstadoUsuario WHERE estado_usuario = 'Inactivo'";
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        /**
         * Method to obtain the ID of the user type: "Student"
         * @param con referring to Connection
         * @return a ResultSet
         */
        public ResultSet BuscarIDEstudiante(Connection con){
            try{
                String query = "SELECT idTipoUsuario FROM tbTipoUsuario WHERE tipo_usuario = 'Alumno'";
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
}
