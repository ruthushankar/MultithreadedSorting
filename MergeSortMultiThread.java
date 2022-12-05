package main.java.service.impl;

import main.java.service.Sort;
import main.java.service.utility.Utility;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

public class MergeSortMultiThread implements Sort {
    Comparable[] arr;
    long executionTime = 0;
    Utility utility;

    public MergeSortMultiThread(Comparable[] arr) {
        this.arr = arr;
        utility = new Utility();
    }

    public void sort() {
        long startTime = System.currentTimeMillis();
        if (arr.length < thresholdSize) {
            utility.selectionSort(arr);
        } else {
            int end = arr.length - 1;
            int half = (end) / 2;
            MergeSortTask T1 = new MergeSortTask(arr, 0, half);
            MergeSortTask T2 = new MergeSortTask(arr, half + 1, end);
            T1.fork();
            T2.fork();
            T1.join();
            T2.join();
            merge(arr, 0, half, end);
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }

    public void merge(Comparable[] arr, int begin, int half, int end) {
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

    class MergeSortTask extends RecursiveAction {
        private int begin;
        private int end;
        Comparable[] arr;

        MergeSortTask(Comparable[] arr, int begin, int end) {
            this.arr = arr;
            this.begin = begin;
            this.end = end;
        }

        @Override
        protected void compute() {
            mergeSort(arr, begin, end);
        }

        public void mergeSort(Comparable[] arr, int begin, int end) {
            if (begin < end) {
                int half = (begin + end) / 2;
                mergeSort(arr, begin, half);
                mergeSort(arr, half + 1, end);
                merge(arr, begin, half, end);
            }
        }
    }

    public long getExecutionTime() {
        return executionTime;
    }
}