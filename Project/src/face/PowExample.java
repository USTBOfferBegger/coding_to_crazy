package face;

import java.math.BigInteger;

public class PowExample {
    public static void main(String[] args) {
        BigInteger my_result = new BigInteger("3");
        my_result = my_result.pow(60);
        //for (Integer i = 0; i < 60; i++) my_result = my_result.multiply(new BigInteger("3"));
        System.out.println("3的60次方等于：" + my_result);
    }
}
