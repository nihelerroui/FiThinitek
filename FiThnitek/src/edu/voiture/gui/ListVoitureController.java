package edu.voiture.gui;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import edu.connexion.utils.MyConnection;
import edu.voiture.entities.Voiture;
import edu.voiture.services.VoitureCRUD;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import static javax.swing.Spring.width;




public class ListVoitureController implements Initializable {

    @FXML
    private TableView<Voiture> voitureTable;
    @FXML
    private TableColumn<Voiture, String> matriculeT;
    @FXML
    private TableColumn<Voiture, String> marqueT;
    @FXML
    private TableColumn<Voiture, String> puissanceT;
    @FXML
    private TableColumn<Voiture, Integer> nbplaceT;
    @FXML
    private TableColumn<Voiture, Integer> kilometrageT;
    @FXML
    private TableColumn<Voiture, Date> derniereAT;
    @FXML
    private TableColumn<Voiture, Date> derniereVT;

    private VoitureCRUD voitureCRUD;
    
    private List<Voiture> voitureList;
    @FXML
    private Button midifierV;
    @FXML
    private Button add;
    @FXML
    private Button supprimerV;
    @FXML
    private TextField mat;
    @FXML
    private TextField marq;
    @FXML
    private TextField puiss;
    @FXML
    private TextField kilo;
    @FXML
    private TextField nbp;
    @FXML
    private DatePicker dateA;
    @FXML
    private DatePicker dateV;
    

    int index = -1;
    @FXML
    private TableColumn<Voiture, Integer> idV;
   
    @FXML
    private TextField idVoi;
    @FXML
    private Button maintenancee;
    @FXML
    private Button imprimer;
    
    public void UpdateTable(){
        
        idV.setCellValueFactory(new PropertyValueFactory<>("id_voiture"));
        matriculeT.setCellValueFactory(new PropertyValueFactory<>("matricule"));
        marqueT.setCellValueFactory(new PropertyValueFactory<>("marque"));
        puissanceT.setCellValueFactory(new PropertyValueFactory<>("puissance"));
        kilometrageT.setCellValueFactory(new PropertyValueFactory<>("kilometrage"));
        nbplaceT.setCellValueFactory(new PropertyValueFactory<>("nbplaces"));
        derniereAT.setCellValueFactory(new PropertyValueFactory<>("dateAssurance"));
        derniereVT.setCellValueFactory(new PropertyValueFactory<>("dateDVidange"));
        
        voitureList = voitureCRUD.getAll();
        voitureTable.setItems(FXCollections.observableArrayList(voitureList));
        
    }

    @Override
      public void initialize(URL url, ResourceBundle rb) {
        voitureCRUD = new VoitureCRUD(); 
        voitureTable.getColumns().addAll(idV ,matriculeT, marqueT, puissanceT, nbplaceT, kilometrageT, derniereAT, derniereVT);
       
        
        UpdateTable();
        // Configurer les colonnes pour afficher les champs appropriés de l'objet Voiture
        
    }
      
   
         
         
         public void Edit(){
             try{
                 String value1= idVoi.getText();
                 String value2= mat.getText();
                 String value3= marq.getText();
                 String value4= puiss.getText();
                 String value5= kilo.getText();
                 String value6= nbp.getText();
                 
                 Date datee = java.sql.Date.valueOf(dateV.getValue());
                 java.sql.Date sqlDateee = new java.sql.Date(datee.getTime());
                 Date dateee = java.sql.Date.valueOf(dateA.getValue());
                 java.sql.Date sqlDateA = new java.sql.Date(dateee.getTime());
                 long value7= sqlDateee.getTime();
                 long value8= sqlDateA.getTime();
                 
                 
                String sql = "update voiture set id_voiture='"+value1+"',matricule='"+value2+"',marque='"+value3+"',puissance='"+value4+"',kilometrage='"+value5+"',nbplaces='"+value6+"',dateAssurance='"+value7+"',dateDVidange='"+value8+"'"; 
              PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(sql);
             pst.execute();
             JOptionPane.showMessageDialog(null, "Update!");
             UpdateTable();
             
             
             }catch(HeadlessException | SQLException e ){
                 JOptionPane.showMessageDialog(null, e);
             }
                 
                 
                 
             }
         
      

 
    
