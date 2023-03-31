package fr.tpnote.gestionnairebanque;

public class Transaction {
    private String nom;
    private char type;
    private double valeur;
    public Transaction(String nom, char type, double valeur) {
        this.nom = nom;
        this.type = type;
        this.valeur = valeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public double getValeur() {
        return valeur;
    }

    public void setValeur(double valeur) {
        this.valeur = valeur;
    }
}
