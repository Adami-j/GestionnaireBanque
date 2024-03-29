package fr.tpnote.gestionnairebanque;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestTaux {
    Taux taux;
    @Test
    public void testInitialisationTaux(){
         taux = new Taux("nom",0,10,0.1);
    }

    @Test
    public void testGetTauxInferieur(){
         taux = new Taux("nom",0,10,0.1);
        assertEquals(taux.getTauxInferieur(),0,0);
    }

    @Test
    public void testGetTauxSuperieur(){
         taux = new Taux("nom",0,10,0.1);
        assertEquals(taux.getTauxSuperieur(),10,0);
    }

    @Test
    public void testGetTauxAApliquer(){
         taux = new Taux("nom",0,10,0.1);
        assertEquals(taux.getTauxAApliquer(),0.1,0);
    }

    @Test
    public void testGetNomTaux(){
         taux = new Taux("nom",0,10,0.1);
        assertEquals(taux.getNomTaux(),"nom");
    }

    @Test
    public void testSetTauxInferieur(){
         taux = new Taux("nom",0,10,0.1);
        taux.setTauxInferieur(1);
        assertEquals(taux.getTauxInferieur(),1,0);
    }

    @Test
    public void testSetTauxSuperieur(){
         taux = new Taux("nom",0,10,0.1);
        taux.setTauxSuperieur(1);
        assertEquals(taux.getTauxSuperieur(),1,0);
    }

    @Test
    public void testSetTauxAApliquer(){
         taux = new Taux("nom",0,10,0.1);
        taux.setTauxAApliquer(1);
        assertEquals(taux.getTauxAApliquer(),1,0);
    }

    @Test
    public void testSetNomTaux(){
         taux = new Taux("nom",0,10,0.1);
        taux.setNomTaux("nom2");
        assertEquals(taux.getNomTaux(),"nom2");
    }

    @Test
    public void testTransactionPossible(){
            taux = new Taux("nom",0,10,0.1);
            assertEquals(taux.transactionPossible(5),true);
    }

    @Test
    public void testTransactionImpossible(){
            taux = new Taux("nom",0,10,0.1);

            assertThrows(IllegalArgumentException.class, () -> taux.transactionPossible(11));
    }

    @Test
    public void testTransactionImpossibleNegative(){
            taux = new Taux("nom",0,10,0.1);

            assertThrows(IllegalArgumentException.class, () -> taux.transactionPossible(-1));
    }

    @Test
    public void testTransactionImpossiblePalierSUp(){
            taux = new Taux("nom",20,100,0.1);
            assertEquals(taux.transactionPossible(35),true);

    }

    @Test
    public void testTransactionImpossiblePalierInf(){
            taux = new Taux("nom",20,100,0.1);

        assertThrows(IllegalArgumentException.class, () -> taux.transactionPossible(15));
    }

    @Test
    public void testTransactionTauxNegatif(){
            taux = new Taux("nom",20,100,-0.1);

        assertThrows(IllegalArgumentException.class, () -> taux.transactionPossible(35));
    }

    @Test
    public void testTransactionTauxTropGrand(){
        taux = new Taux("nom",20,100,200);

        assertThrows(IllegalArgumentException.class, () -> taux.transactionPossible(35));
    }

    @Test
    public void transactionNulle(){
        taux = new Taux("nom",0,100,200);
        assertThrows(IllegalArgumentException.class, () -> taux.transactionPossible(0));
    }




}
