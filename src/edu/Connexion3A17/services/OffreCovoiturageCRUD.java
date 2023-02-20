/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Connexion3A17.services;

import edu.Connexion3A17.entities.OffreCovoiturage;
import java.sql.Connection;
import edu.Connexion3A17.utils.Myconnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SAHBI
 */
public class OffreCovoiturageCRUD {
    
    private Connection cnx ;
    
    public OffreCovoiturageCRUD()
    {
        //cnx= MyConnection.getInstance().getCnx();
    }

    public void create(OffreCovoiturage t)  {
        try {
            String requete="INSERT INTO OffreCovoiturage(matricule, marque, dateD, lieuD, lieuA, dispo, nbPlace, numTel, idUsr, idAvis, idDemande)"
                    +"values(?,?,?,?,?,?,?,?,?,?,?)";
     PreparedStatement pst = Myconnection.getInstance().getCnx()     .prepareStatement(requete);
            pst.setString(1, t.getMatricule());
            pst.setString(2, t.getMarque());
            pst.setDate(3, t.getDateD());
            pst.setString(4, t.getLieuD());
            pst.setString(5, t.getLieuA());
            pst.setBoolean(6, t.isDispo());
            pst.setInt(7, t.getNdPlace());
            pst.setInt(8, t.getNumTel());
            pst.setInt(9, t.getIdUsr());
            pst.setInt(10, t.getIdAvis());
            pst.setInt(11, t.getIdDemande());
            pst.executeUpdate();
            System.out.println("Offre ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
    }

    public void update(OffreCovoiturage t) throws SQLException {
        
        String requete = "UPDATE offrecovoiturage SET matricule=?,marque=?,dateD=?,lieuD=?, lieuA=?, dispo=?,"
                + "nbPlace=?,numTel=?,id_usr=?,id_avis=?,id_demande=?  WHERE iq=?";
     PreparedStatement pst = Myconnection.getInstance().getCnx()
                                    .prepareStatement(requete);
        pst.setString(1, t.getMatricule());
        pst.setString(2, t.getMarque());
        pst.setDate(3, t.getDateD());
        pst.setString(4, t.getLieuD());
        pst.setString(5, t.getLieuA());
        pst.setBoolean(6, t.isDispo());
        pst.setInt(7, t.getNdPlace());
        pst.setInt(8, t.getNumTel());
        pst.setInt(9, t.getIdUsr());
        pst.setInt(10, t.getIdAvis());
        pst.setInt(11, t.getIdDemande());
        pst.executeUpdate(requete);
        System.out.println("Offre modifié");
                
    }

    public void delete(OffreCovoiturage t) throws SQLException {
        String requete = "DELETE FROM offrecovoiturage WHERE id=?";
            PreparedStatement pst = Myconnection.getInstance().getCnx().prepareStatement(requete);

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

    }

    public List<OffreCovoiturage> selectAll() throws SQLException {
        List<OffreCovoiturage> myList = new ArrayList<>();
        String requete = "SELECT * FROM OffreCovoiturage";
            PreparedStatement ps = Myconnection.getInstance().getCnx().prepareStatement(requete);

        ResultSet rs = ps.executeQuery(requete);
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
            oc.setNumTel(rs.getInt(9));
            oc.setIdUsr(rs.getInt(10));
            oc.setIdAvis(rs.getInt(11));
            oc.setIdDemande(rs.getInt(12));
            myList.add(oc);
            
        }
        return myList;
        
    }
    
    
}

