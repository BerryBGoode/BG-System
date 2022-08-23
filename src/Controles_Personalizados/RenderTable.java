/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados;


import javax.swing.JTable;
import javax.swing.JCheckBox;
import java.awt.Component;
import javax.swing.JLabel;
import Controles_Personalizados.Botones.UWPButton;
import Controles_Personalizados.Botones.ButtonGradient;
import Controles_Personalizados.Botones.UWPButton;
/**
 *
 * @author ferna
 */
public class RenderTable extends javax.swing.table.DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                
        if (value instanceof JCheckBox) {
            JCheckBox chk = (JCheckBox) value;
            return chk;
        }
        
        if (value instanceof UWPButton) {
            UWPButton btn = (UWPButton) value;
            return btn;
        }
        
        if (value instanceof UWPButton) {
            UWPButton btn = (UWPButton) value;
            return btn;
        }
        
        if (value instanceof JLabel) {
            JLabel lbl = (JLabel) value;
            return lbl;
        }
        
        return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); //To change body of generated methods, choose Tools | Templates.        
    }
    
    
}
