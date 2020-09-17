package day15;

/**
 * 生产者(Productor)将产品交给店员(Clerk)，而消费者(Customer)从店员处取走产品，
 * 店员一次只能持有固定数量的产品(比如:20），如果生产者试图生产更多的产品，
 * 店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；
 * 如果店中没有产品了，店员会告诉消费者等一下，如果店中有产品了再通知消费者来取走产品。
 * 这里可能出现两个问题：
 *          生产者比消费者快时，消费者会漏掉一些数据没有取到。
 *          消费者比生产者快时，消费者会取相同的数据。
 */
public class Test155 {
    public static void main(String[] args) {
        Clerk clerk = new Clerk();
        /**
         * 消费时不生产，生产时不消费
         */
        //生产者

        new Thread(() -> {
            synchronized (clerk){
                while (true){ //循环代表无限生成

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(clerk.productNum == 0){
                        System.out.println("none product");
                        while (clerk.productNum < 4){
                            clerk.productNum ++;
                            System.out.println("库存" + clerk.productNum);

                        }
                        System.out.println("产品数为：" + clerk.productNum + ",结束生产");

                        clerk.notify(); //唤醒消费者线程
                    }else {
                        System.out.println("生产完");
                        try {
                            clerk.wait(); //生产者线程等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "生产者").start();

        //消费者
        new Thread(() -> {
            synchronized (clerk){
                while (true){ //循环代表无限消费

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    if(clerk.productNum == 4){
                        System.out.println("product 4,start");
                        while (clerk.productNum > 0){
                            clerk.productNum --;
                            System.out.println("库存" + clerk.productNum);
                        }
                        System.out.println("产品数为：" + clerk.productNum + ",结束消费");

                        clerk.notify(); //唤醒生成者线程
                    }else {
                        System.out.println("消费完");
                        try {
                            clerk.wait(); //消费者线程等待
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, "消费者").start();
    }
}

class Clerk{
    public static int productNum = 0;
}