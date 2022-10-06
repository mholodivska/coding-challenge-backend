package com.ccb.cv_reviewer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.ccb")
@EnableJpaRepositories(basePackages = "com.ccb")
public class CvReviewerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CvReviewerApplication.class, args);
    }

}
