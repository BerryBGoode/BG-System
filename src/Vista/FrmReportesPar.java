/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.ControllerConexion;
import Controlador.ControllerReportes;
import com.sun.awt.AWTUtilities;
import java.awt.Image;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Rober
 */
public class FrmReportesPar extends javax.swing.JFrame {

    /**
     * Creates new form FrmReportesPar
     */
    String reportedir;
    String nombre;
    ControllerReportes objcontroller = new ControllerReportes();

    public FrmReportesPar() {
        initComponents();
    }

    public FrmReportesPar(String form, String buscador) {
        initComponents();
        this.setTitle("Reporte - " + form);
        lblForm.setText(form);
        txtPar.setLabelText(buscador);
        nombre = form;
        setLocationRelativeTo(null);
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

        panelRound1 = new Controles_Personalizados.Paneles.PanelRound();
        btnMinimizar = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JLabel();
        lblForm = new javax.swing.JLabel();
        lblReportes = new javax.swing.JLabel();
        txtPar = new Controles_Personalizados.textfields.TextField();
        lblImg = new javax.swing.JLabel();
        btnReporte = new Controles_Personalizados.Botones.ButtonGradient();
        btnGrafico = new Controles_Personalizados.Botones.ButtonGradient();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(58, 50, 75));
        panelRound1.setPreferredSize(new java.awt.Dimension(672, 384));
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnMinimizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Maximizar.png"))); // NOI18N
        btnMinimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnMinimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnMinimizarMouseClicked(evt);
            }
        });
        panelRound1.add(btnMinimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 10, -1, -1));

        btnCerrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/CerrarLogin.png"))); // NOI18N
        btnCerrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCerrarMousePressed(evt);
            }
        });
        panelRound1.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 10, -1, -1));

        lblForm.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        lblForm.setForeground(new java.awt.Color(253, 255, 254));
        lblForm.setText("A");
        panelRound1.add(lblForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        lblReportes.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        lblReportes.setForeground(new java.awt.Color(253, 255, 254));
        lblReportes.setText("Reportes -");
        panelRound1.add(lblReportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 210, 80));
        lblReportes.getAccessibleContext().setAccessibleName("");

        txtPar.setBackground(new java.awt.Color(58, 50, 75));
        txtPar.setForeground(new java.awt.Color(254, 254, 254));
        txtPar.setCaretColor(new java.awt.Color(253, 255, 254));
        txtPar.setDisabledTextColor(new java.awt.Color(253, 255, 254));
        txtPar.setFont(new java.awt.Font("Roboto Light", 0, 18)); // NOI18N
        txtPar.setLabelText("Pruebaxd");
        txtPar.setLineColor(new java.awt.Color(253, 255, 254));
        txtPar.setSelectedTextColor(new java.awt.Color(58, 50, 75));
        txtPar.setSelectionColor(new java.awt.Color(253, 255, 254));
        txtPar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtParKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtParKeyTyped(evt);
            }
        });
        panelRound1.add(txtPar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 340, 70));

        lblImg.setFont(new java.awt.Font("Roboto Medium", 0, 30)); // NOI18N
        lblImg.setForeground(new java.awt.Color(253, 255, 254));
        lblImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos_Proyecto/Reportes.png"))); // NOI18N
        panelRound1.add(lblImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, -1, 290));

        btnReporte.setBackground(new java.awt.Color(253, 255, 254));
        btnReporte.setForeground(new java.awt.Color(58, 50, 75));
        btnReporte.setText("Generar reporte");
        btnReporte.setColor1(new java.awt.Color(253, 255, 254));
        btnReporte.setColor2(new java.awt.Color(253, 255, 254));
        btnReporte.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReporteActionPerformed(evt);
            }
        });
        panelRound1.add(btnReporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 180, 50));

        btnGrafico.setBackground(new java.awt.Color(253, 255, 254));
        btnGrafico.setForeground(new java.awt.Color(58, 50, 75));
        btnGrafico.setText("Generar gráfico");
        btnGrafico.setColor1(new java.awt.Color(253, 255, 254));
        btnGrafico.setColor2(new java.awt.Color(253, 255, 254));
        btnGrafico.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnGrafico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGraficoActionPerformed(evt);
            }
        });
        panelRound1.add(btnGrafico, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 270, 180, 50));

        getContentPane().add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMinimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnMinimizarMouseClicked
        // TODO add your handling code here:
        this.setExtendedState(JFrame.ICONIFIED);
    }//GEN-LAST:event_btnMinimizarMouseClicked

    private void btnCerrarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMousePressed
        this.dispose();
    }//GEN-LAST:event_btnCerrarMousePressed

    private void txtParKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParKeyPressed
        // TODO add your handling code here:
        if (evt.isControlDown() || evt.isShiftDown()) {
            evt.consume();
        }
    }//GEN-LAST:event_txtParKeyPressed

    private void txtParKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtParKeyTyped
        // TODO add your handling code here:
        char key = evt.getKeyChar();
        if (nombre.equals("Accesos")) {
            if (txtPar.getText().length() >= 10) {
                evt.consume();
            } else if (txtPar.getText().length() != 4 && txtPar.getText().length() != 7 && key == '-') {
                evt.consume();
            } else if ((txtPar.getText().length() == 4 || txtPar.getText().length() == 7) && key != '-') {
                evt.consume();
            } else if (!Character.isDigit(key) && key != '-') {
                evt.consume();
            }
        } else {
            if (txtPar.getText().length() >= 30) {
                evt.consume();
            } else if (txtPar.getText().length() == 0 && Character.isWhitespace(key)) {
                evt.consume();
            } else if (txtPar.getText().length() > 0) {
                String text = txtPar.getText();
                String ultimo = text.substring(text.length() - 1);
                if (ultimo != null && ultimo.equals(" ") && Character.isWhitespace(key)) {
                    evt.consume();
                }
            }
        }
    }//GEN-LAST:event_txtParKeyTyped

    void ReportePar(String par) {
        try {
            Connection con = ControllerConexion.getConnectionModel();
            JasperReport reporte = null;

            String dir = reportedir;
            Map parametros = new HashMap();
            parametros.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            if (!par.equals(null)) {
                parametros.put("Parametro", par);
            }
            parametros.put("TextoFooter", "src\\Recursos_Proyecto\\TextoLogin.png");
            reporte = (JasperReport) JRLoader.loadObjectFromFile(dir);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    void Reporte(String dir) {
        try {
            Connection con = ControllerConexion.getConnectionModel();
            JasperReport reporte = null;

            Map parametros = new HashMap();
            parametros.put("Logo", "src\\Recursos_Proyecto\\LogoB&GLogin.png");
            parametros.put("TextoFooter", "src\\Recursos_Proyecto\\TextoLogin.png");
            reporte = (JasperReport) JRLoader.loadObjectFromFile(dir);

            JasperPrint jprint = JasperFillManager.fillReport(reporte, parametros, con);

            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.toString());
        }
    }

    void HacerReporte() {
        if (nombre.equals("Usuarios")) {
            objcontroller.setParam(txtPar.getText());
            boolean respuesta1U = objcontroller.BuscarEstadoUsuario();
            boolean respuesta2U = objcontroller.BuscarTipoUsuario();
            if (respuesta1U == true || respuesta2U == true) {
                reportedir = "src\\DocsReport\\UsuariosReportPar.jasper";
                ReportePar(txtPar.getText());
                txtPar.setText("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No existen registros para mostrar", "Parametro inválido", JOptionPane.WARNING_MESSAGE);
                txtPar.setText("");
            }
        } else if (nombre.equals("Estudiantes")) {
            objcontroller.setParam(txtPar.getText());
            boolean respuesta = objcontroller.BuscarGenero();
            if (respuesta == true) {
                reportedir = "src\\DocsReport\\EstudianteReportePar.jasper";
                ReportePar(txtPar.getText());
                txtPar.setText("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No existen registros para mostrar", "Parametro inválido", JOptionPane.WARNING_MESSAGE);
                txtPar.setText("");
            }
        } else if (nombre.equals("Personal")) {
            objcontroller.setParam(txtPar.getText());
            boolean respuesta1P = objcontroller.BuscarTipoPersonal();
            boolean respuesta2P = objcontroller.BuscarGeneroP();
            if (respuesta1P == true || respuesta2P == true) {
                reportedir = "src\\DocsReport\\PersonalReportePar.jasper";
                ReportePar(txtPar.getText());
                txtPar.setText("");
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "No existen registros para mostrar", "Parametro inválido", JOptionPane.WARNING_MESSAGE);
                txtPar.setText("");
            }
        } else if (nombre.equals("Vehiculos")) {
            objcontroller.setParam(txtPar.getText());
            boolean respuestavh = objcontroller.BuscarVehiculosPersonal();
            if (respuestavh == true) {
                reportedir = "src\\DocsReport\\VehiculosParReporte1.jasper";
                ReportePar(txtPar.getText());
                txtPar.setText("");
                this.dispose();
            } else {
                txtPar.setText("");
                JOptionPane.showMessageDialog(this, "No existen registros para mostrar", "Parametro inválido", JOptionPane.WARNING_MESSAGE);
            }
        } else if (nombre.equals("Contactos")) {
            objcontroller.setParam(txtPar.getText());
            boolean respuestact = objcontroller.BuscarContactosPersonal();
            if (respuestact == true) {
                reportedir = "src\\DocsReport\\ContactosPar1.jasper";
                ReportePar(txtPar.getText());
                txtPar.setText("");
                this.dispose();
            } else {
                txtPar.setText("");
                JOptionPane.showMessageDialog(this, "No existen registros para mostrar", "Parametro inválido", JOptionPane.WARNING_MESSAGE);
            }
        } else if (nombre.equals("Accesos")) {
            objcontroller.setParam(txtPar.getText());
            boolean respuestaacc = objcontroller.BuscarAccesos();
            if (respuestaacc == true) {
                reportedir = "src\\DocsReport\\AccesosPar.jasper";
                ReportePar(txtPar.getText());
                txtPar.setText("");
                this.dispose();
            } else {
                txtPar.setText("");
                JOptionPane.showMessageDialog(this, "No existen registros para mostrar", "Parametro inválido", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    private void btnReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReporteActionPerformed
        // TODO add your handling code here:
        HacerReporte();
    }//GEN-LAST:event_btnReporteActionPerformed

    private void btnGraficoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGraficoActionPerformed
        // TODO add your handling code here:
        if (nombre.equals("Usuarios")) {
            Reporte("src\\DocsReport\\ReporteUsuariosGraph.jasper");
        } else if (nombre.equals("Personal")) {
            Reporte("src\\DocsReport\\PersonalReporteGraph.jasper");
        } else if (nombre.equals("Estudiantes")) {
            Reporte("src\\DocsReport\\EstudianteReporteGraph.jasper");
        } else if (nombre.equals("Vehiculos")) {
            Reporte("src\\DocsReport\\VehiculosGraph1.jasper");
        } else if (nombre.equals("Contactos")) {
            Reporte("src\\DocsReport\\ContactosGraph1.jasper");
        } else if (nombre.equals("Accesos")) {
            Reporte("src\\DocsReport\\AccesosGraph.jasper");
        }
        this.dispose();
    }//GEN-LAST:event_btnGraficoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReportesPar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReportesPar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReportesPar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReportesPar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReportesPar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCerrar;
    private Controles_Personalizados.Botones.ButtonGradient btnGrafico;
    private javax.swing.JLabel btnMinimizar;
    private Controles_Personalizados.Botones.ButtonGradient btnReporte;
    private javax.swing.JLabel lblForm;
    private javax.swing.JLabel lblImg;
    private javax.swing.JLabel lblReportes;
    private Controles_Personalizados.Paneles.PanelRound panelRound1;
    private Controles_Personalizados.textfields.TextField txtPar;
    // End of variables declaration//GEN-END:variables
}
