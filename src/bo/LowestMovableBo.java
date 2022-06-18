package bo;

import dto.OrderDetailDTO;


import java.sql.SQLException;
import java.util.ArrayList;

/** extending LowestMovableBo interface using SuperBo */

public interface LowestMovableBo extends SuperBo{
    ArrayList<OrderDetailDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException;
}
