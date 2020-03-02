package com.util;

import com.util.entity.Inmueble;
import com.util.entity.Persona;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class BiConsumerTest {

    private static final Logger LOOGER = LoggerFactory.getLogger(BiConsumerTest.class);

    @Test
    public void biconsumer_basico() {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "wwww.sunat-beta.wsdl");
        map.put(2, "wwww.ose-beta.wsdl");
        map.put(3, "wwww.proy.ose-beta.wsdl");
        map.forEach((i, s) -> LOOGER.info("id: {} - wsdl: {}", i, s));
    }

    @Test
    public void biconsumer_ForEach() {

        Persona persona1 = new Persona("Deyviz1 ", "Perez1 ", "Chavez1");
        Persona persona2 = new Persona("Deyviz2 ", "Perez2 ", "Chavez2");
        Persona persona3 = new Persona("Deyviz3 ", "Perez3 ", "Chavez3");
        Persona persona4 = new Persona("Deyviz4 ", "Perez4 ", "Chavez4");
        Persona persona5 = new Persona("Deyviz5 ", "Perez5 ", "Chavez5");
        Persona persona6 = new Persona("Deyviz6 ", "Perez6 ", "Chavez6");

        Inmueble inmueble1 = new Inmueble(1, "111 ", "1 ", "Jr.Combate de Angamos 126");
        Inmueble inmueble2 = new Inmueble(2, "222 ", "2 ", "Ca.La hera Mz8");
        Inmueble inmueble3 = new Inmueble(3, "333 ", "3 ", "Jr.Combate de Angamos 126");
        Inmueble inmueble4 = new Inmueble(4, "444 ", "4 ", "Ca.La hera Mz8");
        Inmueble inmueble5 = new Inmueble(5, "555 ", "5 ", "Jr.Combate de Angamos 126");
        Inmueble inmueble6 = new Inmueble(6, "666 ", "6 ", "Jr.Combate de Angamos 126");

        Map<Persona, Inmueble> mapForEach = new HashMap<>();
        mapForEach.put(persona1, inmueble1);
        mapForEach.put(persona2, inmueble2);
        mapForEach.put(persona3, inmueble3);
        mapForEach.put(persona4, inmueble4);
        mapForEach.put(persona5, inmueble5);
        mapForEach.put(persona6, inmueble6);

        BiConsumer<Persona, Inmueble> biConsumerForEach = (p, e) -> {
            LOOGER.info("Logica de un VOID: p1: {} -- {}",
                    p.getNombre().concat(p.getApelligoPaterno().concat(p.getApellidoMatero())),
                    String.valueOf(e.getIdInmueble()).concat(") ").concat(e.getNumero()).concat(e.getPiso()).concat(e.getDireccion()));
        };

        mapForEach.forEach(biConsumerForEach);
    }

    @Test
    public void biconsumer_accept() {

        Persona persona1 = new Persona("Deyviz ", "Perez ", "Chavez");
        Inmueble inmueble1 = new Inmueble(1, "111 ", "1 ", "Jr.Combate de Angamos 126");

        BiConsumer<Persona, Inmueble> biConsumerRow = (p, e) -> {
            LOOGER.info("Logica de un VOID biConsumerRow: {} -- {}",
                    p.getNombre().concat(p.getApelligoPaterno().concat(p.getApellidoMatero())),
                    String.valueOf(e.getIdInmueble()).concat(" ").concat(e.getNumero()).concat(e.getPiso()).concat(e.getDireccion()));
        };

        biConsumerRow.accept(persona1, inmueble1);
    }

    @Test
    public void biconsumer_acceptAndThen() {

        Persona persona1 = new Persona("Deyviz ", "Perez ", "Chavez");
        Inmueble inmueble1 = new Inmueble(1, "111 ", "1 ", "Jr.Combate de Angamos 126");

        BiConsumer<Persona, Inmueble> biConsumerRow2 = (p, e) -> {
            LOOGER.info("Logica de un VOID biConsumerRow2: p1: {} -- {}",
                    p.getNombre().concat(p.getApelligoPaterno().concat(p.getApellidoMatero())),
                    String.valueOf(e.getIdInmueble()).concat(") ").concat(e.getNumero()).concat(e.getPiso()).concat(e.getDireccion()));
        };
        BiConsumer<Persona, Inmueble> biConsumerRow3 = (p, e) -> {
            LOOGER.info("Logica de un VOID biConsumerRow3: p1: {} -- {}",
                    p.getNombre().concat(p.getApelligoPaterno().concat(p.getApellidoMatero())),
                    String.valueOf(e.getIdInmueble()).concat(") ").concat(e.getNumero()).concat(e.getPiso()).concat(e.getDireccion()));
        };

        biConsumerRow2.andThen(biConsumerRow3).accept(persona1, inmueble1);
    }


}
