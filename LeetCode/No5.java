package LeetCode;

/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
 */

/*
思路1：
依次检测字符串中的每个字符，看它是否满足以下两个规则：
1）它本身和之前的字符相同
2）它两侧的字符相同

 */

public class No5 {
    public static void main(String[] args) {
        No5 solution = new No5();
        System.out.println(solution.longestPalindrome3("babad"));
    }

    public String longestPalindrome(String s) {
        char[] stringChars = s.toCharArray();

        int maxLPalindromicLen = 0;
        int maxLPalindromicCenter = 0;
        int maxLPalindromicFlag = 0;
        int currentPalindromicLen;
        int currentRange;
        int currentLPalindromicFlag = 0;


        for (int iterNum = 0; iterNum < stringChars.length; iterNum ++) {

            if (iterNum != stringChars.length -1) {
                currentPalindromicLen = 0;
                currentRange = 1;
                if (stringChars[iterNum] == stringChars[iterNum+1]) {
                    currentPalindromicLen += 2;
                    while (iterNum - currentRange >= 0 && iterNum + 1 + currentRange < stringChars.length) {
                        if (stringChars[iterNum - currentRange] == stringChars[iterNum + 1 + currentRange]) {
                            currentPalindromicLen += 2;
                        }
                        else
                            break;
                        currentRange += 1;
                    }
                }

                if (currentPalindromicLen > maxLPalindromicLen) {
                    maxLPalindromicLen = currentPalindromicLen;
                    maxLPalindromicCenter = iterNum;
                    maxLPalindromicFlag = 1;
                }

                currentPalindromicLen = 0;
                currentRange = 1;
                if (iterNum - currentRange >= 0 && iterNum + currentRange < stringChars.length) {
                    currentPalindromicLen += 1;
                    while (iterNum - currentRange >= 0 && iterNum + currentRange < stringChars.length) {
                        if (stringChars[iterNum - currentRange] == stringChars[iterNum + currentRange]) {
                            currentPalindromicLen += 2;
                        }
                        else
                            break;
                        currentRange += 1;
                    }
                }

                if (currentPalindromicLen > maxLPalindromicLen) {
                    maxLPalindromicLen = currentPalindromicLen;
                    maxLPalindromicCenter = iterNum;
                    maxLPalindromicFlag = 2;
                }
            }
        }

        if (maxLPalindromicLen > 0) {
            if (maxLPalindromicFlag == 1) {
                return s.substring(maxLPalindromicCenter - maxLPalindromicLen/2 + 1, maxLPalindromicCenter + maxLPalindromicLen/2 + 1);
            }
            else {
                return s.substring(maxLPalindromicCenter - maxLPalindromicLen/2, maxLPalindromicCenter + maxLPalindromicLen/2 + 1);
            }
        }

        else {
            if (s.length() > 0) {
                return s.substring(s.length() - 1, s.length());
            }
            else {
                return "";
            }
        }
    }

    private int lo, maxLen;
    public String longestPalindrome2(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }

    private int startIndex, length;
    public String longestPalindrome3(String s) {
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            i = manacher(sc, i);
        }
        return s.substring(startIndex, startIndex + length);
    }

    /*
    先检查完全相同的字符串
     */
    private int manacher(char[] sc, int center) {
        int start = center - 1, end = center;
        while (end < sc.length - 1 && sc[end] == sc[end + 1]) {
            end++;
        }

        int newCenter = end++;
        while (start >= 0 && end < sc.length && sc[start] == sc[end]) {
            start--;
            end++;
        }

        if (end - start - 1 > length) {
            length = end - start - 1;
            startIndex = start + 1;
        }
        return newCenter;
    }
}
