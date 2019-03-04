package problem.top_k_frequent_elements;

import java.util.*;

public class TopKFrequent {

    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq o) {
            if (this.freq > o.freq) {
                return 1;
            }
            else if (this.freq < o.freq) {
                return -1;
            }
            else {
                return 0;
            }
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            }
            else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : map.keySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(key, map.get(key)));
            }
            else if (map.get(key) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(key, map.get(key)));
            }
        }

        LinkedList<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }
        return res;
    }


    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length)
            return list;
        findKValue(input, 0, input.length - 1, k);
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    private void findKValue(int[] data, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int p = partition(data, l, r);
        if (p == k) {
            return;
        }
        else if (p > k) {
            findKValue(data, l, p - 1, k);
        }
        else {
            findKValue(data, p + 1, r, k);
        }
    }

    private int partition(int[] data, int l, int r) {
        swap(data, l, (int)(Math.random() * (r - l + 1))+ l);
        int v = data[l];
        int i = l + 1;
        int j = l;
        for (;i <= r; i++) {
            if (data[i] < v) {
                swap(data, j + 1, i);
                j++;
            }
        }
        swap(data, j, l);
        return j;
    }

    private void swap(int[] data, int a, int b) {
        int temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }
}
