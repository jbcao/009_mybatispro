
import a_staticproxy.Service;
import a_staticproxy.impl.Proxy;
import a_staticproxy.impl.StarLiu;
import b_jdkproxy.impl.SuperStarLiu;
import b_jdkproxy.proxy.ProxyFactory;
import org.junit.Test;

/**
 * 功能
 *
 * @author caojianbang
 * @date 15.7.22 5:20 PM
 */
public class A_StaticProxyTest {
    //    测试静态代理
    @Test
    public void testAgent() {
//有接口和实现类，必须使用接口指向实现类（规范）
        Service s = new Proxy(new StarLiu());
        s.sing();
    }

    @Test
    public void testA() {
//匿名内部实现
        Service service = new Service() {
            @Override
            public void sing() {
                System.out.println("hahha");
            }
        };
        service.sing();
    }
}
