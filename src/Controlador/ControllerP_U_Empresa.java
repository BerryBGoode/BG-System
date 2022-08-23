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
 * @author danlo
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

    public Integer getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Integer idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre_empresa() {
        return nombre_empresa;
    }

    public void setNombre_empresa(String nombre_empresa) {
        this.nombre_empresa = nombre_empresa;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getCnr() {
        return cnr;
    }

    public void setCnr(String cnr) {
        this.cnr = cnr;
    }

    public byte[] getLogo() {
        return logo;
    }

    public void setLogo(byte[] logo) {
        this.logo = logo;
    }
   
    public boolean checkEnterprise(){
        return ModelpEmpresa.checkEnterprise();
    }
    
    public boolean IngresarP_EmpresaController(){
        return ModelpEmpresa.IngresarPEmpresa(nombre_empresa, representante, direccion, nit, cnr,logo);
    }
}
