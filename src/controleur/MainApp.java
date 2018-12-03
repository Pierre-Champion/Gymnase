/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controleur;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 *
 * @author Rabelais
 */
public class MainApp extends Application
{
    private Stage primaryStage;
    private AnchorPane rootLayout;
    @Override
    public void start(Stage primaryStage) throws IOException
    {
        this.primaryStage=primaryStage;
        this.primaryStage.setTitle("Réservations gymnase");
        try
        {
            this.primaryStage.setTitle("Gestion des réservations");
            FXMLLoader loader = new FXMLLoader(MainApp.class.getResource("/vue/FenFXML_Accueil.fxml"));
            AnchorPane rootLayout = (AnchorPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        }
        catch (IOException e)
        {
            System.out.println("Erreur chargement fenetre principale : " + e.getMessage());
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }
    
}
