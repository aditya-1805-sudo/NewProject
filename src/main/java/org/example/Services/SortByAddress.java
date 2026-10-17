package org.example.Services;

import org.example.Intefaces.Sorter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SortByAddress implements Sorter {
    public ArrayList<String> sort(ArrayList<String> list){
        Collections.sort(list);
        return list;
    }
}
