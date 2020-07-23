package top.theonecyl.datastructrue.linklisted;

/**
 * 双向链表
 */
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        Hero hero1 = new Hero(1, "亚索");
        Hero hero2 = new Hero(2, "瑞文");
        Hero hero3 = new Hero(3, "李青");
        Node node1 = new Node(hero1);
        Node node2 = new Node(hero2);
        Node node3 = new Node(hero3);
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
//        doubleLinkedList.add(node1);
//        doubleLinkedList.add(node2);
//        doubleLinkedList.add(node3);
        doubleLinkedList.addByNO(node3);
        doubleLinkedList.addByNO(node1);
        doubleLinkedList.addByNO(node2);
//        doubleLinkedList.remove(node3);
        doubleLinkedList.list();
        System.out.println("*********修改后的双链表");
//        doubleLinkedList.update(new Node(new Hero(3,"盖伦"))).list();
    }
}
class DoubleLinkedList{
    private Hero hero = new Hero(-1,"");
    //定义一个起始节点
    private Node headNode = new Node(hero);

    //添加节点(添加到双链表的最后面)
    public void add(Node heroNode){
        Node tempNode = headNode;
        while(true){
            if(tempNode==heroNode){
                //表示已经添加过了，不可重复添加
                System.out.println("已经添加过了，不可重复添加!");
                break;
            }
            if(tempNode.next==null){
                break;
            }
            tempNode = tempNode.next;
        }
        //添加节点操作
        tempNode.next = heroNode;
        heroNode.before = tempNode;
    }

    //按照编号no顺序添加
    public void addByNO(Node node){
        Node tempNode = headNode;
        while(true){
            if(tempNode==node){
                //表示已经添加过了，不可重复添加
                System.out.println("已经添加过了，不可重复添加!");
                break;
            }
            if(tempNode.hero.no>node.hero.no){
                //添加到tempNode前面即可,从小到大排列
                //此时已经找到需要插入的地方，tempNode的前面
                node.before = tempNode.before.next;
                node.next = tempNode;
                tempNode.before = node;
                break;
            }
            if(tempNode.next==null){
                //已经遍历到为节点，直接添加
                //在尾节点添加
                tempNode.next = node;
                node.before = tempNode;
                break;
            }
            tempNode = tempNode.next;
        }
    }

    //删除节点
    public void remove(Node node){
        Node tempNode = headNode;
        while(true){
            if(tempNode==node){
                break;
            }
            tempNode = tempNode.next;
        }
        //移除节点操作,此时的tempNode为需要移除的节点
        tempNode.before.next = tempNode.next;
        if(tempNode.next!=null) {
            tempNode.before = tempNode.next.before;
        }
    }

    //遍历节点
    public void list(){
        //定义一个指针节点
        Node tempNode = headNode;
        //链表为空不遍历，即没有头节点
        while(true){
            if(tempNode==null){
                System.out.println("链表为空！！！");
                break;
            }
            if(tempNode.next==null){
                break;
            }
            System.out.println(tempNode.next);
            tempNode = tempNode.next;
        }
    }

    //修改节点
    public void update(Node node){
        Node tempNode = headNode;
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.headNode = headNode;
        while(true){
            //英雄编号不可修改
            if(tempNode.hero.no==node.hero.no){
                break;
            }
            tempNode = tempNode.next;
        }
        //进行修改操作
        tempNode=node;
    }
}


class Node{
    public Hero hero;
    Node before;
    Node next;

    public Node(Hero hero) {
        this.hero = hero;
    }

    @Override
    public String toString() {
        return "Node{" +
                "hero=" + hero +
                '}';
    }

//    @Override
//    public String toString() {
//        return "Node{" +
//                "hero=" + hero +
//                ", before=" + before +
//                ", next=" + next +
//                '}';
//    }
}
class Hero{
    public int no;
    public String Name;

    public Hero(int no, String name) {
        this.no = no;
        this.Name = name;
    }
    @Override
    public String toString() {
        return "Hero{" +
                "no=" + no +
                ", Name='" + Name + '\'' +
                '}';
    }
}
