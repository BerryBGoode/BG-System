/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.GraficaEnBlanco;
import java.awt.Graphics2D;

/**
 *
 * @author danlo
 */
public abstract class BlankPlotChatRender {
 
    public abstract String getLabelText(int index);

    public abstract void renderSeries(BlankPlotChart chart, Graphics2D g2, SeriesSize size, int index);
    
}
