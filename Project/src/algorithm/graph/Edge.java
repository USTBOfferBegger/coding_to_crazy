package algorithm.graph;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Edge
 * @Author 李学翰
 * @Description: 无向加权图
 * @Data: Create in 21:27 2020/8/4
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class Edge implements Comparable<Edge>{
    //顶点一
    private final int v;
    //顶点二
    private final int w;
    //当前边的权重
    private final double weight;
    //通过顶点v和w，以及权重weight构造一个边对象

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }

    //获取边的权重
    public double weight(){
        return weight;
    }
    //获取边上的一个点
    public int either(){
        return v;
    }
    //获取边上除了vertex外的另一个顶点
    public int other(int vertex){
        if(v == vertex){
            return w;
        }else{
            return v;
        }
    }
    //比较当前边和参数that边的权重，如果当前边权重大，则返回1，相通返回0，小返回-1
    @Override
    public int compareTo(Edge that) {
        int cmp;
        if(this.weight > that.weight){
            cmp = 1;
        }else if(this.weight < that.weight){
            cmp = -1;
        }else{
            cmp = 0;
        }
        return cmp;
    }
}
