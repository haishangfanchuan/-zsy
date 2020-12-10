package Design_patterns.proxy.aopdemo;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author zhangsy
 * @date 2020/9/10 17:04
 */
public class ProxyFactory implements MethodInterceptor {

    //传入目标对象
    private Object target;
    private final IMyAspect myAspect = new MyAspect();

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //代理子类
    public Object getProxyInsance() {
        //1、声明工具类
        Enhancer enhancer = new Enhancer();
        //2、声明父类
        enhancer.setSuperclass(target.getClass());
        //3、声明回调函数
        enhancer.setCallback(this);
        //4、创建子类对象
        return enhancer.create();

    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        myAspect.before();
        Object returnValue = null;
        if(method!=null){
            returnValue = method.invoke(target,objects);
        }
        myAspect.after();
        myAspect.last();
        return returnValue;
    }
}
