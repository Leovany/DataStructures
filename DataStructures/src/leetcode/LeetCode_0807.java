package leetcode;

import java.util.*;

/**
 * 08.07. 无重复字符串的排列组合
 */
public class LeetCode_0807 {

    public static void main(String[] args) {

        String str = "qwe";
        Solution solution = new Solution();
        String[] arr = solution.permutation(str);
        System.out.println(arr);

    }

    static class Solution {
        public String[] permutation(String S) {
            //造个可以去重的哈希set来装字符串结果
            HashSet<String> set = new HashSet<>();
            //递归拼接得到字符串并把结果塞进set里面
            //递归参数越少越好理解，第一个是一个一个拼接的临时结果（拼接字符串），第二个是还剩多少可以拿来拼接（剩余字符串），就两个字符串参数，然后set是拿来拼接完装结果的
            dfs(new StringBuffer(), new StringBuffer(S), set);
            //返回结果数组
            return set.toArray(new String[set.size()]);

        }

        private void dfs(StringBuffer sb, StringBuffer rest, Set<String> set) {
            if (rest.length() == 0) {
                //判断一下剩余还剩多少字符没有的话就是搞定啦，把结果塞进哈希set里
                set.add(sb.toString());
                return;
            }

            for (int i = 0; i < rest.length(); i++) {
                //单独new一个新的防止变量被共用
                StringBuffer sbNext = new StringBuffer(sb);
                //对于i，拼接剩余字符的第i位字符
                sbNext.append(rest.charAt(i));
                //和上面一样new一个新的防止变量被共用
                StringBuffer resNext = new StringBuffer(rest.substring(0, i) + rest.substring(i + 1));
                //重复这个步骤就可以了，直到回溯条件剩余字符串没了
                dfs(sbNext, resNext, set);

            }

        }


    }
}
