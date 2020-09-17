package algorithm.xianxingbiao;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: SymbolTable
 * @Author 李学翰
 * @Description: 符号表
 * @Data: Create in 16:15 2020/7/27
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class SymbolTable<Key, Value> {
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

    public SymbolTable() {
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
        //符号表中已经存在了键为key的键值对，那么只需要找到该结点，替换value即可
        Node n = head;
        while (n.next != null){
            //变换n
            n = n.next;
            //判断n结点存储的键值是否为key,如果是，则替换n结点的值
            if(n.key.equals(key)){
                n.value = value;
                return;
            }
       }
        //如果符号表不存在key的键值对，只需要创建新的结点，保存要插入的键值对，吧新结点插入到链表的头部
        //head.next = 新结点即可
        Node newNode = new Node(key, value, null);
        Node lastNode = head.next;
        newNode.next = lastNode;
        head.next = newNode;

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
