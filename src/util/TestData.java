package util;

import java.util.Random;
import java.util.concurrent.Callable;

public class TestData {

    public static int[] randomArrayWithoutRepeatition(int min, int max, int n) {
        int len = max - min + 1;
        if (max < min || n > len || n < 0) {
            return null;
        }

        //初始化给定范围的待选数组
        int[] source = new int[len];
        for (int i = min; i < min + len; i++) {
            source[i - min] = i;
        }

        int[] result = new int[n];
        Random rd = new Random();
        int index = 0;
        for (int i = 0; i < result.length; i++) {
            //待选数组0到(len-2)随机一个下标
            index = Math.abs(rd.nextInt() % len--);
            //将随机到的数放入结果集
            result[i] = source[index];
            //将待选数组中被随机到的数，用待选数组(len-1)下标对应的数替换
            source[index] = source[len];
        }
        return result;
    }

    public static int[] randomArray(int min, int max, int n) {
        if (max < min) {
            return null;
        }

        int[] result = new int[n];
        for (int i = 0; i < result.length; i++) {
            result[i] = (int) (Math.random() * (max - min)) + min;
        }
        return result;
    }

    public static int[] almostOrderedArray(int min, int max, int n) {
        int len = max - min + 1;
        if (max < min || n > len || n < 0) {
            return null;
        }

        int[] result = new int[n];
        Random random = new Random();
        int c = min;
        for (int i = 0; i < n; i++, c++) {
            result[i] = random.nextInt(3) + c;
        }
        return result;
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] data, boolean descending) {
        if (!descending) {
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) > 0) {
                    return false;
                }
            }

            return true;
        } else {
            for (int i = 0; i < data.length - 1; i++) {
                if (data[i].compareTo(data[i + 1]) < 0) {
                    return false;
                }
            }

            return true;
        }
    }

    public static <T extends Comparable<T>> boolean isSorted(T[] data) {
        return isSorted(data, false) || isSorted(data, true);
    }

    public static <T extends Comparable<T>> void printArray(T[] data) {
        System.out.println();
        for (int i = 0; i < data.length; i++) {
            System.out.printf(data[i] + " ");
        }
        System.out.println();
    }

    public static void showRunTime(Callable<Void> sortMethod) {
        long start = System.nanoTime();
        try {
            sortMethod.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        long end = System.nanoTime();

        System.out.println();
        System.out.println(end - start);
    }
}
