package bo.Impl;

import bo.CustomerBo;
import dao.DAOFactory;
import dao.custom.CustomerDao;
import dto.CustomerDTO;
import entity.Customer;

import java.sql.SQLException;

/* implement CustomerBoImpl */

public class CustomerBOImpl implements CustomerBo {

    CustomerDao customerDao = (CustomerDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);

    @Override
    public boolean addCustomer(CustomerDTO c1) throws SQLException, ClassNotFoundException {
        return customerDao.add(new Customer(
                c1.getId(),
                c1.getTittle(),
                c1.getName(),
                c1.getAddress(),
                c1.getCity(),
                c1.getProvince(),
                c1.getPostalCode())
        );
    }
}
