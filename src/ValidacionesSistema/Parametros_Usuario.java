/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesSistema;

/**
 *
 * @author hp
 */
public class Parametros_Usuario {
    
    private static int ID;
    private static int idPersonal;
    private static String nombre_usuario;
    private static int idTipoUsuario;
    private static int idEstadoUsuario;
    private static byte[] imagen;
    
    public static int getID() {
        return ID;
    }

    public static void setID(int ID) {
        Parametros_Usuario.ID = ID;
    }

    public static int getIdPersonal() {
        return idPersonal;
    }

    public static void setIdPersonal(int idPersonal) {
        Parametros_Usuario.idPersonal = idPersonal;
    }

    public static String getNombre_usuario() {
        return nombre_usuario;
    }

    public static void setNombre_usuario(String nombre_usuario) {
        Parametros_Usuario.nombre_usuario = nombre_usuario;
    }

    public static int getIdTipoUsuario() {
        return idTipoUsuario;
    }

    public static void setIdTipoUsuario(int idTipoUsuario) {
        Parametros_Usuario.idTipoUsuario = idTipoUsuario;
    }

    public static int getIdEstadoUsuario() {
        return idEstadoUsuario;
    }

    public static void setIdEstadoUsuario(int idEstadoUsuario) {
        Parametros_Usuario.idEstadoUsuario = idEstadoUsuario;
    }

    public static byte[] getImagen() {
        return imagen;
    }

    public static void setImagen(byte[] imagen) {
        Parametros_Usuario.imagen = imagen;
    }
}
