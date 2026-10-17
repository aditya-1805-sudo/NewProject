package org.example.Configuration;

import org.example.Models.Parrot;
import org.example.Models.Person;
import org.example.Models.Rabbit;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ComponentScan(basePackages = "org.example")
public class ProjectConfig {

    @Primary
    @Bean
    Parrot parrot(){
        var p=new Parrot();
        p.setName("Koko");
        return p;
    }
    @Bean
    Parrot parrot1(){
        var p=new Parrot();
        p.setName("Riki");
        return p;
    }
    @Primary
    @Bean
    Person person(){
        var p=new Person();
        p.setName("Mage");
        p.setParrot(parrot());
        return p;
    }
    @Bean
    public Person person1(@Qualifier("parrot1") Parrot parrot){
        var p=new Person();
        p.setName("WK");
        p.setParrot(parrot);
        return p;
    }
    @Bean
    String hello()
    {
        return "Hello";
    }
    @Bean
    Integer ten(){
        return 10;
    }
}
