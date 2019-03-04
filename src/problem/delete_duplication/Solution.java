package problem.delete_duplication;

import java.util.ArrayList;

public class Solution {

    static class ListNode {

        int val;
        ListNode next = null;
        ListNode(int val) {this.val = val;}
    }

    public static ListNode deleteDuplication(ListNode pHead)
    {
        ListNode node = pHead;
        ArrayList<ListNode> arr = new ArrayList<>();
        ListNode temp = new ListNode(-1);
        temp.next = node;
        arr.add(temp);
        while (node != null) {
            arr.add(node);
            node = node.next;
        }
        int i = arr.size() - 1;
        while (i > 0) {
            if (arr.get(i).val == arr.get(i - 1).val) {
                int a = i;
                while (arr.get(i).val == arr.get(i - 1).val) {
                    i--;
                }
                arr.get(i - 1).next = arr.get(a).next;
            }
            i--;
        }
        return arr.get(0).next;
    }
}
