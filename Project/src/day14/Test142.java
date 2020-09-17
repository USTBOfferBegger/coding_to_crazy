package day14;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 *     public Constructor<T>[] getConstructors()
 *  返回此 Class 对象所表示的类的所有public构造方法。
 *     public Constructor<T>[] getDeclaredConstructors()
 *  返回此 Class 对象表示的类声明的所有构造方法 private
 *
 *  Constructor类中：
 *     取得修饰符: public int getModifiers();
 *     取得方法名称: public String getName();
 *     取得参数的类型：public Class<?>[] getParameterTypes();
 *
 *     public Method[] getDeclaredMethods()
 *   返回此Class对象所表示的类或接口的全部方法
 *       public Method[] getMethods()
 *   返回此Class对象所表示的类或接口的public的方法
 *
 *   Method类中：
 *       public Class<?> getReturnType()取得全部的返回值
 *       public Class<?>[] getParameterTypes()取得全部的参数
 *       public int getModifiers()取得修饰符
 *
 *       public Field[] getFields()
 *      返回此Class对象所表示的类或接口的public的Field。
 *      public Field[] getDeclaredFields()
 *  返回此Class对象所表示的类或接口的全部Field。
 *
 *  属性
 *  Field方法中：
 *      public int getModifiers()  以整数形式返回此Field的修饰符
 *      public Class<?> getType()  得到Field的属性类型
 *      public String getName()  返回Field的名称。
 *
 *   1.调用指定方法
 *  通过反射，调用类中的方法，通过Method类完成。步骤：
 *  1.通过Class类的getMethod(String name,Class…parameterTypes)
 *  方法取得一个Method对象，并设置此方法操作时所需要的参数类型。
 *   2.之后使用Object invoke(Object obj, Object[] args)进行调用，
 *   并向方法中传递要设置的obj对象的参数信息。
 *
 *
 *   调用指定属性
 *   Object invoke(Object obj, Object …  args)
 *  说明：
 *  1.Object 对应原方法的返回值，若原方法无返回值，此时返回null
 *  2.若原方法若为静态方法，此时形参Object obj可为null
 *  3.若原方法形参列表为空，则Object[] args为null
 *  4.若原方法声明为private,则需要在调用此invoke()方法前，
 *  显式调用方法对象的setAccessible(true)方法，将可访问private的方法。
 */
public class Test142 {
    public static void main(String[] args) {
        try {
            Class clazz = Class.forName("day14.Student");

            Class superClass = clazz.getSuperclass(); //获取父类
            System.out.println("父类" + superClass.getName());

            Class[] interfaces = clazz.getInterfaces(); //获取接口
            for(Class c : interfaces){
                System.out.println("接口"+ c.getName());
            }

            System.out.println("========================================");
            System.out.println("==公有==");
            Constructor[] constructors = clazz.getConstructors();
            for(Constructor c : constructors){
                System.out.println("构造方法名称" + c.getName());
                System.out.println("修饰符" + c.getModifiers());
                Class[] paramClass = c.getParameterTypes();
                for(Class cla : paramClass){
                    System.out.println("构造方法" + c.getName() + "的参数类型是" + cla.getName());
                }
            }

            System.out.println("========================================");
            System.out.println("==所有==");
            Constructor[] constructors1 = clazz.getDeclaredConstructors();
            for(Constructor c : constructors1){
                System.out.println("构造方法名称" + c.getName());
                System.out.println("修饰符" + c.getModifiers()); //1 public /2 private
                Class[] paramClass = c.getParameterTypes();
                for(Class cla : paramClass){
                    System.out.println("构造方法" + c.getName() + "的参数类型是" + cla.getName());
                }
            }

            System.out.println("========================================");
            System.out.println("==反射构造对象==");
            Object obj = clazz.newInstance();
            Student stu = (Student)obj;

            System.out.println("========================================");
            Constructor c = clazz.getConstructor(String.class); //指定获取有一个String参数的共有构造器
            Student stu1 = (Student)c.newInstance("第一中学"); //newInstance 实例化对象
            System.out.println(stu1.school);

            System.out.println("========================================");
            System.out.println("=通过反射机制，可以强制调用私有的方法=");
            Constructor c1 = clazz.getDeclaredConstructor(String.class, int.class);
            c1.setAccessible(true); //接触私有封装，下面可以对这个私有方法强制调用
            Student stu2 = (Student)c1.newInstance("li", 18);
            System.out.println(stu2.name + stu2.age);

            System.out.println("========================================");
            System.out.println("==获取类的所有公有方法==");
            Method[] methods = clazz.getMethods();
//            System.out.println("==获取类的所有公有(包括私有)方法==");
//            Method[] methods = clazz.getDeclaredMethods();
            for(Method method : methods){
                System.out.println("方法名" + method.getName());
                System.out.println("返回值类型" + method.getReturnType());
                System.out.println("修饰符" + method.getModifiers());

                //获取方法参数类型
                Class[] classes = method.getParameterTypes();
                if(classes != null && classes.length > 0){
                    for(Class cla : classes){
                        System.out.println("方法" + method.getName() + "的参数类型：" + cla.getName());
                    }
                }
            }

            System.out.println("========================================");
//            System.out.println("==获取类的所有公有属性==");
//            Field[] fields = clazz.getFields();
            System.out.println("==获取类的所有公有(包括私有)属性(不包括父类)==");
            Field[] fields = clazz.getDeclaredFields();
            for(Field field : fields){
                System.out.println("修饰符" + field.getModifiers());
                System.out.println("属性名称" + field.getName());
                System.out.println("属性类型" + field.getType());
            }

            System.out.println("========================================");
            System.out.println("==通过反射调用类中的指定方法==");
            Constructor con = clazz.getConstructor();//获取无参构造
            Object o = con.newInstance();
            Method m = clazz.getMethod("setSchool", String.class, String.class);
            m.invoke(o, "li", "学校"); //参数1是需要实例化的对象，参数2是调用当前方法的实际参数
            System.out.println("==私有==");
            Method m1 = clazz.getDeclaredMethod("test", String.class);
            m1.setAccessible(true);
            m1.invoke(o, "ll");
            System.out.println("==重载方法==");
            Method m2 = clazz.getMethod("setSchool", String.class);
            m2.invoke(o, "liu");
            System.out.println("==有返回值方法==");
            Method m3 = clazz.getMethod("getSchool");
            String sc = (String) m3.invoke(o);
            System.out.println(sc);

            System.out.println("========================================");
            System.out.println("==通过反射调用类中的指定属性==");
            Constructor con1 = clazz.getConstructor();
            Student stu01 = (Student)con1.newInstance();
            Field field01 = clazz.getField("school");
            field01.set(stu01, "第四中学");
            String ss = (String)field01.get(stu01);
            System.out.println(ss);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
