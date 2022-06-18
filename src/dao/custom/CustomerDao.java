package dao.custom;

import dao.CrudDAO;
import entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* extending CustomerDao using CrudDAO  */

public interface CustomerDao extends CrudDAO<Customer, String> {
    List<String> getCustomerIds() throws SQLException, ClassNotFoundException;

    Customer getCustomer(String id) throws SQLException, ClassNotFoundException;

    ArrayList<Customer> getName() throws SQLException, ClassNotFoundException;

}
