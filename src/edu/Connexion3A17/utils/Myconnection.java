/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Connexion3A17.utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAHBI
 */
public class Myconnection {
    String url="jdbc:mysql://localhost:3307/fithniytik1";
     String login="root";
     String pwd="";
     private Connection cnx ;
     private static  Myconnection instance;

    public Connection getCnx() {
        return cnx;
    }

    public void setCnx(Connection cnx) {
        this.cnx = cnx;
    }

  public Myconnection() {
        
        try {
           cnx=  DriverManager.getConnection(url, login, pwd);
            System.out.println("connexion établie!");
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
        }
    }

 public  static Myconnection getInstance(){
if (instance == null){
    
    
    
    instance = new Myconnection();
}
 return instance;
 
 
 }

}

