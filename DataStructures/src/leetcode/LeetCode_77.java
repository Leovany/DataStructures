package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 77. 组合
 */
public class LeetCode_77 {

    public static void main(String[] args) {


        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);
        System.out.println(combine);

    }

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> res = new ArrayList<>();
            if (k <= 0 || n < k) {
                return res;
            }

            ArrayDeque<Integer> path = new ArrayDeque<>();

            dfs(n, k, 1, path, res);
            return res;
        }

        private void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
            // 递归终止条件，path长度 == k
            if (path.size() == k) {
                res.add(new ArrayList<>(path));
                return;
            }

            // 遍历可能的搜索起点
            for (int i = begin; i <= n; i++) {
                // 向路径变量里添加一个数
                path.addLast(i);
                System.out.println("递归之前 => " + path);
                // 下一轮搜索，设置的搜索起点要加1,因为组合数理不允许出现重复的元素
                dfs(n, k, i + 1, path, res);

                // 深度优先遍历有回头的过程，递归之前做了什么，递归之后需要做相同的操作
                path.removeLast();
                System.out.println("递归之后 => " + path);
            }

        }

    }


}
