package edu.fithnitik.gui;

import edu.fithnitik.entities.CalculeDistance;
import static edu.fithnitik.entities.CalculeDistance.distance;
import edu.fithnitik.entities.OffreCovoiturage;
import edu.fithnitik.services.OffreCovoiturageCRUD;
import edu.fithnitik.utils.MyConnection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.MenuButton;
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
    private TableColumn<OffreCovoiturage, String> tnumtel;

    @FXML
    private TableColumn<CalculeDistance, String> tdistance;

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

    @FXML
    private Button bsms;

    private List<OffreCovoiturage> CovoiturageList;

    @FXML
    private TableColumn<OffreCovoiturage, Integer> nbplaces;
    @FXML
    private TableColumn<OffreCovoiturage, String> marquet;
    @FXML
    private TableColumn<OffreCovoiturage, String> mztriculet;
    @FXML
    private TableColumn<OffreCovoiturage, Integer> idO;
    @FXML
    private TextField idOO;

    public void UpdateTable() {

        //tdistance.setCellValueFactory(new PropertyValueFactory<CalculeDistance,String>("distance"));
        //nbplaces.setCellValueFactory(new PropertyValueFactory<OffreCovoiturage, Integer>("nbPlace"));
        ObservableList<OffreCovoiturage> offreCovoiturageList = FXCollections.observableArrayList();
        try {

            String query = "SELECT * FROM offrecovoiturage";
            PreparedStatement statement = MyConnection.getInstance().getCnx().prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                OffreCovoiturage offreCovoiturage = new OffreCovoiturage(
                        resultSet.getInt("id"),
                        resultSet.getString("matricule"),
                        resultSet.getString("marque"),
                        resultSet.getDate("dateD"),
                        resultSet.getString("lieuD"),
                        resultSet.getString("lieuA"),
                        resultSet.getString("dispo"),
                        resultSet.getInt("nbPlace"),
                        resultSet.getString("numTel"));
                offreCovoiturageList.add(offreCovoiturage);

            }

            System.out.println(offreCovoiturageList);
            //System.out.println(offreCovoiturageList);
            //table.getColumns().addAll(mztriculet ,marquet, tdate, tdepart, tarriver, tdispo, tnomplace, tnumtel );
        } catch (SQLException ex) {
            System.out.println("Error while retrieving data from database: " + ex.getMessage());
            ex.printStackTrace();

        }

        idO.setCellValueFactory(new PropertyValueFactory<>("id"));
        mztriculet.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        marquet.setCellValueFactory(new PropertyValueFactory<>("marque"));
        tdate.setCellValueFactory(new PropertyValueFactory<>("dateD"));
        tdepart.setCellValueFactory(new PropertyValueFactory<>("lieuD"));
        tarriver.setCellValueFactory(new PropertyValueFactory<>("lieuA"));

        tdispo.setCellValueFactory(new PropertyValueFactory<>("dispo"));
        nbplaces.setCellValueFactory(new PropertyValueFactory<>("ndPlace"));

        tnumtel.setCellValueFactory(new PropertyValueFactory<>("numTel"));
        table.setItems(offreCovoiturageList);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        UpdateTable();
        table.setOnMouseClicked((MouseEvent e) -> {
            if (e.getClickCount() == 2) {
                OffreCovoiturage offreCovoiturage = table.getSelectionModel().getSelectedItem();
                if (offreCovoiturage != null) {
                    idOO.setText(Integer.toString(offreCovoiturage.getId()));
                    matricule.setText(offreCovoiturage.getMatricule());
                    marque.setText(offreCovoiturage.getMarque());
                    Calendar calVidange = Calendar.getInstance();
                    calVidange.setTime(offreCovoiturage.getDateD());
                    LocalDate dateDepart = LocalDate.of(calVidange.get(Calendar.YEAR),
                            calVidange.get(Calendar.MONTH) + 1,
                            calVidange.get(Calendar.DAY_OF_MONTH));
                    dateD.setValue(dateDepart);
                    lieuD.setText(offreCovoiturage.getLieuD());
                    lieuA.setText(offreCovoiturage.getLieuA());
                    dispo.setText(offreCovoiturage.isDispo());
                    nomplace.setText(Integer.toString(offreCovoiturage.getNbPlace()));
                    numtel.setText(offreCovoiturage.getNumTel());
                   //distance.setText(offreCovoiturage.getDistance());
                }
            }
        });

    }

    @FXML
    private void ajouter(ActionEvent event) {
    try {
        if (matricule.getText().isEmpty() || marque.getText().isEmpty() || dateD.getValue() == null
                || lieuD.getText().isEmpty() || lieuA.getText().isEmpty() || dispo.getText().isEmpty()
                || nomplace.getText().isEmpty() || numtel.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tous les champs sont obligatoires");
        } else {
            double latdepart = 0;
            double londepart = 0;
            double latarriver = 0;
            double lonarriver = 0;

            String sql = "INSERT INTO OffreCovoiturage(matricule, marque, dateD, lieuD, lieuA, dispo, nbPlace, numTel, distance)"
                    + "values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(sql);

            Date datee = java.sql.Date.valueOf(dateD.getValue());
            java.sql.Date sqlDatee = new java.sql.Date(datee.getTime());

            pst.setString(1, matricule.getText());
            System.out.println(matricule.getText());
            pst.setString(2, marque.getText());
            pst.setDate(3, sqlDatee);
            pst.setString(4, lieuD.getText());
            System.out.println(lieuD.getText());
            pst.setString(5, lieuA.getText());
            pst.setString(6, dispo.getText());
            int nombreDePlaces = Integer.parseInt(nomplace.getText());
            pst.setInt(8, nombreDePlaces);
            pst.setString(9, numtel.getText());
            double distance = CalculeDistance.distance(latdepart, londepart, latarriver, lonarriver);
           
            pst.executeUpdate();
            System.out.println("Done!");
            JOptionPane.showMessageDialog(null, "offre ajoutée avec succès !");
        }
        UpdateTable();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
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

    @FXML
    private void map(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Localisation.FXML"));
        Parent root = loader.load();
        Scene scene = b_loc.getScene();
        scene.setRoot(root);
        scene.getWindow().sizeToScene();
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

            // Afficher un message de succès
            Alert alertSuccess = new Alert(AlertType.INFORMATION);
            alertSuccess.setTitle("Succès");
            alertSuccess.setHeaderText("Offre supprimée avec succès");
            UpdateTable();
            alertSuccess.showAndWait();

            // Actualiser la table des offres
            CovoiturageList.clear();
            CovoiturageList.addAll(offreCovoiturageCRUD.selectAll());
            table.refresh();
        }
    }

    @FXML
    public void Edit() {
        try {
            int id = Integer.parseInt(idOO.getText());
            String matriculee = matricule.getText();
            String marquee = marque.getText();
            Date dateee = java.sql.Date.valueOf(dateD.getValue());
            String lieudd = lieuD.getText();
            String lieuaa = lieuA.getText();
            String dispoo = dispo.getText();
            String numtell = numtel.getText();
            int nbp = Integer.parseInt(nomplace.getText());

            // Validate the input fields
            if (matriculee.isEmpty() || marquee.isEmpty() || dateee == null
                    || lieudd.isEmpty() || lieuaa == null || dispoo == null || numtell.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Erreur", JOptionPane.ERROR_MESSAGE);
                return;
            }
            String requete = "UPDATE OffreCovoiturage SET matricule=?,marque=?,dateD=?,lieuD=?, lieuA=?, dispo=?,"
                    + "nbPlace=?,numTel=? where id=?  ";

            // Create a connection to the database
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, matriculee);
            pst.setString(2, marquee);
            pst.setDate(3, (java.sql.Date) dateee);
            pst.setString(4, lieudd);
            pst.setString(5, lieuaa);
            pst.setString(6, dispoo);
            pst.setInt(7, nbp);
            pst.setString(8, numtell);
            pst.setInt(9, id);

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

}
