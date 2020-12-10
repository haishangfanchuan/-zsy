package Design_patterns.adapter;

/**
 * @author zhangsy
 * @date 2020/9/10 20:25
 */
public class InterfaceAdapterDemo {

}

interface A{
    void m1();
    void m2();
    void m3();
}
abstract class B implements A{
    public void m1(){}
    public void m2(){}
    public void m3(){}
}

class C extends B{

}