package algorithm.tree;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: MaxPriorityQueue
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 15:42 2020/7/29
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class MaxPriorityQueue<T extends Comparable<T>> {

    private T[] items;
    private int N;

    public MaxPriorityQueue(int capacity) {
        this.items = (T[]) new Comparable[capacity + 1];
        this.N = 0;
    }

    //判断堆中索引i处的元素是否小于索j处的元素
    private boolean less(int i,int j){
        //最大堆
        //return items[i].compareTo(items[j]) < 0;

        //最小堆
        return items[j].compareTo(items[i]) < 0;
    }
    //交换堆中i索引j索引处的值
    private void exch(int i,int j){
        T tmp = items[i];
        items[i] = items[j];
        items[j] = tmp;
    }
    //删除队列中最大的元素,并返回这个最大元素
    public T delMax(){
        T max = items[1];
        exch(1, N);
        items[N] = null;
        N --;
        sink(1);
        return max;
    }
    //往队列中插入一个元素
    public void insert(T t){
        items[++N] = t;
        swim(N);
    }
    //使用上浮算法,使索引k处的元素能在堆中处于一个正确的位置
    private void swim(int k){
        while (k > 1){
            if(less(k/2, k)){
                exch(k/2, k);
            }
            k = k/2;
        }
    }
    //使用下沉算法,使索引k处的元素能在堆中处于一个正确的位置
    private void sink(int k){
        while (2*k <= N){
            int max;
            if(2*k + 1 <= N){
                if(less(2*k, 2*k + 1)){
                    max = 2*k + 1;
                }else {
                    max = 2*k;
                }
            }else{
                max = 2*k;
            }
            if(!less(k, max)){
                break;
            }

            exch(k, max);
            k = max;
        }
    }
    //获取队列中元素的个数
    public int size(){
        return  N;
    }
    //判断队列是否为空
    public boolean isEmpty(){
        return N == 0;
    }
}
