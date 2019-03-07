package com.takara.hako.exam;

import org.jboss.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ExamApplication extends SpringBootServletInitializer {

    private static Logger logger = Logger.getLogger(ExamApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ExamApplication.class, args);
        logger.warn("============= SpringBoot Start Success =============");
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ExamApplication.class);
    }

}
