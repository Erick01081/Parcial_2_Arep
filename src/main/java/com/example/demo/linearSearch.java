package com.example.demo;

import java.lang.reflect.Array;
import java.util.List;

public class linearSearch {
    public static int search(List<Integer> numbers, Integer numberToCompare){
        for (Integer i = 0; i < numbers.size(); i++) {
            if ((numbers.get(i)).equals(numberToCompare)) {
                return i;
            }
        } return -1;
    }
}
