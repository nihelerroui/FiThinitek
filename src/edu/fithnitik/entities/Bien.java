
package edu.fithnitik.entities;

public class Bien {
    private int id;
    private String nomRecepteur;
    private String description;
    private String reference;
    private String telRecept;
    private int quantite;
    
    public Bien(){
        
    }

    public Bien(int id, String nomRecepteur, String description, String reference, String telRecept, int quantite) {
        this.id = id;
        this.nomRecepteur = nomRecepteur;
        this.description = description;
        this.reference = reference;
        this.telRecept = telRecept;
        this.quantite = quantite;
    }
   
    public int getId() {
        return id;
    }

    public String getNomRecepteur() {
        return nomRecepteur;
    }

    public String getDescription() {
        return description;
    }

    public String getReference() {
        return reference;
    }

    public String getTelRecept() {
        return telRecept;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNomRecepteur(String nomRecepteur) {
        this.nomRecepteur = nomRecepteur;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setTelRecept(String telRecept) {
        this.telRecept = telRecept;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Bien{" + "id=" + id + ", nomRecepteur=" + nomRecepteur + ", description=" + description + ", reference=" + reference + ", telRecept=" + telRecept + ", quantite=" + quantite + '}';
    }

   
    
       
   }
    

