package linkedlist;

import java.util.Stack;

/**
 * 单链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode hero_1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero_2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero_3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero_4 = new HeroNode(4, "林冲", "豹子头");

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        // 加入
//        singleLinkedList.add(hero_1);
//        singleLinkedList.add(hero_2);
//        singleLinkedList.add(hero_3);
//        singleLinkedList.add(hero_4);
        // 按顺序插入
        singleLinkedList.addByOrder(hero_1);
        singleLinkedList.addByOrder(hero_4);
        singleLinkedList.addByOrder(hero_2);
        singleLinkedList.addByOrder(hero_3);
        singleLinkedList.showList();

        System.out.println("========修改=======");
        HeroNode updateHero = new HeroNode(2, "小卢", "玉~");
        singleLinkedList.update(updateHero);
        singleLinkedList.showList();

        System.out.println("========删除=======");
        singleLinkedList.delete(1);
//        singleLinkedList.delete(2);
//        singleLinkedList.delete(3);
        singleLinkedList.delete(4);
        singleLinkedList.showList();

        System.out.println("========长度=======");
        System.out.printf("长度 = %d \n", singleLinkedList.getLength());

        System.out.println("========倒数=======");
        System.out.printf("倒数 = %s \n", singleLinkedList.findLastIndexNode(3));

        System.out.println("========反转=======");
        singleLinkedList.reverse();
        singleLinkedList.showList();
        System.out.println("========逆序打印=======");
        singleLinkedList.reversePrint();
    }
}

class HeroNode {
    public int no;
    public String name;
    public String nickName;
    public HeroNode next;

    public HeroNode(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" + "no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
    }
}

class SingleLinkedList {
    // 初始化头节点
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 1. 找到当前链表的最后节点
     * 2. 将最后这个节点的next,指向新的节点
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {

        HeroNode temp = head;
        while (true) {
            // 找到链表的最后
            if (temp.next == null) {
                break;
            }
            // 链表后移
            temp = temp.next;
        }
        // 最后一个节点
        temp.next = heroNode;
    }

    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;

        boolean flag = false;   // 是否已存在
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                // 找到
                break;
            }
            if (temp.next.no == heroNode.no) {
                // 编号相同
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            System.out.printf("准备插入的英雄编号 %d 已经存在，不能在插入 \n ", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }

    }

    public void update(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.no == newHeroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            // 找到
            temp.name = newHeroNode.name;
            temp.nickName = newHeroNode.nickName;
        } else {
            System.out.printf("没有找到编号 %d 节点，不能修改 \n", newHeroNode.no);
        }

    }

    public void delete(int no) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }

        HeroNode temp = head;
        boolean flag = false; // 是否找到
        while (true) {
            if (temp.next == null) {
                // 链表最后
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("要删除的节点%d不存在\n", no);
        }

    }

    /**
     * 显示链表
     */
    public void showList() {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp.next == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
        // 最后一个节点
        System.out.println(temp);
    }

    /**
     * 统计长度
     *
     * @return
     */
    public int getLength() {
        if (head.next == null) {
            return 0;
        }
        int count = 0;
        HeroNode cur = head;
        while (cur.next != null) {
            count += 1;
            cur = cur.next;
        }
        return count;
    }

    /**
     * 查找单链表中，倒数第k个节点
     *
     * @param index
     * @return
     */
    public HeroNode findLastIndexNode(int index) {
        if (head.next == null) {
            return null;
        }
        int count = getLength();
        if (index <= 0 || index > count) {
            return null;
        }
        HeroNode cur = head.next;
        // 移动 count-index 次
        for (int i = 0; i < count - index; i++) {
            cur = cur.next;
        }
        return cur;

    }

    /**
     * 反转-修改原来的结构
     * 1. 先定义一个新节点
     * 2.从头到尾遍历原来的链表，每遍历一个节点，就将其取出，并放在新的链表 reverseHead的最前端
     * 3. 原来的链表 head.next = reverseHead.next
     */
    public void reverse( ) {
        HeroNode reverseHead = new HeroNode(0, "", "");
        if (head.next == null || head.next.next == null) {
            // 0或1个，不用反转
            return ;
        }
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            // 1. 先记录下一个节点，防止找不到后移节点
            next = cur.next;
            // 2. 当前节点的下一个节点，指向反转节点的下一个节点
            cur.next = reverseHead.next;
            // 3. 反转节点下一个节点，等于当前节点
            reverseHead.next = cur;
            // 4. 后移
            cur = next;
        }
        // 将head.next指向reverHead.next , 实现单链表的反转
        head.next = reverseHead.next;
    }

    /**
     * 逆序打印
     */
    public void reversePrint(){
        if(head.next == null){
            return;
        }

        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        // 打印
        while (stack.size()>0){
            System.out.println(stack.pop());
        }

    }

}