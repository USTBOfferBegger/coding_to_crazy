package day12;

import java.io.*;

/**
 * 文件字节/字符流
 */
public class Test122 {
    public static void main(String[] args) {
        //testFileInputStream();
        //TestFileOutputStream();
        //copyFile("D:/WorkSpace/JavaLearn/Project/src/res/1.txt",
         //       "D:/WorkSpace/JavaLearn/Project/src/res/move/out.txt");
        testFileReader("D:/WorkSpace/JavaLearn/Project/src/res/1.txt");
        testFileWrite("LiLiXueHan", "D:/WorkSpace/JavaLearn/Project/src/res/1out.txt");
    }


    /**
     * 文件字节输入流
     */
    public static void testFileInputStream(){
        try {
            FileInputStream fileInputStream = new FileInputStream("D:/WorkSpace/JavaLearn/Project/src/res/1.txt");
            byte[] b = new byte[10]; //设置一个数组接收读取的文件内容
            //fileInputStream.read(b);
            int len = 0;
            //.read()方法有一个返回值（数据的长度），读到最后一个数据还会向后读，
            // 意味着read()返回-1时文件读取完毕
            while ((len = fileInputStream.read(b)) != -1){
                System.out.println(new String(b, 0, len));
                //new String(b, 0, len) 1缓冲数据的数组 2从哪个位置开始转化 3 总共转换的个数
            }

            fileInputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件字节输出流
     */
    public static void TestFileOutputStream(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("D:/WorkSpace/JavaLearn/Project/src/res/out.txt");
            String str = "lixuehan";
            fileOutputStream.write(str.getBytes()); //写内存
            fileOutputStream.flush();//内存刷新到硬盘
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String input, String output){
        try {
            FileInputStream fileInputStream = new FileInputStream(input);
            FileOutputStream fileOutputStream = new FileOutputStream(output);
            byte[] b = new byte[10]; //设置一个数组接收读取的文件内容
            int len = 0;
            while ((len = fileInputStream.read(b)) != -1){
                fileOutputStream.write(b, 0, len);
                //1写的缓冲数组 2 从数组哪个位置开始 3获取数组的总长度
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            fileInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件字符输入流FileReader
     * 只适合文件是字符的
     */
    public static void testFileReader(String inPath){
        try{
            FileReader fr = new FileReader(inPath);
            char[] c = new char[10];
            int len = 0;
            while ((len = fr.read(c)) != -1){
                System.out.println(new String(c, 0, len));
            }
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 写文件，同名则覆盖
     * @param text
     * @param outPath
     */
    public static void testFileWrite(String text, String outPath){
        try{
            FileWriter fw = new FileWriter(outPath);
            fw.write(text);
            fw.flush();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
