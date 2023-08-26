package edu.fithnitek.entities;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

public class OffreCovoiturage {





    public int id;
    private String lieuD;
    private String lieuA;
    private Date dateD;
    private String dispo;
    private int nbPlace;
    private String matricule;
    private String marque;
    private int numTel;
    public double distance;
    public int idUser;
    private String depart;
    private String arriver;
    private float latdepart;
    private float latarriver;
    private float londepart;
    private float lonarriver;
    

    public OffreCovoiturage() {

    }

    public OffreCovoiturage(int id, String lieuD, String lieuA, Date dateD, String dispo, int nbPlace, String matricule, String marque, int numTel, double distance, int idUser) {
        this.id = id;
        this.lieuD = lieuD;
        this.lieuA = lieuA;
        this.dateD = dateD;
        this.dispo = dispo;
        this.nbPlace = nbPlace;
        this.matricule = matricule;
        this.marque = marque;
        this.numTel = numTel;
        this.distance = distance;
        this.idUser = idUser;
    }

    public OffreCovoiturage(int id, String lieuD, String lieuA, Date dateD, String dispo, int nbPlace, String matricule, String marque, int numTel, double distance) {
        this.id = id;
        this.lieuD = lieuD;
        this.lieuA = lieuA;
        this.dateD = dateD;
        this.dispo = dispo;
        this.nbPlace = nbPlace;
        this.matricule = matricule;
        this.marque = marque;
        this.numTel = numTel;
        this.distance = distance;
    }
    
    
    

    public OffreCovoiturage(int id, String lieuD, String lieuA, Date dateD, String dispo, int nbPlace, String matricule, String marque, int numTel) {
        this.id = id;
        this.lieuD = lieuD;
        this.lieuA = lieuA;
        this.dateD = dateD;
        this.dispo = dispo;
        this.nbPlace = nbPlace;
        this.matricule = matricule;
        this.marque = marque;
        this.numTel = numTel;
    }

    public OffreCovoiturage(String lieuD, String lieuA, Date dateD, String dispo, int nbPlace, String matricule, String marque, int numTel, double distance) {
        this.lieuD = lieuD;
        this.lieuA = lieuA;
        this.dateD = dateD;
        this.dispo = dispo;
        this.nbPlace = nbPlace;
        this.matricule = matricule;
        this.marque = marque;
        this.numTel = numTel;
        this.distance = distance;
    }


    
    


    


    public double getDistance() {
        return distance;
    }

    public int getId() {
        return id;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getMarque() {
        return marque;
    }

    public Date getDateD() {
        return dateD;
    }

    public String getLieuD() {
        return lieuD;
    }

    public String getLieuA() {
        return lieuA;
    }

    public String isDispo() {
        return dispo;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public int getNumTel() {
        return numTel;
    }

    public int getIdUser() {
        return idUser;
    }



    
    
    
    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public void setDateD(Date dateD) {
        this.dateD = dateD;
    }

    public void setLieuD(String lieuD) {
        this.lieuD = lieuD;
    }

    public void setLieuA(String lieuA) {
        this.lieuA = lieuA;
    }

    public void setDispo(String dispo) {
        this.dispo = dispo;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public void setNumTel(int numTel) {
        this.numTel = numTel;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "OffreCovoiturage{" + "id=" + id + ", matricule=" + matricule + ", marque=" + marque + ", dateD=" + dateD + ", lieuD=" + lieuD + ", lieuA=" + lieuA + ", dispo=" + dispo + ", nbPlace=" + nbPlace + ", numTel=" + numTel + ", distance=" + distance + ", depart=" + depart + ", arriver=" + arriver + ", latdepart=" + latdepart + ", latarriver=" + latarriver + ", londepart=" + londepart + ", lonarriver=" + lonarriver + ", idUser=" + idUser + '}';
    }









}
