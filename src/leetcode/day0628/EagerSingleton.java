package leetcode.day0628;

//饥饿模式
public final class EagerSingleton
{
    private static EagerSingleton eagerSingleton= new EagerSingleton();

    private EagerSingleton(){
    }

    public static EagerSingleton getSingleInstance(){
        return eagerSingleton;
    }
}