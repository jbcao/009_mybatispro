package g_relation.pojo;

/**
 * 功能
 *
 * @author caojianbang
 * @date 6.8.22 4:54 PM
 */
public class Orders {
    private Integer id;
    private String orderNumber;
    private Double orderPrice;
    //customerId是做关联使用的，可以不写

    //关联下此订单的客户信息，多方持有一方的对象
    private Customer customer;

    public Orders(Integer id, String orderNumber, Double orderPrice, Customer customer) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.customer = customer;
    }

    public Orders(String orderNumber, Double orderPrice, Customer customer) {
        this.orderNumber = orderNumber;
        this.orderPrice = orderPrice;
        this.customer = customer;
    }

    public Orders() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", orderNumber='" + orderNumber + '\'' +
                ", orderPrice=" + orderPrice +
                ", customer=" + customer +
                '}';
    }
}
