/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerP_U_Usuarios;
import Controlador.ControllerRecuperacionContra;
import java.util.HashSet;
import java.util.Objects;
import javax.swing.JOptionPane;

/**
 *
 * @author danlo
 */
public class PanelAjustes extends javax.swing.JPanel {

    /**
     * Creates new form PanelAjustes
     */
    
        public String user;


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public PanelAjustes(String usuario) {
        initComponents();
        user = usuario;
        txtUsuario.setText(usuario);
    }
    
        void CambiarClave() {
        if (Objects.equals(txtClveNueva.getText(), txtConfirmarClave.getText())) {
            ControllerP_U_Usuarios cc = new ControllerP_U_Usuarios();
            cc.setUsuario(user);
            cc.setClave(ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra(txtConfirmarClave.getText()));
            if (cc.CambiandoClave() == true) {
                JOptionPane.showMessageDialog(null, "Su contraseña ha sido agregada, el sistema cerrara  para \nque pueda iniciar desde el login con sus nuevas credenciales");
                System.exit(0);
               
            } else {
                JOptionPane.showMessageDialog(null, "Error al realizar el proceso");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Las claves ingresadas deden de ser las mismas", "Contraseña incorrecta", JOptionPane.WARNING_MESSAGE);

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
        PanelContenedorCambioContra = new Controles_Personalizados.Paneles.PanelRound();
        txtUsuario = new Controles_Personalizados.textfields.TextField();
        lblCambioClave = new javax.swing.JLabel();
        imgCambio = new javax.swing.JLabel();
        btnCambio = new Controles_Personalizados.Botones.UWPButton();
        txtConfirmarClave = new Controles_Personalizados.textfields.PasswordField();
        txtClveNueva = new Controles_Personalizados.textfields.PasswordField();
        PanelContenedorIdiomas = new Controles_Personalizados.Paneles.PanelRound();
        lblIdiomas = new javax.swing.JLabel();
        panelRound5 = new Controles_Personalizados.Paneles.PanelRound();
        lblAjustes = new javax.swing.JLabel();
        PanelContenedorConfiguracion = new Controles_Personalizados.Paneles.PanelRound();
        textoConfig = new javax.swing.JLabel();
        VerificarTipo = new Controles_Personalizados.Botones.UWPButton();
        PanelContenedorTemas = new Controles_Personalizados.Paneles.PanelRound();
        lblTemas = new javax.swing.JLabel();
        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        panelRound2 = new Controles_Personalizados.Paneles.PanelRound();

        setBackground(new java.awt.Color(42, 36, 56));
        setPreferredSize(new java.awt.Dimension(1250, 620));
        setLayout(new java.awt.BorderLayout());

        PanelFondo.setBackground(new java.awt.Color(231, 234, 239));
        PanelFondo.setFont(new java.awt.Font("Roboto", 0, 18)); // NOI18N
        PanelFondo.setPreferredSize(new java.awt.Dimension(1270, 620));
        PanelFondo.setRoundBottomLeft(20);
        PanelFondo.setRoundBottomRight(20);
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelContenedorCambioContra.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorCambioContra.setRoundBottomLeft(30);
        PanelContenedorCambioContra.setRoundBottomRight(30);
        PanelContenedorCambioContra.setRoundTopLeft(30);
        PanelContenedorCambioContra.setRoundTopRight(30);
        PanelContenedorCambioContra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtUsuario.setEditable(false);
        txtUsuario.setBackground(new java.awt.Color(42, 36, 56));
        txtUsuario.setForeground(new java.awt.Color(231, 234, 239));
        txtUsuario.setCaretColor(new java.awt.Color(231, 234, 239));
        txtUsuario.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtUsuario.setLabelText("Usuario");
        txtUsuario.setLineColor(new java.awt.Color(231, 234, 239));
        txtUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtUsuarioActionPerformed(evt);
            }
        });
        PanelContenedorCambioContra.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 180, 70));

        lblCambioClave.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblCambioClave.setForeground(new java.awt.Color(231, 234, 239));
        lblCambioClave.setText("Cambio de contraseña");
        PanelContenedorCambioContra.add(lblCambioClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        imgCambio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/reset-adentrosystem.png"))); // NOI18N
        PanelContenedorCambioContra.add(imgCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, -1, -1));

        btnCambio.setBackground(new java.awt.Color(42, 36, 56));
        btnCambio.setText("Confirmar Cambio");
        btnCambio.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambioActionPerformed(evt);
            }
        });
        PanelContenedorCambioContra.add(btnCambio, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 245, 140, 40));

        txtConfirmarClave.setBackground(new java.awt.Color(42, 36, 56));
        txtConfirmarClave.setForeground(new java.awt.Color(231, 234, 239));
        txtConfirmarClave.setCaretColor(new java.awt.Color(231, 234, 239));
        txtConfirmarClave.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtConfirmarClave.setLabelText("Confirmar Contraseña");
        txtConfirmarClave.setLineColor(new java.awt.Color(231, 234, 239));
        txtConfirmarClave.setPreferredSize(new java.awt.Dimension(45, 6));
        txtConfirmarClave.setShowAndHide(true);
        txtConfirmarClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtConfirmarClaveActionPerformed(evt);
            }
        });
        PanelContenedorCambioContra.add(txtConfirmarClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 180, 70));

        txtClveNueva.setBackground(new java.awt.Color(42, 36, 56));
        txtClveNueva.setForeground(new java.awt.Color(231, 234, 239));
        txtClveNueva.setCaretColor(new java.awt.Color(231, 234, 239));
        txtClveNueva.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        txtClveNueva.setLabelText("Contraseña Nueva");
        txtClveNueva.setLineColor(new java.awt.Color(231, 234, 239));
        txtClveNueva.setPreferredSize(new java.awt.Dimension(45, 6));
        txtClveNueva.setShowAndHide(true);
        txtClveNueva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtClveNuevaActionPerformed(evt);
            }
        });
        PanelContenedorCambioContra.add(txtClveNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 180, 70));

        PanelFondo.add(PanelContenedorCambioContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 310, 460, 300));

        PanelContenedorIdiomas.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorIdiomas.setRoundBottomLeft(30);
        PanelContenedorIdiomas.setRoundBottomRight(30);
        PanelContenedorIdiomas.setRoundTopLeft(30);
        PanelContenedorIdiomas.setRoundTopRight(30);
        PanelContenedorIdiomas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblIdiomas.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblIdiomas.setForeground(new java.awt.Color(231, 234, 239));
        lblIdiomas.setText("Idiomas - Beep&Go");
        PanelContenedorIdiomas.add(lblIdiomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelRound5.setBackground(new java.awt.Color(58, 50, 75));
        panelRound5.setRoundBottomLeft(30);
        panelRound5.setRoundBottomRight(30);
        panelRound5.setRoundTopLeft(30);
        panelRound5.setRoundTopRight(30);

        javax.swing.GroupLayout panelRound5Layout = new javax.swing.GroupLayout(panelRound5);
        panelRound5.setLayout(panelRound5Layout);
        panelRound5Layout.setHorizontalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        panelRound5Layout.setVerticalGroup(
            panelRound5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        PanelContenedorIdiomas.add(panelRound5, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        PanelFondo.add(PanelContenedorIdiomas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 750, 300));

        lblAjustes.setFont(new java.awt.Font("Roboto Medium", 0, 40)); // NOI18N
        lblAjustes.setForeground(new java.awt.Color(58, 50, 75));
        lblAjustes.setText("Ajustes");
        PanelFondo.add(lblAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        PanelContenedorConfiguracion.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorConfiguracion.setRoundBottomLeft(30);
        PanelContenedorConfiguracion.setRoundBottomRight(30);
        PanelContenedorConfiguracion.setRoundTopLeft(30);
        PanelContenedorConfiguracion.setRoundTopRight(30);
        PanelContenedorConfiguracion.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoConfig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Indicacion Config.png"))); // NOI18N
        PanelContenedorConfiguracion.add(textoConfig, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, -1, -1));

        VerificarTipo.setBackground(new java.awt.Color(42, 36, 56));
        VerificarTipo.setText("Verificar mi usuario");
        VerificarTipo.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        VerificarTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VerificarTipoActionPerformed(evt);
            }
        });
        PanelContenedorConfiguracion.add(VerificarTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 170, 50));

        PanelFondo.add(PanelContenedorConfiguracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 70, 460, 230));

        PanelContenedorTemas.setBackground(new java.awt.Color(42, 36, 56));
        PanelContenedorTemas.setRoundBottomLeft(30);
        PanelContenedorTemas.setRoundBottomRight(30);
        PanelContenedorTemas.setRoundTopLeft(30);
        PanelContenedorTemas.setRoundTopRight(30);
        PanelContenedorTemas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTemas.setFont(new java.awt.Font("Roboto Medium", 0, 18)); // NOI18N
        lblTemas.setForeground(new java.awt.Color(231, 234, 239));
        lblTemas.setText("Temas - Beep&Go");
        PanelContenedorTemas.add(lblTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        PanelContenedorTemas.add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 330, 160));

        panelRound2.setBackground(new java.awt.Color(58, 50, 75));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);

        javax.swing.GroupLayout panelRound2Layout = new javax.swing.GroupLayout(panelRound2);
        panelRound2.setLayout(panelRound2Layout);
        panelRound2Layout.setHorizontalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );
        panelRound2Layout.setVerticalGroup(
            panelRound2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );

        PanelContenedorTemas.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, 330, 160));

        PanelFondo.add(PanelContenedorTemas, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 750, 230));

        add(PanelFondo, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    public static int exitdash = 0;

    public static int getExitdash() {
        return exitdash;
    }
    
    //FrmDashboard dash = new FrmDashboard();
    FrmLogin login = new FrmLogin();
    

    
    private void VerificarTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VerificarTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_VerificarTipoActionPerformed

    private void btnCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambioActionPerformed
        // TODO add your handling code here
        CambiarClave();
    }//GEN-LAST:event_btnCambioActionPerformed

    private void txtUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtUsuarioActionPerformed

    private void txtClveNuevaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtClveNuevaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtClveNuevaActionPerformed

    private void txtConfirmarClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtConfirmarClaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtConfirmarClaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorCambioContra;
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorConfiguracion;
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorIdiomas;
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorTemas;
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private Controles_Personalizados.Botones.UWPButton VerificarTipo;
    private Controles_Personalizados.Botones.UWPButton btnCambio;
    private javax.swing.JLabel imgCambio;
    private javax.swing.JLabel lblAjustes;
    private javax.swing.JLabel lblCambioClave;
    private javax.swing.JLabel lblIdiomas;
    private javax.swing.JLabel lblTemas;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.Paneles.PanelRound panelRound2;
    private Controles_Personalizados.Paneles.PanelRound panelRound5;
    private javax.swing.JLabel textoConfig;
    private Controles_Personalizados.textfields.PasswordField txtClveNueva;
    private Controles_Personalizados.textfields.PasswordField txtConfirmarClave;
    private Controles_Personalizados.textfields.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
