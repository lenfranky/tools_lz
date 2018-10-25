package LeetCode;

import java.util.Arrays;

public class No16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int length = nums.length;

        int minDiff = Integer.MAX_VALUE;

        for (int i=0; i<length; i++) {
            if ((i > 0) && (nums[i] == nums[i-1]))
                continue;
            int lowIndex = i + 1;
            int highIndex = nums.length - 1;
            int targetSum = target - nums[i];

            while(lowIndex < highIndex) {
                int currentSum = nums[lowIndex] + nums[highIndex];
                if (currentSum == targetSum) {
                    return target;
                }
                else if (currentSum < targetSum){
                    int currentDiff = targetSum - currentSum;
                    if (Math.abs(currentDiff) < Math.abs(minDiff)) {
                        minDiff = currentDiff;
                    }
                    lowIndex ++;
                }
                else if (currentSum > targetSum){
                    int currentDiff = targetSum - currentSum;
                    if (Math.abs(currentDiff) < Math.abs(minDiff)) {
                        minDiff = currentDiff;
                    }
                    highIndex --;
                }
            }
        }
        int res = target - minDiff;
        return res;
    }

    public static void main(String[] args) {
        No16 solution = new No16();
        int target = 1;
        int[] nums = {-1, 2, 1, -4};
        solution.threeSumClosest(nums, target);
        System.out.println(solution.threeSumClosest(nums, target));
    }
}
