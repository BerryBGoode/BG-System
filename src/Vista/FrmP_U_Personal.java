/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerP_U_Personal;
import Controlador.ControllerP_U_Usuarios;
import ValidacionesSistema.ValidacionesBeep_Go;
import com.sun.awt.AWTUtilities;
import java.awt.AWTException;
import java.awt.HeadlessException;

import java.awt.Image;
import java.awt.Shape;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ItemEvent;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
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
 * @author Ander
 */
public class FrmP_U_Personal extends javax.swing.JFrame {

    DefaultComboBoxModel<String> modelocombo = new DefaultComboBoxModel<>();
    DefaultComboBoxModel<String> modelcombogenero = new DefaultComboBoxModel<>();
    private int tipod = 0;
    private int tipodanterior = 0;
    private int tipo_mensaje = 0;
    private int genero = 0;
    private String tipodoc;
    private Calendar c;
    private List myArrayList;
    private String fecha;
    private SimpleDateFormat formatos;
    private List ListGenero;
    ControllerP_U_Personal controllerp = new ControllerP_U_Personal();
    ControllerP_U_Usuarios controlleru = new ControllerP_U_Usuarios();
    private byte[] fotou;
    private String imprimirid;
    private String Carnet;
    private String nombres;
    private String apellidos;
    private int idpersonal;
    private ImageIcon fotoicon;

