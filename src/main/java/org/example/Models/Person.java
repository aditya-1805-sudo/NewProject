package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Person {
    private String name;
    private Parrot parrot;
    @Autowired
    private Rabbit rabbit;

    @Override
    public String toString(){
        return "Person's Name:"+name;
    }
}
