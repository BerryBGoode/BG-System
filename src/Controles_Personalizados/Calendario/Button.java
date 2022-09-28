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
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

/**
 *  Personalized control class, extends events and controls depends the needs 
 * @author danlo
 */
public final class Button extends JButton {

    /**
     *  Validates state
     * @return a Boolean
     */
    public boolean isPaintBackground() {
        return paintBackground;
    }

    /**
     *  Validates the state
     * @param paintBackground referring to the paintBackground
     */
    public void setPaintBackground(boolean paintBackground) {
        this.paintBackground = paintBackground;
    }

    private Event event;
    private boolean paintBackground = true;
    private Color colorSelected;

    /**
     *  Constructor
     */
    public Button() {
        setBorder(null);
        setContentAreaFilled(false);
        setFocusable(false);
        setBackground(Color.WHITE);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (!getText().equals("") && getName() != null) {
                    if (getName().equals("day") || getName().equals("year")) {
                        event.execute(me, Integer.valueOf(getText()));
                    } else {
                        event.execute(me, Integer.valueOf(getName()));
                    }
                    setBackground(getColorSelected());
                    setForeground(new Color(255, 255, 255));
                }
            }
        });
    }

    /**
     *  Gets the event
     * @return Event
     */
    public Event getEvent() {
        return event;
    }

    /**
     *  Set the event
     * @param event referring to the event 
     */
    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public void paint(Graphics grphcs) {
        if (paintBackground) {
            int width = getWidth();
            int height = getHeight();
            int size = Math.min(width, height);
            int x = (width - size) / 2;
            int y = (height - size) / 2;
            Graphics2D g2 = (Graphics2D) grphcs;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(getBackground());
            g2.fillOval(x, y, size, size);
        }
        super.paint(grphcs);
    }

    /**
     *  Gets the color that has been selected
     * @return
     */
    public Color getColorSelected() {
        return colorSelected;
    }

    /**
     *  Set the selected Color
     * @param colorSelected
     */
    public void setColorSelected(Color colorSelected) {
        this.colorSelected = colorSelected;
    }
}
