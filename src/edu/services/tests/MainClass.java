package edu.services.tests;

import edu.fithnitik.entities.Bien;
import edu.fithnitik.entities.CalculeDistance;
import edu.fithnitik.entities.Localisation;
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

    public static void main(String[] args) {
        

        Connection cnx = MyConnection.getInstance().getCnx();

        OffreCovoiturage oc;
        oc = new OffreCovoiturage(35, "132tunis6519", "bmw", new Date(122, 2, 19), "kef", "tunis", "oui", 4, "+216504", 4, 142.2);
        OffreCovoiturage oc1;
        //oc1 = new OffreCovoiturage(2, "132tunis6521", "pagani", new Date(122, 2, 19), "sfax", "tunis", "oui", 2, "+216504", );

        OffreCovoiturageCRUD pcd = new OffreCovoiturageCRUD();

        //pcd.create(oc);
        //pcd.create(oc1);
        //pcd.update(oc);
        //pcd.delete(oc);
        //Bien b = new Bien(3, "kef", "tunis", new Date(122, 2, 19), "45661");
        //Bien b1 = new Bien(3, "nadhem", "texttexttexttext", "25e52dc5161", "50427525", 7);

       // BienCRUD pcd1 = new BienCRUD();

        //pcd1.create(b);
        //pcd1.update(b);
        //pcd1.delete(b);
        //double distance = CalculeDistance.distance(36.1680, 8.7096, 36.806389, 10.181667);
        //System.out.println("Distance entre Kef et Tunis : " + distance + " km");
    
        //Localisation temp = new Localisation("hhh");
    
    }
}
