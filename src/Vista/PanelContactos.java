/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerContactos;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author danlo
 */
public class PanelContactos extends javax.swing.JPanel {

    /**
     * Creates new form PanelContactos
     */
    
     private Font font = new Font("Roboto Black", Font.PLAIN, 18);
    DefaultTableModel model;
    DefaultComboBoxModel<String> modelcombo = new DefaultComboBoxModel<>();
    ArrayList list;
    int tipo_contacto = 0;
    int idpersonal = 0;
    int panelcontactos = 0;
    private int prueba;
    int frmestate = 0;
    int idContacto;

    FrmAgg_Contacto frmAgg_Contacto;
    UWPButton btnModificar = new UWPButton();
    UWPButton btnEliminar = new UWPButton();
    UWPButton btnReporte = new UWPButton();
    ImageIcon Modificar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    ImageIcon Eliminar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    ImageIcon Reporte = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report 1.png"));

    public PanelContactos() {
        initComponents();

        String[] headerContactos = {"Id Contacto", "Contacto", "Personal", "Tipo Contacto", "idPersonal", "idTipoContacto", "Modificar", "Eliminar", "Registro"};
        model = new DefaultTableModel(null, headerContactos) {
            @Override
            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        CargarTabla();
        tbContactos.setFont(font);
        tbContactos.removeColumn(tbContactos.getColumnModel().getColumn(0));
        tbContactos.removeColumn(tbContactos.getColumnModel().getColumn(3));
        tbContactos.removeColumn(tbContactos.getColumnModel().getColumn(3));
        tbContactos.setDefaultRenderer(Object.class, new RenderTable());
    }

    public PanelContactos(int refresh) {
        CargarTabla();
    }

    final void CargarTabla() {

        tbContactos.setModel(model);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            ResultSet rs = ControllerContactos.CargarTablaContactos_Controller();
            while (rs.next()) {
                btnModificar.setIcon(Modificar);
                btnEliminar.setIcon(Eliminar);
                btnReporte.setIcon(Reporte);
                btnModificar.setBackground(new Color(231, 234, 239));
                btnEliminar.setBackground(new Color(231, 234, 239));
                btnReporte.setBackground(new Color(231, 234, 239));
                Object[] oValues = {rs.getInt("idContacto"), rs.getString("contacto"), rs.getString("Personal"), rs.getString("tipo_contacto"), rs.getInt("idPersonal"), rs.getInt("idTipoContacto"), btnModificar, btnEliminar, btnReporte};
                model.addRow(oValues);
            }
        } catch (Exception e) {
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

        PanelFondo = new Controles_Personalizados.Paneles.PanelRound();
        lblContactos = new javax.swing.JLabel();
        btnInforme = new Controles_Personalizados.Botones.UWPButton();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        PanelTabla = new javax.swing.JScrollPane();
        tbContactos = new Controles_Personalizados.Tables.Table();
        ScrollTabla = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        btnFiltrar1 = new Controles_Personalizados.Botones.UWPButton();

        setBackground(new java.awt.Color(42, 36, 56));
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
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
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblContactos.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblContactos.setForeground(new java.awt.Color(58, 50, 75));
        lblContactos.setText("Contactos");
        PanelFondo.add(lblContactos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnInforme.setBackground(new java.awt.Color(58, 50, 75));
        btnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-file-doc-white.png"))); // NOI18N
        btnInforme.setText("Informe");
        btnInforme.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnInforme.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnInforme.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });
        PanelFondo.add(btnInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 80, 130, 40));

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
        PanelFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 40));

        PanelTabla.setHorizontalScrollBar(null);
        PanelTabla.setVerticalScrollBar(ScrollTabla);
        PanelTabla.setWheelScrollingEnabled(false);
        PanelTabla.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelTablaMouseMoved(evt);
            }
        });

        tbContactos.setBackground(new java.awt.Color(231, 234, 239));
        tbContactos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "CARNET", "NOMBRES", "TIPO USUARIO", "%ENTRADAS", "%SALIDAS", "ACCIONES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbContactos.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tbContactos.setGridColor(new java.awt.Color(58, 50, 75));
        tbContactos.setName(""); // NOI18N
        tbContactos.setSelectionBackground(new java.awt.Color(58, 50, 75));
        tbContactos.setShowVerticalLines(false);
        tbContactos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tbContactosMouseMoved(evt);
            }
        });
        tbContactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbContactosMouseClicked(evt);
            }
        });
        PanelTabla.setViewportView(tbContactos);

        PanelFondo.add(PanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1230, 480));

        ScrollTabla.setBackground(new java.awt.Color(58, 50, 75));
        ScrollTabla.setForeground(new java.awt.Color(58, 50, 75));
        PanelFondo.add(ScrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(1238, 177, 10, 40));

        btnFiltrar1.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar1.setText(" Filtrar");
        btnFiltrar1.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar1.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PanelFondo.add(btnFiltrar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 150, 40));

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    FrmPersonal_Contacto add = new FrmPersonal_Contacto();

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if (add.isVisible()) {
            add.toFront();
        } else {
            add.setVisible(true);
        }

    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tbContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbContactosMouseClicked
        // TODO add your handling code here:
        int column = tbContactos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbContactos.getRowHeight();
        btnModificar.setName("btnActualizar");
        btnEliminar.setName("btnEliminar");
        btnReporte.setName("btnReporte");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            idContacto = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0);
            ValidacionesSistema.Parametros_Contactos.setIdcontacto((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
            ValidacionesSistema.Parametros_Contactos.setContacto(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            ValidacionesSistema.Parametros_Contactos.setPersonal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            ValidacionesSistema.Parametros_Contactos.setTipocontacto(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            ValidacionesSistema.Parametros_Contactos.setIdpersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 4));
            ValidacionesSistema.Parametros_Contactos.setIdtipocontacto((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 5));
        }
        if (row < tbContactos.getRowCount() || row >= 0 || column < tbContactos.getColumnCount() || column >= 0) {
            Object vals = tbContactos.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnActualizar")) {
                    frmAgg_Contacto = new FrmAgg_Contacto(ValidacionesSistema.Parametros_Contactos.getIdcontacto());
                    frmAgg_Contacto.setVisible(true);
                    frmestate = 1;
                    //this.setEnabled(false);
                    CargarTabla();
                }
                if (btns.getName().equals("btnReporte")) {
                    Imprimir1();
                }
                if (btns.getName().equals("btnEliminar")) {
                    int confirmar = JOptionPane.YES_NO_OPTION;
                    int a = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el contacto: " + ValidacionesSistema.Parametros_Contactos.getContacto() + "?", "Proceso de Eliminar", confirmar);
                    if (a == 0) {
                        ControllerContactos.idcontacto = ValidacionesSistema.Parametros_Contactos.getIdcontacto();
                        if (ControllerContactos.EliminarContactos_Controller() == true) {
                            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso de eliminacion", "Contacto eliminado con exito", 1);
                            CargarTabla();
                        }
                    }
                    // Eliminar Contacto metodo

                }
            }
        }
    }//GEN-LAST:event_tbContactosMouseClicked

    void ImprimirReporte() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String path = "src/DocsReport/ReporteContactos.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            System.out.println("si, se imprime");
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }
    
    void Imprimir1() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String path = "src/DocsReport/InformeContactos.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map param = new HashMap<>();
            param.put("idContacto", idContacto);
            System.out.println(idContacto);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            System.out.println("si, se imprime");
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }
    
//    final void Refresh(){
//        if (frmestate == 1 && !(frmAgg_Contacto.isActive())) {
//            CargarTabla();
//            frmestate = 0;
//        }
//    }
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
//        Refresh();
    }//GEN-LAST:event_formMouseClicked

    private void tbContactosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbContactosMouseMoved
        // TODO add your handling code here:
//        Refresh();
    }//GEN-LAST:event_tbContactosMouseMoved

    private void PanelFondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseMoved
        // TODO add your handling code here:
//        Refresh();
    }//GEN-LAST:event_PanelFondoMouseMoved

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        ImprimirReporte();
    }//GEN-LAST:event_btnInformeActionPerformed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        CargarTabla();
    }//GEN-LAST:event_formMouseMoved

    private void PanelTablaMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelTablaMouseMoved
        CargarTabla();
    }//GEN-LAST:event_PanelTablaMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private javax.swing.JScrollPane PanelTabla;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom ScrollTabla;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar1;
    private Controles_Personalizados.Botones.UWPButton btnInforme;
    private javax.swing.JLabel lblContactos;
    private Controles_Personalizados.Tables.Table tbContactos;
    // End of variables declaration//GEN-END:variables
}
