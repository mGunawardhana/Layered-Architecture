package bo.Impl;

import bo.NewItemBo;
import dao.custom.*;
import dao.DAOFactory;
import entity.Item;


import java.sql.SQLException;

/* implement NewItemBoImpl */

public class NewItemBoImpl implements NewItemBo {

    ItemDao itemDao = (ItemDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);

    @Override
    public boolean SaveItems(Item i) throws SQLException, ClassNotFoundException {
        return itemDao.add(i);
    }
}
