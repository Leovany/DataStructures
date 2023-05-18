package stack;

import java.util.Scanner;

/**
 * 数组模拟栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(3);

        Scanner scanner = new Scanner(System.in);
        boolean isLoop = true;
        while (isLoop) {
            System.out.println("s(show):展示");
            System.out.println("a(add):添加");
            System.out.println("p(pop):出栈");

            char c = scanner.next().charAt(0);
            switch (c) {
                case 's':
                    stack.show();
                    break;
                case 'a':
                    int val = scanner.nextInt();
                    stack.add(val);
                    break;
                case 'p':
                    try {
                        int popVal = stack.pop();
                        System.out.println("出栈 = " + popVal);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }

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

    public void show() {
        if (isEmpty()) {
            System.out.println("空栈");
        }
        for (int i = top; i >= 0; i--) {
            System.out.printf("arr[%d]=%d \n", i, arr[i]);
        }
    }

}
