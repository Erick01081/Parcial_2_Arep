package com.example.demo;

import java.util.List;

/**
 * Class that implements a binary search algorithm for sorted lists.
 */
public class BinarySearch {

    /**
     * Performs a binary search on a sorted list of integers.
     *
     * @param numbers The sorted list to search in
     * @param target The number to find
     * @return The index of the target number if found, -1 otherwise
     * @throws IllegalArgumentException if the input list is null
     */
    public static int search(List<Integer> numbers, int target) {
        if (numbers == null) {
            throw new IllegalArgumentException("Input list cannot be null");
        }
        return binarySearch(numbers, target, 0, numbers.size() - 1);
    }

    /**
     * Recursive helper method that performs the actual binary search.
     *
     * @param numbers The sorted list to search in
     * @param target The number to find
     * @param left The left boundary of the current search space
     * @param right The right boundary of the current search space
     * @return The index of the target number if found, -1 otherwise
     */
    private static int binarySearch(List<Integer> numbers, int target, int left, int right) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        int currentNumber = numbers.get(mid);

        if (currentNumber == target) {
            return mid;
        }

        if (currentNumber > target) {
            return binarySearch(numbers, target, left, mid - 1);
        } else {
            return binarySearch(numbers, target, mid + 1, right);
        }
    }
}