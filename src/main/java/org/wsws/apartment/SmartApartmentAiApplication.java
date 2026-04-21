package org.wsws.apartment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.wsws.apartment.generator.mapper")
public class SmartApartmentAiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartApartmentAiApplication.class, args);
    }

}
