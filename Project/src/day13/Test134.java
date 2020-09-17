package day13;

import java.io.RandomAccessFile;

/**
 * 随机读取文件
 * 直接跳到文件的任意地方读写文件
 */
public class Test134 {
    public static void main(String[] args) {
        try {
            testRandomAccessFileRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 随机读取
     */
    public static void testRandomAccessFileRead() throws Exception{
        RandomAccessFile ra = new RandomAccessFile("D:/WorkSpace/JavaLearn/Project/src/res/textCopy.txt", "r");
        ra.seek(2);
        byte[] b = new byte[1024];
        int len = 0;
        while((len = ra.read(b)) != -1){
            System.out.println(new String(b, 0, len));
        }
        ra.close();
    }
}
