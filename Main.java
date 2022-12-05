package main.java.service;

import main.java.service.impl.MergeSortMultiThread;
import main.java.service.impl.MergeSortSingleThread;
import main.java.service.impl.QuickSortMultiThread;
import main.java.service.impl.QuickSortSingleThread;
import main.java.service.utility.Utility;

public class Main {
    public static void main(String[] args) {

        int[] arraySize = {10, 50, 100, 200, 500, 1000, 2500, 5000, 10000, 50000, 100000, 500000};
        Comparable input1[];
        Comparable input1Clone[];

        System.out.println("Testing quick sort implemented");
        QuickSortSingleThread quickSortSingleThread;
        QuickSortMultiThread quickSortMultiThread;
        for (int i = 0; i < 12; i++) {
            input1 = Utility.getRandomIntArray(arraySize[i]);
            //input1 = Utility.getAlphaNumericString(arraySize[i]);
            //input1 = Utility.getAlphaNumericString(arraySize[i]);
            input1Clone = input1.clone();
            quickSortSingleThread = new QuickSortSingleThread(input1);
            quickSortSingleThread.sort();
            System.out.println("Is the input sorted: " + Utility.isSorted(input1));
            System.out.println("Execution time for QuickSort with one thread: " + quickSortSingleThread.getExecutionTime());

            quickSortMultiThread = new QuickSortMultiThread(input1Clone);
            quickSortMultiThread.sort();
            System.out.println("Is the input sorted: " + Utility.isSorted(input1Clone));
            System.out.println("Execution time for QuickSort with multi thread: " + quickSortMultiThread.getExecutionTime());
        }

        System.out.println("Testing merge sort implemented");
        MergeSortSingleThread mergeSortSingleThread;
        MergeSortMultiThread mergeSortMultiThread;
        for (int i = 0; i < 11; i++) {
            input1 = Utility.getRandomIntArray(arraySize[i]);
            //input1 = Utility.getAlphaNumericString(arraySize[i]);
            //input1 = Utility.getAlphaNumericString(arraySize[i]);
            input1Clone = input1.clone();
            mergeSortSingleThread = new MergeSortSingleThread(input1);
            mergeSortSingleThread.sort();
            System.out.println("Is the input sorted: " + Utility.isSorted(input1));
            System.out.println("Execution time for Merge sort with one thread: " + mergeSortSingleThread.getExecutionTime());

            mergeSortMultiThread = new MergeSortMultiThread(input1Clone);
            mergeSortMultiThread.sort();
            System.out.println("Is the input sorted: " + Utility.isSorted(input1Clone));
            System.out.println("Execution time for Merge sort with multi thread: " + mergeSortMultiThread.getExecutionTime());
        }

    }
}