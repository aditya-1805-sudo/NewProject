package org.example.Models;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class Rabbit {
    private String name;

    @PostConstruct
    public void init() {
        this.name = "Ace";
    }
    @Override
    public String toString(){
        return "Rabbit:"+name;
    }
}
