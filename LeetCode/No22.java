package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class No22 {
    public List<String> generateParenthesis_my(int n) {
        List<String> res = new ArrayList<>();
        iterGenerateParenthesis(res, "", 0, 0, n);
        return res;
    }

    public void iterGenerateParenthesis(List<String> res, String currentString, int start, int end, int n) {
        if (currentString.length() == n *2) {
            res.add(currentString);
            return;
        }
        else if (start < n) {
            iterGenerateParenthesis(res, currentString + "(", start + 1, end, n);
        }
        if (end < start) {
            iterGenerateParenthesis(res, currentString + ")", start, end + 1, n);
        }

    }

    public List<String> generateParenthesis(int n) {

        List<String> result=new ArrayList<String>();

        if(n==0)
            return result;

        char[] str=new char[n*2];
        generateCombination(str,0,0,0,n,result);

        return result;

    }


    public void generateCombination(char[] str,int pos,int open,int close, int n,List<String> result)
    {

        if(close==n)
        {
            result.add(String.valueOf(str));
        }

        if(open>close)
        {
            str[pos]=')';
            generateCombination(str,pos+1,open,close+1,n,result);
        }
        if(open<n)
        {
            str[pos]='(';
            generateCombination(str,pos+1,open+1,close,n,result);
        }

    }

    public static void main(String[] args) {
        No22 solution = new No22();
        System.out.println(solution.generateParenthesis(3));
    }
}
