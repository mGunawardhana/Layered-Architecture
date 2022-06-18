package view.tm;

import javafx.scene.control.Button;

/* loading data to add to cart table */

public class ListsTm {

    private String ItemCode;
    private String Description;
    private double UnitPrice;
    private double Discount;
    private int Quantity;
    private double Total;
    private Button btn;

    public ListsTm() {
    }

    public ListsTm(String itemCode, String description, double unitPrice, double discount, int quantity, double total, Button btn) {
        this.setItemCode(itemCode);
        this.setDescription(description);
        this.setUnitPrice(unitPrice);
        this.setDiscount(discount);
        this.setQuantity(quantity);
        this.setTotal(total);
        this.setBtn(btn);
    }


    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        this.ItemCode = itemCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        this.Description = description;
    }

    public double getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.UnitPrice = unitPrice;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        this.Discount = discount;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        this.Quantity = quantity;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        this.Total = total;
    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }

    @Override
    public String toString() {
        return "ListsTm{" +
                "ItemCode='" + ItemCode + '\'' +
                ", Description='" + Description + '\'' +
                ", UnitPrice=" + UnitPrice +
                ", Discount=" + Discount +
                ", Quantity=" + Quantity +
                ", Total=" + Total +
                ", btn=" + btn +
                '}';
    }
}
