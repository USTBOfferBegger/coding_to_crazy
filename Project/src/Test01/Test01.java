package Test01;

/**
 * 工厂模式，改变接口和类不影响当前
 * 通过工厂把new对象隔离，通过产品的接口可以接受不同实际产品的实现类，实例的类名的改变不影响
 * 其他合作开发人员的编程
 * @author 李学翰
 */
public class Test01 {
    public static void main(String[] args) {
        BWM b3 = new BWN3Factory().productBMW();
        b3.showInfo();
        BWM b5 = new BWN5Factory().productBMW();
        b5.showInfo();
        BWM b7 = new BWN7Factory().productBMW();
        b7.showInfo();
        String[] nn = new String[]{"ssa", "dsa"};
    }
}
