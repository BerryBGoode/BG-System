/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerVehiculos;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.RenderTable;
import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ferna
 */
public class FrmPersonal_AggVehiculo extends javax.swing.JFrame {

    DefaultTableModel model;
    ResultSet rs;
    
    public FrmPersonal_AggVehiculo() {
        initComponents();
        setLocationRelativeTo(null);
        Shape forma= new RoundRectangle2D.Double(0,0, this.getBounds() .width, this.getBounds() .height,40,40);
        AWTUtilities. setWindowShape(this, forma);
        setIconImage(Logo());
        
        String[] header = {"ID","Personal","Documento","Tipo documento","Tipo personal","Carnet","Agregar"};
        model = new DefaultTableModel(null, header){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        tbVehiculos_Personal.setDefaultRenderer(Object.class, new RenderTable());
        
        CargarTablaVehiculos();
    }
public Image Logo(){
    Image retvalue=Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
    return retvalue;
}

    UWPButton btnAgregar = new UWPButton();
    ImageIcon agregar = new ImageIcon(getClass().getResource("/Recursos_Proyecto/Agregar.png"));
    
    final void CargarTablaVehiculos() {
        
        tbVehiculos_Personal.setModel(model);
        
        while(model.getRowCount() > 0) {
            model.removeRow(0);
        }
        try {
            rs = ControllerVehiculos.CargarTabla_Personal();
            while(rs.next()) {
                btnAgregar.setIcon(agregar);
                btnAgregar.setBackground(new Color(231, 234, 239));
                Object[] oValues = {rs.getInt("idPersonal"), rs.getString("Personal"), rs.getString("documento"), rs.getString("tipo_documento"), rs.getString("tipo_personal"), rs.getString("Carnet"), btnAgregar};
                model.addRow(oValues);
            }
        } catch(Exception e){
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
        tbVehiculos_Personal = new Controles_Personalizados.Tables.Table();
        ScrollTabla = new Controles_Personalizados.ScrollBar.ScrollBarCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1099, 578));
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
        PanelTabla.setVerticalScrollBar(ScrollTabla);
        PanelTabla.setWheelScrollingEnabled(false);

        tbVehiculos_Personal.setBackground(new java.awt.Color(231, 234, 239));
        tbVehiculos_Personal.setModel(new javax.swing.table.DefaultTableModel(
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
        tbVehiculos_Personal.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        tbVehiculos_Personal.setGridColor(new java.awt.Color(58, 50, 75));
        tbVehiculos_Personal.setName(""); // NOI18N
        tbVehiculos_Personal.setSelectionBackground(new java.awt.Color(58, 50, 75));
        tbVehiculos_Personal.setShowVerticalLines(false);
        tbVehiculos_Personal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbVehiculos_PersonalMouseClicked(evt);
            }
        });
        PanelTabla.setViewportView(tbVehiculos_Personal);

        panelRound1.add(PanelTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 1020, 460));

        ScrollTabla.setBackground(new java.awt.Color(58, 50, 75));
        ScrollTabla.setForeground(new java.awt.Color(58, 50, 75));
        panelRound1.add(ScrollTabla, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 80, 10, 40));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    FrmAgg_Vehiculos add = new FrmAgg_Vehiculos();
    
    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        this.dispose();
        add.dispose();
    }//GEN-LAST:event_btnCerrarMousePressed

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
        
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void tbVehiculos_PersonalMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbVehiculos_PersonalMouseClicked
        int column = tbVehiculos_Personal.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY() / tbVehiculos_Personal.getRowHeight();
        btnAgregar.setName("btnAgregar");
        if (evt.getClickCount() == 1) {
            JTable rcp = (JTable) evt.getSource();
            ValidacionesSistema.Parametros_Vehiculos.setIdPersonal((int) rcp.getModel().getValueAt(rcp.getSelectedRow(), 0));
        }
        if (row < tbVehiculos_Personal.getRowCount() || row >= 0 || column < tbVehiculos_Personal.getColumnCount() || column >= 0) {
            Object vals = tbVehiculos_Personal.getValueAt(row, column);
            if (vals instanceof UWPButton) {
                ((UWPButton) vals).doClick(); // aqui esta
                UWPButton btns = (UWPButton) vals;
                if (btns.getName().equals("btnAgregar")) {
                    FrmAgg_Vehiculos vehiculos = new FrmAgg_Vehiculos();
                    vehiculos.setVisible(true);

                    //Actualizar Contacto metodo
                }
            }
        }
    }//GEN-LAST:event_tbVehiculos_PersonalMouseClicked

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
            java.util.logging.Logger.getLogger(FrmPersonal_AggVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal_AggVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal_AggVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersonal_AggVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPersonal_AggVehiculo().setVisible(true);
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
    private Controles_Personalizados.Tables.Table tbVehiculos_Personal;
    // End of variables declaration//GEN-END:variables
}
