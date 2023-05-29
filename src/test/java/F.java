
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
 * @date 27.7.22 12:30 PM
 */
public class F {
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
    public void getByCondition() {
        try {
            User u = new User();
//        u.setUserName("张");
            u.setBirthday(sd.parse("2001-03-10"));
            ArrayList<User> list = null;
            list = usersMapper.getByCondition(u);
            list.forEach(user -> System.out.println(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void update() {
        User user = new User();
        user.setId(1);
        user.setUserName("zhousan");

        int n = usersMapper.update(user);
    }

    @Test
    public void updateBySet() {
        try {
            User user = new User();
            user.setId(2);
            user.setBirthday(sd.parse("1996-10-06"));
            user.setUserName("zhousan");
            int n = usersMapper.updateBySet(user);
            sqlSession.commit();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByIds() {
        Integer arr[] = {2, 4, 6};
        ArrayList<User> list = usersMapper.getByIds(arr);
        list.forEach(user -> System.out.println(user));
    }

    @Test
    public void deleteBatch() {
        Integer arr[] = {2, 4, 6};
        int num = usersMapper.deleteBatch(arr);
        System.out.println(num);
        sqlSession.commit();
    }

    @Test
    public void insertBatch() {
        try {
            User u1 = new User("aa", sd.parse("2001-09-09"), "1", "china1");
            User u2 = new User("aa", sd.parse("2001-09-09"), "1", "china2");
            User u3 = new User("aa", sd.parse("2001-09-09"), "1", "china3");
            User u4 = new User("aa", sd.parse("2001-09-09"), "1", "china4");
            LinkedList<User> linkedList = new LinkedList<>();
            linkedList.add(u1);
            linkedList.add(u2);
            linkedList.add(u3);
            linkedList.add(u4);
            int num = usersMapper.insertBatch(linkedList);
            //sqlSession.commit();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByBirthday() {
        try {
            java.util.Date d1 = sd.parse("2001-01-01");
            java.util.Date d2 = sd.parse("2001-12-31");
            ArrayList<User> arrayList = usersMapper.getByBirthday(d1, d2);
            arrayList.forEach(user -> System.out.println(user));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getByMap() {
        try {
            java.util.Date d1 = sd.parse("2001-01-01");
            java.util.Date d2 = sd.parse("2001-12-31");
            Map map = new HashMap<>();
            map.put("begin", d1);
            map.put("end", d2);
            ArrayList<User> arrayList = usersMapper.getByMap(map);
            arrayList.forEach(user -> System.out.println(user));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getReturnMapOne() {
        Map map = usersMapper.getReturnMapOne(7);
        System.out.println(map);
    }
    @Test
    public void getMulMap() {
        List<Map> list= usersMapper.getMulMap();
        list.forEach(map -> System.out.println(map));
    }
    /**
     * 别名与成员变量名不一致
     */
    @Test
    public void getAll(){
        ArrayList<Book> list= bookMapper.getAll2();
        list.forEach(book -> System.out.println(book));
    }

}
