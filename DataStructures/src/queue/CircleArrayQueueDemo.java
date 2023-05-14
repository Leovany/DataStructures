package queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(4); // 实际只有 n-1 个
        char key = ' '; // 接收用户输入

        boolean isLoop = true;

        Scanner scanner = new Scanner(System.in);
        while (isLoop){
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add)：添加数据到队列");
            System.out.println("g(get)：从队列取出数据");
            System.out.println("h(head):查看队列头的数据");

            key = scanner.next().charAt(0); // 接收第一个字符
            switch (key){
                case 's':
                    queue.show();
                    break;
                case 'e':
                    scanner.close();
                    isLoop = false;
                    break;
                case 'a':
                    System.out.println("请在输入一个整型值：");
                    int val = scanner.nextInt();
                    queue.add(val);
                    break;
                case 'g':
                    try {
                        int getVal = queue.get();
                        System.out.printf("取出的数据是 %d\n",getVal);
                    }catch(Exception e) {
                        System.out.printf("%s\n",e.getMessage());
                    }
                    break;
                case 'h':
                    try{
                        int peekValue = queue.peek();
                        System.out.printf("队列的头数据是 %d\n",peekValue);
                    }catch (Exception e){
                        System.out.printf("%s\n",e.getMessage());
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");

    }
}

class CircleArray {

    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int maxSize) {
        this.maxSize = maxSize;
        this.front = 0;
        this.rear = 0;
        this.arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队伍已满，不能加入数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    public int get() {
        if (isEmpty()) {
            throw new RuntimeException("队伍空，不能去数据");
        }
        int val = arr[front];
        front = (front + 1) % maxSize;
        return val;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("已空");
        }
        return arr[front];
    }

    public void show() {
        if (isEmpty()) {
            System.out.println("没有元素");
            return;
        }
        // 从front 开始遍历
        for (int i = front; i < front + size(); i++) {
            int realIndex = i % maxSize;
            System.out.printf("arr[%d]=%d\n", realIndex, arr[realIndex]);
        }
    }

}
