package fr.tpnote.gestionnairebanque;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Controller {

    GestionnaireBancaire banque;

    @FXML
    private TextField nom;
    @FXML
    private TextField montant;
    @FXML
    private Label solde;

    @FXML
    ListView<String> listeTransaction= new ListView<>();

    @FXML
    ComboBox comboboxid;

    @FXML
    Button enregistrer;

    public Controller() throws IOException {
    }

    @FXML
    public void initialize() throws IOException {
        banque = new GestionnaireBancaire();
        ObservableList<Transaction> items = listeTransaction.getItems();
        ObservableList<String> itemsCombo = FXCollections.observableArrayList("Crédit", "Débit");
        comboboxid.setItems(itemsCombo);
        solde.setText(banque.getSolde().toString());

    }

    @FXML
    public void actionEnregistrer(ActionEvent actionEvent) {
        char type;
        switch (comboboxid.getValue().toString()){
            case "Crédit":
                type = 'c';
                break;
            case "Débit":
                type = 'd';
                break;
            default:
                type = 'c';
                break;
        }
        Transaction t = new Transaction(nom.getText(), type, Double.parseDouble(montant.getText()));
        banque.addTransaction(t);

        listeTransaction.getItems().add(t); // Ajout de la transaction à l'observable list
        solde.setText(banque.getSolde().toString());

        if(Double.valueOf(solde.getText())<0d){
            solde.setTextFill(Color.rgb(255,0,0));
        }else{
            solde.setTextFill(Color.rgb(0,255,0));
        }


    }




}