package algorithm.xianxingbiao;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: SymbolTable
 * @Author 李学翰
 * @Description: 有序符号表
 * @Data: Create in 16:15 2020/7/27
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class OrderSymbolTable<Key extends Comparable<Key>, Value> {
    private class Node<Key, Value>{
        //存储键
        public Key key;
        //存储值
        public Value value;
        //存储下一个结点
        public Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
    //首结点
    private Node head;
    //记录符号中键值对的个数
    private int N;

    //创建对象

    public OrderSymbolTable() {
        this.head = new Node(null, null, null);
        this.N = 0;
    }

    //根据键key找到对应的值
    public Value get(Key key){
        //找到键值，删除
        Node n = head;
        while (n.next != null){
            n = n.next;
            if(n.key.equals(key)){
                return (Value) n.value;
            }
        }
        return null;
    }
    //向符号中插入一个键值对
    public void put(Key key, Value value){
        //定义两个node变量，记录当前结点和当前变量的上一个结点
        Node curr = head.next;
        Node pre = head;
        while (curr != null && key.compareTo((Key) curr.key) > 0){
            //变换当前结点和前一个结点即可
            pre.next = curr;
            curr = curr.next;
            //
        }
        //如果当前结点curr的键和要插入的key一样，则替换
        if(curr != null && key.compareTo((Key) curr.key) == 0){
            curr.value = value;
            return;
        }
        //如果当前结点curr的键和要插入的key不一样，则把新的结点插入curr之前
        Node newNode = new Node(key, value, curr);
        pre.next = newNode;
        N++;

    }
    //删除键为key的键值对
    public void delete(Key key){
        //找到键值，删除
        Node n = head;
        while (n.next != null){
            //判断n结点的下一个结点的键值是否为key，如果是，就删除该结点
            if(n.next.key.equals(key)){
                n.next = n.next.next;
                N--;
                return;
            }
            n = n.next;
        }
    }
    //获取符号表的大小
    public int size(){
        return N;
    }
}
