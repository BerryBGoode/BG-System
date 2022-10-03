/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.sun.awt.AWTUtilities;
import java.awt.AWTEvent;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;
import Controles_Personalizados.RenderTable;
import java.awt.Color;
import java.awt.Font;
import Controles_Personalizados.Tables.Table;
import Controlador.ControllerParqueo;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;
import Controles_Personalizados.Botones.UWPButton;
import javax.swing.ImageIcon;
import net.sf.jasperreports.web.servlets.Controller;

/**
 *
 * @author ferna
 */
public class FrmSetPark extends javax.swing.JFrame {

    private final UWPButton _btnAgregarCar = new UWPButton();
    private final UWPButton _btnAgregarAccs = new UWPButton();
    ImageIcon iconAdd = new ImageIcon(getClass().getResource("/Recursos_Proyecto/Agregar.png"));

    public Font font = new Font("Roboto Black", Font.PLAIN, 18);

    ControllerParqueo park = new ControllerParqueo();

    public static int action;

    /**
     * Creates new form FrmSetPark
     */
    /**
     * *
     *
     * @param ID
     */
    public FrmSetPark(String ID, int station) {
        initComponents();
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());

        String[] headeracces = {"IDAcceso", "Carnet", "Fecha", "IDCarnet", "Hora", "Acceso", "Notificación", "Agregar"};
        String[] headercars = {"IDPersonal", "Carnet", "IDVehiculo", "Nombres", "Apellidos", "Placa", "Color", "Agregar"};

        modeltableaccess = new DefaultTableModel(null, headeracces);
        modeltablecars = new DefaultTableModel(null, headercars);

        TbAcesosWhite.setModel(modeltableaccess);
        TbVehiculosWhite.setModel(modeltablecars);

        getAccess();
        //Por alguna razón me omite una columna y pasa a la otra Dx y lo mismo con la tabla vehiculos        
        TbAcesosWhite.removeColumn(TbAcesosWhite.getColumnModel().getColumn(0));
        TbAcesosWhite.removeColumn(TbAcesosWhite.getColumnModel().getColumn(2));

        TbVehiculosWhite.removeColumn(TbVehiculosWhite.getColumnModel().getColumn(0));
        TbVehiculosWhite.removeColumn(TbVehiculosWhite.getColumnModel().getColumn(1));

