/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerAccesos;
import Controlador.ControllerConexion;
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
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
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
public class PanelAccesos extends javax.swing.JPanel {

    DefaultTableModel tb;
    ControllerAccesos controller = new ControllerAccesos();
    FrmAgg_Acceso add = new FrmAgg_Acceso();
    FrmOpcionAcceso addop = new FrmOpcionAcceso();
    UWPButton btnupdate;
    UWPButton btndelete;
    ImageIcon modifIcon = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    ImageIcon deleteIcon = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    ImageIcon Modificardark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar_white.png"));
    ImageIcon Eliminardark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-trash-alt white.png"));
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
            tb = new DefaultTableModel(null, header) {
                @Override
                public boolean isCellEditable(int row, int column) { // aqui esta
                    return false;
                }
            };
            loadTableToSegurity();
            TbAccesosWhite4.setFont(font);
            TbAccesosWhite4.setDefaultRenderer(Object.class, new RenderTable());
            TbAccesosWhite4.setModel(tb);
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(0));
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(0));
            TbAccesosWhite4.removeColumn(TbAccesosWhite4.getColumnModel().getColumn(2));
            //Table dark
            TbAcessoDark.setFont(font);
            TbAcessoDark.setDefaultRenderer(Object.class, new RenderTable());
            TbAcessoDark.setModel(tb);
            TbAcessoDark.removeColumn(TbAcessoDark.getColumnModel().getColumn(0));
            TbAcessoDark.removeColumn(TbAcessoDark.getColumnModel().getColumn(0));
            TbAcessoDark.removeColumn(TbAcessoDark.getColumnModel().getColumn(2));
            modoseguridad();
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
            //Table dark
            TbAcessoDark.setFont(font);
            TbAcessoDark.setDefaultRenderer(Object.class, new RenderTable());
            TbAcessoDark.setModel(tb);
            TbAcessoDark.removeColumn(TbAcessoDark.getColumnModel().getColumn(0));
            TbAcessoDark.removeColumn(TbAcessoDark.getColumnModel().getColumn(0));
            TbAcessoDark.removeColumn(TbAcessoDark.getColumnModel().getColumn(2));

            btnupdate.setName("btnModificar");
            btndelete.setName("btnEliminar");
            modo();
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

    void modoseguridad() {
        if (ValidacionesSistema.ValidacionesBeep_Go.Modo == 1) {
            jScrollPane1.setVisible(false);
            TbAccesosWhite4.setVisible(false);
            ScrollDark.setVisible(true);
            jPanel7.setVisible(true);
            TbAcessoDark.setVisible(true);
            TbAcessoDark.setForeground(Color.white);
            PanelFondo.setBackground(new Color(47, 49, 54));
            jPanel4.setBackground(new Color(47, 49, 54));
            jPanel5.setBackground(new Color(47, 49, 54));
            jPanel2.setBackground(new Color(47, 49, 54));
            jPanel1.setBackground(new Color(47, 49, 54));
            jPanel7.setBackground(new Color(47, 49, 54));
            jPanel6.setBackground(new Color(47, 49, 54));
            lblAccesos.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(32, 34, 37));
            btnFiltrar.setBackground(new Color(32, 34, 37));
        } else {
            jScrollPane1.setVisible(true);
            TbAccesosWhite4.setVisible(true);
            ScrollDark.setVisible(false);
            TbAcessoDark.setVisible(false);
            PanelFondo.setBackground(new Color(231, 234, 239));
            jPanel4.setBackground(new Color(231, 234, 239));
            jPanel5.setBackground(new Color(231, 234, 239));
            jPanel2.setBackground(new Color(231, 234, 239));
            jPanel1.setBackground(new Color(231, 234, 239));
            jPanel7.setBackground(new Color(231, 234, 239));
            jPanel6.setBackground(new Color(231, 234, 239));
            lblAccesos.setForeground(new Color(58, 50, 75));
            btnAgregar.setBackground(new Color(58, 50, 75));
            btnFiltrar.setBackground(new Color(58, 50, 75));
        }
    }

    void modo() {
        if (ValidacionesSistema.ValidacionesBeep_Go.Modo == 1) {
            jScrollPane1.setVisible(false);
            TbAccesosWhite4.setVisible(false);
            ScrollDark.setVisible(true);
            jPanel7.setVisible(true);
            TbAcessoDark.setVisible(true);
            TbAcessoDark.setForeground(Color.white);
            PanelFondo.setBackground(new Color(47, 49, 54));
            jPanel4.setBackground(new Color(47, 49, 54));
            jPanel5.setBackground(new Color(47, 49, 54));
            jPanel2.setBackground(new Color(47, 49, 54));
            jPanel1.setBackground(new Color(47, 49, 54));
            jPanel7.setBackground(new Color(47, 49, 54));
            jPanel6.setBackground(new Color(47, 49, 54));
            lblAccesos.setForeground(Color.WHITE);
            btnAgregar.setBackground(new Color(32, 34, 37));
            btnFiltrar.setBackground(new Color(32, 34, 37));
            btnupdate.setBackground(new Color(32, 34, 37));
            btndelete.setBackground(new Color(32, 34, 37));
            btnupdate.setIcon(Modificardark);
            btndelete.setIcon(Eliminardark);
        } else {
            jScrollPane1.setVisible(true);
            TbAccesosWhite4.setVisible(true);
            ScrollDark.setVisible(false);
            TbAcessoDark.setVisible(false);
            PanelFondo.setBackground(new Color(231, 234, 239));
            jPanel4.setBackground(new Color(231, 234, 239));
            jPanel5.setBackground(new Color(231, 234, 239));
            jPanel2.setBackground(new Color(231, 234, 239));
            jPanel1.setBackground(new Color(231, 234, 239));
            jPanel7.setBackground(new Color(231, 234, 239));
            jPanel6.setBackground(new Color(231, 234, 239));
            lblAccesos.setForeground(new Color(58, 50, 75));
            btnAgregar.setBackground(new Color(58, 50, 75));
            btnFiltrar.setBackground(new Color(58, 50, 75));
            btnupdate.setBackground(new Color(231, 234, 239));
            btndelete.setBackground(new Color(231, 234, 239));
            btnupdate.setIcon(modifIcon);
            btndelete.setIcon(deleteIcon);
        }
    }

    public void mododash() {
        switch (ValidacionesSistema.ValidacionesBeep_Go.getModo()) {
            case 1:
                if (!tipouser.equals("Seguridad")) {
                    btnupdate.setBackground(new Color(32, 34, 37));
                    btndelete.setBackground(new Color(32, 34, 37));
                    btnupdate.setIcon(Modificardark);
                    btndelete.setIcon(Eliminardark);
                    jScrollPane1.setVisible(false);
                    TbAccesosWhite4.setVisible(false);
                    ScrollDark.setVisible(true);
                    jPanel7.setVisible(true);
                    TbAcessoDark.setVisible(true);
                    TbAcessoDark.setForeground(Color.white);
                    PanelFondo.setBackground(new Color(47, 49, 54));
                    jPanel4.setBackground(new Color(47, 49, 54));
                    jPanel5.setBackground(new Color(47, 49, 54));
                    jPanel2.setBackground(new Color(47, 49, 54));
                    jPanel1.setBackground(new Color(47, 49, 54));
                    jPanel7.setBackground(new Color(47, 49, 54));
                    jPanel6.setBackground(new Color(47, 49, 54));
                    lblAccesos.setForeground(Color.WHITE);
                    btnAgregar.setBackground(new Color(32, 34, 37));
                    btnFiltrar.setBackground(new Color(32, 34, 37));
                } else {
                    jScrollPane1.setVisible(false);
                    TbAccesosWhite4.setVisible(false);
                    ScrollDark.setVisible(true);
                    jPanel7.setVisible(true);
                    TbAcessoDark.setVisible(true);
                    TbAcessoDark.setForeground(Color.white);
                    PanelFondo.setBackground(new Color(47, 49, 54));
                    jPanel4.setBackground(new Color(47, 49, 54));
                    jPanel5.setBackground(new Color(47, 49, 54));
                    jPanel2.setBackground(new Color(47, 49, 54));
                    jPanel1.setBackground(new Color(47, 49, 54));
                    jPanel7.setBackground(new Color(47, 49, 54));
                    jPanel6.setBackground(new Color(47, 49, 54));
                    lblAccesos.setForeground(Color.WHITE);
                    btnAgregar.setBackground(new Color(32, 34, 37));
                    btnFiltrar.setBackground(new Color(32, 34, 37));
                }

                break;
            case 2:
                if (!tipouser.equals("Seguridad")) {
                    jScrollPane1.setVisible(true);
                    TbAccesosWhite4.setVisible(true);
                    ScrollDark.setVisible(false);
                    TbAcessoDark.setVisible(false);
                    PanelFondo.setBackground(new Color(231, 234, 239));
                    jPanel4.setBackground(new Color(231, 234, 239));
                    jPanel5.setBackground(new Color(231, 234, 239));
                    jPanel2.setBackground(new Color(231, 234, 239));
                    jPanel1.setBackground(new Color(231, 234, 239));
                    jPanel7.setBackground(new Color(231, 234, 239));
                    jPanel6.setBackground(new Color(231, 234, 239));
                    lblAccesos.setForeground(new Color(58, 50, 75));
                    btnAgregar.setBackground(new Color(58, 50, 75));
                    btnFiltrar.setBackground(new Color(58, 50, 75));
                    btnupdate.setBackground(new Color(231, 234, 239));
                    btndelete.setBackground(new Color(231, 234, 239));
                    btnupdate.setIcon(modifIcon);
                    btndelete.setIcon(deleteIcon);
                } else {
                    jScrollPane1.setVisible(true);
                    TbAccesosWhite4.setVisible(true);
                    ScrollDark.setVisible(false);
                    TbAcessoDark.setVisible(false);
                    PanelFondo.setBackground(new Color(231, 234, 239));
                    jPanel4.setBackground(new Color(231, 234, 239));
                    jPanel5.setBackground(new Color(231, 234, 239));
                    jPanel2.setBackground(new Color(231, 234, 239));
                    jPanel1.setBackground(new Color(231, 234, 239));
                    jPanel7.setBackground(new Color(231, 234, 239));
                    jPanel6.setBackground(new Color(231, 234, 239));
                    lblAccesos.setForeground(new Color(58, 50, 75));
                    btnAgregar.setBackground(new Color(58, 50, 75));
                    btnFiltrar.setBackground(new Color(58, 50, 75));
                }

                break;
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
        lblAccesos = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        scrollBarCustom1 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbAccesosWhite4 = new Controles_Personalizados.Tables.Table();
        jPanel7 = new javax.swing.JPanel();
        ScrollDark = new javax.swing.JScrollPane();
        TbAcessoDark = new Controles_Personalizados.Tables.TableDark();

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
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 75));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblAccesos.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblAccesos.setForeground(new java.awt.Color(58, 50, 75));
        lblAccesos.setText("Accesos");
        jPanel4.add(lblAccesos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(100, 70));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFiltrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnFiltrarMouseClicked(evt);
            }
        });
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

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        scrollBarCustom1.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom1.setForeground(new java.awt.Color(58, 50, 75));
        jPanel6.add(scrollBarCustom1, java.awt.BorderLayout.EAST);

        jScrollPane1.setVerticalScrollBar(scrollBarCustom1);

        TbAccesosWhite4 = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        TbAccesosWhite4.setBackground(new java.awt.Color(231, 234, 239));
        TbAccesosWhite4.setModel(new javax.swing.table.DefaultTableModel(
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
        TbAccesosWhite4.setGridColor(new java.awt.Color(58, 50, 75));
        TbAccesosWhite4.setMaximumSize(new java.awt.Dimension(2147483647, 880));
        TbAccesosWhite4.setMinimumSize(new java.awt.Dimension(90, 880));
        TbAccesosWhite4.setPreferredSize(new java.awt.Dimension(450, 880));
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
        });
        jScrollPane1.setViewportView(TbAccesosWhite4);

        jPanel6.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel6, java.awt.BorderLayout.CENTER);

        jPanel7.setLayout(new java.awt.BorderLayout());

        TbAcessoDark = new Controles_Personalizados.Tables.TableDark(){

            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        TbAcessoDark.setBackground(new java.awt.Color(47, 49, 54));
        TbAcessoDark.setModel(new javax.swing.table.DefaultTableModel(
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
        TbAcessoDark.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TbAcessoDark.setRowHeight(40);
        TbAcessoDark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbAcessoDarkMouseClicked(evt);
            }
        });
        ScrollDark.setViewportView(TbAcessoDark);

        jPanel7.add(ScrollDark, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel7, java.awt.BorderLayout.PAGE_START);

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


    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        add.setAction(1);
        
        if (tipouser.equals("Seguridad")) {
            if (addop.isVisible()) {
                addop.toFront();
            } else {
                add.setTypeaccess(0);
                addop.setVisible(true);
                frmstate = 2;
            }
        } else {
            if (add.isVisible()) {
                add.toFront();                
            } else {
                add.setTypeaccess(0);
                add.setVisible(true);
                frmstate = 1;
            }
        }

    }//GEN-LAST:event_btnAgregarMouseClicked

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

    private void PanelFondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseMoved

    private void PanelFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseClicked

    FrmOpcionesReportesAccesos accessReport = new FrmOpcionesReportesAccesos();
    private void btnFiltrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiltrarMouseClicked
        accessReport.setVisible(true);
    }//GEN-LAST:event_btnFiltrarMouseClicked

    private void TbAccesosWhite4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAccesosWhite4MouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_TbAccesosWhite4MouseMoved

    private void TbAccesosWhite4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAccesosWhite4MouseClicked
        JTable tb = (JTable) evt.getSource();//para obtener los datos de la fila

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
                        String notification;
                        if (tb.getModel().getValueAt(tb.getSelectedRow(), 7).toString() == "Sin Justificar") {
                            notification = tb.getModel().getValueAt(tb.getSelectedRow(), 7).toString();
                            
                        }else{
                            notification = tb.getModel().getValueAt(tb.getSelectedRow(), 7).toString();
                            add.setNofitication(tb.getModel().getValueAt(tb.getSelectedRow(), 7).toString());
                        }
                        
                        
