package com.lab.service;

import java.util.Collection;

public interface AgrupadorService {

	void add(Object elemento);
	
	int numeroElementos();
	
	default void addAll(Collection col) {
		for (Object o: col) {
			add(o);
		}
	}
}
