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

/**
 * This class stores all the sentences necessary for the correct functioning of the QR recovery process
 * @author hp
 */
public class ModelQR {
            Connection con;
        PreparedStatement ps;
        ResultSet rs;

    /**
     *  Recover the information stored in the database with a parameter
     * @param Usuario referring to the username 
     * @return a ResultSet
     */
    public  ResultSet ReucContraQR(String Usuario) {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT a.idUsuario,a.nombre_usuario,b.Carnet FROM tbUsuarios a, tbPersonal b Where nombre_usuario=? COLLATE SQL_Latin1_General_CP1_CS_AS AND a.idPersonal=b.idPersonal";
            ps = con.prepareStatement(query);
            ps.setString(1, Usuario);
            rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

}
