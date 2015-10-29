package com.modye.bigdatabenchmark;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by modye on 29/10/2015.
 */
@EnableAutoConfiguration
@ComponentScan
public class Application {
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}
