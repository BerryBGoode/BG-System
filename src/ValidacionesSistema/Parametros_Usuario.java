/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesSistema;

/**
 *  This class stored the parameters that will be used in the system.
 * @author hp
 */
public class Parametros_Usuario {
    
    private static int ID;
    private static int idPersonal;
    private static String nombre_usuario;
    private static int idTipoUsuario;
    private static int idEstadoUsuario;
    private static byte[] imagen;
    
    /**
     *Gets the ID
     * @return an Integer
     */
    public static int getID() {
        return ID;
    }

    /**
     *  Set the ID
     * @param ID referring the ID
     */
    public static void setID(int ID) {
        Parametros_Usuario.ID = ID;
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
        Parametros_Usuario.idPersonal = idPersonal;
    }

    /**
     *  Gets the username
     * @return a String
     */
    public static String getNombre_usuario() {
        return nombre_usuario;
    }

    /**
     *  Set the username
     * @param nombre_usuario referring to the username 
     */
    public static void setNombre_usuario(String nombre_usuario) {
        Parametros_Usuario.nombre_usuario = nombre_usuario;
    }

    /**
     *  Gets the user type ID
     * @return an Integer
     */
    public static int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    /**
     *Set the user type ID
     * @param idTipoUsuario referring to the user type ID
     */
    public static void setIdTipoUsuario(int idTipoUsuario) {
        Parametros_Usuario.idTipoUsuario = idTipoUsuario;
    }

    /**
     *  Gets the status ID of the User
     * @return an Integer
     */
    public static int getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    /**
     *  Set the status ID of the user
     * @param idEstadoUsuario referring to the status ID
     */
    public static void setIdEstadoUsuario(int idEstadoUsuario) {
        Parametros_Usuario.idEstadoUsuario = idEstadoUsuario;
    }

    /**
     *  Gets the user's Image
     * @return a Byte[]
     */
    public static byte[] getImagen() {
        return imagen;
    }

    /**
     *  Set the user image
     * @param imagen referring to the image
     */
    public static void setImagen(byte[] imagen) {
        Parametros_Usuario.imagen = imagen;
    }
}
