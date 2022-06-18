package dto;

public class ItemDetailsDTO {
    private String itemCode;
    private double unitPrice;
    private int QtyForSell;
    private double Discount;

    public ItemDetailsDTO(String itemCode, double unitPrice, int qtyForSell, double discount) {
        this.setItemCode(itemCode);
        this.setUnitPrice(unitPrice);
        setQtyForSell(qtyForSell);
        setDiscount(discount);
    }

    public ItemDetailsDTO(String itemCode, double unitPrice, int qtyForSell) {
        this.itemCode = itemCode;
        this.unitPrice = unitPrice;
        QtyForSell = qtyForSell;
    }

    public ItemDetailsDTO() {
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyForSell() {
        return QtyForSell;
    }

    public void setQtyForSell(int qtyForSell) {
        QtyForSell = qtyForSell;
    }

    public double getDiscount() {
        return Discount;
    }

    public void setDiscount(double discount) {
        Discount = discount;
    }
}
