package dto;

import java.util.ArrayList;

public class OrderDTO {
    private String orderId;
    private String orderDate;
    private String custId;
    private double cost;
    private String discount;
    private ArrayList<OrderDetailDTO> detailDTOS;
    public OrderDTO(String orderId, String orderDate, String custId, ArrayList<OrderDetailDTO> detailDTOS) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.custId = custId;
        this.detailDTOS = detailDTOS;
    }

    public OrderDTO(String orderId, String orderDate, String custId, double cost, String discount, ArrayList<OrderDetailDTO> detailDTOS) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.custId = custId;
        this.cost = cost;
        this.discount = discount;
        this.detailDTOS = detailDTOS;
    }

    public OrderDTO(String orderId, String orderDate, String custId, double cost) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.custId = custId;
        this.cost = cost;
    }


    public OrderDTO() {
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }


    public ArrayList<OrderDetailDTO> getDetailDTOS() {
        return detailDTOS;
    }

    public void setDetailDTOS(ArrayList<OrderDetailDTO> detailDTOS) {
        this.detailDTOS = detailDTOS;
    }
}
