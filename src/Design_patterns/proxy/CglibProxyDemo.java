package Design_patterns.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangsy
 * @date 2020/9/10 16:31
 *
 * Cglib代理：
 *      1、Cglib代理不需要代理对象实现接口，可以调用目标对象的子类来实现代理
 *      2、需要继承MethodIntercepted接口，并实现Intercepted方法，实现对需要增强方法的拦截
 *      （SpringAOP就是使用cglib代理）
 */
public class CglibProxyDemo {

    public static void main(String[] args) {
        CglibTeacher proxyIntance = (CglibTeacher) new CglibProxyFactory(new CglibTeacher()).getProxyIntance();

        proxyIntance.teach();
    }
}

class CglibTeacher {
    public void teach(){
        System.out.println("cglib代理...teaching");
    }

    public void fun () {
        System.out.println("fun ...");
    }
}

class CglibProxyFactory implements MethodInterceptor{

    //添加目标对象
    private Object target;

    public CglibProxyFactory(Object target) {
        this.target = target;
    }

    //cglib代理也叫子类代理，他是在内存中构建一个子类对象，从而实现对目标对象功能扩展
    public Object getProxyIntance(){
        //1、创建一个工具类
        Enhancer enhancer = new Enhancer();
        //2、设置父类
        enhancer.setSuperclass(target.getClass());
        //3、设置回调函数
        enhancer.setCallback(this);
        //4、创建子类对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理start...");
        Object invoke = null;
        System.out.println("===o==="+o.getClass());
        if(method!=null) {
            invoke = method.invoke(target, objects);
        }
        System.out.println("cglib代理end...");
        return invoke;
    }
}
