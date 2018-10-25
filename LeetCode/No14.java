package LeetCode;

/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
Note:

All given inputs are in lowercase letters a-z.
 */

public class No14 {
    public String longestCommonPrefix(String[] strs) {
        String result = "";
        int count = 0;
        char currentLetter;
        int strLength = strs.length;
        if (strLength == 0)
            return "";
        Boolean sameFlag = true;
        while(true) {
            if (strs[0].length() <= count)
                return result;
            currentLetter = strs[0].charAt(count);
            sameFlag = true;
            for (int iter = 1; iter < strs.length; iter++) {
                if (strs[iter].length() <= count)
                    return result;
                if (strs[iter].charAt(count) != currentLetter) {
                    sameFlag = false;
                    break;
                }
            }
            if (sameFlag) {
                count ++;
                result = result + currentLetter;
            }
            else
                break;
        }
        return result;
    }

    public static void main(String[] args) {
        No14 solution = new No14();
        String[] strList = {"abca","abc"};
        System.out.println(solution.longestCommonPrefix(strList));
    }
}
