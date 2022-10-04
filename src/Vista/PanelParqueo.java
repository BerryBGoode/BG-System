/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerParqueo;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import Controles_Personalizados.Tables.Table;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.HeadlessException;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JTable;
import java.util.Map;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author danlo
 */
public class PanelParqueo extends javax.swing.JPanel {

    public final UWPButton btnupdate = new UWPButton();
    public final UWPButton btndelete = new UWPButton();
    public final ImageIcon modifIcon = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    public final ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    ImageIcon Modificardark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar_white.png"));
    ImageIcon Eliminardark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-trash-alt white.png"));
    private int frmstate = 1;
    public Font font = new Font("Roboto Black", Font.PLAIN, 18);

    /**
     * Creates new form PanelParqueo
     */
    public PanelParqueo() {
        initComponents();
        modo();
        String[] headerpark = {"IDDetalle", "IDPersonal", "Carnet", "IDAcceso", "Fecha", "Hora", "IDVehiculo", "Placa", "IDEstacionamiento", "Estacionamiento", "IDParqueo", "Parqueo", "Ubicación", "Modificar", "Eliminar"};
        tbpark = new DefaultTableModel(null, headerpark);        
        TbParqueosWhite.setModel(tbpark);

        getdataPark();

        TbParqueosWhite.removeColumn(TbParqueosWhite.getColumnModel().getColumn(0));
        TbParqueosWhite.removeColumn(TbParqueosWhite.getColumnModel().getColumn(0));
        TbParqueosWhite.removeColumn(TbParqueosWhite.getColumnModel().getColumn(1));
        TbParqueosWhite.removeColumn(TbParqueosWhite.getColumnModel().getColumn(3));
        TbParqueosWhite.removeColumn(TbParqueosWhite.getColumnModel().getColumn(4));
        TbParqueosWhite.removeColumn(TbParqueosWhite.getColumnModel().getColumn(5));

        TbParqueosWhite.getColumnModel().getColumn(4).setPreferredWidth(100);//9

        TbParqueosWhite.setDefaultRenderer(Object.class, new RenderTable());
        TbParqueosWhite.setFont(ValidacionesSistema.ValidacionesBeep_Go.font);
        btndelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnupdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        btnupdate.setName("btnModificar");
        btndelete.setName("btnEliminar");
        //Table Dark
        TbParqueosDark.setModel(tbpark);
        TbParqueosDark.setDefaultRenderer(Object.class, new RenderTable());        
        TbParqueosDark.removeColumn(TbParqueosDark.getColumnModel().getColumn(0));
        TbParqueosDark.removeColumn(TbParqueosDark.getColumnModel().getColumn(0));
        TbParqueosDark.removeColumn(TbParqueosDark.getColumnModel().getColumn(1));
        TbParqueosDark.removeColumn(TbParqueosDark.getColumnModel().getColumn(3));
        TbParqueosDark.removeColumn(TbParqueosDark.getColumnModel().getColumn(4));
        TbParqueosDark.removeColumn(TbParqueosDark.getColumnModel().getColumn(5));
        TbParqueosDark.setFont(ValidacionesSistema.ValidacionesBeep_Go.font);
        TbParqueosDark.getColumnModel().getColumn(4).setPreferredWidth(100);//9

    }

    final void refresh() {
        if (frmstate == 1 && !(park.isActive())) {
            getdataPark();
            frmstate = 0;
        }
    }

