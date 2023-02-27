/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.voiture.test;

import edu.voiture.entities.Voiture;
import edu.voiture.services.VoitureCRUD;
import java.sql.Date;

/**
 *
 * @author USER
 */
public class MainClass {
    
    
    public static void main(String[] args) {
        Date dt = new Date(12/1/2020);
        
        
        Voiture t= new Voiture (9,"gttg","gg", "gggg",555,4, dt  , dt);
        VoitureCRUD vt = new VoitureCRUD();
        vt.add(t);
        
        
        
       
        
        
              
        
        
        
        
    }
    
}
