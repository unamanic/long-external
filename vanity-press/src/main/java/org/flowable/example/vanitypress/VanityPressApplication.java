package org.flowable.example.vanitypress;

import org.flowable.example.vanitypress.config.VanityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VanityPressApplication {

    public static void main(String[] args) {
        SpringApplication.run(VanityPressApplication.class, args);
    }

    @Bean
    @ConfigurationProperties(prefix = "vanity.config")
    public VanityConfig vanityConfig() {
        return new VanityConfig();
    }

}
