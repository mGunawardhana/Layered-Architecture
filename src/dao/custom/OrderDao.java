package dao.custom;

import dao.CrudDAO;
import dto.CustomDTO;
import entity.Orders;

import java.sql.SQLException;
import java.util.ArrayList;

/* extending OrderDao using CrudDAO  */

public interface OrderDao extends CrudDAO<Orders, String> {
    String getOrderId() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException;

    ArrayList<Orders> getData() throws SQLException, ClassNotFoundException;

}
