package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length-3; i ++){
            if (i > 0 && nums[i] == nums[i-1])
                continue;
            for (int j = i+1; j < nums.length-2; j ++) {
                if (j > i+1 && nums[j] == nums[j - 1])
                    continue;
                int targetSum = target - nums[i] - nums[j];
                int lowIndex = j + 1;
                int highIndex = nums.length - 1;

                while(lowIndex < highIndex) {
                    int currentSum = nums[lowIndex] + nums[highIndex];
                    if (currentSum == targetSum) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[lowIndex], nums[highIndex]));
                        while(lowIndex < highIndex && nums[lowIndex] == nums[lowIndex+1])
                            lowIndex ++;
                        while(lowIndex < highIndex && nums[highIndex] == nums[highIndex-1])
                            highIndex --;
                        lowIndex ++;
                        highIndex --;
                    }
                    else if (currentSum < targetSum)
                        lowIndex ++;
                    else
                        highIndex --;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        No18 solution = new No18();
        int target = 0;
        int[] nums = {0,0,0,0};
        solution.fourSum(nums, target);
        System.out.println(solution.fourSum(nums, target));
    }
}
