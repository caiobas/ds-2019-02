package com.github.caiobas.equals.domain;

public class NumeroTelefonico {

	String codigoPais;
	String codigoEstado;
	String numeroTelefone;
	
	public NumeroTelefonico(String codigoPais, String codigoEstado, String numeroTelefone) {
		this.codigoPais = codigoPais;
		this.codigoEstado = codigoEstado;
		this.numeroTelefone = numeroTelefone;
	}
	
	 @Override
	    public boolean equals(Object obj) {
	        if(this == obj){
	            return true;
	        }

	        if(obj == null){
	            return false;
	        }

	        if(obj instanceof NumeroTelefonico){
	            NumeroTelefonico objNumeroTelefonico = (NumeroTelefonico) obj;

		    // FIXME induzi equivocadamente o uso do ==, contudo, lembra-se da pergunta do Werber?
		    // Qual a diferença entre == e equals? Testes com o uso do ==, conforme abaixo, devem 
		    // falhar. O correto é this.codigoPais.equals(objNumeroTelefonico.codigoPais).
	            return this.codigoPais == objNumeroTelefonico.codigoPais &&
	                    this.codigoEstado == objNumeroTelefonico.codigoEstado &&
	                    this.numeroTelefone == objNumeroTelefonico.numeroTelefone;
	        }

	        return false;
	    }

	    @Override
	    public int hashCode() {
	        return this.codigoPais.hashCode() + this.codigoEstado.hashCode() +
	                this.numeroTelefone.hashCode();
	    }
	    
}
