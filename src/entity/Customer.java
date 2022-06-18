package entity;

public class Customer {
    private String CustomerId;
    private String CustomerTittle;
    private String CustomerName;
    private String CustomerAddress;
    private String City;
    private String Province;
    private String PostalCode;

    public Customer() {
    }

    public Customer(String customerId, String customerTittle, String customerName, String customerAddress, String city, String province, String postalCode) {
        CustomerId = customerId;
        CustomerTittle = customerTittle;
        CustomerName = customerName;
        CustomerAddress = customerAddress;
        City = city;
        Province = province;
        PostalCode = postalCode;
    }


    public Customer(String CustId, String CustName) {
        this.CustomerId = CustId;
        this.CustomerName = CustName;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public String getCustomerTittle() {
        return CustomerTittle;
    }

    public void setCustomerTittle(String customerTittle) {
        CustomerTittle = customerTittle;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerAddress() {
        return CustomerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        CustomerAddress = customerAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "CustomerId='" + CustomerId + '\'' +
                ", CustomerTittle='" + CustomerTittle + '\'' +
                ", CustomerName='" + CustomerName + '\'' +
                ", CustomerAddress='" + CustomerAddress + '\'' +
                ", City='" + City + '\'' +
                ", Province='" + Province + '\'' +
                ", PostalCode='" + PostalCode + '\'' +
                '}';
    }
}
