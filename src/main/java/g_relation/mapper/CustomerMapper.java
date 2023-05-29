package g_relation.mapper;

import g_relation.pojo.Customer;

/**
 * 功能
 *
 * @author caojianbang
 * @date 6.8.22 5:09 PM
 */
public interface CustomerMapper {
    //根据客户的id查询客户所有信息，包括名下所有订单
    Customer getById(Integer id);
}
