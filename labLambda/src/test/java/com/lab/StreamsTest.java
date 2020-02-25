package com.lab;

import com.lab.Entity.Persona;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class StreamsTest {

    Logger LOGGER = LoggerFactory.getLogger(StreamsTest.class);

    @Test
    public void stream() {

        Persona persona = new Persona("Deyviz");
        Persona persona2 = new Persona("Lesly");
        Persona persona3 = new Persona("Eliodoro");

        List<Persona> simplePersonas = new ArrayList<>();

        simplePersonas.add(persona);
        simplePersonas.add(persona2);
        simplePersonas.add(persona3);

        List<String> simpleNombres = convertCollectionVersion(simplePersonas);

        LOGGER.info("Simpler personas: {}",simpleNombres);

        List<Persona> streamPersonas = new ArrayList<>();
        streamPersonas.add(persona);
        streamPersonas.add(persona2);
        streamPersonas.add(persona3);
        List<String> streamNombres = convertStreamVersion(streamPersonas);

        LOGGER.info("Stream personas: {}",streamNombres);
    }

    @Test
    public void stream_filtrar_ordenar() {
        Persona persona = new Persona("Deyviz");
        Persona persona2 = new Persona("Lesly");
        Persona persona3 = new Persona("Arepa");
        List<Persona> simplePersonas = new ArrayList<>();
        simplePersonas.add(persona);
        simplePersonas.add(persona2);
        simplePersonas.add(persona3);

        String todos = simplePersonas.stream()
                .map(it -> it.getNombre())
                .sorted((o1,o2)->o1.length()+o2.length())
                .map(it -> "'"+it+"'")
                .reduce("",(a,b)->a+"\n"+b);

        LOGGER.info("stream_filtrar :{}",todos);
    }

    @Test
    public void stream_convertir() {
        Persona persona = new Persona("Deyviz");
        Persona persona2 = new Persona("Lesly");
        Persona persona3 = new Persona("Eliodoro");

        List<Persona> simplePersonas = new ArrayList<>();

        simplePersonas.add(persona);
        simplePersonas.add(persona2);
        simplePersonas.add(persona3);

        Stream<Persona> personas = simplePersonas.stream();

        Stream<String> nombres = personas.map(it -> it.getNombre());

        LOGGER.info("stream_convertir :{}",nombres.collect(Collectors.toList()));

    }

    @Test
    public void stream_filtrar() {
        Persona persona = new Persona("Deyviz");
        Persona persona2 = new Persona("Lesly");
        Persona persona3 = new Persona("Arepa");

        List<Persona> simplePersonas = new ArrayList<>();

        simplePersonas.add(persona);
        simplePersonas.add(persona2);
        simplePersonas.add(persona3);

        Stream<Persona> personas = simplePersonas.stream();

        Stream<String> nombres = personas.map(it -> it.getNombre());

        Stream<String> nombreA = nombres.filter(it -> it.startsWith("A"));

        LOGGER.info("stream_filtrar :{}",nombreA.collect(Collectors.toList()));

    }

    @Test
    public void stream_ordenar() {
        Persona persona = new Persona("Deyvizzzz");
        Persona persona2 = new Persona("Lesly");
        Persona persona3 = new Persona("Arepaaaaaaaa");

        List<Persona> simplePersonas = new ArrayList<>();

        simplePersonas.add(persona);
        simplePersonas.add(persona2);
        simplePersonas.add(persona3);

        Stream<Persona> personas = simplePersonas.stream();

        Stream<String> nombres = personas.map(it -> it.getNombre());

        Stream<String> nombreSorted = nombres.sorted((o1,o2)->o2.length()-o1.length());

        LOGGER.info("stream_ordenar :{}",nombreSorted.collect(Collectors.toList()));

    }

    @Test
    public void stream_reduce() {

        String todos = Stream.of("Lucia","Jose","Antonia")
                .reduce(": ",(a,b)->a+"\n"+b);

        LOGGER.info("stream_ordenar :{}",todos);
    }

    /* metodo Simple */
    private List<String> convertCollectionVersion(List<Persona> personas){
        List<String> nombres = new ArrayList<>();
        for (Persona persona:personas)
            nombres.add(persona.getNombre());
        return nombres;
    }

    /* metodo Streams */
    private List<String> convertStreamVersion(List<Persona> personas){
        return personas.stream()
                .map(it -> it.getNombre())
                .collect(Collectors.toList());
    }
}
