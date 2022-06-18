package dao.custom;

import dao.CrudDAO;
import entity.OrderDetail;

/* extending OrderDetailDao using CrudDAO  */

public interface OrderDetailDao extends CrudDAO<OrderDetail, String> {
}
