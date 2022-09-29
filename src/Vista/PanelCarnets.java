/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerCarnets;
import Controles_Personalizados.Botones.ButtonGradient;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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

    private DefaultTableModel model;
    private ControllerCarnets ObjController = new ControllerCarnets();
    private final UWPButton btnGenerar = new UWPButton();
    private int ID;
    private File file;
    private static String Carnet;
    private int frmstate;
    public Font font = new Font("Roboto Black", Font.PLAIN, 18);
    ImageIcon modifIcon = new ImageIcon(getClass().getResource("/Recursos_Proyecto/Barcode.png"));
    ImageIcon modifIcondark = new ImageIcon(getClass().getResource("/Recursos_Proyecto/bx-barcode-White.png"));

    /**
     * Creates new form PanelCarnets
     */
    public PanelCarnets() {
        initComponents();
        modo();
        String[] TitulosCarnets = {"Nombre", "Apellido", "Carné", "Tipo de usuario", "idPersonal", "Codigo de barra"};
        model = new DefaultTableModel(null, TitulosCarnets);
        TbCarnets.setModel(model);
        TbCarnets.setDefaultRenderer(Object.class, new RenderTable());
        btnGenerar.setFont(font);
        btnGenerar.setText("Generar");
        TbCarnets.removeColumn(TbCarnets.getColumnModel().getColumn(4));
        //DarkTable
        TbCarnetsDark.setModel(model);
        TbCarnetsDark.setDefaultRenderer(Object.class, new RenderTable());
        TbCarnetsDark.removeColumn(TbCarnetsDark.getColumnModel().getColumn(4));
        cargarTabla();
    }

    void cargarTabla() {
        while (model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            ResultSet rs = ObjController.cargarTablaController();
            while (rs.next()) {
                Object[] Valores = {rs.getString("nombre_p"), rs.getString("apellido_p"), rs.getString("Carnet"), rs.getString("tipo_personal"), rs.getInt("idPersonal"), btnGenerar};
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

    void modo() {
        if (ValidacionesSistema.ValidacionesBeep_Go.getModo() == 1) {
            PanelFondo.setBackground(new Color(47, 49, 54));
            btnAgregar.setBackground(new Color(32, 34, 37));
            btnFiltrar.setBackground(new Color(32, 34, 37));
            TbCarnetsDark.setBackground(new Color(47, 49, 54));
            TbCarnetsDark.setForeground(Color.WHITE);
            lblCarnets.setForeground(Color.WHITE);
            PanelTabla.setVisible(false);
            TbCarnets.setVisible(false);
            jScrollPane2.setVisible(true);
            TbCarnetsDark.setVisible(true);
            btnGenerar.setBackground(new Color(32, 34, 37));
            btnGenerar.setForeground(Color.WHITE);
            btnGenerar.setIcon(modifIcondark);

        } else {
            btnGenerar.setBackground(new Color(231, 235, 239));
            btnGenerar.setForeground(new Color(58, 50, 75));
            btnGenerar.setIcon(modifIcon);
            PanelFondo.setBackground(new Color(231, 235, 239));
            btnAgregar.setBackground(new Color(58, 50, 75));
            btnFiltrar.setBackground(new Color(58, 50, 75));
            lblCarnets.setForeground(new Color(58, 50, 75));
            PanelTabla.setVisible(true);
            TbCarnets.setVisible(true);
            jScrollPane2.setVisible(false);
            TbCarnetsDark.setVisible(false);
        }
    }

    void mododash() {
        switch (ValidacionesSistema.ValidacionesBeep_Go.getModo()) {
            case 1:
            PanelFondo.setBackground(new Color(47, 49, 54));
            btnAgregar.setBackground(new Color(32, 34, 37));
            btnFiltrar.setBackground(new Color(32, 34, 37));
            TbCarnetsDark.setBackground(new Color(47, 49, 54));
            TbCarnetsDark.setForeground(Color.WHITE);
            lblCarnets.setForeground(Color.WHITE);
            PanelTabla.setVisible(false);
            TbCarnets.setVisible(false);
            jScrollPane2.setVisible(true);
            TbCarnetsDark.setVisible(true);
            btnGenerar.setBackground(new Color(32, 34, 37));
            btnGenerar.setForeground(Color.WHITE);
            btnGenerar.setIcon(modifIcondark);
                break;
            case 2:
                btnGenerar.setBackground(new Color(231, 235, 239));
                btnGenerar.setForeground(new Color(58, 50, 75));
                btnGenerar.setIcon(modifIcon);
                PanelFondo.setBackground(new Color(231, 235, 239));
                btnAgregar.setBackground(new Color(58, 50, 75));
                btnFiltrar.setBackground(new Color(58, 50, 75));
                lblCarnets.setForeground(new Color(58, 50, 75));
                PanelTabla.setVisible(true);
                TbCarnets.setVisible(true);
                jScrollPane2.setVisible(false);
                TbCarnetsDark.setVisible(false);
                break;
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelFondo = new Controles_Personalizados.Paneles.PanelRound();
        lblCarnets = new javax.swing.JLabel();
        btnFiltrar = new Controles_Personalizados.Botones.UWPButton();
        btnAgregar = new Controles_Personalizados.Botones.UWPButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TbCarnetsDark = new Controles_Personalizados.Tables.TableDark();
        PanelTabla = new javax.swing.JScrollPane();
        TbCarnets = new Controles_Personalizados.Tables.Table();
        scrollBar1 = new Controles_Personalizados.ScrollBar.ScrollBar();

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

        lblCarnets.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblCarnets.setForeground(new java.awt.Color(58, 50, 75));
        lblCarnets.setText("Carnets");
        PanelFondo.add(lblCarnets, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

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
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        PanelFondo.add(btnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 150, 40));

        TbCarnetsDark.setModel(new javax.swing.table.DefaultTableModel(
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
        TbCarnetsDark.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jScrollPane2.setViewportView(TbCarnetsDark);

        PanelFondo.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1230, 480));

        PanelTabla.setHorizontalScrollBar(null);
        PanelTabla.setVerticalScrollBar(scrollBar1);
        PanelTabla.setWheelScrollingEnabled(false);

        TbCarnets = new Controles_Personalizados.Tables.Table(){

            public boolean isCellEditable(int rowIndex, int colIndex){
                return false;
            }

        };
        TbCarnets.setBackground(new java.awt.Color(231, 234, 239));
        TbCarnets.setModel(new javax.swing.table.DefaultTableModel(
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
        TbCarnets.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        TbCarnets.setGridColor(new java.awt.Color(58, 50, 75));
        TbCarnets.setName(""); // NOI18N
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

        PanelFondo.add(PanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 1230, 480));
        PanelTabla.getAccessibleContext().setAccessibleParent(PanelTabla);

        PanelFondo.add(scrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 140, 10, 480));

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

    private void TbCarnetsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbCarnetsMouseClicked
        // TODO add your handling code here:
        int column = TbCarnets.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / TbCarnets.getRowHeight();
        btnGenerar.setName("btnGenerar");
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
                }
            }
        }
    }//GEN-LAST:event_TbCarnetsMouseClicked

    private void PanelFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseClicked
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseClicked

    private void TbCarnetsMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TbCarnetsMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_TbCarnetsMouseMoved

    private void PanelFondoMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelFondoMouseMoved
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_PanelFondoMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private javax.swing.JScrollPane PanelTabla;
    private Controles_Personalizados.Tables.Table TbCarnets;
    private Controles_Personalizados.Tables.TableDark TbCarnetsDark;
    private Controles_Personalizados.Botones.UWPButton btnAgregar;
    private Controles_Personalizados.Botones.UWPButton btnFiltrar;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCarnets;
    private Controles_Personalizados.ScrollBar.ScrollBar scrollBar1;
    // End of variables declaration//GEN-END:variables
}
