package com.edwardchome.demo.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Home {
    @GetMapping
    public String Home(){
        return " The app is working!!!     "+ new Date();
    }
}
