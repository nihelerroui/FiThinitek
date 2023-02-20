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
import tn.covoiturage_1.entities.Reclamation;
import tn.covoiturage_1.interfaces.InterfaceCRUD;
import tn.covoiturage_1.utils.MyConnection;

/**
 *
 * @author Nihel
 */
public class ReclamationCRUD implements InterfaceCRUD <Reclamation>{
    private Connection cnx ;
    
    public ReclamationCRUD()
    {
        cnx= MyConnection.getInstance().getCnx();
    }

    @Override
    public void create(Reclamation t) {
        try {
            String requete = "INSERT INTO reclamation(intitule, contenu, id_usr)"
                    + " VALUES (?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                                    .prepareStatement(requete);
            pst.setString(1, t.getIntitule());
            pst.setString(2, t.getContenu());
            pst.setInt(3, t.getId_usr());
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
            
            String request="DELETE FROM reclamation WHERE id ='"+id+"'";
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(request);
            
            rslt=pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
       return rslt==1;
    }

    @Override
    public List<Reclamation> selectAll() {
         
        List<Reclamation> reclamations = new ArrayList();
        
        try {
            String request = "SELECT * FROM reclamation";
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(request);
            
            ResultSet rs=  pst.executeQuery(request);
            
            while(rs.next()){
                
                Reclamation r = new Reclamation();
                
                r.setId(rs.getInt(1));
                r.setIntitule(rs.getString(2));
                r.setContenu(rs.getString(3));
                r.setId_usr(rs.getInt(4));
                
                reclamations.add(r);
                
            }
            
        } catch (SQLException ex) {
            
            System.out.println(ex.getMessage());
            
        }
       return reclamations;
    }
  
}
