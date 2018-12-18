/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.*;

/**
 *
 * @author Hemnecron
 */
public class Reservation {
    
    private Date date;
    private Time heure;
    private boolean reserve;

    public Reservation(Date date, Time heure, boolean reserve) {
        this.date = date;
        this.heure = heure;
        this.reserve = reserve;
    }

    public Reservation(Date date, Time heure) {
        this.date = date;
        this.heure = heure;
        this.reserve = false;
    }

    public void Reserver() {
        this.reserve = true;
    }

    public Date getDate() {
        return date;
    }

    public Time getHeure() {
        return heure;
    }

    public boolean isReserve() {
        return reserve;
    }
    
}
