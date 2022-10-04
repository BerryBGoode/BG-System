/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerBuscador;
import Controles_Personalizados.Graficas.ModelChart;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
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
        GenerarT();
        System.out.println(ValidacionesSistema.ValidacionesBeep_Go.Modo);
        CargarGraficasGeneral();
        System.out.println("PanelDashBoard modo: " + ValidacionesSistema.ValidacionesBeep_Go.Modo);
        mod();
        //            Grafica1.addLegend("Entradas", new Color(58, 50, 75));
//            Grafica1.setBackground(new Color(231, 234, 239));
//            Grafica1.addLegend("Salidas", new Color(58, 50, 75));
//            Grafica2.setBackground(new Color(231, 234, 239));
//            Grafica2.addLegend("Administradores", new Color(58, 50, 75));
//            Grafica2.addLegend("Docentes", new Color(58, 50, 75));
//            Grafica2.addLegend("Alumnos", new Color(58, 50, 75));
//            Grafica2.addLegend("Seguridad", new Color(58, 50, 75));
        Grafica1.addLegend("Entradas", new Color(92, 84, 112));
        Grafica1.setBackground(new Color(231, 234, 239));
        Grafica1.addLegend("Salidas", new Color(92, 84, 112));
        Grafica2.setBackground(new Color(231, 234, 239));
        Grafica2.addLegend("Administradores", new Color(92, 84, 112));
        Grafica2.addLegend("Docentes", new Color(92, 84, 112));
        Grafica2.addLegend("Alumnos", new Color(92, 84, 112));
        Grafica2.addLegend("Seguridad", new Color(92, 84, 112));
        Grafica1.addData(new ModelChart("Entradas", new double[]{Cont, 0, 0, 0}));
        Grafica1.addData(new ModelChart("Salidas", new double[]{Cont2, 0, 0, 0}));
        Grafica2.addData(new ModelChart("Administradores", new double[]{R_Admins, 0, 0, 0}));
        Grafica2.addData(new ModelChart("Docentes", new double[]{R_Profes, 0, 0, 0}));
        Grafica2.addData(new ModelChart("Alumnos", new double[]{R_Alumnos, 0, 0, 0}));
        Grafica2.addData(new ModelChart("Seguridad", new double[]{R_Seguridad, 0, 0, 0}));
    }

    ControllerBuscador obj = new ControllerBuscador();
    int Cont;
    int Cont2;
    int R_Admins;
    int R_Profes;
    int R_Alumnos;
    int R_Seguridad;
    public int itemCount = 0;
    String fecha;
    String mensaje;
    String id;
    public JPanel panel = new JPanel();

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

    void CargarAdmins() {
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

    void CargarProfes() {
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

    void CargarAlumnos() {
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

    void CargarSeguridad() {
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

    public void mod() {
        if (ValidacionesSistema.ValidacionesBeep_Go.getModo() == 1) {
                jPanel7.setBackground(new Color(47, 49, 54));
                jPanel5.setBackground(new Color(47, 49, 54));
                pnlWestNotifi.setBackground(new Color(47, 49, 54));
                panelRound2.setBackground(new Color(47, 49, 54));
                panelRound6.setBackground(new Color(47, 49, 54));
                pnlNorthNotifi.setBackground(new Color(47, 49, 54));
                jPanel1.setBackground(new Color(47, 49, 54));
                jPanel4.setBackground(new Color(47, 49, 54));
                jPanel11.setBackground(new Color(47, 49, 54));
                PanelGrafica1.setBackground(new Color(47, 49, 54));
                panelRound1.setBackground(new Color(47, 49, 54));
                jPanel6.setBackground(new Color(47, 49, 54));
                jPanel9.setBackground(new Color(47, 49, 54));
                PanelGrafica3.setBackground(new Color(47, 49, 54));
                lblNoti.setForeground(new Color(231, 234, 239));
                PanelNotificaciones.setBackground(new Color(32, 34, 37));
                panelRound.setBackground(new Color(47, 49, 54));
                Grafica1.setBackground(new Color(32, 34, 37));
                Grafica2.setBackground(new Color(32, 34, 37));
//            Grafica1.addLegend("Entradas", new Color(231, 234, 239));
//            Grafica1.setBackground(new Color(32, 34, 37));
//            Grafica1.addLegend("Salidas", new Color(231, 234, 239));
//            Grafica2.setBackground(new Color(32, 34, 37));
//            Grafica2.addLegend("Administradores", new Color(231, 234, 239));
//            Grafica2.addLegend("Docentes", new Color(231, 234, 239));
//            Grafica2.addLegend("Alumnos", new Color(231, 234, 239));
//            Grafica2.addLegend("Seguridad", new Color(231, 234, 239));

        } else if (ValidacionesSistema.ValidacionesBeep_Go.getModo() == 2) {
                jPanel7.setBackground(new Color(231, 234, 239));
                jPanel5.setBackground(new Color(231, 234, 239));
                pnlWestNotifi.setBackground(new Color(231, 234, 239));
                panelRound2.setBackground(new Color(231, 234, 239));
                panelRound6.setBackground(new Color(231, 234, 239));
                pnlNorthNotifi.setBackground(new Color(231, 234, 239));
                jPanel1.setBackground(new Color(231, 234, 239));
                jPanel4.setBackground(new Color(231, 234, 239));
                jPanel11.setBackground(new Color(231, 234, 239));
                PanelGrafica1.setBackground(new Color(231, 234, 239));
                panelRound1.setBackground(new Color(231, 234, 239));
                jPanel6.setBackground(new Color(231, 234, 239));
                jPanel9.setBackground(new Color(231, 234, 239));
                PanelGrafica3.setBackground(new Color(231, 234, 239));
                lblNoti.setForeground(new Color(0, 0, 0));
                PanelNotificaciones.setBackground(new Color(255, 255, 254));
                panelRound.setBackground(new Color(231, 234, 239));
                Grafica1.setBackground(new Color(231, 234, 239));
                Grafica2.setBackground(new Color(231, 234, 239));
//            Grafica1.addLegend("Entradas", new Color(58, 50, 75));
//            Grafica1.setBackground(new Color(231, 234, 239));
//            Grafica1.addLegend("Salidas", new Color(58, 50, 75));
//            Grafica2.setBackground(new Color(231, 234, 239));
//            Grafica2.addLegend("Administradores", new Color(58, 50, 75));
//            Grafica2.addLegend("Docentes", new Color(58, 50, 75));
//            Grafica2.addLegend("Alumnos", new Color(58, 50, 75));
//            Grafica2.addLegend("Seguridad", new Color(58, 50, 75));
        }
    }

    final void GenerarComp() {

        obj.id = itemCount;

        try {
            ResultSet rs = obj.CargarBitCont();
            while (rs.next()) {
                fecha = rs.getString("fecha");
                mensaje = rs.getString("mensaje");
                id = rs.getString("idRegistroBit");

                panel.setBackground(new Color(229, 229, 229));
                panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
                LineBorder line = new LineBorder(new Color(255, 255, 255), 1, true);
                panel.setBorder(line);
                panelNotificacion.add(panel);

                JLabel separator = new JLabel();
                separator.setText("-----------------------------------------");
                separator.setMaximumSize(new Dimension(300, 15));
                separator.setFont(new Font("Roboto", 1, 1));
                separator.setMaximumSize(new Dimension(10, 1));
                separator.setLocation(0, 0);
                panel.add(separator);

                JPanel Aviso = new JPanel();
                Aviso.setBackground(new Color(255, 255, 255));
                Aviso.setLayout(new BoxLayout(Aviso, BoxLayout.X_AXIS));
                panel.add(Aviso);

                Icon Img;
                Img = new ImageIcon("src/Recursos/LogoB&GLogin.png");
                JLabel icon = new JLabel();
                icon.setIcon(Img);
                icon.setSize(100, 40);
                icon.setLocation(30, 60);
                Aviso.add(icon);

                JLabel text = new JLabel();
                text.setText(mensaje);
                text.setMaximumSize(new Dimension(230, 20));
                text.setLocation(20, 20);
                text.setFont(new Font("Roboto", 1, 13));
                Aviso.add(text);

                JLabel txt = new JLabel();
                txt.setText(id);
                txt.setMaximumSize(new Dimension(10, 10));
                txt.setFont(new Font("Roboto", 0, 12));
                txt.setForeground(new Color(184, 184, 184));
                Aviso.add(txt);
                txt.setVisible(true);

                ActionListener action = new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String ID = txt.getText();
                        int i = JOptionPane.showConfirmDialog(null, "Desea eliminar la notificacion");
                        if (i == 0) {
                            obj.id = Integer.parseInt(ID);
                            if (obj.Eliminacion() == true) {
                                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Eliminacion Exitosa", "La notificacion se elimino correctamente", 1);
                                GenerarComp();
                            } else {
                                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Eliminacion Fallida", "La notificacion no se elimino correctamente", 2);
                            }

                        }
                    }
                };

                Icon img;
                img = new ImageIcon("src/Recursos_Proyecto/eliminar.png");
                JButton btn = new JButton();
                btn.setIcon(img);
                btn.setOpaque(false);
                btn.setBorderPainted(false);
                btn.setContentAreaFilled(false);
                btn.setSize(15, 35);
                btn.setLocation(290, 30);
                btn.addActionListener(action);
                Aviso.add(btn);

                JPanel Desc = new JPanel();
                Desc.setBackground(new Color(255, 255, 255));
                Desc.setLayout(new BoxLayout(Desc, BoxLayout.X_AXIS));
                panel.add(Desc);

                JLabel rellenoo = new JLabel();
                rellenoo.setText("");
                rellenoo.setMaximumSize(new Dimension(40, 30));
                Desc.add(rellenoo);

                JLabel description = new JLabel();
                description.setText(fecha);
                description.setMaximumSize(new Dimension(210, 10));
                description.setFont(new Font("Roboto", 0, 12));
                description.setForeground(new Color(184, 184, 184));
                Desc.add(description);

                JLabel relleno = new JLabel();
                relleno.setText("");
                relleno.setMaximumSize(new Dimension(210, 30));
                Desc.add(relleno);

                panel.updateUI();
                this.validate();
            }
        } catch (Exception e) {
        }
    }

    void GenerarT() {
        try {
            Timer tmr = new Timer();
            {
                TimerTask timTas = new TimerTask() {
                    @Override
                    public void run() {
                        itemCount++;
                        GenerarComp();

                        try {
                            if (itemCount == 1000) {
                                tmr.cancel();
                            }
                        } catch (Exception e) {
                        }
                    }

                };
                tmr.scheduleAtFixedRate(timTas, 1, 1);
            }
        } catch (Exception e) {
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error", "Algo salio mal con el temporizador", 2);
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
        panelRound3 = new Controles_Personalizados.Paneles.PanelRound();
        panelNotificacion = new Controles_Personalizados.Paneles.PanelRound();
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
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        panelRound2.setBackground(new java.awt.Color(42, 36, 56));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelRound2MouseMoved(evt);
            }
        });
        panelRound2.setLayout(new java.awt.BorderLayout());

        panelRound6.setPreferredSize(new java.awt.Dimension(250, 100));
        panelRound6.setRoundBottomRight(30);
        panelRound6.setLayout(new java.awt.BorderLayout());

        pnlWestNotifi.setBackground(new java.awt.Color(231, 234, 239));
        pnlWestNotifi.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                pnlWestNotifiMouseMoved(evt);
            }
        });
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
        PanelNotificaciones.setLayout(new javax.swing.BoxLayout(PanelNotificaciones, javax.swing.BoxLayout.Y_AXIS));

        lblNoti.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblNoti.setForeground(new java.awt.Color(0, 0, 0));
        lblNoti.setText("Notificaciones");
        PanelNotificaciones.add(lblNoti);

        panelRound3.setLayout(new javax.swing.BoxLayout(panelRound3, javax.swing.BoxLayout.LINE_AXIS));

        panelNotificacion.setLayout(new javax.swing.BoxLayout(panelNotificacion, javax.swing.BoxLayout.LINE_AXIS));
        panelRound3.add(panelNotificacion);

        PanelNotificaciones.add(panelRound3);

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

    private void pnlWestNotifiMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlWestNotifiMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_pnlWestNotifiMouseMoved

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseMoved

    private void panelRound2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound2MouseMoved
        // TODO add your handling code here:
      mod();
    }//GEN-LAST:event_panelRound2MouseMoved


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
    private Controles_Personalizados.Paneles.PanelRound panelNotificacion;
    private Controles_Personalizados.Paneles.PanelRound panelRound;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.Paneles.PanelRound panelRound2;
    private Controles_Personalizados.Paneles.PanelRound panelRound3;
    private Controles_Personalizados.Paneles.PanelRound panelRound6;
    private javax.swing.JPanel pnlNorthNotifi;
    private javax.swing.JPanel pnlNorthNotifi1;
    private javax.swing.JPanel pnlWestNotifi;
    // End of variables declaration//GEN-END:variables
}
