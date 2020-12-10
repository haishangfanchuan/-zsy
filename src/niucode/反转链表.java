package niucode;

import niucode.comment.ListNode;

import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/5 20:44
 *
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class 反转链表 {

    public static void main(String[] args) {
        ListNode headNode = new ListNode(1);
        ListNode node2 = new ListNode(2);
        headNode.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        System.out.println(ReverseList(headNode));
    }


//    public static ListNode ReverseList(ListNode head) {
//        ListNode currentNode = head.next;
//        ListNode preNode = null;
//        while (currentNode!=null){
//            ListNode nextNode = currentNode.next;
//            currentNode.next = preNode;
//            head.next  = currentNode;
//            preNode = currentNode;
//            currentNode = nextNode;
//        }
//        return head;
//    }
public static ListNode ReverseList(ListNode head) {
    if (head == null) return null;
    ListNode currentNode = head, next = head.next,preNode = null;
    while (true) {
        currentNode.next = preNode;
        preNode = currentNode;
        if (next == null) return currentNode;
        currentNode = next;
        next = next.next;
    }
}

}
