package niucode;

import niucode.comment.ListNode;

/**
 * @author shengyun
 * @date 2020/12/8
 */
public class 链表中倒数第K个节点 {

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) return null;
        //快慢指针：快指针比慢指针先走K步，此时快慢指针之间相隔节点为K,之后快慢指针同步行走知道快指针到达null
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (k > 0) {
            fastNode = fastNode.next;
            if (fastNode == null) return  null;
            k--;
        }
        for (;fastNode != null;slowNode =  slowNode.next,fastNode = fastNode.next) {}
        return slowNode;
    }
}
