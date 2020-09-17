package day10;

/**
 * 异常处理
 * try{}
 * catch(Exception e){}
 * finally{}
 *
 * 抛出异常
 */
public class Test01 {
    public static void main(String[] args) {
        int i = 0;
        try{//防止可能出现的异常,如果前面有异常就不会执行后面的
           System.out.println(1);
           System.out.println(3/i);
        }catch (Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
        }finally {//可写可不写，捕获异常中最终执行的部分，io操作和jdbc
            System.out.println(4);
        }
    }
}
