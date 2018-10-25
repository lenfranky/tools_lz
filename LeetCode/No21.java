package LeetCode;

/*
currentNode = currentNode.next
currentNode = new ListNode(num)
这种用法是不可以的，因为一开始的时候currentNode = currenNode.next时next是null的，
此时相当于cuurentNode与之前的currentNode都指向了null，而不是指向了同一个对象的空间
 */
public class No21 {
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else {
            ListNode resultList;

            if (l1.val > l2.val) {
                resultList = new ListNode(l2.val);
                l2 = l2.next;
            }
            else {
                resultList = new ListNode(l1.val);
                l1 = l1.next;
            }

            ListNode CurrentNode = resultList;

            while (true) {
                if (l1 == null) {
                    CurrentNode.next = l2;
                    break;
                }
                else if (l2 == null) {
                    CurrentNode.next = l1;
                    break;
                }
                else {
                    if (l1.val > l2.val) {
                        CurrentNode.next = new ListNode(l2.val);
                        l2 = l2.next;
                    }
                    else {
                        CurrentNode.next = new ListNode(l1.val);
                        l1 = l1.next;
                    }
                }
                CurrentNode = CurrentNode.next;
            }
            return resultList;
        }
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        ListNode resultList = new ListNode(0);
        ListNode currentNode = resultList;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            }
            else {
                currentNode.next = l2;
                l2 = l2.next;
            }
            currentNode = currentNode.next;
        }
        if (l1 == null) {
            currentNode.next = l2;
        }
        else {
            currentNode.next = l1;
        }


        return resultList.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = mergeTwoLists2(l1, l2);

        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
