module fr.tpnote.gestionnairebanque {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.junit.jupiter.api;


    opens fr.tpnote.gestionnairebanque to javafx.fxml;
    exports fr.tpnote.gestionnairebanque;
}