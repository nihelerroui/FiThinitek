package edu.services.tests;

import edu.fithnitik.entities.Bien;
import edu.fithnitik.entities.OffreCovoiturage;
import edu.fithnitik.services.BienCRUD;
import edu.fithnitik.services.OffreCovoiturageCRUD;
import edu.fithnitik.utils.MyConnection;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainClass {
    public static void main(String [] args){
       
            Connection cnx = MyConnection.getInstance().getCnx();
            
            OffreCovoiturage oc;
             oc = new OffreCovoiturage(35, "132tunis6519", "bmw", new Date(122, 2, 19), "kef", "tunis", true, 4, "+216504", 1, 1, 4);
            OffreCovoiturage oc1;
           // oc1 = new OffreCovoiturage(2, "132tunis6521", "pagani", new Date(122, 2, 19), "sfax", "tunis", false, 2, "+216504", 1, 1, 4);
            
            OffreCovoiturageCRUD pcd = new OffreCovoiturageCRUD();
            
            //pcd.create(oc);
            //pcd.create(oc1);
            
            pcd.update(oc);
           //pcd.delete(oc);
            
            
            //Bien b = new Bien(2, "nadhem", "texttexttexttextxx", "25e52dc5161", "50427525", 7);
            //Bien b1 = new Bien(3, "nadhem", "texttexttexttext", "25e52dc5161", "50427525", 7);
            
            //BienCRUD pcd1 = new BienCRUD();
            
            //pcd1.create(b);
            //pcd1.update(b);
            //pcd1.delete(b);
        
    }
}
    

