package com.spring5.ssddi.config;

import com.spring5.pets.PetService;
import com.spring5.pets.PetServiceFactory;
import com.spring5.ssddi.datasource.FakeDataSource;
import com.spring5.ssddi.repositories.EnglishGreetingRepository;
import com.spring5.ssddi.repositories.EnglishGreetingRepositoryImpl;
import com.spring5.ssddi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

@ImportResource("classpath:ssd-di-config.xml")
@Configuration
public class BeanServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(SsdConfiguration ssdConfiguration){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(ssdConfiguration.getUsername());
        fakeDataSource.setPassword(ssdConfiguration.getPassword());
        fakeDataSource.setJdbcurl(ssdConfiguration.getJdbcurl());
        return fakeDataSource;
    }

//    @Bean
//    FakeDataSource fakeDataSource(@Value("${ssd.username}") String username,
//                                  @Value("${ssd.password}") String password,
//                                  @Value("${ssd.jdbcurl}") String jdbcurl){
//        FakeDataSource fakeDataSource = new FakeDataSource();
//        fakeDataSource.setUsername(username);
//        fakeDataSource.setPassword(password);
//        fakeDataSource.setJdbcurl(jdbcurl);
//        return fakeDataSource;
//    }
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
