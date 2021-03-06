package com.example.soft_cons.todo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new Todo("Item 1")));
            log.info("Preloading " + repository.save(new Todo("Item 2")));
        };
    }
}
