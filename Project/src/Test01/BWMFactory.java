package Test01;

/**
 * 汽车工厂接口
 */
public interface BWMFactory {
    BWM productBMW();
}

class BWN3Factory implements BWMFactory{
    @Override
    public BWM productBMW() {
        System.out.println("生产宝马3系");
        return new BWM3();
    }
}

class BWN5Factory implements BWMFactory{
    @Override
    public BWM productBMW() {
        System.out.println("生产宝马5系");
        return new BWM5();
    }
}

class BWN7Factory implements BWMFactory{
    @Override
    public BWM productBMW() {
        System.out.println("生产宝马7系");
        return new BWM7();
    }
}
