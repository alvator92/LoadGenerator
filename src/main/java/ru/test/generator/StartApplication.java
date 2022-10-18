package ru.test.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Main class
 */
@Slf4j
@SpringBootApplication
public class StartApplication {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(StartApplication.class, args);
        System.out.println("Hello LoadGen!");


    }
}
