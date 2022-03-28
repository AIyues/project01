package com.team11.server;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
@MapperScan("com.team11.server.mapper")
public class Online_attendance {
    public static void main(String[] args) {
        SpringApplication.run(Online_attendance.class,args);
    }
}
