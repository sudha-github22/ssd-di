package com.spring5.ssddi.services;


public class PropertyGreetingService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hello Boss!!-----@Qualifier for Property";
    }
}
