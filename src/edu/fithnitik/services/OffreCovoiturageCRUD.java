
package edu.fithnitik.services;

import edu.fithnitik.entities.OffreCovoiturage;
import edu.fithnitik.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class OffreCovoiturageCRUD {
    private final Connection cnx ;
    
    public OffreCovoiturageCRUD()
    {
        cnx= MyConnection.getInstance().getCnx();
    }

    public void create(OffreCovoiturage t)  {
        try {
            String requete="INSERT INTO OffreCovoiturage(matricule, marque, dateD, lieuD, lieuA, dispo, nbPlace, numTel, id_usr, id_Avis, id_Demande)"
                    +"values(?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, t.getMatricule());
            pst.setString(2, t.getMarque());
            pst.setDate(3, t.getDateD());
            pst.setString(4, t.getLieuD());
            pst.setString(5, t.getLieuA());
            pst.setBoolean(6, t.isDispo());
            pst.setInt(7, t.getNdPlace());
            pst.setString(8, t.getNumTel());
            pst.setInt(9, t.getIdUsr());
            pst.setInt(10, t.getIdAvis());
            pst.setInt(11, t.getIdDemande());
            pst.executeUpdate();
            System.out.println("Offre ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public void update(OffreCovoiturage t) {
        
        try {
            String requete = "UPDATE OffreCovoiturage SET matricule=?,marque=?,dateD=?,lieuD=?, lieuA=?, dispo=?,"
                    + "nbPlace=?,numTel=?,id_usr=?,id_avis=?,id_demande=?  WHERE id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setString(1, t.getMatricule());
            pst.setString(2, t.getMarque());
            pst.setDate(3, t.getDateD());
            pst.setString(4, t.getLieuD());
            pst.setString(5, t.getLieuA());
            pst.setBoolean(6, t.isDispo());
            pst.setInt(7, t.getNdPlace());
            pst.setString(8, t.getNumTel());
            pst.setInt(9, t.getIdUsr());
            pst.setInt(10, t.getIdAvis());
            pst.setInt(11, t.getIdDemande());
            pst.setInt(12, t.getId());
            pst.executeUpdate();
            System.out.println("Offre modifié");
        } catch (SQLException ex) {
            Logger.getLogger(OffreCovoiturageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
                
    }

    public void delete(OffreCovoiturage t) {
        try {
            String requete = "DELETE FROM offrecovoiturage WHERE id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId());
            int row = pst.executeUpdate();
            if(row==1)
            {
                System.out.println("Offre supprimé");
            }
            else
            {
                System.out.println(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OffreCovoiturageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<OffreCovoiturage> selectAll() {
        List<OffreCovoiturage> myList = new ArrayList<>();
        try {
            
            String requete = "SELECT * FROM OffreCovoiturage";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next())
            {
                OffreCovoiturage oc = new OffreCovoiturage();
                oc.setId(rs.getInt(1));
                oc.setMatricule(rs.getString(2));
                oc.setMarque(rs.getString(3));
                oc.setDateD(rs.getDate(4));
                oc.setLieuD(rs.getString(5));
                oc.setLieuA(rs.getString(6));
                oc.setDispo(rs.getBoolean(7));
                oc.setNdPlace(rs.getInt(8));
                oc.setNumTel(rs.getString(9));
                oc.setIdUsr(rs.getInt(10));
                oc.setIdAvis(rs.getInt(11));
                oc.setIdDemande(rs.getInt(12));
                myList.add(oc);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(OffreCovoiturageCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    }
    
    
}
