package dto;


import java.util.Objects;

public class OrderDetailDTO {
    private String OrderId;
    private String ItemCode;
    private int OrderQty;
    private Double Price;
    private Double Discount;

    public OrderDetailDTO(String orderId, Double discount) {
        OrderId = orderId;
        Discount = discount;

    }

    public OrderDetailDTO(String orderId, String itemCode, int orderQty, Double price, Double discount) {
        setOrderId(orderId);
        setItemCode(itemCode);
        setOrderQty(orderQty);
        setPrice(price);
        setDiscount(discount);
    }

    public OrderDetailDTO(String itemCode, int orderQty, Double price, Double discount) {
        ItemCode = itemCode;
        OrderQty = orderQty;
        Price = price;
        Discount = discount;
    }


    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String itemCode, double unitPrice, int quantity, double discount) {
        ItemCode = itemCode;
        OrderQty = quantity;
        Price = unitPrice;
        Discount = discount;
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
        return Discount;
    }

    public void setDiscount(Double discount) {
        Discount = discount;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "OrderId='" + OrderId + '\'' +
                ", ItemCode='" + ItemCode + '\'' +
                ", OrderQty=" + OrderQty +
                ", Price='" + Price + '\'' +
                ", Discount=" + Discount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDetailDTO)) return false;
        OrderDetailDTO that = (OrderDetailDTO) o;
        return getOrderQty() == that.getOrderQty() &&
                Objects.equals(getOrderId(), that.getOrderId()) &&
                Objects.equals(getItemCode(), that.getItemCode()) &&
                Objects.equals(getPrice(), that.getPrice()) &&
                Objects.equals(getDiscount(), that.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getItemCode(), getOrderQty(), getPrice(), getDiscount());
    }

}
