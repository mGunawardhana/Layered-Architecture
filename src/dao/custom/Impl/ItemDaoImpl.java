package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.ItemDao;
import dto.CustomDTO;
import entity.Item;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* implementing ItemDaoImpl using ItemDao */

public class ItemDaoImpl implements ItemDao {
    @Override
    public boolean add(Item i) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO Item VALUES (?,?,?,?,?,?)", i.getItemCode(), i.getDescription(), i.getPackSize(), i.getUnitPrice(), i.getQtyOnHand(), i.getDiscount());
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("DELETE FROM Item WHERE ItemCode=?", id);
    }

    @Override
    public boolean update(Item item) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Item SET Description=?,PackSize=?,UnitPrice=?,QtyOnHand=?,Discount=? WHERE ItemCode=?", item.getDescription(), item.getPackSize(), item.getUnitPrice(), item.getQtyOnHand(), item.getDiscount(), item.getItemCode());
    }

    @Override
    public Item search(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item WHERE ItemCode=?", id);
        if (rst.next()) {
            return new Item(rst.getString(1), rst.getString(2), rst.getString(3),
                    rst.getDouble(4), rst.getInt(5), rst.getDouble(6));
        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Item> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public ArrayList<String> getItemCodes() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Item");
        ArrayList<String> itemCodes = new ArrayList<>();
        while (rst.next()) {
            itemCodes.add(rst.getString(1));
        }
        return itemCodes;
    }

    @Override
    public boolean updateQty(String itemCode, int qty) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("UPDATE Item SET QtyOnHand=(QtyOnHand-?) WHERE ItemCode=?", qty, itemCode);
    }

    @Override
    public ArrayList<CustomDTO> dailyItem() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> dailyTmArrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select OrderDate, count(OrderId),sum(Cost)from Orders group by OrderDate");
        while (rst.next()) {
            dailyTmArrayList.add(new CustomDTO(rst.getString(1), rst.getInt(2), rst.getDouble(3)));
        }
        return dailyTmArrayList;
    }


}
