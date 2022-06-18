package bo.Impl;

import bo.MonthlyIncomeBo;
import dao.custom.*;
import dao.DAOFactory;
import dto.CustomDTO;


import java.sql.SQLException;
import java.util.ArrayList;

/* implement MonthlyIncomeBoImpl */

public class MonthlyIncomeBoImpl implements MonthlyIncomeBo {


    OrderDao orderDao= (OrderDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    QueryDao queryDao= (QueryDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);



    @Override
    public ArrayList<CustomDTO> getMonthlyIncome() throws SQLException, ClassNotFoundException {
        return orderDao.getMonthlyIncome();
    }

    @Override
    public ArrayList<CustomDTO> getMonthlyOrderIncome() throws SQLException, ClassNotFoundException {
        return queryDao.getMonthlyOrderIncome();
    }
}
