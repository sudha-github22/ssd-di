package com.spring5.ssddi.services;

public class ConstructorGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello Boss!!-----@Qualifier for Constructor";
    }
}
