package com.github.caiobas.singleton;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertSame;

class ValorFinalTest {

    @Test
    void umaUnicaInstancia() {
        assertSame(ValorFinal.getInstance(), ValorFinal.getInstance());
    }

}
