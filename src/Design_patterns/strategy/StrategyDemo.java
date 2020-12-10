package Design_patterns.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/11 13:20
 * <P>策略模式</P>
 */
public class StrategyDemo {
    public static void main(String[] args) {
        new PeakDuck().fly();

        //Arrays中排序使用到了策略模式
        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        };
        Integer[] a = {1,2,3};
        Arrays.sort(a,comparator);
    }
}

abstract  class Duck{
    public  FlyStrategy flyStrategy;
    public  QuackStrategy quackStrategy;

    abstract void disPlay();

    public void fly(){
        if(flyStrategy!=null)
            flyStrategy.fly();
    }
    public void setQuackStrategy(){
        if(quackStrategy!=null)
            quackStrategy.quack();
    }
}

class PeakDuck extends Duck{
    public PeakDuck() {
        flyStrategy = new BadFly();
    }

    @Override
    void disPlay() {
        System.out.println("我是北京鸭。。。");
    }
}

//策略一
interface FlyStrategy{
    void fly();
}

class BadFly implements FlyStrategy{

    @Override
    public void fly() {
        System.out.println("飞翔技术差~~");
    }
}
class GoodFly implements FlyStrategy{

    @Override
    public void fly() {
        System.out.println("飞翔技术高超~~");
    }
}

//策略二
interface QuackStrategy{
    void quack();
}

