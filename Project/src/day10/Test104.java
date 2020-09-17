package day10;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collector;

/**
 * TreeSet
 */
public class Test104 {
    public static void main(String[] args) {
//        Set<Integer> sets = new TreeSet<Integer>();
//        //自然排序
//        sets.add(1);
//        sets.add(5);
//        sets.add(2);
//        sets.add(4);
//        sets.add(7);
//
//        System.out.println(sets);//[1, 2, 4, 5, 7]
//
//        //迭代器
//        Iterator<Integer> it = sets.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }
//
//        for (Integer i : sets) {
//            System.out.println(i);
//        }
        
        Person p1 = new Person(21,"li");
        Person p2 = new Person(24,"li1");
        Person p3 = new Person(18,"li2");
        Person p4 = new Person(5,"li3");
        
        Set<Person> set = new TreeSet<Person>(new Person());
        set.add(p1);
        set.add(p2);
        set.add(p3);
        set.add(p4);

        for (Person p : set) {
            System.out.println(p.name + "   " + p.age);
        }
        
        
    }
}

class Person implements Comparator<Person> {//Person存入TreeSet中按年龄排序
    int age;
    String name;
    public Person(){
        
    }
    public Person(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public int compare(Person o1, Person o2) {
        if(o1.age > o2.age){
            return 1;
        }else if(o1.age < o2.age){
            return -1;
        }else {
            return 0;
        }
    }
}
