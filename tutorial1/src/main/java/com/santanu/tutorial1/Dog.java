package com.santanu.tutorial1;

import org.springframework.stereotype.Component;

@Component
public class Dog {

    public String printDogName(){
        return "Hello Dog";
    }

    // Understanding dependency injection
    public String printDependencyInjection(){
        return "This explains working of Dependency injection and Inversion of Control";
    }
}
