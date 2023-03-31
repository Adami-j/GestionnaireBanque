module fr.tpnote.gestionnairebanque {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;


    opens fr.tpnote.gestionnairebanque to javafx.fxml;
    exports fr.tpnote.gestionnairebanque;
}