/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerBuscador;
import Controles_Personalizados.Graficas.ModelChart;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danlo
 */
public class PanelDashboard extends javax.swing.JPanel {

    /**
     * Creates new form PanelDashboard
     */
    public PanelDashboard() {
        initComponents();
        CargarGraficasGeneral();
        Grafica1.addLegend("Entradas", new Color(53, 47, 68));
        Grafica1.setBackground(new Color(231,234,239));
        Grafica1.addLegend("Salidas", new Color(92, 84, 112));
        Grafica1.addData(new ModelChart("Entradas", new double[]{Cont, 0, 0,0}));
        Grafica1.addData(new ModelChart("Salidas", new double[]{Cont2, 0,0,0} ));
        Grafica2.setBackground(new Color(231,234,239));
        Grafica2.addLegend("Administradores", new Color(53, 47, 68));
        Grafica2.addData(new ModelChart("Administradores", new double[]{R_Admins, 0,0,0} ));
        Grafica2.addLegend("Docentes", new Color(92, 84, 112));
        Grafica2.addData(new ModelChart("Docentes", new double[]{R_Profes, 0,0,0} ));
        Grafica2.addLegend("Alumnos", new Color(92, 84, 112));
        Grafica2.addData(new ModelChart("Alumnos", new double[]{R_Alumnos, 0,0,0} ));
        Grafica2.addLegend("Seguridad", new Color(219, 216, 227));
        Grafica2.addData(new ModelChart("Seguridad", new double[]{R_Seguridad, 0,0,0} ));
        mod();
    }

    ControllerBuscador obj = new ControllerBuscador();
    int Cont;
    int Cont2;
    int R_Admins;
    int R_Profes;
    int R_Alumnos;
    int R_Seguridad;

    void CargarGraficasGeneral() {
        CargarGrafAccesos();
        CargarGraf2Accesos();
        CargarAdmins();
        CargarProfes();
        CargarAlumnos();
        CargarSeguridad();
    }

    void CargarGrafAccesos() {
        ResultSet rs = obj.cargarGraficaController();
        Cont = 0;
        try {
            while (rs.next()) {
                ++Cont;
            }
            if (Cont != 0) {
                String res = String.valueOf(Cont);
            }
        } catch (Exception e) {
        }
    }

    void CargarGraf2Accesos() {
        ResultSet rs = obj.cargarSalidasController();
        Cont2 = 0;
        try {
            while (rs.next()) {
                ++Cont2;
            }
            if (Cont2 != 0) {
                String res = String.valueOf(Cont2);
            }
        } catch (Exception e) {
        }
    }
    
    void CargarAdmins()
    {
        ResultSet rs = obj.cargarAdminsController();
        R_Admins = 0;
        try {
            while (rs.next()) {
                ++R_Admins;
            }
            if (R_Admins != 0) {
                String res = String.valueOf(R_Admins);
            }
        } catch (Exception e) {
        }
    }
    
    void CargarProfes()
    {
        ResultSet rs = obj.cargarProfesController();
        R_Profes = 0;
        try {
            while (rs.next()) {
                ++R_Profes;
            }
            if (R_Profes != 0) {
                String res = String.valueOf(R_Profes);
            }
        } catch (Exception e) {
        }
    }
    
        void CargarAlumnos()
    {
        ResultSet rs = obj.cargarAlumnosController();
        R_Alumnos = 0;
        try {
            while (rs.next()) {
                ++R_Alumnos;
            }
            if (R_Alumnos != 0) {
                String res = String.valueOf(R_Alumnos);
            }
        } catch (Exception e) {
        }
    }
        
         void CargarSeguridad()
    {
        ResultSet rs = obj.cargarSeguridadController();
        R_Seguridad = 0;
        try {
            while (rs.next()) {
                ++R_Seguridad;
            }
            if (R_Seguridad != 0) {
                String res = String.valueOf(R_Seguridad);
            }
        } catch (Exception e) {
        }
    }
        


