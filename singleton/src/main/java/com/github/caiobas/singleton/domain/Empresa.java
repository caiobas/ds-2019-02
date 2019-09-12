package com.github.caiobas.builder.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

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
    private List<String> areasAtuacao;

    /**
     * Classe empregada para construir uma instância (immutable) da classe
     * {@link Nome}.
     */
    public static class Builder {
    	private String razaoSocial;
    	private String nomeFantasia;
    	private String cnpj;
    	private List<String> areasAtuacao = new ArrayList<>();
    	
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
         * @param areasAtuacao A área de atuação da empresa.
    	 * @return 
         */
        public Builder areasAtuacao(final String areaAtuacao) {
            areasAtuacao.add(areaAtuacao);
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
        areasAtuacao = Collections.unmodifiableList(builder.areasAtuacao);
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
    public List<String> getAreasAtuacao() {
        return areasAtuacao;
    }

    /**
     * Produz as informações da empresa.
     * @return As informações da empresa.
     */
	@Override
	public String toString() {
		return String.format("Razao Social:%s Nome Fantasia:%s CNPJ:%s Areas De Atuacao:%s",
				razaoSocial, nomeFantasia, cnpj, areasAtuacao);
	}
}
