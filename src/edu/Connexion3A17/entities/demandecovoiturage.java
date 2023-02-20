/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.Connexion3A17.entities;

/**
 *
 * @author SAHBI
 */
public class demandecovoiturage {
    private int id;
    private  String dateReservation;
        public  int  nbplace;
        

    public demandecovoiturage() {
    }

    public demandecovoiturage(int id, String dateReservation,int nbplace) {
        this.id = id;
        this.dateReservation = dateReservation;
        this.nbplace = nbplace;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(String dateReservation) {
        this.dateReservation = dateReservation;
    }

    public int  getNbplace() {
        return nbplace;
    }

    public void setNbplace(int nbplace) {
        this.nbplace = nbplace;
    }

    @Override
    public String toString() {
        return "demandecovoiturage{" + "id=" + id + ", dateReservation=" + dateReservation + ", nbplace=" + nbplace + '}';
    }

   
}
