package com.crudwithcache.crudspringwithcache.config;

import com.crudwithcache.crudspringwithcache.model.Employee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * To Get Beans of Redis
 *
 */

@Configuration
public class RedisConfig {


    @Bean
    public JedisConnectionFactory getJedisConnectionFactory(){
        return new JedisConnectionFactory();
    }

    @Bean
    public RedisTemplate<String, Employee> redisTemplate(){
        RedisTemplate<String,Employee> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(getJedisConnectionFactory());
        return redisTemplate;
    }

}

