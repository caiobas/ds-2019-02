package com.github.caiobas.builder.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

// TODO você pode fazer mais pelo leiaute deste código. 
public class EmpresaTest {
	
	@Test
    void builderCasoTrivial() {
		
		Empresa.Builder builder = new Empresa.Builder("Otavio LTDA")
				.nomeFantasia("Otavio Bugigangas");
		
        assertEquals("Razao Social:Otavio LTDA Nome Fantasia:Otavio Bugigangas CNPJ: Area De Atuacao:", 
        		builder.build().toString());
    }
	
	@Test
    void verificaBuilder() {
		Empresa.Builder empresaOtavio = new Empresa.Builder("Otavio LTDA")
				.nomeFantasia("Otavio Bugigangas")
				.cnpj("12.345.678-0009-12")
				.areaDeAtuacao("Comércio");
		assertEquals("Razao Social:Otavio LTDA Nome Fantasia:Otavio Bugigangas CNPJ:12.345.678-0009-12 Area De Atuacao:Comércio",
				empresaOtavio.build().toString());;
    }
	
	@Test
    void encargosImmutable() {
        Empresa.Builder builder = new Empresa.Builder("Davi");
        Empresa nome = builder.build();

        // Não há como adicionar
        assertThrows(UnsupportedOperationException.class, () ->
                nome.getRazaoSocial().add("teste"));

        // Não há como remover
        assertThrows(UnsupportedOperationException.class, () ->
                nome.getRazaoSocial().remove(0));
	}

}
