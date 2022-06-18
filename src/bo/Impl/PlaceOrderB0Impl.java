package bo.Impl;

import bo.PlaceOrderBo;
import dao.custom.*;
import dao.DAOFactory;
import db.DbConnection;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Customer;
import entity.Item;
import entity.OrderDetail;
import entity.Orders;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/* implement PlaceOrderB0Impl */

public class PlaceOrderB0Impl implements PlaceOrderBo {

    CustomerDao customerDao= (CustomerDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDao itemDao = (ItemDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDao orderDao= (OrderDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    OrderDetailDao OrderDetailDao= (OrderDetailDao) DAOFactory.getDAOFactory().getDAO(DAOFactory.DAOTypes.ORDERDETAILS);


    @Override
    public boolean placeOrder(OrderDTO dto){

        Connection con=null;
        try {
            con= DbConnection.getInstance().getConnection();
            con.setAutoCommit(false);



            boolean b = orderDao.add(new Orders(dto.getOrderId(),dto.getOrderDate(),dto.getCustId(),dto.getCost()));
            System.out.println(dto.getOrderId());

            for (OrderDetailDTO detailDTO : dto.getDetailDTOS()) {

                OrderDetail orderDetail=new OrderDetail(dto.getOrderId(),detailDTO.getItemCode(),detailDTO.getOrderQty(),detailDTO.getPrice(),detailDTO.getDiscount());


                if (b){

                    if(OrderDetailDao.add(orderDetail)){
                        con.commit();
                        return true;
                    }else{
                        con.rollback();
                        return false;
                    }

                }else{
                    con.rollback();
                    return false;
                }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                con.setAutoCommit(true);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;

    }

    @Override
    public String getOrderId() throws SQLException, ClassNotFoundException {
        return orderDao.getOrderId();
    }

    @Override
    public Item searchItem(String newValue) throws SQLException, ClassNotFoundException {
        Item i = itemDao.search(newValue);
        return new Item(i.getItemCode(),i.getDescription(),i.getPackSize(),i.getUnitPrice(),i.getQtyOnHand(),i.getDiscount());
    }

    @Override
    public Customer getCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDao.getCustomer(id);
    }

    @Override
    public List<String> getCustomerIds() throws SQLException, ClassNotFoundException {
        return customerDao.getCustomerIds();
    }

    @Override
    public ArrayList<String> getItemCodes() throws SQLException, ClassNotFoundException {
        return itemDao.getItemCodes();
    }
}
