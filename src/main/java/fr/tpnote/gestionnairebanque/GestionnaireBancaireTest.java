package fr.tpnote.gestionnairebanque;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class GestionnaireBancaireTest {

    GestionnaireBancaire banque;
    @Test
    public void testInitialisationGestionnaireBanque(){
        banque = new GestionnaireBancaire();
    }

      @Test
    public void testInitialisationGestionnaireRecupererListeTransaction() {
          banque = new GestionnaireBancaire();
          assertEquals( banque.getListeTransaction(), new ArrayList<Transaction>());
      }

      @Test
      public void testTailleVideListeTransaction() {
          banque = new GestionnaireBancaire();
          assertEquals( banque.getListeTransaction().size(), 0);
      }
      @Test
    public void testAjoutTransaction() {
            banque = new GestionnaireBancaire();
            banque.getListeTransaction().add(new Transaction("test", 'c', 15d));
            assertEquals( banque.getListeTransaction().size(), 1);
    }

    @Test
    public void testtransactionNegative() {
        banque = new GestionnaireBancaire();
        banque.getListeTransaction().add(new Transaction("test", 'c', -15d));
        banque.getListeTaux().add(new Taux("test", 0, 100, 10));

        assertThrows(IllegalArgumentException.class, () -> banque.addTransaction(new Transaction("test", 'c', -15d)));

    }

    @Test
    public void testtransactionValeurZero() {
        banque = new GestionnaireBancaire();
        banque.getListeTransaction().add(new Transaction("test", 'c', 0d));
        assertEquals( banque.getListeTransaction().size(), 0d,0);
    }


}
