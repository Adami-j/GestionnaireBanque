package fr.tpnote.gestionnairebanque;

import java.util.ArrayList;
import java.util.List;

public class GestionnaireBancaire {

    private List<Transaction> listeTransaction = null;

    public GestionnaireBancaire() {
        this.listeTransaction = new ArrayList<>();
    }

    public List<Transaction> getListeTransaction() {
        return listeTransaction;
    }

    public void setListeTransaction(List<Transaction> listeTransaction) {
        this.listeTransaction = listeTransaction;
    }

}
