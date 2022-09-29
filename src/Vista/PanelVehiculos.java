/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerContactos;
import Controlador.ControllerVehiculos;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import java.awt.Color;
import java.sql.Connection;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class PanelVehiculos extends javax.swing.JPanel {

    /**
     * Creates new form PanelVehiculos
     */
    public PanelVehiculos() {
        initComponents();

        String[] header = {"ID", "Personal", "Carnet", "Placa", "Color", "Id personal", "Modificar", "Eliminar", "Registro"};
        model = new DefaultTableModel(null, header) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        CargarTablaVehiculos();
        TbVehiculos.removeColumn(TbVehiculos.getColumnModel().getColumn(5));
        TbVehiculos.removeColumn(TbVehiculos.getColumnModel().getColumn(0));
        TbVehiculos.setDefaultRenderer(Object.class, new RenderTable());
    }

    int idvehiculo;
    UWPButton btnModificar = new UWPButton();
    UWPButton btnEliminar = new UWPButton();
    UWPButton btnReporte = new UWPButton();
    ImageIcon modificar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    ImageIcon eliminar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    ImageIcon reporte = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report 1.png"));

    final void CargarTablaVehiculos() {

        TbVehiculos.setModel(model);

        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            rs = ControllerVehiculos.CargarTabla();
            while (rs.next()) {
                btnModificar.setIcon(modificar);
                btnEliminar.setIcon(eliminar);
                btnReporte.setIcon(reporte);
                btnModificar.setBackground(new Color(231, 234, 239));
                btnEliminar.setBackground(new Color(231, 234, 239));
                btnReporte.setBackground(new Color(231, 234, 239));
                Object[] oValues = {rs.getInt("idVehiculo"), rs.getString("Personal"), rs.getString("Carnet"), rs.getString("placa"), rs.getString("color"), rs.getInt("idPersonal"), btnModificar, btnEliminar, btnReporte};
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
        lblVehiculos = new javax.swing.JLabel();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        PanelTabla = new javax.swing.JScrollPane();
        TbVehiculos = new Controles_Personalizados.Tables.Table();
        ScrollTabla = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        btnInforme = new Controles_Personalizados.Botones.UWPButton();

        setBackground(new java.awt.Color(42, 36, 56));
        setLayout(new java.awt.BorderLayout());

        PanelFondo.setBackground(new java.awt.Color(231, 234, 239));
        PanelFondo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PanelFondo.setPreferredSize(new java.awt.Dimension(1270, 620));
        PanelFondo.setRoundBottomLeft(20);
        PanelFondo.setRoundBottomRight(20);
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblVehiculos.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblVehiculos.setForeground(new java.awt.Color(58, 50, 75));
        lblVehiculos.setText("Vehiculos");
        PanelFondo.add(lblVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PanelFondo.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 70, 150, 40));

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
        PanelFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 150, 40));

        PanelTabla.setHorizontalScrollBar(null);
        PanelTabla.setVerticalScrollBar(ScrollTabla);
        PanelTabla.setWheelScrollingEnabled(false);

        TbVehiculos.setBackground(new java.awt.Color(231, 234, 239));
        TbVehiculos.setModel(new javax.swing.table.DefaultTableModel(
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
        TbVehiculos.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TbVehiculos.setGridColor(new java.awt.Color(58, 50, 75));
        TbVehiculos.setName(""); // NOI18N
        TbVehiculos.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbVehiculos.setShowVerticalLines(false);
        TbVehiculos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbVehiculosMouseClicked(evt);
            }
        });
        PanelTabla.setViewportView(TbVehiculos);

        PanelFondo.add(PanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 1230, 480));

        ScrollTabla.setBackground(new java.awt.Color(58, 50, 75));
        ScrollTabla.setForeground(new java.awt.Color(58, 50, 75));
        PanelFondo.add(ScrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(1238, 177, 10, 40));

        btnInforme.setBackground(new java.awt.Color(58, 50, 75));
        btnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-file-doc-white.png"))); // NOI18N
        btnInforme.setText("Informe");
        btnInforme.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        btnInforme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformeActionPerformed(evt);
            }
        });
        PanelFondo.add(btnInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 70, 140, 40));

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    FrmPersonal_AggVehiculo add = new FrmPersonal_AggVehiculo();
    FrmAgg_Vehiculos frmVehiculos = new FrmAgg_Vehiculos();
    ControllerVehiculos objVehiculos = new ControllerVehiculos();

    DefaultTableModel model = new DefaultTableModel();
    ResultSet rs;

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

    private void TbVehiculosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbVehiculosMouseClicked
        int column = TbVehiculos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbVehiculos.getRowHeight();
        btnModificar.setName("btnActualizar");
        btnEliminar.setName("btnEliminar");
        btnReporte.setName("btnReporte");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            idvehiculo = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0);
            ValidacionesSistema.Parametros_Vehiculos.setIdvehiculo((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
            ValidacionesSistema.Parametros_Vehiculos.setPersonal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            ValidacionesSistema.Parametros_Vehiculos.setCarnet(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            ValidacionesSistema.Parametros_Vehiculos.setPlaca(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            ValidacionesSistema.Parametros_Vehiculos.setColor(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            ValidacionesSistema.Parametros_Vehiculos.setIdPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 5));
        }
        if (row < TbVehiculos.getRowCount() || row >= 0 || column < TbVehiculos.getColumnCount() || column >= 0) {
            Object vals = TbVehiculos.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnActualizar")) {
                    frmVehiculos = new FrmAgg_Vehiculos(ValidacionesSistema.Parametros_Vehiculos.getIdvehiculo());
                    frmVehiculos.setVisible(true);
                    //this.setEnabled(false);
                    CargarTablaVehiculos();
                    //Actualizar Contacto metodo
                }
                if (btns.getName().equals("btnReporte")) {
                    Imprimir1();
                }
                if (btns.getName().equals("btnEliminar")) {
                    int confirmar = JOptionPane.YES_NO_OPTION;
                    int a = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el vehiculo con placa: " + ValidacionesSistema.Parametros_Vehiculos.getPlaca() + "?", "Proceso de Eliminar", confirmar);
                    if (a == 0) {
                        ControllerVehiculos.idvehiculo = ValidacionesSistema.Parametros_Vehiculos.getIdvehiculo();
                        if (ControllerVehiculos.EliminarVehiculo_Controller() == true) {
                            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso de eliminacion", "Registro del vehiculo eliminado con exito", 1);
                            CargarTablaVehiculos();
                        }
                    }
                    // Eliminar Contacto metodo

                }
            }
        }
    }//GEN-LAST:event_TbVehiculosMouseClicked

    private void btnInformeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformeActionPerformed
        ImprimirReporte();
    }//GEN-LAST:event_btnInformeActionPerformed

    void ImprimirReporte() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String path = "src/DocsReport/VehiculosReporte.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map param = new HashMap();
            param.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Pie", "src\\Recursos_Proyecto\\TextoLogin.png");
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
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
            String path = "src/DocsReport/InformeVehiculos.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(path);
            Map param = new HashMap<>();
            param.put("idVehiculo", idvehiculo);
            param.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Pie", "src\\Recursos_Proyecto\\TextoLogin.png");
            System.out.println(idvehiculo);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            System.out.println("si, se imprime");
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private javax.swing.JScrollPane PanelTabla;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom ScrollTabla;
    private Controles_Personalizados.Tables.Table TbVehiculos;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private Controles_Personalizados.Botones.UWPButton btnInforme;
    private javax.swing.JLabel lblVehiculos;
    // End of variables declaration//GEN-END:variables
}
