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
public class ModelReportes {
    PreparedStatement ps;
    
    public boolean BuscarEstadoUsuario(String par, Connection con){
        ResultSet rs;
        try{
                String query = "SELECT * FROM tbUsuarios a, tbEstadoUsuario b WHERE b.estado_usuario = ? AND a.idEstadoUsuario = b.idEstadoUsuario";
                ps = con.prepareStatement(query);
                ps.setString(1, par);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
    }
    
    public boolean BuscarTipoUsuario(String par, Connection con){
        ResultSet rs;
        try{
                String query = "SELECT * FROM tbUsuarios a, tbTipoUsuario b WHERE b.tipo_usuario = ? AND a.idTipoUsuario = b.idTipoUsuario";
                ps = con.prepareStatement(query);
                ps.setString(1, par);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
    }
    
    public boolean BuscarGenero(String par, Connection con){
        ResultSet rs;
        try{
                String query = "SELECT * FROM tbPersonal a, tbGeneros b WHERE b.genero = ? AND a.idGenero = b.idGenero AND a.idTipoPersonal = 4";
                ps = con.prepareStatement(query);
                ps.setString(1, par);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
    }
    
    public boolean BuscarGeneroP(String par, Connection con){
        ResultSet rs;
        try{
                String query = "SELECT * FROM tbPersonal a, tbGeneros b WHERE b.genero = ? AND a.idGenero = b.idGenero AND a.idTipoPersonal != 4";
                ps = con.prepareStatement(query);
                ps.setString(1, par);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
    }
        
    public boolean BuscarTipoPersonal(String par, Connection con){
        ResultSet rs;
        try{
                String query = "SELECT * FROM tbPersonal a, tbTipoPersonal b WHERE b.tipo_personal = ? AND a.idTipoPersonal = b.idTipoPersonal AND a.idTipoPersonal != 4";
                ps = con.prepareStatement(query);
                ps.setString(1, par);
                rs = ps.executeQuery();
                
                if(rs.next()){
                    return true;
                }else{
                    return false;
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.toString());
                return false;
            }
    }
}
