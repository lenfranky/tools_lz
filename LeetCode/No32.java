package LeetCode;

import java.util.Stack;

public class No32 {
    public int longestValidParentheses(String s) {
        int currentLength = 0;
        int maxLength = 0;
        int stackLength = 0;

        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == '(') {
                stackLength ++;
            }
            else {
                if (stackLength != 0) {
                    currentLength ++;
                    stackLength --;
                        if (currentLength > maxLength) {
                            maxLength = currentLength;
                        }
                }
                else {
                    currentLength = 0;
                }
            }
        }

        return maxLength * 2;
    }

    // stack中最后剩下的数字相当于未成功配对的括号的index
    int longestValidParentheses_2(String s) {
        int n = s.length(), longest = 0;
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') st.push(i);
            else {
                if (!st.empty()) {
                    if (s.charAt(st.peek()) == '(') st.pop();
                    else st.push(i);
                }
                else st.push(i);
            }
        }
        if (st.empty()) longest = n;
        else {
            int a = n, b = 0;
            while (!st.empty()) {
                b = st.peek(); st.pop();
                longest = Math.max(longest, a-b-1);
                a = b;
            }
            longest = Math.max(longest, a);
        }
        return longest;
    }

    public static void main(String args[]) {
        No32 solution = new No32();
        String s = "())()(()(";
        System.out.println(solution.longestValidParentheses_2(s));
    }
}
