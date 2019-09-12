package com.github.caiobas.singleton;

public class ValorFinal {
		
	private final static double porcentagem = 20;
	private static double valorFinal;
	
	private ValorFinal(double valor) {
		valorFinal = valor * porcentagem;
	}
	
	private static final ValorFinal INSTANCIA = criaInstancia();
	
	private static ValorFinal criaInstancia() {
		// Em cenário real o valor seria obtido de fonte externa, talvez.
		final double valor = 12.3;

		return new ValorFinal(valor);
	}
	
	public static ValorFinal getInstance() {
		return INSTANCIA;
	}
	
	public static double getPorcentagem() {
		return porcentagem;
	}

	public static double getValorFinal() {
		return valorFinal;
	}
}
