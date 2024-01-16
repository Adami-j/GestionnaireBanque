package fr.tpnote.gestionnairebanque;



import java.io.IOException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GestionnaireBancaireTest {

    GestionnaireBancaire banque;
    @Test
    public void testInitialisationGestionnaireBanque() throws IOException {
        banque = new GestionnaireBancaire();
    }

      @Test
    public void testInitialisationGestionnaireRecupererListeTransaction() throws IOException {
          banque = new GestionnaireBancaire();
          assertEquals( banque.getListeTransaction(), new ArrayList<Transaction>());
      }

      @Test
      public void testTailleVideListeTransaction() throws IOException {
          banque = new GestionnaireBancaire();
          assertEquals( banque.getListeTransaction().size(), 0);
      }
      @Test
    public void testAjoutTransaction() throws IOException {
            banque = new GestionnaireBancaire();
            banque.getListeTransaction().add(new Transaction("test", 'c', 15d));
            assertEquals( banque.getListeTransaction().size(), 1);
    }

    @Test
    public void testtransactionNegative() throws IOException {
        banque = new GestionnaireBancaire();
        banque.getListeTransaction().add(new Transaction("test", 'c', -15d));
        banque.getListeTaux().add(new Taux("test", 0, 100, 10));

        assertThrows(IllegalArgumentException.class, () -> banque.addTransaction(new Transaction("test", 'c', -15d)));

    }

    @Test
    public void testtransactionValeurZero() throws IOException {
        banque = new GestionnaireBancaire();
        banque.getListeTaux().add(new Taux("test", 0, 100, 10));
        assertThrows(IllegalArgumentException.class, () -> banque.addTransaction(new Transaction("test", 'c', 0d)));
    }

    @Test
    public void testTauxCorrect() throws IOException {
        banque = new GestionnaireBancaire();
        banque.getListeTaux().add(new Taux("test", 0, 100, 10));
        banque.getListeTransaction().add(new Transaction("test", 'c', 15d));
        banque.addTransaction(new Transaction("test", 'c', 15d));
        assertEquals(banque.getListeTransaction().size(), 2);
    }

    @Test
    public void testTauxAppliqueIncorrect() throws IOException {
        banque = new GestionnaireBancaire();
        banque.getListeTaux().add(new Taux("test", 0, 100, -10));
        banque.getListeTransaction().add(new Transaction("test", 'c', 15d));
        assertThrows(IllegalArgumentException.class, () -> banque.addTransaction(new Transaction("test", 'c', 15d)));
    }


    @Test
    public void chargerListeTaux() throws IOException {
        banque = new GestionnaireBancaire();
        banque.recupererFichierTaux("src/main/resources/fr/tpnote/gestionnairebanque/Data/taux.txt");
        assertEquals(banque.getListeTaux().size(), 3);
    }

       @Test
       public void chargerListeTauxInvalide() throws IOException {
           banque = new GestionnaireBancaire();
           banque.recupererFichierTaux("src/main/resources/fr/tpnote/gestionnairebanque/Data/tauxx.txt");
           assertEquals(banque.getListeTaux().size(), 0);
       }





}
