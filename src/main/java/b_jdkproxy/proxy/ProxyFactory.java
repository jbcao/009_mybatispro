package b_jdkproxy.proxy;

import b_jdkproxy.Service;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 功能
 *
 * @author caojianbang
 * @date 17.7.22 5:59 PM
 */
public class ProxyFactory {
    //类中成员变量设计为接口,目标对象
    Service target;

    //传入目标对象,无论是静态代理，还是动态代理，总得把目标对象给我，才能完成代理的功能
    public ProxyFactory(Service target) {
        this.target = target;
    }
//返回动态代理对象，这个工厂里可以生产多个动态代理对象,就是得到jdk的动态代理
//代理对象可以是任意类型，所以类型是object的

    public Object getAgent() {
//        ClassLoader loader, 类加载器，完成目标对象的加载，传进来的是目标对象，必须加载到jvm内存里面，才能被解析，程序运行的时候动态的获取你的类型
//        Class<?>[] interfaces,目标对象实现的所有接口，要拦截接口中的方法，jdk动态代理，代理的方法是目标对象实现的接口中的方法，目标对象本身的方法，是没办法进行代理的
//        InvocationHandler h,实现真正代理功能的接口，我们传入的是匿名内部实现
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            //        这是匿名内部实现，new InvocationHandler()，回车就能搞定
//        proxy：创建代理对象传入，是人家创建的给你的
//        method:就是目标方法sing(),show()
//        args 目标方法的参数，固定的
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                代理功能
                System.out.println("预定时间");
//                代理功能
                System.out.println("预定场地");
//                主业务功能
//                target.sing（），不可以这样写，这样写只能是调用sing方法，不能调用show方法，这样还是写死了，和静态代理就没有区别了,希望灵活的去调用方法，就得用反射技术
//                在外面调用sing show one ，这个地方就调用sing show one，灵活就灵活在这个地方
                Object obj=method.invoke(target,args);
//代理功能
                System.out.println("结算费用");
                return obj;//切记：这个返回值就是目标方法的返回值
            }
        });
    }
}
