package bo.Impl;

import bo.YearlyIncomeBo;
import dao.custom.*;
import dao.DAOFactory;
import dto.CustomDTO;


import java.sql.SQLException;
import java.util.ArrayList;

/* implement YearlyIncomeBoImpl */

public class YearlyIncomeBoImpl implements YearlyIncomeBo {
    OrderDao orderDao= (OrderDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    QueryDao queryDao= (QueryDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);

    @Override
    public ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException {
        return orderDao.getMonthlyIncome();
    }

    @Override
    public ArrayList<CustomDTO> getYearlyOrderIncome() throws SQLException, ClassNotFoundException {
        return queryDao.getYearlyOrderIncome();
    }
}
