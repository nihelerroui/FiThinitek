
package edu.fithnitik.entities;

import java.sql.Date;


public class OffreCovoiturage {
    private int id;
    private String matricule;
    private String marque;
    private Date dateD;
    private String lieuD;
    private String lieuA;
    private boolean dispo;
    private int ndPlace;
    private String numTel;
    private int idUsr;
    private int idAvis;
    private int idDemande;
    
    
   public OffreCovoiturage(){
       
   }

    public OffreCovoiturage(int id, String matricule, String marque, Date dateD, String lieuD, String lieuA, boolean dispo, int ndPlace, String numTel, int idUsr, int idAvis, int idDemande) {
        this.id = id;
        this.matricule = matricule;
        this.marque = marque;
        this.dateD = dateD;
        this.lieuD = lieuD;
        this.lieuA = lieuA;
        this.dispo = dispo;
        this.ndPlace = ndPlace;
        this.numTel = numTel;
        this.idUsr = idUsr;
        this.idAvis = idAvis;   
        this.idDemande = idDemande;
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

    public boolean isDispo() {
        return dispo;
    }

    public int getNdPlace() {
        return ndPlace;
    }

    public String getNumTel() {
        return numTel;
    }

    public int getIdUsr() {
        return idUsr;
    }

    public int getIdAvis() {
        return idAvis;
    }

    public int getIdDemande() {
        return idDemande;
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

    public void setDispo(boolean dispo) {
        this.dispo = dispo;
    }

    public void setNdPlace(int ndPlace) {
        this.ndPlace = ndPlace;
    }

    public void setNumTel(String numTel) {
        this.numTel = numTel;
    }

    public void setIdUsr(int idUsr) {
        this.idUsr = idUsr;
    }

    public void setIdAvis(int idAvis) {
        this.idAvis = idAvis;
    }

    public void setIdDemande(int idDemande) {
        this.idDemande = idDemande;
    }

    @Override
    public String toString() {
        return "OffreCovoiturage{" + "id=" + id + ", matricule=" + matricule + ", marque=" + marque + ", dateD=" + dateD + ", lieuD=" + lieuD + ", lieuA=" + lieuA + ", dispo=" + dispo + ", ndPlace=" + ndPlace + ", numTel=" + numTel + ", idUsr=" + idUsr + ", idAvis=" + idAvis + ", idDemande=" + idDemande + '}';
    }
    
    
}
