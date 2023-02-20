/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.covoiturage_1.entities;

/**
 *
 * @author Nihel
 */
public class Avis {
     private int id;
    private String commentaire;
    private int id_usr;
    private int id_offre;

    public Avis() {
    }

    public Avis(int id, String commentaire,int id_usr,int id_offre) {
        this.id = id;
        this.commentaire = commentaire;
        this.id_usr = id_usr;
        this.id_offre = id_offre;
    }

    public Avis(String commentaire,int id_usr,int id_offre) {
        this.commentaire = commentaire;
        this.id_usr = id_usr;
        this.id_offre = id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_usr(int id_usr) {
        this.id_usr = id_usr;
    }

    public int getId_usr() {
        return id_usr;
    }

    public int getId() {
        return id;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    @Override
    public String toString() {
        return "Avis{" + "id=" + id + ", commentaire=" + commentaire + ", user=" + id_usr + ", offreCovoiturage="+ id_offre+'}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Avis other = (Avis) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
