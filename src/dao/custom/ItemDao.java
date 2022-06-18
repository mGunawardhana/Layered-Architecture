package dao.custom;

import dao.CrudDAO;
import dto.CustomDTO;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

/* extending ItemDao using CrudDAO  */

public interface ItemDao extends CrudDAO<Item, String> {
    ArrayList<String> getItemCodes() throws SQLException, ClassNotFoundException;

    boolean updateQty(String itemCode, int qty) throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> dailyItem() throws SQLException, ClassNotFoundException;


}
