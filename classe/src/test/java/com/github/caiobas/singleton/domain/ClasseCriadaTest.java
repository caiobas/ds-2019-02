package com.github.caiobas.singleton.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.caiobas.autoclosable.domain.ClasseCriada;

public class ClasseCriadaTest {

	@Test
	void verificaCloseChamado() {
	    assertThrows(RuntimeException.class, () -> {
	        try (ClasseCriada obj = new ClasseCriada(null)) {
	        }
	    });
	}
	
}
