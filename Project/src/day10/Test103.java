package day10;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * set不可重复
 * HashSet 集合判断两个元素相等的标准：
 * 两个对象通过 equals() 方法比较相等，并且两个对象的 hashCode() 方法返回值也相等。
 * 如果两个对象通过 equals() 方法返回 true，这两个对象的 hashCode 值也应该相同。
 */
public class Test103 {
    public static void main(String[] args) {
        Set set = new HashSet();
        set.add(1);
        set.add("a");
        set.remove(1);
        System.out.println(set.contains("a"));;
        System.out.println(set);
        set.clear();
        System.out.println(set);

        //遍历
        set.add("e");
        set.add("5");
        set.add("a");
        set.add("w");
        set.add("3");
        System.out.print(set);
        //使用迭代器
        Iterator it = set.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

        //for each
        for(Object obj : set){
            System.out.println(obj);
        }
        System.out.println(set.size());

        //集合只存同类型对象，使用泛型<Object>
        Set<String> sets = new HashSet<String>();
    }
}
