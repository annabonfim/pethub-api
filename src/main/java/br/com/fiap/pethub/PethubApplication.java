package br.com.fiap.pethub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@SpringBootApplication
@ConfigurationPropertiesScan
public class PethubApplication {

    public static void main(String[] args) {
        SpringApplication.run(PethubApplication.class, args);
    }

}
