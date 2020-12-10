package jiangzhi_offer;

import leetcode.letcode100.comment.ListNode;
import net.sf.cglib.proxy.MethodInterceptor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/18 14:32
 */
public class 合并排序链表 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(3);
        node2.next = node3;
        ListNode node4 = new ListNode(4);
//        node3.next = node4;
        ListNode node5 = new ListNode(5);
        node4.next = node5;
        System.out.println(Merge(node1,node4));
    }

    public static ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) return list1 == null ? list2 : list1;
        ListNode res = null;
        if (list1.val < list2.val) {
            res = list1;
            list1.next = Merge(list1.next, list2);
        } else {
            res = list2;
            list2.next = Merge(list1, list2.next);
        }
        return res;
    }
}

