package day11;
/**
 * 注解
 * Annotation
 */

import java.lang.annotation.*;
import java.util.ArrayList;
import java.util.List;

public class Test114 {
    public static void main(String[] args) {
        new TestB().test1(); //过时的方法

        @SuppressWarnings({ "rawtypes", "unused"}) //抑制警告
        List l = new ArrayList();
    }
}

class TestA{
    public void test(){
    }
}

class TestB extends TestA{
    @TestAnn(id = 100, desc = "name")//属性
    String name;
    @Override
    public void test() {
        super.test();
    }

    @Deprecated
    public void test1(){} //过时的方法
}

//注解类
@Target(ElementType.FIELD)//这个注解时给其他类的属性做注解
@Retention(RetentionPolicy.RUNTIME)//定义注解类的生命周期
@Documented
@interface TestAnn{
    public int id() default 0;
    public String desc() default "";
}