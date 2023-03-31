package fr.tpnote.gestionnairebanque;

import org.junit.Test;

public class TestTransaction {

    @Test
    public void testInitialisationBanque(){
        Transaction transaction = new Transaction("nom",'c',15d);

    }

}
