package com.lab;

import com.lab.Entity.Persona;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class LazynessTest {

    Logger LOGGER = LoggerFactory.getLogger(LazynessTest.class);

    @Test
    public void lazyness_ok() {

        String strings = Stream.of("b","c","a")
                .sorted()
                .reduce("",String::concat);

        LOGGER.info("Lazyness_ok:{}",strings);
    }

    @Test
    public void lazyness_error() {

        Stream<String> strings = Stream.of("b","c","a");
        strings.sorted();
        // error ya que en el sorted lo invalida
        String p = strings.reduce("",String::concat);
        LOGGER.info("lazyness_error :{}",p);
    }

    @Test
    public void lazyness_convertir_stream_stringbuilder() {

        Stream<String> stream = Stream.of("a","b","c");
        StringBuilder sb = new StringBuilder();
        stream.forEach(s->sb.append(s));

        LOGGER.info("lazyness_convertir_stream_stringbuilder :{}",sb);
    }
}
