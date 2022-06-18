package dto;


import java.util.Objects;

/* getting details using join query */

public class CustomDTO {

    private String OrderId;
    private String date;
    private int NoOfOrders;
    private int SoldQuantity;
    private double income;
    private String name;
    private String CustId;
    private double cost;

    public CustomDTO(String name, String custId, double cost) {
        this.name = name;
        CustId = custId;
        this.cost = cost;
    }

    public CustomDTO(String orderId, String date, int noOfOrders, int soldQuantity, double income) {
        setOrderId(orderId);
        this.setDate(date);
        setNoOfOrders(noOfOrders);
        setSoldQuantity(soldQuantity);
        this.setIncome(income);
    }

    public CustomDTO(String date, int soldQuantity) {
        this.date = date;
        SoldQuantity = soldQuantity;
    }

    public CustomDTO(String date, int noOfOrders, double income) {
        this.setDate(date);
        setNoOfOrders(noOfOrders);
        this.setIncome(income);
    }

    public CustomDTO(String date, int noOfOrders, int soldQuantity, double income) {

        this.date = date;
        NoOfOrders = noOfOrders;
        SoldQuantity = soldQuantity;
        this.income = income;
    }

    public CustomDTO() {
    }

    public CustomDTO(String customerId, String customerName) {
        this.CustId = customerId;
        this.name = customerName;
    }

    public CustomDTO(String custId, Double cost) {
        this.CustId = custId;
        this.cost = cost;
    }


    public String getOrderId() {
        return OrderId;
    }

    public void setOrderId(String orderId) {
        OrderId = orderId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNoOfOrders() {
        return NoOfOrders;
    }

    public void setNoOfOrders(int noOfOrders) {
        NoOfOrders = noOfOrders;
    }

    public int getSoldQuantity() {
        return SoldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        SoldQuantity = soldQuantity;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustId() {
        return CustId;
    }

    public void setCustId(String custId) {
        CustId = custId;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "DailyTm{" +
                "OrderId='" + OrderId + '\'' +
                ", date='" + date + '\'' +
                ", NoOfOrders=" + NoOfOrders +
                ", SoldQuantity=" + SoldQuantity +
                ", income=" + income +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomDTO)) return false;
        CustomDTO customDTO = (CustomDTO) o;
        return getNoOfOrders() == customDTO.getNoOfOrders() &&
                getSoldQuantity() == customDTO.getSoldQuantity() &&
                Double.compare(customDTO.getIncome(), getIncome()) == 0 &&
                Double.compare(customDTO.getCost(), getCost()) == 0 &&
                Objects.equals(getOrderId(), customDTO.getOrderId()) &&
                Objects.equals(getDate(), customDTO.getDate()) &&
                Objects.equals(getName(), customDTO.getName()) &&
                Objects.equals(getCustId(), customDTO.getCustId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getDate(), getNoOfOrders(), getSoldQuantity(), getIncome());
    }
}
