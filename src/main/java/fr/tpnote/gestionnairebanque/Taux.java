package fr.tpnote.gestionnairebanque;

import java.io.Serializable;

public class Taux implements Serializable {
    private double tauxInferieur;
    private double tauxSuperieur;
    private double tauxAApliquer;
    private String nomTaux;

    public Taux(String nom, double tauxInferieur, double tauxSuperieur, double tauxAApliquer) {
        this.nomTaux = nom;
        this.tauxInferieur = tauxInferieur;
        this.tauxSuperieur = tauxSuperieur;
        this.tauxAApliquer = tauxAApliquer;
    }

    public double getTauxInferieur() {
        return tauxInferieur;
    }

    public void setTauxInferieur(double tauxInferieur) {
        this.tauxInferieur = tauxInferieur;
    }

    public double getTauxSuperieur() {
        return tauxSuperieur;
    }

    public void setTauxSuperieur(double tauxSuperieur) {
        this.tauxSuperieur = tauxSuperieur;
    }

    public double getTauxAApliquer() {
        return tauxAApliquer;
    }

    public void setTauxAApliquer(double tauxAApliquer) {
        this.tauxAApliquer = tauxAApliquer;
    }

    public String getNomTaux() {
        return nomTaux;
    }

    public void setNomTaux(String nomTaux) {
        this.nomTaux = nomTaux;
    }

    public boolean transactionPossible(double i) throws IllegalArgumentException {
        if(i<0 || i<this.getTauxInferieur() || i>this.getTauxSuperieur() || this.getTauxAApliquer() < 0 || this.getTauxAApliquer() >= 100){
            throw new IllegalArgumentException("Transaction impossible : vérifiez les taux");
        }
        return true;
    }


}
