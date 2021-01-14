package com.kicinger.exploration.gradle.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kicinger.exploration.gradle")
public class GradleApplication {

    public static void main(String[] args) {
        SpringApplication.run(GradleApplication.class, args);
    }

}
