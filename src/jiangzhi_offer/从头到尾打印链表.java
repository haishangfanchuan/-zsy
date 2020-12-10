package jiangzhi_offer;

import leetcode.letcode100.comment.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/16 23:53
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */
public class 从头到尾打印链表 {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.isEmpty()) list.add(stack.pop());
        return list;
    }
}
