module fr.tpnote.gestionnairebanque {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.tpnote.gestionnairebanque to javafx.fxml;
    exports fr.tpnote.gestionnairebanque;
}