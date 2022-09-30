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
 * This class stores all the sentences necessary for the correct functioning of
 * the searchers section
 *
 * @author danlo
 */
public class ModelBuscador {

    Connection con;
    PreparedStatement ps;

    /**
     * Load the information of the view
     *
     * @param Carnet referring to the id - card
     * @return a ResultSet
     */
    public ResultSet ResPersonal(String Carnet) {

        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * FROM vwProfesores WHERE documento LIKE  ?";
            ps = con.prepareStatement(cons);
            ps.setString(1, "%" + Carnet + "%");

            ResultSet res = ps.executeQuery();
            return res;

        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo ResPersonal", 2);
            return null;
        }
    }

    /**
     *  Load the information of the view by a parameter
     * @param nombre referring to the parameter
     * @return a ResultSet
     */
    public ResultSet ResUsuarios(String nombre) {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * FROM vwUsuarios WHERE nombre_usuario LIKE ?";
            ps = con.prepareStatement(cons);
            ps.setString(1, "%" + nombre + "%");
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo ResUsuarios", 2);
            return null;
        }
    }

    /**
     *  Load the information of the view by a parameter
     * @param Identificacion referring to the parameter
     * @return a ResultSet
     */
    public ResultSet ResCarnet(String Identificacion) {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * FROM vwPConCarnet WHERE nombre_p + apellido_p LIKE ?";
            ps = con.prepareStatement(cons);
            ps.setString(1, "%" + Identificacion + "%");
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo ResCarnet", 2);
            return null;
        }
    }

    /**
     *  Load the information of the view by a parameter
     * @param Carnet referring to the parameter
     * @return a ResultSet
     */
    public ResultSet ResEstudiantes(String Carnet) {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * FROM vwAlumnos WHERE Carnet LIKE ?";
            ps = con.prepareStatement(cons);
            ps.setString(1, "%" + Carnet + "%");
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo ResEstudiantes", 2);
            return null;
        }
    }

    /**
     *  Load the information of the view by a parameter
     * @param Placa referring to the parameter
     * @return a ResultSet
     */
    public ResultSet ResVeh(String Placa) {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * FROM vwVehiculos_g WHERE placa LIKE ?";
            ps = con.prepareStatement(cons);
            ps.setString(1, "%" + Placa + "%");
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo ResVeh", 2);
            return null;
        }
    }

    /**
     *  Load the information of the view by a parameter
     * @param cont referring to the parameter
     * @return a ResultSet
     */
    public ResultSet ResCon(String cont) {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * FROM vwContactos WHERE contacto LIKE ?";
            ps = con.prepareStatement(cons);
            ps.setString(1, "%" + cont + "%");
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo ResCon", 2);
            return null;
        }
    }

    /**
     *  Load the information of the view by a parameter
     * @return a ResultSet
     */
    public ResultSet GraficaAccesos() {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * from vwAccesos WHERE idTipoAcceso = 1";
            ps = con.prepareStatement(cons);
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo GraficaAccesos", 2);
            return null;
        }
    }

    /**
     *  Load the information of the view by a parameter
     * @return a ResultSet
     */
    public ResultSet GraficaSalidas() {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * from vwAccesos WHERE idTipoAcceso = 2";
            ps = con.prepareStatement(cons);
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo GraficaAccesos", 2);
            return null;
        }
    }

    /**
     *   Load the information of the view by a parameter
     * @param park referring to the parameter
     * @return a ResultSet
     */
    public ResultSet ResPark(String park) {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * FROM vwDetalle_Estacionamientos WHERE placa LIKE ?";
            ps = con.prepareStatement(cons);
            ps.setString(1, "%" + park + "%");
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo ResPark", 2);
            return null;
        }
    }
    
    /**
     *  Load the information of the view by a parameter
     * @return a ResultSet
     */
    public ResultSet CargarAdmins() {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * from tbUsuarios WHERE idTipoUsuario = 2";
            ps = con.prepareStatement(cons);
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo GraficaAccesos", 2);
            return null;
        }
    }
    
    /**
     *  Load the information of the view by a parameter
     * @return a ResultSet
     */
    public ResultSet CargarProfes() {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * from tbUsuarios WHERE idTipoUsuario = 3";
            ps = con.prepareStatement(cons);
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo GraficaAccesos", 2);
            return null;
        }
    }
    
    /**
     *  Load the information of the view by a parameter
     * @return a ResultSet
     */
    public ResultSet CargarAlumnos() {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * from tbUsuarios WHERE idTipoUsuario = 4";
            ps = con.prepareStatement(cons);
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo GraficaAccesos", 2);
            return null;
        }
    }
    
    /**
     *  Load the information of the view by a parameter
     * @return a ResultSet
     */
    public ResultSet CargarSeguridad() {
        try {
            con = ModelConexion.getConnection();
            String cons = "SELECT * from tbUsuarios WHERE idTipoUsuario = 5";
            ps = con.prepareStatement(cons);
            ResultSet res = ps.executeQuery();
            return res;
        } catch (SQLException e) {
            System.out.println(e.toString());
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al buscar los registros dentro de la base", "Verifique la clase ModelSearch - Metodo GraficaAccesos", 2);
            return null;
        }
    }
}
