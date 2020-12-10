package top.theonecyl.datastructrue.linklisted;

import java.util.*;

/**
 * 单向链表
 */
public class SingleLinkedListDemo {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        HeroNode heroNode1 = new HeroNode(1,"疾风剑豪","托儿所");
        HeroNode heroNode2 = new HeroNode(2,"放逐之刃","鱼尾纹");
        HeroNode heroNode3 = new HeroNode(3,"影流之主","儿童节");
        HeroNode heroNode4 = new HeroNode(4,"张三","ZS");
        HeroNode heroNode5 = new HeroNode(5,"李四","LS");
        singleLinkedList.add(heroNode5);
        singleLinkedList.add(heroNode4);
        singleLinkedList.add(heroNode2);
        singleLinkedList.add(heroNode1);
        singleLinkedList.add(heroNode3);
//        singleLinkedList.remove(heroNode2);
//        singleLinkedList.list();
//        System.out.println("链表中节点个数为："+singleLinkedList.size(singleLinkedList));
//        System.out.println("链表中倒数第k个节点为："+singleLinkedList.getLastK(singleLinkedList,4));
        System.out.println("链表反转之后为：");
        HeroNode reversal = singleLinkedList.reversal(singleLinkedList.getHeadNode());
        System.out.println(reversal);
//        singleLinkedList.reversal(singleLinkedList).list();
//        System.out.println("反向遍历链表：");
//        singleLinkedList.reversalPrintLink(singleLinkedList);
//        System.out.println("有序链表合并：");
//        SingleLinkedList singleLinkedList2 = new SingleLinkedList();
//        singleLinkedList.mergeList(singleLinkedList,singleLinkedList2).list();


    }

}

//定义单向链表
class SingleLinkedList{
    //定义头节点，不可随意改变，引导单链表生成
    private HeroNode headNode = new HeroNode(-1,"","");

    public HeroNode getHeadNode() {
        return headNode;
    }

    //添加节点存储到链表的最后面
    public void add(HeroNode heroNode){
        HeroNode tempNode = headNode;
        while(true){
            if(tempNode.next==null){
                break;
            }
            tempNode = tempNode.next;
        }
        tempNode.next = heroNode;
    }

    //添加节点方法
    //按照编号顺序添加，不是添加到链表末尾了
    public void addByNo(HeroNode heroNode){
        //定义一个指针节点
        HeroNode temp = headNode;
        //寻找next=null末尾节点
        while (true){
            //不可添加序号重复的英雄
            if(temp.no == heroNode.no){
                System.out.println("插入节点已存在！！！");
                break;
            }
            if(temp.next == null){
                //指针走到末尾节点
                break;
            }
            if(temp.next.no > heroNode.no){
                break;
            }
            //指针后移一位
            temp = temp.next;
        }
        heroNode.next = temp.next;
        temp.next = heroNode;
    }

    //1、定义遍历链表方法
    //2、按照编号从小到大遍历
    public void list(){
        //定义一个节点指针
        HeroNode temp = headNode;
//        List<TreeNode> list = new ArrayList<>();
        //寻找next=null末尾节点
        while(true){
            if(temp.next==null){
                break;
            }
            System.out.println(temp.next);
            temp = temp.next;
//            if(temp.no>0) {
//                list.add(temp);
//            }
        }
//        //自定义list集合内部排序
//        Collections.sort(list, new Comparator<TreeNode>() {
//            @Override
//            public int compare(TreeNode o1, TreeNode o2) {
//                return o1.no-o2.no;
//            }
//        });
//        for(TreeNode node : list){
//            System.out.println(node);
//        }
    }

    //移除某一个节点
    public void remove(HeroNode heroNode){

        //定义一个指针节点
        HeroNode temp = headNode;
        while(true){
            //找到需要移除节点的前一个heroNodePre
            if(temp.next==heroNode){
                //将heroNodePre的指针指向需要移除节点的下一个节点
                temp.next = heroNode.next ;
                break;
            }
            temp = temp.next;
        }




    }
    //修改某一个节点
    public void update(HeroNode heroNode){
        HeroNode temp = headNode;
        //判断节点是否存在
        while(true){
            if(temp == heroNode){
                break;
            }
            //节点向后移动一位
            temp = temp.next;
        }
        //找出该节点,即temp


    }

    //获取链表的节点的个数
    public int size(SingleLinkedList list){
        HeroNode tempNode = list.headNode;
        int temp = 0;
        while(true){
            if(tempNode.next == null){
                break;
            }
            temp++;
            tempNode = tempNode.next;
        }
        return temp;
    }

    //查找单链表中倒数第k个节点
    //1、首先获取链表中有效节点的个数，倒数第k个节点即顺数size-(k-1)
    public HeroNode getLastK(SingleLinkedList list,int k){
        int size = this.size(list);
        HeroNode tempNode = list.headNode;
        int temp = 0;
        while(true){
            if(temp==size-k+1){
                break;
            }
            temp++;
            tempNode = tempNode.next;
        }
        return tempNode;
    }

    //单链表的反转
    public HeroNode reversal(HeroNode headNode){

        if(headNode==null || headNode.next==null){
            return headNode;
        }

        HeroNode newHead;
        HeroNode currentNode = headNode;
        HeroNode preNode = null;
        while (true){
            HeroNode tempNode = currentNode.next;
            if(tempNode==null){
                newHead = currentNode;
                newHead.next = preNode;
                break;
            }
            currentNode.next = preNode;
            preNode = currentNode;
            currentNode = tempNode;
        }
        return newHead;

//        //声明指针节点
//        HeroNode tempNode = list.headNode;
//        SingleLinkedList reversalSingleLinkedList = new SingleLinkedList();
////        reversalSingleLinkedList.headNode = tempNode;
//        while(true){
//            if(tempNode.next==null){
//                reversalSingleLinkedList.add(tempNode);
//                //原始链表移除此节点
//                list.remove(tempNode);
//                //重置指针节点的位置
//                tempNode = list.headNode;
//                if(list.size(list)==0){
//                    break;
//                }
//            }
//            tempNode = tempNode.next;
//        }
//        return reversalSingleLinkedList;
    }

    //链表反向遍历
    //利用栈的特性，先进后出
    public void reversalPrintLink(SingleLinkedList list){
        //初始话一个栈
        Stack<HeroNode> stack = new Stack<>();
        //定义一个指针节点
        HeroNode tempNode = list.headNode;
        while(true){
            if(tempNode.next==null){
                break;
            }
            stack.push(tempNode.next);
            tempNode = tempNode.next;
        }
        if(!stack.empty()) {
            for (int i = 0; i <stack.size() ; i++) {
                System.out.println(stack.pop());
            }
        }
    }

    //合并两个有序链表，合并而成的链表也是有序的
    public SingleLinkedList mergeList(SingleLinkedList list1,SingleLinkedList list2){
        HeroNode tempNode = list2.headNode;
        while(true){
            if(tempNode.next == null){
                break;
            }
            list1.addByNo(tempNode.next);
            tempNode = tempNode.next;
        }
        return list1;
    }
}



class HeroNode{
    public int no;
    public String heroName;
    public String anotherName;
    public HeroNode next;//指向的下一个节点

    public HeroNode(int no, String heroName, String anotherName) {
        this.no = no;
        this.heroName = heroName;
        this.anotherName = anotherName;
    }


    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", heroName='" + heroName + '\'' +
                ", anotherName='" + anotherName + '\'' +
                ", next=" + next +
                '}';
    }
}