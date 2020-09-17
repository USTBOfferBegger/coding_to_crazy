package day13;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 转换流提供了在字节流和字符流之间的转换
 *   Java API提供了两个转换流：
 *      InputStreamReader和OutputStreamWriter
 *   字节流中的数据都是字符时，转成字符流操作更高效。
 *             InputStreamReader
 *   用于将字节流中读取到的字节按指定字符集解码成字符。需要和
 *   InputStream“套接”。
 *   构造方法
 *              InputStreamReader(InputStream in)
 *   public InputSreamReader(InputStream in,String charsetName)
 *             如： Reader isr = new   InputStreamReader(System.in,”ISO5334_1”);
 */
public class Test131 {
    public static void main(String[] args) {
        try {
            testInputStreamReader();
            testOutputStreamReader();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 转换输入流
     * 在转换字符流的时候，设置字符集编码要与读取的文件的数据编码一致
     * @throws Exception
     */
    public static void testInputStreamReader() throws Exception{
        FileInputStream fs = new FileInputStream("D:/WorkSpace/JavaLearn/Project/src/res/tt5.txt");
        //把字节转换为字符
        InputStreamReader in = new InputStreamReader(fs, "utf-8");
        char[] c = new char[1024];
        int len = 0;
        while ((len = in.read(c)) != -1){
            System.out.println(new String(c, 0, len));
        }
        in.close();
        fs.close();

    }

    /**
     * 把字符输出流转换为字节输出流
     * @throws Exception
     */
    public static void testOutputStreamReader() throws Exception{
        FileOutputStream fo = new FileOutputStream("D:/WorkSpace/JavaLearn/Project/src/res/tt5out.txt");
        OutputStreamWriter ow = new OutputStreamWriter(fo, "utf-8");
        ow.write("你好\n我很好");
        ow.flush();
        ow.close();
        fo.close();
    }
}
