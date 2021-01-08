package niucode;

import niucode.comment.ListNode;

/**
 * @author shengyun
 * @date 2021/1/7
 *
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 示例1
 * 输入
 * {2,2,3,3,3,4,5}
 * 返回值
 * {1,2,5}
 */
public class 删除链表中的重复节点 {

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode nodeL = pHead, nodeR = pHead.next, preNode = null;
        boolean flag = false;
        int temp = 0;
        while (true) {
            int l = nodeL.val, r = nodeR.val;
            while (l == r) {
                flag = true;
                //nodeR 继续先后寻找
                nodeR = nodeR.next;
                if (nodeR == null) {
                    if (temp == 0) return null;
                    break;
                }
                r = nodeR.val;
            }
            //头节点存在重复,寻找新的头节点
            if (flag && temp == 0) {
                flag = false;
                temp = 0;
                pHead = nodeR;
                nodeR = pHead.next;
                if (nodeR == null) return pHead;
                nodeL = pHead;
            }else if (flag) {
                temp++;
                preNode.next = nodeR;
                if (nodeR == null) return pHead;
                nodeL = preNode.next;
                nodeR = nodeR.next;
                flag = false;
            }else {
                temp++;
                preNode = nodeL;
                nodeL = nodeL.next;
                nodeR = nodeR.next;
            }

            if (nodeR == null) return pHead;
        }
    }
}
