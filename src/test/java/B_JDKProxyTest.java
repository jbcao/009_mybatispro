
import b_jdkproxy.Service;
import b_jdkproxy.impl.SuperStarLiu;
import b_jdkproxy.proxy.ProxyFactory;
import org.junit.Test;

import java.sql.SQLOutput;

/**
 * 功能
 * jdk动态代理测试
 *
 * @author caojianbang
 * @date 19.7.22 12:29 AM
 */
public class B_JDKProxyTest {
    //测试jdk动态代理
    @Test
    public void testJDK() {
        ProxyFactory factory = new ProxyFactory(new SuperStarLiu());
        Service service = (Service) factory.getAgent();
        service.sing();
    }

    //    有返回值，有参数，只需要目标对象和，业务接口进行修改，代理对象不需要修改
    //测试jdk动态代理
    @Test
    public void testJDK1() {
        ProxyFactory factory = new ProxyFactory(new SuperStarLiu());
        Service service = (Service) factory.getAgent();
        String age = service.show(18);
        System.out.println(age);

    }

    @Test
    public void testJDK2() {
        ProxyFactory factory = new ProxyFactory(new SuperStarLiu());
        Service agent = (Service) factory.getAgent();
        System.out.println(agent.getClass());//class com.sun.proxy.$Proxy2 返回的是jdk动态代理的类型
        Service service = new SuperStarLiu();
        System.out.println(service.getClass());//class b_jdkproxy.impl.SuperStarLiu  接口指向的是真正的实现类
    }

    @Test
    public void testJDK3() {
        ProxyFactory factory = new ProxyFactory(new SuperStarLiu());
        //Service agent = (Service) factory.getAgent();
        //agent.one();//非接口中方法不能被增强

//       SuperStarLiu agent = (SuperStarLiu) factory.getAgent();这样也不行，功能已经被增强了，原始的类接不住，已经不是原来的类了，但是接口可以，接口可以指向所有的实现类
//       agent.one();
    }
}
