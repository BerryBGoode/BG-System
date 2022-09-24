/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.ComboBox;

import javax.swing.JComboBox;
/**
 *  Personalized control class, extends events and controls depends the needs
 * @author danlo
 * @param <E> String list
 */
public class ComboBoxSuggestion<E>extends JComboBox<E> {

    /**
     *  Set Design
     */
    public ComboBoxSuggestion() {
             setUI(new ComboSuggestionUI()); 
     }
}
