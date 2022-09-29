/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerLogin;
import Controles_Personalizados.Paneles.PanelRound;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Rectangle;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;

import javax.swing.JOptionPane;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author danlo and ferna
 */
public class FrmDashboard extends javax.swing.JFrame implements Runnable {

    private String tipousuario;
    PanelDashboard pld = new PanelDashboard();
    ControllerLogin clog = new ControllerLogin();
    PanelUsuarios_dashbord pu = new PanelUsuarios_dashbord();
    private int ev;
    private int iduser;

    /**
     * Creates new form Dashboard
     */
    public FrmDashboard(String nombre, String tipo) {
        initComponents();
        this.setTitle("Beep&Go");
        tipousuario = tipo;
        this.setLocationRelativeTo(null);
//        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
//        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());
        this.setResizable(true);
        //this.setExtendedState(MAXIMIZED_BOTH);
        //jpanelfondo
        Niveles(tipo);
        Evaluador1();
        lblNombre.setText(nombre);
        lblTipo.setText(tipo);

        lblNormal.setVisible(false);
        lblUsuarioDark.setVisible(false);
        lblNight.setVisible(false);
        lblSun.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionAjustes.setVisible(false);
        panelSeleccionLogout.setVisible(false);

        pld.setSize(1270, 620);
        pld.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pld);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
        h1 = new Thread(this);
        h1.start();

