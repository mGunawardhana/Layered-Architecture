package bo.Impl;

import bo.DailyIncomeBo;
import dao.custom.*;
import dao.DAOFactory;
import dto.CustomDTO;


import java.sql.SQLException;
import java.util.ArrayList;

/* implement DailyIncomeBoImpl */

public class DailyIncomeBoImpl implements DailyIncomeBo {
    QueryDao queryDao= (QueryDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);
    ItemDao itemDao = (ItemDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public ArrayList<CustomDTO> getdailyItems() throws SQLException, ClassNotFoundException {
       return itemDao.dailyItem();
    }

    @Override
    public ArrayList<CustomDTO> getDailyItemsIncome() throws SQLException, ClassNotFoundException {
        return queryDao.getDailyItemIncome();
    }
}
