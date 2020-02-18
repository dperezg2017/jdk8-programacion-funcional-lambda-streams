package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import service.LambdaService;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdasBasico {

    public static final Logger LOGGER = LoggerFactory.getLogger(LambdasBasico.class);
    @Autowired
    LambdaService lambdaService;

    public static void main (String[] args) {

        System.out.println();
        LOGGER.info("service: ",lambdaService.valor());

    }



}
