package jiangzhi_offer;

import leetcode.letcode100.comment.ListNode;

import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/18 13:30
 */
public class 链表中倒数第k个节点 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) return null;
        Stack<ListNode> stack = new Stack<>();
        while (head!=null) {
            stack.push(head);
            head = head.next;
        }
        int temp = 0 ;
        ListNode res = null;
        while (!stack.isEmpty()) {
            temp++;
            res = stack.pop();
            if (temp==k) return res;
        }
        return null;
    }
}
