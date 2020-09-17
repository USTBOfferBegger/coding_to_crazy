package algorithm.anewProject;

import java.util.Scanner;

class TireNode{
    int path;
    TireNode[] map;

    public TireNode(){
        path = 0;
        map = new TireNode[26];
    }
}

public class Tire {
    static TireNode root;
    public static void main(String[] args){
        root = new TireNode();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = sc.next();
        }

        for (int i = 0; i < n; i++) {
            insert(str[i]);
        }

        for (int i = 0; i < n; i++) {
            search(str[i]);
        }

    }

    public static void insert(String s){
        if(s == null) return;
        char[] chars = s.toCharArray();
        TireNode node = root;
        node.path++;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if(node.map[index] == null){
                node.map[index] = new TireNode();
            }
            node = node.map[index];
            node.path++;
        }
    }

    public static void search(String s){
        if(s == null) return;
        char[] chars = s.toCharArray();
        TireNode node = root;
        StringBuilder sb = new StringBuilder();
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            sb.append(chars[i]);
            if(node.map[index].path == 1){
                System.out.println(sb.toString());
                return;
            }
//            if(node.map[index] == null) return;
            node = node.map[index];
        }
    }

    public static void delete(String s){
        if(s == null) return;
        char[] chars = s.toCharArray();
        TireNode node = root;
        node.path++;
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            index = chars[i] - 'a';
            if(node.map[index].path-- == 1){
                node.map[index] = null;
                return;
            }
            node = node.map[index];
        }
    }
}

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}


