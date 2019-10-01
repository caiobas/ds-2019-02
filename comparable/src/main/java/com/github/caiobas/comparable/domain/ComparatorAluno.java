package com.github.caiobas.comparable.domain;

import java.util.Comparator;

public class ComparatorAluno implements Comparator<Aluno>{

	@Override
	public int compare(Aluno aluno1, Aluno aluno2) {
		// FIXME alternativa
		// return Integer.compare(aluno1.getNome().length(), aluno2.getNome().length());
		return aluno1.getNome().length() - aluno2.getNome().length();
	}

}
