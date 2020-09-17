package day11;

public class Test113 {
    public static void main(String[] args) {
        Season season1 = Season.SPRING;
        season1.showInfo();
        Season season2 = Season.SPRING;
        System.out.println(season1.equals(season2));//true
    }
}

/**
 * 枚举类
 */
enum Season implements ITest{
    //单例
    SPRING("春天", "春"),
    SUMMER("夏天", "夏"),
    AUTUMN("秋天", "秋"),
    WINTER("冬天", "冬");

    private final String name;
    private final String desc;

    private Season(String name, String desc){
        this.name = name;
        this.desc = desc;
    }

    public void showInfo(){
        System.out.println(this.name + ", " + this.desc);
    }


    @Override
    public void Te() {

    }
}

interface ITest{
    public void Te();
}
