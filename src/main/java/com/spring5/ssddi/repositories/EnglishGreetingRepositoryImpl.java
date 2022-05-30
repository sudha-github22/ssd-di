package com.spring5.ssddi.repositories;

public class EnglishGreetingRepositoryImpl implements EnglishGreetingRepository{

    @Override
    public String sayGreeting() {
            return "Hello World--EN";
    }
}
