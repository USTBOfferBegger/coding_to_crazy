package algorithm.Design;

/**
 * 策略模式
 */
public class Strategy {

}

class Cat implements Comparable<Cat> {
    int weight;

    public Cat(int weight, int height) {
        this.weight = weight;
        this.height = height;
    }

    int height;

    public int compareTo(Cat c1){
        if(this.height < c1.height) return 1;
        else if(this.height > c1.height) return -1;
        else return 0;
    }
}
