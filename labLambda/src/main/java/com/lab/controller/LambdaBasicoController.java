package com.lab.controller;

import com.lab.service.LambdaService;
import com.lab.util.Utilidades;
import com.sun.org.apache.xpath.internal.objects.XString;
import org.apache.tomcat.util.bcel.Const;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.rmi.CORBA.Util;
import java.util.*;

@RestController
@RequestMapping(value = "/lambda")
public class LambdaBasicoController {

    public static final Logger LOGGER = LoggerFactory.getLogger(LambdaBasicoController.class);

    private LambdaService lambdaService;

    public LambdaBasicoController(LambdaService lambdaService) {
        this.lambdaService = lambdaService;
    }

    @GetMapping(value = "basico")
    public void obtenerLambdaBasico() {

        // Retornar un valor
        int metodoSimpleDevuelve20 = lambdaService.valor();
        int metodoLambdaDevuelve10 = devuelve5().valorLambda();
        LOGGER.info("Simple valor Simple metodoDevuelve20: {} ", metodoSimpleDevuelve20);
        LOGGER.info("Lambda valor Lambda metodoDevuelve10: {} ", metodoLambdaDevuelve10);

        // Retornar un valor con parametros
        int metodoSimpleSuma2numeros2y3 = lambdaService.valor(2, 3);
        int metodoLambdaSuma2numeros5y5 = opera().valorLambda(5, 5);
        LOGGER.info("Simple valor metodoSimpleSuma2numeros2y3: {} ", metodoSimpleSuma2numeros2y3);
        LOGGER.info("Lambda valor metodoLambdaSuma2numeros5y5: {} ", metodoLambdaSuma2numeros5y5);

        // Inicializar un Array
        String[] arraySimple = new String[3];
        String valor = "SimpleWelcome";
        lambdaService.inicializa(arraySimple, valor);
        LOGGER.info("Simple arraySimple: {} {} ", arraySimple.length, arraySimple);

        String[] arrayLambda = new String[4];
        String valorLambda = "LambdaWelcome";
        obtenInicializador().inicializa(arrayLambda, valorLambda);
        LOGGER.info("Lambda arrayLambda: {} {}", arrayLambda.length, arrayLambda);

    }

    @GetMapping(value = "utilitario")
    public void utilitario() {

        // Ordena numeros y compara el tamaño de caracter
        List<String> nombres = Arrays.asList("cortocortocorto", "medianomediano", "largo");
        List<Integer> numeros = Arrays.asList(5,7,1,6,3,4,2);

        Comparator<String> comparadorLongitud = (o1, o2) -> o1.length() - o2.length();
        Comparator<Integer> ordenaNumero = (o1,o2) -> o1.compareTo(o2);

        Collections.sort(nombres,comparadorLongitud);
        Collections.sort(numeros,ordenaNumero);
        Collections.reverse(numeros);

        LOGGER.info("LambdaNumeros: {}",numeros);
        LOGGER.info("LambdaNombres: {}",nombres);

        // lambda, pero no es optimo en este caso.
        List<String> lista = Arrays.asList("ab","b","ccc");
        lista.sort((o1,o2)->Utilidades.comparandoEstatico(o1,o2));
        LOGGER.info("Lambda lista: {}",lista);

        // lo optimo es usar reference
        List<String> lista2 = Arrays.asList("ab2","b2","ccc2");
        lista2.sort(Utilidades::comparandoEstatico);
        LOGGER.info("Reference Static lista2: {}",lista2);

        // si en caso el metodo es estatica, debemos inicializar
        List<String> lista3 = Arrays.asList("ab3","b3","ccc3");
        Utilidades util = new Utilidades();
        lista3.sort(util::comparandoNoEstatico);
        LOGGER.info("Reference No Static lista3: {}",lista3);



    }


    public InicializadorArrays obtenInicializador() {
        return (p1, p2) -> {
            for (int i = 0; i < p1.length; i++) {
                p1[i] = p2;
            }
        };
    }

    public Constante devuelve5() {
        return () -> 10;
    }

    public Operador opera() {
        return (p1, p2) -> p1 + p2;
    }

    interface Constante {
        int valorLambda();
    }

    interface Operador {
        int valorLambda(int p1, int p2);
    }

    interface InicializadorArrays {
        void inicializa(String[] array, String valor);
    }

}