        GetDayString();
    }

    public FrmDashboard() {
        initComponents();
    }

    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    @Override
    public void run() {
        Thread ct = Thread.currentThread();
        while (ct == h1) {
            CalcularHora();
            lblHora.setText(hora + ":" + minutos + ":" + segundos + " " + ampm);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

    String hora, minutos, segundos, ampm;
    Thread h1;

    final void CalcularHora() {
        Calendar cal = new GregorianCalendar();
        Date fechaHoraActual = new Date();

        cal.setTime(fechaHoraActual);
        ampm = cal.get(Calendar.AM_PM) == Calendar.AM ? "am" : "pm";

        if (ampm.equals("pm")) {
            int h = cal.get(Calendar.HOUR_OF_DAY);
            if(h != 12){
                h = cal.get(Calendar.HOUR_OF_DAY) - 12;
            }
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = cal.get(Calendar.HOUR_OF_DAY) > 9 ? "" + cal.get(Calendar.HOUR_OF_DAY) : "0" + cal.get(Calendar.HOUR_OF_DAY);
        }
        minutos = cal.get(Calendar.MINUTE) > 9 ? "" + cal.get(Calendar.MINUTE) : "0" + cal.get(Calendar.MINUTE);
        segundos = cal.get(Calendar.SECOND) > 9 ? "" + cal.get(Calendar.SECOND) : "0" + cal.get(Calendar.SECOND);

        if (Integer.valueOf(hora) >= 2 && Integer.valueOf(hora) <= 6 && ampm.equals("pm")) {
            lblSun.setVisible(false);
            lblSunset.setVisible(true);
            lblNight.setVisible(false);
        }
        if (Integer.valueOf(hora) >= 7 && Integer.valueOf(hora) <= 11 && ampm.equals("pm")) {
            lblSun.setVisible(false);
            lblSunset.setVisible(false);
            lblNight.setVisible(true);
        }
        if (Integer.valueOf(hora) >= 0 && Integer.valueOf(hora) <= 4 && ampm.equals("am")) {
            lblSun.setVisible(false);
            lblSunset.setVisible(false);
            lblNight.setVisible(true);
        }
        if (Integer.valueOf(hora) == 5 && ampm.equals("am")) {
            lblSun.setVisible(false);
            lblSunset.setVisible(true);
            lblNight.setVisible(false);
        }
        if (Integer.valueOf(hora) >= 6 && Integer.valueOf(hora) <= 11 && ampm.equals("am")) {
            lblSun.setVisible(true);
            lblSunset.setVisible(false);
            lblNight.setVisible(false);
        }
        if (Integer.valueOf(hora) >= 0 && Integer.valueOf(hora) <= 1 && ampm.equals("pm")) {
            lblSun.setVisible(true);
            lblSunset.setVisible(false);
            lblNight.setVisible(false);
        }
    }

    final void GetDayString() {
        DayOfWeek dia = LocalDate.now().getDayOfWeek();
        String day = dia.getDisplayName(TextStyle.FULL, new Locale("en", "US"));

        String firstletter = day.substring(0, 1);
        String capital = firstletter.toUpperCase();
        String restletters = day.substring(1, day.length());
        day = capital + restletters;
        lblDia.setText(day);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelFondo = new Controles_Personalizados.Paneles.PanelRound();
        jPanel3 = new javax.swing.JPanel();
        PanelContenedor = new Controles_Personalizados.Paneles.PanelRound();
        pnlNorthForm = new Controles_Personalizados.Paneles.PanelRound();
        txtBuscador = new Controles_Personalizados.textfields.TextFieldSuggestion();
        jPanel9 = new javax.swing.JPanel();
        PanelMO = new Controles_Personalizados.Paneles.PanelRound();
        lblNormal = new javax.swing.JLabel();
        btnMO = new javax.swing.JLabel();
        PanelDatosUs = new Controles_Personalizados.Paneles.PanelRound();
        lblNombre = new javax.swing.JLabel();
        lblTipo = new javax.swing.JLabel();
        lblUsuarioDark = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        PanelFecha = new Controles_Personalizados.Paneles.PanelRound();
        lblHora = new javax.swing.JLabel();
        lblDia = new javax.swing.JLabel();
        lblSun = new javax.swing.JLabel();
        lblNight = new javax.swing.JLabel();
        lblSunset = new javax.swing.JLabel();
        PanelContenedorForms = new Controles_Personalizados.Paneles.PanelRound();
        pnlWest = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnDashboard = new javax.swing.JLabel();
        btnUsuarios = new javax.swing.JLabel();
        btnPersonal = new javax.swing.JLabel();
        btnCarnets = new javax.swing.JLabel();
        btnVehiculos = new javax.swing.JLabel();
        panelSeleccionVehiculos = new Controles_Personalizados.Paneles.PanelRound();
        btnParqueo = new javax.swing.JLabel();
        btnAjustes = new javax.swing.JLabel();
        panelSeleccionAjustes = new Controles_Personalizados.Paneles.PanelRound();
        btnAccesos = new javax.swing.JLabel();
        btnLogOut = new javax.swing.JLabel();
        panelSeleccionLogout = new Controles_Personalizados.Paneles.PanelRound();
        btnContactos = new javax.swing.JLabel();
        panelSeleccionContactos = new Controles_Personalizados.Paneles.PanelRound();
        panelSeleccionAccesos = new Controles_Personalizados.Paneles.PanelRound();
        panelSeleccionParqueo = new Controles_Personalizados.Paneles.PanelRound();
        panelSeleccionCarnets = new Controles_Personalizados.Paneles.PanelRound();
        panelSeleccionPersonal = new Controles_Personalizados.Paneles.PanelRound();
        PanelSeleccionUsuario = new Controles_Personalizados.Paneles.PanelRound();
        PanelSeleccionDashboard = new Controles_Personalizados.Paneles.PanelRound();
        jPanel7 = new javax.swing.JPanel();
        pnlNorth = new javax.swing.JPanel();
        pnlModifWin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        btnMinimizar = new javax.swing.JLabel();
        btnMaximizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        pnlFilled = new javax.swing.JPanel();
        pnlSourth = new javax.swing.JPanel();
        pnlEast = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setName("Dashboard"); // NOI18N
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1373, 768));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.LINE_AXIS));

        panelFondo.setBackground(new java.awt.Color(42, 36, 56));
        panelFondo.setPreferredSize(new java.awt.Dimension(1366, 768));
        panelFondo.setRoundBottomLeft(40);
        panelFondo.setRoundBottomRight(40);
        panelFondo.setRoundTopLeft(40);
        panelFondo.setRoundTopRight(40);
        panelFondo.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(42, 36, 56));
        jPanel3.setLayout(new java.awt.BorderLayout());

        PanelContenedor.setPreferredSize(new java.awt.Dimension(1155, 729));
        PanelContenedor.setRoundBottomLeft(30);
        PanelContenedor.setRoundBottomRight(30);
        PanelContenedor.setRoundTopLeft(30);
        PanelContenedor.setRoundTopRight(30);
        PanelContenedor.setLayout(new java.awt.BorderLayout());

        pnlNorthForm.setBackground(new java.awt.Color(231, 234, 239));
        pnlNorthForm.setMaximumSize(new java.awt.Dimension(32767, 60));
        pnlNorthForm.setRoundTopLeft(30);
        pnlNorthForm.setRoundTopRight(30);

        txtBuscador.setText("Buscar");
        txtBuscador.setDoubleBuffered(true);
        txtBuscador.setPreferredSize(new java.awt.Dimension(800, 50));
        txtBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscadorActionPerformed(evt);
            }
        });
        txtBuscador.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscadorKeyPressed(evt);
            }
        });

        jPanel9.setBackground(new java.awt.Color(231, 234, 239));
        jPanel9.setMaximumSize(new java.awt.Dimension(468, 60));
        jPanel9.setMinimumSize(new java.awt.Dimension(468, 468));

        PanelMO.setBackground(new java.awt.Color(253, 255, 254));
        PanelMO.setPreferredSize(new java.awt.Dimension(57, 54));
        PanelMO.setRoundBottomLeft(20);
        PanelMO.setRoundBottomRight(20);
        PanelMO.setRoundTopLeft(20);
        PanelMO.setRoundTopRight(20);

        lblNormal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/lblNormal.png"))); // NOI18N
        lblNormal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblNormal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNormalMouseClicked(evt);
            }
        });

        btnMO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-moon.png"))); // NOI18N
        btnMO.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMO.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMOMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout PanelMOLayout = new javax.swing.GroupLayout(PanelMO);
        PanelMO.setLayout(PanelMOLayout);
        PanelMOLayout.setHorizontalGroup(
            PanelMOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMOLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(PanelMOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelMOLayout.setVerticalGroup(
            PanelMOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMOLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(PanelMOLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMO, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PanelDatosUs.setBackground(new java.awt.Color(253, 255, 254));
        PanelDatosUs.setPreferredSize(new java.awt.Dimension(200, 55));
        PanelDatosUs.setRoundBottomLeft(20);
        PanelDatosUs.setRoundBottomRight(20);
        PanelDatosUs.setRoundTopLeft(20);
        PanelDatosUs.setRoundTopRight(20);
        PanelDatosUs.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblNombre.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(42, 36, 56));
        lblNombre.setText("Usuario");
        PanelDatosUs.add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 7, -1, 30));

        lblTipo.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        lblTipo.setForeground(new java.awt.Color(42, 36, 56));
        lblTipo.setText("Tipo usuario");
        PanelDatosUs.add(lblTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        lblUsuarioDark.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/usuario-blanco.png"))); // NOI18N
        PanelDatosUs.add(lblUsuarioDark, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 60));

        lblUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-user-circle.png"))); // NOI18N
        PanelDatosUs.add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 40, 60));

        PanelFecha.setBackground(new java.awt.Color(253, 255, 254));
        PanelFecha.setPreferredSize(new java.awt.Dimension(160, 52));
        PanelFecha.setRoundBottomLeft(20);
        PanelFecha.setRoundBottomRight(20);
        PanelFecha.setRoundTopLeft(20);
        PanelFecha.setRoundTopRight(20);

        lblHora.setFont(new java.awt.Font("Roboto Black", 0, 14)); // NOI18N
        lblHora.setForeground(new java.awt.Color(42, 36, 56));
        lblHora.setText("7:00 am");

        lblDia.setFont(new java.awt.Font("Roboto Black", 1, 14)); // NOI18N
        lblDia.setForeground(new java.awt.Color(42, 36, 56));
        lblDia.setText("THU");

        lblSun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-sun.png"))); // NOI18N

        lblNight.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Night.png"))); // NOI18N

        lblSunset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/sunset.png"))); // NOI18N

        javax.swing.GroupLayout PanelFechaLayout = new javax.swing.GroupLayout(PanelFecha);
        PanelFecha.setLayout(PanelFechaLayout);
        PanelFechaLayout.setHorizontalGroup(
            PanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFechaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(PanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDia)
                    .addComponent(lblHora))
                .addGap(30, 30, 30)
                .addGroup(PanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNight)
                    .addComponent(lblSunset)
                    .addComponent(lblSun)))
        );
        PanelFechaLayout.setVerticalGroup(
            PanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelFechaLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblDia)
                .addGap(3, 3, 3)
                .addComponent(lblHora))
            .addGroup(PanelFechaLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(PanelFechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNight, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSunset, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblSun, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(PanelMO, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelFecha, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelDatosUs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(PanelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PanelMO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(PanelDatosUs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)))
                .addGap(1, 1, 1))
        );

        javax.swing.GroupLayout pnlNorthFormLayout = new javax.swing.GroupLayout(pnlNorthForm);
        pnlNorthForm.setLayout(pnlNorthFormLayout);
        pnlNorthFormLayout.setHorizontalGroup(
            pnlNorthFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthFormLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtBuscador, javax.swing.GroupLayout.DEFAULT_SIZE, 795, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12))
        );
        pnlNorthFormLayout.setVerticalGroup(
            pnlNorthFormLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlNorthFormLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(txtBuscador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
            .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        PanelContenedor.add(pnlNorthForm, java.awt.BorderLayout.NORTH);

        PanelContenedorForms.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorForms.setRoundBottomLeft(20);
        PanelContenedorForms.setRoundBottomRight(20);
        PanelContenedorForms.setLayout(new javax.swing.BoxLayout(PanelContenedorForms, javax.swing.BoxLayout.LINE_AXIS));
        PanelContenedor.add(PanelContenedorForms, java.awt.BorderLayout.CENTER);

        jPanel3.add(PanelContenedor, java.awt.BorderLayout.CENTER);

        panelFondo.add(jPanel3, java.awt.BorderLayout.CENTER);

        pnlWest.setBackground(new java.awt.Color(42, 36, 56));
        pnlWest.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(42, 36, 56));
        pnlWest.add(jPanel4, java.awt.BorderLayout.SOUTH);

        jPanel5.setBackground(new java.awt.Color(42, 36, 56));
        pnlWest.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(42, 36, 56));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnDashboard.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/casita-menu.png"))); // NOI18N
        btnDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnDashboard.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDashboardMouseClicked(evt);
            }
        });
        jPanel8.add(btnDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 75, -1, -1));

        btnUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/usuario-menu.png"))); // NOI18N
        btnUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUsuariosMouseClicked(evt);
            }
        });
        jPanel8.add(btnUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 135, -1, -1));

        btnPersonal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/personal-menu.png"))); // NOI18N
        btnPersonal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnPersonal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPersonalMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnPersonalMouseExited(evt);
            }
        });
        jPanel8.add(btnPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 195, -1, -1));

        btnCarnets.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/carnets-menu.png"))); // NOI18N
        btnCarnets.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCarnets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCarnetsMouseClicked(evt);
            }
        });
        jPanel8.add(btnCarnets, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 255, -1, -1));

        btnVehiculos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/vehiculo-menu.png"))); // NOI18N
        btnVehiculos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVehiculosMouseClicked(evt);
            }
        });
        jPanel8.add(btnVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 315, -1, 40));

        panelSeleccionVehiculos.setBackground(new java.awt.Color(58, 50, 75));
        panelSeleccionVehiculos.setPreferredSize(new java.awt.Dimension(122, 67));
        panelSeleccionVehiculos.setRoundBottomLeft(20);
        panelSeleccionVehiculos.setRoundBottomRight(20);
        panelSeleccionVehiculos.setRoundTopLeft(20);
        panelSeleccionVehiculos.setRoundTopRight(20);
        panelSeleccionVehiculos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSeleccionVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 50, 50));

        btnParqueo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/parqueo-menu.png"))); // NOI18N
        btnParqueo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnParqueo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnParqueoMouseClicked(evt);
            }
        });
        jPanel8.add(btnParqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 375, 30, -1));

        btnAjustes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/ajustes.png"))); // NOI18N
        btnAjustes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAjustesMouseClicked(evt);
            }
        });
        jPanel8.add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 556, 40, 40));

        panelSeleccionAjustes.setBackground(new java.awt.Color(58, 50, 75));
        panelSeleccionAjustes.setPreferredSize(new java.awt.Dimension(122, 67));
        panelSeleccionAjustes.setRoundBottomLeft(20);
        panelSeleccionAjustes.setRoundBottomRight(20);
        panelSeleccionAjustes.setRoundTopLeft(20);
        panelSeleccionAjustes.setRoundTopRight(20);
        panelSeleccionAjustes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSeleccionAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, 50, 50));

        btnAccesos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/accesos-menu.png"))); // NOI18N
        btnAccesos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnAccesos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAccesosMouseClicked(evt);
            }
        });
        jPanel8.add(btnAccesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 435, 40, 40));

        btnLogOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/log-out.png"))); // NOI18N
        btnLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnLogOut.setPreferredSize(new java.awt.Dimension(35, 35));
        btnLogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogOutMouseClicked(evt);
            }
        });
        jPanel8.add(btnLogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 658, -1, -1));

        panelSeleccionLogout.setBackground(new java.awt.Color(58, 50, 75));
        panelSeleccionLogout.setPreferredSize(new java.awt.Dimension(122, 67));
        panelSeleccionLogout.setRoundBottomLeft(20);
        panelSeleccionLogout.setRoundBottomRight(20);
        panelSeleccionLogout.setRoundTopLeft(20);
        panelSeleccionLogout.setRoundTopRight(20);
        panelSeleccionLogout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSeleccionLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 650, 50, 50));

        btnContactos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/contactos-menu.png"))); // NOI18N
        btnContactos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContactosMouseClicked(evt);
            }
        });
        jPanel8.add(btnContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(18, 495, 40, 40));

        panelSeleccionContactos.setBackground(new java.awt.Color(58, 50, 75));
        panelSeleccionContactos.setPreferredSize(new java.awt.Dimension(122, 67));
        panelSeleccionContactos.setRoundBottomLeft(20);
        panelSeleccionContactos.setRoundBottomRight(20);
        panelSeleccionContactos.setRoundTopLeft(20);
        panelSeleccionContactos.setRoundTopRight(20);
        panelSeleccionContactos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSeleccionContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 50, 50));

        panelSeleccionAccesos.setBackground(new java.awt.Color(58, 50, 75));
        panelSeleccionAccesos.setPreferredSize(new java.awt.Dimension(122, 67));
        panelSeleccionAccesos.setRoundBottomLeft(20);
        panelSeleccionAccesos.setRoundBottomRight(20);
        panelSeleccionAccesos.setRoundTopLeft(20);
        panelSeleccionAccesos.setRoundTopRight(20);
        panelSeleccionAccesos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSeleccionAccesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 430, 50, 50));

        panelSeleccionParqueo.setBackground(new java.awt.Color(58, 50, 75));
        panelSeleccionParqueo.setPreferredSize(new java.awt.Dimension(122, 67));
        panelSeleccionParqueo.setRoundBottomLeft(20);
        panelSeleccionParqueo.setRoundBottomRight(20);
        panelSeleccionParqueo.setRoundTopLeft(20);
        panelSeleccionParqueo.setRoundTopRight(20);
        panelSeleccionParqueo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSeleccionParqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 50, 50));

        panelSeleccionCarnets.setBackground(new java.awt.Color(58, 50, 75));
        panelSeleccionCarnets.setPreferredSize(new java.awt.Dimension(122, 67));
        panelSeleccionCarnets.setRoundBottomLeft(20);
        panelSeleccionCarnets.setRoundBottomRight(20);
        panelSeleccionCarnets.setRoundTopLeft(20);
        panelSeleccionCarnets.setRoundTopRight(20);
        panelSeleccionCarnets.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSeleccionCarnets, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 50, 50));

        panelSeleccionPersonal.setBackground(new java.awt.Color(58, 50, 75));
        panelSeleccionPersonal.setPreferredSize(new java.awt.Dimension(122, 67));
        panelSeleccionPersonal.setRoundBottomLeft(20);
        panelSeleccionPersonal.setRoundBottomRight(20);
        panelSeleccionPersonal.setRoundTopLeft(20);
        panelSeleccionPersonal.setRoundTopRight(20);
        panelSeleccionPersonal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(panelSeleccionPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 50, 50));

        PanelSeleccionUsuario.setBackground(new java.awt.Color(58, 50, 75));
        PanelSeleccionUsuario.setPreferredSize(new java.awt.Dimension(122, 67));
        PanelSeleccionUsuario.setRoundBottomLeft(20);
        PanelSeleccionUsuario.setRoundBottomRight(20);
        PanelSeleccionUsuario.setRoundTopLeft(20);
        PanelSeleccionUsuario.setRoundTopRight(20);
        PanelSeleccionUsuario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(PanelSeleccionUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 50, 50));

        PanelSeleccionDashboard.setBackground(new java.awt.Color(58, 50, 75));
        PanelSeleccionDashboard.setPreferredSize(new java.awt.Dimension(122, 67));
        PanelSeleccionDashboard.setRoundBottomLeft(20);
        PanelSeleccionDashboard.setRoundBottomRight(20);
        PanelSeleccionDashboard.setRoundTopLeft(20);
        PanelSeleccionDashboard.setRoundTopRight(20);
        PanelSeleccionDashboard.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel8.add(PanelSeleccionDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 50, 50));

        jPanel6.add(jPanel8, java.awt.BorderLayout.CENTER);

        pnlWest.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setBackground(new java.awt.Color(42, 36, 56));
        pnlWest.add(jPanel7, java.awt.BorderLayout.LINE_END);

        panelFondo.add(pnlWest, java.awt.BorderLayout.WEST);

        pnlNorth.setBackground(new java.awt.Color(42, 36, 56));
        pnlNorth.setPreferredSize(new java.awt.Dimension(100, 25));
        pnlNorth.setLayout(new java.awt.BorderLayout());

        pnlModifWin.setBackground(new java.awt.Color(42, 36, 56));
        pnlModifWin.setPreferredSize(new java.awt.Dimension(55, 100));
        pnlModifWin.setRequestFocusEnabled(false);
        pnlModifWin.setLayout(new java.awt.BorderLayout());

        jPanel1.setBackground(new java.awt.Color(42, 36, 56));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMinimizarMousePressed(evt);
            }
        });
        jPanel1.add(btnMinimizar);

        btnMaximizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/MinimizarLogin.png"))); // NOI18N
        btnMaximizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMaximizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnMaximizarMousePressed(evt);
            }
        });
        jPanel1.add(btnMaximizar);

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMousePressed(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        jPanel1.add(btnCerrar);

        pnlModifWin.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(42, 36, 56));
        jPanel2.setPreferredSize(new java.awt.Dimension(100, 5));
        pnlModifWin.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pnlNorth.add(pnlModifWin, java.awt.BorderLayout.EAST);

        pnlFilled.setBackground(new java.awt.Color(42, 36, 56));
        pnlFilled.setPreferredSize(new java.awt.Dimension(1000, 100));
        pnlFilled.setLayout(new java.awt.BorderLayout());
        pnlNorth.add(pnlFilled, java.awt.BorderLayout.CENTER);

        panelFondo.add(pnlNorth, java.awt.BorderLayout.NORTH);

        pnlSourth.setBackground(new java.awt.Color(42, 36, 56));
        pnlSourth.setPreferredSize(new java.awt.Dimension(0, 15));
        pnlSourth.setLayout(new java.awt.BorderLayout());
        panelFondo.add(pnlSourth, java.awt.BorderLayout.SOUTH);

        pnlEast.setBackground(new java.awt.Color(42, 36, 56));
        pnlEast.setPreferredSize(new java.awt.Dimension(10, 100));
        pnlEast.setLayout(new java.awt.BorderLayout());
        panelFondo.add(pnlEast, java.awt.BorderLayout.EAST);

        getContentPane().add(panelFondo);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    PanelOpcionesPersonal _oppersonal = new PanelOpcionesPersonal();
    Point point = MouseInfo.getPointerInfo().getLocation();

    FrmPersonalSinCarnet addCarnet = new FrmPersonalSinCarnet();
    FrmAgg_Usuarios addUsuarios = new FrmAgg_Usuarios();
    FrmAgg_Personal addPersonal = new FrmAgg_Personal();
    FrmPersonal_AggVehiculo addVehiculo = new FrmPersonal_AggVehiculo();

    @Override
    public synchronized int getState() {
        return super.getState(); //To change body of generated methods, choose Tools | Templates.
    }

    public void Niveles(String pnivel) {

        switch (pnivel) {
            case "Root":
                //Root

                break;
            case "Administrador":
                //Admin
                btnParqueo.setVisible(false);
                btnAccesos.setVisible(false);
                btnVehiculos.setVisible(false);
                break;
            case "Docente":
                btnParqueo.setVisible(false);
                btnAccesos.setVisible(false);
                btnVehiculos.setVisible(false);
                btnUsuarios.setVisible(false);
                btnContactos.setVisible(false);
                break;
            case "Alumno":
                btnParqueo.setVisible(false);
                btnAccesos.setVisible(false);
                btnVehiculos.setVisible(false);
                btnUsuarios.setVisible(false);
                btnContactos.setVisible(false);
                btnCarnets.setVisible(false);
                btnPersonal.setVisible(false);
                break;
            case "Seguridad":
                btnUsuarios.setVisible(false);
                btnContactos.setVisible(false);
                btnCarnets.setVisible(false);
                btnPersonal.setVisible(false);
                break;
        }
    }

    void capturariduser() {
        clog.setUsuario(lblNombre.getText());
        ResultSet rs=clog.validaruseractive();
        try {
            if (rs.next()) {
                iduser=rs.getInt("idUsuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmDashboard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //Interface mode
    void DarkMode() {

        lblNormal.setVisible(true);
        pnlNorth.setBackground(new Color(32, 34, 37));
        lblUsuarioDark.setVisible(true);
        panelFondo.setBackground(new Color(32, 34, 37));
        PanelContenedor.setBackground(new Color(47, 49, 54));
        PanelMO.setBackground(new Color(32, 34, 37));
        PanelFecha.setBackground(new Color(32, 34, 37));
        PanelDatosUs.setBackground(new Color(32, 34, 37));
        lblDia.setForeground(Color.WHITE);
        lblHora.setForeground(Color.WHITE);
        pnlNorthForm.setBackground(new Color(47, 49, 54));
        jPanel5.setBackground(new Color(32, 34, 37));
        lblNombre.setForeground(Color.WHITE);
        lblTipo.setForeground(Color.WHITE);
        jPanel8.setBackground(new Color(32, 34, 37));
        jPanel7.setBackground(new Color(32, 34, 37));
        pnlSourth.setBackground(new Color(32, 34, 37));
        jPanel1.setBackground(new Color(32, 34, 37));
        jPanel2.setBackground(new Color(32, 34, 37));
        jPanel4.setBackground(new Color(32, 34, 37));
        pnlEast.setBackground(new Color(32, 34, 37));
        jPanel9.setBackground(new Color(47, 49, 54));
        txtBuscador.setBackground(new Color(32, 34, 37));
        txtBuscador.setForeground(Color.WHITE);
        txtBuscador.setCaretColor(Color.WHITE);
        pnlFilled.setBackground(new Color(32, 34, 37));
        PanelContenedorForms.setBackground(new Color(47, 49, 54));
    }

    void NormalMode() {

        lblNormal.setVisible(false);
        lblUsuarioDark.setVisible(false);
        panelFondo.setBackground(new Color(42, 36, 56));
        PanelContenedor.setBackground(new Color(231, 234, 239));
        PanelMO.setBackground(new Color(253, 255, 254));
        PanelFecha.setBackground(new Color(253, 255, 254));
        PanelDatosUs.setBackground(new Color(253, 255, 254));
        lblDia.setForeground(new Color(42, 36, 56));
        lblHora.setForeground(new Color(42, 36, 56));
        lblNombre.setForeground(new Color(42, 36, 56));
        lblTipo.setForeground(new Color(42, 36, 56));
        txtBuscador.setBackground(new Color(253, 255, 254));
        txtBuscador.setForeground(new Color(42, 36, 56));
        txtBuscador.setCaretColor(new Color(42, 36, 56));
        pnlNorth.setBackground(new Color(231, 234, 239));
        pnlNorthForm.setBackground(new Color(231, 234, 239));
        jPanel5.setBackground(new Color(42, 36, 56));
        jPanel8.setBackground(new Color(42, 36, 56));
        jPanel7.setBackground(new Color(42, 36, 56));
        pnlSourth.setBackground(new Color(42, 36, 56));
        jPanel1.setBackground(new Color(42, 36, 56));
        jPanel2.setBackground(new Color(42, 36, 56));
        jPanel4.setBackground(new Color(42, 36, 56));
        pnlEast.setBackground(new Color(42, 36, 56));
        jPanel9.setBackground(new Color(231, 234, 239));
        pnlFilled.setBackground(new Color(42, 36, 56));
    }

    //show Panel Action
    //Cierra los demás panels
    //agrega sobre el panel contenedor el que se quiere modificar
    //y cierra los formularios hijos abiertos <-- EN PRUEBAS
    public void showPanelDash() {
        PanelSeleccionDashboard.setVisible(true);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionLogout.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionAjustes.setVisible(false);

        pld.setSize(1270, 620);
        pld.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pld);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelUsers() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(true);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionLogout.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionAjustes.setVisible(false);

        pu.setSize(1270, 620);
        pu.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pu);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelStudents() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(true);
        panelSeleccionLogout.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionAjustes.setVisible(false);

        PanelEstudiantes pl = new PanelEstudiantes();
        pl.setSize(1270, 620);
        pl.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pl);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelTeachers() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionLogout.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionAjustes.setVisible(false);

        PanelProfesores pl = new PanelProfesores();
        pl.setSize(1270, 620);
        pl.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pl);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelCarn() {
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(true);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionAjustes.setVisible(false);
        panelSeleccionLogout.setVisible(false);

        PanelCarnets pl = new PanelCarnets();
        pl.setSize(1270, 620);
        pl.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pl);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelCars() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(true);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionAjustes.setVisible(false);
        panelSeleccionLogout.setVisible(false);

        PanelVehiculos pl = new PanelVehiculos();
        pl.setSize(1270, 620);
        pl.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pl);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelPark() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(true);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionAjustes.setVisible(false);
        panelSeleccionLogout.setVisible(false);

        PanelParqueo pl = new PanelParqueo();
        pl.setSize(1270, 620);
        pl.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pl);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelConts() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(true);
        panelSeleccionAjustes.setVisible(false);
        panelSeleccionLogout.setVisible(false);

        PanelContactos pl = new PanelContactos();
        pl.setSize(1270, 620);
        pl.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pl);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelSett() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionLogout.setVisible(false);
        panelSeleccionAjustes.setVisible(true);

        PanelAjustes pl = new PanelAjustes(lblNombre.getText());
        pl.setSize(1270, 620);
        pl.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pl);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    public void showPanelAcces() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(true);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionLogout.setVisible(false);
        panelSeleccionAjustes.setVisible(false);

        PanelAccesos pl = new PanelAccesos(tipousuario);
        pl.setSize(1270, 620);
        pl.setLocation(0, 0);

        PanelContenedorForms.removeAll();
        PanelContenedorForms.add(pl);
        PanelContenedorForms.revalidate();
        PanelContenedorForms.repaint();
    }

    void showPnlOptionsPers(/*double x, double y*/Point p) {
        if (_oppersonal.isShowing()) {
            _oppersonal.setVisible(true);
        } else {
            _oppersonal.setVisible(true);
            _oppersonal.setLocation(p);
        }
    }

    public void showPanelOptionPers() {//obtiene donde esta el boton y muestra el JFrame en la posición cercana del button

        if (_oppersonal.isShowing()) {
            _oppersonal.setVisible(true);
        } else {
            _oppersonal.setVisible(true);
            //MODIFICAR LAS MEDIDAS DONDE SALGA A LA PAR DEL BOTON
            //DISCUTIR, POR SI ALGUIEN TIENE MEJOR IDEA
            int x = btnPersonal.getX();
            int y = btnPersonal.getY();
            _oppersonal.setLocation(x + 354, y + 110);
        }
        /*panelOpcionesPersonal.setVisible(true);*/
        //this.showp
    }

    public void Logout() {
        PanelSeleccionDashboard.setVisible(false);
        PanelSeleccionUsuario.setVisible(false);
        panelSeleccionPersonal.setVisible(false);
        panelSeleccionCarnets.setVisible(false);
        panelSeleccionVehiculos.setVisible(false);
        panelSeleccionParqueo.setVisible(false);
        panelSeleccionAccesos.setVisible(false);
        panelSeleccionContactos.setVisible(false);
        panelSeleccionLogout.setVisible(true);
        panelSeleccionAjustes.setVisible(false);
        capturariduser();
        clog.setIdestado(2);
        clog.setIdusuario(iduser);
        if (clog.ActualizarEstado()==true) {
            System.out.println("Si se pudo y ahora esta inactivo");
        }
        FrmLogin login = new FrmLogin();
        login.setVisible(true);
        this.dispose();
    }

    PanelDashboard _pnldash = new PanelDashboard();
    PanelUsuarios_dashbord _pnlusers = new PanelUsuarios_dashbord();

    private void lblNormalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNormalMouseClicked
        // TODO add your handling code here:
        ValidacionesSistema.ValidacionesBeep_Go.Modo = 2;
        NormalMode();
        pld.mode();
        pu.darkmod();
        if (_pnldash.isShowing()) {

            _pnldash.hide();
            showPanelDash();
        }
    }//GEN-LAST:event_lblNormalMouseClicked

    private void btnMOMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMOMouseClicked
        // TODO add your handling code here:
        ValidacionesSistema.ValidacionesBeep_Go.Modo = 1;
        DarkMode();
        pld.mode();
        pu.darkmod();
        _pnldash.hide();
        if (_pnldash.isVisible()) {

            showPanelDash();
        }
    }//GEN-LAST:event_btnMOMouseClicked

    private void btnDashboardMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDashboardMouseClicked
        this.showPanelDash();
        PanelOpcionesPersonal.showinter = 4;
        // valor = 1;
        //JOptionPane.showMessageDialog(null, "El valor del atributo es" + valor);
    }//GEN-LAST:event_btnDashboardMouseClicked

    private void btnUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUsuariosMouseClicked
        this.showPanelUsers();
        PanelOpcionesPersonal.showinter = 3;
    }//GEN-LAST:event_btnUsuariosMouseClicked

    private void btnPersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMouseClicked
        //showPanelOptionPers(); 
        /*if (getState() == MAXIMIZED_BOTH) {
            int x = btnPersonal.getX();
            int y = btnPersonal.getY();
            showPnlOptionsPers(x, y);
        }else{
            showPanelOptionPers();
        }*/
        PointerInfo pi = MouseInfo.getPointerInfo();
        Point p = pi.getLocation();
        System.out.println(p.getLocation());
        showPnlOptionsPers(p.getLocation());
    }//GEN-LAST:event_btnPersonalMouseClicked

    private void btnCarnetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCarnetsMouseClicked
        this.showPanelCarn();
        PanelOpcionesPersonal.showinter = 5;
    }//GEN-LAST:event_btnCarnetsMouseClicked

    private void btnVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVehiculosMouseClicked
        this.showPanelCars();
        PanelOpcionesPersonal.showinter = 6;
    }//GEN-LAST:event_btnVehiculosMouseClicked

    private void btnParqueoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnParqueoMouseClicked
        this.showPanelPark();
        PanelOpcionesPersonal.showinter = 7;
    }//GEN-LAST:event_btnParqueoMouseClicked

    private void btnContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContactosMouseClicked
        this.showPanelConts();
        PanelOpcionesPersonal.showinter = 8;
    }//GEN-LAST:event_btnContactosMouseClicked

    private void btnAjustesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMouseClicked
        this.showPanelSett();
        PanelOpcionesPersonal.showinter = 10;
    }//GEN-LAST:event_btnAjustesMouseClicked

    private void btnAccesosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAccesosMouseClicked
        this.showPanelAcces();
        PanelOpcionesPersonal.showinter = 9;
    }//GEN-LAST:event_btnAccesosMouseClicked

    private void btnMinimizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMousePressed
        //System.exit(0);
        setState(ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMousePressed

    private void btnPersonalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPersonalMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPersonalMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        switch (PanelOpcionesPersonal.getShowinter()) {
            case 0:
                break;
            case 1:
                showPanelStudents();
                break;
            case 2:
                showPanelTeachers();
                break;
            case 3:
                showPanelUsers();
                break;
            case 4:
                showPanelDash();
                break;
            case 5:
                showPanelCarn();
                break;
            case 6:
                showPanelCars();
                break;
            case 7:
                showPanelPark();
                break;
            case 8:
                showPanelConts();
                break;
            case 9:
                showPanelAcces();
                break;
            case 10:
                showPanelSett();
                break;
            default:
                break;
        }
        switch (ValidacionesSistema.ValidacionesBeep_Go.getModo()) {
            case 1:
                break;
        }

        /*PanelParqueo pnlPark = new PanelParqueo();
        pnlPark.getdataPark();*/
    }//GEN-LAST:event_formWindowActivated

    private void btnLogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogOutMouseClicked
        int cal = JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesion?", "Cerrar sesion", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if (cal == 0) {
            Logout();
        }
    }//GEN-LAST:event_btnLogOutMouseClicked

    void Evaluador1() {
        this.setSize(1366, 768);
        ev = 1;
        setLocationRelativeTo(null);
    }

    void Evaluador2() {
        this.setExtendedState(MAXIMIZED_BOTH);
        final java.awt.Point x = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        new Thread(new Runnable() {
            @Override
            public void run() {
                if (x.equals(GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint())) {
                    Rectangle r = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
                    setSize(r.getSize());
                }
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {

                }
            }
        }).start();

        ev = 2;
    }

    private void btnMaximizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMaximizarMousePressed

        if (ev == 1) {
            Evaluador2();
        } else {
            Evaluador1();
        }
    }//GEN-LAST:event_btnMaximizarMousePressed


    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMousePressed


    private void txtBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscadorActionPerformed

    private void txtBuscadorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscadorKeyPressed
        // TODO add your handling code here:
        //if (valor == 1) {
        // res.ResBusqueda();
        //}
    }//GEN-LAST:event_txtBuscadorKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Paneles.PanelRound PanelContenedor;
    public Controles_Personalizados.Paneles.PanelRound PanelContenedorForms;
    private Controles_Personalizados.Paneles.PanelRound PanelDatosUs;
    private Controles_Personalizados.Paneles.PanelRound PanelFecha;
    private Controles_Personalizados.Paneles.PanelRound PanelMO;
    private Controles_Personalizados.Paneles.PanelRound PanelSeleccionDashboard;
    private Controles_Personalizados.Paneles.PanelRound PanelSeleccionUsuario;
    private javax.swing.JLabel btnAccesos;
    private javax.swing.JLabel btnAjustes;
    private javax.swing.JLabel btnCarnets;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnContactos;
    private javax.swing.JLabel btnDashboard;
    private javax.swing.JLabel btnLogOut;
    private javax.swing.JLabel btnMO;
    private javax.swing.JLabel btnMaximizar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel btnParqueo;
    private javax.swing.JLabel btnPersonal;
    private javax.swing.JLabel btnUsuarios;
    private javax.swing.JLabel btnVehiculos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lblDia;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblNight;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNormal;
    private javax.swing.JLabel lblSun;
    private javax.swing.JLabel lblSunset;
    private javax.swing.JLabel lblTipo;
    private javax.swing.JLabel lblUsuario;
    private javax.swing.JLabel lblUsuarioDark;
    private Controles_Personalizados.Paneles.PanelRound panelFondo;
    private Controles_Personalizados.Paneles.PanelRound panelSeleccionAccesos;
    private Controles_Personalizados.Paneles.PanelRound panelSeleccionAjustes;
    private Controles_Personalizados.Paneles.PanelRound panelSeleccionCarnets;
    private Controles_Personalizados.Paneles.PanelRound panelSeleccionContactos;
    private Controles_Personalizados.Paneles.PanelRound panelSeleccionLogout;
    private Controles_Personalizados.Paneles.PanelRound panelSeleccionParqueo;
    private Controles_Personalizados.Paneles.PanelRound panelSeleccionPersonal;
    private Controles_Personalizados.Paneles.PanelRound panelSeleccionVehiculos;
    private javax.swing.JPanel pnlEast;
    private javax.swing.JPanel pnlFilled;
    private javax.swing.JPanel pnlModifWin;
    private javax.swing.JPanel pnlNorth;
    private Controles_Personalizados.Paneles.PanelRound pnlNorthForm;
    private javax.swing.JPanel pnlSourth;
    private javax.swing.JPanel pnlWest;
    private Controles_Personalizados.textfields.TextFieldSuggestion txtBuscador;
    // End of variables declaration//GEN-END:variables

}
