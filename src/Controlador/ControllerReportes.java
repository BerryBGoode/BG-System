/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelReportes;
import java.sql.Connection;

/**
 *
 * @author Rober
 */
public class ControllerReportes {
    private Connection con = ControllerConexion.getConnectionModel();
    ModelReportes objmodel = new ModelReportes();
    
    private String Param;

    public String getParam() {
        return Param;
    }

    public void setParam(String Param) {
        this.Param = Param;
    }
    
    public boolean BuscarEstadoUsuario(){
        return objmodel.BuscarEstadoUsuario(Param, con);
    }
    
    public boolean BuscarTipoUsuario(){
        return objmodel.BuscarTipoUsuario(Param, con);
    }
    
    public boolean BuscarGenero(){
        return objmodel.BuscarGenero(Param, con);
    }
    
    public boolean BuscarGeneroP(){
        return objmodel.BuscarGeneroP(Param, con);
    }
    
    public boolean BuscarTipoPersonal(){
        return objmodel.BuscarTipoPersonal(Param, con);
    }
}
