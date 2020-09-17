package algorithm.xianxingbiao;

import java.util.Iterator;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: LinkList
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 14:08 2020/7/24
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class TwoWayLinkList<T> implements Iterable<T>{

    //记录头节点
    private Node head;
    //记录尾结点
    private Node Last;
    //记录链表长度
    private int N;
    //结点类
    private class Node{
        //存储数据
        T item;
        //下一个结点
        Node next;
        //上一个结点
        Node pre;
        public Node(T item, Node pre, Node next) {
            this.item = item;
            this.pre = pre;
            this.next = next;
        }
    }
    //创建LinkList对象
    public TwoWayLinkList(){
        //初始化头节点
        this.head = new Node(null, null,null);
        //初始化尾结点
        this.Last = null;
        //初始化元素个数
        this.N = 0;
    }
    //置空线性表
    public void clear(){
        this.head.next = null;
        this.Last = null;
        this.N = 0;
    }
    //判断线性表是否为空
    public boolean isEmpty(){
        return this.N == 0;
    }
    //获取线性表中元素的个数
    public int length(){
        return this.N;
    }
    //获取第一个元素
    public T getFirst(){
        return isEmpty() ? null : this.head.next.item;
    }

    //获取最后一个元素
    public T getLast(){
        return isEmpty() ? null : this.Last.pre.item;
    }
    //读取并返回线性表中第i个元素的值
    public T get(int i){
        //从头节点往后找i
        Node node = this.head.next;
        for(int j = 0; j < i; ++j){
            node = node.next;
        }
        return node.item;
    }
    //往线性表中添加一个值
    public void insert(T t){
        if(isEmpty()){
            //如果为空
            //创建新结点
            Node newNode = new Node(t, this.head, null);
            //让新结点为尾结点
            this.Last = newNode;
            //让头节点指向新结点
            this.head.next = this.Last;
        }else {
            //如果不为空
            //创建新结点
            Node newNode = new Node(t, this.Last, null);
            //让当前的尾结点指向新结点
            this.Last.next = newNode;
            //让新结点称为尾结点
            this.Last = newNode;

        }
        //元素个数+1
        this.N++;
    }
    //在线性表的第i个元素前插入一个元素
    public void insert(int i, T t){
        //找到i位置前一个节点
        Node pre = this.head;
        for(int index = 0; index < i; ++index){
            pre = pre.next;
        }
        //找到i位置结点
        Node curr = pre.next;
        //创建新结点，并且新结点需要指向i位置结点
        Node newNode = new Node(t, pre, curr);
        //i位置前一个节点指向新结点
        pre.next = newNode;
        curr.pre = newNode;
        //元素个数+1
        this.N++;

    }
    //删除并返回线性表中第i个元素
    public T remove(int i){
        //找到i位置的前一个结点
        Node pre = head;
        for(int index = 0; index < i; ++index){
            pre = pre.next;
        }
        //找到i位置的结点
        Node curr = pre.next;
        //找到i位置的后一个结点
        Node nextNode = curr.next;
        //前指向后
        pre.next = nextNode;
        nextNode.pre = pre;
        //元素个数-1
        this.N--;
        return curr.item;
    }
    //返回线性表中首次出现的指定的数据元素的位序号，不存在返回-1
    public int indexOf(T t){
        //从头结点开始，依次找出每一个结点，取出item与t比较
        int index = 0;
        for(Node node = this.head; node.next != null; node = node.next){
            if(t.equals(node.next.item)){
                return index;
            }
            index ++;
        }
        return -1;
    }

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node node;
        public LIterator(){
            this.node = head;
        }
        @Override
        public boolean hasNext() {
            return node.next != null;
        }

        @Override
        public Object next() {
            node = node.next;
            return node.item;
        }
    }
}

////结点类
//   private class Node{
//    //存储数据
//    T item;
//    //下一个结点
//    LinkList.Node next;
//
//    public Node(T item, LinkList.Node next) {
//        this.item = item;
//        this.next = next;
//    }
//}
//    //记录头节点
//    private LinkList.Node node;
//    //记录链表长度
//    private int N;
//    //创建LinkList对象
//    public LinkList(){
//
//    }
//    //创建LinkList对象
//    //置空线性表
//    public void clear(){
//
//    }
//    //判断线性表是否为空
//    public boolean isEmpty(){
//        return false;
//    }
//    //获取线性表中元素的个数
//    public int length(){
//        return 0;
//    }
//    //读取并返回线性表中第i个元素的值
//    public T get(int i){
//        return null;
//    }
//    //往线性表中添加一个值
//    public void insert(T t){
//
//    }
//    //在线性表的第i个元素前插入一个元素
//    public void insert(int i, T t){
//
//    }
//    //删除并返回线性表中第i个元素
//    public T remove(int i){
//        return null;
//    }
//    //返回线性表中首次出现的指定的数据元素的位序号，不存在返回-1
//    public int indexOf(T t){
//        return -1;
//    }
