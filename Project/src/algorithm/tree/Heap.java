package algorithm.tree;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: Heap
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 17:31 2020/7/28
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class Heap<T extends Comparable<T>> {

    //存储堆中元素
    private T[] items;
    //记录个数
    private int N;
    public Heap(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }
    //判断堆中索引i处的元素是否小于索引j处的元素
    private boolean less(int i,int j){
        return items[i].compareTo(items[j]) < 0;
    }
    //交换堆中i索引j索引处的值
    private void exch(int i,int j){
        T temp = items[i];
        items[i] = items[j];
        items[j] = temp;
    }
    //往堆中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }
    //使用上浮算法,使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        //通过循环不断比较当前结点的值和其父结点的值，如果发现父结点的值
        //比当前结点的值小，那交换位置
        while(k > 1){
            //比较当前结点和父结点
            if(less(k / 2, k)){
                exch(k / 2, k);
            }
            k /= 2;
        }
    }

    //删除堆中最大的元素,并返回这个最大元素
    public T delMax(){
        T max = items[1];
        //交换索引1处的元素和最大索引处的元素，让完全二叉树中最右侧的元素变为临时根结点
        exch(1, N);
        //最大索引处的元素删除掉
        items[N] = null;
        //元素个数-1
        N--;
        //通过下沉法调整队，让堆重新排序
        sink(1);
        return max;
    }

    //使用下沉算法,使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        //通过循环不断对比当前k结点和其左子节点2*k以及右子结点2*k+1中较大值的元素大小，
        //如果当前结点小，则需要交换
        while(2*k <= N){
            //获取子结点中较大结点
            int max;//较大结点的索引
            if(2*k + 1 < N){
                if(less(2*k, 2*k +1)){
                    max = 2*k +1;
                }else {
                    max = 2*k;
                }
            }else {
                max = 2*k;
            }

            //比较当前结点和子结点较大结点
            if(!less(k, max)){
                break;
            }

            //交换索引处和max处的值
            exch(k, max);

            k = max;

        }
    }

}
