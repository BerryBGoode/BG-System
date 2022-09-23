/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ModelCorreo;
import java.sql.ResultSet;

/**
 *
 * @author danlo
 */
public class ControllerCorreo {
    
    //Variable String que contiene el usuario recibido
    public String Usuario;

    //Gettter  correspondientes a la variable Usuario
    public String getUsuario() {
        return Usuario;
    }
    //Setter correspondientes a la variable Usuario
    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
    public String Correo;

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }
    
    public String Clave;

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    public int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    //Objeto de la clase ModelCorreo (Nos brinda acceso a los metodos contenidos en dicha clase)
    ModelCorreo mdlCorreo = new ModelCorreo();
    
    //Metodo de retorno del Resultset
    public ResultSet Recuperar(){
        
        //return: Devuelve algo.
        //mdlCorreo: Objeto de la clase ModelCorreo.
        //.Recuperar: Nombre del metodo que se retorna desde el modelo.
        //(Usuario): Devolvemos la variable que contiene la informacion que se enviara como parametro en el modelo.
        return mdlCorreo.Recuperar(Usuario);
    }
    
    public ResultSet capturar()
    {
        return mdlCorreo.CapDatos(Correo);
    }
    
    public boolean Actualizar()
    {
        return ModelCorreo.ActualizarContra(id, Clave);
    }
    
    public ResultSet ComprobarCorreo()
    {
        return mdlCorreo.CapCorreo(id);
    }
            public ResultSet CapId()
    {
        return mdlCorreo.CapturarIdPersonal(Correo);
    }

}
