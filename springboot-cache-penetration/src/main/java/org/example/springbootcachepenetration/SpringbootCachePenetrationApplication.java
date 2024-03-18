package org.example.springbootcachepenetration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class SpringbootCachePenetrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootCachePenetrationApplication.class, args);
    }


    @RequestMapping("/api/getByid/{id}")
    public String getByid() {
        
        return "Hello Spring Boot";
    }






}
