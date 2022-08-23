
package Controlador;

import Modelo.ModelContactos;
import java.sql.*;

/**
 *
 * @author Eam
 */
public class ControllerContactos {
   
    public static int idcontacto;
    public static String contacto;
    public static int idpersonal;
    public static int idtipocontacto;

    public static int getIdcontacto() {
        return idcontacto;
    }

    public static void setIdcontacto(int idcontacto) {
        ControllerContactos.idcontacto = idcontacto;
    }

    public static String getContacto() {
        return contacto;
    }

    public static void setContacto(String contacto) {
        ControllerContactos.contacto = contacto;
    }

    public static int getIdpersonal() {
        return idpersonal;
    }

    public static void setIdpersonal(int idpersonal) {
        ControllerContactos.idpersonal = idpersonal;
    }

    public static int getIdtipocontacto() {
        return idtipocontacto;
    }

    public static void setIdtipocontacto(int idtipocontacto) {
        ControllerContactos.idtipocontacto = idtipocontacto;
    }
    
    
    
    //

    public static ResultSet CargarTablaContactos_Controller() {
        return ModelContactos.CargarTablaContactos();
    }
    
    public static ResultSet CargarTablaPersonal_Controller(){
        return ModelContactos.CargarTablaPersonal();
    }
    
    public static ResultSet CargarCMBTipoContactos_Controller() {
        return ModelContactos.CargarCMBTipoContacto();
    }
    
    public static boolean RegistrarContactos_Controller() {
        return ModelContactos.RegistrarContacto(contacto, idpersonal, idtipocontacto);
    }
    
    public static boolean ActualizarContactos_Controller() {
        return ModelContactos.ActualizarContacto(idcontacto, contacto, idpersonal, idtipocontacto);
    }
    
    public static ResultSet getidContacto(){
        return ModelContactos.capturar_idContacto();
    }
    
    public static ResultSet getidPersonal(){
        return ModelContactos.capturar_idPersonal(contacto);
    }
    
    public static ResultSet getidPersonal_tbPersonal() {
        return ModelContactos.cap_idPersonal_tbPersonal(contacto);
    }
    
    public static boolean EliminarContactos_Controller() {
        return ModelContactos.EliminarContacto(idcontacto);
    }
    
}
