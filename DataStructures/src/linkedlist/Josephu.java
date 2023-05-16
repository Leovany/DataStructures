package linkedlist;

/**
 * 约瑟夫问题（环形单向链表）
 */
public class Josephu {
    public static void main(String[] args) {
        int count = 5;  // 总数
        int startNo = 1;  // 第几个开始
        int step = 2;   // 数到 m

        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.genrateNode(count);
        circleSingleLinkedList.show();
        System.out.println("总数 = " + circleSingleLinkedList.size());
        System.out.print("出队顺序 : ");
        circleSingleLinkedList.play(startNo, step);
    }
}


class CircleSingleLinkedList {

    private Node2 firstNode = null;

    public void genrateNode(int num) {
        if (num < 1) {
            System.out.println("数量太少 < 1");
            return;
        }

        Node2 lastNode = firstNode;
        for (int i = 1; i <= num; i++) {
            Node2 node = new Node2(i);
            if (i == 1) {
                firstNode = node;
                firstNode.next = firstNode;  // 构建成环

                lastNode = firstNode;

            } else {
                // 找到最后
                lastNode.next = node;
                node.next = firstNode;

                lastNode = node;
            }
        }


    }

    public void show() {
        Node2 lastNode = firstNode;
        while (true) {
            if (lastNode.next == firstNode) {
                // 最后一个
                System.out.println(lastNode);
                break;
            }
            System.out.println(lastNode);
            lastNode = lastNode.next;
        }
    }


    public int size() {
        if (firstNode == null) {
            return 0;
        }
        int count = 0;
        Node2 lastNode = firstNode;
        while (true) {
            if (lastNode.next == firstNode) {
                // 最后一个
                count++;
                break;
            }
            count++;
            lastNode = lastNode.next;
        }
        return count;
    }

    public void play(int startNo, int step) {
        if (firstNode == null || startNo < 1 || step > size()) {
            System.out.println("参数错误");
            return;
        }

        Node2 curNode = firstNode;
        for (int i = 0; i < (startNo - 1); i++) {
            curNode = curNode.next;
        }

        while (true) {

            if (curNode.next == curNode) {
                // 最后一个
                System.out.println(curNode.no);
                break;
            }

            Node2 lastNode = null;
            // 移位置
            for (int j = 0; j < (step - 1); j++) {
                lastNode = curNode;
                curNode = curNode.next;
            }
            // 2. 移除节点
            System.out.print(curNode.no + "->");
            lastNode.next = curNode.next;
            // 往后移
            curNode = curNode.next;

        }
    }

}

class Node2 {
    // 编号
    public int no;
    // 下一个
    public Node2 next;

    public Node2(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Node2{" + "no=" + no + '}';
    }
}