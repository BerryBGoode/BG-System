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
 *  This class stores all the sentences necessary for the correct functioning of the login process
 * @author danlo
 */
public class ModelLogin {

    /**
     * Validates that the user exist
     * @param usuario referring to the username of the user
     * @return an Integer
     */
    public static int ValidarUsuario(String usuario) {
        Connection con;
        int i = 0;
        PreparedStatement ps;

        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM tbUsuarios WHERE nombre_usuario = ?");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            } else {
                i = 0;
            }
            return i;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error durante la verificacion de las credenciales" + e.toString(), "ERROR CRITICO", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }

    /**
     *  Recovers the information of the user to compare it 
     * @param usuario referring to the username
     * @param clave referring to the user's password
     * @return an Integer
     */
    public static int ValidarLogin(String usuario, String clave) {
        Connection con;
        int i = 0;
        PreparedStatement ps;

        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM tbUsuarios WHERE nombre_usuario = ? AND contraseña = ? AND intentos < 6");
            ps.setString(1, usuario);
            ps.setString(2, clave);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            } else {
                i = 0;
            }
            return i;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error durante la verificacion de las credenciales" + e.toString(), "ERROR CRITICO", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }

    /**
     *  Validates the user status 
     * @param usuario referring to the username of the user
     * @return an Integer
     */
    public static int ValidarUsuarioActivo(String usuario) {
        Connection con;
        int i = 0;
        PreparedStatement ps;

        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM tbUsuarios WHERE nombre_usuario = ? AND idEstadoUsuario = 1");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                i = 1;
            } else {
                i = 0;
            }
            return i;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error durante la verificacion de las credenciales" + e.toString(), "ERROR CRITICO", JOptionPane.WARNING_MESSAGE);
            return 0;
        }
    }

    /**
     *  Update the information of the user if the login process is correct
     * @param usuario referring to the username of the user
     * @return a Boolean
     */
    public static boolean BloquearUsuario(String usuario) {
        Connection con;
        PreparedStatement ps;

        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("UPDATE tbUsuarios SET idEstadoUsuario = 2, intentos = 0 WHERE nombre_usuario = ?");
            ps.setString(1, usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al validar los datos" + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     *  Update the attempts for login 
     * @param intentos referring to the attempts 
     * @param usuario referring to the username of the user
     * @return a Boolean
     */
    public static boolean Intentos(int intentos, String usuario) {
        Connection con;
        PreparedStatement ps;

        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("UPDATE tbUsuarios SET intentos = ? WHERE nombre_usuario = ?");
            ps.setInt(1, intentos);
            ps.setString(2, usuario);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al validar los datos" + e.toString(), "Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    /**
     *  Capture the number of attempts 
     * @param usuario referring to the username
     * @return a ResultSet
     */
    public static ResultSet CapturarIntentos(String usuario) {
        Connection con;
        PreparedStatement ps;
        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT intentos FROM tbUsuarios WHERE nombre_usuario = ?");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error al validar los datos" + e.toString(), "ERROR CRITICO", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    /**
     *  Capture all the user's information
     * @param usuario referring to username 
     * @return a ResultSet
     */
    public static ResultSet CapturarDatos(String usuario) {
        Connection con;
        PreparedStatement ps;
        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT a.idUsuario, a.nombre_usuario, b.tipo_usuario FROM tbUsuarios a, tbTipoUsuario b WHERE a.idTipoUsuario = b.idTipoUsuario AND a.nombre_usuario = ?");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error durante la verificacion de las credenciales" + e.toString(), "ERROR CRITICO", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }
    
    /**
     *  Capture the user type of the user that logins
     * @param usuario referring to the username of the user
     * @return a ResultSet
     */
    public static ResultSet CapturarTipoUs(String usuario){
        Connection con;
        PreparedStatement ps;
        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT a.idTipoUsuario FROM tbUsuarios a, tbTipoUsuario b WHERE a.idTipoUsuario = b.idTipoUsuario AND a.nombre_usuario = ?");
            ps.setString(1, usuario);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            return null;
        }
    }
}
