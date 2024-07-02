package com.enviro.assessment.grad001.mphorakgope.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDataBase(WasteRepository repository){
        return args -> {
            log.info("Data" + repository.save(new Waste("Plastic", "plastic recycle bin")));
            log.info("Data" + repository.save(new Waste("paper", "paper bin for recycling")));
            log.info("Data" + repository.save(new Waste("Glass", "Glass bin for recycling")));
        };
    }
}
