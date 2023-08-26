package edu.fithnitek.services;

import edu.fithnitek.entities.CalculeDistance;
import static edu.fithnitek.entities.CalculeDistance.distance;
import edu.fithnitek.entities.OffreCovoiturage;
import edu.fithnitek.utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OffreCovoiturageCRUD extends CalculeDistance{

    private final Connection cnx;

    public OffreCovoiturageCRUD() {
        cnx = MyConnection.getInstance().getCnx();
    }



    public void delete(OffreCovoiturage t) {
        String requete = "DELETE FROM offrecovoiturage WHERE id=?";
       try {
          
           PreparedStatement pst = MyConnection.getInstance().getCnx()
                   .prepareStatement(requete);
           pst.setInt(1, t.getId());
           int row = pst.executeUpdate();
           if (row == 1) {
               System.out.println("Offre supprimé");
            } else {
                System.out.println(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OffreCovoiturageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<OffreCovoiturage> selectAll() {
        List<OffreCovoiturage> myList = new ArrayList<>();
        String query = "SELECT * FROM OffreCovoiturage";

        try (Statement st = MyConnection.getInstance().getCnx().createStatement();
             ResultSet rs = st.executeQuery(query)) {

            while (rs.next()) {
                OffreCovoiturage oc = new OffreCovoiturage();
                oc.setId(rs.getInt("id"));
                oc.setMatricule(rs.getString("matricule"));
                oc.setMarque(rs.getString("marque"));
                oc.setDateD(rs.getDate("dateD"));
                oc.setLieuD(rs.getString("lieuD"));
                oc.setLieuA(rs.getString("lieuA"));
                oc.setDispo(rs.getString("dispo"));
                oc.setNbPlace(rs.getInt("nbPlace"));
                oc.setNumTel(rs.getInt("numTel"));

                double latdepart = rs.getDouble("latitude_depart");
                double londepart = rs.getDouble("longitude_depart");
                double latarriver = rs.getDouble("latitude_arrivee");
                double lonarriver = rs.getDouble("longitude_arrivee");
                double distance = CalculeDistance.distance(latdepart, londepart, latarriver, lonarriver);
                oc.setDistance(distance);
                //oc.setIdUser(rs.getInt("idUser"));

                myList.add(oc);
            }
        } catch (SQLException ex) {
            System.out.println("Error while retrieving data from database: " + ex.getMessage());
            ex.printStackTrace();
        }
        return myList;
    }


        
}
