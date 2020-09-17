package day13;

import java.io.Serializable;

/**
 * 凡是实现Serializable接口的类都有一个表示序列化版本标识符的静态变量：
 *      private static final long serialVersionUID;
 *      serialVersionUID用来表明类的不同版本间的兼容性
 *      如果类没有显示定义这个静态变量，它的值是Java运行时环境根据类的内部细节自动生成的。若类的源代码作了修改，serialVersionUID 可能发生变化。故建议，显示声明
 *  显示定义serialVersionUID的用途
 *      希望类的不同版本对序列化兼容，因此需确保类的不同版本具有相同的serialVersionUID
 *      不希望类的不同版本对序列化兼容，因此需确保类的不同版本具有不同的serialVersionUID
 */
public class Person implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    String name;
    int age;
}
