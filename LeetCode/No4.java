package LeetCode;

/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]

The median is (2 + 3)/2 = 2.5
 */

public class No4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length == 1 && nums2.length == 0) {
            return nums1[0];
        }
        if (nums1.length == 0 && nums2.length == 1) {
            return nums1[1];
        }
        if (nums1.length == 1 && nums2.length == 1) {
            double result = (double) (nums1[0] + nums2[1]);
            result /= 2;
            return result;
        }

        int length1 = nums1.length;
        int length2 = nums2.length;


        return 0;
    }

}
