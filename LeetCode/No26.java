package LeetCode;

/*
26. Remove Duplicates from Sorted Array
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
 */
public class No26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;
        int lastNum = nums[0];
        int [] duplicateIndex = new int[nums.length];
        int duplicateNum = 0;
        for (int iterNum = 1; iterNum < nums.length; iterNum ++) {
            if (nums[iterNum] == lastNum) {
                duplicateIndex[duplicateNum] = iterNum;
                duplicateNum ++;
            }
            lastNum = nums[iterNum];
        }

        if (duplicateNum == 0)
            return nums.length;

        for (int i = 0; i < duplicateNum - 1; i++) {
            for (int j = duplicateIndex[i]; j < duplicateIndex[i + 1]; j ++) {
                nums[j - i] = nums[j + 1];
            }
        }
        for (int i = duplicateIndex[duplicateNum - 1]; i < nums.length - 1; i ++) {
            nums[i - duplicateNum + 1] = nums[i + 1];
        }


        return nums.length - duplicateNum;
    }

    public static void main(String[] args) {
        No26 solution = new No26();
        int[] nums = {1};
        for (int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i]);
        }
        int result = solution.removeDuplicates(nums);
        System.out.println();
        System.out.println(result);
        for (int i = 0; i < nums.length; i ++) {
            System.out.print(nums[i]);
        }
    }
}
