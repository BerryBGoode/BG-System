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
public class ModelCorreo {

    public ResultSet Recuperar(String Correo) {

        //Variable de conexion
        Connection con;

        //Variable de un PreparedStatement (Consulta)
        PreparedStatement ps;

        //Estructuctura Try-Catch para detectar errores de procesamiento 
        try {
            //Igualamos la variable de conexion con el metodo respectivo para poder conectarnos a la base de datos.
            con = ModelConexion.getConnection();
            //Definimos una variable tipo String que contiene la consulta que enviaremos a la base de datos.
            //Implementamos INNER-JOIN entre tablas debido a que la informacion se encuentra en tablas diferentes.
            String cons = "SELECT u.nombre_usuario FROM tbPersonal p, tbUsuarios u WHERE p.idPersonal = u.idPersonal AND p.correo = ?";
            //Ejecutamos la sentencia preparada o "preparedStatement" y enviamos la variable que contiene la consulta.
            ps = con.prepareStatement(cons);
            //Asignamos la informacion por posiciones pasando parametros establecidos en el metodo creado (En este caso solo seria el usuario porque es el parametro que se solicita para la busqueda).
            ps.setString(1, Correo);
            //Luego con el ResultSet (Conjunto de resultados encontrados en una consulta) le ordenamos a "ps" que ejecute la consulta.
            ResultSet res = ps.executeQuery();
            //retornamos el Resultset.
            return res;

        } catch (Exception e) {
            //Notificacion en caso de falla.
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error en consulta", "Verifique la clase ModelCorreo", 2);
            //Retonamos null, es decir un ResultSet vacio.
            return null;
        }
    }

    public ResultSet CapDatos(String correo) {
        //Variable de conexion
        Connection con;

        //Variable de un PreparedStatement (Consulta)
        PreparedStatement ps;

        try {

            con = ModelConexion.getConnection();
            String cont = "SELECT u.idUsuario,u.nombre_usuario, u.contraseña FROM tbPersonal p, tbUsuarios u WHERE p.idPersonal = u.idPersonal AND p.correo = ?";
            ps = con.prepareStatement(cont);

            ps.setString(1, correo);

            ResultSet res = ps.executeQuery();
            return res;

        } catch (Exception e) {
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error en consulta", "Verifique la clase ModelCorreo", 2);
            return null;
        }

    }

    public static boolean ActualizarContra(int id, String contra) {
        Connection con;
        PreparedStatement ps;
        int Estado = 1;
        int intentos = 5;
        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("UPDATE tbUsuarios SET idEstadoUsuario = ? , contraseña = ?, intentos = ? WHERE idUsuario = ?");
            ps.setInt(1, Estado);
            ps.setString(2, contra);
            ps.setInt(3, intentos);
            ps.setInt(4, id);
            ps.execute();

            return true;
        } catch (SQLException e) {
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error de actualizacion", "Verifique la clase ModelCorreo", 2);
            System.out.println(e);
            return false;
        }
    }

    public ResultSet CapCorreo(int id) {
        //Variable de conexion
        Connection con;

        //Variable de un PreparedStatement (Consulta)
        PreparedStatement ps;

        try {

            con = ModelConexion.getConnection();
            String cont = "SELECT correo FROM tbPersonal  WHERE idPersonal =? ";
            ps = con.prepareStatement(cont);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            return res;

        } catch (SQLException e) {
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error en consulta", "Verifique la clase ModelCorreo", 2);
            System.out.println(e.toString());
            return null;
        }

    }

    public ResultSet CapturarIdPersonal(String Correo) {
        //Variable de conexion
        Connection con;

        //Variable de un PreparedStatement (Consulta)
        PreparedStatement ps;

        try {

            con = ModelConexion.getConnection();
            String cont = "SELECT idPersonal FROM tbPersonal WHERE correo=?";
            ps = con.prepareStatement(cont);
            ps.setString(1, Correo);
            ResultSet res = ps.executeQuery();
            return res;

        } catch (SQLException e) {
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error en consulta", "Verifique la clase ModelCorreo", 2);
            System.out.println(e.toString());
            return null;
        }
    }

}
