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
 * This class stores all the sentences necessary for the correct functioning of the password recovery process
 * @author danlo
 */
public class ModelRecuperacionContra {

    /**
     *  This method is for password recovery by PIN
     * @param usuario referring to the username
     * @param PIN referring to the PIN of the user
     * @return an integer
     */
    public static int RecuperarContraPIN_ValidarDatos(String usuario, String PIN){
        Connection con;
        int i = 0;
        PreparedStatement ps;
        
        try{
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM tbUsuarios WHERE nombre_usuario = ? COLLATE SQL_Latin1_General_CP1_CS_AS AND PIN = ?");
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
    
    /**
     *  This method update the password of the user to a default one
     * @param usuario referring to the username
     * @param contra referring to the password
     * @return a Boolean
     */
    public static boolean RecuperarContra(String usuario, String contra){
        Connection con;
        PreparedStatement ps;
        
        try{
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("UPDATE tbUsuarios SET contrase??a = ?, idEstadoUsuario = 2, intentos = 5 WHERE nombre_usuario = ?");
            ps.setString(1, contra);
            ps.setString(2, usuario);
            ps.execute();
            return true;
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,"Ocurrio un error al actualizar la contrase??a" + e.toString(),"Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }
    
    //Por intervenci??n de administrador

    /**
     * Load the document type 
     * @param con referring to Connection
     * @return a ResultSet
     */
    
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
    
    /**
     *  Password recovery by admin intervention 
     * @param usuario referring to the username 
     * @param documento referring to the document of the user
     * @param idTipoDoc referring to the document type 
     * @param con referring to the Connection
     * @return an Integer
     */
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
    
        /**
     * Gets the type of document according to id
     * @param ID referring the ID (idTipoDocumento)
     * @return a ResultSet
     */
    public static ResultSet TipoDocumento(int ID){
            try{
                Connection con;
                PreparedStatement ps;
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
