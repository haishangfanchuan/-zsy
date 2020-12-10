package jiangzhi_offer;

import leetcode.letcode100.comment.ListNode;

/**
 * @author zhangsy
 * @date 2020/9/18 14:08
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        System.out.println(ReverseList(node1));
    }

    public static ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        ListNode preNode = null, currentNode = head,next = head.next,node = null;
        while (true) {
            currentNode.next = preNode;//当前节点的next = 上一个节点
            preNode = currentNode;    //上一个节点 = 当前节点
            node = currentNode;
            currentNode = next;       //当前节点向后移动一位
            if(currentNode==null) break;
            next = next.next;        //下一个节点先后移动
        }
        return node;
    }
}
