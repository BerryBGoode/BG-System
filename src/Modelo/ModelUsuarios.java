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
 *
 * @author Rober
 */
public class ModelUsuarios {
        PreparedStatement ps;
    
        /**
         * Metodo para obtener los registros de la tabla tbTipoUsuario
         * @param con
         * @return 
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
         * Metodo para obtener los registros de la tabla tbEstadoUsuario
         * @param con
         * @return 
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
         * Metodo para obtener los registros de la tabla tbPersonal (en este caso, nombres y apellidos)
         * @param con
         * @return 
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
         * Metodo para obtener los registros en la tabla tbUsuarios
         * @param con
         * @return 
         */
        public ResultSet CargarUsuarios(Connection con){
            try{
                String query = "SELECT * FROM vwUsuarios";
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        /**
         * Metodo para ingresar un usuario
         * @param idPersonal
         * @param nombre_usuario
         * @param contraseña
         * @param PIN
         * @param idTipoUsuario
         * @param idEstadoUsuario
         * @param imagen
         * @param intentos
         * @param con
         * @return 
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
         * Metodo para actualizar un usuario
         * @param idPersonal
         * @param nombre_usuario
         * @param idTipoUsuario
         * @param idEstadoUsuario
         * @param imagen
         * @param ID
         * @param con
         * @return 
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
          * Metodo para eliminar un usuario
          * @param ID
          * @param con
          * @return 
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
         * Metodo para obtener los bytes de la imagen del usuario
         * @param ID
         * @param con
         * @return 
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
         * Metodo para obtener el carnet del personal al que pertenece el usuario seleccionado (debe ser un usuario de estudiante)
         * @param ID
         * @param con
         * @return 
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
         * Metodo para obtener el ID del estado "Activo"
         * @param con
         * @return 
         */
        public ResultSet BuscarIDActivo(Connection con){
            try{
                String query = "SELECT idEstadoUsuario FROM tbEstadoUsuario WHERE estado_usuario = 'Activo'";
                ps = con.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
        }
        
        /**
         * Metodo para obtener el ID del tipo de usuario: "Alumno"
         * @param con
         * @return 
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
