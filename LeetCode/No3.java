package LeetCode;

/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

/*
"dvdf"
 */

import java.util.ArrayList;

public class No3 {
    public int lengthOfLongestSubstringOld(String s) {
        int startIndex = 0, endIndex = 0, currentStartIndex = 0, currentEndIndex = 0;
        int subLength = 0, currentSubLength = 0;
        char lastChar =' ';


        for (int iterNum = 0; iterNum < s.length(); iterNum ++) {
            if (s.charAt(iterNum) == lastChar) {
                currentSubLength = 1;
                currentStartIndex = iterNum;
                currentEndIndex = iterNum;
            }
            else {
                currentSubLength ++;
                currentEndIndex = iterNum;
            }
            if (currentSubLength > subLength) {
                startIndex = currentStartIndex;
                endIndex = currentEndIndex;
                subLength = currentSubLength;
            }
            lastChar = s.charAt(iterNum);
        }
        return subLength;
    }

    public int lengthOfLongestSubstringold2(String s) {
        int result = 0;
        ArrayList<Character> uniqueCharList = new ArrayList<>();

        for (int iterNum = 0; iterNum < s.length(); iterNum ++) {
            if (uniqueCharList.indexOf(s.charAt(iterNum)) == -1) {
                uniqueCharList.add(s.charAt(iterNum));
            }
        }

        return uniqueCharList.size();
    }

    public int lengthOfLongestSubstring(String s) {
        int subLength = 0;
        char currentChar;
        ArrayList<Character> uniqueCharList = new ArrayList<>();


        for (int iterNum = 0; iterNum < s.length(); iterNum ++) {
            currentChar = s.charAt(iterNum);
            if (uniqueCharList.contains(currentChar)) {
                for(int j = uniqueCharList.indexOf(currentChar); j >= 0; j --) {
                    uniqueCharList.remove(j);
                }
            }

            uniqueCharList.add(currentChar);

            if (uniqueCharList.size() > subLength) {
                subLength = uniqueCharList.size();
            }
        }
        return subLength;
    }

    public static void main(String[] args) {
        No3 solution = new No3();
        System.out.println(solution.lengthOfLongestSubstring("apwwkew"));
    }
}
