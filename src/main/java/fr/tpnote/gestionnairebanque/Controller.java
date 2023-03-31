package fr.tpnote.gestionnairebanque;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    GestionnaireBancaire banque = new GestionnaireBancaire();
    @FXML
    private TextField nom;
    @FXML
    private TextField montant;
    @FXML
    private Label solde;

    @FXML
    ListView<Transaction> listeTransaction= new ListView<>();

    @FXML
    ComboBox comboboxid;

    @FXML
    Button enregistrer;

    @FXML
    public void initialize(){
        ObservableList<Transaction> items = listeTransaction.getItems();

    }

    @FXML
    public void actionEnregistrer(){

    }


}