package leetcode.letcode100;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/10/10 15:07
 */
public class 环形链表2 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        List<ListNode> list = new ArrayList<>();
        list.add(head);
        while (head!=null) {
            head = head.next;
            if(list.contains(head)) return head;
            list.add(head);
        }
        return null;
    }
}
