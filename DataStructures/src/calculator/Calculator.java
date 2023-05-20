package calculator;

/**
 * 计算器
 * 1. char 可以直接转 int ，需要减去48 或者 减'0'
 */
public class Calculator {

    public static void main(String[] args) {

        String expression = "10+20*6-3";
        Calculator calculator = new Calculator(10);
        int result = calculator.calResult(expression);
        System.out.println(expression + "=" + result);

    }

    // 数栈
    private ArrayStack numStack;
    // 操作栈
    private ArrayStack operStack;

    public Calculator(int maxSize) {
        this.numStack = new ArrayStack(maxSize);
        this.operStack = new ArrayStack(maxSize);
    }

    /**
     * 计算表达式
     *
     * @param expression 表达式
     * @return
     */
    public int calResult(String expression) {
        // 1. 获取单个字符
        char[] array = getCharArray(expression);
        // 2. 单个字符判断
        String numStr = "";
        for (int i = 0; i < array.length; i++) {
            char ch = array[i];
            if (isOper(ch)) {
                // 操作符
                if (operStack.isEmpty()) {
                    operStack.add(ch);
                    continue;
                }
                // 比较操作符优先级
                if (isBigOperPriority(ch, (char) operStack.peek())) {
                    // 当前操作符 > 栈中符号
                    operStack.add(ch);
                } else {
                    // 当前操作符 <= 栈中符号 -> 计算
                    int num_1 = numStack.pop();
                    int num_2 = numStack.pop();
                    char oper = (char) operStack.pop();
                    int res = calOper(num_1, num_2, oper);
                    numStack.add(res);  // 将计算结果压入数栈中
                    operStack.add(ch);  // 将当前操作符压入操作栈中
                }
            } else {
                // 数字
                //  char转int 要 减去48数字 ASCII码要-48
//                int num = ch - 48;
                numStr += ch;

                while(true){
                    if(i == array.length - 1){
                        // 最后一个跳出
                        break;
                    }
                    if(isOper(array[i+1])){
                        // 下一个是字符，跳出
                        break;
                    }
                    i++;
                    // 数字
                    numStr += array[i];
                }

                int num = Integer.parseInt(numStr);
                numStack.add(num);

                numStr = "";
            }
        }

        // 3. 计算
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            int num_1 = numStack.pop();
            int num_2 = numStack.pop();
            char oper = (char) operStack.pop();
            int res = calOper(num_1, num_2, oper);
            numStack.add(res);
        }
        // 最终结果
        int res = numStack.pop();

        return res;
    }

    /**
     * 转成char数组
     *
     * @param expression
     * @return
     */
    private char[] getCharArray(String expression) {
        char[] array = new char[expression.length()];
        for (int i = 0; i < expression.length(); i++) {
            array[i] = expression.charAt(i);
        }
        return array;
    }

    /**
     * oper_1 优先级是否大于 oper_2
     *
     * @param oper_1
     * @param oper_2
     * @return
     */
    private boolean isBigOperPriority(char oper_1, char oper_2) {
        int priority_1 = getOperPriority(oper_1);
        int priority_2 = getOperPriority(oper_2);

        return priority_1 > priority_2;
    }

    /**
     * 计算
     *
     * @param num_1
     * @param num_2
     * @param oper
     * @return
     */
    private int calOper(int num_1, int num_2, char oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num_1 + num_2;
                break;
            case '-':
                res = num_2 - num_1;
                break;
            case '*':
                res = num_1 * num_2;
                break;
            case '/':
                res = num_2 / num_1;
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 是否是操作符
     *
     * @param ch
     * @return
     */
    private boolean isOper(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    /**
     * 操作符的优先级
     *
     * @param ch
     * @return
     */
    private int getOperPriority(char ch) {
        if (ch == '*' || ch == '/') {
            return 1;
        } else if (ch == '+' || ch == '-') {
            return 0;
        } else {
            return -1;
        }
    }

}


/**
 * 数组实现栈
 */
class ArrayStack {

    private int maxSize;
    private int[] arr;
    private int top = -1; // 指针

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
        this.top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public void add(int num) {
        if (isFull()) {
            System.out.println("已满");
            return;
        }
        top += 1;
        arr[top] = num;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        int val = arr[top];
        top -= 1;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("空栈");
        }
        return arr[top];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("空栈");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("arr[%d]=%d \n", i, arr[i]);
        }
    }

}

