package algorithm.graph;

import algorithm.tree.IndexMinPriorityQueue;
import algorithm.xianxingbiao.Queue;

import java.util.Arrays;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: DijkstraSP
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 17:33 2020/8/5
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class DijkstraSP {
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径上的最后一条边
    private DirectedEdge[] edgeTo;
    //索引代表顶点，值表示从顶点s到当前顶点的最短路径的权重
    private double[] distTo;
    //存放树中顶点与非树中顶点之间的有效横切边
    private IndexMinPriorityQueue<Double> pq;
    //根据一副加权有向图G和顶点v，创建一个计算顶点为s的最短路径树方法
    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        //初始化
        this.edgeTo = new DirectedEdge[G.V()];
        this.distTo = new double[G.V()];
        Arrays.fill(distTo, Double.POSITIVE_INFINITY);
        this.pq = new IndexMinPriorityQueue<>(G.V());
        //找到图G中以顶点s为起点的最短路径树
        //默认让顶点s进入到最短路径树中
        distTo[s] = 0.0;
        pq.insert(s, 0.0);

        //遍历pq
        while (!pq.isEmpty()){
            relax(G, pq.delMin());
        }

    }

    //松弛图G中的顶点
    private void relax(EdgeWeightedDigraph G, int v){
        for (DirectedEdge directedEdge : G.adj(v)) {
            //获取到该边的终点
            int w = directedEdge.to();
            //通过松弛，判断从起点s到顶点w的最短路径是否需要先从顶点s到顶点v，再由v到w
            if(distTo(v) + directedEdge.weight() < distTo(w)){
                distTo[w] = distTo[v] + directedEdge.weight();
                edgeTo[w] = directedEdge;

                //判断pq中是否已经存在顶点w，如果存在，则更新权重，如果不存在，则直接添加
                if(pq.contains(w)){
                    pq.changeItem(w, distTo[w]);
                }else{
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }
    //获取从顶点s到顶点v的最短路径的总权重
    public double distTo(int v){
        return distTo[v];
    }
    //判断从顶点s到顶点v是否可达
    public boolean hasPathTo(int v){
        return distTo[v] < Double.POSITIVE_INFINITY;
    }
    //查询从起点s到顶点v的最短路径中所有的边
    public Queue<DirectedEdge> pathTo(int v){
        //判断起点s到顶点v是否可达
        if(!hasPathTo(v)){
            return null;
        }
        //创建队列对象
        Queue<DirectedEdge> allEdges = new Queue<>();
        while (true){
            DirectedEdge e = edgeTo[v];
            if(e == null){
                break;
            }
            allEdges.enqueue(e);
            v = e.from();
        }
        return allEdges;
    }
}
