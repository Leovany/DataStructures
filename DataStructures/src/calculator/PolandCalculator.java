package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 *  1. 生成中缀表达式
 *  2. 中缀表达式 转 后缀表达式
 *  3. 根据后缀表达式，进行计算
 */
public class PolandCalculator {

    public static void main(String[] args) {
        String expression = "1+(2+3)*4-5";
        PolandCalculator calculator = new PolandCalculator();
        int result = calculator.calculator(expression);
        System.out.println("计算结果：" + expression + " = " + result);
    }

    /**
     * 转成中缀表达式
     *
     * @param expression
     * @return
     */
    private List<String> getInfixExpression(String expression) {

        List<String> list = new ArrayList<>();
        String item = "";

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (isNum(ch)) {
                // 数字
                item += ch;
                while (true) {
                    if (i == expression.length() - 1) {
                        // 最后一个
                        break;
                    }
                    if (!isNum(expression.charAt(i + 1))) {
                        // 字符
                        break;
                    }
                    i++;
                    item += expression.charAt(i);
                }
                list.add(item);

            } else {
                list.add(String.valueOf(ch));
            }
            // 重置为空
            item = "";
        }
        return list;
    }

    private Stack<Integer> numStack = new Stack<>();

    /**
     * 计算表达式
     *
     * @param expression
     * @return
     */
    public int calculator(String expression) {
        // 1. 中缀表达式
        //expression = "1+(2+3)*4-5";
        List<String> infixExpressionList = getInfixExpression(expression);    // [1,+,(,2,+,3,),*,4,-,5]
        System.out.println("中缀表达式 = " + infixExpressionList);

        // 2. 中缀表达式 -> 后缀表达式
        List<String> suffixExpressionList = infixToSuffinfixExpression(infixExpressionList); // [1,2,3,+,4,*,+,5,-]
        System.out.println("后缀表达式 = " + suffixExpressionList);
        // 3. 根据后缀表达式，进行计算
        for (String item : suffixExpressionList) {
            if (item.matches("\\d+")) {
                // 数字
                numStack.add(Integer.parseInt(item));
            } else {
                // 运算符，弹出两个数，进行计算
                int num_1 = numStack.pop();
                int num_2 = numStack.pop();
                int res = calculate(num_1, num_2, item);
                numStack.add(res);

            }
        }

        // 最后结果
        int result = numStack.pop();
        return result;
    }

    /**
     * 中缀表达式 转 后缀表达式
     *
     * @param infixExpressionList
     * @return
     */
    private List<String> infixToSuffinfixExpression(List<String> infixExpressionList) {
        // [1,+,(,2,+,3,),*,4,-,5]  --->  [1,2,3,+,4,*,+,5,-]
        // 运算符栈
        Stack<String> operStack = new Stack<>();
        // 数栈
        ArrayList<String> numStack = new ArrayList<>();

        // 执行过程
        for (int i = 0; i < infixExpressionList.size(); i++) {
            String item = infixExpressionList.get(i);

            if (item.matches("\\d+")) {
                // 数字
                numStack.add(item);
            } else if ("(".equals(item)) {
                operStack.add(item);
            } else if (")".equals(item)) {

                while (!"(".equals(operStack.peek())) {
                    // 没有遇到左括号
                    numStack.add(operStack.pop());
                }
                operStack.pop();  // 移除 左括号
            } else {
                // 运算符，比较优先级

                while (operStack.size() != 0 && getPriority(item) <= getPriority(operStack.peek())) {
                    // 运算符栈 不等于0 && 【比较优先级】当前运算符 <= 栈顶运算符
                    numStack.add(operStack.pop());
                }
                operStack.add(item);
            }
        }
        // 最后，将剩余运算符加入 结果栈中
        while (operStack.size() != 0) {
            numStack.add(operStack.pop());
        }
        return numStack;
    }

    /**
     * 运算符权重
     *
     * @param oper
     * @return
     */
    private int getPriority(String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = 1;
                break;
            case "-":
                res = 1;
                break;
            case "*":
                res = 2;
                break;
            case "/":
                res = 2;
                break;
            default:
                //throw new RuntimeException("不合法运算符 = " + oper);
                break;
        }
        return res;
    }

    /**
     * 计算
     *
     * @param num_1
     * @param num_2
     * @param oper
     * @return
     */
    private int calculate(int num_1, int num_2, String oper) {
        int res = 0;
        switch (oper) {
            case "+":
                res = num_1 + num_2;
                break;
            case "-":
                res = num_2 - num_1;
                break;
            case "*":
                res = num_1 * num_2;
                break;
            case "/":
                res = num_2 / num_1;
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 是否是数字
     *
     * @param ch
     * @return
     */
    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';

    }

}
