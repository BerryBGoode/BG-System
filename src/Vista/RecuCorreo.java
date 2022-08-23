/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerCorreo;
import Controlador.ControllerP_U_Usuarios;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author danlo
 */
public class RecuCorreo extends javax.swing.JFrame {

    /**
     * Creates new form RecuperacionCorreo
     */
    int pin;
    String Contra;
    int ID;
    String nombreU;
    String correo;
    String validarcorreo;
    int IDCorreo;

    public RecuCorreo() {
        initComponents();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());
    }

    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelImg = new Controles_Personalizados.Paneles.PanelRound();
        PanelCampos = new Controles_Personalizados.Paneles.PanelRound();
        textoRest = new javax.swing.JLabel();
        btnGoBack = new javax.swing.JLabel();
        txtCorreo = new Controles_Personalizados.textfields.TextField();
        txtPIN = new Controles_Personalizados.textfields.TextField();
        btnRestablecer = new Controles_Personalizados.Botones.ButtonGradient();
        btnPIN = new Controles_Personalizados.Botones.ButtonGradient();
        ImagenRecuCorreo = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelImg.setBackground(new java.awt.Color(42, 36, 56));
        PanelImg.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelImg.setRoundBottomLeft(40);
        PanelImg.setRoundBottomRight(40);
        PanelImg.setRoundTopLeft(40);
        PanelImg.setRoundTopRight(40);
        PanelImg.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelCampos.setBackground(new java.awt.Color(254, 254, 254));
        PanelCampos.setPreferredSize(new java.awt.Dimension(698, 768));
        PanelCampos.setRoundBottomLeft(35);
        PanelCampos.setRoundTopLeft(35);
        PanelCampos.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoRest.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/TextoRecuperacionCorreo.png"))); // NOI18N
        PanelCampos.add(textoRest, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 120, -1, -1));

        btnGoBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/bxs-left-arrow-circle 1.png"))); // NOI18N
        btnGoBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGoBackMouseClicked(evt);
            }
        });
        PanelCampos.add(btnGoBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txtCorreo.setBackground(new java.awt.Color(254, 254, 254));
        txtCorreo.setForeground(new java.awt.Color(42, 36, 56));
        txtCorreo.setCaretColor(new java.awt.Color(42, 36, 56));
        txtCorreo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtCorreo.setLabelText("Correo electronico");
        txtCorreo.setLineColor(new java.awt.Color(42, 36, 56));
        txtCorreo.setSelectionColor(new java.awt.Color(58, 50, 75));
        PanelCampos.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 350, 310, 70));

        txtPIN.setBackground(new java.awt.Color(254, 254, 254));
        txtPIN.setForeground(new java.awt.Color(42, 36, 56));
        txtPIN.setToolTipText("");
        txtPIN.setCaretColor(new java.awt.Color(42, 36, 56));
        txtPIN.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtPIN.setLabelText("PIN recibido");
        txtPIN.setLineColor(new java.awt.Color(42, 36, 56));
        txtPIN.setSelectionColor(new java.awt.Color(58, 50, 75));
        PanelCampos.add(txtPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 450, 310, 70));

        btnRestablecer.setText("Restablecer");
        btnRestablecer.setToolTipText("");
        btnRestablecer.setColor1(new java.awt.Color(42, 36, 56));
        btnRestablecer.setColor2(new java.awt.Color(42, 36, 56));
        btnRestablecer.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnRestablecer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRestablecerActionPerformed(evt);
            }
        });
        PanelCampos.add(btnRestablecer, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 300, -1));

        btnPIN.setText("Enviar PIN");
        btnPIN.setToolTipText("");
        btnPIN.setColor1(new java.awt.Color(42, 36, 56));
        btnPIN.setColor2(new java.awt.Color(42, 36, 56));
        btnPIN.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnPIN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPINActionPerformed(evt);
            }
        });
        PanelCampos.add(btnPIN, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 560, 300, -1));

        PanelImg.add(PanelCampos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        ImagenRecuCorreo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CorreoImg.png"))); // NOI18N
        PanelImg.add(ImagenRecuCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 140, -1, -1));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        PanelImg.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 20, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        PanelImg.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 20, -1, -1));

        getContentPane().add(PanelImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    void CapturarID() {
        ControllerCorreo objC = new ControllerCorreo();
        objC.Correo = txtCorreo.getText();
        ResultSet rs = objC.CapId();
        try {
            if (rs.next()) {
                IDCorreo = rs.getInt("idPersonal");
                System.out.println(IDCorreo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

    void CapturarCorreo() {
        ControllerCorreo objC = new ControllerCorreo();
        objC.id = IDCorreo;
        ResultSet rs = objC.ComprobarCorreo();
        try {
            if (rs.next()) {
                validarcorreo = rs.getString("correo");
                System.out.println(validarcorreo);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    private void btnGoBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGoBackMouseClicked
        // TODO add your handling code here:
        MenuRecu men = new MenuRecu();
        men.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnGoBackMouseClicked

    final void Proceso_Enviado() {
        ControllerCorreo cc = new ControllerCorreo();
        CapturarID();
        CapturarCorreo();
        if (validarcorreo.equals(txtCorreo.getText())) {
            try {

                try {
                    ResultSet res = cc.Recuperar();
                    while (res.next()) {
                        ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Procesando Solicitud", "Espere un momento", 1);
                    }
                } catch (SQLException e) {
                    ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al enviar correo", "Ha ocurrido un error al momento de enviar el correo electronico, vuelva a intentarlo", 1);
                }

                Properties p = new Properties();
                p.setProperty("mail.smtp.host", "smtp.gmail.com");
                p.setProperty("mail.smtp.starttls.enable", "true");
                p.setProperty("mail.smtp.port", "587");
                p.setProperty("mail.smtp.auth", "true");

                Session ses = Session.getDefaultInstance(p);

                Random random = new Random();
                pin = random.nextInt(9999 + 1000) + 1000;

                String correoRemitente = "soportebeepgo@gmail.com";
                String contraRemitente = "dxebkxolinjdimjw";
                String correoRes = txtCorreo.getText();
                String asunto = "Restablecimiento de contraseña";
                String mensaje = "<table style=\"max-width: 600px; padding: 10px; margin:0 auto; border-collapse: collapse;\">\n"
                        + "  <tr>\n"
                        + "    <td style=\"background-color: #FAFAFA; text-align: left; padding: 0\">\n"
                        + "      \n"
                        + "        <center><img width=\"20%\" style=\"display:block; margin: 1.5% 3%\" src=\"https://i.postimg.cc/ncGVM3Bm/Logo-B-GLogin.png\"></center>        \n"
                        + "      </a>\n"
                        + "    </td>\n"
                        + "  </tr>\n"
                        + "\n"
                        + "  <tr>\n"
                        + "    <td style=\"padding: 0; background-color: #5C5470;\">      \n"
                        + "      <center><img style=\"padding: 0; display: block\" src=\"https://i.postimg.cc/Wb9NMXbJ/Envelope-cuate.png\" width=\"300px\"></center>\n"
                        + "    </td>\n"
                        + "  </tr>\n"
                        + "  \n"
                        + "  <tr>\n"
                        + "    <td style=\"background-color: #FAFAFA\">\n"
                        + "      <div style=\"color: #B3B3B3; margin: 4% 10% 2%; text-align: justify;font-family: sans-serif\">\n"
                        + "        <h2 style=\"color: #352F44; margin: 0 0 7px\">PIN " + " de Restablecimiento</h2>\n"
                        + "        <p style=\"margin: 2px; font-size: 15px; font-weight: bold\">        \n"
                        + "          Hola usuario, el equipo de Beep&Go recibio una solicitud de restablecimiento de credenciales por correo, a continuacion te brindamos un pin aleatorio para que puedas completar el proceso de restablecimiento de forma correcta.\n"
                        + "          <br>\n"
                        + "          <br>\n"
                        + "          Tu pin de restablecimiento es: \n"
                        + "          <br>\n"
                        + "          <br>\n"
                        + "          <div style=\"width: 100%; text-align: center\">\n"
                        + "          <a style=\"text-decoration: none; border-radius: 5px; padding: 11px 23px; color: white; background-color: #352F44\" > " + pin + " </a>\n"
                        + "        </div>\n"
                        + "          <br>\n"
                        + "          <br>\n"
                        + "        <br>\n"
                        + "        <p style=\"color: #b3b3b3; font-size: 12px; text-align: center;margin: 30px 0 0\">Beep&Go System ®</p>\n"
                        + "      </div>\n"
                        + "    </td>\n"
                        + "  </tr>\n"
                        + "</table>";

                MimeMessage message = new MimeMessage(ses);
                message.setFrom(new InternetAddress(correoRemitente));
                message.addRecipient(Message.RecipientType.TO, new InternetAddress(correoRes));
                message.setSubject(asunto);
                message.setText(mensaje, "ISO-8859-1", "html");

                Transport t = ses.getTransport("smtp");
                t.connect(correoRemitente, contraRemitente);
                t.sendMessage(message, message.getRecipients(Message.RecipientType.TO));
                t.close();

                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Correo enviado", "El correo con el pin de restablecimiento ha sido enviado con exito", 1);
            btnPIN.setText("Reenviar PIN");
            } catch (MessagingException e) {
                JOptionPane.showMessageDialog(null, "Error al enviar correo");
                System.out.println(e.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "El correo no pertenece a ningun usuario, verifica el correo ingresado", "Verficar correo", JOptionPane.WARNING_MESSAGE);
        }
    }


    private void btnPINActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPINActionPerformed

        Proceso_Enviado();
//        FrmRestablecimiento fr = new FrmRestablecimiento();
//        fr.setVisible(true);
//        this.dispose();
    }//GEN-LAST:event_btnPINActionPerformed

    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMousePressed

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnRestablecerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRestablecerActionPerformed

        int PinIn = Integer.parseInt(txtPIN.getText());

        if (PinIn == pin) {
            ControllerCorreo objC = new ControllerCorreo();
            ResultSet rs;
            objC.setCorreo(txtCorreo.getText());
            rs = objC.capturar();
            try {
                if (rs.next()) {
                    ID = rs.getInt("idUsuario");
                    nombreU = rs.getString("nombre_usuario");
                    Contra = rs.getString("contraseña");
                    objC.Actualizar();

                    objC.setId(ID);
                    objC.setUsuario(nombreU);
                    String clave = nombreU + "123";
                    objC.setClave(ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra(clave));
                    if (objC.Actualizar() == true) {

                        ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Actualizacion Exitosa", "Su clave ha sido actualizada a la clave por defecto." + clave, 1);
                        FrmLogin volver=new FrmLogin();
                        volver.setVisible(true);
                        this.dispose();
                    } else {
                        System.out.println("error");
                    }
                }
            } catch (SQLException e) {
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Error al capturar datos", "Verifique el Resultset en el evento del boton.", 2);
            }
        } else {
            ValidacionesSistema.ValidacionesBeep_Go.Notificacion("No es", "Pin incorrecto", 2);
        }
    }//GEN-LAST:event_btnRestablecerActionPerformed

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
            java.util.logging.Logger.getLogger(RecuCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RecuCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RecuCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RecuCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RecuCorreo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ImagenRecuCorreo;
    private Controles_Personalizados.Paneles.PanelRound PanelCampos;
    private Controles_Personalizados.Paneles.PanelRound PanelImg;
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnGoBack;
    private javax.swing.JLabel btnMinimizar;
    private Controles_Personalizados.Botones.ButtonGradient btnPIN;
    private Controles_Personalizados.Botones.ButtonGradient btnRestablecer;
    private javax.swing.JLabel textoRest;
    private Controles_Personalizados.textfields.TextField txtCorreo;
    private Controles_Personalizados.textfields.TextField txtPIN;
    // End of variables declaration//GEN-END:variables
}
