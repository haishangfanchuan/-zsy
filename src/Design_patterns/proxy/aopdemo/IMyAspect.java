package Design_patterns.proxy.aopdemo;

/**
 * @author zhangsy
 * @date 2020/9/10 17:02
 */
interface IMyAspect {
    void before();
    void after();
    void last();
}

class MyAspect implements IMyAspect{

    @Override
    public void before() {
        System.out.println("do something before...");
    }

    @Override
    public void after() {
        System.out.println("do something after...");
    }

    @Override
    public void last() {
        System.out.println("do something last...");
    }
}
