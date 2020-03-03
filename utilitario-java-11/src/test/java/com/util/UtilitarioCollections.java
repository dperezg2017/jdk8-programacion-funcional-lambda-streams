package com.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.zip.ZipEntry;

public class UtilitarioCollections {

    private static final Logger LOOGER = LoggerFactory.getLogger(BiConsumerTest.class);

    @Test
    public void utilitario_Collection() {

        List<Integer> listaInteger = Arrays.asList(14, 15, 3, 9, 10, 1, 2, 4, 5, 6, 7, 8, 11, 12, 13);

        Collections.sort(listaInteger);
        LOOGER.info("Integer Ordenar {}", listaInteger);

        Collections.reverse(listaInteger);
        LOOGER.info("Integer Invertir {}", listaInteger);

        Integer maxInteger = Collections.max(listaInteger);
        LOOGER.info("Integer maxInteger {}", maxInteger);

        Integer minInteger = Collections.min(listaInteger);
        LOOGER.info("Integer minInteger {}", minInteger);

        List<String> listaString = Arrays.asList("Deyviz", "Lesly", "Magnolia", "Deutoronomio", "Elio");

        Collections.sort(listaString);
        LOOGER.info("String Ordenar {}", listaString);

        Collections.reverse(listaString);
        LOOGER.info("String Invertir {}", listaString);

        List<String> listaLetras = Arrays.asList("B", "C", "D", "A", "E");

        String maxString = Collections.max(listaLetras);
        LOOGER.info("Integer maxString {}", maxString);

        String minString = Collections.min(listaLetras);
        LOOGER.info("Integer minString {}", minString);

        List<String> listaNombres = new ArrayList<>();
        listaNombres.add("deyviz");
        listaNombres.add("lesly");
        listaNombres.add("margarita");
        listaNombres.add("eliodoro");
        int index = Collections.binarySearch(listaNombres, "margarita");
        LOOGER.info("List index : {}", index);

        Deque<Integer> deque = new LinkedList<Integer>();
        deque.add(100);
        deque.add(200);
        deque.add(300);
        deque.add(400);
        Queue<Integer> queque = Collections.asLifoQueue(deque);
        //returns a views of a deque as a last in first out queue LIFO
        LOOGER.info("Deque queque : {}", queque);

        List<Integer> listaIntegerDisjoint1 = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listaIntegerDisjoint2 = Arrays.asList(6, 7, 8, 9, 10);
        boolean disjoint = Collections.disjoint(listaIntegerDisjoint1, listaIntegerDisjoint2);
        LOOGER.info("Lists disjoint: {}", disjoint);

        List<Integer> listaIntegerRotate = Arrays.asList(1, 2, 3, 4, 5);
        Collections.rotate(listaIntegerRotate, 1);
        LOOGER.info("List Rotate: {}", listaIntegerRotate);

        List<Integer> listaIntegerCopy = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> listaIntegerDestino = Arrays.asList(6, 7, 8, 9, 10);
        Collections.copy(listaIntegerDestino, listaIntegerCopy);
        LOOGER.info("List Copy: {}", listaIntegerDestino);

        List<Integer> listaIntegerEnum = Arrays.asList(1, 2, 3, 4, 5);
        Enumeration<Integer> enumeration = Collections.enumeration(listaIntegerEnum);
        LOOGER.info("List enumeration: {}", enumeration.asIterator().hasNext());

        List<Integer> listaIntegerShufle = Arrays.asList(1, 2, 3, 4, 5);
        Collections.shuffle(listaIntegerShufle);
        LOOGER.info("List Random shufle: {}", listaIntegerShufle);

        List<Integer> listaIntegerFrequency = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 2, 4, 2);
        int frequency = Collections.frequency(listaIntegerFrequency, 2);
        LOOGER.info("List Frequency: {}", frequency);

        List<Integer> listaIntegerFill = Arrays.asList(1,2,3,4,5);
        Collections.fill(listaIntegerFill, 4);
        LOOGER.info("List Fill: {}", listaIntegerFill);

        //Retorna un inmutable set conteniendo solo lo espicifico por el objeto
        Set<String> singleton = Collections.singleton("Deyviz");
        LOOGER.info("List Singleton: {}", singleton);

        List<Integer> listaIntegerSwap = Arrays.asList(1,2,3,4,5);
        // la posicio i remplazara la j
        Collections.swap(listaIntegerSwap, 0,4);
        LOOGER.info("List Swap: {}", listaIntegerSwap);

        List<Integer> listaIntegerUnmodifiableList = Arrays.asList(1,2,3,4,5);
        Collections.unmodifiableList(listaIntegerUnmodifiableList);
        LOOGER.info("List UnmodifiableList: {}", listaIntegerUnmodifiableList);
        //unmodifiableList, no puede agregar otra fila a mi LIST unmodifiableList
        // listaIntegerUnmodifiableList.add(2);

        // se generan 4 copias, y asu vez es inmutable, nadie puede agregar o alterar esa lista.
        List<String> listaStringNCopies = Collections.nCopies(4,"deyviz");
        LOOGER.info("List listaStringNCopies: {}", listaStringNCopies);
    }
}
