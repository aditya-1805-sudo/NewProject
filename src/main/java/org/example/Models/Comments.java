package org.example.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class Comments {
    private String author;
    private String text;
}
