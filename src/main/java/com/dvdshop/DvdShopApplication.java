package com.dvdshop;

import com.dvdshop.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class DvdShopApplication implements ApplicationRunner {

    @Autowired
    ActorRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(DvdShopApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
    }

}
