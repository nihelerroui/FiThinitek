package edu.fithnitik.gui;

import edu.fithnitik.entities.OffreCovoiturage;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class OffreCovoiturageController {

    @FXML
    private DatePicker dateD;

    @FXML
    private TextField lieuD;

    @FXML
    private TextField lieuA;

    @FXML
    private TextField dispo;

    @FXML
    private TextField nomplace;

    @FXML
    private TextField matricule;

    @FXML
    private TextField marque;

    @FXML
    private TextField numtel;

    @FXML
    private TextField id;

    @FXML
    private TableView<OffreCovoiturage> table;

    @FXML
    private TableColumn<OffreCovoiturage, String> tdepart;

    @FXML
    private TableColumn<OffreCovoiturage, String> tarriver;

    @FXML
    private TableColumn<OffreCovoiturage, Date> tdate;

    @FXML
    private TableColumn<OffreCovoiturage, String> tdispo;

    @FXML
    private TableColumn<OffreCovoiturage, Integer> tnomplace;

    @FXML
    private TableColumn<OffreCovoiturage, String> tnumtel;

    @FXML
    private MenuButton b_menu;

    @FXML
    private Button b_offre;

    @FXML
    private Button b_bien;

    @FXML
    private Button b_loc;
    
    @FXML
    private Button b_ajouter;
    
    @FXML
    private Button b_modifier;

    @FXML
    private Button b_supprimer;

    
    
    

    public TableView<OffreCovoiturage> getTable() {
        return table;
    }

    public TableColumn<OffreCovoiturage, String> getTdepart() {
        return tdepart;
    }

    public TableColumn<OffreCovoiturage, String> getTarriver() {
        return tarriver;
    }

    public TableColumn<OffreCovoiturage, Date> getTdate() {
        return tdate;
    }

    public TableColumn<OffreCovoiturage, String> getTdispo() {
        return tdispo;
    }

    public TableColumn<OffreCovoiturage, Integer> getTnomplace() {
        return tnomplace;
    }

    public TableColumn<OffreCovoiturage, String> getTnumtel() {
        return tnumtel;
    }

    

    public void initialize(URL url, ResourceBundle rb) {
    tdepart.setCellValueFactory(new PropertyValueFactory<OffreCovoiturage, String>("lieuDapart"));
    tarriver.setCellValueFactory(new PropertyValueFactory<OffreCovoiturage, String>("lieuDArrivee"));
    tdate.setCellValueFactory(new PropertyValueFactory<OffreCovoiturage, Date>("dateDepart"));
    tdispo.setCellValueFactory(new PropertyValueFactory<OffreCovoiturage, String>("disponibilite"));
    tnomplace.setCellValueFactory(new PropertyValueFactory<OffreCovoiturage, Integer>("nombrePlaces"));
    tnumtel.setCellValueFactory(new PropertyValueFactory<OffreCovoiturage, String>("numTel"));
}
    

}

