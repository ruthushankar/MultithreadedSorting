package main.java.service.impl;

import main.java.service.Sort;
import main.java.service.utility.Utility;

import java.util.Arrays;

public class MergeSortSingleThread implements Sort {
    Comparable[] arr;
    long executionTime = 0;
    Utility utility;

    public MergeSortSingleThread(Comparable[] arr) {
        this.arr = arr;
        utility = new Utility();
    }

    public void sort() {
        long startTime = System.currentTimeMillis();
        if (arr.length < thresholdSize) {
            utility.selectionSort(arr);
        } else {
            int begin = 0;
            int end = arr.length - 1;
            mergeSort(arr, begin, end);
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }

    void mergeSort(Comparable[] arr, int begin, int end) {
        if (begin < end) {
            int half = (begin + end) / 2;
            mergeSort(arr, begin, half);
            mergeSort(arr, half + 1, end);
            merge(arr, begin, half, end);
        }
    }

    void merge(Comparable[] arr, int begin, int half, int end) {
        int begin2 = half + 1, i = begin;
        Comparable[] temp = Arrays.copyOf(arr, arr.length);
        while ((begin <= half) && (begin2 <= end)) {
            if (temp[begin].compareTo(temp[begin2]) < 0) {
                arr[i] = temp[begin];
                begin++;
            } else {
                arr[i] = temp[begin2];
                begin2++;
            }
            i++;
        }

        while (begin <= half) {
            arr[i] = temp[begin];
            i++;
            begin++;
        }

        while (begin2 <= end) {
            arr[i] = temp[begin2];
            i++;
            begin2++;
        }

    }

    public long getExecutionTime() {
        return executionTime;
    }
}