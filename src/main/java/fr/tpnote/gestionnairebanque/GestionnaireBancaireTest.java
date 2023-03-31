package fr.tpnote.gestionnairebanque;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GestionnaireBancaireTest {

    GestionnaireBancaire banque;
    @Test
    public void testInitialisationGestionnaireBanque(){
        banque = new GestionnaireBancaire();
    }

      @Test
    public void testInitialisationGestionnaireRecupererListeTransaction() {
          banque = new GestionnaireBancaire();
          assertEquals( banque.getListeTransaction().toArray(), new ArrayList<Transaction>());
      }
}
