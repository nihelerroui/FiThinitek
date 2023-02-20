/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Connexion3A17.gui;

import edu.Connexion3A17.entities.demandecovoiturage;
import edu.Connexion3A17.services.reservationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author SAHBI
 */
public class reservation implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfPrenom;
    @FXML
    private Button btnValider;
    @FXML
    private Button btnUpdate;
    @FXML
    private TableView<reservation> tableuser;
    @FXML
    private TableColumn<reservation, String> colid;
    @FXML
    private TableColumn<reservation, String> colnom;
    @FXML
    private TableColumn<reservation, String> colprenom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        loadDate();
    }

    @FXML
    private void savePersonne(ActionEvent event) {
        try {
            String nom = tfNom.getText();
            String prenom = tfPrenom.getText();
            reservation p = new reservation(3,dateReservation, nbplace);
            reservationCRUD pcd = new reservationCRUD();
            pcd.ajouterEntitee(p);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.FXML"));
            Parent root = loader.load();
            DetailsController dc = loader.getController();
            dc.setResNom(nom);
            dc.setResPrenom(prenom);
            tfNom.getScene().setRoot(root);

        } catch (IOException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void updateperson(ActionEvent event) {

        try {
            String nom = tfNom.getText();
            String prenom = tfPrenom.getText();
               reservation p = new reservation(3,dateReservation, nbplace);
            reservationCRUD pcd = new reservationCRUD();
            pcd.modifier(p);
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Details.FXML"));
            Parent root = loader.load();
            DetailsController dc = loader.getController();
            dc.setResNom(nom);
            dc.setResPrenom(prenom);
            tfNom.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(reservation.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void loadDate() {

        colid.setCellValueFactory(new PropertyValueFactory<>("id"));
        colnom.setCellValueFactory(new PropertyValueFactory<>("id"));
        colprenom.setCellValueFactory(new PropertyValueFactory<>("id"));

    }

}