    void modo() {
        if (ValidacionesSistema.ValidacionesBeep_Go.Modo == 1) {
            jScrollPane1.setVisible(false);
            TbParqueosWhite.setVisible(false);
            jScrollPane2.setVisible(true);
            jPanel6.setVisible(true);
            jPanel7.setVisible(false);
            TbParqueosDark.setVisible(true);
            TbParqueosDark.setForeground(Color.white);
            jScrollPane2.setBackground(new Color(47, 49, 54));
            jPanel4.setBackground(new Color(47, 49, 54));
            jPanel5.setBackground(new Color(47, 49, 54));
            jPanel6.setBackground(new Color(47, 49, 54));
            jPanel3.setBackground(new Color(47, 49, 54));
            jPanel2.setBackground(new Color(47, 49, 54));
            jPanel1.setBackground(new Color(47, 49, 54));
            panelRound1.setBackground(new Color(47, 49, 54));
            btnAgregar.setBackground(new Color(32, 34, 37));
            btnInforme.setBackground(new Color(32, 34, 37));
            btnFiltrar.setBackground(new Color(32, 34, 37));
            btnupdate.setBackground(new Color(32, 34, 37));
            btndelete.setBackground(new Color(32, 34, 37));
            lblParqueo.setForeground(Color.WHITE);
            btndelete.setIcon(Eliminardark);
            btnupdate.setIcon(Modificardark);
        } else {
            jScrollPane1.setVisible(true);
            TbParqueosWhite.setVisible(true);
            jScrollPane2.setVisible(false);
            TbParqueosDark.setVisible(false);
            jPanel7.setVisible(true);
            jPanel6.setVisible(false);
            jPanel4.setBackground(new Color(231, 234, 239));
            jPanel5.setBackground(new Color(231, 234, 239));
            jPanel3.setBackground(new Color(231, 234, 239));
            jPanel2.setBackground(new Color(231, 234, 239));
            jPanel1.setBackground(new Color(231, 234, 239));
            panelRound1.setBackground(new Color(231, 234, 239));
            btnAgregar.setBackground(new Color(58, 50, 75));
            btnInforme.setBackground(new Color(58, 50, 75));
            btnFiltrar.setBackground(new Color(58, 50, 75));
            btnupdate.setBackground(new Color(231, 234, 239));
            btndelete.setBackground(new Color(231, 234, 239));
            lblParqueo.setForeground(new Color(58, 50, 75));
            btndelete.setIcon(deleteIcon);
            btnupdate.setIcon(modifIcon);
            
        }
    }


    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblParqueo = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        btnInforme = new Controles_Personalizados.Botones.UWPButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbParqueosDark = new Controles_Personalizados.Tables.TableDark();
        jPanel7 = new javax.swing.JPanel();
        scrollBarCustom1 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbParqueosWhite = new Controles_Personalizados.Tables.Table();

