/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Connexion3A17.interfaces;

import edu.Connexion3A17.entities.demandecovoiturage;
import java.util.List;

/**
 *
 * @author SAHBI
 * @param <T>
 */
public interface InterfaceCRUD <T>{
    public void ajouterEntitee( T t);
    public List <T> listeDesEntites();
     public void modifier(T t);
     public void supprimer(int id);
}
