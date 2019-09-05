package com.github.kyriosdata.exemplo.domain;

import java.lang.reflect.InvocationTargetException;

public class Factory {
	
	@SuppressWarnings("unchecked")
	public static <T> T newInstance(String className)
		       throws ClassNotFoundException, InstantiationException,
		       IllegalAccessException, InvocationTargetException,
		       NoSuchMethodException {
		   Class<?> classe = Class.forName(className);
		   return (T) classe.getDeclaredConstructor().newInstance();
		}

}
