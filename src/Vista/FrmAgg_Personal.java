/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import Controlador.*;
import java.awt.event.ItemEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import org.omg.CORBA.DynamicImplementation;

/**
 *
 * @author ferna
 */
public class FrmAgg_Personal extends javax.swing.JFrame {

    private ControllerPersonal objControllerP = new ControllerPersonal();
    private int genero;
    private int tipodocu;
    private int tipopersonal;
    private int ID;
    private Calendar c;
    private String imprimirid;
    private String Carnet;
    private List Genero;
    private List TipoDoc;
    private List TipoP;
    private DefaultComboBoxModel modelgenero;
    private DefaultComboBoxModel modeltipodoc;
    private DefaultComboBoxModel modeltipop;
    private int idpersonales;
    private String nombres;
    private String apellidos;
    private Date ufecha;
    private int identpanel = PanelOpcionesPersonal.showinter;

    /**
     * Creates new form FrmAgg_Personal
     * @param idpersonal
     */
    public FrmAgg_Personal(int idpersonal) {
        try {
            initComponents();
            idpersonales = idpersonal;
            this.setLocationRelativeTo(null);
            Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
            AWTUtilities.setWindowShape(this, forma);
            btnContinuar.setVisible(false);
            BtnConfirmar.setVisible(true);
            CbGenerarCarnet.setVisible(false);
            setIconImage(Logo());
            cargarGenero();
            CargarTipoDoc();
            switch (identpanel) {
                case 1:
                    CmbTipoPersonal.setVisible(false);
                    txtNombres.setEditable(false);
                    txtNombres.setText(ValidacionesSistema.Parametros_Personal.getnombre_personal());
                    txtApellidos.setText(ValidacionesSistema.Parametros_Personal.getApellido_personal());
                    txtCorreo.setText(ValidacionesSistema.Parametros_Personal.getCorreo());
                    TxtDireccion.setText(ValidacionesSistema.Parametros_Personal.getDireccion());
                    txtDocumento.setText(ValidacionesSistema.Parametros_Personal.getDocumento());
                    SimpleDateFormat formatofercha = new SimpleDateFormat("yyyy-MM-dd");
                    String getfecha = ValidacionesSistema.Parametros_Personal.getFecha_nacimiento();
                    System.out.println(getfecha);
                    ufecha = formatofercha.parse(getfecha);
                    System.out.println(ufecha);
                    DtFechaPersonal.setDate(ufecha);
                    DtFechaPersonal.setEnabled(false);
                    CmbTipoDoc.setSelectedItem(ValidacionesSistema.Parametros_Personal.getTipoDocumento());
                    CmbGenero.setSelectedItem(ValidacionesSistema.Parametros_Personal.getGenero());
                    break;
                case 2:
                    CmbTipoPersonal.setVisible(true);
                    CargarTipoPersonal();
                    txtNombres.setEditable(false);
                    CmbGenero.setSelectedItem(ValidacionesSistema.Parametros_Personal.getGenero());
                    CmbTipoDoc.setSelectedItem(ValidacionesSistema.Parametros_Personal.getTipoDocumento());
                    CmbTipoPersonal.setSelectedItem(ValidacionesSistema.Parametros_Personal.getTipoPersonal());
                    txtNombres.setText(ValidacionesSistema.Parametros_Personal.getnombre_personal());
                    txtApellidos.setText(ValidacionesSistema.Parametros_Personal.getApellido_personal());
                    txtCorreo.setText(ValidacionesSistema.Parametros_Personal.getCorreo());
                    txtDocumento.setText(ValidacionesSistema.Parametros_Personal.getDocumento());
                    SimpleDateFormat formatofercha2 = new SimpleDateFormat("yyyy-MM-dd");
                    String getfecha2 = ValidacionesSistema.Parametros_Personal.getFecha_nacimiento();
                    System.out.println(getfecha2);
                    ufecha = formatofercha2.parse(getfecha2);
                    System.out.println(ufecha);
                    DtFechaPersonal.setDate(ufecha);
                    DtFechaPersonal.setEnabled(false);
                    TxtDireccion.setText(ValidacionesSistema.Parametros_Personal.getDireccion());
                    break;
            }
        } catch (ParseException ex) {
            Logger.getLogger(FrmAgg_Personal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FrmAgg_Personal() {
        initComponents();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 40, 40);
        AWTUtilities.setWindowShape(this, forma);
        setIconImage(Logo());
        BtnConfirmar.setVisible(false);
        btnContinuar.setVisible(true);
        CbGenerarCarnet.setVisible(true);
        cargarGenero();
        CargarTipoDoc();
        switch (identpanel) {
            case 1:
                CmbTipoPersonal.setVisible(false);
                break;
            case 2:
                CmbTipoPersonal.setVisible(true);
                CargarTipoPersonal();
                break;
        }
    }

    public Image Logo() {
        Image retvalue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Recursos_Proyecto/B&G Morado 2.png"));
        return retvalue;
    }

    private void cargarGenero() {
        Genero = new ArrayList();
        try {
            ResultSet rs = objControllerP.CargarGenero();
            if (rs.next()) {
                modelgenero = new DefaultComboBoxModel<>();
                modelgenero.addElement("");
                do {
                    Genero.add(rs.getInt("idGenero"));
                    modelgenero.addElement(rs.getString("genero"));
                    CmbGenero.setModel(modelgenero);
                } while (rs.next());
            } else {
                System.out.println("No existen campos de genero");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar cargar" + e.toString());
        }
    }

    private void CargarTipoDoc() {
        TipoDoc = new ArrayList();
        try {
            ResultSet rs = objControllerP.CargarTipoDoController();
            if (rs.next()) {
                modeltipodoc = new DefaultComboBoxModel<>();
                modeltipodoc.addElement("");
                do {
                    TipoDoc.add(rs.getInt("idTipoDocumento"));
                    modeltipodoc.addElement(rs.getString("tipo_documento"));
                    CmbTipoDoc.setModel(modeltipodoc);
                } while (rs.next());
            } else {
                System.out.println("No existen campos de genero");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar cargar" + e.toString());
        }
    }

    private void CargarTipoPersonal() {
        TipoP = new ArrayList();
        try {
            ResultSet rs = objControllerP.CargarTipoPersonalController();
            if (rs.next()) {
                modeltipop = new DefaultComboBoxModel<>();
                modeltipop.addElement("");
                do {
                    TipoP.add(rs.getInt("idTipoPersonal"));
                    modeltipop.addElement(rs.getString("tipo_personal"));
                    CmbTipoPersonal.setModel(modeltipop);
                } while (rs.next());
            } else {
                System.out.println("No existen campos de genero");
            }
        } catch (SQLException e) {
            System.out.println("Error al intentar cargar" + e.toString());
        }
    }

    void setIdEmpresa() {

        try {
            ResultSet rs = objControllerP.GetEmpresa();
            if (rs.next()) {
                objControllerP.idempresa = rs.getInt("idEmpresa");
            }

        } catch (SQLException exception) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al obtener los datos de la empresa", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }

    void capturarIDpersonal() {
        objControllerP.nombre = txtNombres.getText();
        ResultSet rs = objControllerP.capturaridpersonalcontroller();
        try {
            if (rs.next()) {
                ID = rs.getInt("idPersonal");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }

    }

    void IngresarProfesores() {
        int anios = capfecha();
        if (txtApellidos.getText().trim().isEmpty() || txtNombres.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || TxtDireccion.getText().trim().isEmpty() || CmbGenero.getSelectedItem() == "" || CmbTipoDoc.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(null, "Revisar si ha ingresado correctamente, la informacion solicitada", "Verficar campos", JOptionPane.WARNING_MESSAGE);
        } else if (anios < 18) {
            JOptionPane.showMessageDialog(null, "No, se permiten registros menores a 18 años de edad", "Menor de edad", JOptionPane.WARNING_MESSAGE);
        } else {
            int mes=c.get(Calendar.MONTH)+1;
            String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" + mes+ "/" + c.get(Calendar.DAY_OF_MONTH));
            objControllerP.nombre = txtNombres.getText();
            objControllerP.apellido = txtApellidos.getText();
            objControllerP.fechanac = nacimiento;
            objControllerP.direccion = TxtDireccion.getText();
            objControllerP.idgenero = genero;
            objControllerP.idtipoDoc = tipodocu;
            objControllerP.idTipoPersonal = tipopersonal;
            objControllerP.correo = txtCorreo.getText();
            objControllerP.documento = txtDocumento.getText();
            setIdEmpresa();
            if (objControllerP.IngresarProfesores() == true) {
                JOptionPane.showMessageDialog(null, "El registro del personal ha sido agregado", "Proceso Agregar", JOptionPane.INFORMATION_MESSAGE);
                if (CbGenerarCarnet.isSelected()) {
                    if (txtApellidos.getText().trim().isEmpty() || txtNombres.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || TxtDireccion.getText().trim().isEmpty() || CmbGenero.getSelectedItem() == "" || CmbTipoDoc.getSelectedItem() == "") {
                        JOptionPane.showMessageDialog(null, "Revisar si ha ingresado correctamente, la informacion solicitada", "Verficar campos", JOptionPane.WARNING_MESSAGE);
                        CbGenerarCarnet.setSelected(false);
                    } else {
                        AgregarCarnet();
                    }

                }
            }
        }
    }

    private int capfecha() {
        Date date = DtFechaPersonal.getDate();
        c = new GregorianCalendar();
        c.setTime(date);
        Calendar hoy = Calendar.getInstance();
        int Anio = hoy.get(Calendar.YEAR) - c.get(Calendar.YEAR);
        int mes = hoy.get(Calendar.MONTH) - c.get(Calendar.MONTH);
        int dia = hoy.get(Calendar.DAY_OF_MONTH) - c.get(Calendar.DAY_OF_MONTH);
        if (mes < 0 || mes == 0 && dia < 0) {
            Anio = Anio -1;
        }
        return Anio;
    }

    void carnet() {
        try {
            capturarIDpersonal();
            String id = String.valueOf(ID);
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
            String apellido = txtApellidos.getText();
            char firstl = apellido.charAt(0);
            String nombre = txtNombres.getText();
            char firstn = nombre.charAt(0);
            nombres = String.valueOf(firstn);
            apellidos = String.valueOf(firstl);
            String carnetlocal = nombres + apellidos;
            String carnetlocal2 = year + imprimirid;
            String numerocarnet = carnetlocal + carnetlocal2;
            Carnet = numerocarnet;
            objControllerP.Carnet = Carnet;
            objControllerP.idpersonal = ID;
        } catch (Exception e) {
            System.out.println("Error interno" + e.toString());
        }
    }

    void IngreasrEstudiante() {
        int anios = capfecha();
        if (txtApellidos.getText().trim().isEmpty() || txtNombres.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || TxtDireccion.getText().trim().isEmpty() || CmbGenero.getSelectedItem() == "" || CmbTipoDoc.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(null, "Revisar si ha ingresado correctamente, la informacion solicitada", "Verficar campos", JOptionPane.WARNING_MESSAGE);
        } else if (anios < 11) {
            JOptionPane.showMessageDialog(null, "La edad del estudiante, debe coincidir con las edades permitidas por el MINED", "Verficar Edad", JOptionPane.WARNING_MESSAGE);
        } else {
            int mes=c.get(Calendar.MONTH)+1;
            String nacimiento = String.valueOf(c.get(Calendar.YEAR) + "/" +mes + "/" + c.get(Calendar.DAY_OF_MONTH));
            objControllerP.nombre = txtNombres.getText();
            objControllerP.apellido = txtApellidos.getText();
            objControllerP.fechanac = nacimiento;
            objControllerP.direccion = TxtDireccion.getText();
            objControllerP.documento = txtDocumento.getText();
            objControllerP.correo = txtCorreo.getText();
            setIdEmpresa();
            objControllerP.idgenero = genero;
            objControllerP.idtipoDoc = tipodocu;
            if (objControllerP.IngresarEstudiante() == true) {
                JOptionPane.showMessageDialog(null, "El registro fue agregado", "Proceso de agregar", JOptionPane.INFORMATION_MESSAGE);
                if (CbGenerarCarnet.isSelected()) {
                    if (txtApellidos.getText().trim().isEmpty() || txtNombres.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || TxtDireccion.getText().trim().isEmpty() || CmbGenero.getSelectedItem() == "" || CmbTipoDoc.getSelectedItem() == "") {
                        JOptionPane.showMessageDialog(null, "Revisar si ha ingresado correctamente, la informacion solicitada", "Verficar campos", JOptionPane.WARNING_MESSAGE);
                        CbGenerarCarnet.setSelected(false);
                    } else {
                        AgregarCarnet();
                    }

                }
            }
        }

    }

    void ActualizarEstudiante() {
        if (txtApellidos.getText().trim().isEmpty() || txtNombres.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || TxtDireccion.getText().trim().isEmpty() || CmbGenero.getSelectedItem() == "" || CmbTipoDoc.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(null, "Revisar si ha ingresado correctamente, la informacion solicitada", "Verficar campos", JOptionPane.WARNING_MESSAGE);
        } else {
            objControllerP.idpersonal = idpersonales;
            objControllerP.nombre = txtNombres.getText();
            objControllerP.apellido = txtApellidos.getText();
            objControllerP.correo = txtCorreo.getText();
            objControllerP.documento = txtDocumento.getText();
            objControllerP.direccion = TxtDireccion.getText();
            objControllerP.idgenero = genero;
            objControllerP.idtipoDoc = tipodocu;
            setIdEmpresa();
            if (objControllerP.ActualizarEstudiantesController() == true) {
                JOptionPane.showMessageDialog(null, "Proceso Completado", "Registro Actulizado", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                System.out.println("Error al actualizar");
            }
        }

    }

    void ActualizarPersonal() {
        if (txtApellidos.getText().trim().isEmpty() || txtNombres.getText().trim().isEmpty() || txtDocumento.getText().trim().isEmpty() || txtCorreo.getText().trim().isEmpty() || TxtDireccion.getText().trim().isEmpty() || CmbGenero.getSelectedItem() == "" || CmbTipoDoc.getSelectedItem() == "") {
            JOptionPane.showMessageDialog(null, "Revisar si ha ingresado correctamente, la informacion solicitada", "Verficar campos", JOptionPane.WARNING_MESSAGE);
        } else {
            objControllerP.idpersonal = idpersonales;
            objControllerP.nombre = txtNombres.getText();
            objControllerP.apellido = txtApellidos.getText();
            objControllerP.correo = txtCorreo.getText();
            objControllerP.documento = txtDocumento.getText();
            objControllerP.direccion = TxtDireccion.getText();
            //objControllerP.fechanac = DtFechaPersonal.getFechaSeleccionada();
            objControllerP.idgenero = genero;
            objControllerP.idtipoDoc = tipodocu;
            objControllerP.idTipoPersonal = tipopersonal;
            setIdEmpresa();
            if (objControllerP.ActualizarPersonalControiller() == true) {
                JOptionPane.showMessageDialog(null, "Proceso Completado", "Registro Actulizado", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                System.out.println("Error al actualizar");
            }
        }
    }

    private boolean AgregarCarnet() {
        try {
            carnet();
            if (objControllerP.AgregarCarnetController() == true) {
                System.out.println("Su carnet ha sido ingresado");
                System.out.println(Carnet);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    void ValidarMetodos() {
        switch (PanelOpcionesPersonal.showinter) {
            case 2:
                IngresarProfesores();
                break;
            case 1:
                IngreasrEstudiante();
                break;
            default:
                break;
        }
    }

    void ValidarActualizar() {
        switch (PanelOpcionesPersonal.showinter) {
            case 2:
                ActualizarPersonal();
                break;
            case 1:
                ActualizarEstudiante();
                break;
            default:
                break;
        }
    }
    public int typestaff;//if type is 1, is a employee or teacher
    //and if type is 2, is a student

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        btnCerrar = new javax.swing.JLabel();
        btnMinimizar = new javax.swing.JLabel();
        txtCorreo = new Controles_Personalizados.textfields.TextField();
        txtApellidos = new Controles_Personalizados.textfields.TextField();
        txtNombres = new Controles_Personalizados.textfields.TextField();
        txtDocumento = new Controles_Personalizados.textfields.TextField();
        CmbGenero = new Controles_Personalizados.ComboBox.combobox();
        TxtDireccion = new Controles_Personalizados.textfields.TextField();
        jLabel1 = new javax.swing.JLabel();
        btnContinuar = new Controles_Personalizados.Botones.ButtonGradient();
        CmbTipoDoc = new Controles_Personalizados.ComboBox.combobox();
        jLabel2 = new javax.swing.JLabel();
        CmbTipoPersonal = new Controles_Personalizados.ComboBox.combobox();
        BtnConfirmar = new Controles_Personalizados.Botones.ButtonGradient();
        CbGenerarCarnet = new javax.swing.JCheckBox();
        DtFechaPersonal = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(58, 50, 75));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1099, 578));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setForeground(new java.awt.Color(58, 50, 75));
        panelRound1.setAlignmentX(0.0F);
        panelRound1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        panelRound1.setPreferredSize(new java.awt.Dimension(1080, 540));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        panelRound1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 11, -1, -1));

        txtCorreo.setBackground(new java.awt.Color(58, 50, 75));
        txtCorreo.setForeground(new java.awt.Color(253, 255, 254));
        txtCorreo.setCaretColor(new java.awt.Color(253, 255, 254));
        txtCorreo.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtCorreo.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtCorreo.setLabelText("Correo");
        txtCorreo.setLineColor(new java.awt.Color(253, 255, 254));
        txtCorreo.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtCorreo.setSelectionColor(new java.awt.Color(253, 255, 254));
        panelRound1.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 310, 70));

        txtApellidos.setBackground(new java.awt.Color(58, 50, 75));
        txtApellidos.setForeground(new java.awt.Color(253, 255, 254));
        txtApellidos.setCaretColor(new java.awt.Color(253, 255, 254));
        txtApellidos.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtApellidos.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtApellidos.setLabelText("Apellidos");
        txtApellidos.setLineColor(new java.awt.Color(253, 255, 254));
        txtApellidos.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtApellidos.setSelectionColor(new java.awt.Color(253, 255, 254));
        txtApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidosKeyTyped(evt);
            }
        });
        panelRound1.add(txtApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 310, 70));

