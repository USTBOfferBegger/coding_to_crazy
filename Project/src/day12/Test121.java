package day12;

/**
 * java.io.File类的使用
 * IO原理及流的分类
 * 文件流
 *     FileInputStream  /  FileOutputStream  /  FileReader  /  FileWriter
 * 缓冲流  基于内存
 *     BufferedInputStream / BufferedOutputStream /
 *     BufferedReader / BufferedWriter
 *
 * 转换流
 *      InputStreamReader  /  OutputStreamWriter
 * 标准输入/输出流
 * 打印流（了解）
 *      PrintStream  /  PrintWriter
 * 数据流（了解）
 *     DataInputStream  /  DataOutputStream
 * 对象流    ----涉及序列化、反序列化
 *    ObjectInputStream  /  ObjectOutputStream
 * 随机存取文件流
 *    RandomAccessFile
 */

import java.io.File;

/**
 * java.io.File类：文件和目录路径名的抽象表示形式，与平台无关
 * File 能新建、删除、重命名文件和目录，但 File 不能访问文件内容本身。
 * 如果需要访问文件内容本身，则需要使用输入/输出流。
 * File对象可以作为参数传递给流的构造函数
 * File类的常见构造方法：
 * public File(String pathname)
 *            以pathname为路径创建File对象，可以是绝对路径或者相对路径，
 *            如果pathname是相对路径，则默认的当前路径在系统属性user.dir中存储。
 * public File(String parent,String child)
 *             以parent为父路径，child为子路径创建File对象。
 * File的静态属性String separator存储了当前系统的路径分隔符。
 * 在UNIX中，此字段为‘/’，在Windows中，为‘\\’
 *
 * File只能操作文件本身，不能访问文件内容
 * File 类代表与平台无关的文件和目录。
 * File  能新建、删除、重命名文件和目录，但 File 不能访问文件内容本身。
 * 如果需要访问文件内容本身，则需要使用输入/输出流。
 *
 * File
 * getName 获取文件名
 * getPath 获取写入的路径 绝对/相对y
 * getAbsolutePath 获取绝对路径
 * getAbsoluteFile 返回一个用当前文件的绝对路径构建的file对象
 * getParent 返回当前文件的父级路径
 * renameTo(File name) 重命名
 * exists()  canWrite() canRead() isFile() isDirectory() lastModify() //最后修改时间  Length()
 * createNewFile()  delete()   mkdir() 创建单层目录  mkdirs()创建多级目录
 * list() 当前文件夹所有子集  listFiles() 当前文件夹所有文件
 */
public class Test121 {
    public static void main(String[] args) {

        new Test121().findFile(new File("D:/WorkSpace/JavaLearn"));
    }

    /**
     * 递归遍历文件
     */
    public void findFile(File file){
        if(file.isFile()){
            System.out.println(file.getAbsolutePath() + "是文件");
        }else {
            System.out.println(file.getAbsolutePath() + "是文件夹");
            File[] files = file.listFiles();
            if(files != null && files.length > 0)
            for(File f : files){
                findFile(f);
            }
        }
    }
}