    public void mode() {
        switch (ValidacionesSistema.ValidacionesBeep_Go.getModo()) {
            case 1:

                PanelGrafica1.setBackground(new Color(32, 34, 37));
                break;
            case 2:

                PanelGrafica1.setBackground(new Color(253, 255, 254));
                PanelGrafica3.setBackground(new Color(253, 255, 254));
                PanelGrafica3.setBackground(new Color(253, 255, 254));
                jPanel10.setBackground(new Color(231,234,239));
                jPanel11.setBackground(new Color(231,234,239));
                jPanel4.setBackground(new Color(231,234,239));
                panelRound1.setBackground(new Color(231,234,239));
                panelRound2.setBackground(new Color(231,234,239));
                pnlWestNotifi.setBackground(new Color(231,234,239));
                pnlNorthNotifi.setBackground(new Color(231,234,239));
                panelRound6.setBackground(new Color(231,234,239));
                jPanel6.setBackground(new Color(231,234,239));
                jPanel5.setBackground(new Color(231,224,239));
                panelRound.setBackground(new Color(231,234,239));

                lblNoti.setForeground(Color.BLACK);
                PanelNotificaciones.setBackground(new Color(253, 255, 254));
                break;

        }
    }

    public void mod() {
        if (ValidacionesSistema.ValidacionesBeep_Go.getModo() == 1) {

        } else if (ValidacionesSistema.ValidacionesBeep_Go.getModo() == 2) {

            panelRound.setBackground(new Color(47, 49, 54));
        } else if (ValidacionesSistema.ValidacionesBeep_Go.getModo() == 2) {
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelRound2 = new Controles_Personalizados.Paneles.PanelRound();
        panelRound6 = new Controles_Personalizados.Paneles.PanelRound();
        pnlWestNotifi = new javax.swing.JPanel();
        pnlNorthNotifi = new javax.swing.JPanel();
        panelRound = new Controles_Personalizados.Paneles.PanelRound();
        PanelNotificaciones = new Controles_Personalizados.Paneles.PanelRound();
        lblNoti = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        pnlNorthNotifi1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        PanelGrafica1 = new Controles_Personalizados.Paneles.PanelRound();
        Grafica1 = new Controles_Personalizados.Graficas.Chart();
        jPanel11 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        PanelGrafica3 = new Controles_Personalizados.Paneles.PanelRound();
        Grafica2 = new Controles_Personalizados.Graficas.Chart();

        setBackground(new java.awt.Color(42, 36, 56));
        setLayout(new java.awt.BorderLayout());

        panelRound2.setBackground(new java.awt.Color(42, 36, 56));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setLayout(new java.awt.BorderLayout());

        panelRound6.setPreferredSize(new java.awt.Dimension(250, 100));
        panelRound6.setRoundBottomRight(30);
        panelRound6.setLayout(new java.awt.BorderLayout());

        pnlWestNotifi.setBackground(new java.awt.Color(231, 234, 239));
        panelRound6.add(pnlWestNotifi, java.awt.BorderLayout.WEST);

        pnlNorthNotifi.setBackground(new java.awt.Color(231, 234, 239));
        panelRound6.add(pnlNorthNotifi, java.awt.BorderLayout.NORTH);

        panelRound.setBackground(new java.awt.Color(231, 234, 239));
        panelRound.setRoundBottomRight(20);
        panelRound.setLayout(new java.awt.GridBagLayout());

        PanelNotificaciones.setBackground(new java.awt.Color(253, 255, 254));
        PanelNotificaciones.setPreferredSize(new java.awt.Dimension(300, 200));
        PanelNotificaciones.setRoundBottomLeft(20);
        PanelNotificaciones.setRoundBottomRight(20);
        PanelNotificaciones.setRoundTopLeft(20);
        PanelNotificaciones.setRoundTopRight(20);
        PanelNotificaciones.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNoti.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNoti.setForeground(new java.awt.Color(0, 0, 0));
        lblNoti.setText("Notificaciones");
        PanelNotificaciones.add(lblNoti, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 10, 10);
        panelRound.add(PanelNotificaciones, gridBagConstraints);

        panelRound6.add(panelRound, java.awt.BorderLayout.CENTER);

        panelRound2.add(panelRound6, java.awt.BorderLayout.EAST);

        jPanel2.setPreferredSize(new java.awt.Dimension(600, 100));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(231, 234, 239));
        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlNorthNotifi1.setBackground(new java.awt.Color(231, 234, 239));
        pnlNorthNotifi1.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        pnlNorthNotifi1.add(jPanel5, java.awt.BorderLayout.EAST);

        jPanel7.setBackground(new java.awt.Color(231, 234, 239));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jPanel8.setPreferredSize(new java.awt.Dimension(100, 300));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(231, 234, 239));
        jPanel10.setLayout(new java.awt.BorderLayout());

