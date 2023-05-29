package g_relation.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 功能
 *
 * @author caojianbang
 * @date 6.8.22 4:46 PM
 */
public class Customer implements Serializable {
    //customer表中三个列
    private Integer id;
    private String name;
    private Integer age;

    //该客户名下所有订单的集合，一方持有多方的集合
    private List<Orders> ordersList;

    public Customer() {
    }

    public Customer(Integer id, String name, Integer age, List<Orders> ordersList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.ordersList = ordersList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Orders> getOrdersList() {
        return ordersList;
    }

    public void setOrdersList(List<Orders> ordersList) {
        this.ordersList = ordersList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", ordersList=" + ordersList +
                '}';
    }
}
