package leetcode.letcode100;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import leetcode.letcode100.comment.ListNode;

/**
 * @author zhangsy
 * @date 2020/9/6 18:40
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class 删除链表的倒数第N个节点 {

    public static void main(String[] args) {
        ListNode headNode = new ListNode(0);
        ListNode node1 = new ListNode(1);
        headNode.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        System.out.println(removeNthFromEnd(headNode, 2));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode tempNode = head;
        List<ListNode> listNodes = new ArrayList<>();
        while (tempNode != null) {
            listNodes.add(tempNode);
            tempNode = tempNode.next;
        }
        int temp = listNodes.size();
        if (temp == n) head = head.next;
        if (n == 1) listNodes.get(temp - 1).next = null;
        else listNodes.get(temp - n).next = listNodes.get(temp - n + 2);
        return head;
    }
}
