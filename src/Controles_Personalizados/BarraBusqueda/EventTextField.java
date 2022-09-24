/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.BarraBusqueda;

/**
 *  Event for other functions
 * @author danlo
 */
public interface EventTextField {

    /**
     *  Start the event
     * @param call
     */
    public void onPressed(EventCallBack call);

    /**
     *  Cancel the Event
     */
    public void onCancel();
}
