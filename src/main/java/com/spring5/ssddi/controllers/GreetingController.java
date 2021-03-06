package com.spring5.ssddi.controllers;

import com.spring5.ssddi.services.GreetingService;
import org.springframework.stereotype.Controller;

@Controller
public class GreetingController {


    private final GreetingService greetingService;


    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }
    public String getGreeting(){

        return greetingService.sayGreeting();
    }
}
