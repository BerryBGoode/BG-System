/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.ComboBox;

import javax.swing.JComboBox;
/**
 *
 * @author danlo
 */
public class ComboBoxSuggestion<E>extends JComboBox<E> {
     public ComboBoxSuggestion() {
             setUI(new ComboSuggestionUI()); 
     }
}
