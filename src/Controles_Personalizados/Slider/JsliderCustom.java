/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.Slider;

/**
 *  Personalized Control package
 * @author danlo
 */
import java.awt.Color;
import javax.swing.JSlider;

/**
 *  Personalized control class, extends events and controls depends the needs
 * @author danlo
 */
public class JsliderCustom extends JSlider {

    /**
     *  Set the properties to the Slider
     */
    public JsliderCustom() {
        setOpaque(false);
        setBackground(new Color(180, 180, 180));
        setForeground(new Color(69, 124, 235));
        setUI(new JSliderUI(this));
    }
}
