package com.enviro.assessment.grad001.mphorakgope;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.logging.Logger;

@Configuration
public class LoadDatabase {
    private static final Logger log = (Logger) LoggerFactory.getLogger(LoadDatabase.class);
    @Bean
    CommandLineRunner initDataBase(WasteRepository repository){
        return args -> {
            log.info("Preloading "+ repository.save(new Waste("Plastic", "plastic recycle bin")));
            log.info("preloading" + repository.save(new Waste("paper", "paper bin for recycling")));
        };
    }
}
