package com.spring5.ssddi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Controller
public class PrototypeBean {

    public PrototypeBean(){
        System.out.println("Creating a Prototype Bean!!!!!!!!!!!!!");
    }

    public String getBeanScope(){
        return "I'm a Prototype";
    }
}
