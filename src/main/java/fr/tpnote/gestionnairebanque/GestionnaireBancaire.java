package fr.tpnote.gestionnairebanque;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GestionnaireBancaire {

    private List<Transaction> listeTransaction = null;
    private List<Taux> listeTaux = null;
    private Double solde;

    public GestionnaireBancaire() throws IOException {
        solde=0d;
        this.listeTransaction = new ArrayList<>();
        this.listeTaux = new ArrayList<>();
        this.recupererFichierTaux("src/main/resources/fr/tpnote/gestionnairebanque/Data/taux.txt");
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

        for(Taux taux : this.getListeTaux()){
            try{
            if(taux.transactionPossible(taux.getTauxAApliquer())){
                t = taux;
            }}
            catch(IllegalArgumentException e){

            }
        }

        return t;
    }

    public void setListeTaux(List<Taux> listeTaux) {
        this.listeTaux = listeTaux;
    }

    public void addTransaction(Transaction transaction)throws IllegalArgumentException{
        Taux t = this.getTauxVoulu();
        if(t==null || t.transactionPossible(transaction.getValeur())==false){
            throw new IllegalArgumentException("Transaction impossible : vérifiez les taux");
        }
        switch (transaction.getType()) {
            case 'c':
                this.solde+=transaction.getValeur()-transaction.getValeur()*t.getTauxAApliquer();
                break;
            case 'd':
                this.solde-=transaction.getValeur();
                break;
            default:
                throw new IllegalArgumentException("Type de transaction incorrect");
        }

        this.getListeTransaction().add(transaction);
    }


    public void recupererFichierTaux(String cheminFichier) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(cheminFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] valeurs = ligne.split(" ");

                if (valeurs.length != 4) {
                    throw new IOException("Erreur : la ligne \"" + ligne + "\" ne contient pas 3 valeurs.");

                }
                try {
                    String niveau = valeurs[0];
                    double montantMin = Double.parseDouble(valeurs[1]);
                    double montantMax = Double.parseDouble(valeurs[2]);
                    double tauxBanque = Double.parseDouble(valeurs[3]);

                    Taux nouveauTaux = new Taux(niveau, montantMin, montantMax, tauxBanque);
                    this.getListeTaux().add(nouveauTaux);

                } catch (NumberFormatException e) {
                  throw new NumberFormatException("Erreur : la ligne \"" + ligne + "\" contient une valeur non numérique.");

                }
            }
        } catch (IOException e) {
           throw  new IOException("Erreur : le fichier \"" + cheminFichier + "\" n'a pas pu être ouvert.");
        }
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }
}
