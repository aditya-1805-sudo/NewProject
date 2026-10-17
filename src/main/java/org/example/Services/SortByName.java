package org.example.Services;

import org.example.Intefaces.Sorter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Service
public class SortByName implements Sorter {

    public ArrayList<String> sort(ArrayList<String> list) {
        Collections.sort(list);
        return list;
    }
}
