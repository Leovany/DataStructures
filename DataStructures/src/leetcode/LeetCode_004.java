package leetcode;

import java.util.HashSet;

/**
 * 4. 寻找两个正序数组的中位数
 */
public class LeetCode_004 {

    public static void main(String[] args) {
        Solution solution = new Solution();
//        String str = "abcabcbb";
        int[] nums2 = new int[]{1};
        int[] nums1 = new int[]{2, 4,5};
        double num = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println(num);

    }

    static class Solution {

        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int len = nums1.length + nums2.length;
            int left = 0, right = 0;
            int res = -1, newRes = -1;

            int step = (len / 2 + 1);
            for (int i = 0; i < step; i++) {
                res = newRes;
                if (left < nums1.length && (right >= nums2.length || nums1[left] < nums2[right])) {
                    // num1 < num2
                    newRes = nums1[left];
                    left++;
                } else {
                    // >=
                    newRes = nums2[right];
                    right++;
                }
            }
            double result = 0.0;
            if (len % 2 == 0) {
                // 偶数
                result = (res + newRes) / 2.0;
            } else {
                result = newRes;
            }
            return result;

        }
    }


}
