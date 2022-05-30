package com.spring5.ssddi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean {

    public SingletonBean(){
        System.out.println("Creating a Singleton bean!!!");
    }

    public String getBeanScope(){
        return "I'm a Singleton";
    }
}
