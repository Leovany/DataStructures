package nowcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * NC52 有效括号序列
 */
public class NowCoder_NC52 {
    public static void main(String[] args) {

    }

    public class Solution {
        /**
         * "()"和"()[]{}"都是合法的括号序列，但"(]"和"([)]"不合法。
         *
         * @param s string字符串
         * @return bool布尔型
         */
        public boolean isValid(String s) {
            if (s.length() <= 1) {
                return false;
            }
            Stack<Character> stack = new Stack<>();

            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];
                if(ch == '('){
                    stack.add(')');
                }else if(ch == '['){
                    stack.add(']');
                }else if(ch == '{'){
                    stack.add('}');
                }else if(stack.isEmpty() || stack.pop() != ch){
                    return false;
                }
            }
            return stack.isEmpty();
        }


    }
}
