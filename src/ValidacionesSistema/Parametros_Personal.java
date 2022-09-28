/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesSistema;

import java.util.Date;

/**
 *  This class stored the parameters that will be used in the system.
 * @author hp
 */
public class Parametros_Personal {

    /**
     * Integer variable
     */
    public static int idPersonal;

    /**
     *  String variable
     */
    public static String nombre_personal;

    /**
     *  String variable
     */
    public static String apellido_personal;

    /**
     *  String variable
     */
    public static String fecha_nacimiento;

    /**
     *   String variable
     */
    public static String direccion;

    /**
     *  String variable
     */
    public static String correo;

    /**
     *  String variable
     */
    public static String documento;

    /**
     *  Integer variable
     */
    public static int idTipoDocumento;

    /**
     *   String variable
     */
    public static String TipoDocumento;

    /**
     *   String variable
     */
    public static String TipoPersonal;

    /**
     *   Integer variable
     */
    public static int idTipoPersonal;

    /**
     *   Integer variable
     */
    public static int idGenero;

    /**
     *   String variable
     */
    public static String Genero;

    /**
     *   Integer variable
     */
    public static int idEmpresa;

    /**
     *   String variable
     */
    public static String Carnet;

    /**
     *  Gets the staff type
     * @return a String
     */
    public static String getTipoPersonal() {
        return TipoPersonal;
    }

    /**
     *  Set staff tye 
     * @param TipoPersonal referring to the staff type
     */
    public static void setTipoPersonal(String TipoPersonal) {
        Parametros_Personal.TipoPersonal = TipoPersonal;
    }

    /**
     *  Gets the gender
     * @return a String
     */
    public static String getGenero() {
        return Genero;
    }

    /**
     *  Set the gender
     * @param Genero referring to the gender of the user
     */
    public static void setGenero(String Genero) {
        Parametros_Personal.Genero = Genero;
    }
    
    /**
     *  Gets the document type
     * @return a String
     */
    public static String getTipoDocumento() {
        return TipoDocumento;
    }

    /**
     *  Set the document type
     * @param TipoDocumento referring to the document type
     */
    public static void setTipoDocumento(String TipoDocumento) {
        Parametros_Personal.TipoDocumento = TipoDocumento;
    }

    /**
     *  Gets the staff ID
     * @return an Integer
     */
    public static int getIdPersonal() {
        return idPersonal;
    }

    /**
     * Set the staff ID
     * @param idPersonal referring to the staff ID
     */
    public static void setIdPersonal(int idPersonal) {
        Parametros_Personal.idPersonal = idPersonal;
    }

    /**
     *  Gets the staff name
     * @return a String
     */
    public static String getnombre_personal() {
        return nombre_personal;
    }

    /**
     *  Set the staff name
     * @param nnombre_personal referring to the staff name 
     */
    public static void setnombre_personal(String nnombre_personal) {
        Parametros_Personal.nombre_personal = nnombre_personal;
    }

    /**
     *  Gets the last name of the staff
     * @return a String
     */
    public static String getApellido_personal() {
        return apellido_personal;
    }

    /**
     *  Set the last name 
     * @param apellido_personal referring to the staff last name 
     */
    public static void setApellido_personal(String apellido_personal) {
        Parametros_Personal.apellido_personal = apellido_personal;
    }

    /**
     *  Gets the date
     * @return a String
     */
    public static String getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    /**
     * Set the date
     * @param fecha_nacimiento referring to the date
     */
    public static void setFecha_nacimiento(String fecha_nacimiento) {
        Parametros_Personal.fecha_nacimiento = fecha_nacimiento;
    }

    /**
     *  Gets the address
     * @return a String 
     */
    public static String getDireccion() {
        return direccion;
    }

    /**
     * Set the address
     * @param direccion referring to the address
     */
    public static void setDireccion(String direccion) {
        Parametros_Personal.direccion = direccion;
    }

    /**
     *  Gets the document
     * @return a String
     */
    public static String getDocumento() {
        return documento;
    }

    /**
     *  Set the Document
     * @param documento referring to the document
     */
    public static void setDocumento(String documento) {
        Parametros_Personal.documento = documento;
    }

    /**
     *  Gets the document type ID
     * @return an integer
     */
    public static int getIdTipoDocumento() {
        return idTipoDocumento;
    }

    /**
     *  Set the document type
     * @param idTipoDocumento referring to the document type ID
     */
    public static void setIdTipoDocumento(int idTipoDocumento) {
        Parametros_Personal.idTipoDocumento = idTipoDocumento;
    }

    /**
     *  Gets the type of staff ID
     * @return an Integer
     */
    public static int getIdTipoPersonal() {
        return idTipoPersonal;
    }

    /**
     *  Set the type of staff ID
     * @param idTipoPersonal referring to the type of staff ID
     */
    public static void setIdTipoPersonal(int idTipoPersonal) {
        Parametros_Personal.idTipoPersonal = idTipoPersonal;
    }

    /**
     *  Gets the gender ID
     * @return an Integer
     */
    public static int getIdGenero() {
        return idGenero;
    }

    /**
     *  Set the gender
     * @param idGenero referring to the gender
     */
    public static void setIdGenero(int idGenero) {
        Parametros_Personal.idGenero = idGenero;
    }

    /**
     *  Gets the company's ID
     * @return an Integer
     */
    public static int getIdEmpresa() {
        return idEmpresa;
    }

    /**
     *  Set the company's ID
     * @param idEmpresa referring to the company's ID
     */
    public static void setIdEmpresa(int idEmpresa) {
        Parametros_Personal.idEmpresa = idEmpresa;
    }

    /**
     *  Gets the id - card string
     * @return a String
     */
    public static String getCarnet() {
        return Carnet;
    }

    /**
     *  Set the id - card String
     * @param Carnet referring to the id - card string
     */
    public static void setCarnet(String Carnet) {
        Parametros_Personal.Carnet = Carnet;
    }

    /**
     *  Gets the email
     * @return a String
     */
    public static String getCorreo() {
        return correo;
    }

    /**
     *  Set the email
     * @param correo referring to the email
     */
    public static void setCorreo(String correo) {
        Parametros_Personal.correo = correo;
    }
            
}
