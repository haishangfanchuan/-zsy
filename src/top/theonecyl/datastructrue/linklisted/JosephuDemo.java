package top.theonecyl.datastructrue.linklisted;

/**
 * 约瑟夫环
 */
public class JosephuDemo {
    public static void main(String[] args) {
        Josephu josephu = new Josephu(5,1,2);
        josephu.add();
//        josephu.remove(1);
        josephu.list();
        System.out.println("************约瑟夫环输出队列：");
        josephu.getJosePhu();
    }
}

class Josephu{

    private int num;//节点个数
    private int k;//从第k个节点开始
    private int m;//从k节点开始向后移动m个节点

    Josephu(int num, int k, int m) {
        this.num = num;
        this.k = k;
        this.m = m;
    }

    //定义指针
    private JosePhuNode headNode = new JosePhuNode(-1);


    /**
     * 问题描述：
     *     1、约瑟夫环中有n个节点，从第k个节点开始计数m下,第m个节点出列.
     *     2、从m的下一个节点开始计数，执行 1 步骤
     */

    //添加节点,使用for循环添加num个节点
    public void add(){
        //添加的num必须要大于2
        if(num<2){
            System.out.println("添加节点数必须大于2！");
            return;
        }
        //需要一个辅助指针，指向当前节点
        JosePhuNode currentNode = null;
        //单独定义第一个节点，方便链表成环
        JosePhuNode firstNode = null;

        for (int i = 1; i <=num ; i++) {
            //创建节点
            JosePhuNode josePhuNode = new JosePhuNode(i);
            //头节点需要单独判断
            if(i==1){
                firstNode = josePhuNode;
                headNode.next = firstNode;
                //辅助指针节点指向firstNode，链表成环
                firstNode.next = firstNode;
                currentNode = firstNode;
            }else {
                //向后继续添加节点
                currentNode.next = josePhuNode;
                josePhuNode.next = firstNode;
                //辅助指针先后移动一位,到达当前添加节点位置
                currentNode = josePhuNode;
            }
        }
    }

    //遍历约瑟夫环
    public void list(){
        //获取头节点
        JosePhuNode tempNode = headNode;
        //获取头节点
        JosePhuNode firstNode = null;
        int temp=0;
        if(headNode!=null) {
            firstNode = headNode.next;
        }
        while(true){
            if(firstNode==tempNode.next && temp>1){
                break;
            }
            temp++;
            System.out.println(tempNode.next);
            tempNode = tempNode.next;
        }
    }

    //移除节点方法
    public void remove(int no){
        JosePhuNode tempNode = headNode.next;//first节点
        JosePhuNode helperNode = null;//first后面的节点
        int index = 1;
        while(true){
            //找到需要移除的节点
            if(tempNode.no == no){
                break;
            }
            if(index>num){
                System.out.println("该节点不存在！");
                break;
            }
            index++;
            helperNode = tempNode;
            tempNode = tempNode.next;
        }
        //找到需要移除节点的前一个节点,helperNode
        if(index>1) {
            helperNode.next = tempNode.next;
        }else{
            //删除节点为头节点
            JosePhuNode startNode = headNode.next.next;
            //删除的节点为原先的first头节点
            while(true){
                if(startNode.next==tempNode){
                    break;
                }
                startNode = startNode.next;
            }
            //此时helperNode为最后一个节点
            helperNode = startNode;
//            System.out.println("helperNode*****"+helperNode);
            headNode.next = tempNode.next;
            helperNode.next = headNode.next;
        }


//        int temp = 0;
//        JosePhuNode startNode = headNode;
//        while(true){
//            if(startNode.next==tempNode){
//                //如果移除的是第一个节点，需要把指针节点headNode.next向后移动一位
//                if(temp==0){
//                    headNode.next = tempNode.next;
//                    startNode.next = tempNode.next;
//                    break;
//                }
//                break;
//            }
//            temp++;
//            startNode = startNode.next;
//        }
//        if(temp>=1) {
//            startNode.next = tempNode.next;
//        }
    }

    //输出序列方法
    public void getJosePhu(){
        int start = k%num;//起始节点
        int temp = 1;
        JosePhuNode tempNode = headNode.next;//从第一个节点开始遍历
        while(true){
            //找到起始节点
            if(temp==start){
                break;
            }
            temp++;
            tempNode = tempNode.next;
        }
        //tempNode为起始节点
        int index = 1;
        int a = 0;
        while(true){
            if(index==m){
                System.out.println("****出列****"+tempNode);//输出移除的节点信息
                //环形列表移除该节点
                this.remove(tempNode.no);
                //起始节点向后移动一位
                tempNode = tempNode.next;
                //重置index
                index = 1;
                if(a>=num-1){
                    //此时链表只剩下最后一个节点
                    System.out.println("****出列****"+tempNode);
                    break;
                }
            }
            a++;
            index++;
            tempNode = tempNode.next;
        }
    }
}



class JosePhuNode{
    int no;
    JosePhuNode next;
    public JosePhuNode(int no){
        this.no = no;
    }
    @Override
    public String toString() {
        return "JosePhuNode{" +
                "no=" + no +
                '}';
    }
}
