package dto;


import java.util.Objects;

public class ItemDTO {
    private String ItemCode;
    private String Description;
    private String PackSize;
    private String UnitPrice;
    private String QtyOnHand;
    private String Discount;

    public ItemDTO(String itemCode, String description, String packSize, String unitPrice, String qtyOnHand, String discount) {
        ItemCode = itemCode;
        Description = description;
        PackSize = packSize;
        UnitPrice = unitPrice;
        QtyOnHand = qtyOnHand;
        Discount = discount;
    }

    public ItemDTO() {
    }

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPackSize() {
        return PackSize;
    }

    public void setPackSize(String packSize) {
        PackSize = packSize;
    }

    public String getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(String unitPrice) {
        UnitPrice = unitPrice;
    }

    public String getQtyOnHand() {
        return QtyOnHand;
    }

    public void setQtyOnHand(String qtyOnHand) {
        QtyOnHand = qtyOnHand;
    }

    public String getDiscount() {
        return Discount;
    }

    public void setDiscount(String discount) {
        Discount = discount;
    }

    @Override
    public String toString() {
        return "Item{" +
                "ItemCode='" + ItemCode + '\'' +
                ", Description='" + Description + '\'' +
                ", PackSize='" + PackSize + '\'' +
                ", UnitPrice='" + UnitPrice + '\'' +
                ", QtyOnHand='" + QtyOnHand + '\'' +
                ", Discount='" + Discount + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ItemDTO)) return false;
        ItemDTO itemDTO = (ItemDTO) o;
        return Objects.equals(getItemCode(), itemDTO.getItemCode()) &&
                Objects.equals(getDescription(), itemDTO.getDescription()) &&
                Objects.equals(getPackSize(), itemDTO.getPackSize()) &&
                Objects.equals(getUnitPrice(), itemDTO.getUnitPrice()) &&
                Objects.equals(getQtyOnHand(), itemDTO.getQtyOnHand()) &&
                Objects.equals(getDiscount(), itemDTO.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getItemCode(), getDescription(), getPackSize(), getUnitPrice(), getQtyOnHand(), getDiscount());
    }
}
