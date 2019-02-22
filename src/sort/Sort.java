package sort;

import static util.TestData.randomArray2;

public class Sort {

    public static <T extends Comparable<T>> void selectionSort(T[] data) {

        if (data == null || data.length == 0) {
            return;
        }

        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[j].compareTo(data[i]) < 0) {
                    T temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] aa = randomArray2(0,100,100);
        Integer[] a = new Integer[aa.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = aa[i];
        }

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        selectionSort(a);
        System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(a.length);
    }
}
