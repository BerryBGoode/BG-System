/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerAccesos;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import Controles_Personalizados.Tables.Table;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author danlo
 */
public class PanelAccesos extends javax.swing.JPanel {

    DefaultTableModel tb;
    ControllerAccesos controller = new ControllerAccesos();
    FrmAgg_Acceso add = new FrmAgg_Acceso();
    FrmOpcionAcceso addop = new FrmOpcionAcceso();
    UWPButton btnupdate;
    UWPButton btndelete;
    ImageIcon modifIcon = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    private String CapCarnet;
    private int idPersonal;
    private int frmstate;
    private String tipouser;

    public Font font = new Font("Roboto Black", Font.PLAIN, 18);

    /**
     * Creates new form PanelAccesos
     */
    public PanelAccesos(String tipousuario) {
        initComponents();
        tipouser = tipousuario;
        //TxtCodigoBarra.setEditable(false);
        if (tipouser.equals("Seguridad")) {
            System.out.println(tipouser);
            String[] header = {"IDAcceso", "IDPersonal", "Carnet", "Fecha", "IDTipoAcceso", "Hora", "Acceso", "Notificación"};
            tb = new DefaultTableModel(null, header);
            loadTableToSegurity();
            TbAccesosWhite4.setFont(font);
            TbAccesosWhite4.setDefaultRenderer(Object.class, new RenderTable());
            TbAccesosWhite4.setModel(tb);
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(0));
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(0));
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(2));
        } else {
            btnupdate = new UWPButton();
            btndelete = new UWPButton();
            String[] header = {"IDAcceso", "IDPersonal", "Carnet", "Fecha", "IDTipoAcceso", "Hora", "Acceso", "Notificación", "Modificar", "Eliminar"};
            tb = new DefaultTableModel(null, header);
            loadTable();
            TbAccesosWhite4.setFont(font);
            TbAccesosWhite4.setDefaultRenderer(Object.class, new RenderTable());
            TbAccesosWhite4.setModel(tb);
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(0));
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(0));
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(2));
            btnupdate.setName("btnModificar");
            btnupdate.setBackground(new Color(231, 234, 239));
            btnupdate.setIcon(modifIcon);

            btndelete.setName("btnEliminar");
            btndelete.setBackground(new Color(231, 234, 239));
            btndelete.setIcon(deleteIcon);
        }

    }
    /**
     * This function is to refresh the Jtable in the systemAn
     */
    final void refresh() {
        if (frmstate == 1 || frmstate == 2 && !(add.isActive())) {
            loadTable();
            frmstate = 0;
        } else if (frmstate == 0 && !(add.isActive())) {
            loadTable();
            frmstate = 0;
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
        lblAccesos = new javax.swing.JLabel();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        PanelTabla = new javax.swing.JScrollPane();
        TbAccesosWhite4 = new Controles_Personalizados.Tables.Table();
        ScrollTabla = new Controles_Personalizados.ScrollBar.ScrollBarCustom();

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
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAccesos.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblAccesos.setForeground(new java.awt.Color(58, 50, 75));
        lblAccesos.setText("Accesos");
        PanelFondo.add(lblAccesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        PanelFondo.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, 150, 40));

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
        PanelFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 40));

        PanelTabla.setHorizontalScrollBar(null);
        PanelTabla.setVerticalScrollBar(ScrollTabla);
        PanelTabla.setWheelScrollingEnabled(false);

        TbAccesosWhite4 = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }
        };
        TbAccesosWhite4.setBackground(new java.awt.Color(231, 234, 239));
        TbAccesosWhite4.setModel(new javax.swing.table.DefaultTableModel(
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
        TbAccesosWhite4.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TbAccesosWhite4.setGridColor(new java.awt.Color(58, 50, 75));
        TbAccesosWhite4.setName(""); // NOI18N
        TbAccesosWhite4.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbAccesosWhite4.setShowVerticalLines(false);
        TbAccesosWhite4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TbAccesosWhite4MouseMoved(evt);
            }
        });
        TbAccesosWhite4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbAccesosWhite4MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                TbAccesosWhite4MouseEntered(evt);
            }
        });
        PanelTabla.setViewportView(TbAccesosWhite4);

        PanelFondo.add(PanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1230, 480));

        ScrollTabla.setBackground(new java.awt.Color(58, 50, 75));
        ScrollTabla.setForeground(new java.awt.Color(58, 50, 75));
        PanelFondo.add(ScrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(1238, 177, 10, 40));

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents


    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        if (tipouser.equals("Seguridad")) {
            if (addop.isVisible()) {
                addop.toFront();
            } else {
                addop.setVisible(true);
                frmstate = 2;
            }
        } else {
            if (add.isVisible()) {
                add.toFront();
            } else {
                add.setAction(1);
                add.setVisible(true);
                frmstate = 1;
            }
        }

    }//GEN-LAST:event_btnAgregarMouseClicked

    private void TbAccesosWhite4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAccesosWhite4MouseEntered
        int col = TbAccesosWhite4.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbAccesosWhite4.getRowHeight();
        if (row < TbAccesosWhite4.getRowCount() && row > 0 && col > 0 && col < TbAccesosWhite4.getColumnCount()) {
            Object value = TbAccesosWhite4.getValueAt(row, col);
            if (value instanceof UWPButton) {
                ((UWPButton) value).doClick();
                UWPButton btn = (UWPButton) value;

            }
        }
    }//GEN-LAST:event_TbAccesosWhite4MouseEntered

    void deleteAccess(int ID) {
        ControllerAccesos.setID(ID);
        if (ControllerAccesos.getID() > 0) {
            if (ControllerAccesos.deleteAccess() == true) {
                loadTable();
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo eliminar el registro", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            System.out.println(ControllerAccesos.getID());
        }
    }

    private void TbAccesosWhite4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAccesosWhite4MouseClicked
        Table tb = (Table) evt.getSource();//para obtener los datos de la fila

        int row = evt.getY() / TbAccesosWhite4.getRowHeight();
        int col = TbAccesosWhite4.getColumnModel().getColumnIndexAtX(evt.getX());
        try {
            if (row < TbAccesosWhite4.getRowCount() && row >= 0 && col < TbAccesosWhite4.getColumnCount() && col >= 0) {
                Object obj = TbAccesosWhite4.getValueAt(row, col);
                if (obj instanceof UWPButton) {
                    ((UWPButton) obj).doClick();
                    UWPButton btn = (UWPButton) obj;
                    if (btn.getName().equals("btnModificar")) {
                        //aquí
                        if (add.isShowing()) {
                            add.setVisible(false);
                        }
                        add.setAction(2);
                        String notification = tb.getModel().getValueAt(tb.getSelectedRow(), 7).toString();

                        if ("".equals(notification)) {
                            add.setNofitication("");
                            System.out.println(notification + "ds");
                            add.setVisible(true);
                            frmstate = 1;
                        } else {
                            add.setNofitication(tb.getModel().getValueAt(tb.getSelectedRow(), 7).toString());
                            System.out.println(notification + "f");
                        }
                        add.setID(Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 0).toString()));
                        add.setTypeaccess(Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 4).toString()));

                        add.setVisible(true);

                    }
                    if (btn.getName().equals("btnEliminar")) {
                        int msg = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este dato?", "Confirmar acción", JOptionPane.YES_NO_OPTION);
                        if (msg == JOptionPane.YES_OPTION) {
                            deleteAccess(Integer.valueOf(tb.getModel().getValueAt(tb.getSelectedRow(), 0).toString()));
                        }
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_TbAccesosWhite4MouseClicked

    private void PanelFondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseMoved

    private void TbAccesosWhite4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAccesosWhite4MouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_TbAccesosWhite4MouseMoved

    private void PanelFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseClicked

    void loadTable() {
        ResultSet rs;
        try {
            while (tb.getRowCount() > 0) {
                tb.removeRow(0);
            }
            rs = ControllerAccesos.getdata("vwAccesos");
            while (rs.next()) {
                Object[] data = {rs.getInt("idAcceso"), rs.getInt("idPersonal"), rs.getString("Carnet"), rs.getDate("fecha"), rs.getInt("idTipoAcceso"), rs.getTime("hora"), rs.getString("tipo_acceso"), rs.getString("notificacion"), btnupdate, btndelete};
                tb.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e.toString());
        }
    }

    void loadTableToSegurity() {
        ResultSet rs;
        try {
            while (tb.getRowCount() > 0) {
                tb.removeRow(0);
            }
            rs = ControllerAccesos.getdata("vwAccesos");
            while (rs.next()) {
                Object[] data = {rs.getInt("idAcceso"), rs.getInt("idPersonal"), rs.getString("Carnet"), rs.getDate("fecha"), rs.getInt("idTipoAcceso"), rs.getTime("hora"), rs.getString("tipo_acceso"), rs.getString("notificacion")};
                tb.addRow(data);
            }
        } catch (SQLException e) {
            System.out.println("Error:" + e.toString());
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private javax.swing.JScrollPane PanelTabla;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom ScrollTabla;
    private Controles_Personalizados.Tables.Table TbAccesosWhite4;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private javax.swing.JLabel lblAccesos;
    // End of variables declaration//GEN-END:variables
}
