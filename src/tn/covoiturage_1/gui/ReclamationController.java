/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.covoiturage_1.gui;

import java.awt.Image;
import static java.lang.System.gc;
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import tn.covoiturage_1.entities.Reclamation;
import tn.covoiturage_1.services.ReclamationCRUD;


/**
 * FXML Controller class
 *
 * @author Nihel
 */
public class ReclamationController implements Initializable {

    @FXML
    private Button Reclamer1;
    @FXML
    private TextArea description;
    @FXML
    private TextField objet;
    @FXML
    private TableView table_reclamation;
    @FXML
    private TableColumn tb_id;
    @FXML
    private TableColumn tb_intitule;
    @FXML
    private TableColumn tb_contenu;
    @FXML
    private TableColumn id_usr;
    @FXML
    private Button supprimer;
    
    ReclamationCRUD rc = new ReclamationCRUD();
    public static ObservableList<Reclamation> listR = null;
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayReclamation();
    }    
    public void displayReclamation(){
        
        ImageView imageView = new ImageView(getClass().getResource("/tn/covoiturage_1/ressources/images/supprimer.png").toExternalForm());
        supprimer.setGraphic(imageView);
        
        tb_id.setCellValueFactory(new PropertyValueFactory("id"));
        tb_intitule.setCellValueFactory(new PropertyValueFactory("intitule"));
        tb_contenu.setCellValueFactory(new PropertyValueFactory("contenu"));
        id_usr.setCellValueFactory(new PropertyValueFactory("id_usr"));
        
        List l = rc.selectAll();
        
        listR =FXCollections.observableArrayList(l);
        
        table_reclamation.setItems(listR);
        
    }

    @FXML
    private void AjouterReclamation(ActionEvent event) {
        String s= objet.getText();
        String s1=description.getText();
        
        if (!(description.getText().equals("")) && !(objet.getText().equals(""))) {
            Reclamation r = new Reclamation();
            r.setIntitule(s);
            r.setContenu(s1);
            r.setId_usr(1);
            rc.create(r);
        }else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("");
		alert.setHeaderText("");
		alert.setContentText("Verifier vos données ");
                alert.showAndWait();
        }
    }

    @FXML
    private void DeleteReclamation(ActionEvent event) {
        Reclamation rec = (Reclamation) table_reclamation.getSelectionModel().getSelectedItem();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Voulez-vous vraiment supprimer la réclamation N°"+rec.getId());
                a.setTitle("CONFIRMER");
                Optional<ButtonType> res=a.showAndWait();
        if(res.get() == ButtonType.OK){
            if(rc.delete(rec.getId())){
                listR.remove(rec);
            }
        }
    }
    
        
}
    

