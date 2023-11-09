package com.cms.collegemanagementsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude =  {DataSourceAutoConfiguration.class })
public class CollegemanagementsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(CollegemanagementsystemApplication.class, args);
    }

}
