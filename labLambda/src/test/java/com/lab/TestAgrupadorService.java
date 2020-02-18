package com.lab;

import com.lab.service.AgrupadorService;
import com.lab.service.AgrupadorServiceConListImpl;
import org.junit.Test;

import java.util.Arrays;

import org.junit.Assert;

public class TestAgrupadorService {

	/**
	 * Completad la definicion de la clase AgrupadorConList 
	 * para que implemente la interface
	 * (este ejercicio es de repaso, no usa los metodos default)
	 */
	@Test
	public void test_add() {
		
		AgrupadorService agrupador = new AgrupadorServiceConListImpl();
		Assert.assertEquals(0, agrupador.numeroElementos());
		
		agrupador.add("primero");
		Assert.assertEquals(1, agrupador.numeroElementos());
		
	}
	
	
	/**
	 * definid un metodo default addAll que acepte un Collection y
	 * a�ada cada objeto al agrupador
	 * Cuando tengais el metodo, descomentad el codigo comentado en el test
	 */
	@Test
	public void test_addAll() {
		
		AgrupadorService agrupador = new AgrupadorServiceConListImpl();
		agrupador.addAll(Arrays.asList("primero","segundo"));
		
		Assert.assertEquals(2,agrupador.numeroElementos());
	}
}
