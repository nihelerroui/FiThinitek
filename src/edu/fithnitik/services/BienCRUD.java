
package edu.fithnitik.services;

import edu.fithnitik.entities.Bien;
import edu.fithnitik.interfaces.InterfaceCRUD;
import edu.fithnitik.utils.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadhem
 */
public class BienCRUD  {
    private Connection cnx;
    public BienCRUD()
    {
        cnx=MyConnection.getInstance().getCnx();
    }
    
    public void create(Bien t) {
        try {
            String requete = "INSERT INTO Bien(nomRecepteur,description,reference,telRecept,quantite)"+"values(?,?,?,?,?)";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            
            pst.setString(1, t.getNomRecepteur());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getReference());
            pst.setString(4, t.getTelRecept());
            pst.setInt(5, t.getQuantite());
            pst.executeUpdate();
            System.out.println("Bien ajouté");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    
    public void update(Bien t) {
        try {
            String requete= "UPDATE bien SET nomRecepteur=?,description=?,reference=?,telRecept=?,quantite=? WHERE id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            
            pst.setString(1, t.getNomRecepteur());
            pst.setString(2, t.getDescription());
            pst.setString(3, t.getReference());
            pst.setString(4, t.getTelRecept());
            pst.setInt(5, t.getQuantite());
            pst.setInt(6, t.getId());
            pst.executeUpdate();
            System.out.println("Bien modifié");
        } catch (SQLException ex) {
            Logger.getLogger(BienCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public void delete(Bien t) {
        try {
            String requete = "DELETE FROM Bien WHERE id=?";
            PreparedStatement pst = MyConnection.getInstance().getCnx()
                    .prepareStatement(requete);
            pst.setInt(1, t.getId());
            int row = pst.executeUpdate();
            if(row==1)
            {
                System.out.println("Bien supprimé");
            }
            else
            {
                System.out.println(row);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BienCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    public List<Bien> selectAll() {
         List<Bien> myList = new ArrayList<>();
        try {
           
            String requete = "SELECT * FROM Bien";
            Statement st = MyConnection.getInstance().getCnx()
                    .createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next())
            {
                Bien b = new Bien();
                b.setId(rs.getInt(1));
                b.setNomRecepteur(rs.getString(2));
                b.setDescription(rs.getString(3));
                b.setReference(rs.getString(4));
                b.setTelRecept(rs.getString(5));
                b.setQuantite(rs.getInt(6));
                myList.add(b);
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(BienCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return myList;
    }
    
}
