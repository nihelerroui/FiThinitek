package edu.voiture.entities;

import java.util.Date;

public class Voiture {
    private int id_voiture;
    private String matricule; 
    private String marque; 
    private String puissance; 
    private int kilometrage;
    private int nbplaces;
    private Date dateAssurance; 
    private Date dateDVidange; 

    public Voiture(int id_voiture ,String matricule, String marque, String puissance, int kilometrage, int nbplaces, Date dateAssurance , Date dateDVidange) { 
        this.id_voiture = id_voiture;
        this.matricule = matricule;
        this.marque = marque;
        this.puissance = puissance;
        this.kilometrage = kilometrage;
        this.nbplaces = nbplaces;
        this.dateAssurance = dateAssurance;
        this.dateDVidange = dateDVidange;
    }
public Voiture (int id_voiture ,String matricule, Date dateAssurance , Date dateDVidange) { 
        this.id_voiture = id_voiture;
        this.matricule = matricule;
        this.dateAssurance = dateAssurance;
        this.dateDVidange = dateDVidange;
    }

    public Voiture(String string, java.sql.Date date, java.sql.Date date0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public String toString() {
        return "Voiture{" + "id=" + id_voiture + ", matricule=" + matricule + ", marque=" + marque + ", puissance=" + puissance + ", kilometrage=" + kilometrage + ", nbplaces=" + nbplaces + ", dateAssurance=" + dateAssurance + ", dateDVidange=" + dateDVidange + '}';
    }

    public Voiture() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_voiture() {
        return id_voiture;
    }

    public void setId_voiture(int id_voiture) {
        this.id_voiture = id_voiture;
    }

  
    

    
    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getPuissance() {
        return puissance;
    }

    public void setPuissance(String puissance) {
        this.puissance = puissance;
    }

    public int getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(int kilometrage) {
        this.kilometrage = kilometrage;
    }

    public int getNbplaces() {
        return nbplaces;
    }

    public void setNbplaces(int nbplaces) {
        this.nbplaces = nbplaces;
    }

    public Date getDateAssurance() {
        return dateAssurance;
    }

    public void setDateAssurance(Date dateAssurance) {
        this.dateAssurance = dateAssurance;
    }

    public Date getDateDVidange() {
        return dateDVidange;
    }

    public void setDateDVidange(Date dateDVidange) {
        this.dateDVidange = dateDVidange;
    }
}