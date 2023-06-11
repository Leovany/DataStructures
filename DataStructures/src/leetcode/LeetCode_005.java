package leetcode;

/**
 * 5. 最长回文子串
 */
public class LeetCode_005 {

    public static void main(String[] args) {
        String str = "babad";
        Solution solution = new Solution();
        String longestPalindrome = solution.longestPalindrome(str);
        System.out.println(longestPalindrome);

    }

    static class Solution {
        public String longestPalindrome(String s) {
            if (s.length() == 0) {
                return s;
            }
            int count = 0;
            int startIndex = 0 , endIndex = 0;

            // 遍历s
            for (int i = 0; i < s.length(); i++) {
                // 奇数
                int leftIndex = i - 1;
                int rightIndex = i + 1;
                while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
                    // 长度
                    int len = rightIndex - leftIndex + 1;
                    if (len > count) {
                        count = len;
                        startIndex = leftIndex;
                        endIndex = rightIndex;
                    }
                    leftIndex--;
                    rightIndex++;
                }

                // 偶数
                leftIndex = i;
                rightIndex = i + 1;
                while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
                    // 长度
                    int len = rightIndex - leftIndex + 1;
                    if (len > count) {
                        count = len;
                        startIndex = leftIndex;
                        endIndex = rightIndex;
                    }
                    leftIndex--;
                    rightIndex++;
                }
            }
            return s.substring(startIndex,endIndex+1);

        }

    }


}
