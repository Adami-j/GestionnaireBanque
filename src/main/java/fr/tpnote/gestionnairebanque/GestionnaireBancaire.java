package fr.tpnote.gestionnairebanque;

import java.util.List;

public class GestionnaireBancaire {

    private List<Transaction> listeTransaction;

    public List<Transaction> getListeTransaction() {
        return listeTransaction;
    }

    public void setListeTransaction(List<Transaction> listeTransaction) {
        this.listeTransaction = listeTransaction;
    }

}
