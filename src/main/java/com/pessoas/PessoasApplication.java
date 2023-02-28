package com.pessoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class PessoasApplication {

    public static void main(String[] args) {
        SpringApplication.run(PessoasApplication.class, args);
    }

}
