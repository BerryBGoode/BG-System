/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerContactos;
import ValidacionesSistema.Parametros_Personal;
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
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class FrmAgg_Contacto extends javax.swing.JFrame {

    /**
     * Creates new form FrmAgg_Contacto
     */
    private static int pidcontacto;
    private String contacto;
    private static int personal;
    private static int tipocontacto;
    private static List Ltipocontacto;
    String combo_text = "Seleccione el tipo contacto";
    DefaultComboBoxModel modelcombo = new DefaultComboBoxModel<>();

    public FrmAgg_Contacto(int idcontacto) {
        initComponents();
        pidcontacto = idcontacto;
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());

        btnConfirmar.setVisible(true);
        btnConfirmar_C.setVisible(false);

        CargarTipoC();
        txtContacto.setText(ValidacionesSistema.Parametros_Contactos.getContacto());
        txtIDPersonal.setText(String.valueOf(ValidacionesSistema.Parametros_Contactos.getIdpersonal()));
        personal=ValidacionesSistema.Parametros_Contactos.getIdpersonal();
        System.out.println(personal);
        System.out.println(ValidacionesSistema.Parametros_Contactos.getIdpersonal());
        cmbtipoc.setSelectedItem(ValidacionesSistema.Parametros_Contactos.getTipocontacto());
        System.out.println(cmbtipoc.getSelectedItem());
        txtID.setVisible(false);
        txtIDPersonal.setVisible(true);
        txtID.setEditable(false);
        txtIDPersonal.setEditable(false);
    }

    FrmAgg_Contacto() {
        initComponents();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());
        btnConfirmar.setVisible(false);
        btnConfirmar_C.setVisible(true);

        CargarTipoC();

        txtID.setVisible(false);
        txtIDPersonal.setVisible(false);
        txtID.setText(String.valueOf(ValidacionesSistema.Parametros_Contactos.getIdpersonal()));
    }

    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    final void CargarTipoC() {
        Ltipocontacto = new ArrayList();
        try {
            ResultSet rs = ControllerContactos.CargarCMBTipoContactos_Controller();
            if (rs.next()) {
                modelcombo = new DefaultComboBoxModel<>();
                modelcombo.addElement(combo_text);
                do {
                    Ltipocontacto.add(rs.getInt("idTipoContacto"));
                    modelcombo.addElement(rs.getString("tipo_contacto"));
                    cmbtipoc.setModel(modelcombo);
                } while (rs.next());
            } else {
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al cargar datos", "No se han podido cargar datos en la lista Tipo Contactos", 3);
            }
        } catch (Exception e) {

        }
    }

    void capIDPersonal_tbContactos() {
        ControllerContactos.contacto=txtContacto.getText();
        try {
            ResultSet rs = ControllerContactos.getidPersonal();
            if (rs.next()) {
                personal = rs.getInt("idPersonal");
            }

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos del personal", "Error", JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    // falta caputrar el id de la tabla
    final void RegistrarContacto() {
        if (txtContacto.getText().trim().isEmpty() || cmbtipoc.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(null, "Existen campos vacios, favor llenar los campos", "Campos vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            ControllerContactos.contacto = txtContacto.getText();
            ControllerContactos.idtipocontacto = tipocontacto;
            ControllerContactos.idpersonal = Integer.parseInt(txtID.getText());
            //            capIDPersonal_tbPersonal();
            boolean a = ControllerContactos.RegistrarContactos_Controller();
            if (a == true) {
                JOptionPane.showMessageDialog(null, "Registrado con exito");
            } else {
                JOptionPane.showMessageDialog(null, "No pudo ser registrado");
            }
        }
    }

    final void ActualizarContacto() {
        ControllerContactos.idcontacto = pidcontacto;
        ControllerContactos.contacto = txtContacto.getText();
        ControllerContactos.idtipocontacto = tipocontacto;
        ControllerContactos.idpersonal = personal;
        System.out.println(personal);
        boolean a = ControllerContactos.ActualizarContactos_Controller();
        if (a == true) {
            //            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso de actualizacion", "Contacto actualizado con exito", 1);
            JOptionPane.showMessageDialog(null, "Actualizado con exito");
        } else {
            //            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso de actualizacion", "Contacto no fue actualizado", 2);
            JOptionPane.showMessageDialog(null, "No se pudo actualizar");
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
        txtContacto = new Controles_Personalizados.textfields.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnConfirmar = new Controles_Personalizados.Botones.ButtonGradient();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        cmbtipoc = new Controles_Personalizados.ComboBox.combobox();
        txtIDPersonal = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        btnConfirmar_C = new Controles_Personalizados.Botones.ButtonGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtContacto.setBackground(new java.awt.Color(58, 50, 75));
        txtContacto.setForeground(new java.awt.Color(253, 255, 254));
        txtContacto.setCaretColor(new java.awt.Color(253, 255, 254));
        txtContacto.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtContacto.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtContacto.setLabelText("Contacto");
        txtContacto.setLineColor(new java.awt.Color(253, 255, 254));
        txtContacto.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtContacto.setSelectionColor(new java.awt.Color(253, 255, 254));
        txtContacto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContactoKeyTyped(evt);
            }
        });
        panelRound1.add(txtContacto, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 330, 310, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Mobile-amico.png"))); // NOI18N
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, -1, -1));

        btnConfirmar.setBackground(new java.awt.Color(42, 36, 56));
        btnConfirmar.setForeground(new java.awt.Color(58, 50, 75));
        btnConfirmar.setText("Continuar");
        btnConfirmar.setColor1(new java.awt.Color(253, 255, 254));
        btnConfirmar.setColor2(new java.awt.Color(253, 255, 254));
        btnConfirmar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });
        panelRound1.add(btnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, 150, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        panelRound1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, -1));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        panelRound1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        cmbtipoc.setBackground(new java.awt.Color(58, 50, 75));
        cmbtipoc.setForeground(new java.awt.Color(253, 255, 254));
        cmbtipoc.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        cmbtipoc.setLabeText("Tipo - contacto");
        cmbtipoc.setLineColor(new java.awt.Color(253, 255, 254));
        cmbtipoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbtipocItemStateChanged(evt);
            }
        });
        panelRound1.add(cmbtipoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 310, 80));
        panelRound1.add(txtIDPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 60, -1, -1));
        panelRound1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 50, 30, -1));

        btnConfirmar_C.setForeground(new java.awt.Color(58, 50, 75));
        btnConfirmar_C.setText("Continuar");
        btnConfirmar_C.setColor1(new java.awt.Color(253, 255, 254));
        btnConfirmar_C.setColor2(new java.awt.Color(253, 255, 254));
        btnConfirmar_C.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnConfirmar_C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmar_CActionPerformed(evt);
            }
        });
        panelRound1.add(btnConfirmar_C, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 510, 150, 44));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        // TODO add your handling code here:
        ActualizarContacto();
        this.dispose();
        PanelOpcionesPersonal.showinter = 0;
    }//GEN-LAST:event_btnConfirmarActionPerformed

    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        PanelOpcionesPersonal.showinter = 0;
        this.dispose();
    }//GEN-LAST:event_btnCerrarMousePressed

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnConfirmar_CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmar_CActionPerformed
        // TODO add your handling code here:
        RegistrarContacto();
        this.dispose();
    }//GEN-LAST:event_btnConfirmar_CActionPerformed

    private void cmbtipocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbtipocItemStateChanged
        // TODO add your handling code here:
        txtContacto.setText("");
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = cmbtipoc.getSelectedIndex();
            if (pos == 0) {
                tipocontacto = 0;
            } else {
                int dim = Ltipocontacto.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        tipocontacto = (int) Ltipocontacto.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_cmbtipocItemStateChanged

    private void txtContactoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContactoKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(tipocontacto == 1){
            if(txtContacto.getText().length() >= 9){
                evt.consume();
            }else if(txtContacto.getText().length() == 4 && key != '-'){
                evt.consume();
            }
            else if(txtContacto.getText().contains("-") && key == '-'){
                evt.consume();
            }else{
                if(! Character.isDigit(key) && key != '-'){
                    evt.consume();
                }
            }
        }else if(tipocontacto == 2){
            if(txtContacto.getText().length() >= 9){
                evt.consume();
            }else{
                ValidacionesSistema.ValidacionesBeep_Go.SoloNumeros(evt);
            }
        }
    }//GEN-LAST:event_txtContactoKeyTyped

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
            java.util.logging.Logger.getLogger(FrmAgg_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Contacto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgg_Contacto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private Controles_Personalizados.Botones.ButtonGradient btnConfirmar;
    private Controles_Personalizados.Botones.ButtonGradient btnConfirmar_C;
    private javax.swing.JLabel btnMinimizar;
    private Controles_Personalizados.ComboBox.combobox cmbtipoc;
    private javax.swing.JLabel jLabel1;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.textfields.TextField txtContacto;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtIDPersonal;
    // End of variables declaration//GEN-END:variables
}
