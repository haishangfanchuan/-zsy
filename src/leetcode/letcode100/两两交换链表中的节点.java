package leetcode.letcode100;

import java.util.ArrayList;
import java.util.List;
import leetcode.letcode100.comment.ListNode;

/**
 * @author zhangsy
 * @date 2020/9/7 13:38
 *
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

    示例:

    给定 1->2->3->4, 你应该返回 2->1->4->3.。
     */
public class 两两交换链表中的节点 {

    public static void main(String[] args) {
        leetcode.letcode100.comment.ListNode headNode = new leetcode.letcode100.comment.ListNode(0);
        leetcode.letcode100.comment.ListNode node1 = new leetcode.letcode100.comment.ListNode(1);
//        headNode.next = node1;
        leetcode.letcode100.comment.ListNode node2 = new leetcode.letcode100.comment.ListNode(2);
        node1.next = node2;
        leetcode.letcode100.comment.ListNode node3 = new leetcode.letcode100.comment.ListNode(3);
        node2.next = node3;
        leetcode.letcode100.comment.ListNode node4 = new leetcode.letcode100.comment.ListNode(4);
        node3.next = node4;
        leetcode.letcode100.comment.ListNode node5 = new leetcode.letcode100.comment.ListNode(5);
        node4.next = node5;
        System.out.println(swapPairs(node1));
    }

    public static ListNode swapPairs(ListNode head) {
        //终止条件：链表只剩一个节点或者没节点了，没得交换了。返回的是已经处理好的链表
        if(head == null || head.next == null){
            return head;
        }
        //一共三个节点:head, next, swapPairs(next.next)
        //下面的任务便是交换这3个节点中的前两个节点
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        //根据第二步：返回给上一级的是当前已经完成交换后，即处理好了的链表部分
        return next;
    }
}
