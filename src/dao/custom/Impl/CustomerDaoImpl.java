package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.CustomerDao;
import entity.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* implementing CustomerDaoImpl using CustomerDao */

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public boolean add(entity.Customer c) throws SQLException, ClassNotFoundException {
        return CrudUtil.executeUpdate("INSERT INTO Customer VALUES(?,?,?,?,?,?,?)", c.getCustomerId(), c.getCustomerTittle(), c.getCustomerName(), c.getCustomerAddress(), c.getCity(), c.getProvince(), c.getPostalCode());
    }

    @Override
    public boolean delete(String s) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean update(entity.Customer customer) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public entity.Customer search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<Customer> getAll() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer");
        List<String> ids = new ArrayList<>();
        while (rst.next()) {
            ids.add(rst.getString(1));
        }
        return ids;
    }

    @Override
    public entity.Customer getCustomer(String id) throws SQLException, ClassNotFoundException {
        ResultSet rst = CrudUtil.executeQuery("SELECT * FROM Customer WHERE CustId=?", id);
        if (rst.next()) {
            return new entity.Customer(
                    rst.getString(1),
                    rst.getString(2),
                    rst.getString(3),
                    rst.getString(4),
                    rst.getString(5),
                    rst.getString(6),
                    rst.getString(7)
            );

        } else {
            return null;
        }
    }

    @Override
    public ArrayList<Customer> getName() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = CrudUtil.executeQuery("SELECT CustId,CustName FROM Customer");
        ArrayList<Customer> arrayList2 = new ArrayList<>();
        while (resultSet.next()) {
            arrayList2.add(new Customer(resultSet.getString(1), resultSet.getString(2)));
        }

        return arrayList2;

    }


}
