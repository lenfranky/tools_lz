package LeetCode;
/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:

Input: "()"
Output: true
Example 2:

Input: "()[]{}"
Output: true
Example 3:

Input: "(]"
Output: false
Example 4:

Input: "([)]"
Output: false
Example 5:

Input: "{[]}"
Output: true

"(([]){})"
true

"{}{}()[]"
true

"[({(())}[()])]"
true
 */

import java.util.HashMap;
import java.util.Stack;

public class No20 {
    public boolean isValid_1(String s) {
        int begin = 0;

        if (s.length() == 0) {
            return true;
        }
        else if (s.length() == 1) {
            return false;
        }
        else {
            int count = 1;
            while(count < s.length()) {
                if (s.charAt(count) == s.charAt(0)) {
                    int count_in = s.length() - 1;
                    while(count_in > count) {
                        if (signMatch(s.charAt(0), s.charAt(count_in))) {
                            if (isValid(s.substring(count, count_in))) {
                                if (count_in < s.length() - 1) {
                                    return isValid(s.substring(count + 1, s.length()))
                                            && isValid(s.substring(1, count));
                                }
                                else
                                    return true;
                            }
                        }
                        count_in --;
                    }
                }
                else {
                    if (signMatch(s.charAt(0), s.charAt(count))) {
                        if (isValid(s.substring(1, count))) {
                            if (count < s.length() - 1) {
                                return isValid(s.substring(count + 1, s.length()));
                            } else
                                return true;
                        } else
                            return false;
                    }
                }
                count ++;
            }
            return false;
        }
    }

    public Boolean signMatch(char ch1, char ch2) {
        if (ch1 == '{') {
            return  (ch2 == '}');
        }
        else if (ch1 == '[') {
            return  (ch2 == ']');
        }
        else if (ch1 == '(') {
            return  (ch2 == ')');
        }
        return false;
    }

    //5ms 98.13%
    public boolean isValid_2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

    //8ms 33.73%
    public boolean isValid_my(String s) {
        Stack<Character> parentheseStack = new Stack<>();
        char[] inputArray = s.toCharArray();
        for(char currentChar: inputArray) {
            if (currentChar == '(')
                parentheseStack.push(')');
            else if (currentChar == '[')
                parentheseStack.push(']');
            else if (currentChar == '{')
                parentheseStack.push('}');
            else {
                if (parentheseStack.empty())
                    return false;
                if (currentChar != parentheseStack.pop())
                    return false;
            }
        }
        if (parentheseStack.empty())
            return true;
        else
            return false;
    }

    //11ms - 13ms
    //将需要反复调用的map写到构造函数里，可以快约2ms
    public boolean isValid_solution(String s) {
        HashMap<Character, Character> mappings;
        mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }

    public boolean isValid(String s) {
        Stack<Character> parentheseStack = new Stack<>();
        char[] inputArray = s.toCharArray();
        for(char currentChar: inputArray) {
            if (currentChar == '(')
                parentheseStack.push(')');
            else if (currentChar == '[')
                parentheseStack.push(']');
            else if (currentChar == '{')
                parentheseStack.push('}');
            else if (parentheseStack.empty() || currentChar != parentheseStack.pop()){
                return false;
            }
        }
        return parentheseStack.empty();
    }


        public static void main(String[] args) {
        No20 solution = new No20();
        System.out.println(solution.isValid("[({(())}[()])]"));
    }
}
