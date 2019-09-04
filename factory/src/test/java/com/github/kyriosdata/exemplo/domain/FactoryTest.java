package com.github.kyriosdata.exemplo.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;

import org.junit.jupiter.api.Test;

import com.github.kyriosdata.exemplo.application.console.Aluno;
import com.github.kyriosdata.exemplo.application.console.Factory;
import com.github.kyriosdata.exemplo.application.console.Professor;

public class FactoryTest {

	@Test
	void factoryTest() throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
		Aluno aluno = Factory.newInstance("com.github.kyriosdata.exemplo.application.console.Aluno");
		Professor professor = Factory.newInstance("com.github.kyriosdata.exemplo.application.console.Professor");
		
		assertEquals("Estudar", aluno.atividade());
		assertEquals("Educar", professor.atividade());
	}
}
