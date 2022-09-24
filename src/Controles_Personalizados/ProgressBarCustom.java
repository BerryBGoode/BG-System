/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados;

/**
 *  Personalized Control package
 * @author danlo
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JProgressBar;
import javax.swing.plaf.basic.BasicProgressBarUI;

/**
 *  Personalized control class, extends events and controls depends the needs 
 * @author danlo
 */
public class ProgressBarCustom extends JProgressBar {
    
    /**
     *  Gets the Color
     * @return Color
     */
    public Color getColorString() {
        return colorString;
    }
    
    /**
     *  Set the Color
     * @param colorString referring to the Color
     */
    public void setColorString(Color colorString) {
        this.colorString = colorString;
    }
    
    private Color colorString = new Color(0, 0, 0);
    
    /**
     *  Validates properties of the control
     */
    public ProgressBarCustom() {
        setPreferredSize(new Dimension(100, 5));
        setBackground(new Color(77, 77, 77));
        setForeground(new Color(190, 190, 190));
        setUI(new BasicProgressBarUI() {
            
            @Override
            protected void paintString(Graphics grphcs, int i, int i1, int i2, int i3, int i4, Insets insets) {
                grphcs.setColor(getColorString());
                super.paintString(grphcs, i, i1, i2, i3, i4, insets);
            }
        });
    }
}