        txtNombres.setBackground(new java.awt.Color(58, 50, 75));
        txtNombres.setForeground(new java.awt.Color(253, 255, 254));
        txtNombres.setCaretColor(new java.awt.Color(253, 255, 254));
        txtNombres.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtNombres.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtNombres.setLabelText("Nombres");
        txtNombres.setLineColor(new java.awt.Color(253, 255, 254));
        txtNombres.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtNombres.setSelectionColor(new java.awt.Color(253, 255, 254));
        txtNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombresActionPerformed(evt);
            }
        });
        txtNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombresKeyTyped(evt);
            }
        });
        panelRound1.add(txtNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 310, 70));

        txtDocumento.setBackground(new java.awt.Color(58, 50, 75));
        txtDocumento.setForeground(new java.awt.Color(253, 255, 254));
        txtDocumento.setCaretColor(new java.awt.Color(253, 255, 254));
        txtDocumento.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtDocumento.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtDocumento.setLabelText("Documento");
        txtDocumento.setLineColor(new java.awt.Color(253, 255, 254));
        txtDocumento.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtDocumento.setSelectionColor(new java.awt.Color(253, 255, 254));
        txtDocumento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDocumentoKeyTyped(evt);
            }
        });
        panelRound1.add(txtDocumento, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 310, 70));

        CmbGenero.setBackground(new java.awt.Color(58, 50, 75));
        CmbGenero.setForeground(new java.awt.Color(255, 255, 255));
        CmbGenero.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        CmbGenero.setLabeText("Genero");
        CmbGenero.setLineColor(new java.awt.Color(253, 255, 254));
        CmbGenero.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbGeneroItemStateChanged(evt);
            }
        });
        panelRound1.add(CmbGenero, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 310, 70));

        TxtDireccion.setBackground(new java.awt.Color(58, 50, 75));
        TxtDireccion.setForeground(new java.awt.Color(253, 255, 254));
        TxtDireccion.setCaretColor(new java.awt.Color(253, 255, 254));
        TxtDireccion.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        TxtDireccion.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        TxtDireccion.setLabelText("Dirección");
        TxtDireccion.setLineColor(new java.awt.Color(253, 255, 254));
        TxtDireccion.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        TxtDireccion.setSelectionColor(new java.awt.Color(253, 255, 254));
        panelRound1.add(TxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 30, 310, 70));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/PersonalImgAdd.png"))); // NOI18N
        jLabel1.setPreferredSize(new java.awt.Dimension(301, 300));
        panelRound1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 130, 360, 350));

        btnContinuar.setBackground(new java.awt.Color(42, 36, 56));
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
        panelRound1.add(btnContinuar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 150, -1));

        CmbTipoDoc.setBackground(new java.awt.Color(58, 50, 75));
        CmbTipoDoc.setForeground(new java.awt.Color(255, 255, 255));
        CmbTipoDoc.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CmbTipoDoc.setLabeText("Tipo Documento");
        CmbTipoDoc.setLineColor(new java.awt.Color(253, 255, 254));
        CmbTipoDoc.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoDocItemStateChanged(evt);
            }
        });
        panelRound1.add(CmbTipoDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 220, 310, 80));

        jLabel2.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(253, 255, 255));
        jLabel2.setText("Fecha Nacimiento");
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        CmbTipoPersonal.setBackground(new java.awt.Color(58, 50, 75));
        CmbTipoPersonal.setForeground(new java.awt.Color(255, 255, 255));
        CmbTipoPersonal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CmbTipoPersonal.setLabeText("Tipo Personal");
        CmbTipoPersonal.setLineColor(new java.awt.Color(253, 255, 254));
        CmbTipoPersonal.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                CmbTipoPersonalItemStateChanged(evt);
            }
        });
        panelRound1.add(CmbTipoPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 320, 310, 70));

        BtnConfirmar.setForeground(new java.awt.Color(58, 50, 75));
        BtnConfirmar.setText("Confirmar");
        BtnConfirmar.setColor1(new java.awt.Color(253, 255, 254));
        BtnConfirmar.setColor2(new java.awt.Color(253, 255, 254));
        BtnConfirmar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        BtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnConfirmarActionPerformed(evt);
            }
        });
        panelRound1.add(BtnConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 520, 150, 44));

        CbGenerarCarnet.setBackground(new java.awt.Color(58, 50, 75));
        CbGenerarCarnet.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        CbGenerarCarnet.setForeground(new java.awt.Color(253, 255, 255));
        CbGenerarCarnet.setText("Generar Carné ");
        CbGenerarCarnet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbGenerarCarnetActionPerformed(evt);
            }
        });
        panelRound1.add(CbGenerarCarnet, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 490, -1, -1));

        DtFechaPersonal.setBackground(new java.awt.Color(42, 36, 56));
        DtFechaPersonal.setDateFormatString("yyyy-MM-dd");
        DtFechaPersonal.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        DtFechaPersonal.setMaxSelectableDate(new java.util.Date(253370790119000L));
        panelRound1.add(DtFechaPersonal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 310, 50));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1100, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        this.dispose();
    }//GEN-LAST:event_btnCerrarMousePressed
    public static boolean esMayuscula(String s) {
        return s.equals(s.toUpperCase());
    }
    private void btnContinuarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContinuarActionPerformed
        // TODO add your handling code here:
        ValidarMetodos();
        this.dispose();
    }//GEN-LAST:event_btnContinuarActionPerformed

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void BtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnConfirmarActionPerformed
        // TODO add your handling code here:
        ValidarActualizar();

    }//GEN-LAST:event_BtnConfirmarActionPerformed

    private void CmbTipoPersonalItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbTipoPersonalItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbTipoPersonal.getSelectedIndex();
            if (pos == 0) {
                tipopersonal = 0;
            } else {
                int dim = TipoP.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        tipopersonal = (int) TipoP.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbTipoPersonalItemStateChanged

    private void CmbTipoDocItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbTipoDocItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbTipoDoc.getSelectedIndex();
            if (pos == 0) {
                tipodocu = 0;
            } else {
                int dim = TipoDoc.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        tipodocu = (int) TipoDoc.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbTipoDocItemStateChanged

    private void CmbGeneroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_CmbGeneroItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            int pos = CmbGenero.getSelectedIndex();
            if (pos == 0) {
                genero = 0;
            } else {
                int dim = Genero.size();
                for (int i = 0; i < dim; i++) {
                    if (i == pos - 1) {
                        genero = (int) Genero.get(i);
                    }
                }
            }
        }
    }//GEN-LAST:event_CmbGeneroItemStateChanged

    private void txtDocumentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyPressed
        // TODO add your handling code here:

    }//GEN-LAST:event_txtDocumentoKeyPressed

    private void txtDocumentoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDocumentoKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        ValidacionesSistema.ValidacionesBeep_Go.SoloNumeros(evt);
    }//GEN-LAST:event_txtDocumentoKeyTyped

    private void txtNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombresKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        try {
            ValidacionesSistema.ValidacionesBeep_Go.SoloLetras(evt);
            if (txtNombres.getText().length() >= 75) {
                evt.consume();
            } else if (txtNombres.getText().length() == 0 && !Character.isUpperCase(key)) {
                evt.consume();
            } else if (txtNombres.getText().contains(" ") && Character.isWhitespace(key)) {
                evt.consume();
            } else {
                String capnombre = txtNombres.getText();
                String ultimo = capnombre.substring(capnombre.length() - 1);
                if (ultimo.equals(" ") && !Character.isUpperCase(key)) {
                    evt.consume();
                }
            }
        } catch (Exception e) {

        }
    }//GEN-LAST:event_txtNombresKeyTyped

    private void txtApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidosKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        try {
            ValidacionesSistema.ValidacionesBeep_Go.SoloLetras(evt);
            if (txtApellidos.getText().length() >= 75) {
                evt.consume();
            } else if (txtApellidos.getText().length() == 0 && !Character.isUpperCase(key)) {
                evt.consume();
            } else if (txtApellidos.getText().contains(" ") && Character.isWhitespace(key)) {
                evt.consume();
            } else {
                String capapellido = txtApellidos.getText();
                String ultimo = capapellido.substring(capapellido.length() - 1);
                if (ultimo.equals(" ") && !Character.isUpperCase(key)) {
                    evt.consume();
                }
            }
        } catch (Exception e) {

        }

    }//GEN-LAST:event_txtApellidosKeyTyped

    private void txtNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombresActionPerformed

    private void CbGenerarCarnetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbGenerarCarnetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbGenerarCarnetActionPerformed

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
            java.util.logging.Logger.getLogger(FrmAgg_Personal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Personal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Personal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmAgg_Personal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmAgg_Personal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Controles_Personalizados.Botones.ButtonGradient BtnConfirmar;
    private javax.swing.JCheckBox CbGenerarCarnet;
    private Controles_Personalizados.ComboBox.combobox CmbGenero;
    private Controles_Personalizados.ComboBox.combobox CmbTipoDoc;
    private Controles_Personalizados.ComboBox.combobox CmbTipoPersonal;
    private com.toedter.calendar.JDateChooser DtFechaPersonal;
    private Controles_Personalizados.textfields.TextField TxtDireccion;
    private javax.swing.JLabel btnCerrar;
    private Controles_Personalizados.Botones.ButtonGradient btnContinuar;
    private javax.swing.JLabel btnMinimizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.textfields.TextField txtApellidos;
    private Controles_Personalizados.textfields.TextField txtCorreo;
    private Controles_Personalizados.textfields.TextField txtDocumento;
    private Controles_Personalizados.textfields.TextField txtNombres;
    // End of variables declaration//GEN-END:variables
}
