package com.thc.spradv2025fall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Spradv2025fallApplication {
    public static void main(String[] args) {
        SpringApplication.run(Spradv2025fallApplication.class, args);
    }
}
