package day15;

import java.text.DecimalFormat;

public class Tee {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("0.00000000");
        String re = df.format(1.0/3);
        System.out.println(re);
        float re1 = Float.parseFloat(re);
        System.out.println(re1);
        DecimalFormat decimalFormat = new DecimalFormat("0.000000");
        System.out.println(decimalFormat.format((float)100));
        System.out.println(decimalFormat.format(re1*100.0));
    }
}
