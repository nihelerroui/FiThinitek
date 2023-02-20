/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.covoiturage_1.gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import tn.covoiturage_1.entities.Reclamation;
import static tn.covoiturage_1.gui.ReclamationController.listR;
import tn.covoiturage_1.services.ReclamationCRUD;

/**
 * FXML Controller class
 *
 * @author Nihel
 */
public class ReclamationBackController implements Initializable {

    @FXML
    private TableColumn<?, ?> tab_id;
    @FXML
    private TableColumn<?, ?> tab_intitule;
    @FXML
    private TableColumn<?, ?> tab_contenu;
    @FXML
    private TableColumn<?, ?> tab_id_usr;
    @FXML
    private Button tfback;
    @FXML
    private Button tftraite;
    @FXML
    private TableView<Reclamation> table;
    
    ReclamationCRUD rc = new ReclamationCRUD();
    public static ObservableList<Reclamation> listR = null;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        displayReclamationBack();
    }    
    public void displayReclamationBack(){
        
        tab_id.setCellValueFactory(new PropertyValueFactory("id"));
        tab_intitule.setCellValueFactory(new PropertyValueFactory("intitule"));
        tab_contenu.setCellValueFactory(new PropertyValueFactory("contenu"));
        tab_id_usr.setCellValueFactory(new PropertyValueFactory("id_usr"));
        
        List l = rc.selectAll();
        
        listR =FXCollections.observableArrayList(l);
        
        table.setItems(listR);
        
    }

    @FXML
    private void back(ActionEvent event) {
    }

    @FXML
    private void treat(ActionEvent event) {
        
    }
    
}
