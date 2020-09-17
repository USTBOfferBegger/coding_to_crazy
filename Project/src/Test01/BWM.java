package Test01;

/**
 *宝马产品的接口
 */
public interface BWM {
    //信息介绍
    void showInfo();
}

class BWM3 implements BWM{
    @Override
    public void showInfo() {
        System.out.println("宝马3系");
    }
}

class BWM5 implements BWM{
    @Override
    public void showInfo() {
        System.out.println("宝马5系");
    }
}

class BWM7 implements BWM{
    @Override
    public void showInfo() {
        System.out.println("宝马7系");
    }
}
