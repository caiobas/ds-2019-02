package com.github.caiobas.singleton.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.github.caiobas.autoclosable.domain.ClasseCriada;

public class ClasseCriadaTest {

	// FIXME o teste passa, mas a exceção capturada não é aquela gerada pelo throw no método close
	// TODO trocar o null por um nome válido, existente. Uma estratégia adequada foi implementada pelo josenilton em https://github.com/newtonjose/ds-2019-02/blob/master/auto-closeable/src/test/java/com/github/newtonjose/autocloseable/FileInputStreamAutoCloseableTest.java
	@Test
	void verificaCloseChamado() {
	    assertThrows(RuntimeException.class, () -> {
	        try (ClasseCriada obj = new ClasseCriada(null)) {
	        }
	    });
	}
	
}
