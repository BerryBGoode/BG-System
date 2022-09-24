/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.TextArea;

/** 
 *  Personalized Control package
 * @author danlo
 */
import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import Controles_Personalizados.ScrollBar.ScrollBarCustom;

/**
 *  Personalized control class, extends events and controls depends the needs
 * @author danlo
 */
public class TextAreaScroll extends JScrollPane {

    private final Animator animator;
    private boolean animateHinText = true;
    private float animateLocation;
    private boolean show;
    private boolean mouseOver = false;
    private String labelText = "Label";
    private Color lineColor = new Color(3, 155, 216);

    /**
     * Set the properties to the scroll
     */
    public TextAreaScroll() {
        setVerticalScrollBar(new ScrollBarCustom());
        ScrollBarCustom scrol = new ScrollBarCustom();
        scrol.setOrientation(JScrollBar.HORIZONTAL);
        setHorizontalScrollBar(scrol);
        setBorder(new EmptyBorder(20, 3, 3, 3));
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                setAnimateLocation(fraction);
                repaint();
            }
        };
        animator = new Animator(300, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs);
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        int width = getWidth();
        int height = getHeight();
        if (mouseOver) {
            g2.setColor(lineColor);
        } else {
            g2.setColor(new Color(150, 150, 150));
        }
        g2.fillRect(2, height - 1, width - 4, 1);
        createHintText(g2);
        createLineStyle(g2);
        g2.dispose();
    }

    private void createHintText(Graphics2D g2) {
        Insets in = getInsets();
        g2.setColor(new Color(150, 150, 150));
        FontMetrics ft = g2.getFontMetrics();
        Rectangle2D r2 = ft.getStringBounds(labelText, g2);
        double height = in.top;
        double textY = (height - r2.getHeight()) / 2;
        double size;
        if (animateHinText) {
            if (show) {
                size = 18 * (1 - animateLocation);
            } else {
                size = 18 * animateLocation;
            }
        } else {
            size = 18;
        }
        g2.drawString(labelText, in.right, (int) (in.top + textY + ft.getAscent() - size));
    }

    private void createLineStyle(Graphics2D g2) {
        double width = getWidth() - 4;
        int height = getHeight();
        g2.setColor(lineColor);
        double size;
        if (show) {
            size = width * (1 - animateLocation);
        } else {
            size = width * animateLocation;
        }
        double x = (width - size) / 2;
        g2.fillRect((int) (x + 2), height - 2, (int) size, 2);
    }

    /**
     * Animator
     * @return Animation
     */
    protected Animator getAnimator() {
        return animator;
    }

    /**
     *  Get Location of the animation
     * @return Animation
     */
    public float getAnimateLocation() {
        return animateLocation;
    }

    /**
     *  Animator
     * @param animateLocation Location
     */
    public void setAnimateLocation(float animateLocation) {
        this.animateLocation = animateLocation;
    }

    /**
     *
     * @return
     */
    public boolean isMouseOver() {
        return mouseOver;
    }

    /**
     * Mouse Over
     * @param mouseOver Location
     */
    public void setMouseOver(boolean mouseOver) {
        this.mouseOver = mouseOver;
        repaint();
    }

    /**
     *  Animation check
     * @return Boolean
     */
    public boolean isAnimateHinText() {
        return animateHinText;
    }

    /**
     *  Animated text
     * @param animateHinText Text
     */
    public void setAnimateHinText(boolean animateHinText) {
        this.animateHinText = animateHinText;
    }

    /**
     *  Gets Label Text
     * @return String
     */
    public String getLabelText() {
        return labelText;
    }

    /**
     * Set Label text
     * @param labelText String
     */
    public void setLabelText(String labelText) {
        this.labelText = labelText;
    }

    /**
     *  Get Line Color
     * @return Color
     */
    public Color getLineColor() {
        return lineColor;
    }

    /**
     *  Set Line Color
     * @param lineColor Color
     */
    public void setLineColor(Color lineColor) {
        this.lineColor = lineColor;
    }

    /**
     *  State
     * @return a Boolean
     */
    public boolean isShow() {
        return show;
    }

    /**
     *  State
     * @param show state
     */
    public void setShow(boolean show) {
        this.show = show;
    }
}
