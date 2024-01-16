package fr.tpnote.gestionnairebanque;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestTransaction {

    Transaction transaction;
    @Test
    public void testInitialisationBanque(){
       transaction = new Transaction("nom",'c',15d);
        assertEquals(transaction.getNom(),"nom");
    }

    @Test
    public void testGetType(){
       transaction = new Transaction("nom",'c',15d);
        assertEquals(transaction.getType(),'c');
    }

    @Test
    public void testGetValeur(){
       transaction = new Transaction("nom",'c',15d);
        assertEquals(transaction.getValeur(),15d,0);
    }

    @Test
    public void testSetNom(){
       transaction = new Transaction("nom",'c',15d);
       transaction.setNom("nom2");
        assertEquals(transaction.getNom(),"nom2");
    }

    @Test
    public void testSetType(){
       transaction = new Transaction("nom",'c',15d);
       transaction.setType('d');
        assertEquals(transaction.getType(),'d');
    }

    @Test
    public void testSetValeur(){
       transaction = new Transaction("nom",'c',15d);
       transaction.setValeur(20d);
        assertEquals(transaction.getValeur(),20d,0);
    }







}
