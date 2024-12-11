package com.journalApp.Journal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class HealthCheckController {
    
    @GetMapping("/healthCheck")
    public String healthCheck() {
        return "Healthcheck Successfull";
    }
}
