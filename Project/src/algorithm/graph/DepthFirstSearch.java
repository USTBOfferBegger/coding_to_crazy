package algorithm.graph;

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
public class DepthFirstSearch {
    //记录是否已经被搜索
    private boolean[] marked;
    //记录有多少个顶点与S顶点相通
    private int count;
    //构造优先深度搜索对象，使用深度优先搜索找出G图中S顶点的所有相通的点
    public DepthFirstSearch(Graph G, int s){
        //初始化mark数组
        this.marked = new boolean[G.V()];
        //初始化跟顶点s相通的顶点的数量
        this.count = 0;

        dfs(G, s);

    }
    //使用dfs找出G中v顶点中所有相通的点
    private void dfs(Graph G, int v){
        //把v结点标识为已经搜索
        marked[v] = true;

        for(Integer w : G.adj(v)){
            //判断当前w顶点有没有被搜索过，如果没有，则递归调用dfs方法进行深度搜索
            if(!marked[w]){
                dfs(G, w);
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