        setBackground(new java.awt.Color(42, 36, 56));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
            }
        });
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        panelRound1.setBackground(new java.awt.Color(231, 234, 239));
        panelRound1.setRoundBottomLeft(20);
        panelRound1.setRoundBottomRight(20);
        panelRound1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                panelRound1MouseMoved(evt);
            }
        });
        panelRound1.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(231, 234, 239));
        jPanel2.setMinimumSize(new java.awt.Dimension(1240, 135));
        jPanel2.setPreferredSize(new java.awt.Dimension(1240, 135));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(231, 234, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(1240, 75));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblParqueo.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblParqueo.setForeground(new java.awt.Color(58, 50, 75));
        lblParqueo.setText("Parqueos");
        jPanel4.add(lblParqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(1240, 70));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jPanel5.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 150, 40));

        btnAgregar.setBackground(new java.awt.Color(58, 50, 75));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Agregar Blanco.png"))); // NOI18N
        btnAgregar.setText(" Agregar");
        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAgregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAgregarMouseClicked(evt);
            }
        });
        jPanel5.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        btnInforme.setBackground(new java.awt.Color(58, 50, 75));
        btnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-file-doc-white.png"))); // NOI18N
        btnInforme.setText("Informe");
        btnInforme.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnInforme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInformeMouseClicked(evt);
            }
        });
        jPanel5.add(btnInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 150, 40));

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setBackground(new java.awt.Color(231, 234, 239));
        jPanel3.setPreferredSize(new java.awt.Dimension(461, 403));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setPreferredSize(new java.awt.Dimension(453, 403));
        jPanel6.setLayout(new java.awt.BorderLayout());

        TbParqueosDark = new Controles_Personalizados.Tables.TableDark(){

            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        TbParqueosDark.setBackground(new java.awt.Color(47, 49, 54));
        TbParqueosDark.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TbParqueosDark.setRowHeight(40);
        TbParqueosDark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbParqueosDarkMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TbParqueosDark);

        jPanel6.add(jScrollPane2, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel7.setPreferredSize(new java.awt.Dimension(461, 403));
        jPanel7.setLayout(new java.awt.BorderLayout());

        scrollBarCustom1.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom1.setForeground(new java.awt.Color(58, 50, 75));
        jPanel7.add(scrollBarCustom1, java.awt.BorderLayout.EAST);

        jScrollPane1.setMinimumSize(new java.awt.Dimension(15, 26));
        jScrollPane1.setPreferredSize(new java.awt.Dimension(461, 403));
        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

        TbParqueosWhite = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TbParqueosWhite.setBackground(new java.awt.Color(231, 234, 239));
        TbParqueosWhite.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TbParqueosWhite.setGridColor(new java.awt.Color(58, 50, 75));
        TbParqueosWhite.setPreferredSize(new java.awt.Dimension(450, 880));
        TbParqueosWhite.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbParqueosWhite.setShowVerticalLines(false);
        TbParqueosWhite.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbParqueosWhiteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbParqueosWhite);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 500;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        panelRound1.add(jPanel1, gridBagConstraints);

        add(panelRound1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    FrmConfigPark park = new FrmConfigPark();
    DefaultTableModel tbpark;    

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if (park.isShowing()) {
            park.setVisible(false);
        }
        park = new FrmConfigPark();
        park.setVisible(true);
        FrmSetPark.action = 2;//me refiero a que se va a agregar, entonces que en wl switch verifique los estados de lo estacionamientos
    }//GEN-LAST:event_btnAgregarMouseClicked

    FrmSetPark setPark = new FrmSetPark();

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        getdataPark();
    }//GEN-LAST:event_formFocusGained

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        getdataPark();
        refresh();
    }//GEN-LAST:event_formComponentShown

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        refresh();
    }//GEN-LAST:event_formMouseReleased

    private void btnInformeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInformeMouseClicked
        try {
            Connection con = ControllerConexion.getConnectionModel();
            JasperReport reporte = null;
            String dir = "src\\DocsReport\\DetalleEstacionamientosGeneral.jasper";
            Map param = new HashMap<>();
            param.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("TextoFooter", "src\\Recursos_Proyecto\\TextoLogin.png");

            reporte = (JasperReport) JRLoader.loadObjectFromFile(dir);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, param, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }

    }//GEN-LAST:event_btnInformeMouseClicked

    ControllerParqueo controllerParqueo = new ControllerParqueo();
    private void TbParqueosWhiteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbParqueosWhiteMouseClicked
        // TODO add your handling code here:
        JTable tb = (JTable) evt.getSource();//para obtener los datos de la fila

        int row = evt.getY() / TbParqueosWhite.getRowHeight();
        int col = TbParqueosWhite.getColumnModel().getColumnIndexAtX(evt.getX());
        try {
            if (row < TbParqueosWhite.getRowCount() && row >= 0 && col < TbParqueosWhite.getColumnCount() && col >= 0) {
                Object obj = TbParqueosWhite.getValueAt(row, col);
                if (obj instanceof UWPButton) {
                    ((UWPButton) obj).doClick();
                    UWPButton btn = (UWPButton) obj;
                    if (btn.getName().equals("btnModificar")) {
                        if (park.isShowing()) {
                            park.setVisible(false);

                        }
                        //envio el station que en el q se registro, para que se habilite y pueda cambiar el parqueo                        
                        int IDAcceso = Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 3).toString());
                        //int IDVehiuclo = Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 6).toString());
                        int IDstation = Integer.parseInt(tb.getModel().getValueAt(tb.getSelectedRow(), 8).toString());//numberpark
                        int ID = Integer.parseInt(tb.getModel().getValueAt(tb.getSelectedRow(), 0).toString());
                        int station = Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 9).toString());
                        int IDPark = Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 11).toString());

                        int IDBeforeStation = IDstation;//esta variable sirve para guardar el IDestacionamiento  antes de actualizar, y sí se llega a cambiar, entonces a este estacionamiento
                        //se le cambiará el estado a disponible
                        FrmSetPark.action = 1;//me refiero a que se va a actualizar, entonces que en wl switch bloquee todos los estacionamientos menos en el q se ingreso  
                        //FrmSetPark.setIDDetail(ID);

                        //setteo 
                        //el objeto "park" hace referencia al FRMconfigpark 
                        controllerParqueo.setIDAcceso(IDAcceso);
                        //controllerParqueo.setIDVehiculo(IDVehiuclo);
                        controllerParqueo.setIDEstacionamiento(IDstation);
                        FrmSetPark.setIDDetail(ID);
                        ControllerParqueo.setNumberPark(IDPark);
                        park.setStation(station);
                        park.setPark(tb.getModel().getValueAt(tb.getSelectedRow(), 11).toString());
                        ControllerParqueo.setBeforeStation(IDBeforeStation);
                        park.setVisible(true);
                        frmstate = 1;
                        FrmSetPark.action = 1;

                    }
                    if (btn.getName().equals("btnEliminar")) {
                        int msg = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este dato?", "Confirmar acción", JOptionPane.YES_NO_OPTION);
                        if (msg == JOptionPane.YES_OPTION) {
                            int IDDetail = Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 0).toString());
                            int IDStation = Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 8).toString());
                            deletePark(IDDetail, IDStation);
                        }
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_TbParqueosWhiteMouseClicked

    private void TbParqueosDarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbParqueosDarkMouseClicked
        // TODO add your handling code here:
        JTable tbd = (JTable) evt.getSource();//para obtener los datos de la fila

        int row = evt.getY() / TbParqueosDark.getRowHeight();
        int col = TbParqueosDark.getColumnModel().getColumnIndexAtX(evt.getX());
        try {
            if (row < TbParqueosDark.getRowCount() && row >= 0 && col < TbParqueosDark.getColumnCount() && col >= 0) {
                Object obj = TbParqueosDark.getValueAt(row, col);
                if (obj instanceof UWPButton) {
                    ((UWPButton) obj).doClick();
                    UWPButton btn = (UWPButton) obj;
                    if (btn.getName().equals("btnModificar")) {
                        if (park.isShowing()) {
                            park.setVisible(false);

                        }
                        //envio el station que en el q se registro, para que se habilite y pueda cambiar el parqueo                        
                        int IDAcceso = Integer.valueOf(tbd.getModel().getValueAt(tbd.getSelectedRow(), 3).toString());
                        int IDVehiuclo = Integer.valueOf(tbd.getModel().getValueAt(tbd.getSelectedRow(), 6).toString());
                        int IDstation = Integer.parseInt(tbd.getModel().getValueAt(tbd.getSelectedRow(), 8).toString());//numberpark
                        int ID = Integer.parseInt(tbd.getModel().getValueAt(tbd.getSelectedRow(), 0).toString());
                        int station = Integer.valueOf(tbd.getModel().getValueAt(tbd.getSelectedRow(), 9).toString());
                        int IDPark = Integer.valueOf(tbd.getModel().getValueAt(tbd.getSelectedRow(), 11).toString());
                        FrmSetPark.action = 1;//me refiero a que se va a actualizar, entonces que en wl switch bloquee todos los estacionamientos menos en el q se ingreso  
                        //FrmSetPark.setIDDetail(ID);
                        //setteo 

                        controllerParqueo.setIDAcceso(IDAcceso);
                        controllerParqueo.setIDVehiculo(IDVehiuclo);
                        controllerParqueo.setIDEstacionamiento(IDstation);
                        FrmSetPark.setIDDetail(ID);
                        ControllerParqueo.setNumberPark(IDPark);
                        park.setStation(station);
                        park.setPark(tbd.getModel().getValueAt(tbd.getSelectedRow(), 11).toString());

                        park.setVisible(true);
                        frmstate = 1;
                        FrmSetPark.action = 1;

                    }
                    if (btn.getName().equals("btnEliminar")) {
                        int msg = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este dato?", "Confirmar acción", JOptionPane.YES_NO_OPTION);
                        if (msg == JOptionPane.YES_OPTION) {
                            int IDDetail = Integer.valueOf(tbd.getModel().getValueAt(tbd.getSelectedRow(), 0).toString());
                            int IDStation = Integer.valueOf(tbd.getModel().getValueAt(tbd.getSelectedRow(), 8).toString());
                            deletePark(IDDetail, IDStation);
                        }
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_TbParqueosDarkMouseClicked

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        refresh();
        getdataPark();
    }//GEN-LAST:event_formMouseMoved

    private void panelRound1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseMoved
        // TODO add your handling code here:
        modo();
    }//GEN-LAST:event_panelRound1MouseMoved
    
 
    public void getdataPark() {
        String tablename = "vwDetalle_Estacionamientos";
        while (tbpark.getRowCount() > 0) {
            tbpark.removeRow(0);
        }

        try {
            ResultSet rs = Controlador.ControllerAccesos.getdata(tablename);
            while (rs.next()) {
                Object[] data = {rs.getInt("IDDetalle"), rs.getInt("idPersonal"), rs.getString("carnet"), rs.getInt("idAcceso"), rs.getDate("fecha"), rs.getTime("hora"), rs.getInt("idVehiculo"), rs.getString("placa"), rs.getInt("idEstacionamiento"), rs.getInt("numero_estacionamiento"), rs.getInt("idParqueo"), rs.getInt("numero_parqueo"), rs.getString("Ubicacion"), btnupdate, btndelete};
                tbpark.addRow(data);

                //que recupere los datos q especifico con la columname y los guarde en un object
            }
        } catch (SQLException e) {
            System.out.println("Error view: " + e.toString());
        }

    }

    public void deletePark(int ID, int IDStation) {
        ControllerParqueo park = new ControllerParqueo();
        ControllerParqueo.setIDDetail(ID);
        park.setIDEstacionamiento(IDStation);
        System.out.println(ControllerParqueo.getIDDetail());
        if (ControllerParqueo.getIDDetail() > 0) {
            if (park.deletePark() == true) {
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado", "datos  eliminados", 1);
                getdataPark();
            } else {
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso fallido", "No se pudo eliminar los datos", 2);
            }
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Tables.TableDark TbParqueosDark;
    private Controles_Personalizados.Tables.Table TbParqueosWhite;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private Controles_Personalizados.Botones.UWPButton btnInforme;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblParqueo;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}
