import f_dynamicsql.mapper.BookMapper;
import f_dynamicsql.mapper.UsersMapper;
import f_dynamicsql.pojo.Book;
import f_dynamicsql.pojo.User;
import g_relation.mapper.CustomerMapper;
import g_relation.mapper.OrdersMapper;
import g_relation.pojo.Customer;
import g_relation.pojo.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 功能
 *
 * @author caojianbang
 * @date 6.8.22 6:57 PM
 */
public class G {
    SqlSession sqlSession;
    CustomerMapper customerMapper;
    OrdersMapper ordersMapper;

    //日期格式化刷子，很重要
    //可以讲字符创与日期格式相互转换
    SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

    @Before
    public void before() {
        try {
            //        读取核心配置文件,注意这里读取的是核心配置文件，之前写错，调试1个小时
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //        创建工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //        取出selsession
            sqlSession = factory.openSession();
            //        取出动态代理的对象，完成接口方法的调用，实则调用xml文件中相应的标签的功能
          customerMapper=sqlSession.getMapper(CustomerMapper.class);
          ordersMapper=sqlSession.getMapper(OrdersMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        sqlSession.close();
    }

@Test
    public void getById(){
    Customer customer = customerMapper.getById(3);
    System.out.println(customer);
}
@Test
    public void getOrderById(){
    Orders orders = ordersMapper.getOrderById(11);
    System.out.println(orders);
}
}
