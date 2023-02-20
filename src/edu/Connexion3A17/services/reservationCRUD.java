/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Connexion3A17.services;

import edu.Connexion3A17.entities.demandecovoiturage;
import edu.Connexion3A17.interfaces.InterfaceCRUD;
import edu.Connexion3A17.utils.Myconnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 * @author SAHBI
 */
public class reservationCRUD implements InterfaceCRUD<demandecovoiturage> {

    @Override
    public void ajouterEntitee(demandecovoiturage t) {
       
        String req = "insert into Questions (id,dateReservation,nbplace) values"
                + " ( '" + t.getId() + "', '" + t.getDateReservation() + "', '" + t.getNbplace() + "')";
        try {
     PreparedStatement ps = Myconnection.getInstance().getCnx().prepareStatement(req);
         //   st.executeUpdate(req);
            System.out.println("done!");
        } catch (SQLException ex) {
            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override

    public ObservableList<demandecovoiturage> listeDesEntites() {
        ObservableList<demandecovoiturage> list = FXCollections.observableArrayList();

        try {

            String requete = " SELECT *FROM demandecovoiturage";
            Statement st = Myconnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {

                demandecovoiturage p = new demandecovoiturage();

                p.setId(rs.getInt(1));
                p.setDateReservation(rs.getString(2));          //   p.setNom(rs.getString("nom"));
                p.setNbplace(rs.getInt(3));
                list.add(p);

            }

        } catch (SQLException ex) {
            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public void modifier(demandecovoiturage t) {

        try {
            String req = "update demandecovoiturage set dateReservation = ? , nbplace_ = ? where id= ? ";
            PreparedStatement ps = Myconnection.getInstance().getCnx().prepareStatement(req);
            ps.setInt(1, t.getId());
            ps.setString(2, t.getDateReservation());
            ps.setInt(3, t.getNbplace());

            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void supprimer(int id) {

        try {
            String requete = "delete from demande reservation where id = ?";
            PreparedStatement ps = Myconnection.getInstance().getCnx().prepareStatement(requete);
            
            ps.setInt(1, id);
              ps.executeUpdate();
        } catch (SQLException ex) {
            
            
            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }

        

    }

}

//    @Override
//    public void ajouterEntitee(reservation t) {
//        String requete = "INSERT INTO personne (nom, prenom) "
//                + "VALUES('"+t.getNom()+"','"+t.getPrenom()+"');
//        try {
//            Statement st = new Myconnection().getCnx().createStatement();
//            st.executeUpdate(requete);
//            System.out.println("done!");
//        } catch (SQLException ex) {
//            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    @Override
//    public List<reservation> listeDesEntites() {
//        List<reservation> mylist = new ArrayList<>();
//        try {
//
//            String requete = " SELECT *FROM demandecovoiturage";
//            Statement st = Myconnection.getInstance().getCnx().createStatement();
//            ResultSet rs = st.executeQuery(requete);
//            while (rs.next()) {
//                reservation p = new reservation();
//                p.setid(rs.getInt(1));
//                p.setDatereservation(rs.getString(2)) ;          //   p.setNom(rs.getString("nom"));
//                p.setnbplace(rs.getString(3));
//                mylist.add(p);
//
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//    public void modifier(reservation p) {
//        try {
//            String req = "update Personne set nom = ? , prenom = ? where id= ? ";
//     PreparedStatement ps = Myconnection.getInstance().getCnx().prepareStatement(req);
//            ps.setString(1, p.getNom());
//            ps.setString(2, p.getPrenom());
//            ps.setInt(3, p.getId());
//           
//
//            ps.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//  public void supprimer(int id) {
//        try {
//            String req = "delete from Perrsonne  where id = ?";
//     PreparedStatement ps = Myconnection.getInstance().getCnx().prepareStatement(req);
//            ps.setInt(1, id);
//            ps.executeUpdate();
//        } catch (SQLException ex) {
//            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
//
//    @Override
//    public void ajouterEntitee(demandecovoiturage t) {
//     String requete = "INSERT INTO personne (nom, prenom) "
//                + "VALUES(?,?)";
//        try {
//            //PreparedStatement pst = new Myconnection().getCnx().prepareStatement(requete);
//            PreparedStatement pst = Myconnection.getInstance().getCnx().prepareStatement(requete);
//
//            pst.setString(1, t.getId_D());
//            pst.setString(2, t.getDate_R());
//            pst.setString(3, t.getNb_place());
//            pst.executeUpdate();
//            System.out.println("done!");
//        } catch (SQLException ex) {
//            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    @Override
//    public void modifier(demandecovoiturage t) {
//   try {
//            String req = "update Personne set date_R = ? , nb_ = ? where id= ? ";
//     PreparedStatement ps = Myconnection.getInstance().getCnx().prepareStatement(req);
//            ps.setString(1, t.getId_D());
//            ps.setString(2, t.getDate_R());
//            ps.setInt(3, t.getNb_place());
//           
//
//            ps.executeUpdate();
//
//        } catch (SQLException ex) {
//            Logger.getLogger(reservationCRUD.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }

