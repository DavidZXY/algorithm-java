package problem.add_to_array_form_of_integer;

import java.util.*;

public class Solution {
    public static List<Integer> addToArrayForm(int[] A, int K) {
//        LinkedList<Integer> k = new LinkedList<>();
//        String kStr = String.valueOf(K);
//        for (int i = 0; i < kStr.length(); i++) {
//            k.push(Character.getNumericValue(kStr.charAt(i)));
//        }
//        LinkedList<Integer> res = new LinkedList<>();
//        LinkedList<Integer> a = new LinkedList<>();
//        for (int i = 0; i < A.length; i++) {
//            a.push(A[i]);
//        }
//        int highValue = 0;
//        while (k.size() != 0 && a.size() != 0) {
//            int temp = k.pop() + a.pop() + highValue;
//            highValue = temp / 10;
//            res.addFirst(temp % 10);
//        }
//
//        while (a.size() != 0) {
//            int temp = a.pop() + highValue;
//            highValue = temp / 10;
//            res.addFirst(temp % 10);
//        }
//        while (k.size() != 0) {
//            int temp = k.pop() + highValue;
//            highValue = temp / 10;
//            res.addFirst(temp % 10);
//        }
//
//        if (highValue != 0) {
//            res.addFirst(highValue);
//        }
//        return res;
        int n = A.length;
        int c = K;
        for(int i = A.length-1;i >= 0;i--){
            A[i] += c;
            c = A[i] / 10;
            A[i] %= 10;
        }
        List<Integer> ret = new ArrayList<>();
        while(c > 0){
            ret.add(0, c%10);
            c /= 10;
        }
        for(int v : A)ret.add(v);
        return ret;
    }

    public static boolean Find(int target, int [][] array) {
        for (int i = 0; i < array.length; i++) {
            int[] temp = array[i];
            if (Arrays.binarySearch(temp, target) != -1) {
                return true;
            }
        }
        return false;
    }

    public static String replaceSpace(StringBuffer str) {
        String temp = str.toString();
        return temp.replaceAll(" ", "%20");
    }
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        while (listNode != null) {
            list.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < list.size() ; i++) {
            res.add(list.remove(list.size()));
        }
        return res;
    }



    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }


    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        TreeNode root=reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }
    //前序遍历{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}
    private TreeNode reConstructBinaryTree(int[] pre,int startPre,int endPre,int[] in,int startIn,int endIn) {

        if(startPre>endPre||startIn>endIn)
            return null;
        TreeNode root=new TreeNode(pre[startPre]);

        for(int i=startIn;i<=endIn;i++)
            if(in[i]==pre[startPre]){
                root.left=reConstructBinaryTree(pre,startPre+1,startPre+i-startIn,in,startIn,i-1);
                root.right=reConstructBinaryTree(pre,i-startIn+startPre+1,endPre,in,i+1,endIn);
                break;
            }

        return root;
    }

    public static void main(String[] args) {
//        int[] a = {2};
//        int k = 23;
//        System.out.println(addToArrayForm(a,k));
//        int[][] array = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
//        System.out.println(Find(5, array));


    }
}
