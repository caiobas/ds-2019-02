package com.github.caiobas.equals.domain;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumeroTelefonicoTest {

	@Test
    public void numeroTelefone() {
        NumeroTelefonico numero1 = new NumeroTelefonico("55","62","87654321");

        assertTrue(numero1.equals(numero1));
    }

    @Test
    public void numerosTelefoneIguais() {
        NumeroTelefonico numero1 = new NumeroTelefonico("55","62","87654321");
        NumeroTelefonico numero2 = new NumeroTelefonico("55","62","87654321");

        assertTrue(numero1.equals(numero2));
    }

    @Test
    public void numerosTelefoneDiferentes() {
        NumeroTelefonico numero1 = new NumeroTelefonico("55","62","87654321");
        NumeroTelefonico numero2 = new NumeroTelefonico("55","62","12345678");

        assertFalse(numero1.equals(numero2));
    }

    @Test
    public void objetosDiferentes() {
        NumeroTelefonico numero1 = new NumeroTelefonico("55","62","87654321");
        String numero2 = "556287654321";

        assertFalse(numero1.equals(numero2));
    }

    @Test
    public void instaciaNull() {
        NumeroTelefonico numero1 = new NumeroTelefonico("55","62","87654321");
        NumeroTelefonico numeroNull = null;

        assertFalse(numero1.equals(numeroNull));
    }

    @Test
    public void contemNumeroTelefone() {

        NumeroTelefonico numero1 = new NumeroTelefonico("55","62","87654321");
        Set<NumeroTelefonico> listaTelefones = new HashSet<>();
        listaTelefones.add(numero1);

        NumeroTelefonico numero2 = new NumeroTelefonico("55","62","87654321");

        assertTrue(listaTelefones.contains(numero2));
    }
}
