package com.unitec.amigos;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*Esta anotacion hace que nuestra clase se vuelve un controlador
que es lo que obtiene recursos de un servidor y se la da al cliente*/
@RestController
//Esta anotacion nos hace que busquemos api
@RequestMapping("/api")
public class ControladorHola {
    //Este primer recurso es un hola mundo de un servicio REST que usa
    //el metodo get
    @GetMapping("/hola")
        public  String saludar(){
            return "Hola desde mi primer servicio REST";
    }
}
