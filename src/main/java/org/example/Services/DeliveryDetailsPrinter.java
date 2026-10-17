package org.example.Services;

import org.example.Intefaces.Sorter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DeliveryDetailsPrinter {
    Sorter sorter;
    @Autowired
    public DeliveryDetailsPrinter(SortByAddress sorter){
        this.sorter=sorter;
    }
    public void print(ArrayList<String> list){
        for(Object obj :list){
            System.out.println(obj);
        }
    }
}
