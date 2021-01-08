package niucode;

import niucode.comment.ListNode;

/**
 * @author shengyun
 * @date 2020/12/10
 *
 * @deprecated 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 示例1
 * 输入
 * {1,3,5},{2,4,6}
 * 返回值
 * {1,2,3,4,5,6}
 */
public class 合并两个排序列表 {

    public static void main(String[] args) {
        ListNode list11 = new ListNode(1);
        ListNode list12 = new ListNode(3);
        list11.next = list12;
        ListNode list13 = new ListNode(5);
        list12.next = list13;
        list13.next = null;

        ListNode list21 = new ListNode(2);
        ListNode list22 = new ListNode(4);
        list21.next = list22;
        ListNode list23 = new ListNode(6);
        list22.next = list23;
        list23.next = null;

        ListNode merge = Merge(list11, list21);
        System.out.println(merge);
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) return null;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode tempNode = new ListNode(-1);
        ListNode newHead = tempNode;
        while (list2 != null && list1 != null) {
            int val1 = list1.val  ,val2 = list2.val;
            if (val1 <= val2) {
                newHead.next  = list1;
                list1 = list1.next;
            }else {
                newHead.next = list2;
                list2 = list2.next;
            }
            newHead = newHead.next;
        }
        if (list1 != null) newHead.next = list1;
        if (list2 != null) newHead.next = list2;
        return tempNode.next;
    }
}
