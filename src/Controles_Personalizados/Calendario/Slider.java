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
import java.awt.Component;

/**
 *  Personalized control class, extends events and controls depends the needs 
 * @author danlo
 */
public class Slider extends javax.swing.JPanel {

    private boolean sliding = false;

    /**
     *  Constructor
     */
    public Slider() {
        initComponents();
    }

    /**
     *  Slider
     * @param com referring to the direction
     * @return a Boolean
     */
    public boolean slideToRight(Component com) {
        boolean act = false;
        if (!sliding) {
            act = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sliding = true;
                    Component old = null;
                    if (getComponentCount() > 0) {
                        old = getComponent(0);
                    }
                    add(com);
                    com.setLocation(-getWidth(), 0);
                    int x = 0;
                    int width = (int) getSize().getWidth() / 70;
                    for (int i = -getWidth(); i <= 0; i += width) {
                        com.setLocation(i, 0);
                        if (old != null) {
                            old.setLocation(x, 0);
                            x += width;
                        }
                        sleep();
                    }
                    com.setLocation(0, 0);
                    while (getComponentCount() != 1) {
                        remove(getComponentCount() - 2);
                    }
                    repaint();
                    revalidate();
                    sliding = false;
                }
            }).start();
        }
        return act;
    }

    /**
     *  Slide 
     * @param com directions
     * @return a Boolean
     */
    public boolean slideToRightBack(Component com) {
        boolean act = false;
        if (!sliding) {
            act = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sliding = true;
                    Component old = null;
                    if (getComponentCount() > 0) {
                        old = getComponent(0);
                    }
                    add(com);
                    com.setLocation(-getWidth(), 0);
                    int x = 0;
                    int width = (int) getSize().getWidth() / 70;
                    for (int i = -getWidth(); i <= 0; i += width) {
                        com.setLocation(i, 0);
                        if (old != null) {
                            old.setLocation(x, 0);
                            x -= width;
                        }
                        sleep();
                    }
                    com.setLocation(0, 0);
                    while (getComponentCount() != 1) {
                        remove(getComponentCount() - 2);
                    }
                    repaint();
                    revalidate();
                    sliding = false;
                }
            }).start();
        }
        return act;
    }

    /**
     *  Slide 
     * @param com Directions
     * @return a Boolean
     */
    public boolean slideToLeft(Component com) {
        boolean act = false;
        if (!sliding) {
            act = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sliding = true;
                    Component old = null;
                    if (getComponentCount() > 0) {
                        old = getComponent(0);
                    }
                    add(com);
                    com.setLocation(getWidth(), 0);
                    int x = 0;
                    int width = (int) getSize().getWidth() / 70;
                    for (int i = getWidth(); i >= 0; i -= width) {
                        com.setLocation(i, 0);
                        if (old != null) {
                            old.setLocation(x, 0);
                            x -= width;
                        }
                        sleep();
                    }
                    com.setLocation(0, 0);
                    while (getComponentCount() != 1) {
                        remove(getComponentCount() - 2);
                    }
                    repaint();
                    revalidate();
                    sliding = false;
                }
            }).start();
        }
        return act;
    }

    /**
     * Slide
     * @param com Directions
     * @return a Boolean
     */
    public boolean slideToLeftBack(Component com) {
        boolean act = false;
        if (!sliding) {
            act = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sliding = true;
                    Component old = null;
                    if (getComponentCount() > 0) {
                        old = getComponent(0);
                    }
                    add(com);
                    com.setLocation(getWidth(), 0);
                    int x = 0;
                    int width = (int) getSize().getWidth() / 70;
                    for (int i = getWidth(); i >= 0; i -= width) {
                        com.setLocation(i, 0);
                        if (old != null) {
                            old.setLocation(x, 0);
                            x += width;
                        }
                        sleep();
                    }
                    com.setLocation(0, 0);
                    while (getComponentCount() != 1) {
                        remove(getComponentCount() - 2);
                    }
                    repaint();
                    revalidate();
                    sliding = false;
                }
            }).start();
        }
        return act;
    }

    /**
     * Slide
     * @param com Directions
     * @return a Boolean
     */
    public boolean slideToDown(Component com) {
        boolean act = false;
        if (!sliding) {
            act = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sliding = true;
                    Component old = null;
                    if (getComponentCount() > 0) {
                        old = getComponent(0);
                    }
                    add(com);
                    com.setLocation(0, -getHeight());
                    int x = 0;
                    int right = (int) getSize().getHeight() / 70;
                    for (int i = getHeight(); i >= 0; i -= right) {
                        com.setLocation(0, i);
                        if (old != null) {
                            old.setLocation(0, x);
                            x -= right;
                        }
                        sleep();
                    }
                    com.setLocation(0, 0);
                    while (getComponentCount() != 1) {
                        remove(getComponentCount() - 2);
                    }
                    repaint();
                    revalidate();
                    sliding = false;
                }
            }).start();
        }
        return act;
    }

    /**
     *  Slide
     * @param com Directions
     * @return a Boolean
     */
    public boolean slideToDownBack(Component com) {
        boolean act = false;
        if (!sliding) {
            act = true;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    sliding = true;
                    Component old = null;
                    if (getComponentCount() > 0) {
                        old = getComponent(0);
                    }
                    add(com);
                    com.setLocation(0, -getHeight());
                    int x = 0;
                    int right = (int) getSize().getHeight() / 70;
                    for (int i = getHeight(); i >= 0; i -= right) {
                        com.setLocation(0, i);
                        if (old != null) {
                            old.setLocation(0, x);
                            x += right;
                        }
                        sleep();
                    }
                    com.setLocation(0, 0);
                    while (getComponentCount() != 1) {
                        remove(getComponentCount() - 2);
                    }
                    repaint();
                    revalidate();
                    sliding = false;
                }
            }).start();
        }
        return act;
    }

    /**
     *  Slide Non
     * @param com Directions
     */
    public void slideNon(Component com) {
        this.removeAll();
        this.add(com);
        repaint();
        revalidate();
    }

    private void sleep() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
