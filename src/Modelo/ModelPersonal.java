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
 *  This class stores all the sentences necessary for the correct functioning of the Personal section
 * @author danlo
 */
public class ModelPersonal {
    //Comentario de prueba 1.1 - DanielLopez
       PreparedStatement ps;
    Connection con;

    /**
     * Load the table with the information of the view
     * @return a ResultSet
     */
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

    /**
     *  Load the table with the information of the view
     * @return a ResultSet
     */
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

    /**
     * Save staff (general)
     * @param nombre referring to the names of the staff
     * @param apellido referring to the last names of the staff
     * @param fecha referring to the birth date 
     * @param correo referring to the email 
     * @param direccion referring to the address
     * @param documento referring to the document
     * @param tipodoc referring to the document type
     * @param tipopersonal referring to the staff type 
     * @param genero referring to the gender 
     * @param empresa referring to the company
     * @return a Boolean
     */
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

    /**
     *  Save staff (students)
     * @param nombre referring the names
     * @param apellido referring the last names
     * @param fecha referring the birth date
     * @param correo referring the email
     * @param direccion referring the address
     * @param documento referring the document
     * @param tipodoc referring the document type
     * @param genero referring the gender
     * @param empresa referring the company
     * @return a Boolean
     */
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

    /**
     *  Updates the id - card of the staff
     * @param id referring to the ID
     * @param carnet referring to the id - card
     * @return a Boolean
     */
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

    /**
     *  Load the genders
     * @return a ResultSet
     */
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

    /**
     *  Load the documents type
     * @return a ResultSet
     */
    public ResultSet CargarTipodOC() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM tbTipoDocumento";
            ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    /**
     *  Load staff type 
     * @return a ResultSet
     */
    public ResultSet CargarTipoP() {
        try {
            con = ModelConexion.getConnection();
            String query = "SELECT * FROM tbTipoPersonal WHERE tipo_personal!='Alumnos'";
            ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    /**
     *  Capture the staff ID
     * @param nombrep referring to the name of the staff
     * @return a ResultSet
     */
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

    /**
     *  Gets the company ID
     * @return a ResultSet
     */
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
    
    /**
     *  Update the staff(students)
     * @param idpersonal referring to ID
     * @param nombrep referring to names
     * @param apellidop referring to last names
     * @param correo referring to email
     * @param direccion referring to address
     * @param documento referring to document
     * @param idtipodoc referring to document type
     * @param idgenero referring to gender
     * @param idempresa referring to company
     * @return a Boolean
     */
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

    /**
     *  Update the staff(general)
     * @param idpersonal referring to ID
     * @param nombrep referring to names
     * @param apellidop referring to last names
     * @param correo referring to email
     * @param direccion referring to address
     * @param documento referring to document
     * @param idtipodoc referring to document type
     * @param idgenero referring to gender
     * @param idempresa referring to company
     * @param idtipop referring staff type
     * @return a Boolean
     */
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

    /**
     *  Delete the information stored in the database 
     * @param idpersonal referring the ID
     * @return a Boolean
     */
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

    /**
     * Gets the type of document according to id
     * @param ID referring the ID (idTipoDocumento)
     * @return a ResultSet
     */
    public ResultSet TipoDocumento(int ID){
            try{
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
    
    /**
     * Sets the carnets to people who do not have one
     * @param idpersonal referring the ID (idPersonal)
     * @return 
     */
    public boolean GenerarCarnetsTodos(){
        try {
            con=ModelConexion.getConnection();
            String query="EXEC carnettodos";
            ps=con.prepareStatement(query);
            ps.execute();
            return true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al llenar los carnets","Error al actualizar",JOptionPane.ERROR_MESSAGE);
            System.out.println(e.toString());
            return false;
        }
    }
}
