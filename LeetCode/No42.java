package LeetCode;

import java.util.Stack;

public class No42 {
    public int trap(int[] height) {
        int res = 0;
        int currentBottom = 0, diffHeight = 0, currentWater = 0;
        Stack<Integer> indexStack = new Stack<>();
        int i = 0;
        while(i < height.length) {
            if (indexStack.isEmpty() || height[i] < height[indexStack.peek()]) {
                indexStack.push(i);
                i ++;
            }
            else {
                currentBottom = indexStack.pop();
                if (indexStack.isEmpty())
                    currentWater = 0;
                else {
                    diffHeight = Math.min(height[i], height[indexStack.peek()]) - height[currentBottom];
                    currentWater = diffHeight * (i - indexStack.peek() - 1);
                }

                res += currentWater;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No42 solution = new No42();
        int[] heights = {5,3,2,1,0,1,4};
        System.out.println(solution.trap(heights));
    }
}