//                       if (tb.getModel().getValueAt(tb.getSelectedRow(), 7).toString() == "") {
//                            add.setNofitication("Sin justificar");
//                            System.out.println(notification + "ds");

//                            frmstate = 1;
//                        } else {
//                            add.setNofitication(tb.getModel().getValueAt(tb.getSelectedRow(), 7).toString());
//                            System.out.println(notification + "f");
//                        }
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

    private void TbAcessoDarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAcessoDarkMouseClicked
        // TODO add your handling code here:
        JTable rc = (JTable) evt.getSource();//para obtener los datos de la fila

        int row = evt.getY() / TbAcessoDark.getRowHeight();
        int col = TbAcessoDark.getColumnModel().getColumnIndexAtX(evt.getX());
        try {
            if (row < TbAcessoDark.getRowCount() && row >= 0 && col < TbAcessoDark.getColumnCount() && col >= 0) {
                Object obj = TbAcessoDark.getValueAt(row, col);
                if (obj instanceof UWPButton) {
                    ((UWPButton) obj).doClick();
                    UWPButton btn = (UWPButton) obj;
                    if (btn.getName().equals("btnModificar")) {
                        //aquí
                        if (add.isShowing()) {
                            add.setVisible(false);
                        }
                        add.setAction(2);
                        String notification = rc.getModel().getValueAt(rc.getSelectedRow(), 7).toString();

                        if ("".equals(notification)) {
                            add.setNofitication("");
                            System.out.println(notification + "ds");
                            add.setVisible(true);
                            frmstate = 1;
                        } else {
                            add.setNofitication(rc.getModel().getValueAt(rc.getSelectedRow(), 7).toString());
                            System.out.println(notification + "f");
                        }
                        add.setID(Integer.valueOf(rc.getModel().getValueAt(rc.getSelectedRow(), 0).toString()));
                        add.setTypeaccess(Integer.valueOf(rc.getModel().getValueAt(rc.getSelectedRow(), 4).toString()));

                        add.setVisible(true);

                    }
                    if (btn.getName().equals("btnEliminar")) {
                        int msg = JOptionPane.showConfirmDialog(this, "¿Desea eliminar este dato?", "Confirmar acción", JOptionPane.YES_NO_OPTION);
                        if (msg == JOptionPane.YES_OPTION) {
                            deleteAccess(Integer.valueOf(rc.getModel().getValueAt(rc.getSelectedRow(), 0).toString()));
                        }
                    }
                }
            }
        } catch (HeadlessException | NumberFormatException e) {
            System.out.println(e.toString());
        }
    }//GEN-LAST:event_TbAcessoDarkMouseClicked

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
    private javax.swing.JScrollPane ScrollDark;
    private Controles_Personalizados.Tables.Table TbAccesosWhite4;
    private Controles_Personalizados.Tables.TableDark TbAcessoDark;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAccesos;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom1;
    // End of variables declaration//GEN-END:variables
}
