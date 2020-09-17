package algorithm.paixu;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.SimpleFormatter;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: DataChecker
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 14:17 2020/7/21
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class DataChecker {
    static int[] generateRandomArray(){
        Random random = new Random();
        int[] arr = new int[10000];

        for(int i = 0; i < arr.length; ++i){
            arr[i] = random.nextInt(10000);
        }

        return arr;
    }

    static void check(){
        int[] arr = generateRandomArray();
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        Arrays.sort(arr);
        QuickSort.sort(arr2, 0, arr2.length - 1);
        boolean same = true;
        for(int i = 0; i < arr2.length; ++i){
            if(arr[i] != arr2[i]) same = false;
        }
        System.out.println(same ? "right" : "wrong");
    }

    public static void main(String[] args) {
        //check();
        /*
        String a = "asd";
        String b = "asd";
        System.out.println(a == b);
        */


        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String time = sdf.format(date);
        System.out.println(time);

        String timeC = "2020-07-22";
        String[] sps = timeC.split("-");
        System.out.println(sps[0]);
        try {
            Date dateC = sdf.parse(timeC);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(dateC);
            System.out.println(calendar.get(Calendar.YEAR));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
