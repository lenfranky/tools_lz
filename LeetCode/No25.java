package LeetCode;

public class No25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tmp = head;
        int length = 0;
        while(tmp != null) {
            length++;
            tmp = tmp.next;
        }
        return reverse(head, k, length);
    }
    public ListNode reverse(ListNode head, int k, int length) {
        if(length < k) return head;
        ListNode tmp = head;
        ListNode next = null;
        ListNode first = head;
        ListNode last = null;
        for(int i = 0; i < k - 1 ; i++) {
            tmp = tmp.next;
        }
        last = tmp;
        next = reverse(tmp.next, k, length - k);
        for(int i = 0; i < k - 1; i++) {
            tmp = first.next;
            first.next = next;
            last.next = first;
            next = first;
            first = tmp;
        }

        return last;
    }
}
