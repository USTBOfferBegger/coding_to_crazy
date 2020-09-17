package algorithm.graph;

import algorithm.xianxingbiao.Stack;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: TopLogical
 * @Author 李学翰
 * @Description: 拓扑排序
 * @Data: Create in 21:11 2020/8/4
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class TopLogical {
    //顶点的拓扑排序
    private Stack<Integer> order;
    //构造拓扑排序对象
    public TopLogical(Digraph G) {
        //创建一个检测又向环的对象
        DirectedCycle cycle = new DirectedCycle(G);
        //判断G图中是否有环，如果没有环，则进行顶点排序：创建一个顶点排序序列
        if(!cycle.hasCycle()){
            DepthFirstOrder depthFirstOrder = new DepthFirstOrder(G);
            order = depthFirstOrder.reversePost();
        }
    }

    //判断图G是否有环
    public boolean isCycle(){
        return order == null;
    }
    //获取拓扑序列的所有顶点
    public Stack<Integer> order(){
        return order;
    }

}
