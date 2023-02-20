/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.covoiturage_1.tests;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import tn.covoiturage_1.entities.Avis;
import tn.covoiturage_1.entities.Reclamation;
import tn.covoiturage_1.entities.User;
import tn.covoiturage_1.services.AvisCRUD;
import tn.covoiturage_1.services.ReclamationCRUD;
import tn.covoiturage_1.utils.MyConnection;

/**
 *
 * @author Nihel
 */
public class MainClass {
    public static void main(String[] args) throws SQLException {
        //Connection cnx = MyConnection.getInstance().getCnx();
        User usr = new User("roui","nihel","nihelroui","aaaa","demandeur");
        Reclamation r = new Reclamation(3,"Rec3", "tattat",1);
        ReclamationCRUD rcd = new ReclamationCRUD();
        //rcd.create(r);
         //System.out.println(rcd.delete(r));
         System.out.println(rcd.selectAll());
           
        
        Avis a = new Avis(1,"commentaire1",2,0);
        AvisCRUD acd = new AvisCRUD();
        //acd.create(a);  
        //System.out.println(acd.selectAll());
        //System.out.println(acd.delete(a));
       
    }
    
}
