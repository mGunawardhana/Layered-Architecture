package bo.Impl;

import bo.LowestMovableBo;
import dao.custom.*;

import dao.DAOFactory;
import dto.OrderDetailDTO;
import entity.OrderDetail;


import java.sql.SQLException;
import java.util.ArrayList;

/* implement LowestMovableBoImpl */

public class LowestMovableBoImpl implements LowestMovableBo {

    OrderDetailDao orderDetailDao = (OrderDetailDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);


    @Override
    public ArrayList<OrderDetailDTO> getAllOrderDetails() throws SQLException, ClassNotFoundException {
        ArrayList<OrderDetailDTO> orderDetailDTOS=new ArrayList<>();
        ArrayList<OrderDetail> all = orderDetailDao.getAll();
        for (OrderDetail o : all) {
            orderDetailDTOS.add(new OrderDetailDTO(o.getOrderId(),o.getItemCode(),o.getOrderQty(),o.getPrice(),o.getDiscount()));
        }
        return orderDetailDTOS;
    }
}
