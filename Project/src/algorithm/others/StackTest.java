package algorithm.others;

import java.util.Stack;

/**
 * 老爹说过要用魔法打败魔法
 * *
 *
 * @ClassName: StackTest
 * @Author 李学翰
 * @Description: TODO
 * @Data: Create in 18:56 2020/7/19
 * @Version: *
 * <p>
 * 你只管开车办法由老爹来想
 */
public class StackTest {
    public static void main(String[] args) {
        //TwoStackQueue twoStackQueue = new TwoStackQueue();
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        getAndRemoveLastElement(stack);
    }

    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        System.out.println(result);
        if(stack.isEmpty()){
            return result;
        }else {
            int last = getAndRemoveLastElement(stack);
            System.out.println(last);
            stack.push(result);
            return last;
        }
    }
}

class MyStack1{
    Stack<Integer> stackData;
    Stack<Integer> stackMin;

    public MyStack1() {
        this.stackData = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int newData){
        if(this.stackMin.isEmpty()){
            this.stackMin.push(newData);
        }else{
            int popData = this.stackMin.peek();
            this.stackMin.push(Math.min(newData, popData));
        }
        this.stackData.push(newData);
    }

    public int pop(){
        if(this.stackData.isEmpty()){
            throw new RuntimeException("empty");
        }
        this.stackMin.pop();
        return this.stackData.pop();
    }

    public int getMin(){
        if(this.stackMin.isEmpty()){
            throw new RuntimeException("empty");
        }
        return this.stackMin.peek();
    }
}

/**
 * 两个栈组成的队列
 */
class TwoStackQueue{
    Stack<Integer> stackPush;
    Stack<Integer> stackPop;

    public TwoStackQueue() {
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void pushToPop(){
        if(this.stackPop.isEmpty()){
            while (!this.stackPush.isEmpty()){
                this.stackPop.push(this.stackPush.pop());
            }
        }
    }

    public void add(int newData){
        this.stackPush.push(newData);
    }

    public int poll(){
        if(this.stackPush.isEmpty() && this.stackPop.isEmpty()){
            throw new RuntimeException("empty");
        }
        pushToPop();
        return this.stackPop.pop();
    }

    public int peek(){
        if(this.stackPush.isEmpty() && this.stackPop.isEmpty()){
            throw new RuntimeException("empty");
        }
        pushToPop();
        return this.stackPop.peek();
    }
}


