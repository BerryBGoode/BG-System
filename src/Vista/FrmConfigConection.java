/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import com.sun.awt.AWTUtilities;
import java.io.*;
import Controlador.*;
import java.awt.Image;
import java.awt.Toolkit;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author ferna
 */
public class FrmConfigConection extends javax.swing.JFrame {

    File file;
    final String filename = "configConection.txt";
    public String[] data = new String[5];
    ControllerP_U_Empresa verficarpu = new ControllerP_U_Empresa();
    ControllerP_U_Personal verficarpu1 = new ControllerP_U_Personal();
    ControllerP_U_Usuarios verficarpu2 = new ControllerP_U_Usuarios();

    /**
     * Creates new form FrmConfigConection
     */
    public FrmConfigConection() {
        initComponents();
        txtcontra.setEchoChar('•');
        setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());                
    }

    /**
     * Metodo para colocar el logo en la barra de tareas
     * @return 
     */
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

        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        panelRound2 = new Controles_Personalizados.Paneles.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        txtIP = new Controles_Personalizados.textfields.TextField();
        txtUsuario = new Controles_Personalizados.textfields.TextField();
        txtHost = new Controles_Personalizados.textfields.TextField();
        btnSave = new Controles_Personalizados.Botones.ButtonGradient();
        txtcontra = new Controles_Personalizados.textfields.PasswordField();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1099, 578));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(254, 254, 254));
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/TextoConfigConection.png"))); // NOI18N
        panelRound2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

        txtIP.setBackground(new java.awt.Color(254, 254, 254));
        txtIP.setForeground(new java.awt.Color(42, 36, 56));
        txtIP.setCaretColor(new java.awt.Color(42, 36, 56));
        txtIP.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtIP.setLabelText("Dirección  IP");
        txtIP.setLineColor(new java.awt.Color(42, 36, 56));
        txtIP.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtIP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtIPKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIPKeyTyped(evt);
            }
        });
        panelRound2.add(txtIP, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 450, 70));

        txtUsuario.setBackground(new java.awt.Color(254, 254, 254));
        txtUsuario.setForeground(new java.awt.Color(42, 36, 56));
        txtUsuario.setCaretColor(new java.awt.Color(42, 36, 56));
        txtUsuario.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtUsuario.setLabelText("Usuario - Conexión");
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
        panelRound2.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 450, 70));

        txtHost.setBackground(new java.awt.Color(254, 254, 254));
        txtHost.setForeground(new java.awt.Color(42, 36, 56));
        txtHost.setCaretColor(new java.awt.Color(42, 36, 56));
        txtHost.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtHost.setLabelText("Puerto - Host");
        txtHost.setLineColor(new java.awt.Color(42, 36, 56));
        txtHost.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtHost.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtHostKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtHostKeyTyped(evt);
            }
        });
        panelRound2.add(txtHost, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 450, 70));

        btnSave.setBackground(new java.awt.Color(254, 254, 254));
        btnSave.setColor1(new java.awt.Color(42, 36, 56));
        btnSave.setColor2(new java.awt.Color(58, 50, 75));
        btnSave.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnSave.setLabel("Guardar");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        panelRound2.add(btnSave, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 500, 320, -1));

        txtcontra.setBackground(new java.awt.Color(254, 254, 254));
        txtcontra.setForeground(new java.awt.Color(42, 36, 56));
        txtcontra.setCaretColor(new java.awt.Color(42, 36, 56));
        txtcontra.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtcontra.setLabelText("Contraseña:");
        txtcontra.setLineColor(new java.awt.Color(42, 36, 56));
        txtcontra.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtcontra.setShowAndHide(true);
        txtcontra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtcontraKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtcontraKeyTyped(evt);
            }
        });
        panelRound2.add(txtcontra, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 450, 70));

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 590, 580));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        panelRound1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, -1));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        panelRound1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Server status-amico.png"))); // NOI18N
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(596, 40, 500, -1));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para cerrar la aplicación
     * @param evt 
     */
    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        System.exit(0);
    }//GEN-LAST:event_btnCerrarMousePressed

    /**
     * Metodo para activar el metodo de guardar la configuración
     * @param evt 
     */
    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        saveConfig();
        this.dispose();
    }//GEN-LAST:event_btnSaveActionPerformed

    /**
     * Metodo para minimizar la aplicación
     * @param evt 
     */
    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    /**
     * Validaciones para el txtUsuario
     * @param evt 
     */
    private void txtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtUsuarioKeyPressed

    /**
     * Validaciones para el txtIP
     * @param evt 
     */
    private void txtIPKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtIPKeyPressed

    /**
     * Validaciones para el txtHost
     * @param evt 
     */
    private void txtHostKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHostKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtHostKeyPressed

    /**
     * Validaciones para el txtcontra
     * @param evt 
     */
    private void txtcontraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(txtcontra.getText().length() >= 40){
            evt.consume();
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
        }
    }//GEN-LAST:event_txtcontraKeyTyped

    /**
     * Validaciones para el txtContra
     * @param evt 
     */
    private void txtHostKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtHostKeyTyped
        // TODO add your handling code here:
        if(txtHost.getText().length() >= 8){
            evt.consume();
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.SoloNumeros(evt);
            ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
        }
    }//GEN-LAST:event_txtHostKeyTyped

    /**
     * Validaciones para el txtUsuario
     * @param evt 
     */
    private void txtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUsuarioKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(txtUsuario.getText().length() >= 30){
            evt.consume();
        }else if(txtUsuario.getText().length() == 0 && Character.isWhitespace(key)){
            evt.consume();
        }else if(txtUsuario.getText().length() > 0){
            String text = txtUsuario.getText();
            String ultimo = text.substring(text.length() - 1);
            if(ultimo != null && ultimo.equals(" ") && Character.isWhitespace(key)){
                evt.consume();
            }   
        }
    }//GEN-LAST:event_txtUsuarioKeyTyped

    /**
     * Validaciones para el txtIP
     * @param evt 
     */
    private void txtIPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIPKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(txtIP.getText().length() >= 30){
            evt.consume();
        }else if(txtIP.getText().length() == 0 && Character.isWhitespace(key)){
            evt.consume();
        }else if(txtIP.getText().length() > 0){
            String text = txtIP.getText();
            String ultimo = text.substring(text.length() - 1);
            if(ultimo != null && ultimo.equals(" ") && Character.isWhitespace(key)){
                evt.consume();
            }   
        }
    }//GEN-LAST:event_txtIPKeyTyped

    /**
     * Validaciones para el txtcontra
     * @param evt 
     */
    private void txtcontraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcontraKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtcontraKeyPressed
    
    /**
     * Metodo para guardar la configuración en un archivo
     */
    void saveConfig() {
        getDataConfig();
        if (ControllerConfig.getUsername() == "" && ControllerConfig.getHost() == ""
                && ControllerConfig.getIp() == "" && ControllerConfig.getPassword() == "") {

            JOptionPane.showMessageDialog(null, "Existen campos vacíos, porfavor llenarlos", "Campos vacios", 0);
        } else {
            if (ControllerConexion.getConnectionModel() != null) {
                createFile();
                writeFile();
                JOptionPane.showMessageDialog(null, "Se guardo un archivo con\nlos datos de la conexón", "Archivo guardado", JOptionPane.INFORMATION_MESSAGE);
                if (verficarpu.checkEnterprise() == false) {
                    FrmP_U_Empresa cargarempresa = new FrmP_U_Empresa();
                    cargarempresa.setVisible(true);
                } else if (verficarpu.checkEnterprise() == true && verficarpu1.checkcontrollerPersonal() == false) {
                    FrmP_U_Personal cargarpersonal = new FrmP_U_Personal();
                    cargarpersonal.setVisible(true);
                }

                ControllerP_U_Empresa VistapEmpresa = new ControllerP_U_Empresa();
                ControllerP_U_Personal PrimerPersonal = new ControllerP_U_Personal();
                ControllerP_U_Usuarios primerUsuarios = new ControllerP_U_Usuarios();

                if (VistapEmpresa.checkEnterprise() == false) {
                    FrmP_U_Empresa emp = new FrmP_U_Empresa();
                    emp.setVisible(true);

                } else if (VistapEmpresa.checkEnterprise() == true && PrimerPersonal.checkcontrollerPersonal() == false) {
                    FrmP_U_Personal cargarpersonal = new FrmP_U_Personal();
                    cargarpersonal.setVisible(true);

                } else if (PrimerPersonal.checkcontrollerPersonal() == true && primerUsuarios.checkControllerUsuario() == false && VistapEmpresa.checkEnterprise() == true) {
                    FrmP_U_Personal cargarpersonal = new FrmP_U_Personal();
                    cargarpersonal.setVisible(true);
                } else if (PrimerPersonal.checkcontrollerPersonal() == true && primerUsuarios.checkControllerUsuario() == true && VistapEmpresa.checkEnterprise() == true) {
                    FrmLogin iniciar = new FrmLogin();
                    iniciar.setVisible(true);
                }

            } else {
                /*esto porque me cerraba el frm al dale ok al msg anterior */
                int conf = JOptionPane.YES_NO_OPTION;
                JOptionPane.showConfirmDialog(this, "No se pudo establecer " + "conexión con la\nbase de" + "datos" + "\n Error 001", "¿Desea volver a intentar?", conf);
                if (conf == JOptionPane.YES_OPTION) {
                    FrmConfigConection config = new FrmConfigConection();
                    config.setVisible(true);
                }

            }
        }

    }

    /**
     * Metodo para enviar los datos al controlador
     */
    void getDataConfig() {
        ControllerConfig.setIp(txtIP.getText());
        ControllerConfig.setHost(txtHost.getText());
        ControllerConfig.setUsername(txtUsuario.getText());
        ControllerConfig.setPassword(txtcontra.getText());
    }

    /**
     * Metodo para verificar si existe un archivo y retorna true si existe
     * @return 
     */
    boolean checkFile() {
        file = new File(filename);
        if (file.exists()) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Metodo para crear un archivo
     */
    void createFile() {
        file = new File(filename);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Metodo para escribir el archivo
     */
    void writeFile() {
        file = new File(filename);
        try {
            FileWriter writer = new FileWriter(filename);

            writer.write(ValidacionesSistema.ValidacionesBeep_Go.EBase64(ControllerConfig.getUsername()));
            writer.write("\n" + ValidacionesSistema.ValidacionesBeep_Go.EBase64(ControllerConfig.getIp()));
            writer.write("\n" + ValidacionesSistema.ValidacionesBeep_Go.EBase64(ControllerConfig.getHost()));
            writer.write("\n" + ValidacionesSistema.ValidacionesBeep_Go.EBase64(ControllerConfig.getPassword()));
            writer.write("\nEste es un archivo de configuración para la conexión, porfavor no borrar\n");
            writer.write("This a file of configuration of connection on database, please don't delete this file");
            writer.close();
            file.setReadOnly();
            hiddenFile();
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Metodo para leer el archivo
     */
    public void readFile() {
        String cont;
        try {
            FileReader readerfile = new FileReader(filename);
            BufferedReader reader = new BufferedReader(readerfile);
            for (int i = 0; i < 4; i++) {
                cont = reader.readLine();
                String[] listconf = new String[]{cont};
                data[i] = ValidacionesSistema.ValidacionesBeep_Go.DBase64(listconf[0]);
            }
            readerfile.close();
            reader.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            e.printStackTrace(System.out);
        }
    }

    /**
     * Metodo para ocultar el archivo
     */
    void hiddenFile() {
        try {
            Path repo = Paths.get(filename);
            String atri = "dos:hidden";
            Boolean hidden = (Boolean) Files.getAttribute(repo, atri, LinkOption.NOFOLLOW_LINKS);
            if (hidden != null && !hidden) {
                Files.setAttribute(repo, atri, Boolean.TRUE, LinkOption.NOFOLLOW_LINKS);
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
    }

    /**
     * Metodo para borrar el archivo
     */
    void deleteFile() {
        file = new File(filename);
        if (file.delete()) {
            JOptionPane.showMessageDialog(null, "No se pudo establecer \n" + "conexión con la base de \n" + "datos, porque existen datos erroneos \n en el archivo creado", "Archivo eliminado", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "No se pudo establecer \n" + "conexión con la base de \n" + "datos, y no se pudo borrar el archivo\n con las configuraciones", "Error grave", JOptionPane.WARNING_MESSAGE);
        }
    }
    /**
     * @param args the command line arguments
     */
    static FrmConfigConection config = new FrmConfigConection();
    static FrmLogin login = new FrmLogin();

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
            java.util.logging.Logger.getLogger(FrmConfigConection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmConfigConection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmConfigConection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmConfigConection.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
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
                            FrmP_U_Empresa emp = new FrmP_U_Empresa();
                            emp.setVisible(true);
                        } else if (VistapEmpresa.checkEnterprise() == true && PrimerPersonal.checkcontrollerPersonal() == false) {
                            FrmP_U_Personal cargarpersonal = new FrmP_U_Personal();
                            cargarpersonal.setVisible(true);

                        } else if (PrimerPersonal.checkcontrollerPersonal() == true && primerUsuarios.checkControllerUsuario() == false && VistapEmpresa.checkEnterprise() == true) {
                            FrmP_U_Personal cargarpersonal = new FrmP_U_Personal();
                            cargarpersonal.setVisible(true);
                        } else if (PrimerPersonal.checkcontrollerPersonal() == true && primerUsuarios.checkControllerUsuario() == true && VistapEmpresa.checkEnterprise() == true) {
                            FrmLogin iniciar = new FrmLogin();
                            iniciar.setVisible(true);
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
                        JOptionPane.showMessageDialog(null, "No, se logro establercer conexion con la base de datos", "Error de conexion", JOptionPane.ERROR_MESSAGE);
                        config.setVisible(true);//para volver a config, porque salio algo mal                        
                        config.deleteFile();
                    }
                } else {
                    config.setVisible(true);//cuando no exista el archivo
                }
            }
        });

    }
    
    /**
     * 
     * @return 
     */
    @Override
    public boolean isFocused() {
        return super.isFocused(); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     */
    @Override
    public void addNotify() {
        super.addNotify(); //To change body of generated methods, choose Tools | Templates.
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private javax.swing.JLabel btnMinimizar;
    private Controles_Personalizados.Botones.ButtonGradient btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.Paneles.PanelRound panelRound2;
    private Controles_Personalizados.textfields.TextField txtHost;
    private Controles_Personalizados.textfields.TextField txtIP;
    private Controles_Personalizados.textfields.TextField txtUsuario;
    private Controles_Personalizados.textfields.PasswordField txtcontra;
    // End of variables declaration//GEN-END:variables
}
