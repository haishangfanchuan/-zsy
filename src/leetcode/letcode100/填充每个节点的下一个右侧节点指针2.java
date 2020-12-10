package leetcode.letcode100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangsy
 * @date 2020/9/28 12:46
 */
public class 填充每个节点的下一个右侧节点指针2 {

    public static void main(String[] args) {
        Node root = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node7 = new Node(7);
        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.right = node7;

        System.out.println(connect(root));

    }

    public static Node connect(Node root) {
        if(root == null) return null;
        root.next = null;
        Deque<Node> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            Deque<Node> tempDeque = new LinkedList<>();
            for (int i = 0; i <= deque.size(); i++) {
                Node pop = deque.pop();
                try{
                    pop.next = deque.getFirst();
                }catch (Exception e){
                    pop.next = null;
                }
                if(pop.left!=null) tempDeque.add(pop.left);
                if(pop.right!=null) tempDeque.add(pop.right);
            }
            while (!tempDeque.isEmpty()){
                deque.add(tempDeque.pop());
            }
        }
        return root;
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                ", next=" + next +
                '}';
    }
}
