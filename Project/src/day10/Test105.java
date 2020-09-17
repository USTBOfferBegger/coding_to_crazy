package day10;

import java.util.ArrayList;
import java.util.List;

public class Test105 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println(list);
        System.out.println(list.get(0));
        List<String> lis = new ArrayList<String>();
        lis.add("1");
        lis.add("2");
        list.addAll(2,lis);
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
        list.set(0,"aChange");
        System.out.println(list);
        System.out.println(list.indexOf("c"));
        System.out.println(list.lastIndexOf("e"));
        List<String> subList = list.subList(2,4);
        System.out.println(subList);


    }
}
