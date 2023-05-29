import f_dynamicsql.mapper.BookMapper;
import f_dynamicsql.mapper.UsersMapper;
import f_dynamicsql.pojo.Book;
import f_dynamicsql.pojo.User;
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
 * @date 7.8.22 2:38 PM
 */
public class I {
    SqlSession sqlSession;
    UsersMapper usersMapper;
    BookMapper bookMapper;
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
            sqlSession = factory.openSession(true);
            //        取出动态代理的对象，完成接口方法的调用，实则调用xml文件中相应的标签的功能
            usersMapper = sqlSession.getMapper(UsersMapper.class);
            bookMapper=sqlSession.getMapper(BookMapper.class);
            System.out.println(usersMapper.getClass());//class com.sun.proxy.$Proxy4 是代理对象
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        sqlSession.close();
    }

    @Test
    public void getByIds() {
        //
        try {
            Integer arr[] = {2, 4, 6};
            ArrayList<User> list = usersMapper.getByIds(arr);
            System.out.println("*****************************");
            User u =new User("cjb",sd.parse("1996-10-06"),"n","baoshan");
            usersMapper.insert(u);
            sqlSession.commit();
            ArrayList<User> list2 = usersMapper.getByIds(arr);
            System.out.println(list==list2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
