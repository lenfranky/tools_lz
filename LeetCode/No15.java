package LeetCode;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class No15 {
    public List<List<Integer>> threeSum_demo(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new LinkedList<>();
        for (int i = 0; i < num.length-2; i++) {
            if (i == 0 || (num[i] != num[i-1])) {
                int lo = i+1, hi = num.length-1, sum = 0 - num[i];
                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        res.add(Arrays.asList(num[i], num[lo], num[hi]));
                        while (lo < hi && num[lo] == num[lo+1]) lo++;
                        while (lo < hi && num[hi] == num[hi-1]) hi--;
                        lo++; hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;
                    else hi--;
                }
            }
        }
        return res;
    }

    public List<List<Integer>> threeSum_1(int[] nums) {
        ArrayList combinationList = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length-1; j ++) {
                for (int k = i + 2; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0 ) {
                        ArrayList tempList = new ArrayList<Integer>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[k]);
                        combinationList.add(tempList);
                        // System.out.println(nums[i] + " " + nums[j] + " " + nums[k]);
                    }
                }
            }
        }
        System.out.println(combinationList.getClass().getName());


//        for(int i = 0; i < combinationList.size(); i++) {
////            System.out.println(combinationList.get(i).getClass());
////            System.out.println(combinationList.get(i));
////            // ArrayList comb = combinationList.get(i);
////        }

        List resultList = new ArrayList<ArrayList<Integer>>();
        return combinationList;
    }



    public List<List<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i < num.length-2; i++) {
            if ((i > 0) && (num[i] == num[i-1]))
                continue;
            int lowIndex = i + 1;
            int highIndex = num.length - 1;
            int sum = 0 - num[i];

            while(lowIndex < highIndex) {
                if (num[lowIndex] + num[highIndex] == sum) {
                    res.add(Arrays.asList(num[i], num[lowIndex], num[highIndex]));

                    // 前一个条件作用为保证第二次判断时两个索引仍处于可取范围内
                    while(lowIndex < highIndex && num[lowIndex] == num[lowIndex + 1])
                        lowIndex ++;
                    while(highIndex > lowIndex && num[highIndex] == num[highIndex-1])
                        highIndex --;
                    lowIndex ++;
                    highIndex --;
                }
                else if (num[lowIndex] + num[highIndex] < sum)
                    lowIndex ++;
                else if (num[lowIndex] + num[highIndex] > sum)
                    highIndex --;
            }
        }
        return res;
    }

    public static void main(String[] args){
        No15 solution = new No15();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(solution.threeSum(nums));
    }
}
