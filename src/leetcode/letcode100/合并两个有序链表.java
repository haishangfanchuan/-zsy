package leetcode.letcode100;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/6 22:46
 */
public class 合并两个有序链表 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        List<ListNode> list = new ArrayList<>();
        while (l1!=null){
            list.add(l1);
            l1 = l1.next;
        }
        while (l2!=null){
            list.add(l2);
            l2 = l2.next;
        }
        list.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });

        ListNode node = new ListNode(-1);
        ListNode temp = node;
        for(ListNode node1 : list){
            temp.next = node1;
            temp = temp.next;
        }
        return node.next;
    }
}
