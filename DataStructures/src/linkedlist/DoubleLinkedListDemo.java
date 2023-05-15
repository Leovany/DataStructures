package linkedlist;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 hero_1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero_2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero_3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero_4 = new HeroNode2(4, "林冲", "豹子头");

        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

        System.out.println("=======测试增加====");
        doubleLinkedList.add(hero_1);
        doubleLinkedList.add(hero_2);
        doubleLinkedList.add(hero_3);
        doubleLinkedList.add(hero_4);

        doubleLinkedList.showList();

        System.out.println("=======测试修改====");
        HeroNode2 updateHero = new HeroNode2(2, "小卢", "玉麒麟~~");
        doubleLinkedList.update(updateHero);
        doubleLinkedList.showList();

        System.out.println("=======测试删除====");
        doubleLinkedList.delete(2);
        doubleLinkedList.delete(4);
        doubleLinkedList.showList();
    }

}

class DoubleLinkedList {

    // 定义一个头节点
    private HeroNode2 head = new HeroNode2(0, "", "");

    public boolean isEmpty() {
        return head.next == null;
    }

    public void add(HeroNode2 heroNode) {
        // 找到最后节点
        HeroNode2 cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        // 赋值到最后节点上
        cur.next = heroNode;
        heroNode.pre = cur;
    }

    public void delete(int no) {
        if (isEmpty()) {
            System.out.println("当前双向链表为空");
            return;
        }
        HeroNode2 cur = head.next;
        boolean isFind = false;
        while (cur != null) {
            if (cur.no == no) {
                isFind = true;
                break;
            }
            cur = cur.next;
        }
        if (isFind) {
            //
            cur.pre.next = cur.next;
            if (cur.next != null) {
                // 特殊处理最后一个
                cur.next.pre = cur.pre;
            }

        } else {
            System.out.printf(" %d 不存在\n", no);
        }


    }

    public void update(HeroNode2 heroNode) {
        if (isEmpty()) {
            System.out.println("当前双向链表为空");
            return;
        }
        HeroNode2 cur = head.next;
        boolean isFind = false;
        while (cur != null) {
            if (cur.no == heroNode.no) {
                isFind = true;
                break;
            }
            cur = cur.next;
        }
        if (isFind) {
            //
            cur.name = heroNode.name;
            cur.nickName = heroNode.nickName;
        } else {
            System.out.printf(" %d 不存在\n", heroNode.no);
        }
    }

    public void showList() {
        if (isEmpty()) {
            System.out.println("当前双向链表为空");
            return;
        }
        HeroNode2 cur = head.next;
        while (cur != null) {
            System.out.println(cur);
            cur = cur.next;
        }
    }
}

class HeroNode2 {
    // data域
    public int no;
    public String name;
    public String nickName;
    // pre域
    public HeroNode2 pre;
    // next域
    public HeroNode2 next;

    public HeroNode2(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;

        this.pre = null;
        this.next = null;
    }

    @Override
    public String toString() {
        return "HeroNode2{" + "no=" + no + ", name='" + name + '\'' + ", nickName='" + nickName + '\'' + '}';
    }
}
