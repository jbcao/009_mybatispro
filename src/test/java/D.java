import d_firstexample.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * 功能
 *
 * @author caojianbang
 * @date 23.7.22 10:04 PM
 */
public class D {
    @Test
    public void getAll(){
        try {
            InputStream is=Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession=factory.openSession();
            List<Student> list =sqlSession.selectList("cjb.getAll");
            list.forEach(student -> System.out.println(student));
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void getById(){
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();
            Student s = sqlSession.selectOne("cjb.getOrderById",1);
            System.out.println(s);
            sqlSession.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Test
    public void getByName(){
        try{
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();
            List<Student> students = sqlSession.selectList("cjb.getByName","张");
            students.forEach(student -> System.out.println(student));
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void insert(){
        try{
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();
            int num=sqlSession.insert("cjb.insert",new Student("叶问","ipman@126.com",72));
            System.out.println(num);
//            切记，增删改必须要手动提交
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void delete(){
        try{
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();
            int num=sqlSession.delete("cjb.delete",7);
            System.out.println(num);
//            切记，增删改必须要手动提交
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void update(){
        try{
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = factory.openSession();
            int num=sqlSession.update("cjb.update",new Student(1,"叶问","1233@188.com",90));
            System.out.println(num);
//            切记，增删改必须要手动提交
            sqlSession.commit();
            sqlSession.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
