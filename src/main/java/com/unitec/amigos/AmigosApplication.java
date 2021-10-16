package com.unitec.amigos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//Esta anotacion instala en el puerto 8080 del servidor tomcat pero podemos cambiarlo
//Se cambio al 9000
@SpringBootApplication
public class AmigosApplication {

	public static void main(String[] args) {

		SpringApplication.run(AmigosApplication.class, args);
	}
}
