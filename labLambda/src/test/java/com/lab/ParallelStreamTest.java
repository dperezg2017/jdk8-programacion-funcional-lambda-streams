package com.lab;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ParallelStreamTest {

    Logger LOGGER = LoggerFactory.getLogger(LazynessTest.class);

    @Test
    public void strema_paralelo() {

        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer suma = lista.stream()
                .peek(System.out::println)
                .reduce(0, (a, b) -> a + b);
        LOGGER.info("suma : {}", suma);

        Integer sumaParalelo = lista.parallelStream()
                .peek(System.out::println)
                .reduce(0, (a, b) -> a + b);

        LOGGER.info("sumaParalelo : {}", sumaParalelo);
    }

    @Test
    public void strema_paralelo2() {

        List<Integer> lista = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        String paralelo = lista.parallelStream()
                .map(String::valueOf)  //convertimos los elementos a String
                .collect(Collectors.joining(",")); // actua sobre un stream de string, concateanando con el separador indicado

        LOGGER.info("sumaParalelo : {}", paralelo);
    }
}
