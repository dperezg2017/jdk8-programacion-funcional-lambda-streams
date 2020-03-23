package com.util.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;

public class PersonaLambdaOracle {

    /*
    * clase creado bajo el link: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
    * */

    private static final Logger LOOGER = LoggerFactory.getLogger(PersonaLambdaOracle.class);

    public PersonaLambdaOracle(String name, LocalDate birthday, Sex gender, String emailAddress) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.emailAddress = emailAddress;
    }

    public enum Sex {
        MALE, FEMALE
    }

    String name;
    LocalDate birthday;
    Sex gender;
    String emailAddress;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public Sex getGender() {
        return gender;
    }

    public void setGender(Sex gender) {
        this.gender = gender;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public int getAge() {
        LocalDate today = LocalDate.now();
        Period p = Period.between(getBirthday(), today);

        //LOOGER.info("{} tiene dias: {} meses: {} y años: {}",getName(),p.getDays(),p.getMonths(),p.getYears());

        return p.getYears();
    }

    public void printPerson() {
        LOOGER.info( "printPerson{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender=" + gender +
                ", emailAddress='" + emailAddress + '\'' +
                '}');
    }

}
