package LeetCode;

/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string s, int numRows);
Example 1:

Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
Example 2:

Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
 */
public class No6 {
    public static void main(String[] args) {
        No6 solution = new No6();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        int count = 0;
        int stringLength = s.length();
        boolean cycleFlag = true;
        char[] resultChar = new char[s.length()];
        int cycleCount = 0;

        if (numRows == 1) {
            return s;
        }

        int gap = numRows + (numRows - 2);

        while (cycleFlag) {
            for (int iterNum = 0; iterNum < numRows; iterNum ++) {


                count += 1;
                if (count >= stringLength) {
                    cycleFlag = false;
                    break;
                }
            }

            if (!cycleFlag) {
                break;
            }

            for (int iterNum = 0; iterNum < numRows - 2; iterNum ++) {


                count += 1;
                if (count >= stringLength) {
                    cycleFlag = false;
                    break;
                }
            }
            cycleCount += 1;
        }

        return new String(resultChar);
    }
}
