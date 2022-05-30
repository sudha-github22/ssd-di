package com.spring5.ssddi.config;

import com.spring5.pets.PetService;
import com.spring5.pets.PetServiceFactory;
import com.spring5.ssddi.repositories.EnglishGreetingRepository;
import com.spring5.ssddi.repositories.EnglishGreetingRepositoryImpl;
import com.spring5.ssddi.services.*;
import org.springframework.context.annotation.*;

@ImportResource("classpath:ssd-di-config.xml")
@Configuration
public class BeanServiceConfig {

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog","default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
       return petServiceFactory.getPetService("dog");
    }

    @Profile("cat")
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){

        return petServiceFactory.getPetService("cat");
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }


    @Profile({"EN","default"})
    @Bean
    I18NEnglishGreetingService i18Service(EnglishGreetingRepository englishGreetingRepository){
        return new I18NEnglishGreetingService(englishGreetingRepository);
    }

    @Profile("ES")
    @Bean("i18Service")
    I18NSpanishService i18NSpanishService(){
        return new I18NSpanishService();
    }

    @Primary
    @Bean
    GreetingServiceImpl greetingServiceImpl(){
        return new GreetingServiceImpl();
    }

    @Bean
    PropertyGreetingService propertyGreetingService(){
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService(){
        return new SetterGreetingService();
    }
}
