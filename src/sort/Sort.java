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

        insertSort(data, 0, data.length - 1);
    }

    public static <T extends Comparable<T>> void insertSort(T[] data, int l, int r) {
        if (data == null || data.length == 0 || r <= l || r < 0 || l < 0) {
            return;
        }

        for (int i = l + 1; i <= r; i++) {
            T temp = data[i];
            int j = i;
            for (; j > l; j--) {
                if (temp.compareTo(data[j - 1]) < 0) {
                    data[j] = data[j - 1];
                } else {
                    break;
                }
            }
            data[j] = temp;
        }
    }

    public static void countingSort(int[] data, int min, int max) {
        if (data == null || data.length == 0) {
            return;
        }
        int[] temp = new int[max - min + 1];
        int[] res = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            temp[data[i]] += 1;
        }
        for (int i = 1; i < temp.length; i++) {
            temp[i] = temp[i] + temp[i - 1];
        }
        for (int i = data.length - 1; i >= 0; i--) {
            int a = data[i];
            res[temp[a] - 1] = a;
            temp[a]--;
        }
    }

    public static <T extends Comparable<T>> void quickSort(T[] data) {

        if (data == null || data.length == 0) {
            return;
        }

        quickSort(data, 0, data.length - 1);

    }

    private static <T extends Comparable<T>> int partition(T[] data, int l, int r) {
        swap(data, (int)(Math.random() * (r - l) + 1) + l, l);
        T v = data[l];
        int i = l + 1;
        int j = l;
        for (; i <= r; i++) {
            if (data[i].compareTo(v) < 0) {
                swap(data, i, j + 1);
                j++;
            }
        }

        swap(data, l, j);
        return j;
    }

    private static <T extends Comparable<T>> void quickSort(T[] data, int l, int r) {
        if (r - l <= 7) {
            insertSort(data, l, r);
            return;
        }

        int p = partition(data, l, r);
        quickSort(data, l, p - 1);
        quickSort(data, p + 1, r);
    }

    public static <T extends Comparable<T>> void quickSort3Ways(T[] data) {
        if (data == null || data.length == 0) {
            return;
        }

        quickSort3Ways(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void quickSort3Ways(T[] data, int l, int r) {
        if (r - l <= 7) {
            insertSort(data, l, r);
            return;
        }

        swap(data, l, (int)(Math.random() * (r - l + 1) + l));
        T v = data[l];
        int lt = l;
        int gt = r + 1;
        int i = l + 1;

        while (i < gt) {
            if (data[i].compareTo(v) < 0) {
                swap(data, lt + 1, i);
                lt++;
                i++;
            }
            else if (data[i].compareTo(v) > 0) {
                swap(data, gt - 1, i);
                gt--;
            }
            else {
                i++;
            }
        }
        swap(data, l, lt);
        lt--;
        quickSort3Ways(data, l, lt);
        quickSort3Ways(data, gt, r);
    }

    public static <T extends Comparable<T>> void swap(T[] data, int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static <T extends Comparable<T>> void mergeSort(T[] data) {
        mergeSort(data, 0, data.length - 1);
    }

    private static <T extends Comparable<T>> void mergeSort(T[] data, int l, int r) {
        if (r - l <= 7) {
            insertSort(data, l, r);
            return;
        }

        int mid = l + (r - l) / 2;
        mergeSort(data, l, mid);
        mergeSort(data, mid + 1, r);
        if (data[mid].compareTo(data[mid + 1]) <= 0) {
            return;
        }
        T[] temp = (T[])new Comparable[r - l + 1];
        for (int i = l; i <= r; i++) {
            temp[i - l]= data[i];
        }
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                data[k] = temp[j - l];
                j++;
            } else if (j > r) {
                data[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                data[k] = temp[i - l];
                i++;
            } else {
                data[k] = temp[j - l];
                j++;
            }
        }
    }

    public static <T extends Comparable<T>> void mergeSortBU(T[] data) {
        int n = data.length;
        for (int i = 1; i <= n; i += i) {
            for (int j = 0; j + i < n; j += i + i) {

            }
        }
    }

    private static <T extends Comparable<T>> void merge(T[] data) {

    }


    public static void main(String[] args) {

        int[] aa = randomArrayWithoutRepetition(0,10000,10000);
        Integer[] a = new Integer[aa.length];
        for (int i = 0; i < a.length; i++) {
            a[i] = aa[i];
        }

        TestData.printArray(a);
        TestData.showRunTime(() -> {
            mergeSort(a);
            return null;
        });
        System.out.println(TestData.isSorted(a));
        TestData.printArray(a);

        System.out.println("------------------------------------------------------");

        int[] bb = randomArrayWithoutRepetition(0,10000,10000);
        Integer[] b = new Integer[bb.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = bb[i];
        }

        TestData.printArray(b);
        TestData.showRunTime(() -> {
            quickSort3Ways(b);
            return null;
        });
        System.out.println(TestData.isSorted(b));
        TestData.printArray(b);

        System.out.println("------------------------------------------------------");

        int[] cc = almostOrderedArray(0,10000,10000);
        Integer[] c = new Integer[cc.length];
        for (int i = 0; i < c.length; i++) {
            c[i] = cc[i];
        }

        TestData.printArray(c);
        TestData.showRunTime(() -> {
            quickSort3Ways(c);
            return null;
        });
        System.out.println(TestData.isSorted(c));
        TestData.printArray(c);

        System.out.println("------------------------------------------------------");

        int[] dd = randomRepetitionArray(10000, 4);
        Integer[] d = new Integer[dd.length];
        for (int i = 0; i < d.length; i++) {
            d[i] = dd[i];
        }

        TestData.printArray(d);
        TestData.showRunTime(() -> {
            quickSort(d);
            return null;
        });

        System.out.println(TestData.isSorted(d));
        TestData.printArray(d);
    }
}
