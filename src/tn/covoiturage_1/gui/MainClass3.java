/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.covoiturage_1.gui;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nihel
 */
public class MainClass3 extends Application{
     @Override
    public void start(Stage primaryStage)  {
     
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ReclamationBackAdmin.fxml"));
            Scene scene = new Scene(root);
            
            primaryStage.setTitle("ReclamationBack");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
