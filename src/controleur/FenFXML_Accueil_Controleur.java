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
    @FXML private DatePicker timepckDate;
    private ObservableList<Association> lesAssoc;
    private ObservableList<Sport> lesSports;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        try
        {
            lesAssoc = GestionBDD.getLesAssoc();
            cbxAssoc.setItems((ObservableList) lesAssoc);
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
        try
        {
            
            lesSports=GestionBDD.getLesSport(cbxAssoc.getSelectionModel().getSelectedItem().toString());
            cbxSport.setItems((ObservableList) lesSports);
        } catch (SQLException sqle)
        {
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("ERREUR SQL");
            alert.setHeaderText("ERREUR SQL");
            alert.setContentText(sqle.getMessage());
            alert.showAndWait();
        }
    }
    
}
