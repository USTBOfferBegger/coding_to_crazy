package day10;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Map 用于保存具有映射关系的数据，因此 Map 集合里保存着两组值，一组值用于保存 Map 里的 Key，
 * 另外一组用于保存 Map 里的 Value
 * Map 中的 key 和  value 都可以是任何引用类型的数据
 * Map 中的 Key 不允许重复，即同一个 Map 对象的任何两个 Key 通过 equals 方法比较中返回 false
 * Key 和 Value 之间存在单向一对一关系，即通过指定的 Key 总能找到唯一的，确定的 Value。
 */
public class TestMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("b", 1);
        map.put("c", 2);
        map.put("e", 2);
        System.out.println(map);
        System.out.println(map.get("b"));
        map.remove("c");//根据key移除value
        System.out.println(map);
        System.out.println(map.size());//长度
        System.out.println(map.containsKey("a"));//判断map集合是否包含指定key
        System.out.println(map.containsValue(1));//判断map集合是否包含指定value

        map.keySet();//获取所有key
        map.values();//获取所有value
        //遍历map集合,map.keySet();
        for(String key : map.keySet()){
            System.out.println("key = " + key + ", value = " + map.get(key));
        }

        //map.entrySet
        Set<Map.Entry<String, Integer>> entrys = map.entrySet();
        for (Map.Entry<String, Integer> en : entrys){
            System.out.println("key = " + en.getKey() + ", value = " + en.getValue());
        }
        System.out.println("============================");
        Map<Integer, String> map1 = new TreeMap<Integer, String>();
        map1.put(4, "a");
        map1.put(5, "a");
        map1.put(1, "a");
        map1.put(2, "a");
        map1.put(3, "a");
        System.out.println(map1);

        System.out.println("=========================");

        Map<String, String> map2 = new TreeMap<String, String>();
        map2.put("e", "a");
        map2.put("a", "a");
        map2.put("t", "a");
        map2.put("m", "a");
        map2.put("y", "a");
        System.out.println(map2);


    }
}

