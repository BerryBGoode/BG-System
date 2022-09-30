/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerUsuarios;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ItemEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import necesario.RSFileChooser;

/**
 *
 * @author Rober
 */
public class FrmAgg_Usuarios extends javax.swing.JFrame {

    DefaultComboBoxModel<String> modelocombo;
    private List myArrayListTU;
    private List myArrayListEU;
    private List myArrayListPE;
    private int tipoUsu;
    private int estadoUsu;
    private int personal;
    byte[] imagen;
    ImageIcon fotoicon;
    FrmRecuAdmin ra = new FrmRecuAdmin();
    String carnet;
    int idActivo;
    int idAlumno;
    ControllerUsuarios objc = new ControllerUsuarios();
    
    /**
     * Creates new form FrmAgg_Usuarios
     */
    /**
     * 
     * @param titulo 
     */
    public FrmAgg_Usuarios(String titulo) {
        initComponents();
        CargarCmbs();
        
        this.setTitle(titulo);
        cbRecu.setVisible(false);
        txtID.setVisible(false);
        BtnConfirmar.setVisible(true);
        txtID.setVisible(false);
        cbAuto.setVisible(false);
        if ("Actualizar usuario".equals(this.getTitle())) {
            cbRecu.setVisible(true);
            txtID.setText(String.valueOf(ValidacionesSistema.Parametros_Usuario.getID()));
            txtUsuario.setText(ValidacionesSistema.Parametros_Usuario.getNombre_usuario());

            int respuestaTU = BuscarTipoUsuarioSeleccionado(ValidacionesSistema.Parametros_Usuario.getIdTipoUsuario());
            cmbTipo.setSelectedIndex(respuestaTU + 1);

            int respuestaEU = BuscarEstadoUsuarioSeleccionado(ValidacionesSistema.Parametros_Usuario.getIdEstadoUsuario());
            cmbEstado.setSelectedIndex(respuestaEU + 1);

            int respuestaPE = BuscarPersonalSeleccionado(ValidacionesSistema.Parametros_Usuario.getIdPersonal());
            cmbPersonal.setSelectedIndex(respuestaPE + 1);
            

            if (ValidacionesSistema.Parametros_Usuario.getImagen() != null) {
                try {
                    imagen = ValidacionesSistema.Parametros_Usuario.getImagen();
                    BufferedImage image = null;
                    InputStream input = new ByteArrayInputStream(ValidacionesSistema.Parametros_Usuario.getImagen());
                    image = ImageIO.read(input);
                    fotoicon = new ImageIcon(image.getScaledInstance(220, 250, 0));
                    lblFoto.setIcon(fotoicon);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, e.toString());
                }
            }
        }

        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());
    }

    /**
     * Constructor
     */
    public FrmAgg_Usuarios() {
        initComponents();
        CargarCmbs();
        
        cbRecu.setVisible(false);
        txtID.setVisible(false);
        BtnConfirmar.setVisible(true);
        txtID.setVisible(false);
        
        this.setLocationRelativeTo(null);
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
     * Metodo para ingresar un usuario
     */
    void Ingresar() {
        if (txtUsuario.getText().equals(" ") || cmbPersonal.getSelectedIndex() == 0 || cmbTipo.getSelectedIndex() == 0 || cmbEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Campos vacios");
        } else {
            String contraseña = ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra(txtUsuario.getText() + 123);
            ControllerUsuarios obja = new ControllerUsuarios(personal, txtUsuario.getText(), contraseña, ValidacionesSistema.ValidacionesBeep_Go.EncriptarContra("2353"), tipoUsu, estadoUsu, imagen, 5);
            boolean respuesta = obja.NuevoUsuario_C();
            if (respuesta == true) {
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado", "Usuario agregado", 1);
                this.dispose();
            } else {
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso fallido", "Usuario no pudo ser agregado", 2);
            }
        }
    }

    /**
     * Metodo para actualizar un usuario
     */
    void Actualizar() {
        if (txtUsuario.getText().equals(" ") || cmbPersonal.getSelectedIndex() == 0 || cmbTipo.getSelectedIndex() == 0 || cmbEstado.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Campos vacios");
        } else {
            ControllerUsuarios obja = new ControllerUsuarios(Integer.parseInt(txtID.getText()), personal, txtUsuario.getText(), tipoUsu, estadoUsu, imagen);
            boolean respuesta = obja.ActualizarUsuario_C();
            if (respuesta == true) {
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso completado", "Usuario actualizado", 1);
                this.dispose();
            } else {
                ValidacionesSistema.ValidacionesBeep_Go.Notificacion("Proceso fallido", "Usuario no pudo ser actualizado", 2);
            }
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
        txtUsuario = new Controles_Personalizados.textfields.TextField();
        cmbPersonal = new Controles_Personalizados.ComboBox.combobox();
        lblFoto = new javax.swing.JLabel();
        cmbEstado = new Controles_Personalizados.ComboBox.combobox();
        jLabel3 = new javax.swing.JLabel();
        btnExaminar = new Controles_Personalizados.Botones.UWPButton();
        jLabel1 = new javax.swing.JLabel();
        cmbTipo = new Controles_Personalizados.ComboBox.combobox();
        txtID = new javax.swing.JTextField();
        BtnConfirmar = new Controles_Personalizados.Botones.ButtonGradient();
        cbRecu = new javax.swing.JCheckBox();
        cbAuto = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1099, 578));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        panelRound1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 10, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        panelRound1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 10, -1, -1));

        txtUsuario.setBackground(new java.awt.Color(58, 50, 75));
        txtUsuario.setForeground(new java.awt.Color(254, 254, 254));
        txtUsuario.setCaretColor(new java.awt.Color(253, 255, 254));
        txtUsuario.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtUsuario.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtUsuario.setLabelText("Nombre - usuario");
        txtUsuario.setLineColor(new java.awt.Color(253, 255, 254));
        txtUsuario.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtUsuario.setSelectionColor(new java.awt.Color(253, 255, 254));
        txtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUsuarioKeyTyped(evt);
            }
        });
        panelRound1.add(txtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 340, 70));

        cmbPersonal.setBackground(new java.awt.Color(58, 50, 75));
        cmbPersonal.setForeground(new java.awt.Color(255, 255, 255));
        cmbPersonal.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        cmbPersonal.setLabeText("Personal");
        cmbPersonal.setLineColor(new java.awt.Color(253, 255, 254));
        cmbPersonal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPersonalItemStateChanged(evt);
            }
        });
        panelRound1.add(cmbPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 410, 340, 80));

        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(254, 254, 254), 3));
        panelRound1.add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 220, 235));

        cmbEstado.setBackground(new java.awt.Color(58, 50, 75));
        cmbEstado.setForeground(new java.awt.Color(253, 255, 254));
        cmbEstado.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        cmbEstado.setLabeText("Estado - Usuario");
        cmbEstado.setLineColor(new java.awt.Color(253, 255, 254));
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });
        panelRound1.add(cmbEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 300, 340, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/imagenlogin2.png"))); // NOI18N
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, 330, 350));

        btnExaminar.setBackground(new java.awt.Color(254, 254, 254));
        btnExaminar.setForeground(new java.awt.Color(58, 50, 75));
        btnExaminar.setText("Examinar");
        btnExaminar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExaminarActionPerformed(evt);
            }
        });
        panelRound1.add(btnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 410, 220, 50));

        jLabel1.setBackground(new java.awt.Color(51, 255, 51));
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 153));
        jLabel1.setText("Foto (Opcional)");
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        cmbTipo.setBackground(new java.awt.Color(58, 50, 75));
        cmbTipo.setForeground(new java.awt.Color(255, 255, 255));
        cmbTipo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        cmbTipo.setLabeText("Tipo - Usuario");
        cmbTipo.setLineColor(new java.awt.Color(253, 255, 254));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });
        panelRound1.add(cmbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 340, 80));
        panelRound1.add(txtID, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        BtnConfirmar.setBackground(new java.awt.Color(253, 255, 254));
        BtnConfirmar.setForeground(new java.awt.Color(58, 50, 75));
        BtnConfirmar.setText("Continuar");
        BtnConfirmar.setColor1(new java.awt.Color(253, 255, 254));
        BtnConfirmar.setColor2(new java.awt.Color(253, 255, 254));
        BtnConfirmar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });
        panelRound1.add(BtnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 510, 150, 44));

        cbRecu.setBackground(new java.awt.Color(58, 50, 75));
        cbRecu.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbRecu.setForeground(new java.awt.Color(253, 255, 255));
        cbRecu.setText("Recuperar contraseña");
        panelRound1.add(cbRecu, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 520, -1, -1));

        cbAuto.setBackground(new java.awt.Color(58, 50, 75));
        cbAuto.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        cbAuto.setForeground(new java.awt.Color(253, 255, 255));
        cbAuto.setText("Usuario automatico");
        cbAuto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbAutoItemStateChanged(evt);
            }
        });
        panelRound1.add(cbAuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 520, -1, -1));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1120, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Metodo para cerrar la aplicación
     * @param evt 
     */
    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        txtUsuario.setText("");
        cmbTipo.setSelectedIndex(0);
        cmbEstado.setSelectedIndex(0);
        cmbPersonal.setSelectedIndex(0);
        this.dispose();
        PanelOpcionesPersonal.showinter = 0;
    }//GEN-LAST:event_btnCerrarMousePressed

    /**
     * Metodo para minimizar la aplicación
     * @param evt 
     */
    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    /**
     * Metodo para buscar el IDActivo en la tabla de los estados de los usuarios
     */
    void CargarIDActivo(){
        ResultSet rs;
        rs = objc.BuscarIDActivo_C();
        try {
            if (rs.next()) {
                idActivo = rs.getInt("idEstadoUsuario");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(this,e.toString());
        }
        if(carnet != null){
            int respuesta = BuscarEstadoUsuarioSeleccionado(idActivo);
            cmbEstado.setSelectedIndex(respuesta + 1);
        }
    }
    
    /**
     * Metodo para cargar el ID con el tipo de usuario de "Estudiante"
     */
    void CargarIDAlumno(){
        ResultSet rs;
        rs = objc.BuscarIDEstudiante_C();
        try {
            if (rs.next()) {
                idAlumno = rs.getInt("idTipoUsuario");
            }
        } catch (Exception e) {
                JOptionPane.showMessageDialog(this,e.toString());
        }
        if(carnet != null){
            int respuesta = BuscarTipoUsuarioSeleccionado(idAlumno);
            cmbTipo.setSelectedIndex(respuesta + 1);
        }
    }
    
    /**
     * Metodo para cargar el carnet de un personal seleccionado
     */
    void CargarCarnet(){
        ResultSet rs;
        carnet = null;
        if(personal != 0){
            objc.setIDPersonal(personal);
            rs = objc.BuscarCarnet_C();
            try {
                if (rs.next()) {
                    carnet = rs.getString("Carnet");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,e.toString());
            }
        }
        if(carnet != null){
            txtUsuario.setText(carnet);
        }
    }
    
    /**
     * Metodo para cargar los datos del usuario que se generara automaticamente
     */
    void CargarDatos(){
        CargarCarnet();
        CargarIDAlumno();
        CargarIDActivo();
    }
    
    /**
     * Metodo para guardar el ID del registro seleccioando en el cmbPersonal
     * @param evt 
     */
    private void cmbPersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPersonalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = cmbPersonal.getSelectedIndex();
            if (pos == 0) {
                personal = 0;
            } else {
                int dim = myArrayListPE.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        personal = (int) myArrayListPE.get(i);
                    }
                }
            }
        }
        
        if(cbAuto.isSelected() && cmbPersonal.getSelectedIndex() != 0){
            CargarDatos();
        }
    }//GEN-LAST:event_cmbPersonalItemStateChanged

    /**
     * Metodo para guardar el ID del registro seleccioando en el cmbEstado
     * @param evt 
     */
    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = cmbEstado.getSelectedIndex();
            if (pos == 0) {
                estadoUsu = 0;
            } else {
                int dim = myArrayListEU.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        estadoUsu = (int) myArrayListEU.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    /**
     * Metodo para activar el proceso de actualizar o agregar
     * @param evt 
     */
    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        // TODO add your handling code here:
        if(this.getTitle().equals("Actualizar usuario")){
            Actualizar();
            if(cbRecu.isSelected()){
                if(ra.isVisible()){
                    ra.toFront();
                }else{
                    ra.setVisible(true);
                }
            }
        }
        else{
            Ingresar();
        }
    }//GEN-LAST:event_BtnConfirmarActionPerformed

    /**
     * Metodo para activar el proceso de mostrar la imagen
     * @param evt 
     */
    private void btnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExaminarActionPerformed
        // TODO add your handling code here:
        MostrarImagen();
    }//GEN-LAST:event_btnExaminarActionPerformed

    /**
     * Metodo para limpiar campos dependiendo si el usuario se creara automaticamente o no
     * @param evt 
     */
    private void cbAutoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbAutoItemStateChanged
        // TODO add your handling code here:
        if(! cbAuto.isSelected()){
            txtUsuario.setText("");
            cmbEstado.setSelectedIndex(0);
            cmbTipo.setSelectedIndex(0);
            cmbPersonal.setSelectedIndex(0);
        }
    }//GEN-LAST:event_cbAutoItemStateChanged

    /**
     * Metodo para guardar el ID del registro seleccioando en el cmbTipo
     * @param evt 
     */
    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = cmbTipo.getSelectedIndex();
            if (pos == 0) {
                tipoUsu = 0;
            } else {
                int dim = myArrayListTU.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        tipoUsu = (int) myArrayListTU.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_cmbTipoItemStateChanged

    /**
     * Validaciones para el txtUsuario
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
            java.util.logging.Logger.getLogger(FrmAgg_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Usuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgg_Usuarios().setVisible(true);
            }
        });
    }

    /**
     * Metodo para llenar el combobox de tipo de usuario
     */
    final void CargarTipoUsuarios() {
        ControllerUsuarios objc = new ControllerUsuarios();
        myArrayListTU = new ArrayList();
        try {
            ResultSet rs = objc.CargarTipoUsuarios_C();
            if (rs.next()) {
                modelocombo = new DefaultComboBoxModel<>();
                modelocombo.addElement("");
                do {
                    myArrayListTU.add(rs.getInt("idTipoUsuario"));
                    modelocombo.addElement(rs.getString("tipo_usuario"));
                    cmbTipo.setModel(modelocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No existen tipos de usuario por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se han podido cargar los datos, favor consulta con el administrador del sistema", "Error critico", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para cargar el combobox de estado de usuario
     */
    final void CargarEstadoUsuarios() {
        ControllerUsuarios objc = new ControllerUsuarios();
        myArrayListEU = new ArrayList();
        try {
            ResultSet rs = objc.CargarEstadoUsuarios_C();
            if (rs.next()) {
                modelocombo = new DefaultComboBoxModel<>();
                modelocombo.addElement("");
                do {
                    myArrayListEU.add(rs.getInt("idEstadoUsuario"));
                    modelocombo.addElement(rs.getString("estado_usuario"));
                    cmbEstado.setModel(modelocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No existen estados de usuario por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se han podido cargar los datos, favor consulta con el administrador del sistema", "Error critico", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para cargar el combobox de personal
     */
    final void CargarPersonal() {
        ControllerUsuarios objc = new ControllerUsuarios();
        myArrayListPE = new ArrayList();
        try {
            ResultSet rs = objc.CargarPersonal_C();
            if (rs.next()) {
                modelocombo = new DefaultComboBoxModel<>();
                modelocombo.addElement("");
                do {
                    myArrayListPE.add(rs.getInt("idPersonal"));
                    modelocombo.addElement(rs.getString("nombre_completo"));
                    cmbPersonal.setModel(modelocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No existe ningún personal por cargar.", "Mensaje", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se han podido cargar los datos, favor consulta con el administrador del sistema", "Error critico", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Metodo para cargar todos los combobox
     */
    final void CargarCmbs() {
        CargarTipoUsuarios();
        CargarEstadoUsuarios();
        CargarPersonal();
    }

    /**
     * Metodo para mostrar la imagen seleccionada en un label
     */
    void MostrarImagen() {
        RSFileChooser jcargarfoto = new RSFileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("JPG", "PNG", "JPG");
        jcargarfoto.setFileFilter(extension);
        int ver = jcargarfoto.showOpenDialog(this);
        if (ver == JFileChooser.APPROVE_OPTION) {
            String url = jcargarfoto.getSelectedFile().getAbsolutePath();
            try {
                File ruta = new File(url);
                imagen = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(imagen);
            } catch (Exception e) {
            }
            try {
                BufferedImage image = null;
                InputStream input = new ByteArrayInputStream(imagen);
                image = ImageIO.read(input);
                fotoicon = new ImageIcon(image.getScaledInstance(220, 250, 0));
                lblFoto.setIcon(fotoicon);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }

    /**
     * Metodo para buscar el tipo de usuario a seleccionar en el combobox
     * @param id
     * @return 
     */
    final int BuscarTipoUsuarioSeleccionado(int id) {
        int size = myArrayListTU.size();
        int retorno = -1;
        for (int i = 0; i < size; i++) {
            int valor = (Integer) myArrayListTU.get(i);
            if (valor == id) {
                retorno = i;
            }
        }
        return retorno;
    }

    /**
     * Metodo para buscar el estado de usuario a seleccionar en el combobox
     * @param id
     * @return 
     */
    final int BuscarEstadoUsuarioSeleccionado(int id) {
        int size = myArrayListEU.size();
        int retorno = -1;
        for (int i = 0; i < size; i++) {
            int valor = (Integer) myArrayListEU.get(i);
            if (valor == id) {
                retorno = i;
            }
        }
        return retorno;
    }

    /**
     * Metodo para buscar el personal a seleccionar en el combobox
     * @param id
     * @return 
     */
    final int BuscarPersonalSeleccionado(int id) {
        int size = myArrayListPE.size();
        int retorno = -1;
        for (int i = 0; i < size; i++) {
            int valor = (Integer) myArrayListPE.get(i);
            if (valor == id) {
                retorno = i;
            }
        }
        return retorno;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Botones.ButtonGradient BtnConfirmar;
    private javax.swing.JLabel btnCerrar;
    private Controles_Personalizados.Botones.UWPButton btnExaminar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JCheckBox cbAuto;
    private javax.swing.JCheckBox cbRecu;
    private Controles_Personalizados.ComboBox.combobox cmbEstado;
    private Controles_Personalizados.ComboBox.combobox cmbPersonal;
    private Controles_Personalizados.ComboBox.combobox cmbTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblFoto;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private javax.swing.JTextField txtID;
    private Controles_Personalizados.textfields.TextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
