package leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 1. 两数相加
 */
public class LeetCode_001_Two_Sum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 11, 7, 15};
        int target = 9;
        Solution solution = new Solution();
        int[] ans = solution.twoSum2(nums, target);
        System.out.println("ans = " + Arrays.toString(ans));
    }

    static class Solution {

        // 解法一：时间复杂度 n平方
        public int[] twoSum(int[] nums, int target) {
            int[] ans = new int[2];
            for (int i = 0; i < nums.length; i++) {
                for (int j = (i + 1); j < nums.length; j++) {
                    if (nums[i] + nums[j] == target) {
                        ans[0] = nums[i];
                        ans[1] = nums[j];
                    }
                }
            }
            return ans;
        }

        // 解法二：时间复杂度 n
        public int[] twoSum2(int[] nums, int target) {
            // <val,index>
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < nums.length; i++) {
                int sub = target - nums[i];
                if (map.containsKey(sub)) {
                    // 存在
                    return new int[]{map.get(sub), i};
                }
                map.put(nums[i], i);
            }
            throw new IllegalArgumentException("No two sum");
        }


    }
}
