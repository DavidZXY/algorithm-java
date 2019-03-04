package problem.print_binary_tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        ArrayList<ArrayList<TreeNode>> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        while (true) {
            ArrayList<TreeNode> temp = new ArrayList<>();
            ArrayList<Integer> tempRes = new ArrayList<>();

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                temp.add(node);
                tempRes.add(node.val);
            }

            if (temp.size() == 0) {
                break;
            }

            list.add(temp);
            res.add(tempRes);

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i).left != null) queue.offer(temp.get(i).left);
                if (temp.get(i).right != null) queue.offer(temp.get(i).right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node1  =  new TreeNode(8);
        TreeNode node2  =  new TreeNode(5);
        TreeNode node3  =  new TreeNode(6);
        TreeNode node4  =  new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        Print(node1);
    }
}
