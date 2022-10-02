/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerUsuarios;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import java.awt.Color;
import java.awt.Font;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author ferna
 */
public class PanelUsuarios_dashbord extends javax.swing.JPanel {

    DefaultTableModel modelo;
    DefaultTableModel modelodark;
    public final UWPButton btnActualizar = new UWPButton();
    public final UWPButton btnEliminar = new UWPButton();
    public final UWPButton btnReporte = new UWPButton();
    private final UWPButton btnActualizardark = new UWPButton();
    private final UWPButton btnEliminardark = new UWPButton();
    private final UWPButton btnReportedark = new UWPButton();
    private Font font = new Font("Roboto Black", Font.PLAIN, 18);
    ImageIcon Modificar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar.png"));
    ImageIcon Eliminar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/eliminar.png"));
    ImageIcon reporte = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report 1.png"));
    ImageIcon Modificardark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/editar_white.png"));
    ImageIcon Eliminardark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-trash-alt white.png"));
    ImageIcon reportedark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-report-White.png"));
    FrmAgg_Usuarios agg = new FrmAgg_Usuarios();
    private int frmstate = 1;
    byte[] imagen;
    FrmReportesPar frmreporte = new FrmReportesPar("Usuarios", "Ingrese tipo de usuario/estado del usuario:");

