package Design_patterns.proxy.aopdemo;

/**
 * @author zhangsy
 * @date 2020/9/10 17:07
 */
public class Client {
    public static void main(String[] args) {
        Teacher insance = (Teacher) new ProxyFactory(new Teacher()).getProxyInsance();
        insance.teach();
    }
}
