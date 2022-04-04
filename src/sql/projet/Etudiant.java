package sql.projet;

import java.sql.Date;

public class Etudiant {

    public Etudiant(String nom, String prenom, String sexe, int matricule, int telephone, Date datenaiss) {
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.matricule = matricule;
        this.telephone = telephone;
        this.datenaiss = datenaiss;
    }

    public Etudiant() {
    }

    ;
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public int getMatricule() {
        return matricule;
    }

    public void setMatricule(int matricule) {
        this.matricule = matricule;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public Date getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(Date datenaiss) {
        this.datenaiss = datenaiss;
    }

    String nom, prenom, sexe;
    int matricule, telephone;
    Date datenaiss;

}
