package leetcode;

/**
 * 5. 最长回文子串
 */
public class LeetCode_5 {

    public static void main(String[] args) {


        Solution solution = new Solution();
        String str = solution.longestPalindrome("ccc");
        System.out.println(str);

    }

    static class Solution {
        public String longestPalindrome(String s) {
            char[] arr = s.toCharArray();
            int count = 0;
            int left = 0;
            int right = 0;

            for (int i = 0; i < arr.length; i++) {
                // 奇数
                int l = i - 1;
                int r = i + 1;
                while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
                    int len = r - l + 1;
                    if (len > count) {
                        count = len;
                        left = l;
                        right = r;
                    }
                    l--;
                    r++;
                }
                // 奇数
                l = i;
                r = i + 1;
                while (l >= 0 && r < arr.length && arr[l] == arr[r]) {
                    int len = r - l + 1;
                    if (len > count) {
                        count = len;
                        left = l;
                        right = r;
                    }
                    l--;
                    r++;
                }
            }
            return s.substring(left, right + 1);
        }



    }


}
