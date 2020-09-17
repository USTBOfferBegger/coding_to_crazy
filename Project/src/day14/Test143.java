package day14;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * 动态代理
 * Proxy ：专门完成代理的操作类，是所有动态代理类的父类。
 * 通过此类为一个或多个接口动态地生成实现类。
 * 创建一个动态代理类所对应的Class对象
 *  static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)  直接创建一个动态代理对象
 */
public class Test143 {
    public static void main(String[] args) {
        ITestDemo iTestDemo = new TestDenoImpl();
        /**
         * 注意：一个对象想要通过Proxy.newProxyInstance方法被代理
         * 那么这个对象的类一定要有相应接口
         * 就像本例中的ITestDemo和实现类
         */
        iTestDemo.test1();
        iTestDemo.test2();

        /**
         * 需求：
         * 执行test1和test2是需要加入一些东西
         * 执行前打印test1和test2开始执行
         * 执行结束后打印test1和test2执行结束
         * 名称保持一致
         */
        InvocationHandler handler = new ProxyDemo(iTestDemo);
        /**
         * Proxy.newProxyInstance(ClassLoader,interface,h)
         * 1 代理对象的类加载器
         * 2 被代理对象的接口
         * 3 代理对象
         *
         * 返回值是被成功代理后的对象，Object类型，需要转换类型
         */
        ITestDemo testDemo = (ITestDemo) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
                iTestDemo.getClass().getInterfaces(), handler);
        testDemo.test1();
        System.out.println("-------------");
        testDemo.test2();


    }
}
