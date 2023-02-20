/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.covoiturage_1.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tn.covoiturage_1.entities.Avis;
import tn.covoiturage_1.entities.Reclamation;
import tn.covoiturage_1.interfaces.InterfaceCRUD;
import tn.covoiturage_1.utils.MyConnection;

/**
 *
 * @author Nihel
 */
public class AvisCRUD implements InterfaceCRUD <Avis>{
    private Connection cnx ;
    
    public AvisCRUD()
    {
        cnx= MyConnection.getInstance().getCnx();
    }

    @Override
    public void create(Avis t) {
        try {
            String requete = "INSERT INTO avis(commentaire, id_usr)"
                    + " VALUES (?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                                    .prepareStatement(requete);
            pst.setString(1, t.getCommentaire());
            pst.setInt(2, t.getId_usr());
            pst.executeUpdate();
            System.out.println("Done!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Override
    public boolean delete(int id) {
        int rslt = 0 ;
            
        try {
            
            String request="DELETE FROM avis WHERE id ='"+id+"'";
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(request);
            
            rslt=pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return rslt==1;
    }

    @Override
    public List<Avis> selectAll() {
         List<Avis> avis = new ArrayList();
        
        try {
            String request = "SELECT * FROM avis";
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(request);
            
            ResultSet rs=  pst.executeQuery(request);
            
            while(rs.next()){
                
                Avis a = new Avis();
                
                a.setId(rs.getInt(1));
                a.setCommentaire(rs.getString(2));
                a.setId_usr(rs.getInt(3));
                //a.setId_offre(rs.getInt(4));
                
                avis.add(a);
                
            }
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
       return avis;
    }

   
    
}
