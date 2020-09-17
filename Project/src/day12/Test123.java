package day12;

import java.io.*;

/**
 *为了提高数据读写的速度，Java API提供了带缓冲功能的流类，在使用这些流类时，会创建一个内部缓冲区数组
 * 根据数据操作单位可以把缓冲流分为：
 *     BufferedInputStream 和 BufferedOutputStream
 *     BufferedReader 和 BufferedWriter
 * 缓冲流要“套接”在相应的节点流之上，对读写的数据提供了缓冲的功能，提高了读写的效率，同时增加了一些新的方法
 * 对于输出的缓冲流，写出的数据会先在内存中缓存，使用flush()将会使内存中的数据立刻写出
 * 缓冲流，先把数据缓冲到内存中，在内存中做io操作，基于内存的io操作比硬盘快很多倍
*/
public class Test123 {
    public static void main(String[] args) throws Exception {
        testBufferedInputStream("D:/WorkSpace/JavaLearn/Project/src/res/text.txt");
        testBufferedOutputStream("Ni hao!\nHello Word!", "D:/WorkSpace/JavaLearn/Project/src/res/textOut.txt");
        copyFile("D:/WorkSpace/JavaLearn/Project/src/res/text.txt","D:/WorkSpace/JavaLearn/Project/src/res/textCopy.txt");
    }

    /**
     * 缓冲字节输入流
     */
    public static void testBufferedInputStream(String inPut){
        try {
            //文件字节输入对象
            FileInputStream in = new FileInputStream(inPut);
            //文件字节输入流放到缓缓冲输入流
            BufferedInputStream br = new BufferedInputStream(in);
            byte[] b = new byte[10];
            int len = 0;
            while ((len = br.read(b)) != -1){
                System.out.println(new String(b, 0, len));
            }
            //关闭流，最晚开最早关
            br.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void testBufferedOutputStream(String text, String outPut) throws Exception{
        FileOutputStream out = new FileOutputStream(outPut);
        BufferedOutputStream bout = new BufferedOutputStream(out);
        bout.write(text.getBytes());
        bout.flush();
        bout.close();
        out.close();
    }

    public static void copyFile(String inPut, String outPut) throws Exception{
        BufferedInputStream br = new BufferedInputStream(new FileInputStream(inPut));
        BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(outPut));
        byte[] b = new byte[1024];
        int len = 0;
        while ((len = br.read(b)) != -1){
            bo.write(b, 0, len);
        }
        bo.flush();
        bo.close();
        br.close();
    }
}
