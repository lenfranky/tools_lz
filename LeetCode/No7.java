package LeetCode;

/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed
integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns
0 when the reversed integer overflows.
 */

// 注意要求的是判断输出是否溢出

/*
class Solution {
    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
 */

class Solution {
    public int reverse(int x) {
        if (x < -Math.pow(2,31) || x > Math.pow(2,31) - 1) {
            return 0;
        }

        long newNum = 0;
        int currentNum = 0;

        while (x != 0) {
            currentNum = x % 10;
            x /= 10;
            newNum *= 10;
            newNum += currentNum;

            if (newNum < -Math.pow(2,31) || newNum > Math.pow(2,31) - 1) {
                return 0;
            }

        }

        return (int)newNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.reverse(1534236469);
        System.out.println(result);

    }
}