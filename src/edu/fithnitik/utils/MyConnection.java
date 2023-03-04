
package edu.fithnitik.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {

    String url="jdbc:mysql://localhost:3306/fithnitek";
    String login="root";
    String pwd="";
    private Connection cnx;
    private static MyConnection instance;

    public MyConnection() {
        try {
         cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion établie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }
    
    public static MyConnection getInstance(){
        if(instance == null){
            instance = new MyConnection();
        }
         return instance;
    }
    
}

