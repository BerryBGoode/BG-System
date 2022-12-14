/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerContactos;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import java.awt.geom.RoundRectangle2D;
import java.awt.Shape;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferna
 */
public class FrmPersonal_Contacto extends javax.swing.JFrame {

    /**
     * Creates new form FrmPersonal_Contacto
     */
    DefaultTableModel modelPersonal;

    UWPButton btnAgregar = new UWPButton();
    ImageIcon Agregar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/Agregar.png"));

    public FrmPersonal_Contacto() {
        initComponents();
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());

        tbPersonal_Contactos.setDefaultRenderer(Object.class, new RenderTable());

        String[] headerTable = {"ID Personal", "Personal", "fecha_nacimiento", "Documento", "Tipo de documento", "Agregar"};
        modelPersonal = new DefaultTableModel(null, headerTable) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        CargarTablaPersonal();
    }

    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    final void CargarTablaPersonal() {
        tbPersonal_Contactos.setModel(modelPersonal);
        while (modelPersonal.getRowCount() > 0) {
            modelPersonal.removeRow(0);
        }
        try {
            ResultSet rs = ControllerContactos.CargarTablaPersonal_Controller();
            while (rs.next()) {
                btnAgregar.setIcon(Agregar);
                btnAgregar.setBackground(new Color(231, 234, 239));
                Object[] oValues = {rs.getInt("idPersonal"), rs.getString("Personal"), rs.getString("fecha_nacimiento"), rs.getString("documento"), rs.getString("tipo_personal"), btnAgregar};
                modelPersonal.addRow(oValues);
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

        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        btnMinimizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        lblVehiculos = new javax.swing.JLabel();
        PanelTabla = new javax.swing.JScrollPane();
        tbPersonal_Contactos = new Controles_Personalizados.Tables.Table();
        ScrollTabla = new Controles_Personalizados.ScrollBar.ScrollBarCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        panelRound1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        panelRound1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, -1));

        lblVehiculos.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        lblVehiculos.setForeground(new java.awt.Color(253, 255, 254));
        lblVehiculos.setText("PERSONAL");
        panelRound1.add(lblVehiculos, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        PanelTabla.setHorizontalScrollBar(null);
        PanelTabla.setVerifyInputWhenFocusTarget(false);
        PanelTabla.setVerticalScrollBar(ScrollTabla);
        PanelTabla.setWheelScrollingEnabled(false);

        tbPersonal_Contactos.setBackground(new java.awt.Color(231, 234, 239));
        tbPersonal_Contactos.setModel(new javax.swing.table.DefaultTableModel(
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
                "CARNET", "NOMBRES", "APELLIDOS", "CORREO", "TIPO USUARIO", "ACCIONES"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPersonal_Contactos.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tbPersonal_Contactos.setGridColor(new java.awt.Color(58, 50, 75));
        tbPersonal_Contactos.setName(""); // NOI18N
        tbPersonal_Contactos.setSelectionBackground(new java.awt.Color(58, 50, 75));
        tbPersonal_Contactos.setShowVerticalLines(false);
        tbPersonal_Contactos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPersonal_ContactosMouseClicked(evt);
            }
        });
        PanelTabla.setViewportView(tbPersonal_Contactos);

        panelRound1.add(PanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1020, 460));

        ScrollTabla.setBackground(new java.awt.Color(58, 50, 75));
        ScrollTabla.setForeground(new java.awt.Color(58, 50, 75));
        panelRound1.add(ScrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 80, 10, 40));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    FrmAgg_Contacto add = new FrmAgg_Contacto();

    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        this.dispose();
        add.dispose();
        PanelOpcionesPersonal.showinter = 0;
    }//GEN-LAST:event_btnCerrarMousePressed

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void tbPersonal_ContactosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPersonal_ContactosMouseClicked
        // TODO add your handling code here:
        int column = tbPersonal_Contactos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbPersonal_Contactos.getRowHeight();
        btnAgregar.setName("btnAgregar");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            ValidacionesSistema.Parametros_Contactos.setIdpersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
        }
        if (row < tbPersonal_Contactos.getRowCount() || row >= 0 || column < tbPersonal_Contactos.getColumnCount() || column >= 0) {
            Object vals = tbPersonal_Contactos.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnAgregar")) {
                    FrmAgg_Contacto frmAgg_Contacto = new FrmAgg_Contacto();
                    frmAgg_Contacto.setVisible(true);
                    this.dispose();
                    //Actualizar Contacto metodo
                }
            }
        }
    }//GEN-LAST:event_tbPersonal_ContactosMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPersonal_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPersonal_Contacto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane PanelTabla;
    private Controles_Personalizados.ScrollBar.ScrollBarCustom ScrollTabla;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel lblVehiculos;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.Tables.Table tbPersonal_Contactos;
    // End of variables declaration//GEN-END:variables
}
