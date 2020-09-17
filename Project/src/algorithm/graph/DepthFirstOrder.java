package algorithm.graph;

import algorithm.xianxingbiao.Stack;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: DepthFirstOrder
 * @Author 李学翰
 * @Description: 基于深度优先的顶点排序
 * @Data: Create in 20:51 2020/8/4
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class DepthFirstOrder {
    //索引代表顶点，值表示当前顶点是否已经被搜索
    private boolean[] marked;
    //使用栈，存储顶点序列
    private Stack<Integer> reversePost;
    //创建一个顶点排序对象，生成顶点线性序列
    public DepthFirstOrder(Digraph G) {
        this.marked = new boolean[G.V()];
        this.reversePost = new Stack<Integer>();
        for (int v = 0; v < G.V(); v++) {
            if(!marked[v]){
                dfs(G, v);
            }
        }
    }
    //基于深度优先搜索，生成顶点线性序列
    private void dfs(Digraph G, int v){
        marked[v] = true;
        for (Integer w : G.adj(v)) {
            if(!marked[w]){
                dfs(G, w);
            }
        }
        reversePost.push(v);
    }
    //获取顶点线性序列
    public Stack<Integer> reversePost(){
        return reversePost;
    }
}
