/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.Calendario;

/**
 *
 * @author danlo
 */
import java.awt.event.MouseEvent;

public interface Event {

    public void execute(MouseEvent evt, int num);
}
