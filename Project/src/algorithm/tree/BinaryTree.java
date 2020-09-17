package algorithm.tree;

import algorithm.xianxingbiao.Queue;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: BinaryTree
 * @Author 李学翰
 * @Description: 二叉查找树
 * @Data: Create in 22:54 2020/7/27
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    private class Node{
        public Node left;
        public Node right;
        public Key key;
        public Value value;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    //记录根节点
    private Node root;
    //长度
    private int N;

    public BinaryTree() {
        this.root = null;
        this.N = 0;
    }
    //向树中插入一个键值对
    public void put(Key key, Value value){
        //1.如桌当前树中没有任何一个结点，则直接把新结点当做根结点使用
        //2.如果当前树不为空，则从根结点开始：
        //2.1如果新结点的key小于当前结点的key，则继续找当前结点的左子结点；
        // 2.2如果新结点的key大于当前结点的key，则继续找当前结点的右子结点；
        // 2.3如果新结点的key等于当前结点的key，则树中已经存在这样的结点，替换该结点的value值即可。
        root = put(root, key, value);
    }
    //给指定的树X上，添加一个键值对，并返回添加后的新树
    private Node put(Node x, Key key, Value value){
        //如果子树为空
        if(x == null){
            N++;
            return new Node(key, value, null, null);
        }
        //如果子树不为空
        //比较x结点的键和key大小
        int com = key.compareTo((Key) x.key);

        if(com < 0){
            //如果key小于×结点的键，则继续找×结点的左子树
            x.left = put(x.left, key, value);
        }else if(com > 0){
            //如果key大×结点的键，则继续找x结点的右子树
            x.right = put(x.right, key, value);
        }else {
            //如果key等于×结点的键，则替换×结点的值为为value即可
            x.value = value;
        }
        //N++;
        return x;
    }
    //根据key,从树中找到对应的值
    public Value get(Key key){
        //查询方法get实现思想：
        //从根节点开始：

        return (Value) get(root, key);
    }
    //从指定的树X中，找出key对应的值
    private Value get(Node x, Key key){
        //X树为空
        if(x == null){
            return null;
        }

        //X树不为空
        //比较x结点的键和key大小
        int com = key.compareTo((Key) x.key);
        if(com < 0){
            //1.如果要查询的key小于当前结点的key，则继续找当前结点的左子结点；
            return (Value) get(x.left, key);
        }else if(com > 0){
            //2.如果要查询的key大于当前结点的key，则继续找当前结点的右子结点；
            return (Value) get(x.right, key);
        }else {
            //3.如果要查询的key等于当前结点的key，则树中返回当前结点的value。
            return (Value) x.value;
        }

       // return null;
    }
    //根据key，删除树种对应的键值对
    public void delete(Key key){
        //删除方法delete实现思想：
        //1.找到被删除结点；
        //2.找到被删除结点右子树中的最小结点minNode
        //3.删除右子树中的最小结点
        //4.让被删除结点的左子树称为最小结点minNode的左子树，让被删除结点的右子树称为最小结点minNode的右子树
       // 5.让被删除结点的父节点指向最小结点minNode
        delete(root, key);
    }
    //删除指定树X上的键为key的键值对，并返回新树
    private Node delete(Node x, Key key){
        //X树为空
        if(x == null){
            return null;
        }
        //X树不为空
        //比较x结点的键和key大小
        int com = key.compareTo((Key) x.key);
        if(com < 0){
            //1.如果要查询的key小于当前结点的key，则继续找当前结点的左子结点；
            x.left = delete(x.left, key);
        }else if(com > 0){
            //2.如果要查询的key大于当前结点的key，则继续找当前结点的右子结点；
            x.right = delete(x.right, key);
        }else {
            //3.如果要查询的key等于当前结点的key，完成真正的删除操作，要删除X
            N--;
            if(x.right == null){
                return x.left;
            }
            if(x.left == null){
                return  x.right;
            }
            //找到右子树中最小的结点
            Node minNode = x.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }
            //删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null){
                if(n.left.left == null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }
            //x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            //x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            //让x结点的父结点指向minNode
            x = minNode;
        }

        return x;
    }
    //找出整个树中最小的键
    public Key min(){
        return min(root).key;
    }
    // 找出指定树x中最小的键所在的结点
    public Node min(Node x){
        if(x.left != null){
            return min(x.left);
        }else {
            return x;
        }
    }

    //找出整个树中最大的键
    public Key max(){
        return max(root).key;
    }
    // 找出指定树x中最大的键所在的结点
    public Node max(Node x){
        if(x.right != null){
            return max(x.right);
        }else {
            return x;
        }
    }

    //获取整个数组中所有的键
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new Queue<>();
        preErgodic(root, keys);
        return keys;
    }
    //获取指定树x的所有键，并放到keys队列中
    private void preErgodic(Node x, Queue<Key> keys){
        if(x == null){
            return;
        }
        //把x结点的key放入到keys中
        //keys.enqueue(x.key);  //前序
        //递归遍历X结点的左子树
        if(x.left != null){
            preErgodic(x.left, keys);
        }


        //keys.enqueue(x.key);  //中序

        //递归遍历X结点的右子树
        if(x.right != null){
            preErgodic(x.right, keys);
        }
        //后序
        keys.enqueue(x.key);  //中序
    }

    //层次遍历
    public Queue<Key> layerErgodic(){
        //定义两个队列，分别存储树中的键和结点
        Queue<Key> keys = new Queue<>();
        Queue<Node> nodes = new Queue<>();
        nodes.enqueue(root);
        while (!nodes.isEmpty()){
            int n = nodes.size();
            for(int i = 0; i < n; ++i){
                Node node = nodes.dequeue();
                keys.enqueue(node.key);
                if(node.left != null) nodes.enqueue(node.left);
                if(node.right != null) nodes.enqueue(node.right);
            }
        }
        return keys;
    }

    //计算整个树的最大深度
    public int maxDepth(){
        return maxDepth(root);
    }
    //计算指定树X的最大深度
    private int maxDepth(Node x){
        //1.如果根结点为空，则最大深度为0；
        //2.计算左子树的最大深度；3.计算右子树的最大深度；
        //4.当前树的最大深度=左子树的最大深度和右子树的最大深度中的较大者+1
        if(x == null){
            return 0;
        }
        return Math.max(maxDepth(x.left), maxDepth(x.right)) + 1;
    }


    //获取元素个数
    public int size(){
        return N;
    }
}
