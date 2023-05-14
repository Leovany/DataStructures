package queue;

import java.util.Scanner;

/**
 * 数组模拟队列
 *      缺：数组不可重复使用（采用 环形数组）
 */
public class ArrayQueueDemo {

    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(3);
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

class ArrayQueue{
    // 最大容量
    private int maxSize;
    // 队首指针
    private int front;
    // 队尾指针
    private int rear;
    // 存放数据
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        front = -1;
        rear = -1;
        arr = new int[maxSize];
    }

    /**
     * 判断空
     */
    public boolean isEmpty(){
        return front == rear;
    }

    /**
     * 是否已满
     * @return
     */

    public boolean isFull(){
        return rear == maxSize -1;
    }

    /**
     * 添加
     * @param val
     */
    public void add(int val){
        if(isFull()){
            System.out.println("队列已满");
            return;
        }
        rear ++;
        arr[rear] = val;
    }

    /**
     * 取出元素
     * @return
     */
    public int get(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        front ++;
        return arr[front];
    }

    /**
     * 查看头部元素
     * @return
     */
    public int peek(){
        if(isEmpty()){
            throw new RuntimeException("队列已空");
        }
        return arr[front+1];
    }

    public void show(){
        if(isEmpty()){
            System.out.println("没有元素");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n",i,arr[i]);
        }
    }


}


