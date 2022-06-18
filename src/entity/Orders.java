package entity;

public class Orders {
    private String OrderId;
    private String OrderDate;
    private String CustId;
    private Double Cost;


    public Orders() {
    }

    public Orders(String orderId, String orderDate, String custId, Double cost) {
        OrderId = orderId;
        OrderDate = orderDate;
        CustId = custId;
        Cost = cost;
    }

    public Orders(String orderId, String orderDate, String custId, double cost) {
        OrderId = orderId;
        OrderDate = orderDate;
        CustId = custId;
        Cost = cost;
    }

    public Orders(String custId, double cost) {
        CustId = custId;
        Cost = cost;
    }


    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getOrderDate() {
        return OrderDate;
    }

    public void setOrderDate(String orderDate) {
        OrderDate = orderDate;
    }

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }

    public Double getCost() {
        return Cost;
    }

    public void setCost(Double cost) {
        Cost = cost;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "OrderId='" + OrderId + '\'' +
                ", OrderDate='" + OrderDate + '\'' +
                ", CustId='" + CustId + '\'' +
                ", Cost=" + Cost +
                '}';
    }
}
