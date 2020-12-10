package Design_patterns;

/**
 * @author zhangsy
 * @date 2020/9/10 12:25
 */
public class Singleton {

    public static void main(String[] args) {
        System.out.println(Singleton1.INSTANCE==Singleton1.getInstance());
        System.out.println(HungrySingleton.getInstance()==HungrySingleton.getInstance());
        System.out.println(FullSingleton.getSingleton()==FullSingleton.getSingleton());
    }

}

enum  Singleton1{
    INSTANCE;

    public static Singleton1 getInstance(){
        return INSTANCE;
    }

    public void m1(){
        System.out.println("I am a enumSingleton");
    }
}

class HungrySingleton{
    private HungrySingleton(){}
    private static final HungrySingleton singleton = new HungrySingleton();
    public static HungrySingleton getInstance(){
        return singleton;
    }
}

class FullSingleton{
    private FullSingleton(){}
    private static volatile  FullSingleton singleton = null;
    private static byte[] bytes = new byte[1];
    public static FullSingleton getSingleton(){
        if(singleton==null){
            synchronized (bytes){
                if(singleton==null){
                    singleton = new FullSingleton();
                    return singleton;
                }
            }
        }
        return singleton;
    }
}
