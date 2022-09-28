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
public interface EventDateChooser {

    /**
     *  Date selected
     * @param action action start
     * @param date date
     */
    public void dateSelected(SelectedAction action, SelectedDate date);
}
