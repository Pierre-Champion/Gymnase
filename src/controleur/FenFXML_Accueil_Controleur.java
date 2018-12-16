/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import modele.Association;
import modele.GestionBDD;
import modele.Sport;

/**
 * FXML Controller class
 *
 * @author Rabelais
 */
public class FenFXML_Accueil_Controleur implements Initializable
{

    @FXML private ComboBox cbxAssoc;
    @FXML private ComboBox cbxSport;
    @FXML private ComboBox cbxSalle;
    @FXML private ComboBox cbxHeure;
    @FXML private DatePicker timepckDate;
    /**
     * Initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        cbxSport.setDisable(true);
        cbxSalle.setDisable(true);
        timepckDate.setDisable(true);
        timepckDate.getEditor().setEditable(false);
        cbxHeure.setDisable(true);
        try
        {
            cbxAssoc.setItems(GestionBDD.getLesAssoc());
        } catch (SQLException sqle)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR SQL");
            alert.setHeaderText("ERREUR SQL");
            alert.setContentText(sqle.getMessage());
            alert.showAndWait();
        }
    }
    @FXML
    public void loadSport()
    {
        cbxSalle.setDisable(true);
        timepckDate.setDisable(true);
        cbxHeure.setDisable(true);
        try
        {
            cbxSport.setItems(GestionBDD.getLesSport(cbxAssoc.getSelectionModel().getSelectedItem().toString()));
            if(!cbxSport.getItems().isEmpty())
                cbxSport.setDisable(false);
            else
                cbxSport.setDisable(true);
        } catch (SQLException sqle)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR SQL");
            alert.setHeaderText("ERREUR SQL");
            alert.setContentText(sqle.getMessage());
            alert.showAndWait();
        }
    }
    
    @FXML
    public void loadSalle()
    {
        timepckDate.setDisable(true);
        cbxHeure.setDisable(true);
        try
        {
            if(null!=cbxSport.getSelectionModel().getSelectedItem())
            {
                cbxSalle.setItems(GestionBDD.getLesSalles(cbxSport.getSelectionModel().getSelectedItem().toString()));
            }
            if(!cbxSalle.getItems().isEmpty())
                cbxSalle.setDisable(false);
            else
                cbxSalle.setDisable(true);
        } catch (SQLException sqle)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR SQL");
            alert.setHeaderText("ERREUR SQL");
            alert.setContentText(sqle.getMessage());
            alert.showAndWait();
        } catch (NullPointerException npe)
        {
        }
    }
    
    @FXML
    public void salleChoisie()
    {
        timepckDate.setDisable(false);
        cbxHeure.setDisable(true);
    }
}
