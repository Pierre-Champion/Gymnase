/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import sql.GestionBdd;

/**
 *
 * @author Rabelais
 */
public class GestionBDD
{
    static Statement stmt = GestionBdd.connexionBdd(GestionBdd.TYPE_MYSQL, "gymnase","localhost", "root","");
    
    public static ObservableList<Association> getLesAssoc() throws SQLException
    {
        ObservableList<Association> lesAssoc = FXCollections.observableArrayList();
        String req = "SELECT * FROM association";
        try
        {
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt,req);
            while(rs.next())
            {
                lesAssoc.add(new Association(rs.getString("refAsso"),rs.getString("ville"),rs.getString("adresse"),rs.getString("nomResponsable")));
            }
        }
        catch (SQLException sqle)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR SQL");
            alert.setHeaderText("ERREUR SQL");
            alert.setContentText(sqle.getMessage());
            alert.showAndWait();
        }
        return lesAssoc;
    }
    
    public static ObservableList<Sport> getLesSport(String refAsso) throws SQLException
    {
        ObservableList<Sport> lesSports = FXCollections.observableArrayList();
        String req = "SELECT nomSport FROM pratiquer WHERE refAsso = '" + refAsso + "'";
        try
        {
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt,req);
            while(rs.next())
            {
                lesSports.add(new Sport(rs.getString("nomSport")));
            }
        }
        catch (SQLException sqle)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR SQL");
            alert.setHeaderText("ERREUR SQL");
            alert.setContentText(sqle.getMessage());
            alert.showAndWait();
        }
        return lesSports;
    }
    
    public static ObservableList<Salle> getLesSalles(String nomSport) throws SQLException
    {
        ObservableList<Salle> lesSalles = FXCollections.observableArrayList();
        String req = "SELECT s.refSalle, surface, typeRevetement FROM salle s, accueillir a WHERE s.refSalle = a.refSalle AND nomSportAutorise = '" + nomSport + "'";
        try
        {
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt,req);
            while(rs.next())
            {
                lesSalles.add(new Salle(rs.getString("refSalle"), rs.getFloat("surface"), rs.getString("typeRevetement")));
            }
        }
        catch (SQLException sqle)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR SQL");
            alert.setHeaderText("ERREUR SQL");
            alert.setContentText(sqle.getMessage());
            alert.showAndWait();
        }
        return lesSalles;
    }
    
    public static ObservableList<Reservation> getLesReservations(String refSalle, Date date) throws SQLException
    {
        ObservableList<Reservation> lesReservations = FXCollections.observableArrayList();
        lesReservations.add(new Reservation(date, new Time(8,0,0)));
        lesReservations.add(new Reservation(date, new Time(9,0,0)));
        lesReservations.add(new Reservation(date, new Time(10,0,0)));
        lesReservations.add(new Reservation(date, new Time(11,0,0)));
        lesReservations.add(new Reservation(date, new Time(13,0,0)));
        lesReservations.add(new Reservation(date, new Time(14,0,0)));
        lesReservations.add(new Reservation(date, new Time(15,0,0)));
        lesReservations.add(new Reservation(date, new Time(16,0,0)));
        lesReservations.add(new Reservation(date, new Time(17,0,0)));
        String req = "SELECT heure FROM reservation WHERE refSalle = '" + refSalle + "' AND date = '" + date + "'";
        try
        {
            ResultSet rs = GestionBdd.envoiRequeteLMD(stmt,req);
            while(rs.next())
            {
                for(Reservation tempRes:lesReservations)
                {
                    if(tempRes.getHeure()==rs.getTime("heure"))
                        tempRes.Reserver();
                }
            }
        }
        catch (SQLException sqle)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR SQL");
            alert.setHeaderText("ERREUR SQL");
            alert.setContentText(sqle.getMessage());
            alert.showAndWait();
        }
        return lesReservations;
    }
    
}
