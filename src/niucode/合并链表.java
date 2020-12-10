package niucode;

import niucode.comment.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/5 23:12
 *
 * 将两个有序的链表合并为一个新链表，要求新的链表是通过拼接两个链表的节点来生成的。
 *
 */
public class 合并链表 {

    public ListNode mergeTwoLists (ListNode l1, ListNode l2) {
        // write code here
        if(l1==null && l2==null){
            return null;
        }
        ListNode node1 = l1,node2 = l2,preNode = null;
        while (node2!=null){
            //遍历l1
            while (node1!=null){
                preNode = node1;
                if(node1.val <= node2.val){
                    //将node2插入到node1的前面
                    preNode.next = node2;
                    node2.next = node1;
                }
                node1 = node1.next;
            }
            node2 = node2.next;
        }
        return node1;
    }
}

