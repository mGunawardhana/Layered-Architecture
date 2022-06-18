package bo;

import dto.OrderDTO;
import entity.Customer;
import entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * extending PlaceOrderBo interface using SuperBo
 */

public interface PlaceOrderBo extends SuperBo {
    boolean placeOrder(OrderDTO dto);

    String getOrderId() throws SQLException, ClassNotFoundException;

    Item searchItem(String newValue) throws SQLException, ClassNotFoundException;

    Customer getCustomer(String id) throws SQLException, ClassNotFoundException;

    List<String> getCustomerIds() throws SQLException, ClassNotFoundException;

    ArrayList<String> getItemCodes() throws SQLException, ClassNotFoundException;
}
