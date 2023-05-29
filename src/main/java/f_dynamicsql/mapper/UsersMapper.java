package f_dynamicsql.mapper;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

import f_dynamicsql.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 功能
 *
 * @author caojianbang
 * @date 25.7.22 6:53 PM
 */
public interface UsersMapper {
//查询全部用户信息
    ArrayList<User> getAll();
    //根据用户主键查用户
    User getById(Integer id);
    //根据用户名模糊查询用户
    ArrayList<User> getByName(String name);
    //优化后的模糊查询
    ArrayList<User> getByNameGood(String name);
    //模糊地址或用户查询
    ArrayList<User> getByNameOrAddress(@Param("columnName") String columnName, @Param("columnValue") String columnValue);
    //用户的更新
    int update(User u);
    //增加用户
    int insert(User u);
    //根据主键删除用户
    int delete(Integer id);
    //按指定的条件进行多条件查询,用实体类封装查询条件
    ArrayList<f_dynamicsql.pojo.User> getByCondition(User users);
    //有选择地进行更新
    int updateBySet(User u);
    //查询多个置顶id的用户信息
    ArrayList<User> getByIds(Integer arr[]);
    //批量删除
    int deleteBatch(Integer arr[]);
    //批量增加
    int insertBatch(LinkedList<User> linkedList);
    //制定日期范围查询用户
    ArrayList<User> getByBirthday(java.util.Date begin, java.util.Date end);
    //传入map
    ArrayList<User> getByMap(Map m);
    //map返回一条
    Map getReturnMapOne(Integer id);
    //返回多条map
    List<Map> getMulMap();
}
