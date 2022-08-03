package com.demo.pruebatecnicamc.be;

import org.jsondoc.spring.boot.starter.EnableJSONDoc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@EnableJSONDoc
@ImportResource("classpath:/app-config.xml")
public class PruebaTecnicaMCApplication {

    public static void main(String[] args) {
        SpringApplication.run(PruebaTecnicaMCApplication.class, args);
    }
}
