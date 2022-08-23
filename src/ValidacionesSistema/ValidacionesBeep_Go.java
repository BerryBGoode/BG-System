/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ValidacionesSistema;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author danlo
 */
public class ValidacionesBeep_Go {
    
    public static int Modo;

    public ValidacionesBeep_Go() {
    }

    public static int getModo() {
        return Modo;
    }

    public static void setModo(int Modo) {
        ValidacionesBeep_Go.Modo = Modo;
    }
    
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
    
    public static String EBase64(String p){
        String base64;
        base64 = Base64.getEncoder().encodeToString(p.getBytes());
        return base64;
    }   
    
    public static String EncriptarContra(String p){
        String sha1 = SHA1(p);
        String sha2 = SHA256(sha1);
        String base64 = EBase64(sha2);
        String f = MD5(base64);
        return f;
    }
    
    public static void SoloLetrasYNumeros(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        if(Character.isLetter(car) || Character.isDigit(car)){

        }else{
            evt.consume();
        }
    }
    
    public static void SoloLetrasNumerosGuionBajo(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        if(Character.isLetter(car) || Character.isDigit(car) || car == 95){

        }else{
            evt.consume();
        }
    }
    public static void SoloLetras(java.awt.event.KeyEvent evt){
        char car=evt.getKeyChar();
        if (Character.isLetter(car) || Character.isWhitespace(car)) {
            
        }else{
            evt.consume();
        }
    }
    public static void SoloNumeros(java.awt.event.KeyEvent evt){
        char car = evt.getKeyChar();
        if(Character.isDigit(car)){

        }else{
            evt.consume();
        }
    }
    
    public static void SinEspacios(java.awt.event.KeyEvent evt){
        char key = evt.getKeyChar();

        if (Character.isSpace(key))
        {
            evt.consume();
        }
    }
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
