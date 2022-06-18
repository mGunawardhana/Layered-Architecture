package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.ItemDao;
import dao.custom.OrderDetailDao;
import entity.OrderDetail;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* implementing OrderDetailDaoImpl using OrderDetailDao */

public class OrderDetailDaoImpl implements OrderDetailDao {
    @Override
    public boolean add(OrderDetail o) throws SQLException, ClassNotFoundException {
        boolean b = CrudUtil.executeUpdate("INSERT INTO OrderDetail VALUES (?,?,?,?,?)",
                o.getOrderId(), o.getItemCode(), o.getOrderQty(), o.getPrice(), o.getDiscount());

        ItemDao itemDao = new ItemDaoImpl();

        if (b) {
            if (itemDao.updateQty(o.getItemCode(), o.getOrderQty())) {

            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }


    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(entity.OrderDetail orderDetail) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public OrderDetail search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<entity.OrderDetail> getAll() throws SQLException, ClassNotFoundException {
        ArrayList<entity.OrderDetail> orderDetail = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM OrderDetail");
        while (rst.next()) {
            orderDetail.add(new entity.OrderDetail(rst.getString(1), rst.getString(2),
                    rst.getInt(3), rst.getDouble(4), rst.getDouble(5)));
        }
        return orderDetail;
    }
}
