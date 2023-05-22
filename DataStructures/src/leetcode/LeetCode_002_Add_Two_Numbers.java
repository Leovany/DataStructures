package leetcode;

/**
 * 2. 两数相加
 */
public class LeetCode_002_Add_Two_Numbers {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        Solution solution = new Solution();
        ListNode resultNode = solution.addTwoNumbers(l1, l2);
        System.out.println(resultNode);  // 807

    }

    static class Solution {

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = new ListNode(0);

            // 偏移指针
            ListNode curr = head;
            ListNode p = l1;
            ListNode q = l2;

            int carry = 0; // 进位
            while (p != null || q != null) {

                int x = (p != null) ? p.val : 0;
                int y = (q != null) ? q.val : 0;

                int sum = x + y + carry;

                carry = sum / 10;

                curr.next = new ListNode(sum % 10);
                curr = curr.next;

                // 下一组计算
                if (p != null) {
                    p = p.next;
                }
                if (q != null) {
                    q = q.next;
                }
            }
            // 特殊处理最后的进位
            if (carry > 0) {
                curr.next = new ListNode(carry);
            }
            // 移除第一个头节点（val = 0 ）情况
            return head.next;
        }

    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }


}
