package com.spring5.ssddi;

import com.spring5.ssddi.controllers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SsdDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SsdDiApplication.class, args);
		MyController myController = (MyController) ctx.getBean("myController");

		String greeting = myController.sayHello();
		System.out.println(greeting);

		System.out.println("-------Spring Profile--------");
		I18NController i18NController = (I18NController)ctx.getBean("i18NController");
		System.out.println(i18NController.sayHello());

		System.out.println("-------@Qualifier - More Than one bean of the same type--------");
		GreetingController greetingController = (GreetingController)ctx.getBean("greetingController");
		System.out.println(greetingController.getGreeting());

		//------@Qualifier - More Than one bean of the same type--------
		System.out.println("---------Property Injected Dependency-----------");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController)ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("----------Setter Injected Dependency--------------");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("----------Constructor Injected Dependency--------------");
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController)
				ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());
	}

}
