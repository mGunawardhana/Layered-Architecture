package view.tm;

import java.util.Objects;

/* generating customer wise income */

public class CustomerWiseTm {
    private String name;
    private String CustId;
    private double cost;

    public CustomerWiseTm(String name, String custId, double cost) {
        this.setName(name);
        setCustId(custId);
        this.setCost(cost);
    }

    public CustomerWiseTm(String custId, double cost) {
        CustId = custId;
        this.cost = cost;
    }

    public CustomerWiseTm(String custId, String name) {
        CustId = custId;
        this.name = name;
    }

    public CustomerWiseTm(String name) {
        this.name = name;
    }

    public CustomerWiseTm() {
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
        return "CustomerWiseTm{" +
                "name='" + name + '\'' +
                ", CustId='" + CustId + '\'' +
                ", cost=" + cost +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CustomerWiseTm)) return false;
        CustomerWiseTm that = (CustomerWiseTm) o;
        return Double.compare(that.getCost(), getCost()) == 0 &&
                Objects.equals(getName(), that.getName()) &&
                Objects.equals(getCustId(), that.getCustId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getCustId(), getCost());
    }
}
