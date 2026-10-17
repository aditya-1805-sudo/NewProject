package org.example.Models;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class Trainer {
    private String name;

    private final Rabbit rabbit;
    @Autowired
    public Trainer(Rabbit rabbit){
        this.rabbit=rabbit;
    }

}
