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
public interface SelectedAction {

    /**
     *  Day selected 
     */
    public final int DAY_SELECTED = 1;

    /**
     *  Month Selected
     */
    public final int MONTH_SELECTED = 2;

    /**
     *  Year Selected
     */
    public final int YEAR_SELECTED = 3;

    /**
     *  Start 
     * @return
     */
    public int getAction();
}
