package com.util;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class UtilitarioCollectors {

    private static final Logger LOOGER = LoggerFactory.getLogger(UtilitarioCollectors.class);

    @Test
    public void utilitario_Collectors() {

        List<String> names = Arrays.asList("Deyviz","Lesly","Catalina","Edgard");

        for (String name:names)
            if (!name.equals("Deyviz"))
                LOOGER.info("Simple: {}",name);


        Consumer<String> consumer=(s)->{ LOOGER.info("Filter: {}",s); };
        Predicate<String>  predicate= (s)->{ boolean is = !s.equals("Deyviz");return is; };
        names.stream().filter(predicate).forEach(consumer);




    }
}
