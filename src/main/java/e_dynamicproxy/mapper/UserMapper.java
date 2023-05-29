package e_dynamicproxy.mapper;

import e_dynamicproxy.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;

/**
 * 功能
 *
 * @author caojianbang
 * @date 25.7.22 6:53 PM
 */
public interface UserMapper {
//查询全部用户信息
    ArrayList<Users> getAll();
    //根据用户主键查用户
    Users getById(Integer id);
    //根据用户名模糊查询用户
    ArrayList<Users> getByName(String name);
    //优化后的模糊查询
    ArrayList<Users> getByNameGood(String name);
    //模糊地址或用户查询
    ArrayList<Users> getByNameOrAddress(@Param("columnName") String columnName,@Param("columnValue")  String columnValue);
    //用户的更新
    int update(Users u);
    //增加用户
    int insert(Users u);
    //根据主键删除用户
    int delete(Integer id);
}
