package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串
 */
public class LeetCode_003_Longest_Substring_Without_Repeating_Characters {

    public static void main(String[] args) {
        Solution solution = new Solution();
        String str = "abcabcbb";
        int length = solution.lengthOfLongestSubstring(str);
        System.out.printf("%s 无重复字符的最长子串长度是 = %d \n", str, length);

    }

    static class Solution {

        /**
         * 滑动窗口思路
         * 1. 存在相同元素，左下标 +1
         * 2. 不存在，右下标 + 1
         * 3. 计算窗口大小
         */
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0;
            int maxCount = 0;

            HashSet<Character> windowSet = new HashSet<>();
            while (left < s.length() && right < s.length()) {
                // 判断是否有重复元素，使用 set
                if (windowSet.contains(s.charAt(right))) {
                    // 存在相同元素，左移
                    windowSet.remove(s.charAt(left));
                    left++;
                } else {
                    // 不存在，右移
                    windowSet.add(s.charAt(right));
                    right++;

                    // 统计窗口大小
                    int curWindowLength = right - left;
                    maxCount = Math.max(maxCount, curWindowLength);
                }
                System.out.printf("left = %d,right = %d, set = %s, set size = %d, maxcount = %d\n", left, right, windowSet, windowSet.size(), maxCount);
            }

            return maxCount;
        }

    }


}
