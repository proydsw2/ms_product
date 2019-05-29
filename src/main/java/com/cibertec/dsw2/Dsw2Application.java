package com.cibertec.dsw2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
@SpringBootApplication
public class Dsw2Application {

   private static final Logger log = LoggerFactory.getLogger(Dsw2Application.class);


   public static void main(String[] args) {
      log.info("--------------- Ejecutando aplicacion MS PRODUCT ---------------");
      SpringApplication.run(Dsw2Application.class, args);
      log.info("--------------- Terminada ejecucion MS PRODUCT ---------------");
   }


}
