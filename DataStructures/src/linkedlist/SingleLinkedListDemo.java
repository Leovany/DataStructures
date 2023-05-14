package linkedlist;

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
}