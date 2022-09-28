
package Controlador;

import Modelo.ModelContactos;
import java.sql.*;

/**
 *  This class stores and connects the ModelContactos with the view, and makes possible the communication between both
 * @author Eam
 */
public class ControllerContactos {
   
    /**
     * Integer variable idcontacto
     */
    public static int idcontacto;

    /**
     *  String variable contacto
     */
    public static String contacto;

    /**
     * Integer variable idpersonal
     */
    public static int idpersonal;

    /**
     *  Integer variable idtipocontacto
     */
    public static int idtipocontacto;

    /**
     *  Gets the id of the contact register 
     * @return an Integer
     */
    public static int getIdcontacto() {
        return idcontacto;
    }

    /**
     *  Set the contact id
     * @param idcontacto referring to the contact identifier
     */
    public static void setIdcontacto(int idcontacto) {
        ControllerContactos.idcontacto = idcontacto;
    }

    /**
     *  Gets the contact information
     * @return a String
     */
    public static String getContacto() {
        return contacto;
    }

    /**
     *  Set the contact information
     * @param contacto referring to the different text strings that refer to a contact
     */
    public static void setContacto(String contacto) {
        ControllerContactos.contacto = contacto;
    }

    /**
     *  Gets the id of the staff
     * @return an Integer
     */
    public static int getIdpersonal() {
        return idpersonal;
    }

    /**
     *  Set the id of the staff in the registers of contacts
     * @param idpersonal referring to the identifier of the staff
     */
    public static void setIdpersonal(int idpersonal) {
        ControllerContactos.idpersonal = idpersonal;
    }

    /**
     *  Gets the type of contacts avaliable in the system
     * @return an Integer
     */
    public static int getIdtipocontacto() {
        return idtipocontacto;
    }

    /**
     *  Set the types of contacts available in the system
     * @param idtipocontacto referring to the types of contacts avaliable in the system
     */
    public static void setIdtipocontacto(int idtipocontacto) {
        ControllerContactos.idtipocontacto = idtipocontacto;
    }

    /**
     *  Load the table of contact registers in the view package
     * @return a ResultSet
     */

    public static ResultSet CargarTablaContactos_Controller() {
        return ModelContactos.CargarTablaContactos();
    }
    
    /**
     *  Load the table of staff in the view package
     * @return a ResultSet
     */
    public static ResultSet CargarTablaPersonal_Controller(){
        return ModelContactos.CargarTablaPersonal();
    }
    
    /**
     *  Fill the contact type Combobox in the view package
     * @return a ResultSet
     */
    public static ResultSet CargarCMBTipoContactos_Controller() {
        return ModelContactos.CargarCMBTipoContacto();
    }
    
    /**
     *  Save new contact registers
     * @return a Boolean
     */
    public static boolean RegistrarContactos_Controller() {
        return ModelContactos.RegistrarContacto(contacto, idpersonal, idtipocontacto);
    }
    
    /**
     *  Update contact registers
     * @return a Boolean
     */
    public static boolean ActualizarContactos_Controller() {
        return ModelContactos.ActualizarContacto(idcontacto, contacto, idpersonal, idtipocontacto);
    }
    
    /**
     *  Gets the contact id 
     * @return a ResultSet
     */
    public static ResultSet getidContacto(){
        return ModelContactos.capturar_idContacto();
    }
    
    /**
     *  Gets the staff id
     * @return a ResultSet
     */
    public static ResultSet getidPersonal(){
        return ModelContactos.capturar_idPersonal(contacto);
    }
    
    /**
     * Capture the ID of the staff passing the contact as a parameter
     * @return a ResultSet
     */
    public static ResultSet getidPersonal_tbPersonal() {
        return ModelContactos.cap_idPersonal_tbPersonal(contacto);
    }
    
    /**
     * Delete contact registers
     * @return a Boolean
     */
    public static boolean EliminarContactos_Controller() {
        return ModelContactos.EliminarContacto(idcontacto);
    }
    
}
