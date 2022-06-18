package dao.custom;

import dao.SuperDAO;
import dto.CustomDTO;

import java.sql.SQLException;
import java.util.ArrayList;

/* extending QueryDao using SuperDAO  */

public interface QueryDao extends SuperDAO {

    ArrayList<CustomDTO> getDailyItemIncome() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getMonthlyOrderIncome() throws SQLException, ClassNotFoundException;

    ArrayList<CustomDTO> getYearlyOrderIncome() throws SQLException, ClassNotFoundException;
}
