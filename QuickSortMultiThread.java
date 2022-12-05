package main.java.service.impl;

import main.java.service.Sort;
import main.java.service.utility.Utility;

import java.util.concurrent.RecursiveAction;

public class QuickSortMultiThread implements Sort {

    Comparable array[];
    long executionTime = 0;
    Utility utility;

    public QuickSortMultiThread(Comparable array[]) {
        this.array = array;
        utility = new Utility();
    }

    @Override
    public void sort() {
        long startTime = System.currentTimeMillis();
        if (array.length < thresholdSize) {
            utility.selectionSort(array);
        } else {
            int pivot = utility.partition(array, 0, array.length - 1);
            QuickSortTask leftTask = new QuickSortTask(array, 0, pivot - 1);
            QuickSortTask rightTask = new QuickSortTask(array, pivot + 1, array.length - 1);
            leftTask.fork();
            rightTask.fork();
            leftTask.join();
            rightTask.join();
        }
        long endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;
    }

    @Override
    public long getExecutionTime() {
        return executionTime;
    }

    class QuickSortTask extends RecursiveAction {
        int left;
        int right;
        Comparable[] array;

        QuickSortTask(Comparable[] arr, int left, int right) {
            this.left = left;
            this.right = right;
            array = arr;
        }

        protected void compute() {
            sort(left, right);
        }

        private void sort(int left, int right) {
            if (left < right) {
                int pivot = utility.partition(array, left, right);
                sort(left, pivot - 1);
                sort(pivot + 1, right);
            }
        }

    }
}