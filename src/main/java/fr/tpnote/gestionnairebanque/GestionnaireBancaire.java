package fr.tpnote.gestionnairebanque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireBancaire {

    private List<Transaction> listeTransaction = null;
    private List<Taux> listeTaux = null;
    private Double solde = 0d;

    public GestionnaireBancaire() {
        this.listeTransaction = new ArrayList<>();
        this.listeTaux = new ArrayList<>();
    }

    public List<Transaction> getListeTransaction() {
        return listeTransaction;
    }

    public void setListeTransaction(List<Transaction> listeTransaction) {
        this.listeTransaction = listeTransaction;
    }

    public List<Taux> getListeTaux() {
        return listeTaux;
    }

    public Taux getTauxVoulu(){
        Taux t = null;
        if (this.getListeTaux()!=null  && this.getListeTaux().size() >0){

        for(Taux taux : this.getListeTaux()){
            if(taux.transactionPossible((int) taux.getTauxAApliquer())){
                t = taux;
            }
        }
        }
        return t;
    }

    public void setListeTaux(List<Taux> listeTaux) {
        this.listeTaux = listeTaux;
    }

    public void addTransaction(Transaction transaction)throws IllegalArgumentException{
        Taux t = this.getTauxVoulu();
        if(t.transactionPossible(transaction.getValeur())==false){
            throw new IllegalArgumentException("Transaction impossible : vérifiez les taux");
        }
        this.solde+=transaction.getValeur();
        this.getListeTransaction().add(transaction);
    }


    public void recupererFichierTaux(String cheminFichier) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] valeurs = ligne.split(" ");

                if (valeurs.length != 4) {
                    System.err.println("Erreur : la ligne \"" + ligne + "\" ne contient pas 3 valeurs.");
                }
                try {
                    String niveau = valeurs[0];
                    double montantMin = Double.parseDouble(valeurs[1]);
                    double montantMax = Double.parseDouble(valeurs[2]);
                    double tauxBanque = Double.parseDouble(valeurs[3]);

                    Taux nouveauTaux = new Taux(niveau, montantMin, montantMax, tauxBanque);
                    this.getListeTaux().add(nouveauTaux);
                } catch (NumberFormatException e) {
                    System.err.println("Erreur : impossible de convertir une valeur en nombre dans la ligne \"" + ligne + "\".");

                }
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier " + cheminFichier + " : " + e.getMessage());

        }
    }


}
