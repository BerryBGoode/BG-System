/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerPersonal;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import Controles_Personalizados.Tables.Table;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class PanelEstudiantes extends javax.swing.JPanel {

    private FrmAgg_Personal add = new FrmAgg_Personal();
    public ControllerPersonal objControllerP = new ControllerPersonal();
    public final DefaultTableModel ModelAlumnos;
    public final UWPButton btnActualizar = new UWPButton();
    public final UWPButton btnEliminar = new UWPButton();
    public final UWPButton btnReporteP = new UWPButton();
    //Codigo para colocar la letra que se utilza en el proyecto
    private Font font = new Font("Roboto Black", Font.PLAIN, 18);
    private ImageIcon modificar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    private ImageIcon eliminar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    private ImageIcon reporteimg = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report 1.png"));
    ImageIcon Modificardark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar_white.png"));
    ImageIcon Eliminardark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-trash-alt white.png"));
    ImageIcon reportedark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report-White.png"));
    private int frmstate;
    private int ID;
    FrmReportesPar frmreportes = new FrmReportesPar("Estudiantes", "Ingrese genero:");

    /**
     * Creates new form PanelPersonal
     */
    public PanelEstudiantes() {
        initComponents();
        mood();
        System.out.println("El modo en estudiantes es: " + ValidacionesSistema.ValidacionesBeep_Go.Modo);
        //Titulos de los campos que se cargan en la tabla
        String[] TitulosAlumnos = {"IDPersonal", "Nombres", "Apellidos", " Nacimiento", "Documento", "Carné", "Tipo Personal", "Direccion", "Correo", "IDTD", "IDTP", "IDG", "Genero", "Tipo Documento", "Modificar", "Eliminar", "Registro"};
        ModelAlumnos = new DefaultTableModel(null, TitulosAlumnos) {
            //Codigo para no porder modificar texto en la tabla
            @Override
            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        TbAlumnos.setModel(ModelAlumnos);
        TbAlumnos.setDefaultRenderer(Object.class, new RenderTable());
        TbAlumnos.setFont(font);
        cargarTabla();
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(0));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(12));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(11));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(10));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(9));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(8));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(7));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(6));
        TbAlumnos.removeColumn(TbAlumnos.getColumnModel().getColumn(5));
        TbAlumnosDark.setModel(ModelAlumnos);
        TbAlumnosDark.setDefaultRenderer(Object.class, new RenderTable());
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(0));
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(12));
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(11));
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(10));
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(9));
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(8));
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(7));
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(6));
        TbAlumnosDark.removeColumn(TbAlumnosDark.getColumnModel().getColumn(5));
    }

    final void refresh() {
        if (frmstate == 1 && !(add.isActive())) {
            cargarTabla();
            frmstate = 0;
        }
    }

    void mood() {
        if (ValidacionesSistema.ValidacionesBeep_Go.Modo == 1) {
            lblPersonal.setForeground(Color.WHITE);
            jPanel4.setBackground(new Color(47, 49, 54));
            PanelFondo.setBackground(new Color(47, 49, 54));
            jPanel5.setBackground(new Color(47, 49, 54));
            jPanel2.setBackground(new Color(47, 49, 54));
            btnAgregar.setBackground(new Color(32, 34, 37));
            btnFiltrar.setBackground(new Color(32, 34, 37));
            BtnReporte.setBackground(new Color(32, 34, 37));
            jPanel6.setBackground(new Color(47, 49, 54));
            jPanel7.setBackground(new Color(47, 49, 54));
            btnActualizar.setBackground(new Color(32, 34, 37));
            btnEliminar.setBackground(new Color(32, 34, 37));
            btnReporteP.setBackground(new Color(32, 34, 37));
            btnActualizar.setIcon(Modificardark);
            btnEliminar.setIcon(Eliminardark);
            btnReporteP.setIcon(reportedark);
            TbAlumnosDark.setForeground(Color.WHITE);
            TablaDark.setVisible(true);
            TbAlumnosDark.setVisible(true);
            scrollBarWhite.setVisible(false);
            jScrollPane1.setVisible(false);
            TbAlumnos.setVisible(false);
        } else {
            lblPersonal.setForeground(new Color(58, 50, 75));
            jPanel4.setBackground(new Color(231, 234, 239));
            PanelFondo.setBackground(new Color(231, 234, 239));
            jPanel5.setBackground(new Color(231, 234, 239));
            jPanel2.setBackground(new Color(231, 234, 239));
            btnAgregar.setBackground(new Color(58, 50, 75));
            btnFiltrar.setBackground(new Color(58, 50, 75));
            BtnReporte.setBackground(new Color(58, 50, 75));
            jPanel6.setBackground(new Color(231, 234, 239));
            jPanel7.setBackground(new Color(231, 234, 239));
            btnActualizar.setBackground(new Color(231, 234, 239));
            btnEliminar.setBackground(new Color(231, 234, 239));
            btnReporteP.setBackground(new Color(231, 234, 239));
            btnActualizar.setIcon(modificar);
            btnEliminar.setIcon(eliminar);
            btnReporteP.setIcon(reporteimg);
            TablaDark.setVisible(false);
            TbAlumnosDark.setVisible(false);
            scrollBarWhite.setVisible(true);
            jScrollPane1.setVisible(true);
            TbAlumnos.setVisible(true);
        }
    }

    public void mododash() {
        switch (ValidacionesSistema.ValidacionesBeep_Go.getModo()) {
            case 1:
                lblPersonal.setForeground(Color.WHITE);
                jPanel4.setBackground(new Color(47, 49, 54));
                PanelFondo.setBackground(new Color(47, 49, 54));
                jPanel5.setBackground(new Color(47, 49, 54));
                jPanel2.setBackground(new Color(47, 49, 54));
                btnAgregar.setBackground(new Color(32, 34, 37));
                btnFiltrar.setBackground(new Color(32, 34, 37));
                BtnReporte.setBackground(new Color(32, 34, 37));
                jPanel6.setBackground(new Color(47, 49, 54));
                jPanel7.setBackground(new Color(47, 49, 54));
                btnActualizar.setBackground(new Color(32, 34, 37));
                btnEliminar.setBackground(new Color(32, 34, 37));
                btnReporteP.setBackground(new Color(32, 34, 37));
                btnActualizar.setIcon(Modificardark);
                btnEliminar.setIcon(Eliminardark);
                btnReporteP.setIcon(reportedark);
                TbAlumnosDark.setForeground(Color.WHITE);
                TablaDark.setVisible(true);
                TbAlumnosDark.setVisible(true);
                scrollBarWhite.setVisible(false);
                jScrollPane1.setVisible(false);
                TbAlumnos.setVisible(false);
                break;
            case 2:
                lblPersonal.setForeground(new Color(58, 50, 75));
                jPanel4.setBackground(new Color(231, 234, 239));
                PanelFondo.setBackground(new Color(231, 234, 239));
                jPanel5.setBackground(new Color(231, 234, 239));
                jPanel2.setBackground(new Color(231, 234, 239));
                btnAgregar.setBackground(new Color(58, 50, 75));
                btnFiltrar.setBackground(new Color(58, 50, 75));
                BtnReporte.setBackground(new Color(58, 50, 75));
                jPanel6.setBackground(new Color(231, 234, 239));
                jPanel7.setBackground(new Color(231, 234, 239));
                btnActualizar.setBackground(new Color(231, 234, 239));
                btnEliminar.setBackground(new Color(231, 234, 239));
                btnReporteP.setBackground(new Color(231, 234, 239));
                btnActualizar.setIcon(modificar);
                btnEliminar.setIcon(eliminar);
                btnReporteP.setIcon(reporteimg);
                TablaDark.setVisible(false);
                TbAlumnosDark.setVisible(false);
                scrollBarWhite.setVisible(true);
                jScrollPane1.setVisible(true);
                TbAlumnos.setVisible(true);
                break;
        }
    }

    public void cargarTabla() {
        while (ModelAlumnos.getRowCount() > 0) {
            ModelAlumnos.removeRow(0);
        }
        try {
            ResultSet rs = objControllerP.MostrarEstudiantesController();
            while (rs.next()) {
                Object[] Campos = {rs.getInt("idPersonal"), rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("fecha_nacimiento"), rs.getString("documento"), rs.getString("Carnet"), rs.getString("tipo_personal"), rs.getString("direccion"), rs.getString("correo"), rs.getInt("idTipoDocumento"), rs.getInt("idTipoPersonal"), rs.getInt("idGenero"), rs.getString("genero"), rs.getString("tipo_documento"), btnActualizar, btnEliminar, btnReporteP};
                ModelAlumnos.addRow(Campos);
            }
        } catch (SQLException e) {
            System.out.println("Error al cargar tablas");
            System.out.println(e.toString());
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
        lblPersonal = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        BtnReporte = new Controles_Personalizados.Botones.UWPButton();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        TablaDark = new javax.swing.JScrollPane();
        TbAlumnosDark = new Controles_Personalizados.Tables.TableDark();
        jPanel7 = new javax.swing.JPanel();
        scrollBarWhite = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbAlumnos = new Controles_Personalizados.Tables.Table();

        setBackground(new java.awt.Color(42, 36, 56));
        setLayout(new java.awt.BorderLayout());

        PanelFondo.setBackground(new java.awt.Color(231, 234, 239));
        PanelFondo.setRoundBottomLeft(20);
        PanelFondo.setRoundBottomRight(20);
        PanelFondo.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                PanelFondoMouseMoved(evt);
            }
        });
        PanelFondo.setLayout(new java.awt.GridBagLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(231, 234, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(1240, 75));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPersonal.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblPersonal.setForeground(new java.awt.Color(58, 50, 75));
        lblPersonal.setText("Estudiantes");
        jPanel4.add(lblPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel2.add(jPanel4, java.awt.BorderLayout.NORTH);

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(1240, 70));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAgregar.setBackground(new java.awt.Color(58, 50, 75));
        btnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Agregar Blanco.png"))); // NOI18N
        btnAgregar.setText(" Agregar");
        btnAgregar.setDisabledIcon(null);
        btnAgregar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel5.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        BtnReporte.setBackground(new java.awt.Color(58, 50, 75));
        BtnReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-file-doc-white.png"))); // NOI18N
        BtnReporte.setText("Informe");
        BtnReporte.setDisabledIcon(null);
        BtnReporte.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnReporteActionPerformed(evt);
            }
        });
        jPanel5.add(BtnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 150, 40));
        BtnReporte.getAccessibleContext().setAccessibleDescription("");

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setDisabledIcon(null);
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        jPanel5.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 150, 40));

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.NORTH);

        jPanel3.setBackground(new java.awt.Color(231, 234, 239));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel6.setLayout(new java.awt.BorderLayout());

        TbAlumnosDark.setBackground(new java.awt.Color(47, 49, 54));
        TbAlumnosDark.setModel(new javax.swing.table.DefaultTableModel(
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
        TbAlumnosDark.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TbAlumnosDark.setRowHeight(40);
        TbAlumnosDark.setSelectionBackground(new java.awt.Color(47, 49, 54));
        TbAlumnosDark.setSelectionForeground(new java.awt.Color(255, 255, 255));
        TbAlumnosDark.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbAlumnosDarkMouseClicked(evt);
            }
        });
        TablaDark.setViewportView(TbAlumnosDark);

        jPanel6.add(TablaDark, java.awt.BorderLayout.PAGE_START);

        jPanel3.add(jPanel6, java.awt.BorderLayout.NORTH);

        jPanel7.setBackground(new java.awt.Color(231, 234, 239));
        jPanel7.setLayout(new java.awt.BorderLayout());

        scrollBarWhite.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarWhite.setForeground(new java.awt.Color(58, 50, 75));
        jPanel7.add(scrollBarWhite, java.awt.BorderLayout.EAST);

        jScrollPane1.setBackground(new java.awt.Color(58, 50, 75));
        jScrollPane1.setVerticalScrollBar(scrollBarWhite);

        TbAlumnos.setBackground(new java.awt.Color(231, 234, 239));
        TbAlumnos.setModel(new javax.swing.table.DefaultTableModel(
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
        TbAlumnos.setGridColor(new java.awt.Color(58, 50, 75));
        TbAlumnos.setMaximumSize(new java.awt.Dimension(2147483647, 880));
        TbAlumnos.setMinimumSize(new java.awt.Dimension(90, 880));
        TbAlumnos.setPreferredSize(new java.awt.Dimension(450, 880));
        TbAlumnos.setSelectionBackground(new java.awt.Color(58, 50, 75));
        TbAlumnos.setShowVerticalLines(false);
        TbAlumnos.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                TbAlumnosMouseMoved(evt);
            }
        });
        TbAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TbAlumnosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TbAlumnos);

        jPanel7.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel7, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 100;
        gridBagConstraints.ipady = 100;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        PanelFondo.add(jPanel1, gridBagConstraints);

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (!add.isVisible()) {
            add.setVisible(true);
            add.typestaff = 2; //student
        } else {
            add.toFront();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void PanelFondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseMoved

    private void BtnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnReporteActionPerformed
        // TODO add your handling code here:
        imprimir();
    }//GEN-LAST:event_BtnReporteActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        if (frmreportes.isVisible()) {
            frmreportes.toFront();
        } else {
            frmreportes.setVisible(true);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed

    private void TbAlumnosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAlumnosMouseMoved
        // TODO add your handling code here:
        refresh();

    }//GEN-LAST:event_TbAlumnosMouseMoved

    private void TbAlumnosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAlumnosMouseClicked
        // TODO add your handling code here:
        Table tb = (Table) evt.getSource();
        JTable rcp = (JTable) evt.getSource();
        int column = TbAlumnos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbAlumnos.getRowHeight();
        btnActualizar.setName("btnActualizar");
        btnEliminar.setName("btnEliminar");
        btnReporteP.setName("btnReport");
        if (evt.getClickCount() == 1) {
            ID = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0);
            ValidacionesSistema.Parametros_Personal.setIdPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
            ValidacionesSistema.Parametros_Personal.setnombre_personal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            ValidacionesSistema.Parametros_Personal.setApellido_personal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            ValidacionesSistema.Parametros_Personal.setFecha_nacimiento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            ValidacionesSistema.Parametros_Personal.setDocumento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            //ValidacionesSistema.Parametros_Personal.setCarnet(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
            ValidacionesSistema.Parametros_Personal.setCorreo(rcp.getModel().getValueAt(rcp.getSelectedRow(), 8).toString());
            ValidacionesSistema.Parametros_Personal.setDireccion(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            ValidacionesSistema.Parametros_Personal.setIdTipoPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 10));
            ValidacionesSistema.Parametros_Personal.setIdTipoDocumento((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 9));
            ValidacionesSistema.Parametros_Personal.setIdGenero((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 11));
            ValidacionesSistema.Parametros_Personal.setTipoPersonal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());
            ValidacionesSistema.Parametros_Personal.setTipoDocumento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 13).toString());
            ValidacionesSistema.Parametros_Personal.setGenero(rcp.getModel().getValueAt(rcp.getSelectedRow(), 12).toString());
        }
        if (row < TbAlumnos.getRowCount() || row >= 0 || column < TbAlumnos.getColumnCount() || column >= 0) {
            Object vals = TbAlumnos.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnActualizar")) {
                    if (rcp.getModel().getValueAt(rcp.getSelectedRow(), 5) == null) {
                        JOptionPane.showMessageDialog(null, "Ocurrieron problemas, al intentar cargar la informacion debido que este registro no tiene carné", "Error de carné", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println(ValidacionesSistema.Parametros_Personal.getCarnet());
                        FrmAgg_Personal frmAgg_Personal = new FrmAgg_Personal(ValidacionesSistema.Parametros_Personal.getIdPersonal());
                        frmAgg_Personal.show();
                        frmstate = 1;
                    }

                    //Actualizar Contacto metodo
                }
                if (btns.getName().equals("btnReport")) {
                    imprimironly1();

                }
                if (btns.getName().equals("btnEliminar")) {
                    int confirmar = JOptionPane.YES_NO_OPTION;
                    int a = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar el registro de: " + ValidacionesSistema.Parametros_Personal.getnombre_personal() + "?", "Proceso de Eliminar", confirmar);
                    if (a == 0) {
                        objControllerP.idpersonal = ValidacionesSistema.Parametros_Personal.getIdPersonal();
                        if (objControllerP.EliminarRegistroController() == true) {
                            JOptionPane.showMessageDialog(null, "Su registro a sido Eliminado", "Proceso Completado", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }
            }
        }
    }//GEN-LAST:event_TbAlumnosMouseClicked

    private void TbAlumnosDarkMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbAlumnosDarkMouseClicked
        // TODO add your handling code here:
        JTable rcp = (JTable) evt.getSource();
        int column = TbAlumnosDark.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbAlumnosDark.getRowHeight();
        btnActualizar.setName("btnActualizar");
        btnEliminar.setName("btnEliminar");
        btnReporteP.setName("btnReport");
        if (evt.getClickCount() == 1) {
            ID = (int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0);
            ValidacionesSistema.Parametros_Personal.setIdPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
            ValidacionesSistema.Parametros_Personal.setnombre_personal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 1).toString());
            ValidacionesSistema.Parametros_Personal.setApellido_personal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 2).toString());
            ValidacionesSistema.Parametros_Personal.setFecha_nacimiento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 3).toString());
            ValidacionesSistema.Parametros_Personal.setDocumento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            //ValidacionesSistema.Parametros_Personal.setCarnet(rcp.getModel().getValueAt(rcp.getSelectedRow(), 5).toString());
            ValidacionesSistema.Parametros_Personal.setCorreo(rcp.getModel().getValueAt(rcp.getSelectedRow(), 8).toString());
            ValidacionesSistema.Parametros_Personal.setDireccion(rcp.getModel().getValueAt(rcp.getSelectedRow(), 7).toString());
            ValidacionesSistema.Parametros_Personal.setIdTipoPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 10));
            ValidacionesSistema.Parametros_Personal.setIdTipoDocumento((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 9));
            ValidacionesSistema.Parametros_Personal.setIdGenero((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 11));
            ValidacionesSistema.Parametros_Personal.setTipoPersonal(rcp.getModel().getValueAt(rcp.getSelectedRow(), 6).toString());
            ValidacionesSistema.Parametros_Personal.setTipoDocumento(rcp.getModel().getValueAt(rcp.getSelectedRow(), 13).toString());
            ValidacionesSistema.Parametros_Personal.setGenero(rcp.getModel().getValueAt(rcp.getSelectedRow(), 12).toString());
        }
        if (row < TbAlumnosDark.getRowCount() || row >= 0 || column < TbAlumnosDark.getColumnCount() || column >= 0) {
            Object vals = TbAlumnosDark.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnActualizar")) {
                    if (rcp.getModel().getValueAt(rcp.getSelectedRow(), 5) == null) {
                        JOptionPane.showMessageDialog(null, "Ocurrieron problemas, al intentar cargar la informacion debido que este registro no tiene carné", "Error de carné", JOptionPane.WARNING_MESSAGE);
                    } else {
                        System.out.println(ValidacionesSistema.Parametros_Personal.getCarnet());
                        FrmAgg_Personal frmAgg_Personal = new FrmAgg_Personal(ValidacionesSistema.Parametros_Personal.getIdPersonal());
                        frmAgg_Personal.show();
                        frmstate = 1;
                    }

                    //Actualizar Contacto metodo
                }
                if (btns.getName().equals("btnReport")) {
                    imprimironly1();

                }
                if (btns.getName().equals("btnEliminar")) {
                    int confirmar = JOptionPane.YES_NO_OPTION;
                    int a = JOptionPane.showConfirmDialog(this, "¿Desea Eliminar el registro de: " + ValidacionesSistema.Parametros_Personal.getnombre_personal() + "?", "Proceso de Eliminar", confirmar);
                    if (a == 0) {
                        objControllerP.idpersonal = ValidacionesSistema.Parametros_Personal.getIdPersonal();
                        if (objControllerP.EliminarRegistroController() == true) {
                            JOptionPane.showMessageDialog(null, "Su registro a sido Eliminado", "Proceso Completado", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                }
            }
        }
    }//GEN-LAST:event_TbAlumnosDarkMouseClicked
    void imprimironly1() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String dir = "src/DocsReport/EstudianteReporte.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(dir);
            Map param = new HashMap<>();
            param.put("idPersonal", ID);
            param.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Nombre", "src\\Recursos_Proyecto\\TextoLogin.png");
            System.out.println(param);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
            System.out.println("si, se imprime");
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }

    void imprimir() {
        Connection con = ControllerConexion.getConnectionModel();
        try {
            String dir = "src/DocsReport/InformeEstudiantes.jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObjectFromFile(dir);
            Map param = new HashMap<>();
            param.put("Logo1", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            param.put("Texto", "src\\Recursos_Proyecto\\TextoLogin.png");
            System.out.println(param);
            JasperPrint jp = JasperFillManager.fillReport(jr, param, con);
            JasperViewer jv = new JasperViewer(jp, false);
            jv.setVisible(true);
        } catch (JRException e) {
            System.out.println("Error" + e.toString());
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Botones.UWPButton BtnReporte;
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private javax.swing.JScrollPane TablaDark;
    private Controles_Personalizados.Tables.Table TbAlumnos;
    private Controles_Personalizados.Tables.TableDark TbAlumnosDark;
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
    private javax.swing.JLabel lblPersonal;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarWhite;
    // End of variables declaration//GEN-END:variables
}
