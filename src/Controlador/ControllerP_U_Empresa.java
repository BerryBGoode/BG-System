/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelP_U_Empresa;
import static com.oracle.jrockit.jfr.ContentType.Bytes;
import com.sun.org.apache.bcel.internal.util.ByteSequence;
import java.sql.ResultSet;

/**
 *  This class stores and connects the ModelP_U_Empresa with the view, and makes possible the communication between both
 * @author Ander
 */
public class ControllerP_U_Empresa {
    ModelP_U_Empresa ModelpEmpresa=new ModelP_U_Empresa();
    
    public Integer idEmpresa;
    public String nombre_empresa;
    public String representante;
    public String direccion;
    public String nit;
    public String cnr;
    public byte [] logo;

    /**
     * Method to obtain the company ID
     * @return an Integer
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Method to establish the company ID
     * @param idEmpresa referring to the company ID
     */
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * Method to get company name
     * @return a String 
     */
    public String getNombre_empresa() {
        return nombre_empresa;
    }

    /**
     * Method to set the company name
     * @param nombre_empresa referring to the company name
     */
    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    /**
     * Method to obtain the name of the legal representative
     * @return a String
     */
    public String getRepresentante() {
        return representante;
    }

    /**
     * Method to establish the name of the legal representative
     * @param representante referring to the representative name
     */
    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    /**
     * Method to obtain the address of the company
     * @return a String
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Method to establish the address of the company
     * @param direccion referring to the address of the company
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Method to obtain the NIT
     * @return a String
     */
    public String getNit() {
        return nit;
    }

    /**
     * Method to establish the NIT
     * @param nit referring to the type of document 
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Method to obtain the CNR
     * @return a String
     */
    public String getCnr() {
        return cnr;
    }

    /**
     * Method to establish the CNR
     * @param cnr referring to the register number of the company
     */
    public void setCnr(String cnr) {
        this.cnr = cnr;
    }

    /**
     * Method to obtain the company logo
     * @return a Byte[]
     */
    public byte[] getLogo() {
        return logo;
    }

    /**
     * Method to establish the company logo
     * @param logo referring to the company logo
     */
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
   
    /**
     * Method to check if a company exists in the database
     * @return a Boolean
     */
    public boolean checkEnterprise(){
        return ModelpEmpresa.checkEnterprise();
    }
    
    /**
     * Method to register a company
     * @return a Boolean
     */
    public boolean IngresarP_EmpresaController(){
        return ModelpEmpresa.IngresarPEmpresa(nombre_empresa, representante, direccion, nit, cnr,logo);
    }
}
