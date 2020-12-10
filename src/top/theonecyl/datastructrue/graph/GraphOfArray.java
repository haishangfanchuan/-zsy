package top.theonecyl.datastructrue.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用二维矩阵表示图
 */
public class GraphOfArray {

    private List<String> peakNodes;//图的顶点
    private int[][] edges;//图的路径，1表示通路，0表示不通
    private int access;//图中通路的数量

    private static List<String> list = new ArrayList<>();
    private static int temp = 0;

    public static void main(String[] args) {
        GraphOfArray graph = new GraphOfArray(5);
        String[] peakNodes = {"A","B","C","D","E"};
        for (int i = 0; i <peakNodes.length ; i++) {
            graph.addPeakNode(peakNodes[i]);
        }
        graph.addEdges(0,1,1);
//        graph.addEdges(1,2,1);
        graph.addEdges(1,4,1);
        graph.addEdges(1,3,1);

        graph.printGraph();

        System.out.println("通路的数量为："+graph.edgesCount());

        System.out.println("A和C之间是否为通路:"+graph.isAccessOfDfs("A","C"));
    }

    private GraphOfArray(int n){
        peakNodes = new ArrayList<>(n);
        edges = new int[n][n];
        access = 0;
    }

    //添加线路
    private void addEdges(int p1,int p2 ,int weight){
        edges[p1][p2] = weight;
        edges[p2][p1] = weight;
        access++;
    }

    //添加顶点
    private void addPeakNode(String string){
        peakNodes.add(string);
    }

    //判断两点之间是否为通路(深度优先遍历)
    private boolean isAccessOfDfs(String peakNode1,String peakNode2){
        int index1 = 0;
        int index2 = 0;
        //找到peakNode1对应的下标
        for (int i = 0; i < peakNodes.size(); i++) {
            if (peakNode1.equals(peakNodes.get(i))) {
                index1 = i;
            }
            if(peakNode2.equals(peakNodes.get(i))){
                break;
            }
            if (i == peakNodes.size() - 1) {
                //不存在此顶点
                throw new RuntimeException("顶点不存在！");
            }
        }
        //在第index1  行寻找与 peakNode1 相连的点     禁止回去
        for (int i = 0; i < edges.length; i++) {
            if(edges[i][peakNodes.indexOf(peakNode2)]==1 || edges[peakNodes.indexOf(peakNode2)][i]==1){
                return true;
            }
            if ((edges[index1][i] == 1 || edges[i][index1]==1) && !list.contains(peakNodes.get(i))) {
                list.add(peakNode1);
                //找到此顶点
                index2 = i;
                break;
            }
            if(i==edges.length-1){
                return false;
            }
        }
        if((edges[index1][index2]==1 || edges[index2][index1]==1) && peakNodes.get(index2).equals(peakNode2)){
            return true;
        }else {
            return isAccessOfDfs(peakNodes.get(index2), peakNode2);
        }
    }

    //两个顶点是否是同路（广度优先）
    public boolean isAccessOfBfs(String peakNode1,String peakNode2){
        return false;
    }

    //返回通路个数量
    private int edgesCount(){
        return access;
    }

    //打印图
    private void printGraph(){
        for (String peakNode : peakNodes) {
            if(peakNode.equals("A")){
                System.out.print("   "+peakNode+" ");
            }else {
                System.out.print( " "+peakNode+" ");
            }

        }
        System.out.println();
        for (int i = 0; i <edges.length ; i++) {
            for (int j = 0; j < edges[0].length; j++) {
                if(j==0) {
                    System.out.print(peakNodes.get(i)+"  " + edges[i][j] + " ");
                }else {
                    System.out.print(" " + edges[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
