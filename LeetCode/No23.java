package LeetCode;

public class No23 {
    public ListNode mergeKLists_my(ListNode[] lists) {
        ListNode resListHead = new ListNode(0);

        int currentMinValue;
        int nullCount = 0;
        int currentIndex = 0;
        ListNode currentNode = resListHead;
        while(nullCount < lists.length) {
            nullCount = 0;
            currentMinValue = Integer.MAX_VALUE;
            currentIndex = -1;
            int indexCount = 0;
            for (ListNode list: lists) {
                if (list == null) {
                    nullCount ++;
                    indexCount ++;
                    continue;
                }
                if (list.val <= currentMinValue) {
                    currentIndex = indexCount;
                    currentMinValue = list.val;
//                    System.out.println(lists[currentIndex].val);
                }
                indexCount ++;
            }
            if (currentIndex != -1) {
//                System.out.println("list:\t" + currentIndex + "\tval:\t" + currentMinValue);
//                System.out.println(lists[currentIndex].val);
                lists[currentIndex] = lists[currentIndex].next;
                currentNode.next = new ListNode(currentMinValue);
                currentNode = currentNode.next;
            }
        }

        return resListHead.next;
    }

    // //     PriorityQueue Solution, Easy
// //     O(n lgn) time
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode dummy = new ListNode(0), cur = dummy;
//         PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
//         for (ListNode head : lists) {
//             if (head != null) pq.offer(head); //Need to chech null to avoid nested empty lists [[]]
//         }

//         while (!pq.isEmpty()) {
//             ListNode node = pq.poll();
//             cur.next = node; //First time of execution will set the dummy.next = head
//             cur = node;
//             if (node.next != null) pq.offer(node.next);
//         }
//         return dummy.next;
//     }



    //Merge Sort Solution
    //First need to partition lists using binary search with index start and end until start == end
    //Then merge the two left linked list with regular merge()

    public ListNode mergeKLists(ListNode[] lists) {
        return partion(lists, 0, lists.length - 1);
    }

    private ListNode partion(ListNode[] lists, int start, int end) {
        if (start == end) return lists[start];
        if (start < end) {
            int mid = (start + end) / 2;
            ListNode p1 = partion(lists, start, mid);
            ListNode p2 = partion(lists, mid + 1, end);
            return merge(p1, p2);
        }
        return null;
    }

    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            }
            else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        //do not forget to check any remaining lists
        if (l1 != null) cur.next = l1;
        if (l2 != null) cur.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        No23 solution = new No23();
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);

        ListNode[] lists = {list1, list2, list3};

        solution.mergeKLists(lists);

    }
}
