package niucode;

import niucode.comment.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/5 22:56
 *
 * 判断给定的链表中是否有环
 */
public class 判断给定的链表中是否有环 {

    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        List<ListNode> list = new ArrayList<>();
        ListNode nextNode = head;
        list.add(nextNode);
        while (nextNode!=null){
            if(list.contains(nextNode.next)){
                return true;
            }
            nextNode = nextNode.next;
            list.add(nextNode);
        }
        return false;
    }
}


