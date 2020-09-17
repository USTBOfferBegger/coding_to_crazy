package day13;

import java.io.*;

/**
 * System.in和System.out分别代表了系统标准的输入和输出设备
 *   默认输入设备是键盘，输出设备是显示器
 *    System.in的类型是InputStream
 *    System.out的类型是PrintStream，其是OutputStream的子类FilterOutputStream 的子类
 */

/**
 * 打印流
 * 在整个IO包中，打印流是输出信息最方便的类。
 *   PrintStream(字节打印流)和PrintWriter(字符打印流)提供了一系列重载的print和println方法，
 *   用于多种数据类型的输出
 *      PrintStream和PrintWriter的输出不会抛出异常
 *      PrintStream和PrintWriter有自动flush功能
 *      System.out返回的是PrintStream的实例
 */

/**
 * 数据流
 * 为了方便地操作Java语言的基本数据类型的数据，可以使用数据流。
 *  数据流有两个类：(用于读取和写出基本数据类型的数据）
 *      DataInputStream 和 DataOutputStream
 *      分别“套接”在 InputStream 和 OutputStream 节点流上
 *  DataInputStream中的方法
 *            boolean readBoolean()		byte readByte()
 *            char readChar()			float readFloat()
 *            double readDouble()		short readShort()
 *            long readLong()			int readInt()
 *            String readUTF()                                 void readFully(byte[] b)
 *            DataOutputStream中的方法
 *  将上述的方法的read改为相应的write即可。
 */
public class Test2 {
    public static void main(String[] args) {
        try {
           // testSystemIn();
           // writeTXT();
            testDataOutputStream();
            testDataInputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void testSystemIn() throws Exception{
        //创建一个接收键盘输入的输入流
        InputStreamReader is = new InputStreamReader(System.in);
        //输入流放入缓冲流
        BufferedReader br = new BufferedReader(is);

        String str = ""; //定义一个临时接收的字符串

        while ((str = br.readLine()) != null) {
            System.out.println(str);
        }

        br.close();
        is.close();
    }

    /**
     * 把控制台输入的内容写到指定的TXT文件中，当接收到字符串over，就结束程序的运行
     * @throws Exception
     */
    public static void writeTXT() throws Exception{
        //创建一个接收键盘输入的输入流
        InputStreamReader is = new InputStreamReader(System.in);
        //输入流放入缓冲流
        BufferedReader br = new BufferedReader(is);

        BufferedWriter bw = new BufferedWriter(new FileWriter("D:/WorkSpace/JavaLearn/Project/src/res/writeTXT.txt"));

        String str = ""; //定义一个临时接收的字符串

        while ((str = br.readLine()) != null) {
            if(str.equals("over")){
                break;
            }
            bw.write(str);
        }
        bw.flush();
        bw.close();
        br.close();
        is.close();
    }

    /**
     * 数据流
     */
    public static void testDataOutputStream() throws Exception{
        DataOutputStream out = new DataOutputStream(new FileOutputStream("D:/WorkSpace/JavaLearn/Project/src/res/tt8.txt"));
        out.writeBoolean(true);
        out.flush();
        out.close();
    }

    public static void testDataInputStream() throws Exception{
        DataInputStream in = new DataInputStream(new FileInputStream("D:/WorkSpace/JavaLearn/Project/src/res/tt8.txt"));
        System.out.println(in.readBoolean());
        in.close();
    }
}
