package com.lab.service;

import java.util.ArrayList;
import java.util.List;

public class AgrupadorServiceConListImpl implements AgrupadorService {

	private List<Object> contenido = new ArrayList<>();

	@Override
	public void add(Object elemento) {
		contenido.add(elemento);
	}

	@Override
	public int numeroElementos() {
		return contenido.size();
	}
	

}
