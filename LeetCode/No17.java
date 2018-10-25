package LeetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class No17 {
    public List<String> letterCombinations(String digits) {
        int[] nums = new int[digits.length()];
        for (int i=0; i<digits.length(); i ++) {
            nums[i] = digits.charAt(i) - '0';
        }

        Map<Integer, String[]> numLetterMap = new HashMap<>();
        numLetterMap.put(2, new String[] {"a", "b", "c"});
        numLetterMap.put(3, new String[] {"d", "e", "f"});
        numLetterMap.put(4, new String[] {"g", "h", "i"});
        numLetterMap.put(5, new String[] {"j", "k", "l"});
        numLetterMap.put(6, new String[] {"m", "n", "o"});
        numLetterMap.put(7, new String[] {"p", "q", "r", "s"});
        numLetterMap.put(8, new String[] {"t", "u", "v"});
        numLetterMap.put(9, new String[] {"w", "x", "y", "z"});

        List<String> res = new ArrayList<>();

        for (int num: nums) {
            addSingleLetter(num, numLetterMap, res);
        }
        return res;
    }

    private void addSingleLetter(int num, Map<Integer, String[]> numLetterMap,List<String> res){
        if (res.size() == 0) {
            res.add("");
        }
        List<String> originalRes = new ArrayList<>(res);
        res.clear();
        for (String currentLetter: numLetterMap.get(num)){
            for (String currentString: originalRes) {
                res.add(currentString + currentLetter);
            }
        }
    }

    public static void main(String[] args) {
        No17 solution = new No17();

        String digits = "2345";
        solution.letterCombinations(digits);
        System.out.println(solution.letterCombinations(digits));
    }
}
