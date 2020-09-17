package algorithm.graph;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: DirectedCycle
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 23:24 2020/8/3
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class DirectedCycle {
    //索引代表顶点，值表示顶点是否已经被搜索
    private boolean[] marked;
    //记录图中是否有环
    private boolean hasCycle;
    //索引代表顶点，使用栈的思想，记录当前顶点有没有已经处于正在被搜索的有向路径上
    private boolean[] onStack;
    //创建一个检测环对象，检测图G中是否含有环
    public DirectedCycle(Digraph G) {
        this.marked = new boolean[G.V()];
        this.hasCycle = false;
        this.onStack = new boolean[G.V()];

        //找到图中每一个顶点，然后让每一个顶点作为入口，调用一次dfs进行搜索
        for(int v = 0; v < G.V(); ++v){
            //如果结点还没有被搜索过
            if(!marked[v]){
                dfs(G, v);
            }
        }
    }
    //基于深度优先搜索，检测是否含有环
    private void dfs(Digraph G, int v){
        //v标识为已搜索
        marked[v] = true;
        //当前顶点入栈
        onStack[v] = true;
        //进行深度搜索
        for(Integer w : G.adj(v)){
            //判断w是否已经被搜索
            if(!marked[w]){
                dfs(G, w);
            }
            //判断当前顶点是否已经在栈中，如果已经在栈中，证明当前顶点
            //处于正在被搜索的状态，那么现在又要被搜索一次，证明有环
            if(onStack[w]){
                hasCycle = true;
                return;
            }
        }
        //把当前顶点出栈
        onStack[v] = false;
    }
    //判断图中是否有环
    public boolean hasCycle(){
        return hasCycle;
    }
}
