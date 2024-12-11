package com.santanu.tutorial1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class MyClass {
    
//    @GetMapping("/")
//    public String hello() {
//        return "Hello World";
//    }
    @Autowired
    private Dog dog;

    @GetMapping("/")
    public String hello(){
        return dog.printDependencyInjection();
    }
}
