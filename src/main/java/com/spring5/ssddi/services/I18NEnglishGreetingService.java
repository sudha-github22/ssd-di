package com.spring5.ssddi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"EN","default"})
@Service("i18Service")
public class I18NEnglishGreetingService implements GreetingService{

    @Override
    public String sayGreeting() {
        return "Hello World--EN";
    }
}
