package niucode;

import niucode.comment.ListNode;

import java.util.Objects;

/**
 * @author shengyun
 * @date 2020/12/31
 *
 * 输入两个链表，找出它们的第一个公共结点。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class 两个链表的第一个公共节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node3 = new ListNode(3);
        head.next = node3;
        ListNode node7 = new ListNode(7);
        node3.next = node7;
        ListNode node9 = new ListNode(9);
        node7.next = node9;

        ListNode head2 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        head2.next = node4;
        ListNode node6 = new ListNode(6);
        node4.next = node6;
        ListNode node8 = new ListNode(7);
        node6.next = node8;
        ListNode node10 = new ListNode(9);
        node8.next = node10;
        System.out.println(FindFirstCommonNode(head,head2));
    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        //1 -> 3 -> 7 ->9
        //2 -> 4 -> 6 -> 7 -> 9
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 != p2) {
                if (p1 == null) p1 = pHead2;
                if (p2 == null) p2 = pHead1;
            }
        }
        return p1;
    }
}
