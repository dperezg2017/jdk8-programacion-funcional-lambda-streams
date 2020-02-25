package com.lab;

import com.lab.Entity.Persona;
import com.lab.Entity.Persona3;
import org.junit.Test;

import java.util.Optional;

public class MethodTest {


    @Test
    public void metodo_Optinal() {
        Persona persona = new Persona("deyviz", "perez", "chavez");
        String saluda = saluda(persona);
        System.out.println("saluda1: " + saluda);

        Persona persona2 = new Persona(null, "perez2", "chavez2");

        Optional<Persona> personaOptional = Optional.of(persona2);
        /*Optional<Persona> personaOptional = Optional.empty();*/
        //Optional<Persona> personaOptional = Optional.ofNullable(persona2);
        String saluda2 = saluda2(personaOptional);
        System.out.println("saluda2: " + saluda2);

        Persona persona3 = new Persona("deyviz3", "perez3", "chavez3");
        Optional<Persona> personaOptional2 = Optional.of(persona3);
        Optional<String> saluda3 = saludaOptional(personaOptional2);
        System.out.println("saluda3: " + saluda3);

        Persona persona4 = new Persona(null, "perez4", "chavez4");
        Optional<Persona> personaOptional3 = Optional.of(persona4);
        String saluda4 = saludaOrElse(personaOptional3);
        System.out.println("saluda4: " + saluda4);

        Persona persona5 = new Persona(null, "perez5", "chavez5");
        Optional<Persona> personaOptional5 = Optional.of(persona5);
        String saluda5 = saludaReferenced(personaOptional5);
        System.out.println("saluda5: " + saluda5);

        Persona3 persona6 = new Persona3(Optional.of("hols"));
        Optional<Persona3> personaOptional6 = Optional.of(persona6);
        String saluda6 = saludaOrElseFlatMap(personaOptional6);
        System.out.println("saluda6: " + saluda6);

    }

    String saludaReferenced(Optional<Persona> persona) {
        return persona.map(Persona::getNombre)
                .map("Hola "::concat)
                .orElse("Estoy solito");
    }

    String saludaOrElse(Optional<Persona> persona) {
        return persona.map(it -> "Hola " + it.getNombre())
                .orElse("Estoy solo");
    }

    String saludaOrElseFlatMap(Optional<Persona3> persona) {
        return persona.flatMap(Persona3::getNombre)
                .map("Hola "::concat)
                .orElse("Estoy solito");
    }

    Optional<String> saludaOptional(Optional<Persona> persona) {
        return persona.map(it -> "Hola " + it.getNombre());
    }

    String saluda2(Optional<Persona> persona) {
        return "Hola " + persona.get().getNombre();
    }

    String saluda(Persona persona) {
        return "Hola " + persona.getNombre();
    }
}
