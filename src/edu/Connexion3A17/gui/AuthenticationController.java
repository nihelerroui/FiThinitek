/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Connexion3A17.gui;

import edu.Connexion3A17.entities.OffreCovoiturage;
import edu.Connexion3A17.entities.demandecovoiturage;
import edu.Connexion3A17.services.OffreCovoiturageCRUD;
import edu.Connexion3A17.services.reservationCRUD;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author SAHBI
 */
public class AuthenticationController implements Initializable {

    @FXML
    private TextField lieua;
    @FXML
    private TextField tflieud;
    @FXML
    private Button btnValider;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btndelete;
    @FXML
    private TableView<OffreCovoiturage> tableuser;
    
    @FXML
    private TableColumn<OffreCovoiturage, String> colD;
    @FXML
    private TableColumn<OffreCovoiturage, String> colA;
    @FXML
    private TableColumn<OffreCovoiturage, Integer> colnbplace;
    @FXML
    private TableColumn<OffreCovoiturage, String> coldate;
    @FXML
    private TextField date;
    @FXML
    private Button btnpre;
    @FXML
    private TextField textplace;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    
        private ObservableList<OffreCovoiturage> getTableList() {

       
            OffreCovoiturageCRUD ts = new OffreCovoiturageCRUD();
        ObservableList<OffreCovoiturage> list = FXCollections.observableArrayList(ts.selectAll());
        return list;
    }
    
    public void ShowTable() {
        ObservableList<OffreCovoiturage> Mylist = getTableList();
        tableuser.setItems(Mylist);
       // colid.setCellValueFactory(new PropertyValueFactory<>("sondage_id"));
       colD.setCellValueFactory(new PropertyValueFactory<>("lieuD"));
        colA.setCellValueFactory(new PropertyValueFactory<>("lieuA"));
         colnbplace.setCellValueFactory(new PropertyValueFactory<>("ndPlace"));
         coldate.setCellValueFactory(new PropertyValueFactory<>("dateD"));
       
    }

    @FXML
    private void ajouteRe(ActionEvent event) {
        
       
           
            
        String  nbplace = textplace.getText();
        demandecovoiturage  d = new demandecovoiturage();
        reservationCRUD pcd = new reservationCRUD();
           
       if (d.nbplace <=4){
            pcd.ajouterEntitee(d);
             System.out.println("reservation ajoutééé");
            JOptionPane.showMessageDialog(null, "réservation effectué avec succès !");
            
       }else {
                      JOptionPane.showMessageDialog(null, "vérifiez nombre de place  !");

       }
    }

    @FXML
    private void updateRe(ActionEvent event) {
         String  nbplace = textplace.getText();
        demandecovoiturage  d = new demandecovoiturage();
        reservationCRUD pcd = new reservationCRUD();
        if (d.nbplace <=4){
            pcd.modifier(d);
             System.out.println("réservation modifiée");
            JOptionPane.showMessageDialog(null, "réservation modifiée !");
            
       }else {
                      JOptionPane.showMessageDialog(null, "vérifiez nombre de place  !");

       }
        
    }

    @FXML
    private void deleteRe(ActionEvent event) {
         demandecovoiturage D = tableuser.getSelectionModel().getSelectedItem();
                String  nbplace = textplace.getText();

      
        int id = demandecovoiturage.get;
        
         // BOX CONFIRMATION 
        Stage stage = new Stage();
        
        Alert.AlertType type =Alert.AlertType.CONFIRMATION;
        Alert alert = new Alert(type,"");
        alert.initModality(Modality.APPLICATION_MODAL);
       // alert.initOwner(stage);
        alert.getDialogPane().setContentText("Voulez-vous supprimer la réservation");
        alert.getDialogPane().setHeaderText("Confirmation");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get()== ButtonType.OK){
            D.supprimer(id);
            ShowTable();
            
       
        
         
    }
        
        
         @FXML
    private void goBack(ActionEvent event) {
        
        
         try {
             FXMLLoader loader=new FXMLLoader(getClass().getResource("../GUI/GestHomePage.fxml"));
            Parent root = loader.load();
          
            Scene scene = new Scene(root);
            Stage stage =(Stage)btnpre.getScene().getWindow();
            stage.setScene(scene);
            //stage.show();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());  
        }
    }
        
    }

   
        
    
    

  
    
    




}