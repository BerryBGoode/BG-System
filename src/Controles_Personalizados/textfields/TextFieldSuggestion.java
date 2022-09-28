/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.textfields;

/**
 *  Personalized Control package
 * @author danlo
 */
import javax.swing.JTextField;

/**
 *  Personalized control class, extends events and controls depends the needs
 * @author danlo
 */
public class TextFieldSuggestion extends JTextField {

    private TextFieldSuggestionUI textUI;

    /**
     * Suggestions 
     */
    public TextFieldSuggestion() {
        textUI = new TextFieldSuggestionUI(this);
        setUI(textUI);
    }

    /**
     *  add item
     * @param text String
     */
    public void addItemSuggestion(String text) {
        textUI.getItems().add(text);
    }

    /**
     *  remove item
     * @param text String
     */
    public void removeItemSuggestion(String text) {
        textUI.getItems().remove(text);
    }

    /**
     *  Clear item
     */
    public void clearItemSuggestion() {
        textUI.getItems().clear();
    }

    /**
     * Round
     * @param round round 
     */
    public void setRound(int round) {
        textUI.setRound(round);
    }

    /**
     *  Gets Round
     * @return round
     */
    public int getRound() {
        return textUI.getRound();
    }

}
