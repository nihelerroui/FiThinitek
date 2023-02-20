/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Connexion3A17.test;

import edu.Connexion3A17.entities.demandecovoiturage;
import edu.Connexion3A17.services.reservationCRUD;
import edu.Connexion3A17.utils.Myconnection;

/**
 *
 * @author SAHBI
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
       // Myconnection mc =new Myconnection();
       demandecovoiturage p = new demandecovoiturage (22, "19/02/2023 08:00", 2);
       reservationCRUD pcd = new reservationCRUD();//ajouterentitie situé dans personnecrud
       pcd.ajouterEntitee(p);
       pcd.modifier(p);
      // pcd.supprimer(p);

    }
    
    
}
