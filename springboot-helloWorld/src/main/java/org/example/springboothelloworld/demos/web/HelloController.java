package org.example.springboothelloworld.demos.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello() throws UnknownHostException {
        InetAddress addr = InetAddress.getLocalHost();
        return "Hello Spring Boot" + addr.getHostAddress();
    }

}

