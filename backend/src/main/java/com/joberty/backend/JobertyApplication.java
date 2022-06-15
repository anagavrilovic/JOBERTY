package com.joberty.backend;

import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JobertyApplication {

    public static final org.slf4j.Logger LOGGER_INFO= LoggerFactory.getLogger("joberty-info");
    public static final org.slf4j.Logger LOGGER_ERROR= LoggerFactory.getLogger("joberty-error");
    public static final org.slf4j.Logger LOGGER_WARNING= LoggerFactory.getLogger("joberty-warning");

    public static void main(String[] args) {
        SpringApplication.run(JobertyApplication.class, args);
    }

}
