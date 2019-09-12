package com.github.caiobas.singleton;

public class Pedidos {
	int idPedido;
	String item;
	static double valor;
	String mesa;
	
	
	
	public Pedidos(int idPedido, String item, String mesa) {
		this.idPedido = idPedido;
		this.item = item;
		this.mesa = mesa;
	}

	
}
