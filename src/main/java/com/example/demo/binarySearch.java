package com.example.demo;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class binarySearch {

    private static int  counter;

    public static String binarySearching(List<Integer> numbers, Integer numberToCompare, int counter) {

        int initial_index = (numbers.size() / 2);

        counter += initial_index;


        if (!numbers.isEmpty()) {
            if (numberToCompare.equals(numbers.get(initial_index))) {
                return String.valueOf(counter);
            } else if (numbers.get(initial_index) > numberToCompare) {
                return binarySearching(numbers.subList(0,initial_index), numberToCompare, counter - initial_index);
            } else {
                return binarySearching(numbers.subList(initial_index, numbers.size()), numberToCompare, counter);
            }
        } else {
            return "-1";
        }
    }
}

