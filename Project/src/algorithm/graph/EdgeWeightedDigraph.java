package algorithm.graph;

import algorithm.xianxingbiao.Queue;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: EdgeWeightedGraph
 * @Author 李学翰
 * @Description: 加权有向图
 * @Data: Create in 21:38 2020/8/4
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class EdgeWeightedDigraph {
    //记录顶点数量
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<DirectedEdge>[] adj;
    //构造一个含有V个顶点的空加权有向图
    public EdgeWeightedDigraph(int v) {
        this.V = v;
        this.E = 0;
        this.adj = new Queue[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<DirectedEdge>();
        }
    }

    //获取图中顶点的数量
    public int V(){
        return V;
    }
    //获取图中边的数量
    public int E(){
        return E;
    }
    //向加权有向图中添加一条边
    public void addEdge(DirectedEdge e){
        //需要让边e出现在e起点的邻接表中
        int v = e.from();
        adj[v].enqueue(e);
        //边的数量+1
        E++;
    }
    //获取顶点v指出的所有边
    public Queue<DirectedEdge> adj(int v){
        return adj[v];
    }
    //获取加权有向图的所有边
    public Queue<DirectedEdge> edges(){
        //创建一个队列对象，存储所有的边
        Queue<DirectedEdge> allEdges = new Queue<>();
        //遍历图中的每一个顶点，找到该顶点的邻接表，邻接表中存储了该顶点关联的每一条边
        for (int v = 0; v < V; v++) {
            //遍历v顶点的邻接表，找到每一条和v关联的边
            for (DirectedEdge edge : adj[v]) {
                allEdges.enqueue(edge);
            }
        }

        return allEdges;
    }
}
