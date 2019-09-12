package com.github.caiobas.singleton;

public class ValorFinal {
		
	private static double porcentagem = 20;
	public static double valorFinal; 
	
	private ValorFinal() {
		valorFinal = Pedidos.valor * porcentagem;
	}
	
	private static final ValorFinal INSTANCIA = criaInstancia();
	
	private static ValorFinal criaInstancia() {
		return new ValorFinal();
	}
	
	public static ValorFinal getInstance() {
		return INSTANCIA;
	}
	
	public static double getPorcentagem() {
		return porcentagem;
	}
}
