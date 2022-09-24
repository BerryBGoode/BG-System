/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.Calendario;

/**
 *  Personalized Control package
 * @author danlo
 */
import java.awt.event.MouseEvent;

/**
 *  Event
 * @author danlo
 */
public interface Event {

    /**
     * Execute the event
     * @param evt event
     * @param num time
     */
    public void execute(MouseEvent evt, int num);
}
