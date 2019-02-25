package sort;

import util.TestData;

import java.util.concurrent.Callable;

import static util.TestData.*;

public class Sort {

    public static <T extends Comparable<T>> void selectionSort(T[] data) {

        if (data == null || data.length == 0) {
            return;
        }

        for (int i = 0; i < data.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            T temp = data[minIndex];
            data[minIndex] = data[i];
            data[i] = temp;
        }

    }

    public static <T extends Comparable<T>> void insertSort(T[] data) {

        if (data == null || data.length == 0) {
            return;
        }

        for (int i = 1; i < data.length; i++) {

            T temp = data[i];
            int j = i;
            for (; j > 0; j--) {
                if (data[j].compareTo(data[j - 1]) < 0) {
                    data[j] = data[j - 1];
                } else {
                    break;
                }
            }
            data[j] = temp;
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] data) {

        if (data == null || data.length == 0) {
            return;
        }


    }

    public static void main(String[] args) {
        int[] aa = randomArrayWithoutRepeatition(0,100,100);
        Integer[] a = new Integer[aa.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = aa[i];
        }

        TestData.printArray(a);

        TestData.showRunTime(() -> {
            insertSort(a);
            return null;
        });

        System.out.println(TestData.isSorted(a));
        TestData.printArray(a);

        System.out.println("------------------------------------------------------");

        int[] bb = randomArray(0,100,100);
        Integer[] b = new Integer[bb.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = bb[i];
        }

        TestData.printArray(b);

        TestData.showRunTime(() -> {
            insertSort(b);
            return null;
        });

        System.out.println(TestData.isSorted(b));
        TestData.printArray(b);

        System.out.println("------------------------------------------------------");


        int[] cc = almostOrderedArray(0,100,100);
        Integer[] c = new Integer[cc.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = cc[i];
        }

        TestData.printArray(c);

        TestData.showRunTime(() -> {
            insertSort(c);
            return null;
        });

        System.out.println(TestData.isSorted(b));
        TestData.printArray(b);

        System.out.println("------------------------------------------------------");


    }
}
