package bo;


import entity.Item;

import java.sql.SQLException;

/**
 * extending RemoveItemBo interface using SuperBo
 */

public interface RemoveItemBo extends SuperBo {

    Item searchItem(String text) throws SQLException, ClassNotFoundException;

    boolean deleteItem(String text) throws SQLException, ClassNotFoundException;
}
