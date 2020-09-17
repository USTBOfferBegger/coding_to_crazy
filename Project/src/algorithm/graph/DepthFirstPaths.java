package algorithm.graph;


import algorithm.xianxingbiao.Stack;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: DepthFirstPaths
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 22:51 2020/8/2
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class DepthFirstPaths {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //起点
    private int s;
    //索引代表顶点，值代表从起点s到当前顶点路径上的最后一个顶点
    private int[] edgeTo;
    //构造深度优先搜索对象，使用深度优先搜索找出G图中起点为S的所有路径
    public DepthFirstPaths(Graph G, int s) {
        //初始化marked
        this.marked = new boolean[G.V()];
        //初始化起点
        this.s = s;
        //初始化edgeTo
        this.edgeTo = new int[G.V()];
        dfs(G, s);
    }

    //使用dfs找出G图中v顶点的所有相邻顶点
    private void dfs(Graph G, int v){
        //v表示为已经搜索
        marked[v] = true;
        //遍历顶点v的邻接表，拿到每一个相邻的结点
        for(int w : G.adj(v)){
            //如果没有被搜索到
            if(!marked[w]) {
                //更新edgeTo
                edgeTo[w] = v;
                //递归
                dfs(G, w);
            }
        }

    }
    //判断v顶点与s顶点是否存在路径
    private boolean hasPathTp(int v){
        return marked[v];
    }
    //找出从起点s到顶点v的路径（就是该路径经过的顶点）
    public Stack<Integer> pathTo(int v){
        if(!hasPathTp(v)) return null;
        //创建栈对象保存所有顶点
        Stack<Integer> path = new Stack<>();
        //通过循环，从V开始一直找到起点
        for(int x = v; x != s; x = edgeTo[x]){
            path.push(x);
        }
        //把起点放入
        path.push(s);
        return path;
    }
}
