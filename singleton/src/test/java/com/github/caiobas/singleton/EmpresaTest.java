package com.github.caiobas.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class EmpresaTest {
	
	@Test
    void builderCasoTrivial() {
		
		Empresa.Builder builder = new Empresa.Builder("Otavio LTDA")
				.nomeFantasia("Otavio Bugigangas");
		
        assertEquals("Razao Social:Otavio LTDA Nome Fantasia:Otavio Bugigangas CNPJ:null Areas De Atuacao:[]", 
        		builder.build().toString());
    }
	
	@Test
    void verificaBuilder() {
		Empresa.Builder empresaOtavio = new Empresa.Builder("Otavio LTDA")
				.nomeFantasia("Otavio Bugigangas")
				.cnpj("12.345.678-0009-12")
				.areasAtuacao("Comércio");
		assertEquals("Razao Social:Otavio LTDA Nome Fantasia:Otavio Bugigangas CNPJ:12.345.678-0009-12 Areas De Atuacao:[Comércio]",
				empresaOtavio.build().toString());;
    }
	
	@Test
    void encargosImmutable() {
        Empresa.Builder build = new Empresa.Builder("Empresa 1");
        Empresa empresa = build
        		.areasAtuacao("Área 1")
        		.build();

       // Não há como adicionar
        assertThrows(UnsupportedOperationException.class, () ->
                empresa.getAreasAtuacao().add("teste"));

        // Não há como remover
        assertThrows(UnsupportedOperationException.class, () ->
                empresa.getAreasAtuacao().remove(0));
	}

}
