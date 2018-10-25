package LeetCode;

/*
You are given two non-empty linked lists representing two non-negative longegers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
 */

/*
[5]
[5]

[9]
[1,9,9,9,9,9,9,9,9,9]

[2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9]
[5,6,4,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,2,4,3,9,9,9,9]
 */

public class No2 {
    public ListNode addTwoNumbersOld(ListNode l1, ListNode l2) {
        long iterCount = 0;
        long num1 = 0, num2 = 0;
        while (l1 != null) {
            num1 += l1.val * Math.pow(10, iterCount);
            l1 = l1.next;
            iterCount ++;
        }
        iterCount = 0;
        while (l2 != null) {
            num2 += l2.val * Math.pow(10, iterCount);
            l2 = l2.next;
            iterCount ++;
        }

        if (iterCount == 0) {
            return new ListNode(0);
        }

        long resultNum = num1 + num2;

        if (resultNum == 0)
            return new ListNode(0);

        ListNode resultList = new ListNode(0);
        ListNode currentNode = resultList;
       while (resultNum > 9) {
            currentNode.next = new ListNode((int)(resultNum % 10));
            resultNum /= 10;
            currentNode = currentNode.next;
        }
        currentNode.next = new ListNode((int)resultNum);
        return resultList.next;
    }


    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int currentNum;
        int addNum = 0;

        ListNode resultList = new ListNode(0);
        ListNode currentNode = resultList;

        while (l1 != null && l2 != null) {
            currentNum = l1.val + l2.val + addNum;
            if (currentNum > 9) {
                currentNum %= 10;
                addNum = 1;
            }
            else {
                addNum = 0;
            }

            currentNode.next = new ListNode(currentNum);
            currentNode = currentNode.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode restList = l1 == null ? l2 : l1;

        while (restList != null) {
            currentNum = restList.val + addNum;
            if (currentNum > 9) {
                currentNum %= 10;
                addNum = 1;
            }
            else {
                addNum = 0;
            }
            currentNode.next = new ListNode(currentNum);
            currentNode = currentNode.next;
            restList = restList.next;
        }

        if (addNum == 1) {
            currentNode.next = new ListNode(addNum);
        }

        return resultList.next;
    }

    public static void main(String[] args) {
        No2 solution = new No2();

        int[] l1num = {9};
        int[] l2num = {1,9,9,9,9,9,9,9,9,9};

        ListNode l1 = new ListNode(l1num[0]);
        ListNode currentNode = l1;
        for(int iterNum = 1; iterNum < l1num.length; iterNum++) {
            currentNode.next = new ListNode(l1num[iterNum]);
            currentNode = currentNode.next;
        }

        ListNode l2 = new ListNode(l2num[0]);
        currentNode = l2;
        for(int iterNum = 1; iterNum < l2num.length; iterNum++) {
            currentNode.next = new ListNode(l2num[iterNum]);
            currentNode = currentNode.next;
        }

        ListNode l3 = solution.addTwoNumbers(l1, l2);

        while (l3 != null) {
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
