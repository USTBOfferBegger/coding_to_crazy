package algorithm.graph;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: DirectedEdge
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 16:32 2020/8/5
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class DirectedEdge {
    //起点
    private final int v;
    //终点
    private final int w;
    //当前边的权重
    private final double weight;

    //通过顶点v和w，以及权重weight值构造一个边对象
    public DirectedEdge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //获取变得权重值
    public double weight(){
        return weight;
    }
    //获取有向边的起点
    public int from(){
        return v;
    }
    //获取有向边的终点
    public int to(){
        return w;
    }
}