    /**
     * Creates new form PrimerUsoPersonal
     */
    public FrmP_U_Personal() {
        initComponents();
        this.setTitle("Creación de primer usuario");
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());
        //De esta forma se muestra el logo que deseamos mostrar
        cargarlista();
        PrimerUso();
    }

    /**
     * Metodo para cargar el logo en la barra de tareas
     * @return 
     */
    private Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    /**
     * Metodo para bloquear los botonoes de la creacopm del primer usuario
     */
    private void PrimerUso() {
        //Validamos si se generaron registros en la tabla de personal y no en usuario
        if (controllerp.checkcontrollerPersonal() == true && controlleru.checkControllerUsuario() == false) {
            txtApellido.setEnabled(false);
            txtCorreo.setEnabled(false);
            txtDocumento.setEnabled(false);
            txtDirecion.setEnabled(false);
            txtNombre.setEnabled(false);
            CmbGenero.setEnabled(false);
            CmbTipoDocumento.setEnabled(false);
            BtnExaminar.setEnabled(true);
            TxtUsuario.setEnabled(true);
            DtFechaNac.setEnabled(false);
            btnContinuar.setVisible(false);
            BtnGuardar.setVisible(true);
        } //Si no hay registros de personal los controles para generar un registro de usuario se bloquean
        else {
            txtApellido.setEnabled(true);
            txtCorreo.setEnabled(true);
            txtDocumento.setEnabled(true);
            txtNombre.setEnabled(true);
            CmbGenero.setEnabled(true);
            txtDirecion.setEnabled(true);
            CmbTipoDocumento.setEnabled(true);
            btnContinuar.setVisible(true);
            BtnGuardar.setVisible(false);
            BtnExaminar.setEnabled(false);
            TxtUsuario.setEnabled(false);
            DtFechaNac.setEnabled(true);
//            JDateChooser  = new JDateChooser ();
//            DtFechanac.set
//            JTextFieldDateEditor editor = (JTextFieldDateEditor) fecha.getDateEditor();
//            editor.setEditable(false);
        }
    }

    /**
     * Metodo para capturar la fecha de nacimiento
     * @return 
     */
    private int capfecha() {
        Date date = DtFechaNac.getDate();
        c = new GregorianCalendar();
        c.setTime(date);
        Calendar hoy = Calendar.getInstance();
        int Anio = hoy.get(Calendar.YEAR) - c.get(Calendar.YEAR);
        int Mes = hoy.get(Calendar.MONTH) - c.get(Calendar.MONTH);
        int dia = hoy.get(Calendar.DAY_OF_MONTH) - c.get(Calendar.DAY_OF_MONTH);
        if (Mes < 0 || Mes == 0 && dia < 0) {
            Anio = Anio - 1;
        }
        return Anio;
    }

    /**
     * Metodo para abrir una imagen en el LblFoto
     */
    void ExaminarImagen() {
        RSFileChooser jcargarfoto = new RSFileChooser();
        FileNameExtensionFilter extension = new FileNameExtensionFilter("JPG", "PNG", "JPG");
        jcargarfoto.setFileFilter(extension);
        int ver = jcargarfoto.showOpenDialog(this);
        if (ver == JFileChooser.APPROVE_OPTION) {
            String url = jcargarfoto.getSelectedFile().getAbsolutePath();
            try {
                File ruta = new File(url);
                fotou = new byte[(int) ruta.length()];
                InputStream input = new FileInputStream(ruta);
                input.read(fotou);
                controllerp.setLogo(fotou);
            } catch (IOException e) {
                controllerp.setLogo(fotou);
            }
            try {
                byte[] imagen = controllerp.getLogo();
                BufferedImage image = null;
                InputStream input = new ByteArrayInputStream(imagen);
                image = ImageIO.read(input);
                fotoicon = new ImageIcon(image.getScaledInstance(220, 250, 0));
                LblFoto.setIcon(fotoicon);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }

    }

    /**
     * Metodo para mostrar una notificación
     */
    void notificacionTaskBar() {
        try {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("Recursos_Proyecto/comprobar.png");
            TrayIcon trayIcon = new TrayIcon(image, "Java AWTTray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);
            if (tipo_mensaje == 1) {
                String mensajes = "Ha logrado completar exitosamente el proceso de Primer Uso, como siguiente paso procede a validar sus credenciales para obtener acceso al sistema";
                trayIcon.displayMessage("Proceso Completado", mensajes, TrayIcon.MessageType.INFO);
            } else {
                String mensaje = "Error del sistema";
                trayIcon.displayMessage("Error Critico", mensaje, TrayIcon.MessageType.ERROR);
            }
        } catch (AWTException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Metodo para ingresar un usuario
     */
    void IngresarUsuario() {
        if (TxtUsuario.getText().trim().isEmpty() && LblFoto.getIcon() == null) {
            JOptionPane.showMessageDialog(null, "No se puede continuar con el proceso debido a que \n la informacion necesaria esta incompleta", "Error usuario", JOptionPane.WARNING_MESSAGE);
        } else {
            GetIdPersonal();
            controlleru.setUsuario(TxtUsuario.getText());
            String clave = TxtUsuario.getText() + "123";
            controlleru.setClave(ValidacionesBeep_Go.EncriptarContra(clave));
            int min = 1000;
            int max = 9999;
            Random random = new Random();
            int valornum = random.nextInt(max + min) + min;
            String valor = String.valueOf(valornum);
            String encriptarPIN = ValidacionesBeep_Go.EncriptarContra(valor);
            controlleru.setPIN(encriptarPIN);
            controlleru.setFoto(fotou);
            if (controlleru.IngresarPUsuarioController() == true) {
                JOptionPane.showMessageDialog(null, "Su usuario ha sido ingresado correctamente", "Proceso Completado", JOptionPane.INFORMATION_MESSAGE);
                FrmLogin iniciarSesion = new FrmLogin();
                iniciarSesion.setVisible(true);
                this.dispose();
                tipo_mensaje = 1;
                notificacionTaskBar();
                JOptionPane.showMessageDialog(null, "Su contraseña es su usario +123, ingrese de esa forma sus \n credenciales para luego poder ingresar la contraseña que desee", "Contraseña", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, "Su PIN de seguridad es el siguiente :" + valornum, "PIN de seguridad", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }

    /**
     * Metodo para generar e ingresar un carnet
     */
    void carnet() {
        try {
            GetInfo();
            System.out.println("Generando carnet: " + idpersonal);
            String id = String.valueOf(idpersonal);
            if (id.length() > 0 && id.length() < 2) {
                imprimirid = String.valueOf("000" + id);
            } else if (id.length() == 2 && id.length() < 3) {
                imprimirid = String.valueOf("00" + id);
            } else if (id.length() == 3 && id.length() < 4) {
                imprimirid = String.valueOf("0" + id);
            } else if (id.length() == 4 && id.length() < 5) {
                imprimirid = String.valueOf(id);
            }
            int year = YearMonth.now().getYear();
            String apellido = txtApellido.getText();
            char firstl = apellido.charAt(0);
            String nombre = txtNombre.getText();
            char firstn = nombre.charAt(0);
            nombres = String.valueOf(firstn);
            apellidos = String.valueOf(firstl);
            String carnetlocal = nombres + apellidos;
            String carnetlocal2 = year + imprimirid;
            String numerocarnet = carnetlocal + carnetlocal2;
            Carnet = numerocarnet;
            controllerp.Carnet = Carnet;
            controllerp.idpersonal = idpersonal;
            System.out.println(idpersonal);
            if (controllerp.IngresarCarnet() == false) {
                System.out.println("Su Carnet es: " + Carnet + " Se ingreso");

            }
        } catch (Exception e) {
            System.out.println("Error interno" + e.toString());
        }
    }
    
    /**
     * Metodo para obtener el IDPersonal para generar el carnet en ese registro
     */
    void GetInfo() {
        try {
            ResultSet rs = controlleru.ObtenerIdPersonal();
            if (rs.next()) {
                idpersonal = rs.getInt("idPersonal");
            }

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Metodo para obtener el IDPersonal
     */
    void GetIdPersonal() {
        try {
            ResultSet rs = controlleru.ObtenerIdPersonal();
            if (rs.next()) {
                idpersonal = rs.getInt("idPersonal");
                controlleru.idPersonal = idpersonal;
            }

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Metodo para obtener el IDEmpresa
     */
    void getIDEnterprise() {

        try {
            ResultSet rs = controllerp.ObteneridEmpresa();
            if (rs.next()) {
                controllerp.empresa = rs.getInt("idEmpresa");
            }

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }

    /**
     * Metodo para ingresar un personal
     */
    void InsercionPPersonal() {
        int anios = capfecha();
        if (controllerp.checkcontrollerPersonal() == false && controlleru.checkControllerUsuario() == false) {
            if (CmbTipoDocumento.getSelectedItem() == "" || CmbGenero.getSelectedItem() == "") {
                JOptionPane.showMessageDialog(null, "Escoja una opcion");
            } else if (txtNombre.getText().trim().isEmpty() || txtApellido.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || txtDirecion.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No se permiten campos vacios");

            } else if (anios < 18) {
                JOptionPane.showMessageDialog(null, "La persona que se esta ingresando debe ser mayor de edad", "Menor de edad", JOptionPane.WARNING_MESSAGE);
            } else if(! txtCorreo.getText().contains(".") || ! txtCorreo.getText().contains("@")){
                JOptionPane.showMessageDialog(null, "El correo electrónico ingresado no tiene un formato correcto", "Error de formato", JOptionPane.WARNING_MESSAGE);
            }else if((txtDocumento.getText().length() != 17 && tipodoc.equals("NIT")) || (txtDocumento.getText().length() != 10 && tipodoc.equals("DUI"))){
                JOptionPane.showMessageDialog(null, "El documento ingresado no tiene un formato correcto", "Error de formato", JOptionPane.WARNING_MESSAGE);
            }else{
                int mes=c.get(Calendar.MONTH)+1;
                String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + mes + "/" + c.get(Calendar.DAY_OF_MONTH));
                getIDEnterprise();
                controllerp.nombre = txtNombre.getText();
                controllerp.apellido = txtApellido.getText();
                controllerp.correo = txtCorreo.getText();
                controllerp.direccion = txtDirecion.getText();
                controllerp.dui = txtDocumento.getText();
                controllerp.idtipoDocumento = tipod;
                controllerp.idgenero = genero;
                controllerp.fechanac = nacimiento;
                if (controllerp.IngresarPPersonalController() == true) {
                    JOptionPane.showMessageDialog(null, "Su registro ha sido ingresado correctamente", "Proceso Completado", JOptionPane.INFORMATION_MESSAGE);
                    carnet();
                    BtnExaminar.setEnabled(true);
                    txtApellido.setEnabled(false);
                    txtCorreo.setEnabled(false);
                    txtDocumento.setEnabled(false);
                    txtNombre.setEnabled(false);
                    CmbGenero.setEnabled(false);
                    txtDirecion.setEnabled(false);
                    DtFechaNac.setEnabled(false);
                    CmbTipoDocumento.setEnabled(false);
                    btnContinuar.setVisible(false);
                    BtnGuardar.setVisible(true);
                    TxtUsuario.setEnabled(true);
                }
            }

        }
    }

    /**
     * Metodo para cargar los combobox
     */
    private void cargarlista() {
        CargarTipoDocumento();
        CargarGeneroPersonal();
    }

    /**
     * Metodo para cargar el comobobox de género
     */
    final void CargarGeneroPersonal() {
        ListGenero = new ArrayList();
        try {
            ResultSet rs = controllerp.cargarGeneroController();
            if (rs.next()) {
                modelcombogenero.addElement("");
                do {
                    ListGenero.add(rs.getInt("idGenero"));
                    modelcombogenero.addElement(rs.getString("genero"));
                    CmbGenero.setModel(modelcombogenero);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No existen datos sobre los generos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se logro cargar la informacion", "Error al cargar", JOptionPane.WARNING_MESSAGE);
        }
    }

    /**
     * Metodo para cargar el comobobox de los tipo de documento
     */
    final void CargarTipoDocumento() {
        myArrayList = new ArrayList();
        try {
            ResultSet rs = controllerp.cargarTipoDocumentoController();
            if (rs.next()) {
                modelocombo.addElement("");
                do {
                    myArrayList.add(rs.getInt("idTipoDocumento"));
                    modelocombo.addElement(rs.getString("tipo_documento"));
                    CmbTipoDocumento.setModel(modelocombo);
                } while (rs.next());
            } else {
                JOptionPane.showMessageDialog(null, "No existen datos sobre los tipos de documentos", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null, "No se lograron cargar los datos", "Error al cargar", JOptionPane.WARNING_MESSAGE);
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
        Logo = new Controles_Personalizados.Paneles.PanelRound();
        btnContinuar = new Controles_Personalizados.Botones.ButtonGradient();
        txtDocumento = new Controles_Personalizados.textfields.TextField();
        txtNombre = new Controles_Personalizados.textfields.TextField();
        txtApellido = new Controles_Personalizados.textfields.TextField();
        txtCorreo = new Controles_Personalizados.textfields.TextField();
        txtDirecion = new Controles_Personalizados.textfields.TextField();
        CmbGenero = new Controles_Personalizados.ComboBox.combobox();
        jLabel2 = new javax.swing.JLabel();
        LblFoto = new javax.swing.JLabel();
        BtnExaminar = new Controles_Personalizados.Botones.UWPButton();
        TxtUsuario = new Controles_Personalizados.textfields.TextField();
        CmbTipoDocumento = new Controles_Personalizados.ComboBox.combobox();
        LblFecha = new javax.swing.JLabel();
        BtnGuardar = new Controles_Personalizados.Botones.ButtonGradient();
        DtFechaNac = new com.toedter.calendar.JDateChooser();
        btnMinimizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1392, 842));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        PanelFondo.setBackground(new java.awt.Color(42, 36, 56));
        PanelFondo.setPreferredSize(new java.awt.Dimension(1366, 768));
        PanelFondo.setRequestFocusEnabled(false);
        PanelFondo.setRoundBottomLeft(40);
        PanelFondo.setRoundBottomRight(40);
        PanelFondo.setRoundTopLeft(40);
        PanelFondo.setRoundTopRight(40);
        PanelFondo.setVerifyInputWhenFocusTarget(false);
        PanelFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Logo.setBackground(new java.awt.Color(254, 254, 254));
        Logo.setToolTipText("");
        Logo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Logo.setPreferredSize(new java.awt.Dimension(698, 768));
        Logo.setRoundBottomLeft(35);
        Logo.setRoundTopLeft(35);
        Logo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnContinuar.setText("Continuar");
        btnContinuar.setToolTipText("");
        btnContinuar.setColor1(new java.awt.Color(42, 36, 56));
        btnContinuar.setColor2(new java.awt.Color(42, 36, 56));
        btnContinuar.setFont(new java.awt.Font("Roboto Black", 0, 18)); // NOI18N
        btnContinuar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContinuarActionPerformed(evt);
            }
        });
        Logo.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 780, 150, -1));

        txtDocumento.setBackground(new java.awt.Color(254, 254, 254));
        txtDocumento.setForeground(new java.awt.Color(42, 36, 56));
        txtDocumento.setCaretColor(new java.awt.Color(42, 36, 56));
        txtDocumento.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtDocumento.setLabelText("Documento ");
        txtDocumento.setLineColor(new java.awt.Color(42, 36, 56));
        txtDocumento.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        Logo.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 310, 70));

        txtNombre.setBackground(new java.awt.Color(254, 254, 254));
        txtNombre.setForeground(new java.awt.Color(42, 36, 56));
        txtNombre.setCaretColor(new java.awt.Color(42, 36, 56));
        txtNombre.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtNombre.setLabelText("Nombres");
        txtNombre.setLineColor(new java.awt.Color(42, 36, 56));
        txtNombre.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        Logo.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 310, 70));

        txtApellido.setBackground(new java.awt.Color(254, 254, 254));
        txtApellido.setForeground(new java.awt.Color(42, 36, 56));
        txtApellido.setCaretColor(new java.awt.Color(42, 36, 56));
        txtApellido.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtApellido.setLabelText("Apellidos");
        txtApellido.setLineColor(new java.awt.Color(42, 36, 56));
        txtApellido.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        Logo.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 310, 70));

        txtCorreo.setBackground(new java.awt.Color(254, 254, 254));
        txtCorreo.setForeground(new java.awt.Color(42, 36, 56));
        txtCorreo.setToolTipText("");
        txtCorreo.setCaretColor(new java.awt.Color(42, 36, 56));
        txtCorreo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtCorreo.setLabelText("Correo Electronico");
        txtCorreo.setLineColor(new java.awt.Color(42, 36, 56));
        txtCorreo.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtCorreoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        Logo.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 570, 310, 70));

        txtDirecion.setBackground(new java.awt.Color(254, 254, 254));
        txtDirecion.setForeground(new java.awt.Color(42, 36, 56));
        txtDirecion.setCaretColor(new java.awt.Color(42, 36, 56));
        txtDirecion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtDirecion.setLabelText("Direccion");
        txtDirecion.setLineColor(new java.awt.Color(42, 36, 56));
        txtDirecion.setSelectionColor(new java.awt.Color(58, 50, 75));
        txtDirecion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDirecionKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDirecionKeyTyped(evt);
            }
        });
        Logo.add(txtDirecion, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 310, 70));

        CmbGenero.setBackground(new java.awt.Color(254, 254, 254));
        CmbGenero.setForeground(new java.awt.Color(42, 36, 56));
        CmbGenero.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        CmbGenero.setLabeText("Genero");
        CmbGenero.setLineColor(new java.awt.Color(42, 36, 56));
        CmbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbGeneroItemStateChanged(evt);
            }
        });
        Logo.add(CmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 310, 80));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Foto (Opcional)");
        Logo.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));

        LblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        Logo.add(LblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 110, 220, 240));

        BtnExaminar.setBackground(new java.awt.Color(42, 36, 56));
        BtnExaminar.setText("Examinar");
        BtnExaminar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnExaminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnExaminarActionPerformed(evt);
            }
        });
        Logo.add(BtnExaminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 360, 220, 50));

        TxtUsuario.setBackground(new java.awt.Color(254, 254, 254));
        TxtUsuario.setForeground(new java.awt.Color(42, 36, 56));
        TxtUsuario.setToolTipText("");
        TxtUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        TxtUsuario.setLabelText("Usuario");
        TxtUsuario.setLineColor(new java.awt.Color(42, 36, 56));
        TxtUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TxtUsuarioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                TxtUsuarioKeyTyped(evt);
            }
        });
        Logo.add(TxtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 670, 310, 70));

        CmbTipoDocumento.setBackground(new java.awt.Color(254, 254, 254));
        CmbTipoDocumento.setForeground(new java.awt.Color(42, 36, 56));
        CmbTipoDocumento.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        CmbTipoDocumento.setLabeText("Tipo  Documento");
        CmbTipoDocumento.setLineColor(new java.awt.Color(42, 36, 56));
        CmbTipoDocumento.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoDocumentoItemStateChanged(evt);
            }
        });
        Logo.add(CmbTipoDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 560, 310, 80));

        LblFecha.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        LblFecha.setForeground(new java.awt.Color(153, 153, 153));
        LblFecha.setText("Fecha Nacimiento");
        Logo.add(LblFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, -1, -1));

        BtnGuardar.setBackground(new java.awt.Color(42, 36, 56));
        BtnGuardar.setText("Finalizar");
        BtnGuardar.setToolTipText("");
        BtnGuardar.setColor1(new java.awt.Color(42, 36, 56));
        BtnGuardar.setColor2(new java.awt.Color(42, 36, 56));
        BtnGuardar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGuardarActionPerformed(evt);
            }
        });
        Logo.add(BtnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 780, 150, 44));

        DtFechaNac.setBackground(new java.awt.Color(42, 36, 56));
        Logo.add(DtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 310, 50));

        PanelFondo.add(Logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 850));

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        PanelFondo.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 21, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        PanelFondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1350, 20, -1, -1));

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/PersonalImg.png"))); // NOI18N
        PanelFondo.add(Imagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 170, 500, 530));

        getContentPane().add(PanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1400, 850));

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
     * Metodo para minimizar la aplicación
     * @param evt 
     */
    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    /**
     * Metodo para cargar el tipo de documento segun su ID
     */
    void CargarIDT() { 
        ResultSet rs;
        controllerp.setIdtipoDocunmento(tipod);
        rs = controllerp.TipoDocumento();
        try {
            if (rs.next()) {
                tipodoc = rs.getString("tipo_documento");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    
    /**
     * Metodo para registrar el ID del registro que se encuentra seleccionado en el cmbTipoDocumento
     * @param evt 
     */
    private void CmbTipoDocumentoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbTipoDocumentoItemStateChanged
        // TODO add your handling code here:º
        tipodanterior = tipod;
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbTipoDocumento.getSelectedIndex();
            if (pos == 0) {
                tipod = 0;
            } else {
                int dim = myArrayList.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        tipod = (int) myArrayList.get(i);
                    }
                }
            }
            CargarIDT();
        }
        if(tipodanterior != tipod){
            txtDocumento.setText("");
        }
    }//GEN-LAST:event_CmbTipoDocumentoItemStateChanged

    /**
     * Metodo para registrar el ID del registro que se encuentra seleccionado en el cmbGenero
     * @param evt 
     */
    private void CmbGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbGeneroItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbGenero.getSelectedIndex();
            if (pos == 0) {
                genero = 0;
            } else {
                int dimgenero = ListGenero.size();
                for (int i = 0; i < dimgenero; i++) {
                    if (i == pos - 1) {
                        genero = (int) ListGenero.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbGeneroItemStateChanged

    /**
     * Metodo para activar la inserción del personal
     * @param evt 
     */
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        InsercionPPersonal();

    }//GEN-LAST:event_btnContinuarActionPerformed

    /**
     * Metodo para activar el proceso de guardado de imagen en el label
     * @param evt 
     */
    private void BtnExaminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnExaminarActionPerformed
        // TODO add your handling code here:
        ExaminarImagen();
    }//GEN-LAST:event_BtnExaminarActionPerformed

    /**
     * Metodo para activar la inserción del usuario
     * @param evt 
     */
    private void BtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnGuardarActionPerformed
        // TODO add your handling code here:
        if (TxtUsuario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Campos Vacios, verificar la informacion", "Campos Vacios", JOptionPane.WARNING_MESSAGE);
        } else {
            IngresarUsuario();
        }
    }//GEN-LAST:event_BtnGuardarActionPerformed

    /**
     * Metodo para validaciones del txtNombre
     * @param evt 
     */
    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    /**
     * Metodo para validaciones del txtNombre
     * @param evt 
     */
    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        ValidacionesSistema.ValidacionesBeep_Go.SoloLetras(evt);
        if(txtNombre.getText().length() >= 35){
            evt.consume();
        }else if(txtNombre.getText().length() == 0 && Character.isWhitespace(key)){
            evt.consume();
        }else if(txtNombre.getText().length() == 0 && ! Character.isUpperCase(key)){
            evt.consume();
        }else if(txtNombre.getText().length() > 0){
            String text = txtNombre.getText();
            String ultimo = text.substring(text.length() - 1);
            if(ultimo != null && ultimo.equals(" ") && (Character.isWhitespace(key) || !Character.isUpperCase(key))){
               evt.consume();
            }else if(ultimo != null && Character.isUpperCase(ultimo.charAt(0)) && !Character.isLowerCase(key) && !Character.isWhitespace(key)){
                evt.consume();
            }else if(ultimo != null && Character.isLowerCase(ultimo.charAt(0)) && !Character.isLowerCase(key) && !Character.isWhitespace(key)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    /**
     * Metodo para validaciones del txtApellido
     * @param evt 
     */
    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        ValidacionesSistema.ValidacionesBeep_Go.SoloLetras(evt);
        if(txtApellido.getText().length() >= 35){
            evt.consume();
        }else if(txtApellido.getText().length() == 0 && Character.isWhitespace(key)){
            evt.consume();
        }else if(txtApellido.getText().length() == 0 && ! Character.isUpperCase(key)){
            evt.consume();
        }else if(txtApellido.getText().length() > 0){
            String text = txtApellido.getText();
            String ultimo = text.substring(text.length() - 1);
            if(ultimo != null && ultimo.equals(" ") && (Character.isWhitespace(key) || !Character.isUpperCase(key))){
               evt.consume();
            }else if(ultimo != null && Character.isUpperCase(ultimo.charAt(0)) && !Character.isLowerCase(key) && !Character.isWhitespace(key)){
                evt.consume();
            }else if(ultimo != null && Character.isLowerCase(ultimo.charAt(0)) && !Character.isLowerCase(key) && !Character.isWhitespace(key)){
                evt.consume();
            }
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

    /**
     * Metodo para validaciones del txtApellido
     * @param evt 
     */
    private void txtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyPressed

    /**
     * Metodo para validaciones del txtDireccion
     * @param evt 
     */
    private void txtDirecionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirecionKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(txtDirecion.getText().length() >= 200){
            evt.consume();
        }else if(txtDirecion.getText().length() == 0 && Character.isWhitespace(key)){
            evt.consume();
        }else if(txtDirecion.getText().length() > 0){
            String text = txtDirecion.getText();
            String ultimo = text.substring(text.length() - 1);
            if(ultimo != null && ultimo.equals(" ") && Character.isWhitespace(key)){
               evt.consume();
            }   
        }
    }//GEN-LAST:event_txtDirecionKeyTyped

    /**
     * Metodo para validaciones del txtDireccion
     * @param evt 
     */
    private void txtDirecionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDirecionKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtDirecionKeyPressed

    /**
     * Metodo para validaciones del txtCorreo
     * @param evt 
     */
    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        // TODO add your handling code here:
        if(txtCorreo.getText().length() >= 60){
            evt.consume();
        }else{
            ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    /**
     * Metodo para validaciones del txtCorreo
     * @param evt 
     */
    private void txtCorreoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtCorreoKeyPressed

    /**
     * Metodo para validaciones del txtDocumento
     * @param evt 
     */
    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if(tipodoc != null){
            if(tipodoc.equals("NIT")){
                if(txtDocumento.getText().length() >= 17){
                    evt.consume();
                }else if(txtDocumento.getText().length() != 4 && txtDocumento.getText().length() != 11 && txtDocumento.getText().length() != 15 && key == '-'){
                    evt.consume();
                }else if((txtDocumento.getText().length() == 4 || txtDocumento.getText().length() == 11 || txtDocumento.getText().length() == 15) && key != '-'){
                    evt.consume();
                }else if(! Character.isDigit(key) && key != '-' ){
                    evt.consume();
                }
            }else if(tipodoc.equals("DUI")){
                if(txtDocumento.getText().length() >= 10){
                    evt.consume();
                }else if(txtDocumento.getText().length() == 8 && key != '-'){
                    evt.consume();
                }else if(! Character.isDigit(key) && key != '-' ){
                    evt.consume();
                }
            }
        }else{
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoKeyTyped

    /**
     * Metodo para validaciones del txtUsuario
     * @param evt 
     */
    private void TxtUsuarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUsuarioKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();
        if (TxtUsuario.getText().length() >= 15) {
            evt.consume();
        } else {
            if (TxtUsuario.getText().equals("") && car == 95) {
                evt.consume();
            } else if (TxtUsuario.getText().contains("_") && car == 95) {
                evt.consume();
            } else {
                ValidacionesSistema.ValidacionesBeep_Go.SinEspacios(evt);
                ValidacionesSistema.ValidacionesBeep_Go.SoloLetrasNumerosGuionBajo(evt);
            }
        }    
    }//GEN-LAST:event_TxtUsuarioKeyTyped

    /**
     * Metodo para validaciones del txtUsuario
     * @param evt 
     */
    private void TxtUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtUsuarioKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_TxtUsuarioKeyPressed

    /**
     * Metodo para validaciones del txtDocumento
     * @param evt 
     */
    private void txtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown())
        {
            evt.consume();
        }
    }//GEN-LAST:event_txtDocumentoKeyPressed

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
            java.util.logging.Logger.getLogger(FrmP_U_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmP_U_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmP_U_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmP_U_Personal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmP_U_Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Botones.UWPButton BtnExaminar;
    private Controles_Personalizados.Botones.ButtonGradient BtnGuardar;
    private Controles_Personalizados.ComboBox.combobox CmbGenero;
    private Controles_Personalizados.ComboBox.combobox CmbTipoDocumento;
    private com.toedter.calendar.JDateChooser DtFechaNac;
    private javax.swing.JLabel Imagen;
    private javax.swing.JLabel LblFecha;
    private javax.swing.JLabel LblFoto;
    private Controles_Personalizados.Paneles.PanelRound Logo;
    private Controles_Personalizados.Paneles.PanelRound PanelFondo;
    private Controles_Personalizados.textfields.TextField TxtUsuario;
    private javax.swing.JLabel btnCerrar;
    private Controles_Personalizados.Botones.ButtonGradient btnContinuar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel jLabel2;
    private Controles_Personalizados.textfields.TextField txtApellido;
    private Controles_Personalizados.textfields.TextField txtCorreo;
    private Controles_Personalizados.textfields.TextField txtDirecion;
    private Controles_Personalizados.textfields.TextField txtDocumento;
    private Controles_Personalizados.textfields.TextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
