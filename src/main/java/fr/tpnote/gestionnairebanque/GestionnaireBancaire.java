package fr.tpnote.gestionnairebanque;

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
        System.out.println(t);
        System.out.println(t.transactionPossible((double) transaction.getValeur()));
        if(t==null||t.transactionPossible((double) transaction.getValeur())==false){
            throw new IllegalArgumentException("Transaction impossible : vérifiez les taux");
        }
        this.getListeTransaction().add(transaction);
    }
}
