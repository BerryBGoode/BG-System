/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.ScrollBar;

/**
 *  Personalized Control package
 * @author danlo
 */
import java.awt.Dimension;
import javax.swing.JScrollBar;

/**
 *  Personalized control class, extends events and controls depends the needs
 * @author danlo
 */
public class ScrollBar extends JScrollBar {

    /**
     *  Set Properties to the control
     */
    public ScrollBar() {
        setUI(new ModernScrollBarUI());
        setPreferredSize(new Dimension(5, 5));
        setOpaque(false);
        setUnitIncrement(20);
    }
}
