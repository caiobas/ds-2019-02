package com.github.caiobas.builder.Application;

import com.github.caiobas.builder.domain.Empresa;

public class Application {

	public static void main(String[] args) {
		Empresa.Builder builder = new Empresa.Builder("Otavio LTDA");
		Empresa empresaOtavio = builder
				.nomeFantasia("Otavio Bugigangas")
				.build();

		System.out.println(empresaOtavio.toString());
	}

}