        TbAcesosWhite.setDefaultRenderer(Object.class, new RenderTable());
        TbVehiculosWhite.setDefaultRenderer(Object.class, new RenderTable());
        TbAcesosWhite.setFont(font);
        TbVehiculosWhite.setFont(font);
        txtIDPark.setText(ID);
        txtStation.setText(String.valueOf(station));
        txtStation.setVisible(false);
        txtIDPark.setVisible(false);
        chkCantbAcess.setFont(font);
        chkCantbCars.setFont(font);
        chkCantbAcess.setForeground(Color.GRAY);
        chkCantbCars.setForeground(Color.gray);
        chkCantbAcess.setEnabled(false);
        chkCantbCars.setEnabled(false);
        txtIDDetail.setVisible(false);
        txtIDDetail.setText(String.valueOf(getIDDetail()));
    }

    public FrmSetPark() {
        initComponents();
    }

    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        btnListo = new Controles_Personalizados.Botones.ButtonGradient();
        lblStation = new javax.swing.JLabel();
        lblParkname1 = new javax.swing.JLabel();
        lblParkname2 = new javax.swing.JLabel();
        txtIDPark = new javax.swing.JTextField();
        chkCantbAcess = new javax.swing.JCheckBox();
        chkCantbCars = new javax.swing.JCheckBox();
        txtStation = new javax.swing.JTextField();
        btnActualizar = new Controles_Personalizados.Botones.ButtonGradient();
        txtIDDetail = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        scrollBarCustom2 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        PanelTabla2 = new javax.swing.JScrollPane();
        TbAcesosWhite = new Controles_Personalizados.Tables.Table();
        jPanel1 = new javax.swing.JPanel();
        scrollBarCustom1 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        PanelTabla1 = new javax.swing.JScrollPane();
        TbVehiculosWhite = new Controles_Personalizados.Tables.Table();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1205, 747));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        panelRound1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 10, -1, -1));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        panelRound1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 10, -1, -1));

        btnListo.setBackground(new java.awt.Color(42, 36, 56));
        btnListo.setForeground(new java.awt.Color(58, 50, 75));
        btnListo.setText("Listo");
        btnListo.setColor1(new java.awt.Color(253, 255, 254));
        btnListo.setColor2(new java.awt.Color(253, 255, 254));
        btnListo.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnListo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListoActionPerformed(evt);
            }
        });
        panelRound1.add(btnListo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 690, 150, -1));

        lblStation.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        lblStation.setForeground(new java.awt.Color(253, 255, 254));
        lblStation.setText("Station");
        panelRound1.add(lblStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 10, 320, 40));

        lblParkname1.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        lblParkname1.setForeground(new java.awt.Color(253, 255, 254));
        lblParkname1.setText("VEHICULOS");
        panelRound1.add(lblParkname1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, -1, 40));

        lblParkname2.setFont(new java.awt.Font("Roboto Medium", 0, 36)); // NOI18N
        lblParkname2.setForeground(new java.awt.Color(253, 255, 254));
        lblParkname2.setText("ACCESOS");
        panelRound1.add(lblParkname2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 40));
        panelRound1.add(txtIDPark, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, 20, -1));

        chkCantbAcess.setBackground(new java.awt.Color(58, 50, 75));
        chkCantbAcess.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        chkCantbAcess.setText("Cancelar");
        chkCantbAcess.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCantbAcessActionPerformed(evt);
            }
        });
        panelRound1.add(chkCantbAcess, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, -1, -1));

        chkCantbCars.setBackground(new java.awt.Color(58, 50, 75));
        chkCantbCars.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        chkCantbCars.setText("Cancelar");
        chkCantbCars.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCantbCarsActionPerformed(evt);
            }
        });
        panelRound1.add(chkCantbCars, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 385, -1, -1));
        panelRound1.add(txtStation, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 30, -1));

        btnActualizar.setBackground(new java.awt.Color(42, 36, 56));
        btnActualizar.setForeground(new java.awt.Color(58, 50, 75));
        btnActualizar.setText("Listo");
        btnActualizar.setColor1(new java.awt.Color(253, 255, 254));
        btnActualizar.setColor2(new java.awt.Color(253, 255, 254));
        btnActualizar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        panelRound1.add(btnActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 690, 150, -1));
        panelRound1.add(txtIDDetail, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 40, 30, -1));

        jPanel3.setBackground(new java.awt.Color(58, 50, 75));
        jPanel3.setLayout(new java.awt.BorderLayout());

        scrollBarCustom2.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom2.setForeground(new java.awt.Color(58, 50, 75));
        jPanel3.add(scrollBarCustom2, java.awt.BorderLayout.EAST);

        PanelTabla2.setMinimumSize(new java.awt.Dimension(15, 26));
        PanelTabla2.setPreferredSize(new java.awt.Dimension(461, 403));
        PanelTabla2.setVerticalScrollBar(scrollBarCustom2);

        TbAcesosWhite = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TbAcesosWhite.setBackground(new java.awt.Color(231, 234, 239));
        TbAcesosWhite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Carnet", "Fecha", "Hora", "Acceso", "Notificación", "Agregar"
            }
        ));
        TbAcesosWhite.setGridColor(new java.awt.Color(58, 50, 75));
        TbAcesosWhite.setPreferredSize(new java.awt.Dimension(450, 880));
        TbAcesosWhite.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbAcesosWhite.setShowVerticalLines(false);
        TbAcesosWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbAcesosWhiteMouseClicked(evt);
            }
        });
        PanelTabla2.setViewportView(TbAcesosWhite);

        jPanel3.add(PanelTabla2, java.awt.BorderLayout.CENTER);

        panelRound1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 115, 1130, 240));

        jPanel1.setBackground(new java.awt.Color(58, 50, 75));
        jPanel1.setLayout(new java.awt.BorderLayout());

        scrollBarCustom1.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom1.setForeground(new java.awt.Color(58, 50, 75));
        jPanel1.add(scrollBarCustom1, java.awt.BorderLayout.EAST);

        PanelTabla1.setMinimumSize(new java.awt.Dimension(15, 26));
        PanelTabla1.setPreferredSize(new java.awt.Dimension(461, 403));
        PanelTabla1.setVerticalScrollBar(scrollBarCustom1);

        TbVehiculosWhite = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TbVehiculosWhite.setBackground(new java.awt.Color(231, 234, 239));
        TbVehiculosWhite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Carnet", "Nombre", "Apellido", "Placa", "Color", "Agregar"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TbVehiculosWhite.setGridColor(new java.awt.Color(58, 50, 75));
        TbVehiculosWhite.setPreferredSize(new java.awt.Dimension(450, 880));
        TbVehiculosWhite.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbVehiculosWhite.setShowVerticalLines(false);
        TbVehiculosWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbVehiculosWhiteMouseClicked(evt);
            }
        });
        PanelTabla1.setViewportView(TbVehiculosWhite);

        jPanel1.add(PanelTabla1, java.awt.BorderLayout.CENTER);

        panelRound1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 1130, 240));

        getContentPane().add(panelRound1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private static String parkname;
    private boolean confir;
    private int IDPark;
    private static int IDStation;
    private static int IDDetail;

    public static String getParkname() {
        return parkname;
    }

    public static void setParkname(String parkname) {
        FrmSetPark.parkname = parkname;
    }

    public int getIDPark() {
        return IDPark;
    }

    public void setIDPark(int IDPark) {
        this.IDPark = IDPark;
    }

    public static int getIDStation() {
        return IDStation;
    }

    public static void setIDStation(int IDStation) {
        FrmSetPark.IDStation = IDStation;
    }

    public static int getIDDetail() {
        return IDDetail;
    }

    public static void setIDDetail(int IDDetail) {
        FrmSetPark.IDDetail = IDDetail;
    }

    DefaultTableModel modeltableaccess;
    DefaultTableModel modeltablecars;

    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        this.hide();
        FrmConfigPark.visibleFrm = false;
    }//GEN-LAST:event_btnCerrarMousePressed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated

        lblStation.setText(("Estacionamiento " + parkname));
        if (action == 1) {
            btnActualizar.setVisible(true);
            btnListo.setVisible(false);
        } else {
            btnActualizar.setVisible(false);
            btnListo.setVisible(true);
        }
    }//GEN-LAST:event_formWindowActivated

    FrmConfigPark configpark = new FrmConfigPark();

    boolean updatePark() {
        boolean val;
        ControllerParqueo.setIDDetail(getIDDetail());
        if (park.getIDAcceso() > 0 && park.getIDVehiculo() > 0 && park.getIDEstacionamiento() > 0 && ControllerParqueo.getIDDetail() > 0 && ControllerParqueo.getNumberPark() > 0) {
            if (park.updatePark()) {
                val = true;
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado", "Se lograron actualizar los datos con exito", 1);
            } else {
                val = false;
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error ", "No se lograron actualizar los datos", 2);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se permiten valores nulos.\nAgregar correctamente los datos", "Error", JOptionPane.ERROR_MESSAGE);
            val = false;
            System.out.println(park.getIDAcceso() + " " + park.getIDVehiculo() + " " + park.getIDEstacionamiento() + " " + ControllerParqueo.getNumberPark() + " " + ControllerParqueo.getIDDetail());
        }
        return val;
    }

    private void btnListoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListoActionPerformed
        // TODO add your handling code here:
        insertPark();
        if (confir == true) {
            this.dispose();

        }

    }//GEN-LAST:event_btnListoActionPerformed

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void chkCantbAcessActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCantbAcessActionPerformed
        if (chkCantbAcess.isSelected()) {
            TbAcesosWhite.setVisible(true);
            TbVehiculosWhite.setVisible(false);
            if (modeltablecars.getRowCount() > 0) {
                modeltablecars.removeRow(0);
                //TbAcesosWhite.setVisible(true);
            }

        }
    }//GEN-LAST:event_chkCantbAcessActionPerformed

    private void chkCantbCarsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCantbCarsActionPerformed
        if (chkCantbCars.isSelected()) {
            TbVehiculosWhite.setVisible(true);
        }
    }//GEN-LAST:event_chkCantbCarsActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed

        //idacces se obtiene de la tabla de este formulario (por el click del btn)
        //idcar se obtiene de la tabla de este formulario (por el click del btn)
        //idstation se envie del dato de la tabla que esta en el panel del formulario principal y se le envia a un attr statico del controller
        park.setID(Integer.parseInt(txtIDDetail.getText()));//viene del panel del formulario principal y se carga en un control no visible de este formulario
        ControllerParqueo.setIDParqueo(Integer.parseInt(txtIDPark.getText()));//idpark se obtiene de la tabla del panel que esta en el dashbord
        //y se la envia a un control de este formulario

        if (updatePark() == true) {
            this.dispose();
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void TbVehiculosWhiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbVehiculosWhiteMouseClicked
        // TODO add your handling code here:
        int row = evt.getY() / TbVehiculosWhite.getRowHeight();
        int col = TbVehiculosWhite.getColumnModel().getColumnIndexAtX(evt.getX());
        try {
            if (row < TbVehiculosWhite.getRowCount() && row >= 0 && col < TbVehiculosWhite.getColumnCount() && col >= 0) {
                Object obj = TbVehiculosWhite.getValueAt(row, col);
                if (obj instanceof UWPButton) {
                    ((UWPButton) obj).doClick();
                    chkCantbCars.setEnabled(true);
                    chkCantbCars.setForeground(Color.WHITE);
                    //((ButtonGradient) obj).setText("");                    
                    UWPButton btn = (UWPButton) obj;

                    if (btn.getName().equals("btnAgregarCar")) {
                        int IDVehiculo = Integer.valueOf(TbVehiculosWhite.getModel().getValueAt(TbVehiculosWhite.getSelectedRow(), 2).toString());
                        
                        park.setIDVehiculo(IDVehiculo/*setSourceCars(evt)*/);
                        //btn.setText("");
                        //park.setIDAcceso(setSourceAcces(evt)); 
                        TbVehiculosWhite.setVisible(false);
                        chkCantbCars.setSelected(Boolean.FALSE);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error do click table cars: " + e.toString());
        }

    }//GEN-LAST:event_TbVehiculosWhiteMouseClicked

    private void TbAcesosWhiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAcesosWhiteMouseClicked
        // TODO add your handling code here:
       int row = evt.getY() / TbAcesosWhite.getRowHeight();
        int col = TbAcesosWhite.getColumnModel().getColumnIndexAtX(evt.getX());
        try {
            if (row < TbAcesosWhite.getRowCount() && row >= 0 && col < TbVehiculosWhite.getColumnCount() && col >= 0) {
                Object obj = TbAcesosWhite.getValueAt(row, col);
                if (obj instanceof UWPButton) {
                    chkCantbAcess.setEnabled(true);
                    chkCantbAcess.setForeground(Color.WHITE);
                    //((ButtonGradient) obj).doClick();
                    //((ButtonGradient) obj).setText("");                    
                    UWPButton btn = (UWPButton) obj;

                    if (btn.getName().equals("btnAgregarAcceso")) {
                        setSourceAcces(evt);
                        //btn.setText("");                        
                        park.setIDAcceso(setSourceAcces(evt));
                        TbAcesosWhite.setVisible(false);
                        park.setIDEstacionamiento(getIDStation());
                        chkCantbAcess.setSelected(false);
                        if (modeltablecars.getRowCount() > 0) {
                            modeltablecars.removeRow(0);
                            TbVehiculosWhite.setVisible(true);
                        } else {
                            boolean notif_exist_car = false;
                            ResultSet rs = park.getCarByPersonal("vwVehiculos", "Carnet", setSourceCarnetAccess(evt));
                            try {
                                while (rs.next()) {
                                    Object data[] = {rs.getInt("idPersonal"), rs.getString("Carnet"), rs.getInt("idVehiculo"), rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("placa"), rs.getString("color"), _btnAgregarCar};
                                    TbVehiculosWhite.addRow(data);                                    
                                    notif_exist_car = true;
                                }
                                if (notif_exist_car == false) {
                                    ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al cargar vehiculos", "No se ha podido cargar los vehiculos, debido a que este personal no tiene un vehiculo registrado", 2);
                                }

                            } catch (Exception e) {
                                System.out.println("Tabla: " + e.toString());
                            }
                            TbVehiculosWhite.setVisible(true);
                        }
                    }
                }
            }
        } catch (Exception e) {
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error ", "Error al seleccionar el vehiculo", 3);
        }
    }//GEN-LAST:event_TbAcesosWhiteMouseClicked

    int setSourceCars(java.awt.event.MouseEvent event) {
        Table tb = (Table) event.getSource();
        int id = Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 0).toString());
        return id;
    }

    int setSourceAcces(java.awt.event.MouseEvent evt) {
        Table tb = (Table) evt.getSource();
        int id = Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 0).toString());
        return id;
    }

    String setSourceCarnetAccess(java.awt.event.MouseEvent evt) {
        Table tb = (Table) evt.getSource();
        String carnet = tb.getModel().getValueAt(tb.getSelectedRow(), 1).toString();
        return carnet;
    }

    void getAccess() {

        _btnAgregarAccs.setName("btnAgregarAcceso");
        _btnAgregarCar.setName("btnAgregarCar");
        _btnAgregarAccs.setBackground(new Color(231, 234, 239));
        _btnAgregarAccs.setIcon(iconAdd);
        //_btnAgregarAccs.setColor2(new Color(253, 255, 254));
        _btnAgregarCar.setBackground(new Color(231, 234, 239));
        _btnAgregarCar.setIcon(iconAdd);
        //_btnAgregarCar.setColor2(new Color(253, 255, 255));
        /*_btnAgregarAccs.setForeground(new Color(58, 50, 75));        
        _btnAgregarCar.setForeground(new Color(58, 50, 75));
        _btnAgregarAccs.setFont(font);
        _btnAgregarCar.setFont(font);
        _btnAgregarAccs.setText("Agregar");
        _btnAgregarCar.setText("Agregar");*/

        if (modeltableaccess.getRowCount() > 0 || modeltablecars.getRowCount() > 0) {//si en el modelo de la tabla hay datos/filas o los datos son mayores a 0
            modeltableaccess.removeRow(0);//remover las filas a 0
            modeltablecars.removeRow(0);
        } else {
            try {
                ResultSet rsAcsess = Controlador.ControllerAccesos.getdata("vwAccesos");
                while (rsAcsess.next()) {
                    Object[] data = {rsAcsess.getInt("idAcceso"), rsAcsess.getString("Carnet"), rsAcsess.getDate("fecha"), rsAcsess.getInt("idTipoAcceso"), rsAcsess.getTime("hora"), rsAcsess.getString("tipo_acceso"), rsAcsess.getString("notificacion"), _btnAgregarAccs};
                    modeltableaccess.addRow(data);
                }
                /*ResultSet rsCar = Controlador.ControllerAccesos.getdata("vwVehiculos");
                while (rsCar.next()) {
                    Object[] data = {rsCar.getInt("idVehiculo"), rsCar.getString("Carnet"), rsCar.getInt("idPersonal"), rsCar.getString("nombre_p"), rsCar.getString("apellido_p"), rsCar.getString("placa"), rsCar.getString("color"), _btnAgregarCar};
                    modeltablecars.addRow(data);
                }*/

            } catch (SQLException e) {
                System.out.println("Error view: " + e.toString());
            }
        }
    }

    void insertPark() {

        ControllerParqueo.setNumberPark(Integer.valueOf(txtStation.getText()));

        //que los ids sean mayores a 0, para agregar dato
        if (park.getIDAcceso() >= 0 && park.getIDVehiculo() >= 0 && ControllerParqueo.getNumberPark() >= 0) {
            if (park.insertPark() == true) {
                confir = true;
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado", "Se lograron ingresar los datos", 1);
            } else {
                confir = false;
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error  ", "No se lograron ingresar los datos", 2);
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se permiten valores nulos.\nAgregar correctamente los datos", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(park.getIDVehiculo());
        }
    }

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
            java.util.logging.Logger.getLogger(FrmSetPark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSetPark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSetPark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSetPark.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSetPark().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PanelTabla1;
    private javax.swing.JScrollPane PanelTabla2;
    private Controles_Personalizados.Tables.Table TbAcesosWhite;
    private Controles_Personalizados.Tables.Table TbVehiculosWhite;
    private Controles_Personalizados.Botones.ButtonGradient btnActualizar;
    private javax.swing.JLabel btnCerrar;
    private Controles_Personalizados.Botones.ButtonGradient btnListo;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JCheckBox chkCantbAcess;
    private javax.swing.JCheckBox chkCantbCars;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblParkname1;
    private javax.swing.JLabel lblParkname2;
    private javax.swing.JLabel lblStation;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom1;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom2;
    private javax.swing.JTextField txtIDDetail;
    private javax.swing.JTextField txtIDPark;
    private javax.swing.JTextField txtStation;
    // End of variables declaration//GEN-END:variables
}
