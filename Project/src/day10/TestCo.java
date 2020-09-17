package day10;
/**
 * reverse(List)：反转 List 中元素的顺序
 * shuffle(List)：对 List 集合元素进行随机排序
 * sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序
 * sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序
 * swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换
 *
 * Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
 * Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
 * Object min(Collection)
 * Object min(Collection，Comparator)
 * int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
 * boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestCo {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("e");
        list.add("rf");
        list.add("qw");
        list.add("we");
        list.add("ds");
        list.add("1");
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
        System.out.println("============================================================");
        Student s1 = new Student(12,"12");
        Student s2 = new Student(16,"16");
        Student s3 = new Student(1,"1");
        Student s4 = new Student(18,"18");
        Student s5 = new Student(12,"12");
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        studentList.add(s4);
        studentList.add(s5);
        System.out.println(studentList);
        for(Student student : studentList){
            System.out.println("name:" + student.name + ", age:" + student.age);
        }
        System.out.println("============================================================");
        Collections.sort(studentList, new Student());
        for(Student student : studentList){
            System.out.println("name:" + student.name + ", age:" + student.age);
        }

    }
}

class Student implements Comparator<Student>{
    int age;
    String name;
    public Student(){

    }
    public Student(int age, String name){
        this.age = age;
        this.name = name;
    }
    @Override
    public int compare(Student o1, Student o2) {
        if(o1.age > o2.age){
            return 1;
        }else if(o1.age < o2.age){
            return -1;
        }else {
            return 0;
        }
    }
}
