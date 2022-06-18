package view.tm;

import java.util.Objects;

/* loading data to Daily table */

public class DailyTm {
    private String OrderId;
    private String date;
    private int NoOfOrders;
    private int SoldQuantity;
    private double income;

    public DailyTm(String orderId, String date, int noOfOrders, int soldQuantity, double income) {
        setOrderId(orderId);
        this.setDate(date);
        setNoOfOrders(noOfOrders);
        setSoldQuantity(soldQuantity);
        this.setIncome(income);
    }

    public DailyTm(String date, int soldQuantity) {
        this.date = date;
        SoldQuantity = soldQuantity;
    }

    public DailyTm(String date, int noOfOrders, double income) {
        this.setDate(date);
        setNoOfOrders(noOfOrders);
        this.setIncome(income);
    }

    public DailyTm(String date, int noOfOrders, int soldQuantity, double income) {

        this.date = date;
        NoOfOrders = noOfOrders;
        SoldQuantity = soldQuantity;
        this.income = income;
    }

    public DailyTm() {
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
        if (!(o instanceof DailyTm)) return false;
        DailyTm dailyTm = (DailyTm) o;
        return getNoOfOrders() == dailyTm.getNoOfOrders() &&
                getSoldQuantity() == dailyTm.getSoldQuantity() &&
                Double.compare(dailyTm.getIncome(), getIncome()) == 0 &&
                Objects.equals(getOrderId(), dailyTm.getOrderId()) &&
                Objects.equals(getDate(), dailyTm.getDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrderId(), getDate(), getNoOfOrders(), getSoldQuantity(), getIncome());
    }
}
