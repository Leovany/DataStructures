package leetcode;

import java.util.HashMap;

/**
 * 76. 最小覆盖子串
 */
public class LeetCode_76 {

    public static void main(String[] args) {


        Solution solution = new Solution();


    }

    static class Solution {


        public String minWindow(String s, String t) {
            HashMap<Character, Integer> window = new HashMap<>();
            HashMap<Character, Integer> need = new HashMap<>();
            for (char c : t.toCharArray()) {
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            // 双指针
            int left = 0, right = 0;
            int count = 0;
            int start = 0;

            int len = Integer.MAX_VALUE;

            while (right < s.length()) {
                char c = s.charAt(right);
                right++;  // 右移扩大窗口

                if (need.containsKey(c)) {
                    window.put(c, window.getOrDefault(c, 0) + 1);
                    // 出现次数相同
                    if (need.get(c).equals(window.get(c))) {
                        count++;
                    }
                }

                while (count == need.size()) {
                    // 包含所有字符
                    int nowCount = right - left;
                    if (nowCount < len) {
                        len = nowCount;
                        start = left;
                    }

                    // 左指针右移，缩小窗口
                    char d = s.charAt(left);
                    left++;

                    if (need.containsKey(d)) {
                        if (need.get(d).equals(window.get(d))) {
                            count--;
                        }
                        // 字段对应次数 -1
                        window.put(d, window.get(d) - 1);
                    }

                }

            }

            return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
        }
    }


}
