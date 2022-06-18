package bo;

import dto.CustomerDTO;


import java.sql.SQLException;


/** extending CustomerBo interface using SuperBo */

public interface CustomerBo extends SuperBo {
    boolean addCustomer(CustomerDTO c1) throws SQLException, ClassNotFoundException;
}
