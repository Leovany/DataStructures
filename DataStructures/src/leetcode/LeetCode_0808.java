package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 08.08. 有重复字符串的排列组合
 */
public class LeetCode_0808 {

    public static void main(String[] args) {

        String str = "abc";
        Solution solution = new Solution();
        String[] permutation = solution.permutation(str);
        System.out.println(Arrays.toString(permutation));

    }

    static class Solution {


        public String[] permutation(String S) {
            Set<String> set = new HashSet<>();
            char[] arr = S.toCharArray();
            dfs(arr, 0, set);
            String[] res = new String[set.size()];
            return set.toArray(res);
        }

        private void dfs(char[] arr, int idx, Set<String> set) {
            if (arr.length - 1 == idx) {
                set.add(new String(arr));
                return;
            }

            for (int i = idx; i < arr.length; i++) {
                // 交换
                char temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;

                dfs(arr, idx + 1, set);
                // 交换回来
                temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
            }

        }

    }


}
