package c_cglibproxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 功能
 *
 * @author caojianbang
 * @date 19.7.22 5:26 PM
 */
public class ProxyFactory implements MethodInterceptor {
    Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("预定时间");
        System.out.println("预定地点");
        Object returnValue=method.invoke(target,objects);
        System.out.println("结算费用");
        return returnValue;
    }

    public Object getProxyInstance(){
        Enhancer en= new Enhancer();
        en.setSuperclass(target.getClass());
        en.setCallback(this);
        return en.create();
    }
}