    @FXML
        public void  add (){

      try {
    // Check if any field is empty or null
    if (mat.getText().isEmpty() || marq.getText().isEmpty() || puiss.getText().isEmpty() || kilo.getText().isEmpty() || nbp.getText().isEmpty() || dateA.getValue() == null || dateV.getValue() == null) {
        JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs du formulaire !");
        return;
    }
    
    String sqlSelect = "SELECT COUNT(*) FROM voiture WHERE matricule = ?";
    PreparedStatement pstSelect = MyConnection.getInstance().getCnx().prepareStatement(sqlSelect);
    pstSelect.setString(1, mat.getText());
    ResultSet rs = pstSelect.executeQuery();
    rs.next();
    int count = rs.getInt(1);
    if (count > 0) {
        JOptionPane.showMessageDialog(null, "Cette voiture existe déjà !");
        return;
    }
    
    String sql="INSERT INTO voiture (matricule , marque , puissance, kilometrage, nbplaces, dateAssurance , dateDVidange )"+ "VALUES (?,?,?,?,?,?,?)";
    PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(sql);
    Date date = java.sql.Date.valueOf(dateA.getValue());
    java.sql.Date sqlDate = new java.sql.Date(date.getTime());
    
    Date datee = java.sql.Date.valueOf(dateV.getValue());
    java.sql.Date sqlDatee = new java.sql.Date(datee.getTime());

    pst.setString(1, mat.getText());
    pst.setString(2, marq.getText());
    pst.setString(3, puiss.getText());
    pst.setString(4 ,kilo.getText());
    pst.setString(5, nbp.getText());
    pst.setDate(6, sqlDate);
    pst.setDate( 7 ,sqlDatee);
    pst.executeUpdate();
    System.out.println("Done!");
    JOptionPane.showMessageDialog(null, "Voiture ajoutée avec succès !");
    UpdateTable();
} catch (SQLException e) {
     System.out.println(e.getMessage());
}
        
    }
        
    @FXML
     public void Delete() throws SQLException{
    int choice = JOptionPane.showConfirmDialog(null, "Voulez-vous vraiment supprimer le produit N°" + idVoi.getText() + " ?", "Confirmation de suppression", JOptionPane.YES_NO_OPTION);
    if (choice != JOptionPane.YES_OPTION) {
        return;
    }
    
    String sql="DELETE FROM voiture WHERE id_voiture=?";
    try {
        PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(sql);
        pst.setString(1,idVoi.getText());
        int rowsAffected = pst.executeUpdate();
        if (rowsAffected == 0) {
            JOptionPane.showMessageDialog(null, "ID does not exist!");
        } else {
            JOptionPane.showMessageDialog(null, "Deleted!");
            UpdateTable();
        }
    }
    catch (HeadlessException | SQLException e) {
        // handle errors here
    }   
}
     
     
     
    @FXML
     public void maintenance_view(ActionEvent event){
         
        try {
            
            FXMLLoader loader=new FXMLLoader(getClass().getResource("MainVoiture.fxml"));
            Parent root=loader.load();
            maintenancee.getScene().setRoot(root);
            
           
        } catch (IOException ex) {
            System.out.println(ex);
        }
         
         
       
     }
     private List <Voiture> voitureList1 ;
     
   void handlePrintButtonAction(ActionEvent event) {
    voitureCRUD = new VoitureCRUD();

    voitureList1 = voitureCRUD.getAll();
    System.out.println(voitureList1); // récupérez la liste des voitures à partir de votre modèle
    VoiturePDFGenerator.generatePDF(voitureList1);
    System.out.println("Document PDF généré avec succès !");
}


    @FXML
    private void handlePdfButton(ActionEvent event) throws IOException {
               com.itextpdf.text.Document document = new com.itextpdf.text.Document();
              try {
            PdfWriter.getInstance(document, new FileOutputStream("voiture.pdf"));
            
            document.open();
            document.addTitle("Titre du document");
            // Create a BaseColor instance with RGB values
BaseColor myColor = new BaseColor(150, 12, 172);

// Set the background color for the document
 document.add(new Chunk("liste des voitures ", new Font(Font.FontFamily.HELVETICA, 15 , Font.BOLD, myColor)));

            PdfPTable table = new PdfPTable(8); // 3 columns

            // Add table headers
            
            table.addCell("ID");
            table.addCell("matricule");
            table.addCell("marque ");
            table.addCell("puissance ");
            table.addCell("kilometrage ");
            table.addCell("nombre de place");
            table.addCell("date derniere assurance");
            table.addCell("date derniere vidange ");
                        Connection conn = MyConnection.getInstance().getCnx();
            // Add table rows from the database
            String query = "SELECT * FROM voiture";
            ResultSet resultSet = conn.createStatement().executeQuery(query);
            
  
            while (resultSet.next()) {
                int id = resultSet.getInt("id_voiture");
                String matricule = resultSet.getString("matricule");
                String marque = resultSet.getString("marque");
                String puissance = resultSet.getString("puissance");
                int kilometrage = resultSet.getInt("kilometrage");
                int nbplaces = resultSet.getInt("nbplaces");
                int dateassurance = resultSet.getInt("dateAssurance");
                int datevidange = resultSet.getInt("dateDVidange");
               
                table.addCell(Integer.toString(id));   //ism les attribut ml base 
                table.addCell(matricule);
                table.addCell(marque);
                table.addCell(puissance);
                table.addCell(Integer.toString(kilometrage));
                table.addCell(Integer.toString(nbplaces));
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                table.addCell(formatter.format(dateassurance));
                table.addCell(formatter.format(datevidange));
            }
            document.add(table);
            document.close();
            Process pro = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler voiture.pdf");
JOptionPane.showMessageDialog(null, "Les voitures ont été exportées dans le fichier voiture.pdf");
        } catch (FileNotFoundException | DocumentException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Erreur lors de l'exportation des données des emplois : " + e.getMessage());
        }


            
         

    }
}






            

    
