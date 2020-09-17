package algorithm.graph;

import algorithm.xianxingbiao.Queue;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: DepthFirstSearch
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 17:27 2020/7/31
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class BreadFirstSearch {
    //记录是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与S顶点相通
    private int count;
    //用来存储待搜索邻接表的点
    private Queue<Integer> waitSearch;
    //构造优先深度搜索对象，使用深度优先搜索找出G图中S顶点的所有相通的点
    public BreadFirstSearch(Graph G, int s){
        //初始化mark数组
        this.marked = new boolean[G.V()];
        //初始化跟顶点s相通的顶点的数量
        this.count = 0;

        this.waitSearch = new Queue<>();

        bfs(G, s);
    }
    //使用bfs找出G中v顶点中所有相通的点
    private void bfs(Graph G, int v){
        //把v结点标识为已经搜索
        marked[v] = true;
        //顶点V进入队列，待搜索
        waitSearch.enqueue(v);
        //通过循环，如果队列不为空，则从队列弹出一个带搜索的顶点进行搜索
        while (!waitSearch.isEmpty()){
            int m = waitSearch.dequeue();
            for(Integer w : G.adj(m)){
                if(!marked[w]){
                    bfs(G, w);
                }
            }
        }

        //相通顶点数量加1
        this.count++;
    }
    //判断w顶点与s顶点是否相通
    public boolean marked(int w){
        return marked[w];
    }
    //获取与顶点s相通的所有顶点的总数
    public int count(){
        return count;
    }
}
