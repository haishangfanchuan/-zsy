package Design_patterns.factory;

/**
 * @author zhangsy
 * @date 2020/9/10 14:06
 */
public class AbstractFactory {

    public static void main(String[] args) {
        Food food = new Restaurant().makeFood(new Rice());
        food.eat();
    }


}

interface Food{
    void eat();
}

class Rice implements Food{

    @Override
    public void eat() {
        System.out.println("吃米饭");
    }
}

class Meat implements Food{

    @Override
    public void eat() {
        System.out.println("吃肉");
    }
}

abstract class Factory{
    //工厂制作食物
    public abstract Food makeFood(Food food);
}

class Restaurant extends Factory{

    @Override
    public Food makeFood(Food food) {
        return food;
    }
}
