package entity;

import java.util.Date;

public class OrderDetail {
    private String OrderId;
    private String ItemCode;
    private int OrderQty;
    private Double Price;
    private Double discount;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String itemCode, int orderQty, Double price, Double Discount) {
        OrderId = orderId;
        ItemCode = itemCode;
        OrderQty = orderQty;
        Price = price;
        discount = Discount;
    }

    public OrderDetail(String orderId, Date orderDate, String custId, double Price, Double discount) {
        this.setOrderId(orderId);
        this.setPrice(Price);
        this.setDiscount(discount);

    }

    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public int getOrderQty() {
        return OrderQty;
    }

    public void setOrderQty(int orderQty) {
        OrderQty = orderQty;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    private void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "OrderId='" + OrderId + '\'' +
                ", ItemCode='" + ItemCode + '\'' +
                ", OrderQty=" + OrderQty +
                ", Price=" + Price +
                ", discount=" + discount +
                '}';
    }
}
