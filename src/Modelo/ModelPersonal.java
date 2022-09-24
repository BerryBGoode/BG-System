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
public class ModelPersonal {
    //Comentario de prueba 1.1 - DanielLopez
       PreparedStatement ps;
    Connection con;

    public ResultSet MostrarProfesores() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM vwProfesores";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public ResultSet MostrarEstudiantes() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM vwAlumnos";
            ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean IngresarProfesores(String nombre, String apellido, String fecha, String correo, String direccion, String documento, int tipodoc, int tipopersonal,int genero, int empresa) {
        try {
            con = ModelConexion.getConnection();
            String query = "INSERT INTO tbPersonal (nombre_p, apellido_p, fecha_nacimiento, correo, direccion, documento, idTipoDocumento,idTipoPersonal, idGenero,idEmpresa) VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, fecha);
            ps.setString(4, correo);
            ps.setString(5, direccion);
            ps.setString(6, documento);
            ps.setInt(7, tipodoc);
            ps.setInt(8, tipopersonal);
            ps.setInt(9, genero);
            ps.setInt(10, empresa);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar Personal", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            return false;
        }
    }

    public boolean IngresarEstudiantes(String nombre, String apellido, String fecha, String correo, String direccion, String documento, int tipodoc, int genero, int empresa) {
        int tipopersonal = 4;
        try {
            con = ModelConexion.getConnection();
            String query = "INSERT INTO tbPersonal (nombre_p, apellido_p, fecha_nacimiento, correo, direccion, documento, idTipoDocumento,idTipoPersonal, idGenero,idEmpresa) VALUES (?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(query);
            ps.setString(1, nombre);
            ps.setString(2, apellido);
            ps.setString(3, fecha);
            ps.setString(4, correo);
            ps.setString(5, direccion);
            ps.setString(6, documento);
            ps.setInt(7, tipodoc);
            ps.setInt(8, tipopersonal);
            ps.setInt(9, genero);
            ps.setInt(10, empresa);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al ingresar un Alumno", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            return false;
        }
    }
    public boolean AgregarCarnet(int id,String carnet){
        try {
            con=ModelConexion.getConnection();
            String query="UPDATE tbPersonal SET Carnet=? WHERE idPersonal=?";
            ps=con.prepareStatement(query);
            ps.setString(1, carnet);
            ps.setInt(2, id);
            ps.execute();
            return true;
        } catch (Exception e) {
            System.out.println("Error al realizar proceso con la base"+e.toString());
            return false;
        }
    }

    public ResultSet CargarGenero() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM tbGeneros";
            ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public ResultSet CargarTipodOC() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM tbTipoDocumento";
            ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public ResultSet CargarTipoP() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM tbTipoPersonal WHERE tipo_personal!='Alumnos'";
            ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public ResultSet capturaridpersonal(String nombrep) {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT idPersonal FROM tbPersonal WHERE nombre_p=?";
            ps = con.prepareStatement(query);
            ps.setString(1, nombrep);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error en el modelo " + e.toString());
            return null;
        }
    }

    public ResultSet getidEmpresa() {
        try {
            con = ModelConexion.getConnection();
            ps = con.prepareStatement("SELECT idEmpresa FROM tbEmpresas");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
            return null;
        }
    }
    
    public boolean ActualizarAlumno(int idpersonal,String nombrep,String apellidop,String correo,String direccion,String documento,int idtipodoc,int idgenero,int idempresa){
        int idtipop=4;
        try {
            con=ModelConexion.getConnection();
            String query="UPDATE tbPersonal SET nombre_p=?,apellido_p=?,correo=?,direccion=?,documento=?,idTipoDocumento=?,idTipoPersonal=?,idGenero=?,idEmpresa=? WHERE idPersonal=?";
            ps=con.prepareStatement(query);
            ps.setString(1, nombrep);
            ps.setString(2, apellidop);
            ps.setString(3, correo);
            ps.setString(4, direccion);
            ps.setString(5, documento);
            ps.setInt(6, idtipodoc);
            ps.setInt(7, idtipop);
            ps.setInt(8, idgenero);
            ps.setInt(9, idempresa);
            ps.setInt(10, idpersonal);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se logro completar el proceso de actualizacion","ERROR Actualizar",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            return false;
        }
    }
    public boolean ActualizarPersonal(int idpersonal,String nombrep,String apellidop,String correo,String direccion,String documento,int idtipodoc,int idgenero,int idempresa,int idtipop){
        try {
            con=ModelConexion.getConnection();
            String query="UPDATE tbPersonal SET nombre_p=?,apellido_p=?,correo=?,direccion=?,documento=?,idTipoDocumento=?,idTipoPersonal=?,idGenero=?,idEmpresa=? WHERE idPersonal=?";
            ps=con.prepareStatement(query);
            ps.setString(1, nombrep);
            ps.setString(2, apellidop);
            ps.setString(3, correo);
            ps.setString(4, direccion);
            ps.setString(5, documento);
            ps.setInt(6, idtipodoc);
            ps.setInt(7, idtipop);
            ps.setInt(8, idgenero);
            ps.setInt(9, idempresa);
            ps.setInt(10, idpersonal);
            ps.execute();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se logro completar el proceso de actualizacion","ERROR Actualizar",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            return false;
        }
    }
    public boolean EliminarRegistro(int idpersonal){
        try {
            con=ModelConexion.getConnection();
            String query="DELETE tbPersonal WHERE idPersonal=?";
            ps=con.prepareStatement(query);
            ps.setInt(1, idpersonal);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar el registro","Error al Eliminar",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            return false;
        }
    }

}
