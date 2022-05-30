package com.spring5.ssddi.services;

public class SetterGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello Boss!!-----@Qualifier for Setter";
    }
}
