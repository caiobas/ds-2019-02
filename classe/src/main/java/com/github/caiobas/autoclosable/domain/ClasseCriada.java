package com.github.caiobas.autoclosable.domain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ClasseCriada extends FileInputStream{

	public ClasseCriada(String arg) throws FileNotFoundException {
		super(arg);
	}

	@Override
	public void close() throws IOException {
		throw new RuntimeException("método close chamado");
	}

	
}
