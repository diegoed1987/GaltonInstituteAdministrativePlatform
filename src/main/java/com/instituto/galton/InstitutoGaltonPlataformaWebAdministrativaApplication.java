package com.instituto.galton;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableAsync
public class InstitutoGaltonPlataformaWebAdministrativaApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(InstitutoGaltonPlataformaWebAdministrativaApplication.class, args);
	}
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(InstitutoGaltonPlataformaWebAdministrativaApplication.class);
    }
}
