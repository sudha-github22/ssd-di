package com.spring5.ssddi.services;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
@Primary
@Service
public class GreetingServiceImpl implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello Boss!!---From Primary Bean ..";
    }
}
