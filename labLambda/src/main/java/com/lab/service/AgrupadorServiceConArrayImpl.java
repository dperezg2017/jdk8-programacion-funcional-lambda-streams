package com.lab.service;

public class AgrupadorServiceConArrayImpl implements AgrupadorService {

	private Object[] contenido = new Object[20];
	private int index = 0;
	
	@Override
	public void add(Object elemento) {
		contenido[index++] = elemento;
	}

	@Override
	public int numeroElementos() {
		return index;
	}
	
	

}
