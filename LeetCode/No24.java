package LeetCode;

public class No24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currentNode = dummy;
        ListNode tempNode = new ListNode(0);
        while (currentNode.next != null && currentNode.next.next != null) {
            tempNode = currentNode.next;
            currentNode.next = tempNode.next;
            tempNode.next = currentNode.next.next;
            currentNode.next.next = tempNode;
            currentNode = tempNode;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        No24 solution = new No24();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(3);
        list1.next.next.next = new ListNode(4);
        solution.swapPairs(list1);
    }
}
