package dao;

import dao.custom.Impl.*;

public class DAOFactory {
    /* Singleton design pattern */

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDAOFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
    }

    public enum DAOTypes {
        CUSTOMER, ITEM, ORDER, ORDERDETAILS, QUERYDAO
    }

    /* factory design pattern */

    public SuperDAO getDAO(DAOTypes types) {
        switch (types) {
            case CUSTOMER:
                return new CustomerDaoImpl();
            case ITEM:
                return new ItemDaoImpl();
            case ORDER:
                return new OrderDaoImpl();
            case ORDERDETAILS:
                return new OrderDetailDaoImpl();
            case QUERYDAO:
                return new QueryDaoImpl();
            default:
                return null;
        }
    }

}
