/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.fithnitik.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Nadhem
 */
public class MainWindow extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        OffreCovoiturageController c = new OffreCovoiturageController();
        
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OffreCovoiturage.fxml"));
            loader.setController(c);
            Parent root = loader.load();
            
            // Set up the scene and the stage
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.setTitle("OffreCovoiturage"); // Set the title of the window
            primaryStage.show(); // Show the window
        } catch (IOException ex) {
                System.out.println(ex.getMessage());

        }

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}