/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modele;

import java.sql.*;
import java.util.ArrayList;
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
        String req = "SELECT nomSport FROM pratiquer where refAsso = '" + refAsso + "'";
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
}
