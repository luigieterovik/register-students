package com.registerStudents.registerStudents;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class RegisterStudentsApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(RegisterStudentsApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(RegisterStudentsApplication.class, args);
    }
}
