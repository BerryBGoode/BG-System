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
public class ModelAjustes {
    PreparedStatement ps;
    public boolean CambiarPIN(String PIN, String nombre_usuario, Connection con){
            try{
                String query = "UPDATE tbUsuarios SET PIN = ? WHERE nombre_usuario = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, PIN);
                ps.setString(2, nombre_usuario);
                ps.execute();
                return true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
    }
    
     public boolean CambiarContra(String contra, String nombre_usuario, Connection con){
            try{
                String query = "UPDATE tbUsuarios SET contraseña = ? WHERE nombre_usuario = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, contra);
                ps.setString(2, nombre_usuario);
                ps.execute();
                return true;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
    }
     
    public ResultSet BuscarContraAntigua(String usuario, Connection con){
            try{
                String query = "SELECT contraseña FROM tbUsuarios WHERE nombre_usuario = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, usuario);
                ResultSet rs = ps.executeQuery();
                return rs;
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return null;
            }
    }
}
