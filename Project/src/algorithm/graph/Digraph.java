package algorithm.graph;

import algorithm.xianxingbiao.Queue;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Graph
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 17:06 2020/7/31
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class Digraph {
    //记录顶点数量
    private final int V;
    //记录边数量
    private int E;
    //邻接表
    private Queue<Integer>[] adj;

    //创建一个包含V个顶点但不包含边的图
    public Digraph(int v) {
        //初始化顶点数量
        this.V = v;
        //初始化边的数量
        this.E = 0;
        //初始化邻接表
        this.adj = new Queue[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new Queue<Integer>();
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
    //向图中添加一条边v->w
    public void addEdge(int v, int w){
        //只需要让顶点w出现在顶点v的邻接表中，v->其他结点
        adj[v].enqueue(w);
        E++;
    }
    //获取和顶点v相邻的所有顶点
    public Queue<Integer> adj(int v){
        return adj[v];
    }

    //该图的反向图
    private Digraph reverse(){
        //创建有向图对象
        Digraph digraph = new Digraph(V);
        for (int v = 0; v < V; v++) {
            //获取由v指出的所有边
            for(Integer w : adj[v]){
                digraph.addEdge(w, v); //w->v
            }
        }

        return null;
    }
}
