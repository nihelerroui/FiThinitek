/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.voiture.gui;

import edu.connexion.utils.MyConnection;
import edu.voiture.entities.Voiture;
import edu.voiture.entities.maintenance;
import edu.voiture.services.VoitureCRUD;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class MainVoitureController implements Initializable {

    @FXML
    private TableColumn<maintenance, Integer> id_Maint;
    @FXML
    private TableColumn<maintenance, String> Matvoiture;
    @FXML
    private TableColumn<maintenance, Date> dateDMV;
    @FXML
    private TableColumn<maintenance, Date> dateDPA;
    @FXML
    private TableColumn<maintenance, Date> dateDVV;
    @FXML
    private ComboBox<String> idcombo;
    @FXML
    private DatePicker dda;
    @FXML
    private DatePicker ddv;
    @FXML
    private Button idajouter;
    @FXML
    private TextField kilom;
    private VoitureCRUD voitureCRUD;
    @FXML
    private TableView<maintenance> maintable;
    private List<maintenance> mainList;
    @FXML
    private Button voituree;


    /**
     * Initializes the controller class.
     */ 
  
    
    
    public void UpdateTableM(){
         
         
       
        id_Maint.setCellValueFactory(new PropertyValueFactory<>("id_maintenance"));
        Matvoiture.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        dateDMV.setCellValueFactory(new PropertyValueFactory<>("dateDAssurance"));
        dateDPA.setCellValueFactory(new PropertyValueFactory<>("datePAssurance"));
        dateDVV.setCellValueFactory(new PropertyValueFactory<>("dateDVidange"));
        mainList = voitureCRUD.getmaintenance();
        maintable.setItems(FXCollections.observableArrayList(mainList));
        

    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
      voitureCRUD = new VoitureCRUD();
       maintable.getColumns().addAll(id_Maint, Matvoiture, dateDMV, dateDPA, dateDVV);
        System.out.println(maintable);
      UpdateTableM();
    try {
        String query = "SELECT matricule FROM voiture";
        PreparedStatement pstSelect = MyConnection.getInstance().getCnx().prepareStatement(query);
        ResultSet resultSet = pstSelect.executeQuery();
        
        while (resultSet.next()) {
            String matricule = resultSet.getString("matricule");
            idcombo.getItems().add(matricule);
        }
    } catch (SQLException ex) {
        Logger.getLogger(MainVoitureController.class.getName()).log(Level.SEVERE, null, ex);
    }

    
    
    idcombo.setOnAction(event -> {
    String matricule = idcombo.getValue();
    try {
        String query = "SELECT kilometrage ,dateAssurance , dateDVidange  FROM Voiture WHERE matricule = ?";
        PreparedStatement pstSelect = MyConnection.getInstance().getCnx().prepareStatement(query);
        pstSelect.setString(1, matricule);
        ResultSet resultSet = pstSelect.executeQuery();
        
        if (resultSet.next()) {
            int kilo = resultSet.getInt("kilometrage");
            java.sql.Date dateA = resultSet.getDate("dateAssurance");
            java.sql.Date dateV = resultSet.getDate("dateDVidange");
            
            
            
            // Faire quelque chose avec les informations récupérées
            // Par exemple, remplir des champs de texte dans l'interface graphique
            kilom.setText(String.valueOf(kilo));
            dda.setValue(dateA.toLocalDate());
            ddv.setValue(dateV.toLocalDate());
            
            
        }
    } catch (SQLException ex) {
        Logger.getLogger(MainVoitureController.class.getName()).log(Level.SEVERE, null, ex);
    }
}); 
    
    
   
    }
    
   
    
    @FXML
     public void  add (){

      try {
    // Check if any field is empty or null
    if ( kilom.getText().isEmpty() ||  dda.getValue() == null || ddv.getValue() == null) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs du formulaire !");
        return;
    }
    
    String sqlSelect = "SELECT COUNT(*) FROM maintenance WHERE matricule = ?";
    PreparedStatement pstSelect = MyConnection.getInstance().getCnx().prepareStatement(sqlSelect);
    pstSelect.setString(1, idcombo.getValue());
    ResultSet rs = pstSelect.executeQuery();
    rs.next();
    int count = rs.getInt(1);
    if (count > 0) {
        JOptionPane.showMessageDialog(null, "Cette voiture existe déjà !");
        return;
    }
    
    
    String sql = "INSERT INTO maintenance ( matricule ,dateDAssurance,datePAssurance, dateDVidange )"+ "VALUES (?,?,?,?)";
    PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(sql);
    
    
    LocalDate dateDebutAssurance = dda.getValue();
    LocalDate dateDebutVidange = ddv.getValue();
    
    
 
     LocalDate dateFinAssurance = dateDebutAssurance.plus(1, ChronoUnit.YEARS);
     //

    
    pst.setString(1, idcombo.getValue());
    pst.setDate(2, java.sql.Date.valueOf(dateDebutAssurance));
    pst.setDate(3, java.sql.Date.valueOf(dateFinAssurance));
    pst.setDate(4, java.sql.Date.valueOf(dateDebutVidange));
    //pst.setString(5, dpv.getText());
    
    pst.executeUpdate();
    System.out.println("Done!");
    JOptionPane.showMessageDialog(null, "Voiture ajoutée avec succès !");
   
} catch (SQLException e) {
     System.out.println(e.getMessage());
}
       UpdateTableM(); 
    }
    
    
    @FXML
    public void voiture_view(ActionEvent event){
         
        try {
            
            FXMLLoader loader=new FXMLLoader(getClass().getResource("ListVoiture.fxml"));
            Parent root=loader.load();
            voituree.getScene().setRoot(root);
            
           
        } catch (IOException ex) {
            System.out.println(ex);
        }
         
         
       
     }
    
    
    
}
    
    
   




