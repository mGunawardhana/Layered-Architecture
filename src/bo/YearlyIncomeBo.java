package bo;

import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/* extending NewItemBo interface using SuperBo */

public interface YearlyIncomeBo extends SuperBo {
    ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getYearlyOrderIncome() throws SQLException, ClassNotFoundException;
}
