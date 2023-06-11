package leetcode;

import java.util.Stack;

public class LeetCode_1614 {

    public static void main(String[] args) {
        String expression = "(1)+((2))+(((3)))";
        Solution solution = new Solution();
        int maxDepth = solution.maxDepth(expression);
        System.out.println(maxDepth);
    }

    static class Solution {
        public int maxDepth(String s) {
            int maxCount = 0;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    stack.add(')');
                    maxCount = Math.max(maxCount, stack.size());
                } else if (ch == ')') {
                    stack.pop();
                }

            }

            return maxCount;
        }
    }

}
