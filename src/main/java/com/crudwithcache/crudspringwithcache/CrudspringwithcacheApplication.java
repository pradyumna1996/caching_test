package com.crudwithcache.crudspringwithcache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching //Enabling Caching
public class CrudspringwithcacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudspringwithcacheApplication.class, args);
    }

}
