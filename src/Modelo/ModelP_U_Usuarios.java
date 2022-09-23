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
public class ModelP_U_Usuarios {

    PreparedStatement ps;
    Connection con;

    public boolean checkUsuario() {

        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT * FROM tbUsuarios");
            ResultSet rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            return false;
        }
    }

    public ResultSet GetIdPersonal() {
        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT idPersonal FROM tbPersonal");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }

    public boolean IngresarPUsuario(String Usuario, byte[] perfil, String Contra,String pin, int personal) {
        int idtipousuario = 1;
        int idestadousuario = 1;
        int intentos = 5;
        try {
            con = ModelConexion.getConnection();
            String querys = "INSERT INTO tbUsuarios (idPersonal, nombre_usuario, contraseña,PIN, idTipoUsuario, idEstadoUsuario, imagen , intentos) VALUES (?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(querys);
            ps.setInt(1, personal);
            ps.setString(2, Usuario);
            ps.setString(3, Contra);
            ps.setString(4, pin);
            ps.setInt(5, idtipousuario);
            ps.setInt(6, idestadousuario);
            ps.setBytes(7, perfil);
            ps.setInt(8, intentos);
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            JOptionPane.showMessageDialog(null, "Error al realizar el proceso" + e.toString(), "Error al registrar", JOptionPane.ERROR_MESSAGE);
            return false;
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return false;
        }
    }
    public boolean CambiarClave(String usuario, String newclave){
        try {
            con=ModelConexion.getConnection();
            String query="UPDATE tbUsuarios SET contraseña=? WHERE nombre_usuario=?";
            ps=con.prepareStatement(query);
            ps.setString(1, newclave);
            ps.setString(2, usuario);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar clave"+e.toString(),"Error Clave",JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    /*public ResultSet getIdUsuario(){
        try {
            con=ModelConexion.getConnection();
            String query="SELECT * FROM tbUsuarios";
        } catch (Exception e) {
        }
    }*/
}
