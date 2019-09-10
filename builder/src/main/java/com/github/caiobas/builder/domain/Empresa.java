package com.github.caiobas.builder.domain;

public class Empresa {
	
	/**
     * Razão social da empresa.
     */
    private String razaoSocial;

    /**
     * Nome fantasia da empresa.
     */
    private String nomeFantasia;
    
    /**
     * CNPJ da empresa.
     */
    private String cnpj;

    /**
     * Área de atuação da empresa.
     */
    private String areaDeAtuacao;

    /**
     * Classe empregada para construir uma instância (immutable) da classe
     * {@link Nome}.
     */
    public static class Builder {
    	private String razaoSocial;
    	private String nomeFantasia;
    	private String cnpj;
    	private String areaDeAtuacao;
    	
    	/**
         * Ter a razão social é obrigatório.
         *
         * @param razaoSocial A razão social da empresa.
    	 * @return 
         */
        public Builder(final String razaoSocial) {
            this.razaoSocial = razaoSocial;
        }
        
        /**
         * Adiciona o nome fantasia da empresa.
         *
         * @param nomeFantasia O nome fantasia da empresa.
    	 * @return 
         */
        public Builder nomeFantasia(final String nomeFantasia) {
            this.nomeFantasia = nomeFantasia;
            return this;
        }
        
        /**
         * Adiciona o cnpj da empresa.
         *
         * @param cnpf O cnpj da empresa.
    	 * @return 
         */
        public Builder cnpj(final String cnpj) {
            this.cnpj = cnpj;
            return this;
        }
        
        /**
         * Adiciona a área de atuação da empresa.
         *
         * @param areaDeAtuacao A área de atuação da empresa.
    	 * @return 
         */
        public Builder areaDeAtuacao(final String areaDeAtuacao) {
            this.areaDeAtuacao = areaDeAtuacao;
            return this;
        }
        
        public Empresa build() {
            return new Empresa(this);
        }
    }
    
    /**
     * Construtor PRIVADO que faz uso de objeto da classe {@link Builder}.
     *
     * @param builder Objeto contendo valores a partir dos quais a instância
     *                da classe {@link Empresa} será criada.
     */
    private Empresa(Builder builder) {
        razaoSocial = builder.razaoSocial;
        nomeFantasia = builder.nomeFantasia;
        cnpj = builder.cnpj;
        areaDeAtuacao = builder.areaDeAtuacao;
    }
    
    /**
     * Recupera a razão social da empresa.
     *
     * @return A razão social da empresa.
     */
    public String getRazaoSocial() {
        return razaoSocial;
    }
    
    /**
     * Recupera o nome fantasia da empresa.
     *
     * @return O nome fantasia da empresa.
     */
    public String getNomeFantasia() {
        return nomeFantasia;
    }
    
    /**
     * Recupera o cnpj da empresa.
     *
     * @return O cnpj da empresa.
     */
    public String getCNPJ() {
        return cnpj;
    }
    
    /**
     * Recupera a área de atuação da empresa.
     *
     * @return A área de atuação da empresa.
     */
    public String getAreaDeAtuação() {
        return areaDeAtuacao;
    }

    /**
     * Produz as informações da empresa.
     * @return As informações da empresa.
     */
	@Override
	public String toString() {
		// Evite a criação de tantos objetos intermediários. Para isto há o método String.format!
		return "Razao Social:" + razaoSocial + " Nome Fantasia:" + nomeFantasia + " CNPJ:" + cnpj + " Area De Atuacao:" + areaDeAtuacao;
	}
}
