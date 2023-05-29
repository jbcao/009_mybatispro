import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import e_dynamicproxy.mapper.UserMapper;
import e_dynamicproxy.pojo.Users;
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
import java.util.ArrayList;
import java.util.UUID;

/**
 * 功能
 *
 * @author caojianbang
 * @date 25.7.22 7:37 PM
 */
public class E {
    SqlSession ss;
    UserMapper um;
    //日期格式化刷子，很重要
    //可以讲字符创与日期格式相互转换
    SimpleDateFormat sd=new SimpleDateFormat("yyyy-MM-dd");
    @Before
    public void before() {
        try {
            //        读取核心配置文件,注意这里读取的是核心配置文件，之前写错，调试1个小时
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            //        创建工厂对象
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            //        取出selsession
            ss = factory.openSession();
            //        取出动态代理的对象，完成接口方法的调用，实则调用xml文件中相应的标签的功能
            um = ss.getMapper(UserMapper.class);
            System.out.println(um.getClass());//class com.sun.proxy.$Proxy4 是代理对象
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @After
    public void after() {
        ss.close();
    }

    @Test
    public void getAll() {
        ArrayList<Users> list = um.getAll();

        list.forEach(users -> System.out.println(users));
    }
    @Test
    public void update(){
        try {
            //所谓异常捕获，是对可能出现的异常进行处理，并不是说执行这段代码就会出现问题
            //是这段代码很容易出错，出错的话怎样去处理
            Users u =new Users(7,"caojian",sd.parse("2000-01-01"),"1","shanghai");
            int n=um.update(u);
            //增删改一定要手动提交
            ss.commit();
            System.out.println(n);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getById(){
        Users u = um.getById(1);
        System.out.println(u);
    }
    @Test
    public void getByName(){
        ArrayList<Users> list=um.getByName("张三");
        list.forEach(users -> System.out.println(users));
    }
    @Test
    public void getByNameOrAddress(){
        ArrayList<Users> list=um.getByNameOrAddress("username","张");
        list.forEach(users -> System.out.println(users));
    }
    @Test
    public void insert(){
        try {
            Users u= new Users("hhh",sd.parse("2001-01-09"),"3","baosan");
            int n=um.insert(u);
            System.out.println(n);
            System.out.println(u);
            ss.commit();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void delete(){
        int n=um.delete(27);
        System.out.println(n);
        ss.commit();
    }
    @Test
    public void uuid(){
        UUID u = UUID.randomUUID();
        System.out.println(u.toString().replace("-","").substring(20));
    }
}
