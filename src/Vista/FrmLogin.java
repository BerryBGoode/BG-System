/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerLogin;
import com.sun.awt.AWTUtilities;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author danlo
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public FrmLogin() {
        initComponents();
        this.setTitle("Login");
        txtContra.setEchoChar('•');
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        this.setIconImage(Logo());
    }

    int nivel = 0;
    public int ID;
    public static String nombre;
    private int estadouser;
    private int capiduser;
    public static String tipo;
    private int intentos;

    /**
     * Metodo para colocar la imagen del logo en la barra de tareas
     *
     * @return
     */
    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    void capestadouser() {
        ControllerLogin cl = new ControllerLogin();
        cl.setUsuario(txtUsuario.getText());
        ResultSet rs = cl.validaruseractive();
        try {
            if (rs.next()) {
                estadouser = rs.getInt("idEstadoUsuario");
                capiduser = rs.getInt("idUsuario");
            }
        } catch (SQLException ex) {
            Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
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
        PanelContenedorCampos = new Controles_Personalizados.Paneles.PanelRound();
        LogoLogin = new javax.swing.JLabel();
        txtUsuario = new Controles_Personalizados.textfields.TextField();
        btnConocerMas = new Controles_Personalizados.Botones.ButtonGradient();
        btnLogin = new Controles_Personalizados.Botones.ButtonGradient();
        lblOlvide = new javax.swing.JLabel();
        textologin = new javax.swing.JLabel();
        txtContra = new Controles_Personalizados.textfields.PasswordField();
        ImagenLogin = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1291, 760));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelFondo.setBackground(new java.awt.Color(42, 36, 56));
        PanelFondo.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelFondo.setRoundBottomLeft(35);
        PanelFondo.setRoundBottomRight(40);
        PanelFondo.setRoundTopLeft(35);
        PanelFondo.setRoundTopRight(40);
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelContenedorCampos.setBackground(new java.awt.Color(254, 254, 254));
        PanelContenedorCampos.setPreferredSize(new java.awt.Dimension(629, 768));
        PanelContenedorCampos.setRoundBottomLeft(35);
        PanelContenedorCampos.setRoundTopLeft(35);
        PanelContenedorCampos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LogoLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/LogoB&GLogin.png"))); // NOI18N
        PanelContenedorCampos.add(LogoLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(254, 254, 254));
        txtUsuario.setForeground(new java.awt.Color(42, 36, 56));
        txtUsuario.setCaretColor(new java.awt.Color(42, 36, 56));
        txtUsuario.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtUsuario.setLabelText("Usuario");
        txtUsuario.setLineColor(new java.awt.Color(42, 36, 56));
        txtUsuario.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        PanelContenedorCampos.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 450, 70));

        btnConocerMas.setBackground(new java.awt.Color(254, 254, 254));
        btnConocerMas.setForeground(new java.awt.Color(42, 36, 56));
        btnConocerMas.setText("Conocer más");
        btnConocerMas.setColor1(new java.awt.Color(239, 239, 239));
        btnConocerMas.setColor2(new java.awt.Color(239, 239, 239));
        btnConocerMas.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnConocerMas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConocerMasActionPerformed(evt);
            }
        });
        PanelContenedorCampos.add(btnConocerMas, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 710, 170, -1));

        btnLogin.setBackground(new java.awt.Color(254, 254, 254));
        btnLogin.setText("Iniciar Sesión ");
        btnLogin.setColor1(new java.awt.Color(42, 36, 56));
        btnLogin.setColor2(new java.awt.Color(58, 50, 75));
        btnLogin.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        PanelContenedorCampos.add(btnLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 320, -1));

        lblOlvide.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Olvidaste tu contraseña_.png"))); // NOI18N
        lblOlvide.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblOlvide.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblOlvideMouseClicked(evt);
            }
        });
        PanelContenedorCampos.add(lblOlvide, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 420, -1, -1));

        textologin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/TextoLogin.png"))); // NOI18N
        PanelContenedorCampos.add(textologin, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 710, -1, -1));

        txtContra.setBackground(new java.awt.Color(254, 254, 254));
        txtContra.setForeground(new java.awt.Color(42, 36, 56));
        txtContra.setCaretColor(new java.awt.Color(42, 36, 56));
        txtContra.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtContra.setLabelText("Contraseña:");
        txtContra.setLineColor(new java.awt.Color(42, 36, 56));
        txtContra.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtContra.setShowAndHide(true);
        txtContra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtContraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtContraKeyTyped(evt);
            }
        });
        PanelContenedorCampos.add(txtContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 450, 70));

        PanelFondo.add(PanelContenedorCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 630, 760));

        ImagenLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Login-amico.png"))); // NOI18N
        PanelFondo.add(ImagenLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 120, -1, -1));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        PanelFondo.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 21, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        PanelFondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1258, 20, -1, -1));

        getContentPane().add(PanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para acceder al sistema (valida el usuario, la contraseña, y los
     * intentos)
     */
    void Login() {

        if (txtUsuario.getText().equals("") || txtContra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Existen campos vacios", "Error de procesamiento", JOptionPane.WARNING_MESSAGE);
        } else {
            ControllerLogin objc = new ControllerLogin();
            String contra = ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra(String.valueOf(txtContra.getPassword()));

            objc.setUsuario(txtUsuario.getText());
            objc.setContraseña(contra);

            //Valida que exista un usuario
            int respuesta0 = objc.validarUsuarioController();

            if (respuesta0 == 1) {
                //Valida estado del usuario
                capestadouser();
                if (estadouser == 2) {
                    //Valida informacion del 
                    int respuesta2 = objc.validarLoginC();

                    ControllerLogin cLogin = new ControllerLogin();
                    ResultSet rs;

                    if (respuesta2 == 1) {
                        //Restablece los intentos a 5
                        objc.setIntentos(5);
                        objc.IntentosController();
                        CargarDatos();
                        if (txtContra.getText().equals(txtUsuario.getText() + "123")) {
                            FrmRestablecimiento frm = new FrmRestablecimiento(nombre);
                            frm.setVisible(true);
                            this.dispose();
                        } else {
                            FrmDashboard frm = new FrmDashboard(nombre, tipo);
                            PanelOpcionesPersonal.showinter = 0;//le doy este valor a este attr que sirve para detectar cual fue el panel que se abrio, entonces 
                            //el valor en un switch que evalua este attr, el valor 0 no reenvía a otro panel
                            frm.setVisible(true);
                            cLogin.setIdestado(1);
                            cLogin.setIdusuario(capiduser);
                            if (cLogin.ActualizarEstado() == true) {
                                System.out.println("Si se actualiza a 1");
                            }
                            this.dispose();
                        }
                    } else {
                        rs = objc.CapturarIntentosController();
                        try {
                            if (rs.next()) {
                                intentos = rs.getInt("intentos");
                            }
                        } catch (SQLException e) {
                            JOptionPane.showMessageDialog(null, "Error al validar las credenciales");
                        }
                        if (intentos > 1) {
                            int intentosf = intentos - 1;
                            objc.setIntentos(intentosf);
                            objc.IntentosController();
                            JOptionPane.showMessageDialog(null, "Credenciales incorrectas, intentos restantes: " + intentosf);
                        } else {
                            objc.BloquearUsuarioController();
                            JOptionPane.showMessageDialog(null, "Usuario bloqueado");
                        }
                    }
                } else if (estadouser == 1) {
                    JOptionPane.showMessageDialog(null, "El usuario esta abierto en otro dispositivo");
                } else if (estadouser == 3) {
                    JOptionPane.showMessageDialog(null, "Usuario bloqueado");
                } 
            }else {
                    JOptionPane.showMessageDialog(null, "Usuario inexistente");
             }
        }
    }

    /**
     * Metodo para activar el inicio de sesión
     *
     * @param evt
     */
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        Login();
    }//GEN-LAST:event_btnLoginActionPerformed

    /**
     * Metodo para cargar los datos del usuario (su nombre de usuario y tipo de
     * usuario)
     */
    void CargarDatos() {
        ControllerLogin objc = new ControllerLogin();
        ResultSet rs;
        objc.setUsuario(txtUsuario.getText());
        rs = objc.CapturarDatosController();
        try {
            if (rs.next()) {
                ID = rs.getInt("idUsuario");
                nombre = rs.getString("nombre_usuario");
                tipo = rs.getString("tipo_usuario");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    /**
     * Metodo para acceder al form de recuperar contraseña
     *
     * @param evt
     */
    private void lblOlvideMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOlvideMouseClicked
        // TODO add your handling code here:
        MenuRecu rec = new MenuRecu();
        rec.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lblOlvideMouseClicked

    /**
     * Metodo para cerrar la aplicación
     *
     * @param evt
     */
    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMousePressed

    /**
     * Metodo para minimizar la aplicación
     *
     * @param evt
     */
    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    /**
     * Validaciones para el txtUsuario
     *
     * @param evt
     */
    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txtUsuario.getText().equals("") && !txtContra.getText().equals("")) {
            Login();
        } else if (evt.isControlDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    /**
     * Validaciones para el txtUsuario
     *
     * @param evt
     */
    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if (txtUsuario.getText().length() >= 15) {
            evt.consume();
        } else {
            if (txtUsuario.getText().equals("") && car == 95) {
                evt.consume();
            } else if (txtUsuario.getText().contains("_") && car == 95) {
                evt.consume();
            } else {
                ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
                ValidacionesSistema.ValidacionesBeep_Go.SoloLetrasNumerosGuionBajo(evt);
            }
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    /**
     * Validaciones para el txtContra
     *
     * @param evt
     */
    private void txtContraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER && !txtUsuario.getText().equals("") && !txtContra.getText().equals("")) {
            Login();
        } else if (evt.isControlDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtContraKeyPressed

    /**
     * Validaciones para el txtContra
     *
     * @param evt
     */
    private void txtContraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtContraKeyTyped
        // TODO add your handling code here:
        if (txtContra.getText().length() >= 30) {
            evt.consume();
        } else {
            ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
        }
    }//GEN-LAST:event_txtContraKeyTyped

    /**
     * Metodo para abrir el google sites con más información del sistema
     *
     * @param evt
     */
    private void btnConocerMasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConocerMasActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://beep-go-system.netlify.app/"));
            this.setExtendedState(JFrame.ICONIFIED);
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Minimizado", "El sistema ha sido minimizado para tu comodidad, puedes abrirlo de nuevo desde tu barra de tareas", 1);
        } catch (URISyntaxException ex) {
            JOptionPane.showMessageDialog(this, ex);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_btnConocerMasActionPerformed

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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenLogin;
    private javax.swing.JLabel LogoLogin;
    private Controles_Personalizados.Paneles.PanelRound PanelContenedorCampos;
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private javax.swing.JLabel btnCerrar;
    private Controles_Personalizados.Botones.ButtonGradient btnConocerMas;
    private Controles_Personalizados.Botones.ButtonGradient btnLogin;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel lblOlvide;
    private javax.swing.JLabel textologin;
    private Controles_Personalizados.textfields.PasswordField txtContra;
    private Controles_Personalizados.textfields.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
