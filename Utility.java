package main.java.service.utility;

public class Utility {

    public int partition(Comparable array[], int low, int high) {
        Comparable pivot = array[high];
        int i = (low - 1);

        for (int j = low; j <= high - 1; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return (i + 1);
    }

    public static void swap(Comparable array[], int p, int r) {
        Comparable t = array[p];
        array[p] = array[r];
        array[r] = t;
    }

    public void selectionSort(Comparable arr[]) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++)
                if (arr[j].compareTo(arr[min_idx]) < 0)
                    min_idx = j;
            Comparable temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }

    public static boolean isSorted(Comparable a[]) {
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i].compareTo(a[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public static void printComparableArray(Comparable a[]) {
        for (Comparable comparable : a) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }


    public static Comparable[] getRandomIntArray(int length) {
        Comparable a[] = new Comparable[length];
        for (int i = 0; i < length; i++) {
            a[i] = (int) Math.floor(Math.random() * length * 5);
        }
        return a;
    }

    public static String[] getAlphaNumericString(int length) {
        String[] s = new String[length];
        for (int i = 0; i < length; i++) {
            s[i] = getRandomString();
        }
        return s;
    }

    public static String getRandomString() {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(5);
        for (int j = 0; j < 5; j++) {
            int index = (int) (AlphaNumericString.length()
                    * Math.random());
            sb.append(AlphaNumericString.charAt(index));
        }
        return sb.toString();
    }

    public static Student[] getStudentArray(int len) {
        Student[] students = new Student[len];
        int id, marks;
        String name;
        Student s;
        for (int i = 0; i < len; i++) {
            id = (int) Math.floor(Math.random() * 500000);
            marks = (int) Math.floor(Math.random() * 100);
            name = getRandomString();
            s = new Student(id, name, marks);
            students[i] = s;
        }
        return students;
    }

}