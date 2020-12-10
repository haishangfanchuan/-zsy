package simaite;




import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangsy
 * @date 2020/9/30 21:13
 */
public class Demo9 {

    public static void main(String[] args) {
        SMTCompany pop = new PopCompany();
        new ProxyDemo(pop).getCompany();
    }

}

interface  SMTCompany{
    void  disPlay();
}

class PopCompany implements SMTCompany{

    @Override
    public void disPlay() {
        System.out.println("气泡公司展示商品");
    }
}

class ProxyDemo{
    private SMTCompany company;

    public ProxyDemo(SMTCompany company) {
        this.company = company;
    }

    public void  getCompany(){
        Proxy.newProxyInstance(company.getClass().getClassLoader(), company.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object invoke = null;
                        System.out.println("气泡公司包装商品");
                        if(method!=null) {
                             invoke = method.invoke(company, args);
                        }
                        System.out.println("气泡公司加价商品");
                        return invoke;
                    }
        });
    }
}
