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
 * @author danlo
 */
public class ModelUsuarios {
        PreparedStatement ps;
    
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
}
