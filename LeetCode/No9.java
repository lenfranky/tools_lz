package LeetCode;

/*
Determine whether an integer is a palindrome. An integer is a palindrome when it
reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes
121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 */

// 另一种思路是找到其反转数，然后判断反转数和它本身是否相同

public class No9 {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        String str = String.valueOf(x);
        // System.out.println(str);

        int i = 0;
        int j = str.length() - 1;

        while(i <= j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i ++;
            j --;
        }

        return true;
    }

    public static void main(String [] args) {
        No9 solution = new No9();
        System.out.println(solution.isPalindrome(-123454321));
    }
}
