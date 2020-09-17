package algorithm.tree;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: UF
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 15:32 2020/7/31
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class UF_Tree_Weighted {
    //记录结点元素和该元素所在分组的标识
    private int[] eleAndGroup;
    //存储每一个根节点对应的树中保存的结点的个数
    private int[] size;
    //记录并查集中数据的分组个数
    private int count;
    //初始化并查集，以整数标识（0，N-1）个结点
    public UF_Tree_Weighted(int N) {
        //初始化分组和数量，默认情况下有N各数组
        this.count = N;
        //初始化eleAndGroup数组
        this.eleAndGroup = new int[N];
        //初始化eleAndGroup数组及其所在的组的标识符，让eleAndGroup数组的索引作为并查集的每个结点
        //的元素，并且让每个索引处的值（该元素所在组的标识符）就是该索引
        for (int i = 0; i < N; ++i){
            eleAndGroup[i] = i;
        }

        size = new int[N];
        //默认情况下，size中每个索引处的值都是1；
        for (int i = 0; i < size.length; i++) {
            size[i] = 1;
        }
    }
    //获取当前并查集中的数据有多少个分组
    public int count(){
        return count;
    }
    //判断并查集中元素p和元素q是否在同一分组中
    public boolean connected(int p, int q){
        return find(p) == find(q);
    }
    //元素p所在分组的标识符
    public int find(int p){
        while (true){
            if(p == eleAndGroup[p]){
                return p;
            }
            p = eleAndGroup[p];
        }
    }
    //把p元素所在分组和q元素所在分组合并
    public void union(int p, int q){
        //找到p所在分组对应的树的根节点
        int pRoot = find(p);
        //找到q所在分组对应的树的根节点
        int qRoot= find(q);
        //判断元素是否已经在一个同一分组中，如果已经在统一分组中，则结束方法
        if(pRoot == qRoot) return;

        //判断proot对应的树大还是qroot对应的树大，最终需要把较小的树合并到较大的树
        if(size[pRoot] < size[qRoot]){
            eleAndGroup[pRoot] = qRoot;
            size[qRoot] += size[pRoot];
        }else{
            eleAndGroup[qRoot] = p;
            size[pRoot] += size[qRoot];
        }


        this.count--;
    }
    //
}
