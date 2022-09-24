/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.ElementosDeMenu;

/**
 *   Personalized Control package
 * @author danlo
 */
import javaswingdev.GoogleMaterialDesignIcon;

/**
 *   Personalized control class, extends events and controls depends the needs 
 * @author danlo
 */
public class ModelMenuItem {

    /**
     *  Gets icon
     * @return icons
     */
    public GoogleMaterialDesignIcon getIcon() {
        return icon;
    }

    /**
     *  Set icon
     * @param icon referring to the icon
     */
    public void setIcon(GoogleMaterialDesignIcon icon) {
        this.icon = icon;
    }

    /**
     * Gets menu name
     * @return a String
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * Set menu name
     * @param menuName referring to the menu name
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     *  Gets Sub menu
     * @return a String
     */
    public String[] getSubMenu() {
        return subMenu;
    }

    /**
     *  Set SubMenu
     * @param subMenu referring to the SubMenu
     */
    public void setSubMenu(String[] subMenu) {
        this.subMenu = subMenu;
    }

    /**
     * Model
     * @param icon icon model
     * @param menuName menu model
     * @param subMenu Sub menu model
     */
    public ModelMenuItem(GoogleMaterialDesignIcon icon, String menuName, String... subMenu) {
        this.icon = icon;
        this.menuName = menuName;
        this.subMenu = subMenu;
    }

    /**
     *  Constructor
     */
    public ModelMenuItem() {
    }

    private GoogleMaterialDesignIcon icon;
    private String menuName;
    private String subMenu[];
}
