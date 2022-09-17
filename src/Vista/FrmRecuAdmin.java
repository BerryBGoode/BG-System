/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerLogin;
import Controlador.ControllerRecuperacionContra;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author rocyr
 */
public class FrmRecuAdmin extends javax.swing.JFrame {

    /**
     * Creates new form FrmRecuAdmin
     */
    DefaultComboBoxModel<String> modelocombo;
    private List myArrayListTD;
    int idTipoDoc;
    String nombre = FrmLogin.nombre;
    String tipo = FrmLogin.tipo;
    ControllerRecuperacionContra obj = new ControllerRecuperacionContra();
    
    public FrmRecuAdmin() {
        initComponents();
        txtAdmin.setText(nombre);
        txtTipoUsu.setText(tipo);
        if(ValidacionesSistema.Parametros_Usuario.getNombre_usuario() != null){
            txtUsuario.setText(ValidacionesSistema.Parametros_Usuario.getNombre_usuario());
        }
        txtAdmin.setEditable(false);
        txtTipoUsu.setEditable(false);
        txtUsuario.setEditable(false);
        this.setTitle("Recuperar contraseña");
        CargarTipoDoc();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());
    }
    
    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    final void CargarTipoDoc() {
        ControllerRecuperacionContra objc = new ControllerRecuperacionContra();
        myArrayListTD = new ArrayList();
        try {
            ResultSet rs = objc.CargarTipoDocumentoController();
            if (rs.next()) {
                modelocombo = new DefaultComboBoxModel<>();
                modelocombo.addElement("");
                do {
                    myArrayListTD.add(rs.getInt("idTipoDocumento"));
                    modelocombo.addElement(rs.getString("tipo_documento"));
                    cmbTipo.setModel(modelocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No existen tipos de documento por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se han podido cargar los datos, favor consulta con el administrador del sistema", "Error critico", JOptionPane.ERROR_MESSAGE);
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
        txtTipoUsu = new Controles_Personalizados.textfields.TextField();
        btnContinuar = new Controles_Personalizados.Botones.ButtonGradient();
        jLabel1 = new javax.swing.JLabel();
        cmbTipo = new Controles_Personalizados.ComboBox.combobox();
        txtDoc = new Controles_Personalizados.textfields.TextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtUsuario = new Controles_Personalizados.textfields.TextField();
        txtAdmin = new Controles_Personalizados.textfields.TextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(58, 50, 75));
        setUndecorated(true);

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
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

        txtTipoUsu.setBackground(new java.awt.Color(58, 50, 75));
        txtTipoUsu.setForeground(new java.awt.Color(254, 254, 254));
        txtTipoUsu.setCaretColor(new java.awt.Color(253, 255, 254));
        txtTipoUsu.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtTipoUsu.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtTipoUsu.setLabelText("Tipo - usuario");
        txtTipoUsu.setLineColor(new java.awt.Color(253, 255, 254));
        txtTipoUsu.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtTipoUsu.setSelectionColor(new java.awt.Color(253, 255, 254));
        panelRound1.add(txtTipoUsu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 370, 70));

        btnContinuar.setBackground(new java.awt.Color(253, 255, 254));
        btnContinuar.setForeground(new java.awt.Color(58, 50, 75));
        btnContinuar.setText("Continuar");
        btnContinuar.setColor1(new java.awt.Color(253, 255, 254));
        btnContinuar.setColor2(new java.awt.Color(253, 255, 254));
        btnContinuar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        panelRound1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 500, 150, -1));

        jLabel1.setBackground(new java.awt.Color(51, 255, 51));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/RecuContraAdmin.png"))); // NOI18N
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 80, 490, 390));

        cmbTipo.setBackground(new java.awt.Color(58, 50, 75));
        cmbTipo.setForeground(new java.awt.Color(253, 255, 254));
        cmbTipo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        cmbTipo.setLabeText("Tipo - Documento");
        cmbTipo.setLineColor(new java.awt.Color(253, 255, 254));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });
        cmbTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTipoActionPerformed(evt);
            }
        });
        panelRound1.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 420, 190, 80));

        txtDoc.setBackground(new java.awt.Color(58, 50, 75));
        txtDoc.setForeground(new java.awt.Color(254, 254, 254));
        txtDoc.setCaretColor(new java.awt.Color(253, 255, 254));
        txtDoc.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtDoc.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtDoc.setLabelText("Documento");
        txtDoc.setLineColor(new java.awt.Color(253, 255, 254));
        txtDoc.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtDoc.setSelectionColor(new java.awt.Color(253, 255, 254));
        txtDoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocKeyTyped(evt);
            }
        });
        panelRound1.add(txtDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 430, 260, 70));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Usuario a recuperar:");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/user70px.png"))); // NOI18N
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario administrador:");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/user70px.png"))); // NOI18N
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(58, 50, 75));
        txtUsuario.setForeground(new java.awt.Color(254, 254, 254));
        txtUsuario.setCaretColor(new java.awt.Color(253, 255, 254));
        txtUsuario.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtUsuario.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtUsuario.setLabelText("Usuario a recuperar");
        txtUsuario.setLineColor(new java.awt.Color(253, 255, 254));
        txtUsuario.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtUsuario.setSelectionColor(new java.awt.Color(253, 255, 254));
        panelRound1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 330, 370, 70));

        txtAdmin.setBackground(new java.awt.Color(58, 50, 75));
        txtAdmin.setForeground(new java.awt.Color(254, 254, 254));
        txtAdmin.setCaretColor(new java.awt.Color(253, 255, 254));
        txtAdmin.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtAdmin.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtAdmin.setLabelText("Usuario - administrador");
        txtAdmin.setLineColor(new java.awt.Color(253, 255, 254));
        txtAdmin.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtAdmin.setSelectionColor(new java.awt.Color(253, 255, 254));
        txtAdmin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAdminKeyTyped(evt);
            }
        });
        panelRound1.add(txtAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 370, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 1100, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(this.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        this.dispose();
        PanelOpcionesPersonal.showinter = 0;
    }//GEN-LAST:event_btnCerrarMousePressed

    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        if(txtDoc.getText().equals("") || cmbTipo.getSelectedIndex() == 0){
            JOptionPane.showMessageDialog(this, "Campos vacios");
        }else{
            obj.setUsuario(txtUsuario.getText());
            obj.setDocumento(txtDoc.getText());
            obj.setIdTipoDoc(idTipoDoc);
            int respuesta = obj.ValidarDocumentoController();
            if(respuesta == 1){
                obj.setContra(ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra(txtUsuario.getText()+"123"));
                boolean respuesta2 = obj.RecuperarContraController();
                if(respuesta2 == true){
                    ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado", "La contraseña ha sido actualizada", 1);
                    this.dispose();
                }else{
                    ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso fallido", "La contraseña no pudo ser actualizada", 3);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
            }
        }
        PanelOpcionesPersonal.showinter = 0;
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        // TODO add your handling code here:
        txtDoc.setText("");
         if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = cmbTipo.getSelectedIndex();
            if (pos == 0) {
                idTipoDoc = 0;
            } else {
                int dim = myArrayListTD.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        idTipoDoc = (int) myArrayListTD.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_cmbTipoItemStateChanged

    private void txtAdminKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAdminKeyTyped
        // TODO add your handling code here:
        evt.consume();
    }//GEN-LAST:event_txtAdminKeyTyped

    private void cmbTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoActionPerformed

    private void txtDocKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        ValidacionesSistema.ValidacionesBeep_Go.SoloNumeros(evt);
    }//GEN-LAST:event_txtDocKeyTyped

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
            java.util.logging.Logger.getLogger(FrmRecuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRecuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRecuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRecuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRecuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private Controles_Personalizados.Botones.ButtonGradient btnContinuar;
    private javax.swing.JLabel btnMinimizar;
    private Controles_Personalizados.ComboBox.combobox cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.textfields.TextField txtAdmin;
    private Controles_Personalizados.textfields.TextField txtDoc;
    private Controles_Personalizados.textfields.TextField txtTipoUsu;
    private Controles_Personalizados.textfields.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
