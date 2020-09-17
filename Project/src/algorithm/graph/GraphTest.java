package algorithm.graph;

import algorithm.xianxingbiao.Queue;
import algorithm.xianxingbiao.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: GraphTest
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 22:52 2020/7/31
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class GraphTest {
    public static void DepthGraphTest(){
        //准备Graph对象
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(4,6);

        G.addEdge(7,8);

        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);


        //准备深度优先搜索
        DepthFirstSearch search = new DepthFirstSearch(G, 0);
        //测试与某个顶点相通的顶点数量
        int count = search.count();
        System.out.println(count);
        //测试某个顶点与起点相通
        boolean marked1 = search.marked(5);
        System.out.println(marked1);
        boolean marked2 = search.marked(7);
        System.out.println(marked2);

    }

    public static void BreakGraphTest(){
        //准备Graph对象
        Graph G = new Graph(13);
        G.addEdge(0,5);
        G.addEdge(0,1);
        G.addEdge(0,2);
        G.addEdge(0,6);
        G.addEdge(5,3);
        G.addEdge(5,4);
        G.addEdge(3,4);
        G.addEdge(4,6);

        G.addEdge(7,8);

        G.addEdge(9,11);
        G.addEdge(9,10);
        G.addEdge(9,12);
        G.addEdge(11,12);


        //准备深度优先搜索
        BreadFirstSearch search = new BreadFirstSearch(G, 0);
        //测试与某个顶点相通的顶点数量
        int count = search.count();
        System.out.println(count);
        //测试某个顶点与起点相通
        boolean marked1 = search.marked(5);
        System.out.println(marked1);
        boolean marked2 = search.marked(7);
        System.out.println(marked2);

    }

    public static void TrafficT() throws Exception{
        //构建一个缓冲读取流BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(
                GraphTest.class.getClassLoader().getResourceAsStream("traffic.txt")));
        //读取第一行数据
        int totalNum = Integer.parseInt(br.readLine());
        //构建一个Graph对象
        Graph G = new Graph(totalNum);
        //读取第二行数据
        int roads = Integer.parseInt(br.readLine());
        //循环读取有限次（7），读取已建好的道路
        for (int i = 0; i < roads; i++) {
            String road = br.readLine();
            String[] str = road.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            //调用图addEdge方法，把边添加到图中，表示修好的道路
            G.addEdge(v, w);
        }
        //构建深度优先搜索对象。起点为9
        DepthFirstSearch search = new DepthFirstSearch(G, 9);

        //调用marked方法，判断
        System.out.println(search.marked(8));
        System.out.println(search.marked(10));

    }

    public static void DepthFirstPathsTest() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(
               GraphTest.class.getClassLoader().getResourceAsStream("road.txt")
        ));
        int totalNum = Integer.parseInt(br.readLine());
        Graph G = new Graph(totalNum);
        int roads = Integer.parseInt(br.readLine());
        for (int i = 0; i < roads; i++) {
            String road = br.readLine();
            String[] str = road.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            G.addEdge(v, w);
        }
        DepthFirstPaths depthFirstPaths = new DepthFirstPaths(G, 0);
        Stack<Integer> stack = depthFirstPaths.pathTo(4);
        StringBuilder sb = new StringBuilder();
        for (Integer integer : stack) {
            sb.append(integer + "->");
        }
        System.out.println(sb.delete(sb.length() - 2, sb.length()));

    }

    public static void TopLogicalTest(){
        //准备有向图
        Digraph digraph = new Digraph(6);
        digraph.addEdge(0,2);
        digraph.addEdge(0,3);
        digraph.addEdge(2,4);
        digraph.addEdge(3,4);
        digraph.addEdge(4,5);
        digraph.addEdge(1,3);

        //通过TopLogical对象对有向图中的顶点进行排序
        TopLogical topLogical = new TopLogical(digraph);
        //排序顶点的线性序列打印
        StringBuilder sb = new StringBuilder();
        Stack<Integer> order = topLogical.order();
        for (Integer integer : order) {
            sb.append(integer + "->");
        }
        String str = sb.toString();
        int index = str.lastIndexOf("->");
        str = str.substring(0, index);
        System.out.println(str);
    }
    public static void PrimMstTest() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(
                GraphTest.class.getClassLoader().getResourceAsStream("min_create_tree_test.txt")));
        int total = Integer.parseInt(br.readLine());
        EdgeWeightedGraph G = new EdgeWeightedGraph(total);
        int edgeNumbers = Integer.parseInt(br.readLine());
        for (int i = 0; i < edgeNumbers; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            double weight = Double.parseDouble(str[2]);
            G.addEdge(new Edge(v, w, weight));
        }

        //PrimMst primMst = new PrimMst(G);
        //Queue<Edge> edges = primMst.edges();
        KruskalMST kruskalMST = new KruskalMST(G);
        Queue<Edge> edges = kruskalMST.edges();

        for (Edge edge : edges) {
            int v = edge.either();
            int w = edge.other(v);
            double weight = edge.weight();
            System.out.println(v + "-" + w + "::" + weight);
        }
    }
    public static void DijkstraSPTest() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(
                GraphTest.class.getClassLoader().getResourceAsStream("min_route.txt")));
        int total = Integer.parseInt(br.readLine());
        EdgeWeightedDigraph G = new EdgeWeightedDigraph(total);
        int edgeNumbers = Integer.parseInt(br.readLine());
        for (int i = 0; i < edgeNumbers; i++) {
            String line = br.readLine();
            String[] str = line.split(" ");
            int v = Integer.parseInt(str[0]);
            int w = Integer.parseInt(str[1]);
            double weight = Double.parseDouble(str[2]);
            G.addEdge(new DirectedEdge(v, w, weight));
        }
        DijkstraSP dijkstraSP = new DijkstraSP(G, 0);
        System.out.println(dijkstraSP.hasPathTo(6));
        System.out.println(dijkstraSP.distTo(6));
        Queue<DirectedEdge> edges = dijkstraSP.pathTo(6);
        for (DirectedEdge edge : edges) {
            System.out.println(edge.from() + "->" + edge.to() + ":" + edge.weight());
        }
    }
    public static void main(String[] args) throws Exception{
        //DepthGraphTest();
        //BreakGraphTest();
        //TrafficT();
        //DepthFirstPathsTest();
        //TopLogicalTest();
        //PrimMstTest();
        //DijkstraSPTest();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        for (Integer integer : stack) {
            System.out.println(stack.peek());
            stack.poll();
        }
        //HashMap
        //ConcurrentHashMap

    }
}
