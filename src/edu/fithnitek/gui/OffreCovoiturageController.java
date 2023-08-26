package edu.fithnitek.gui;

import edu.fithnitek.entities.CalculeDistance;
import edu.fithnitek.entities.OffreCovoiturage;
import edu.fithnitek.services.OffreCovoiturageCRUD;
import edu.fithnitek.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

public class OffreCovoiturageController extends CalculeDistance implements Initializable  {

    @FXML
    private DatePicker dateD;

    @FXML
    private ComboBox lieuD;

    @FXML
    private ComboBox lieuA;

    @FXML
    private TextField dispo;

    @FXML
    private ComboBox nomplace;

    @FXML
    private TextField matricule;

    @FXML
    private TextField marque;

    @FXML
    private TextField numtel;

    @FXML
    private TableView<OffreCovoiturage> table;

    @FXML
    private TableColumn<OffreCovoiturage, String> tdepart;

    @FXML
    private TableColumn<OffreCovoiturage, String> tarriver;

    @FXML
    private TableColumn<OffreCovoiturage, String> tdate;

    @FXML
    private TableColumn<OffreCovoiturage, String> tdispo;
    
    @FXML
    private TableColumn<OffreCovoiturage, Integer> nbplaces;
    
    @FXML
    private TableColumn<OffreCovoiturage, String> tmarque;
    
    @FXML
    private TableColumn<OffreCovoiturage, String> tmatricule;

    @FXML
    private TableColumn<OffreCovoiturage, Integer> tnumtel;

    @FXML
    private TableColumn<CalculeDistance, Double> tdistance;


    @FXML
    private Button b_offre;

    @FXML
    private Button b_bien;

    @FXML
    private Button b_ajouter;

    @FXML
    private Button b_modifier;

    @FXML
    private Button b_supprimer;

    @FXML
    private Button bsms;

    private List<OffreCovoiturage> CovoiturageList;

    public ObservableList<OffreCovoiturage> data=FXCollections.observableArrayList();
    
    ObservableList<String> lieuList = FXCollections.observableArrayList("Tunis", "Ariana", "Ben Arous", "Mannouba", "Bizerte", "Nabeul", "Béja", "Jendouba", "Zaghouan", "Siliana", "Le Kef", "Sousse", "Monastir", "Mahdia", "Kasserine", "Sidi Bouzid", "Kairouan", "Gafsa", "Sfax", "Gabès", "Médenine", "Tozeur", "Kebili", "Ttataouine");
    ObservableList<Integer> nbList = FXCollections.observableArrayList(1, 2, 3, 4);
    
    public void UpdateTable() {
       ObservableList<OffreCovoiturage> offreCovoiturageList = FXCollections.observableArrayList();
        try {
            String query = "SELECT * FROM offrecovoiturage";
            PreparedStatement statement = MyConnection.getInstance().getCnx().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            
            while(resultSet.next()){
                OffreCovoiturage offreCovoiturage = new OffreCovoiturage(
                    resultSet.getInt("id"),
                    resultSet.getString("lieuD"),
                    resultSet.getString("lieuA"),
                    resultSet.getDate("dateD"),
                    resultSet.getString("dispo"),
                    resultSet.getInt("nbPlace"),
                    resultSet.getString("matricule"),
                    resultSet.getString("marque"),
                    resultSet.getInt("numTel"),
                    resultSet.getDouble("distance"));
                
                offreCovoiturageList.add(offreCovoiturage);
            }
            } catch (SQLException ex) {
            System.out.println("Error while retrieving data from database: " + ex.getMessage());
            ex.printStackTrace();
        }
        //idO.setCellValueFactory(new PropertyValueFactory<>("id"));
        tdepart.setCellValueFactory(new PropertyValueFactory<>("lieuD"));
        tarriver.setCellValueFactory(new PropertyValueFactory<>("lieuA"));
        tdate.setCellValueFactory(new PropertyValueFactory<>("dateD"));
        tdispo.setCellValueFactory(new PropertyValueFactory<>("dispo"));
        nbplaces.setCellValueFactory(new PropertyValueFactory<>("nbPlace"));
        tmatricule.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        tmarque.setCellValueFactory(new PropertyValueFactory<>("marque"));
        tnumtel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        tdistance.setCellValueFactory(new PropertyValueFactory<>("distance"));
        table.setItems(offreCovoiturageList);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
        
        lieuD.setItems(lieuList);
        
        lieuA.setItems(lieuList);
        nomplace.setItems(nbList);
        table.setOnMouseClicked((MouseEvent e) -> {
            if (e.getClickCount() == 2) {
                OffreCovoiturage offreCovoiturage = table.getSelectionModel().getSelectedItem();
                if (offreCovoiturage != null) {
                    //idOO.setText(Integer.toString(offreCovoiturage.getId()));
                    lieuD.setValue(offreCovoiturage.getLieuD());
                    lieuA.setValue(offreCovoiturage.getLieuA());
                    Calendar calVidange = Calendar.getInstance();
                    calVidange.setTime(offreCovoiturage.getDateD());
                    LocalDate dateDepart = LocalDate.of(calVidange.get(Calendar.YEAR),
                            calVidange.get(Calendar.MONTH) + 1,
                            calVidange.get(Calendar.DAY_OF_MONTH));
                    dateD.setValue(dateDepart);
                    dispo.setText(offreCovoiturage.isDispo());
                    nomplace.setValue(Integer.toString(offreCovoiturage.getNbPlace()));
                    matricule.setText(offreCovoiturage.getMatricule());
                    marque.setText(offreCovoiturage.getMarque());
                    numtel.setText(Integer.toString(offreCovoiturage.getNumTel())); 
                }
            }
        });

    }

