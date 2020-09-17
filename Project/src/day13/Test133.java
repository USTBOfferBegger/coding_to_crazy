package day13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 对象流
 * ObjectInputStream和OjbectOutputSteam
 * 用于存储和读取对象的处理流。它的强大之处就是可以把Java中的对象写入到数据源中，
 * 也能把对象从数据源中还原回来。
 * 针对对象属性，不包括类
 * 序列化(Serialize)：用ObjectOutputStream类将一个Java对象写入IO流中
 * 反序列化(Deserialize)：用ObjectInputStream类从IO流中恢复该Java对象
 * ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 *  如果需要让某个对象支持序列化机制，则必须让其类是可序列化的，为了让某个类是可序列化的，该类必须实现如下两个接口之一：
 *  Serializable
 *  Externalizable
 *  序列化，反序列化对象名，包名，结构必须一致
 */
public class Test133 {
    public static void main(String[] args) {
        try {
            testSerialize();
            testDeserialize();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 对象序列化
     */
    public static void testSerialize() throws Exception{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("D:/WorkSpace/JavaLearn/Project/src/res/ttSer.txt"));
        Person p = new Person();
        p.name = "li";
        p.age = 18;
        out.writeObject(p);
        out.flush();
        out.close();
    }

    /**
     * 反序列化
     */
    public static void testDeserialize() throws Exception{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("D:/WorkSpace/JavaLearn/Project/src/res/ttSer.txt"));
        Object o = in.readObject();
        Person p = (Person) o;
        System.out.println(p.name);
        in.close();
    }
}
