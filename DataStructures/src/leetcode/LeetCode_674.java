package leetcode;

/**
 * 674. 最长连续递增序列
 */
public class LeetCode_674 {

    public static void main(String[] args) {


        Solution solution = new Solution();


    }

    static class Solution {
        public int findLengthOfLCIS(int[] nums) {
            if (nums.length <= 1) {
                return nums.length;
            }

            int ans = 1;
            int count = 1;

            for (int i = 0; i < nums.length; i++) {
                if (nums[i + 1] > nums[i]) {
                    count += 1;
                } else {
                    // 不连续，重置
                    count = 1;
                }
                ans = Math.max(ans, count);

            }
            return ans;
        }

    }


}
