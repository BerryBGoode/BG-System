/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerCarnets;
import Controlador.ControllerConexion;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;

/**
 *
 * @author danlo
 */
public class PanelCarnets extends javax.swing.JPanel {

    public DefaultTableModel model;
    private ControllerCarnets ObjController = new ControllerCarnets();
    public final UWPButton btnGenerar = new UWPButton();
    public final UWPButton btnReporte = new UWPButton();
    private int ID;
    private File file;
    private static String Carnet;
    private int frmstate;
    public Font font = new Font("Roboto Black", Font.PLAIN, 18);
    ImageIcon modifIcon = new ImageIcon(getClass().getResource("/Recursos_Proyecto/Barcode.png"));
    ImageIcon modifIcondark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bx-barcode-White.png"));
    ImageIcon report = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report 1.png"));
    ImageIcon reportedark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report-White.png"));
    byte[] imagen;

    /**
     * Creates new form PanelCarnets
     */
    public PanelCarnets() {
        initComponents();
        mood();
        String[] TitulosCarnets = {"Nombre", "Apellido", "Carn??", "Tipo de usuario", "idPersonal", "Codigo de barra", "Imprimir carnet"};

        model = new DefaultTableModel(null, TitulosCarnets) {
            @Override
            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }

        };
        cargarTabla();
        TbCarnets.setModel(model);
        TbCarnets.setDefaultRenderer(Object.class, new RenderTable());
        btnGenerar.setFont(font);
        btnGenerar.setText("Generar");
        btnReporte.setFont(font);
        TbCarnets.removeColumn(TbCarnets.getColumnModel().getColumn(4));
        tbCarnetsDark.setModel(model);
        tbCarnetsDark.setDefaultRenderer(Object.class, new RenderTable());
        tbCarnetsDark.removeColumn(tbCarnetsDark.getColumnModel().getColumn(4));
        TbCarnets.setFont(font);
    }

    void cargarTabla() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            ResultSet rs = ObjController.cargarTablaController();
            while (rs.next()) {
                Object[] Valores = {rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("Carnet"), rs.getString("tipo_personal"), rs.getInt("idPersonal"), btnGenerar, btnReporte};
                model.addRow(Valores);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar, Error de vista lfdksjfsl" + e.toString());
        }
    }

    public static boolean validarImagen() {
        File file = new File("src/Codigos_Barra/" + Carnet + ".png");
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    void CrearCodigodeBarra() {
        /* FilenameFilter fn=(File dir, String name1) -> {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        };*/
        if (validarImagen() == false) {
            try {
                Barcode bar = BarcodeFactory.createCode128(Carnet);
                file = new File("src/Codigos_Barra/" + Carnet + ".png");
                BarcodeImageHandler.savePNG(bar, file);
                Thread.sleep(2000);
            } catch (BarcodeException | OutputException | IOException ex) {
                Logger.getLogger(PanelCarnets.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("No se logro realizar la imagen ruta mala");
            } catch (InterruptedException ex) {
                Logger.getLogger(PanelCarnets.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        /*else {
            FrmAgg_Carnet frmc = new FrmAgg_Carnet(ID,Carnet);
            if (frmc.isVisible()) {
                frmc.toFront();
            } else {
                frmc.setVisible(true);
            }
        }*/

    }

    void mood() {
        if (ValidacionesSistema.ValidacionesBeep_Go.getModo() == 1) {
            tbCarnetsDark.setVisible(true);
            PanelDark.setVisible(true);
            PanelTabla.setVisible(false);
            TbCarnets.setVisible(false);
            lblCarnets.setForeground(Color.WHITE);
            PanelFondo.setBackground(new Color(47, 49, 54));
            jPanel4.setBackground(new Color(47, 49, 54));
            jPanel5.setBackground(new Color(47, 49, 54));
            jPanel2.setBackground(new Color(47, 49, 54));
            jPanel1.setBackground(new Color(47, 49, 54));
            jPanel6.setBackground(new Color(47, 49, 54));
            jPanel7.setBackground(new Color(47, 49, 54));
            btnGenerar.setBackground(new Color(32, 34, 37));
            btnAgregar.setBackground(new Color(32, 34, 37));
            btnReporte.setBackground(new Color(32, 34, 37));
            btnGenerar.setForeground(Color.WHITE);
            btnReporte.setIcon(reportedark);
            tbCarnetsDark.setForeground(Color.WHITE);
            btnGenerar.setIcon(modifIcondark);
        } else {
            tbCarnetsDark.setVisible(false);
            PanelDark.setVisible(false);
            PanelTabla.setVisible(true);
            TbCarnets.setVisible(true);
            lblCarnets.setForeground(new Color(58, 50, 75));
            PanelFondo.setBackground(new Color(231, 235, 239));
            jPanel4.setBackground(new Color(231, 235, 239));
            jPanel5.setBackground(new Color(231, 235, 239));
            jPanel2.setBackground(new Color(231, 235, 239));
            jPanel1.setBackground(new Color(231, 235, 239));
            jPanel6.setBackground(new Color(231, 235, 239));
            jPanel7.setBackground(new Color(231, 235, 239));
            btnGenerar.setBackground(new Color(231, 235, 239));
            btnReporte.setBackground(new Color(231, 235, 239));
            btnGenerar.setForeground(new Color(58, 50, 75));
            btnGenerar.setIcon(modifIcon);
            btnReporte.setBackground(new Color(231, 235, 239));
            btnReporte.setForeground(new Color(58, 50, 75));
            btnReporte.setIcon(report);
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

        PanelFondo = new Controles_Personalizados.Paneles.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblCarnets = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        PanelDark = new javax.swing.JScrollPane();
        tbCarnetsDark = new Controles_Personalizados.Tables.TableDark();
        jPanel7 = new javax.swing.JPanel();
        scrollBarCustom2 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        PanelTabla = new javax.swing.JScrollPane();
        TbCarnets = new Controles_Personalizados.Tables.Table();

        setBackground(new java.awt.Color(42, 36, 56));
        setLayout(new java.awt.BorderLayout());

        PanelFondo.setBackground(new java.awt.Color(231, 234, 239));
        PanelFondo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PanelFondo.setPreferredSize(new java.awt.Dimension(1270, 620));
        PanelFondo.setRoundBottomLeft(20);
        PanelFondo.setRoundBottomRight(20);
        PanelFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelFondoMouseMoved(evt);
            }
        });
        PanelFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelFondoMouseClicked(evt);
            }
        });
        PanelFondo.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(231, 234, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(1240, 75));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                jPanel4MouseMoved(evt);
            }
        });
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCarnets.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblCarnets.setForeground(new java.awt.Color(58, 50, 75));
        lblCarnets.setText("Carnets");
        jPanel4.add(lblCarnets, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(1240, 70));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(231, 234, 239));
        jPanel6.setLayout(new java.awt.BorderLayout());

        tbCarnetsDark.setBackground(new java.awt.Color(47, 49, 54));
        tbCarnetsDark.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCarnetsDark.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        tbCarnetsDark.setRowHeight(40);
        tbCarnetsDark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCarnetsDarkMouseClicked(evt);
            }
        });
        PanelDark.setViewportView(tbCarnetsDark);

        jPanel6.add(PanelDark, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel7.setBackground(new java.awt.Color(231, 234, 239));
        jPanel7.setLayout(new java.awt.BorderLayout());

        scrollBarCustom2.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom2.setForeground(new java.awt.Color(58, 50, 75));
        jPanel7.add(scrollBarCustom2, java.awt.BorderLayout.EAST);

        PanelTabla.setBackground(new java.awt.Color(58, 50, 75));
        PanelTabla.setVerticalScrollBar(scrollBarCustom2);

        TbCarnets.setBackground(new java.awt.Color(231, 234, 239));
        TbCarnets.setModel(new javax.swing.table.DefaultTableModel(
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
        TbCarnets.setGridColor(new java.awt.Color(58, 50, 75));
        TbCarnets.setMaximumSize(new java.awt.Dimension(2147483647, 880));
        TbCarnets.setMinimumSize(new java.awt.Dimension(90, 880));
        TbCarnets.setPreferredSize(new java.awt.Dimension(450, 880));
        TbCarnets.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbCarnets.setShowVerticalLines(false);
        TbCarnets.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TbCarnetsMouseMoved(evt);
            }
        });
        TbCarnets.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbCarnetsMouseClicked(evt);
            }
        });
        PanelTabla.setViewportView(TbCarnets);

        jPanel7.add(PanelTabla, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = -100;
        gridBagConstraints.ipady = -100;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        PanelFondo.add(jPanel1, gridBagConstraints);

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    FrmPersonalSinCarnet add = new FrmPersonalSinCarnet();

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if (add.isVisible()) {
            add.toFront();
        } else {
            add.setVisible(true);
            frmstate = 1;
        }
    }//GEN-LAST:event_btnAgregarMouseClicked
    final void refresh() {
        if (frmstate == 1 && !(add.isActive())) {
            cargarTabla();
            frmstate = 0;
        }
    }
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    void BuscarIDPersonal() {
        ResultSet rs;
        ObjController.setCarnet(Carnet);
        rs = ObjController.BuscarID();
        try {
            if (rs.next()) {
                ID = rs.getInt("idPersonal");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    void BuscarImagen() {
        ResultSet rs;
        ObjController.setIdPersonal(ID);
        rs = ObjController.BuscarImagen();
        try {
            if (rs.next()) {
                imagen = rs.getBytes("imagen");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    void CargarDatos() {
        BuscarIDPersonal();
        BuscarImagen();
    }

    boolean checkFile() {
        file = new File("src\\Codigos_Barra\\" + Carnet + ".png");
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void ReportePar() {
        try {
            Connection con = ControllerConexion.getConnectionModel();
            JasperReport reporte = null;

            String dir = "src\\DocsReport\\ReportCarnet.jasper";
            Map parametros = new HashMap();
            parametros.put("Plantilla", "src\\Recursos_Proyecto\\PCarnet1.png");
            boolean respuesta = checkFile();
            if (respuesta == true) {
                parametros.put("CodBarra", "src\\Codigos_Barra\\" + Carnet + ".png");
            }
            parametros.put("idPersonal", ID);
            if (imagen != null) {
                InputStream input = new ByteArrayInputStream(imagen);
                parametros.put("imagenusu", input);
            }
            reporte = (JasperReport) JRLoader.loadObjectFromFile(dir);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    private void PanelFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseClicked

    private void PanelFondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseMoved

    private void TbCarnetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbCarnetsMouseClicked
        // TODO add your handling code here:
        int column = TbCarnets.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbCarnets.getRowHeight();
        btnGenerar.setName("btnGenerar");
        btnReporte.setName("btnReporte");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            ID = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 4);
            Carnet = rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString();
        }
        if (row < TbCarnets.getRowCount() || row >= 0 || column < TbCarnets.getColumnCount() || column >= 0) {
            Object vals = TbCarnets.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnGenerar")) {
                    CrearCodigodeBarra();
                    if (validarImagen() == true) {

                        FrmAgg_Carnet frmc = new FrmAgg_Carnet(Carnet);
                        if (frmc.isVisible()) {
                            frmc.toFront();
                        } else {
                            frmc.setVisible(true);
                        }
                    }
                } else if (btns.getName().equals("btnReporte")) {
                    ID = 0;
                    imagen = null;
                    CargarDatos();
                    ReportePar();
                }
            }
        }
    }//GEN-LAST:event_TbCarnetsMouseClicked

    private void TbCarnetsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbCarnetsMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_TbCarnetsMouseMoved

    private void tbCarnetsDarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCarnetsDarkMouseClicked
        // TODO add your handling code here:
        int column = tbCarnetsDark.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbCarnetsDark.getRowHeight();
        btnGenerar.setName("btnGenerar");
        btnReporte.setName("btnReporte");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            ID = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 4);
            Carnet = rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString();
        }
        if (row < tbCarnetsDark.getRowCount() || row >= 0 || column < tbCarnetsDark.getColumnCount() || column >= 0) {
            Object vals = tbCarnetsDark.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnGenerar")) {
                    CrearCodigodeBarra();
                    if (validarImagen() == true) {

                        FrmAgg_Carnet frmc = new FrmAgg_Carnet(Carnet);
                        if (frmc.isVisible()) {
                            frmc.toFront();
                        } else {
                            frmc.setVisible(true);
                        }
                    }
                } else if (btns.getName().equals("btnReporte")) {
                    ID = 0;
                    imagen = null;
                    CargarDatos();
                    ReportePar();
                }
            }
        }
    }//GEN-LAST:event_tbCarnetsDarkMouseClicked

    private void jPanel4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseMoved
        // TODO add your handling code here:
        mood();
    }//GEN-LAST:event_jPanel4MouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PanelDark;
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private javax.swing.JScrollPane PanelTabla;
    private Controles_Personalizados.Tables.Table TbCarnets;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lblCarnets;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom2;
    private Controles_Personalizados.Tables.TableDark tbCarnetsDark;
    // End of variables declaration//GEN-END:variables
}
