package com.spring5.ssddi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("ES")
@Service("i18Service")
public class I18NSpanishService implements GreetingService{
    @Override
    public String sayGreeting() {
        return "Hola Munda--ES";
    }
}
