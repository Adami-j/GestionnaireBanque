package fr.tpnote.gestionnairebanque;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;


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
        banque.getListeTaux().add(new Taux("test", 0, 100, 10));
        assertThrows(IllegalArgumentException.class, () -> banque.addTransaction(new Transaction("test", 'c', 0d)));
    }

    @Test
    public void testTauxCorrect(){
        banque = new GestionnaireBancaire();
        banque.getListeTaux().add(new Taux("test", 0, 100, 10));
        banque.getListeTransaction().add(new Transaction("test", 'c', 15d));
        banque.addTransaction(new Transaction("test", 'c', 15d));
        assertEquals(banque.getListeTransaction().size(), 2);
    }

    @Test
    public void testTauxAppliqueIncorrect(){
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
