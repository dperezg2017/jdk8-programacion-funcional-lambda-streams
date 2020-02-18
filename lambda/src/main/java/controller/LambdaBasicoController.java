package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.LambdaService;

@RestController
@RequestMapping(value = "/lambda")
public class LambdaBasicoController {

    public static final Logger LOGGER = LoggerFactory.getLogger(LambdaBasicoController.class);

    @Autowired
    LambdaService lambdaService;

    @GetMapping(value = "basico")
    public void obtenerLambdaBasico(){

    }
}
