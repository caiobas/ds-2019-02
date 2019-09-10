package com.github.caiobas.builder.Application;

import com.github.caiobas.builder.domain.Empresa;

public class Application {

	public static void main(String[] args) {
		Empresa.Builder empresaOtavio = new Empresa.Builder("Otavio LTDA")
				.nomeFantasia("Otavio Bugigangas")
				.cnpj("12.345.678-0009-12")
				.areaDeAtuacao("Comércio");

		empresaOtavio.toString();
	}

}
