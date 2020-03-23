package com.util;

import static com.util.entity.PersonaLambdaOracle.Sex.*;

import com.util.entity.PersonaLambdaOracle;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UtilitarioLambda {

    private static final Logger LOOGER = LoggerFactory.getLogger(UtilitarioLambda.class);


    @Test
    public void test_printPersonsOlderThan() {
        LocalDate birthDate1 = LocalDate.of(1993, 5, 6);
        LocalDate birthDate2 = LocalDate.of(1994, 7, 1);
        LocalDate birthDate3 = LocalDate.of(1971, 7, 28);

        List<PersonaLambdaOracle> listaPersonaLambdaOracle = new ArrayList<>();
        PersonaLambdaOracle personaLambdaOracle1 = new PersonaLambdaOracle("deyviz", birthDate1, MALE, "dperezg2017@gmail.com");
        PersonaLambdaOracle personaLambdaOracle2 = new PersonaLambdaOracle("lesly", birthDate2, FEMALE, "lesly94ramos@hotmail.com");
        PersonaLambdaOracle personaLambdaOracle3 = new PersonaLambdaOracle("kathy", birthDate3, FEMALE, "kathyc@hotmail.com");

        listaPersonaLambdaOracle.add(personaLambdaOracle1);
        listaPersonaLambdaOracle.add(personaLambdaOracle2);
        listaPersonaLambdaOracle.add(personaLambdaOracle3);

        //printPersonsOlderThan(listaPersonaLambdaOracle, 40);
        printPersons(listaPersonaLambdaOracle, p->{
            if(p.getAge()<=40){
                return true;
            }
            return false;
        });
    }

    public void printPersonsOlderThan(List<PersonaLambdaOracle> listaPersonaLambdaOracle, int age) {
        for (PersonaLambdaOracle p : listaPersonaLambdaOracle) {
            if (p.getAge() >= age) {
                p.printPerson();
            }
        }
    }

    public static void printPersons(
            List<PersonaLambdaOracle> roster, CheckPerson tester) {
        for (PersonaLambdaOracle p : roster) {
            if (tester.test(p)) {
                p.printPerson();
            }
        }
    }

    interface CheckPerson {
        boolean test(PersonaLambdaOracle p);
    }
}
