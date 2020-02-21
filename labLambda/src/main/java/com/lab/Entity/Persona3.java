package com.lab.Entity;

import java.util.Optional;

public class Persona3 {

	private Optional<String> nombre;

	public Persona3(Optional<String> nombre) {
		this.nombre = nombre;
	}

	public Persona3() {

	}

	public Optional<String> getNombre() {
		return nombre;
	}
	
	
}
