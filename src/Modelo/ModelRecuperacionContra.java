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
 * @author danlo
 */
public class ModelRecuperacionContra {
    public static int RecuperarContraPIN_ValidarDatos(String usuario, String PIN){
        Connection con;
        int i = 0;
        PreparedStatement ps;
        
        try{
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM tbUsuarios WHERE nombre_usuario = ? AND PIN = ?");
            ps.setString(1, usuario);
            ps.setString(2, PIN);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                i = 1;
            }else{
                i = 0;
            }
            return i;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error durante la verificacion de las credenciales" + e.toString(),"ERROR CRITICO", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }
    
    public static boolean RecuperarContra(String usuario, String contra){
        Connection con;
        PreparedStatement ps;
        
        try{
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("UPDATE tbUsuarios SET contraseña = ?, idEstadoUsuario = 1, intentos = 5 WHERE nombre_usuario = ?");
            ps.setString(1, contra);
            ps.setString(2, usuario);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error al actualizar la contraseña" + e.toString(),"Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    //Por intervención de administrador
    
    public static ResultSet CargarTipoDocumento(Connection con){
        PreparedStatement ps;
        try{
            ps = con.prepareStatement("SELECT * FROM tbTipoDocumento");
            ResultSet rs = ps.executeQuery();
            return rs;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Error al cargar los tipos de documento" + e.toString(),"Error", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    public static int ValidarDocumento(String usuario, String documento, int idTipoDoc, Connection con){
        int i = 0;
        PreparedStatement ps;

        try {
            ps = con.prepareStatement("SELECT * FROM tbUsuarios a, tbPersonal b WHERE nombre_usuario = ? AND documento = ? AND idTipoDocumento = ?");
            ps.setString(1, usuario);
            ps.setString(2, documento);
            ps.setInt(3, idTipoDoc);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            } else {
                i = 0;
            }
            return i;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Credenciales invalidas" + e.toString(), "ERROR CRITICO", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }
    
    public static ResultSet TipoDocumento(int ID, Connection con){
            try{
                String query = "SELECT tipo_documento FROM tbTipoDocumento WHERE idTipoDocumento = ?";
                PreparedStatement ps;
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
