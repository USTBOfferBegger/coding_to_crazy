package face;

import java.util.Scanner;

public class DecimalCovertHEX {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int decimal = num;
        int remainder;
        char result;
        String hex = "";
        while (decimal != 0){
            remainder = decimal % 16;
            decimal = decimal / 16;

            if(remainder > 9){
                result = (char)('A' + (remainder - 10));
            }else {
                result = (char)('0' + (remainder - 0));
            }
            hex = result + hex;
        }
        System.out.println("十进制数：" + num + "转换成十六进制数为：" + hex);
    }
}
