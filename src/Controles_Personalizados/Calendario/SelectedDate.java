/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles_Personalizados.Calendario;

/**
 *  Personalized Control package
 * @author danlo
 */
public class SelectedDate {

    /**
     * Gets day
     * @return an Integer
     */
    public int getDay() {
        return day;
    }

    /**
     *  Set Day 
     * @param day referring the day
     */
    public void setDay(int day) {
        this.day = day;
    }

    /**
     *  Gets the month
     * @return an Integer
     */
    public int getMonth() {
        return month;
    }

    /**
     *  Set month
     * @param month referring to the month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    /**
     *  Gets the year
     * @return an Integer
     */
    public int getYear() {
        return year;
    }

    /**
     *  Set year
     * @param year referring the year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     *  Selected Date
     * @param day day
     * @param month month
     * @param year year
     */
    public SelectedDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Selected Date
     */
    public SelectedDate() {
    }

    private int day;
    private int month;
    private int year;
}
