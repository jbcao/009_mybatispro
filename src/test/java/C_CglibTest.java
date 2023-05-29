import c_cglibproxy.ProxyFactory;
import c_cglibproxy.SubSuperStarLiu;
import c_cglibproxy.SuperStarLiu;
import org.junit.Test;

/**
 * 功能
 *
 * @author caojianbang
 * @date 19.7.22 11:12 AM
 */
public class C_CglibTest {
    //    记住，只要是子类重写父类方法，无论在什么场合，你张嘴来的都是重写后的内容，这就是多态的一个特点，所以得用父类指向子类
//    同样的要用接口指向实现类
    @Test
    public void testAgent() {
//        这就是一个简版的cglib动态代理，如果是使用cglib动态代理，
//        如果是系统提供的，SubSuperStarLiu就不是自己写了，系统会自动给你生成，生成有点复杂
        SuperStarLiu liu = new SubSuperStarLiu();
        liu.sing();
    }

    //
    @Test
    public void testCglib() {
        SuperStarLiu proxy= (SuperStarLiu) new ProxyFactory(new SuperStarLiu()).getProxyInstance();
        proxy.sing();
    }
}
