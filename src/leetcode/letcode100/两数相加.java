package leetcode.letcode100;

import java.util.Stack;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，
 * 并且它们的每个节点只能存储 一位 数字。
 *  如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *  您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *  示例：
 *  输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  输出：7 -> 0 -> 8
 *  原因：342 + 465 = 807
 */
public class 两数相加 {

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(-1);
        ListNode n12 = new ListNode(2);
        ListNode n14 = new ListNode(4);
        ListNode n13 = new ListNode(3);
        listNode1.next = n12;
        n12.next = n14;
        n14.next = n13;

        ListNode listNode2 = new ListNode(-2);
        ListNode n25 = new ListNode(5);
        ListNode n26 = new ListNode(6);
        ListNode n24 = new ListNode(4);
        listNode2.next = n25;
        n25.next = n26;
        n26.next = n24;


        ListNode listNode = addTwoNumbers(listNode1, listNode2);
        System.out.println(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum  = intUtil(l1) + intUtil(l2);
        char[] targetStr = String.valueOf(sum).toCharArray();
        ListNode listNode = new ListNode(-1);
        ListNode tempNode = listNode;
        for (int i = targetStr.length-1; i >=0; i--) {
            ListNode node = new ListNode(Integer.parseInt(String.valueOf(targetStr[i])));
            tempNode.next = node;
            tempNode = node;
        }
        return listNode;
    }

    private static int intUtil(ListNode listNode){
        Stack<ListNode> stack = new Stack<>();
        ListNode tempNode = listNode.next;
        while (true){
            if(tempNode==null){
                break;
            }
            stack.push(tempNode);
            tempNode = tempNode.next;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.pop().val);
        }
        return Integer.parseInt(sb.toString());
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