    /**
     * Creates new form PanelUsuario_dashbord
     */
    public PanelUsuarios_dashbord() {
        initComponents();
        System.out.println(ValidacionesSistema.ValidacionesBeep_Go.getModo());
//        if (ValidacionesSistema.ValidacionesBeep_Go.getModo() == 2) {
//            CargarTabladark();
//            tbUsuarioDark.setModel(modelodark);
//        } else if (ValidacionesSistema.ValidacionesBeep_Go.Modo == 1) {
//            CargarTabla();
//            tbUsuarios.setModel(modelo);
//        }
        modo();
        //tbUsuarioDark.setVisible(false);
        //tbUsuarios.setVisible(true);
        String[] TitulosTabla = {"ID", "idPersonal", "Nombres", "Apellidos", "Usuario", "idTipoUsuario", "Tipo de usuario", "idEstadoUsuario", "Estado", "Imagen", "Modificar", "Eliminar", "Registro"};
        modelo = new DefaultTableModel(null, TitulosTabla) {
            @Override
            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        modelodark = new DefaultTableModel(null, TitulosTabla) {
            @Override
            public boolean isCellEditable(int row, int column) { // aqui esta
                return false;
            }
        };
        CargarTabla();
        CargarTabladark();
        tbUsuarios.setModel(modelo);
        tbUsuarios.setDefaultRenderer(Object.class, new RenderTable());
        tbUsuarios.setFont(font);
        tbUsuarios.removeColumn(tbUsuarios.getColumnModel().getColumn(0));
        tbUsuarios.removeColumn(tbUsuarios.getColumnModel().getColumn(0));
        tbUsuarios.removeColumn(tbUsuarios.getColumnModel().getColumn(3));
        tbUsuarios.removeColumn(tbUsuarios.getColumnModel().getColumn(4));
        tbUsuarios.removeColumn(tbUsuarios.getColumnModel().getColumn(5));
        //DarkTable
        tbUsuarioDark.setModel(modelodark);
        tbUsuarioDark.setDefaultRenderer(Object.class, new RenderTable());
        tbUsuarioDark.setFont(font);
        tbUsuarioDark.removeColumn(tbUsuarioDark.getColumnModel().getColumn(0));
        tbUsuarioDark.removeColumn(tbUsuarioDark.getColumnModel().getColumn(0));
        tbUsuarioDark.removeColumn(tbUsuarioDark.getColumnModel().getColumn(3));
        tbUsuarioDark.removeColumn(tbUsuarioDark.getColumnModel().getColumn(4));
        tbUsuarioDark.removeColumn(tbUsuarioDark.getColumnModel().getColumn(5));
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

        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ScrollTabla = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbUsuarios = new Controles_Personalizados.Tables.Table();
        scrollBarCustom1 = new Controles_Personalizados.ScrollBar.ScrollBarCustom();
        Scroll = new javax.swing.JScrollPane();
        tbUsuarioDark = new Controles_Personalizados.Tables.TableDark();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        btnInforme = new Controles_Personalizados.Botones.UWPButton();
        jPanel5 = new javax.swing.JPanel();
        lblParqueo = new javax.swing.JLabel();

        setBackground(new java.awt.Color(42, 36, 56));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                formMouseReleased(evt);
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

        jPanel1.setBackground(new java.awt.Color(231, 234, 239));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 50));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(231, 234, 239));
        jPanel2.setLayout(new java.awt.BorderLayout());

        ScrollTabla.setBackground(new java.awt.Color(58, 50, 75));
        ScrollTabla.setForeground(new java.awt.Color(58, 50, 75));
        jPanel2.add(ScrollTabla, java.awt.BorderLayout.EAST);

        jScrollPane1.setVerticalScrollBar(ScrollTabla);

        tbUsuarios.setBackground(new java.awt.Color(231, 234, 239));
        tbUsuarios.setModel(new javax.swing.table.DefaultTableModel(
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
        tbUsuarios.setGridColor(new java.awt.Color(58, 50, 75));
        tbUsuarios.setMaximumSize(new java.awt.Dimension(2147483647, 880));
        tbUsuarios.setMinimumSize(new java.awt.Dimension(90, 880));
        tbUsuarios.setPreferredSize(new java.awt.Dimension(450, 880));
        tbUsuarios.setSelectionBackground(new java.awt.Color(58, 50, 75));
        tbUsuarios.setShowVerticalLines(false);
        tbUsuarios.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseMoved(evt);
            }
        });
        tbUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbUsuarios);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        scrollBarCustom1.setBackground(new java.awt.Color(58, 50, 75));
        scrollBarCustom1.setForeground(new java.awt.Color(58, 50, 75));
        jPanel2.add(scrollBarCustom1, java.awt.BorderLayout.EAST);

        Scroll.setBackground(new java.awt.Color(0, 0, 0));
        Scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        Scroll.setVerticalScrollBar(scrollBarCustom1);

        tbUsuarioDark.setBackground(new java.awt.Color(0, 0, 0));
        tbUsuarioDark.setModel(new javax.swing.table.DefaultTableModel(
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
        Scroll.setViewportView(tbUsuarioDark);

        jPanel2.add(Scroll, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setPreferredSize(new java.awt.Dimension(1240, 135));
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(231, 234, 239));
        jPanel4.setPreferredSize(new java.awt.Dimension(1240, 70));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel4.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 150, 40));

        btnFiltrar.setBackground(new java.awt.Color(58, 50, 75));
        btnFiltrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Filtrar Blanco.png"))); // NOI18N
        btnFiltrar.setText(" Filtrar");
        btnFiltrar.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnFiltrar.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnFiltrar.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });
        jPanel4.add(btnFiltrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 0, 150, 40));

        btnInforme.setBackground(new java.awt.Color(58, 50, 75));
        btnInforme.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-file-doc-white.png"))); // NOI18N
        btnInforme.setText("Informe");
        btnInforme.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        btnInforme.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btnInforme.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnInforme.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInformeMouseClicked(evt);
            }
        });
        jPanel4.add(btnInforme, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 0, 150, 40));

        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(231, 234, 239));
        jPanel5.setPreferredSize(new java.awt.Dimension(1240, 75));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblParqueo.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblParqueo.setForeground(new java.awt.Color(58, 50, 75));
        lblParqueo.setText("Usuarios");
        jPanel5.add(lblParqueo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        jPanel3.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 550;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(10, 15, 10, 15);
        panelRound1.add(jPanel1, gridBagConstraints);

        add(panelRound1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public final void CargarTabla() {
        ControllerUsuarios obj = new ControllerUsuarios();
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        try {
            obj.setNombre_usuario(FrmLogin.nombre);
            ResultSet rs = obj.CargarUsuarios_C();
            while (rs.next()) {
                btnActualizar.setIcon(Modificar);
                btnEliminar.setIcon(Eliminar);
                btnReporte.setIcon(reporte);
                Object[] oValores = {rs.getInt("idUsuario"), rs.getInt("idPersonal"), rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("nombre_usuario"), rs.getInt("idTipoUsuario"), rs.getString("tipo_usuario"), rs.getInt("idEstadoUsuario"), rs.getString("estado_usuario"), rs.getBytes("imagen"), btnActualizar, btnEliminar, btnReporte};

                modelo.addRow(oValores);
                System.out.println("cargando info normal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public final void CargarTabladark() {
        ControllerUsuarios obj = new ControllerUsuarios();
        while (modelodark.getRowCount() > 0) {
            modelodark.removeRow(0);
        }
        try {
            obj.setNombre_usuario(FrmLogin.nombre);
            ResultSet rs = obj.CargarUsuarios_C();
            while (rs.next()) {
                btnActualizardark.setIcon(Modificardark);
                btnEliminardark.setIcon(Eliminardark);
                btnReportedark.setIcon(reportedark);
                Object[] oValores = {rs.getInt("idUsuario"), rs.getInt("idPersonal"), rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("nombre_usuario"), rs.getInt("idTipoUsuario"), rs.getString("tipo_usuario"), rs.getInt("idEstadoUsuario"), rs.getString("estado_usuario"), rs.getBytes("imagen"), btnActualizardark, btnEliminardark, btnReportedark};

                modelodark.addRow(oValores);
                System.out.println("cargando info normal");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    public final void darkmod() {
        switch (ValidacionesSistema.ValidacionesBeep_Go.getModo()) {
            case 1:
                panelRound1.setBackground(new Color(47, 49, 54));
                lblParqueo.setForeground(Color.WHITE);
                jPanel5.setBackground(new Color(47, 49, 54));
                jPanel4.setBackground(new Color(47, 49, 54));
                btnAgregar.setBackground(new Color(32, 34, 37));
                btnFiltrar.setBackground(new Color(32, 34, 37));
                btnInforme.setBackground(new Color(32, 34, 37));
                jPanel2.setBackground(new Color(47, 49, 54));
                tbUsuarioDark.setGridColor(new Color(32, 34, 37));
                btnActualizardark.setBackground(new Color(47, 49, 54));
                btnEliminardark.setBackground(new Color(47, 49, 54));
                btnReportedark.setBackground(new Color(47, 49, 54));
                float xwhite = tbUsuarios.getX();
                float ywhite = tbUsuarios.getY();
                int widhtwhite = tbUsuarios.getWidth();
                int heightwhite = tbUsuarios.getHeight();
                jScrollPane1.setVisible(false);
                tbUsuarios.setVisible(false);
                Scroll.setVisible(true);
                tbUsuarioDark.setVisible(true);
                tbUsuarioDark.setAlignmentY(ywhite);
                tbUsuarioDark.setSize(widhtwhite, heightwhite);
                tbUsuarioDark.setAlignmentX(xwhite);
                tbUsuarioDark.setBackground(new Color(47, 49, 54));
                tbUsuarioDark.setForeground(Color.WHITE);
                break;
            case 2:
                panelRound1.setBackground(new Color(231, 234, 239));
                lblParqueo.setForeground(new Color(58, 50, 75));
                jPanel5.setBackground(new Color(231, 234, 239));
                jPanel4.setBackground(new Color(231, 234, 239));
                btnAgregar.setBackground(new Color(58, 50, 75));
                btnFiltrar.setBackground(new Color(58, 50, 75));
                btnInforme.setBackground(new Color(58, 50, 75));
                jPanel2.setBackground(new Color(231, 234, 239));
                btnActualizar.setBackground(new Color(231, 234, 239));
                btnEliminar.setBackground(new Color(231, 234, 239));
                btnReporte.setBackground(new Color(231, 234, 239));
                jScrollPane1.setVisible(true);
                tbUsuarios.setVisible(true);
                Scroll.setVisible(false);
                tbUsuarioDark.setVisible(false);
                break;
        }
    }

    private void modo() {
        if (ValidacionesSistema.ValidacionesBeep_Go.Modo == 1) {
            panelRound1.setBackground(new Color(47, 49, 54));
            lblParqueo.setForeground(Color.WHITE);
            jPanel5.setBackground(new Color(47, 49, 54));
            jPanel4.setBackground(new Color(47, 49, 54));
            btnAgregar.setBackground(new Color(32, 34, 37));
            btnFiltrar.setBackground(new Color(32, 34, 37));
            btnInforme.setBackground(new Color(32, 34, 37));
            jPanel2.setBackground(new Color(47, 49, 54));
            tbUsuarioDark.setGridColor(new Color(32, 34, 37));
            btnActualizar.setBackground(new Color(47, 49, 54));
            btnEliminar.setBackground(new Color(47, 49, 54));
            btnReporte.setBackground(new Color(47, 49, 54));
            float xwhite = tbUsuarios.getX();
            float ywhite = tbUsuarios.getY();
            int widhtwhite = tbUsuarios.getWidth();
            int heightwhite = tbUsuarios.getHeight();
            jScrollPane1.setVisible(false);
            tbUsuarios.setVisible(false);
            Scroll.setVisible(true);
            tbUsuarioDark.setVisible(true);
            tbUsuarioDark.setAlignmentY(ywhite);
            tbUsuarioDark.setSize(widhtwhite, heightwhite);
            tbUsuarioDark.setAlignmentX(xwhite);
            tbUsuarioDark.setBackground(new Color(47, 49, 54));
            tbUsuarioDark.setForeground(Color.WHITE);
        } else {
            panelRound1.setBackground(new Color(231, 234, 239));
            lblParqueo.setForeground(new Color(58, 50, 75));
            jPanel5.setBackground(new Color(231, 234, 239));
            jPanel4.setBackground(new Color(231, 234, 239));
            btnAgregar.setBackground(new Color(58, 50, 75));
            btnFiltrar.setBackground(new Color(58, 50, 75));
            btnInforme.setBackground(new Color(58, 50, 75));
            jPanel2.setBackground(new Color(231, 234, 239));
            btnActualizar.setBackground(new Color(231, 234, 239));
            btnEliminar.setBackground(new Color(231, 234, 239));
            btnReporte.setBackground(new Color(231, 234, 239));
            jScrollPane1.setVisible(true);
            tbUsuarios.setVisible(true);
            Scroll.setVisible(false);
            tbUsuarioDark.setVisible(false);
        }
    }

    /* btnModificar.setIcon(Modificar);
    btnEliminar.setIcon(Eliminar);
    btnModificar.setBackground(new Color(231,234,239));
    btnEliminar.setBackground(new Color(231,234,239)); */
    void CargarImagen() {
        ControllerUsuarios objc = new ControllerUsuarios(ValidacionesSistema.Parametros_Usuario.getID());
        ResultSet rs;
        rs = objc.BuscarImagen_C();
        try {
            if (rs.next()) {
                imagen = rs.getBytes("imagen");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    void ReportePar() {
        try {
            Connection con = ControllerConexion.getConnectionModel();
            JasperReport reporte = null;

            String dir = "src\\DocsReport\\UsuarioPReportID.jasper";
            Map parametros = new HashMap();
            parametros.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            parametros.put("idUsuario", ValidacionesSistema.Parametros_Usuario.getID());
            if (ValidacionesSistema.Parametros_Usuario.getImagen() != null) {
                InputStream input = new ByteArrayInputStream(ValidacionesSistema.Parametros_Usuario.getImagen());
                parametros.put("imagenusu", input);
            }
            reporte = (JasperReport) JRLoader.loadObjectFromFile(dir);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    final void refresh() {
        if (frmstate == 1 && !(agg.isActive())) {
            CargarTabla();
            frmstate = 0;
        }
    }

    private void btnAgregarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAgregarMouseClicked
        // TODO add your handling code here:
        if (agg.isVisible()) {
            agg.toFront();

        } else {
            agg.setTitle("Agregar usuario");
            agg.setVisible(true);
        }
        frmstate = 1;
    }//GEN-LAST:event_btnAgregarMouseClicked

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void formMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseReleased
        refresh();
    }//GEN-LAST:event_formMouseReleased

    private void btnInformeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInformeMouseClicked
        // TODO add your handling code here:
        try {
            Connection con = ControllerConexion.getConnectionModel();
            JasperReport reporte = null;
            String dir = "src\\DocsReport\\UsuariosReport.jasper";
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

    private void tbUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseClicked
        // TODO add your handling code here:
        JTable tb = (JTable) evt.getSource();
        String nombre = null;
        int column = tbUsuarios.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbUsuarios.getRowHeight();
        btnActualizar.setName("btnActualizar");
        btnEliminar.setName("btnEliminar");
        btnReporte.setName("btnReporte");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            ValidacionesSistema.Parametros_Usuario.setID((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
            ValidacionesSistema.Parametros_Usuario.setIdPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 1));
            ValidacionesSistema.Parametros_Usuario.setNombre_usuario(rcp.getModel().getValueAt(rcp.getSelectedRow(), 4).toString());
            ValidacionesSistema.Parametros_Usuario.setIdTipoUsuario((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 5));
            ValidacionesSistema.Parametros_Usuario.setIdEstadoUsuario((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 7));
            CargarImagen();
            ValidacionesSistema.Parametros_Usuario.setImagen(imagen);
        }

        if (row < tbUsuarios.getRowCount() || row >= 0 || column < tbUsuarios.getColumnCount() || column >= 0) {
            Object vals = tbUsuarios.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnActualizar")) {
                    FrmAgg_Usuarios ac = new FrmAgg_Usuarios("Actualizar usuario");
                    if (ac.isVisible()) {
                        ac.toFront();
                    } else {
                        ac.setVisible(true);
                        frmstate = 1;
                    }

                }
                if (btns.getName().equals("btnEliminar")) {
                    int confirmar = 0;
                    nombre = ValidacionesSistema.Parametros_Usuario.getNombre_usuario();
                    confirmar = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el usuario de: " + nombre + "?", "Proceso de Eliminar", confirmar);
                    if (confirmar == 0) {
                        ControllerUsuarios obje = new ControllerUsuarios(ValidacionesSistema.Parametros_Usuario.getID());
                        boolean respuesta = obje.EliminarUsuario_C();
                        if (respuesta == true) {
                            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado", "Usuario eliminado", 1);
                            CargarTabla();
                        } else {
                            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso fallido", "Usuario no pudo ser eliminado", 2);
                        }
                    }
                }
                if (btns.getName().equals("btnReporte")) {
                    ReportePar();
                }
            }
        }
    }//GEN-LAST:event_tbUsuariosMouseClicked

    private void panelRound1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRound1MouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_panelRound1MouseMoved

    private void tbUsuariosMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbUsuariosMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_tbUsuariosMouseMoved

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        // TODO add your handling code here:
        if (frmreporte.isVisible()) {
            frmreporte.toFront();

        } else {
            frmreporte.setVisible(true);
        }
    }//GEN-LAST:event_btnFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane Scroll;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom ScrollTabla;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private Controles_Personalizados.Botones.UWPButton btnInforme;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblParqueo;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom scrollBarCustom1;
    private Controles_Personalizados.Tables.TableDark tbUsuarioDark;
    private Controles_Personalizados.Tables.Table tbUsuarios;
    // End of variables declaration//GEN-END:variables
}
