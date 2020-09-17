package algorithm.xianxingbiao;

import java.sql.SQLOutput;
import java.util.Iterator;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: SequenceList
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 17:09 2020/7/23
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class SequenceList<T> implements Iterable<T> {
    //存储元素的数组
    private T[] eles;
    //记录个数
    private int N;

    //构造方法
    public SequenceList(int capacity) {
        //初始化数组
        this.eles = (T[])new Object[capacity];
        //初始化长度
        this.N = 0;
    }

    //将一个线性表置为空表
    public void clear(){
        this.N = 0;
    }
    //判断当前线性表是否为空表
    public boolean isEmpty(){
        return this.N == 0;
    }
    //获取线性表的长度
    public int length(){
        return this.N;
    }
    //获取指定位置元素
    public T get(int i){
        return this.eles[i];
    }
    //向线性表中添加元素
    public void insert(T t){
        //先判断扩容
        if(this.N == this.eles.length){
            this.resize(2 * this.eles.length);
        }
        this.eles[this.N++] = t;
    }
    //线性表指定位置添加一个元素
    public void insert(int i, T t){
        //先判断扩容
        if(this.N == this.eles.length){
            this.resize(this.eles.length << 1);
        }
        //先把i索引处的元素依次向后移一位
        for(int index = this.N; index > i; index--){
            this.eles[index] = this.eles[index - 1];
        }
        //元素t放入i的位置
        this.eles[i] = t;
        //元素个数+1
        this.N++;
    }
    //线性表删除元素并返回
    public T remove(int i){
        //记录索引i后的值
        T current = this.eles[i];
        //索引i后的值向前移动一位
        for(int index = i; index < this.N - 1; i++){
            this.eles[index] = this.eles[index - 1];
        }
        //元素个数-1
        this.N--;

        if(this.N < this.eles.length >> 2){
            resize(this.eles.length >> 1);
        }
        return current;
    }
    //返回线性表中首次出现的指定的数据元素的位序号，若不存在，返回-1
    public int indexOf(T t){
        for(int i = 0; i < N; i++){
            if(this.eles[i].equals(t)){
                return i;
            }
        }
        return -1;
    }

    public void resize(int newSize){
        //定义一个临时数组指向原数组
        T[] temp = this.eles;
        //创建新数组
        this.eles = (T[])new Object[newSize];
        //把原数组的数据拷贝到新数组
        for(int i = 0; i < this.N; i++){
            this.eles[i] = temp[i];
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{
        private int cursor;
        public SIterator() {
            this.cursor = 0;
        }

        @Override
        public boolean hasNext() {
            return cursor < N;
        }

        @Override
        public Object next() {
            return eles[cursor++];
        }
    }
}
