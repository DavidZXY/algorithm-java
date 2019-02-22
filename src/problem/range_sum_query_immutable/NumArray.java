package problem.range_sum_query_immutable;

import base.segment_tree.SegmentTree;

public class NumArray {

//    private SegmentTree<Integer> segmentTree;
//
//    public NumArray(int[] nums) {
//        if (nums.length > 0) {
//            Integer[] data = new Integer[nums.length];
//            for (int i = 0; i < nums.length; i++) {
//                data[i] = nums[i];
//            }
//            segmentTree = new SegmentTree<>(data, (a, b) -> a + b);
//        }
//    }
//
//    public int sunRange(int i, int j) {
//        if (segmentTree == null) {
//            throw new IllegalArgumentException("Segment Tree is null");
//        }
//        return segmentTree.query(i, j);
//    }
    private int[] sums;

    public NumArray(int[] nums) {
        sums = new int[nums.length + 1];

        sums[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sums[j - 1] - sums[i];
    }
}
