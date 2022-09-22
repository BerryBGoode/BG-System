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
 *
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
     * Metodo para obtener el IDEmpresa
     * @return 
     */
    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    /**
     * Metodo para establecer el IDEmpresa
     * @param idEmpresa 
     */
    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    /**
     * Metodo para obtener el nombre de la empresa
     * @return 
     */
    public String getNombre_empresa() {
        return nombre_empresa;
    }

    /**
     * Metodo para establecer el nombre de la empresa
     * @param nombre_empresa 
     */
    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    /**
     * Metodo para obtener el nombre del representante legal
     * @return 
     */
    public String getRepresentante() {
        return representante;
    }

    /**
     * Metodo para establecer el nombre del representante legal
     * @param representante 
     */
    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    /**
     * Metodo para obtener la dirección de la empresa
     * @return 
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Metodo para establecer la dirección de la empresa
     * @param direccion 
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Metodo para obtener el NIT
     * @return 
     */
    public String getNit() {
        return nit;
    }

    /**
     * Metodo para establecer el NIT
     * @param nit 
     */
    public void setNit(String nit) {
        this.nit = nit;
    }

    /**
     * Metodo para obtener el CNR
     * @return 
     */
    public String getCnr() {
        return cnr;
    }

    /**
     * Metodo para establecer el CNR
     * @param cnr 
     */
    public void setCnr(String cnr) {
        this.cnr = cnr;
    }

    /**
     * Metodo para obtener el logo de la empresa
     * @return 
     */
    public byte[] getLogo() {
        return logo;
    }

    /**
     * Metodo para establecer el logo de la empresa
     * @param logo 
     */
    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
   
    /**
     * Metodo para comprobar si existe una empresa en la base de datos
     * @return 
     */
    public boolean checkEnterprise(){
        return ModelpEmpresa.checkEnterprise();
    }
    
    /**
     * Metodo para ingresar una empresa
     * @return 
     */
    public boolean IngresarP_EmpresaController(){
        return ModelpEmpresa.IngresarPEmpresa(nombre_empresa, representante, direccion, nit, cnr,logo);
    }
}
