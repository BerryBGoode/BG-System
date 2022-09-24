/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesSistema;

import java.awt.Event;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.awt.Font;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/**
 * This class stored the parameters and validations that will be used in the system.
 * @author danlo
 */
public class ValidacionesBeep_Go {
    
    public static int Modo;
    public static final Font font = new Font("Roboto Black", Font.PLAIN, 18);
    /**
     * Constructor
     */
    public ValidacionesBeep_Go() {
    }

    /**
     * Method to get the mode the application is in (dark or light mode)
     * @return an Integer
     */
    public static int getModo() {
        return Modo;
    }

    /**
     * Method to set the mode
     * @param Modo referring to the parameter that stored a value
     */
    public static void setModo(int Modo) {
        ValidacionesBeep_Go.Modo = Modo;
    }
    
    /**
     * Method to encrypt in SHA1
     * @param p String
     * @return a String
     */
    public static String SHA1(String p){
        String sha1 = null;       
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.reset();
	    digest.update(p.getBytes("utf8"));
            sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return sha1;
    }
    
    /**
     * Method to encrypt in SHA256
     * @param p String
     * @return a String
     */
    public static String SHA256(String p){
        String sha256 = null;       
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    digest.reset();
	    digest.update(p.getBytes("utf8"));
            sha256 = String.format("%064x", new BigInteger(1, digest.digest()));
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        return sha256;
    }
    
    /**
     * Method to encrypt in MD5
     * @param p String
     * @return a String
     */
    public static String MD5(String p){  
        try{
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(p.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            return hashtext;
        }catch(NoSuchAlgorithmException e){
            throw new RuntimeException(e);
        }
    }
    
    /**
     * Method to encode in base64
     * @param p String
     * @return a String
     */
    public static String EBase64(String p){
        String base64;
        base64 = Base64.getEncoder().encodeToString(p.getBytes());
        return base64;
    }   
    
    /**
     * Method to encrypt the password (bypassing SHA1, SHA256, base64, and MD5)
     * @param p String
     * @return a String (p)
     */
    public static String EncriptarContra(String p){
        String sha1 = SHA1(p);
        String sha2 = SHA256(sha1);
        String base64 = EBase64(sha2);
        String f = MD5(base64);
        return f;
    }
    
    /**
     * Method to decode a string in base64
     * @param p String
     * @return a String
     */
    public static String DBase64(String p){
        byte[] decoded = Base64.getDecoder().decode(p.getBytes());
        String base64 = new String(decoded, StandardCharsets.UTF_8);
        return base64;
    }
    
    /**
     * Method to validate that a jtextfield only accepts letters and numbers
     * @param evt event
     */
    public static void SoloLetrasYNumeros(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        if(Character.isLetter(car) || Character.isDigit(car)){

        }else{
            evt.consume();
        }
    }
    
    /**
     * Method to validate that a jtextfield only accepts letters, numbers, and the character '_'
     * @param evt event
     */
    public static void SoloLetrasNumerosGuionBajo(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        if(Character.isLetter(car) || Character.isDigit(car) || car == 95){

        }else{
            evt.consume();
        }
    }
    
    /**
     * Method to validate that a jtextfield only accepts letters
     * @param evt event
     */
    public static void SoloLetras(java.awt.event.KeyEvent evt){
        char car=evt.getKeyChar();
        if (Character.isLetter(car) || Character.isWhitespace(car)) {
            
        }else{
            evt.consume();
        }
    }
    
    /**
     * Method to validate that a jtextfield only accepts numbers
     * @param evt event
     */
    public static void SoloNumeros(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        if(Character.isDigit(car)){

        }else{
            evt.consume();
        }
    }
    
    /**
     * Method to validate that a jtextfield does not accept the space key
     * @param evt event
     */
    public static void SinEspacios(java.awt.event.KeyEvent evt){
        char key = evt.getKeyChar();

        if (Character.isSpace(key))
        {
            evt.consume();
        }
    }
    
    /**
     * Method to display a notification
     * @param encabezado header of the notification
     * @param mensaje message of the notification
     * @param tipo_mensaje type of notification 
     */
    public static void Notificacion(String encabezado, String mensaje, int tipo_mensaje){
        try{
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().createImage("some-icon.png");
            TrayIcon trayIcon = new TrayIcon(image, "Java AWT Tray Demo");
            trayIcon.setImageAutoSize(true);
            trayIcon.setToolTip("System tray icon demo");
            tray.add(trayIcon);
            
            if(tipo_mensaje == 1){
                trayIcon.displayMessage(encabezado, mensaje, MessageType.INFO);
            }else if(tipo_mensaje == 2){
                trayIcon.displayMessage(encabezado, mensaje, MessageType.ERROR);
            }else{
                trayIcon.displayMessage(encabezado, mensaje, MessageType.WARNING);
            }
        }catch(Exception ex){
            System.err.print(ex); 
        }
    }
}