    @FXML
    private void ajouter(ActionEvent event) {
    try {
        if (matricule.getText().isEmpty() || marque.getText().isEmpty() || dateD.getValue() == null
                || lieuD.getValue()== null || lieuA.getValue()== null || dispo.getText().isEmpty()
                || nomplace.getValue()== null || numtel.getText().isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires");
        } else {
            

            String sql = "INSERT INTO OffreCovoiturage(lieuD, lieuA, dateD, dispo, nbPlace, matricule, marque, numTel, distance, idUser)"
                    + "values(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(sql);

            
            pst.setString(1, (String) lieuD.getValue());
            pst.setString(2, (String) lieuA.getValue());
            Date datee = java.sql.Date.valueOf(dateD.getValue());
            java.sql.Date sqlDatee = new java.sql.Date(datee.getTime());
            pst.setDate(3, sqlDatee);
            pst.setString(4, dispo.getText());
            int nombreDePlaces = Integer.parseInt((String) nomplace.getValue());
            pst.setInt(5, nombreDePlaces);
            pst.setString(6, matricule.getText());
            pst.setString(7, marque.getText());
            pst.setString(8, numtel.getText());
            double distance = CalculeDistance.distance(CalculeDistance.lat_depart, CalculeDistance.lon_depart, CalculeDistance.lat_arriver, CalculeDistance.lon_arriver);
            pst.setDouble(9, distance);
            pst.setInt(10, 29);
            pst.executeUpdate();
            System.out.println("Done!");
            UpdateTable();
               Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("A");
            alert.setHeaderText(null);
            alert.setContentText("Ajouté avec succées");
            alert.showAndWait();
        }
        UpdateTable();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }

}





    @FXML
    public void Edit() {
        try {
            //int id = Integer.parseInt(idOO.getText());
            String lieudd = (String) lieuD.getValue();
            String lieuaa = (String) lieuA.getValue();
            String dispoo = dispo.getText();
            Date dateee = java.sql.Date.valueOf(dateD.getValue());
            int nbp = Integer.parseInt((String) nomplace.getValue());
            String matriculee = matricule.getText();
            String marquee = marque.getText();
            int numtell = Integer.parseInt(numtel.getText());

            // Validate the input fields
            if (matriculee.isEmpty() || marquee.isEmpty() || dateee == null
                    || lieudd.isEmpty() || lieuaa == null || dispoo == null ) {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String requete = "UPDATE OffreCovoiturage SET,lieuD=?, lieuA=?, dateD=? dispo=?, nbPlace=?, matricule=?,marque=?,numTel=? where id=?  ";

            // Create a connection to the database
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            //pst.setInt(1, id);
            pst.setString(1, lieudd);
            pst.setString(2, lieuaa);
            pst.setDate(3, (java.sql.Date) dateee);
            pst.setString(4, dispoo);
            pst.setInt(5, nbp);
            pst.setString(6, matriculee);
            pst.setString(7, marquee);
            pst.setInt(8, numtell);
            

            pst.executeUpdate();
            int rowsUpdated = pst.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "offre mise à jour avec succès");
                UpdateTable();
            } else {
                JOptionPane.showMessageDialog(null, "Échec de la mise à jour du bien", "Erreur", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Veuillez entrer un nombre valide", "Erreur", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur SQL : " + e.getMessage(), "Erreur", JOptionPane.ERROR_MESSAGE);

        }

    }
    
        @FXML
    private void deleteOffre(ActionEvent event) {
        // Vérifier si une offre a été sélectionnée
        OffreCovoiturage offreCovoiturage = table.getSelectionModel().getSelectedItem();
        if (offreCovoiturage == null) {
            // Afficher un message d'erreur si aucune offre n'a été sélectionnée
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Erreur");
            alert.setHeaderText("Aucune offre sélectionnée");
            alert.setContentText("Veuillez sélectionner une offre à supprimer.");
            alert.showAndWait();
            return;
        }

        // Afficher une boîte de dialogue de confirmation
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Confirmation de la suppression");
        alert.setHeaderText("Supprimer l'offre sélectionnée ?");
        alert.setContentText("Êtes-vous sûr de vouloir supprimer l'offre sélectionnée ?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // Supprimer l'offre de la base de données
            OffreCovoiturageCRUD offreCovoiturageCRUD = new OffreCovoiturageCRUD();
            offreCovoiturageCRUD.delete(offreCovoiturage);
            //offreCovoiturageCRUD.

            // Afficher un message de succès
            Alert alertSuccess = new Alert(AlertType.INFORMATION);
            alertSuccess.setTitle("Succès");
            alertSuccess.setHeaderText("Offre supprimée avec succès");
            UpdateTable();
            alertSuccess.showAndWait();

            // Actualiser la table des offres
           // CovoiturageList.clear();
           // CovoiturageList.addAll(offreCovoiturageCRUD.selectAll());
           // table.refresh();
        }
    }
    
    @FXML
    private void sms(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("SendSms.FXML"));
        Parent root = loader.load();
        Scene scene = bsms.getScene();
        scene.setRoot(root);
        scene.getWindow().sizeToScene();
    }

    @FXML
    private void offre(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OffreCovoiturage.FXML"));
        Parent root = loader.load();
        Scene scene = b_offre.getScene();
        scene.setRoot(root);
        scene.getWindow().sizeToScene();
    }

    @FXML
    private void bien(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Bien.FXML"));
        Parent root = loader.load();
        Scene scene = b_bien.getScene();
        scene.setRoot(root);
        scene.getWindow().sizeToScene();
    }

}
