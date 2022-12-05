package main.java.service.impl;

import main.java.service.Sort;
import main.java.service.utility.Utility;

public class QuickSortSingleThread implements Sort {

    Comparable array[];
    long executionTime = 0;
    Utility utility;

    public QuickSortSingleThread(Comparable array[]) {
        this.array = array;
        utility = new Utility();
    }

    @Override
    public void sort() {
        long startTime = System.currentTimeMillis();
        if (array.length < 100) {
            utility.selectionSort(array);
        } else {
            sort(0, array.length - 1);
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }

    @Override
    public long getExecutionTime() {
        return executionTime;
    }

    void sort(int low, int high) {
        if (low < high) {
            int pi = utility.partition(array, low, high);
            sort(low, pi - 1);
            sort(pi + 1, high);
        }

    }
}