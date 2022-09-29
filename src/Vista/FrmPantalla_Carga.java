/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerConfig;
import Controlador.ControllerP_U_Empresa;
import Controlador.ControllerP_U_Personal;
import Controlador.ControllerP_U_Usuarios;
import static Vista.FrmConfigConection.config;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
public class FrmPantalla_Carga extends javax.swing.JFrame {

    /**
     * Creates new form FrmPantalla_Carga
     */
    FrmConfigConection frmconexion = new FrmConfigConection();
    int numerobarra;

    public FrmPantalla_Carga() {
        initComponents();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());
        correrlo();
    }

    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    private void barracargar() {
        for (numerobarra = 0; numerobarra <= 100; numerobarra++) {
            try {
                Thread.sleep(20);
                BarraCarga.setValue(numerobarra);
                if (numerobarra == 100) {
                    if (config.checkFile() == true) {
                        //existe file
                        config.readFile();
                        ControllerConfig.setUsername(config.data[0]);
                        ControllerConfig.setIp(config.data[1]);
                        ControllerConfig.setHost(config.data[2]);
                        ControllerConfig.setPassword(config.data[3]);

                        ControllerP_U_Empresa VistapEmpresa = new ControllerP_U_Empresa();
                        ControllerP_U_Personal PrimerPersonal = new ControllerP_U_Personal();
                        ControllerP_U_Usuarios primerUsuarios = new ControllerP_U_Usuarios();

                        //lee los valores y los asigna a los attr
                        if (ControllerConexion.getConnectionModel() != null) {
                            if (VistapEmpresa.checkEnterprise() == false) {
                                Bienvenida welcome = new Bienvenida();
                                welcome.setVisible(true);
                            } else if (PrimerPersonal.checkcontrollerPersonal() == true && primerUsuarios.checkControllerUsuario() == true && VistapEmpresa.checkEnterprise() == true) {
                                FrmLogin iniciar = new FrmLogin();
                                iniciar.setVisible(true);
                            } else if (VistapEmpresa.checkEnterprise() == true && PrimerPersonal.checkcontrollerPersonal() == false) {

                                Bienvenida welcome = new Bienvenida();
                                welcome.setVisible(true);

                            } else if (PrimerPersonal.checkcontrollerPersonal() == true && primerUsuarios.checkControllerUsuario() == false && VistapEmpresa.checkEnterprise() == true) {
                                Bienvenida welcome = new Bienvenida();
                                welcome.setVisible(true);
                            }
                        } /*else if(primerPersonal==true){
                            FrmP_U_Usuario pu=new FrmP_U_Usuario();
                            pu.setVisible(true);
                    }*/ //FrmP_U_Personal pe=new FrmP_U_Personal();
                        //pe.setVisible(true);
                        //modificar.
                        //verificar si existe un usuario 
                        //si existen, pasar al login 
                        //si no exsiten la primer uso
                        else {
                            
                            config.setVisible(true);//para volver a config, porque salio algo mal                        
                            config.deleteFile();
                        }
                    } else {
                        ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Configuración inexistente", "No se ha encontrado un archivo de configuración.\nConfigure su conexión", 1);
                        config.setVisible(true);//cuando no exista el archivo                        
                    }
                    this.dispose();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(FrmPantalla_Carga.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void correrlo() {
        Thread hilo = new Thread() {
            @Override
            public void run() {
                barracargar();
            }
        };
        hilo.start();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BarraCarga = new Controles_Personalizados.ProgressBarCustom();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(900, 500));

        panelRound1.setBackground(new java.awt.Color(42, 36, 56));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/LogoB&GDash.png"))); // NOI18N
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 80, 130, 140));

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 54)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(219, 216, 227));
        jLabel2.setText("Beep&Go");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 220, -1, -1));

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(219, 216, 227));
        jLabel3.setText("Cargando ...");
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, 40));

        BarraCarga.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.add(BarraCarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 335, 475, 40));

        getContentPane().add(panelRound1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(FrmPantalla_Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPantalla_Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPantalla_Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPantalla_Carga.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPantalla_Carga().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.ProgressBarCustom BarraCarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    // End of variables declaration//GEN-END:variables
}
