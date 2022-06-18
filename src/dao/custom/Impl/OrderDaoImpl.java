package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.OrderDao;
import dto.CustomDTO;
import entity.Orders;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* implementing OrderDaoImpl using OrderDao */

public class OrderDaoImpl implements OrderDao {
    @Override
    public boolean add(Orders o) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO Orders VALUES(?,?,?,?)", o.getOrderId(), o.getOrderDate(), o.getCustId(), o.getCost());

    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(Orders orders) throws SQLException, ClassNotFoundException {
        return false;
    }


    @Override
    public Orders search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Orders> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }


    @Override
    public String getOrderId() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT OrderId FROM Orders ORDER BY OrderId DESC LIMIT 1");
        if (rst.next()) {

            int tempId = Integer.
                    parseInt(rst.getString(1).split("-")[1]);
            tempId = tempId + 1;
            if (tempId <= 9) {
                return "O-00" + tempId;
            } else if (tempId <= 99) {
                return "O-0" + tempId;
            } else {
                return "O-" + tempId;
            }

        } else {
            return "O-001";
        }
    }

    @Override
    public ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> dailyTmArrayList = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("select OrderDate, count(OrderId),sum(Cost)from Orders group by OrderDate");
        while (rst.next()) {
            dailyTmArrayList.add(new CustomDTO(rst.getString(1), rst.getInt(2), rst.getDouble(3)));
        }
        return dailyTmArrayList;
    }

    @Override
    public ArrayList<Orders> getData() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT CustId,Cost FROM Orders");
        ArrayList<Orders> customerWiseTmArrayList = new ArrayList<>();
        while (rst.next()) {
            customerWiseTmArrayList.add(new Orders(rst.getString(1), rst.getDouble(2)));
        }
        return customerWiseTmArrayList;
    }
}
