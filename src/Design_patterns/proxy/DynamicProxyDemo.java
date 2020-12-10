package Design_patterns.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zhangsy
 * @date 2020/9/10 15:22
 */
public class DynamicProxyDemo {
    public static void main(String[] args) {
        ITeacherDao target = (ITeacherDao) new ProxyFactory(new TeacherDao()).getTarget();
        target.teach();
    }
}

//代理工厂
class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    /**
     * public static Object newProxyInstance(ClassLoader loader,
     * Class<?>[] interfaces,
     * InvocationHandler h)
     *
     * 1、ClassLoader loader 被代理对象的指定类加载器
     * 2、Class<?>[] interfaces  被代理对象实现接口集合
     * 3、InvocationHandler h    需要执行的具体方法
     *
     * @return
     */
    public Object getTarget() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Class<?>[] interfaces = target.getClass().getInterfaces();
                        for(Class<?> iface : interfaces){
                            System.out.println(iface.getName());
                        }
                        System.out.println("====proxy==="+proxy.getClass());
                        System.out.println("====method==="+method);
                        System.out.println("JDK动态代理start...");
                        //方法执行的放回值
                        Object invoke = null;
                        if(method!=null) {
                            invoke = method.invoke(target, args);
                        }
                        System.out.println("JDK动态代理提交....");
                        return invoke;
                    }
                });
    }
}