        PanelGrafica1.setBackground(new java.awt.Color(253, 255, 254));
        PanelGrafica1.setPreferredSize(new java.awt.Dimension(400, 400));
        PanelGrafica1.setRoundBottomLeft(20);
        PanelGrafica1.setRoundBottomRight(20);
        PanelGrafica1.setRoundTopLeft(20);
        PanelGrafica1.setRoundTopRight(20);
        PanelGrafica1.setLayout(new java.awt.BorderLayout());

        Grafica1.setBackground(new java.awt.Color(231, 234, 239));
        Grafica1.setForeground(new java.awt.Color(53, 47, 68));
        Grafica1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PanelGrafica1.add(Grafica1, java.awt.BorderLayout.CENTER);

        jPanel10.add(PanelGrafica1, java.awt.BorderLayout.CENTER);

        jPanel8.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel11.setBackground(new java.awt.Color(231, 234, 239));
        jPanel8.add(jPanel11, java.awt.BorderLayout.WEST);

        jPanel7.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(42, 36, 56));
        jPanel9.setPreferredSize(new java.awt.Dimension(100, 290));
        jPanel9.setRequestFocusEnabled(false);
        jPanel9.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(231, 234, 239));
        jPanel6.setPreferredSize(new java.awt.Dimension(100, 5));
        jPanel9.add(jPanel6, java.awt.BorderLayout.NORTH);

        panelRound1.setBackground(new java.awt.Color(231, 234, 239));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setLayout(new java.awt.GridBagLayout());

        PanelGrafica3.setBackground(new java.awt.Color(253, 255, 254));
        PanelGrafica3.setPreferredSize(new java.awt.Dimension(990, 200));
        PanelGrafica3.setRoundBottomLeft(20);
        PanelGrafica3.setRoundBottomRight(20);
        PanelGrafica3.setRoundTopLeft(20);
        PanelGrafica3.setRoundTopRight(20);
        PanelGrafica3.setLayout(new java.awt.BorderLayout());

        Grafica2.setBackground(new java.awt.Color(231, 234, 239));
        Grafica2.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PanelGrafica3.add(Grafica2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 1;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 10, 0);
        panelRound1.add(PanelGrafica3, gridBagConstraints);

        jPanel9.add(panelRound1, java.awt.BorderLayout.CENTER);

        jPanel7.add(jPanel9, java.awt.BorderLayout.SOUTH);

        pnlNorthNotifi1.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(pnlNorthNotifi1, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        panelRound2.add(jPanel2, java.awt.BorderLayout.CENTER);

        add(panelRound2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Graficas.Chart Grafica1;
    private Controles_Personalizados.Graficas.Chart Grafica2;
    private Controles_Personalizados.Paneles.PanelRound PanelGrafica1;
    private Controles_Personalizados.Paneles.PanelRound PanelGrafica3;
    private Controles_Personalizados.Paneles.PanelRound PanelNotificaciones;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblNoti;
    private Controles_Personalizados.Paneles.PanelRound panelRound;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.Paneles.PanelRound panelRound2;
    private Controles_Personalizados.Paneles.PanelRound panelRound6;
    private javax.swing.JPanel pnlNorthNotifi;
    private javax.swing.JPanel pnlNorthNotifi1;
    private javax.swing.JPanel pnlWestNotifi;
    // End of variables declaration//GEN-END:variables
}
