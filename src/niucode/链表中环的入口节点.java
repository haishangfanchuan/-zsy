package niucode;

import niucode.comment.ListNode;

/**
 * @author shengyun
 * @date 2021/1/6
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class 链表中环的入口节点 {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) return null;
        //快慢指针
        ListNode fast = pHead.next.next, slow = pHead.next;
        boolean flag = false;
        while (fast != null || slow != null) {
            if (fast == null || fast.next == null || slow == null) return null;
            //证明存在环。。。但是此点并不一定是入口节点，此时将其中任意一个节点
            //重新指向头节点，两个节点都直走一步，再次相遇点即使节点
            if (fast == slow) {
                flag = true;
                fast = pHead;
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        if (flag) {
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return fast;
        }
        return null;
    }
}
