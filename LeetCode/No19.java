package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No19 {
    // 13ms beats 27.33%
    public ListNode removeNthFromEnd_1(ListNode head, int n) {
        List<ListNode> nodeList = new ArrayList<>();
        ListNode currentNode = head;
        while(currentNode != null) {
            nodeList.add(currentNode);
            currentNode = currentNode.next;
        }

        if (n == nodeList.size()) {
            if (nodeList.size() == 1)
                return null;
            return nodeList.get(1);
        }

        if (n == 1) {
            nodeList.get(nodeList.size() - 2).next = null;
            return head;
        }

        nodeList.get(nodeList.size()-n-1).next = nodeList.get(nodeList.size() - n).next;

        return head;
    }
    public ListNode removeNthFromEnd_2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy;
        ListNode slow = dummy;
        for (int i = 0; i <= n +1; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currentNode = dummy;
        ListNode previousNode = dummy;

        while (currentNode != null) {

        }
        return dummy.next;
    }

    public static void main(String[] args) {
        No19 solution = new No19();

    }
}
