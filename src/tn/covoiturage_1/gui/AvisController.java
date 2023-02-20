/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.covoiturage_1.gui;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import tn.covoiturage_1.entities.Avis;
import static tn.covoiturage_1.gui.ReclamationController.listR;
import tn.covoiturage_1.services.AvisCRUD;

/**
 * FXML Controller class
 *
 * @author Nihel
 */
public class AvisController implements Initializable {

    @FXML
    private TableColumn<?, ?> id_utilisateur;
    @FXML
    private Button ajouter;
    @FXML
    private Button supprimer;
    @FXML
    private TableColumn<?, ?> id_offre;
    @FXML
    private TableColumn<?, ?> id;
    @FXML
    private TableColumn<?, ?> id_commentaire;
    
    AvisCRUD rc = new AvisCRUD();
    public static ObservableList<Avis> listA = null;
    @FXML
    private TableView<Avis> table;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayAvis();
    }    
    public void displayAvis(){
        
        ImageView imageView = new ImageView(getClass().getResource("/tn/covoiturage_1/ressources/images/ajouter.png").toExternalForm());
        ajouter.setGraphic(imageView);
        ImageView imageView1 = new ImageView(getClass().getResource("/tn/covoiturage_1/ressources/images/supprimer.png").toExternalForm());
        supprimer.setGraphic(imageView1);
        
        id.setCellValueFactory(new PropertyValueFactory("id"));
        id_commentaire.setCellValueFactory(new PropertyValueFactory("commentaire"));
        id_utilisateur.setCellValueFactory(new PropertyValueFactory("id_usr"));
        //id_offre.setCellValueFactory(new PropertyValueFactory("id_offre"));
        
        List l = rc.selectAll();
        
        listA =FXCollections.observableArrayList(l);
        
        table.setItems(listA);
    
}

    @FXML
    private void ajouterAvis(ActionEvent event) {
        String s= id_commentaire.getText();
        
        if (!(id_commentaire.getText().equals(""))) {
            Avis a = new Avis();
            a.setCommentaire(s);
            a.setId_usr(1);
            //a.setId_offre(1);
            rc.create(a);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Verifier vos données ");
                alert.showAndWait();
        }
    }

    @FXML
    private void supprimerAvis(ActionEvent event) {
        Avis rec = (Avis) table.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Voulez-vous vraiment supprimer l'avis N°"+rec.getId());
                a.setTitle("CONFIRMER");
                Optional<ButtonType> res=a.showAndWait();
        if(res.get() == ButtonType.OK){
            if(rc.delete(rec.getId())){
                listA.remove(rec);
            }
        }
    }
}
