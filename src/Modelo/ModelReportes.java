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
    
    public boolean BuscarVehiculosPersonal(String par, Connection con){
                ResultSet rs;
        try{
                String query = "SELECT vwVehiculos.idPersonal AS vwVehiculos_idPersonal, vwVehiculos.idVehiculo AS vwVehiculos_idVehiculo, vwVehiculos.Carnet AS vwVehiculos_Carnet, CONCAT(vwVehiculos.nombre_p, ' ', vwVehiculos.apellido_p) AS vwVehiculos_nombre_p, vwVehiculos.placa AS vwVehiculos_placa, vwVehiculos.color AS vwVehiculos_color FROM dbo.vwVehiculos vwVehiculos WHERE vwVehiculos.Carnet LIKE ? OR vwVehiculos.nombre_p LIKE ? OR vwVehiculos.apellido_p LIKE ?";
                ps = con.prepareStatement(query);
                ps.setString(1, par);
                ps.setString(2, par);
                ps.setString(3, par);
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
    
        public boolean BuscarContactosPersonal(String par, Connection con){
                ResultSet rs;
        try{
                String query = "SELECT tbContactos.idContacto AS tbContactos_idContacto, tbContactos.contacto AS tbContactos_contacto, tbPersonal.nombre_p AS tbPersonal_nombre_p, tbPersonal.apellido_p AS tbPersonal_apellido_p, tbTipoContacto.tipo_contacto AS tbTipoContacto_tipo_contacto, tbPersonal.Carnet AS tbPersonal_Carnet FROM dbo.tbPersonal tbPersonal INNER JOIN dbo.tbContactos tbContactos ON tbPersonal.idPersonal = tbContactos.idPersonal INNER JOIN dbo.tbTipoContacto tbTipoContacto ON tbContactos.idTipoContacto = tbTipoContacto.idTipoContacto WHERE tbPersonal.nombre_p LIKE  ? OR tbPersonal.apellido_p LIKE ? OR tbPersonal.Carnet LIKE ?";
                ps = con.prepareStatement(query);
                ps.setString(1, par);
                ps.setString(2, par);
                ps.setString(3, par);
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
