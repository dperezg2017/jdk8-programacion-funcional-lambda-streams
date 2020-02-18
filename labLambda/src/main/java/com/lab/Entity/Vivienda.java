package com.lab.Entity;

import java.util.Optional;

public class Vivienda {

	private Optional<Persona2> propietario;
	
	private String nombre;

	public Vivienda(Persona2 propietario, String nombre) {
		this.propietario = Optional.ofNullable(propietario);
		this.nombre = nombre;
	}
	public Vivienda(String nombre) {
		this.propietario = Optional.empty();
		this.nombre = nombre;
	}

	public Optional<Persona2> getPropietario() {
		return propietario;
	}

	public String getNombre() {
		return nombre;
	}
	
	public Optional<String> nombrePropietario() {
		return propietario.map(it -> it.getNombre());
	}
	
	
}
