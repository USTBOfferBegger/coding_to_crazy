package algorithm.graph;

import algorithm.tree.IndexMinPriorityQueue;
import algorithm.xianxingbiao.Queue;

import java.util.Arrays;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: PrimMst
 * @Author 李学翰
 * @Description: Prim最小生成树
 * @Data: Create in 14:02 2020/8/5
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class PrimMst {
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边
    private Edge[] edgeTo;
    //索引代表顶点，值表示当前顶点和最小生成树之间的最短边的权重
    private double[] distTo;
    //索引代表顶点，如果当前顶点已经在树中，则值为true,否则为false
    private boolean[] marked;
    //存放树中顶点与非树中顶点之间的有效横向边
    private IndexMinPriorityQueue<Double> pq;
    //根据一副加权无向图，创建最小生成树计算对象
    public PrimMst(EdgeWeightedGraph G) {
        //初始化edgeTo
        this.edgeTo = new Edge[G.V()];
        //初始化distTo
        this.distTo = new double[G.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        //初始化marked
        this.marked = new boolean[G.V()];
        //初始化pq
        pq = new IndexMinPriorityQueue<Double>(G.V());

        //默认顶点0进入到树中，但是树中只有一个顶点，因此，0顶点默认没有和其他的顶点相连，
        // 所以distTo对应位置处的值存储0.0
        this.distTo[0] = 0.0;
        pq.insert(0, 0.0);
        //遍历索引最小优选队列，拿到最小的N切边对应的顶点，把该顶点加入到最小生成树中
        while (!pq.isEmpty()){
            visit(G, pq.delMin());
        }
    }

    //将顶点v添加到最小生成树中，并且更新数据
    private void visit(EdgeWeightedGraph G, int v){
        //把顶点v添加到最小生成树中
        marked[v] = true;
        //更新数据
        for (Edge edge : G.adj(v)) {
            //获取e的另一个顶点
            int w = edge.other(v);
            //判断另外一个顶点是不是已经在树中，如果在树中，则不做处理，如果不在树中，更新数据
            if(marked[w]){
               continue;
            }
            //判断边e的权重是否小于从W顶点到树中已经存在的最小边的权重
            if(edge.weight() < distTo[w]){
                //更新数据
                edgeTo[w] = edge;
                distTo[w] = edge.weight();
                if(pq.contains(w)){
                    pq.changeItem(w, edge.weight());
                }else{
                    pq.insert(w, edge.weight());
                }
            }
        }
    }
    //获取最小生成树的所有边
    public Queue<Edge> edges(){
        Queue<Edge> allEdges = new Queue<>();
        for (int i = 0; i < edgeTo.length; i++) {
            if(edgeTo[i] != null){
                allEdges.enqueue(edgeTo[i]);
            }
        }
        return allEdges;
    }
}
