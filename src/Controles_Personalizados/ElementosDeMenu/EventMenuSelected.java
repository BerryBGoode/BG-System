/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.ElementosDeMenu;

/**
 *  Personalized Control package
 * @author danlo
 */
public interface EventMenuSelected {

    /**
     *  Event
     * @param index Index of menu
     * @param indexSubMenu Index SubMenu
     */
    public void menuSelected(int index, int indexSubMenu);
}
