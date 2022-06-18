package dao.custom.Impl;

import dao.CrudUtil;
import dao.custom.QueryDao;
import dto.CustomDTO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/* implementing QueryDaoImpl using QueryDao */

public class QueryDaoImpl implements QueryDao {

    @Override
    public ArrayList<CustomDTO> getDailyItemIncome() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> arrayList2 = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery("SELECT Orders.OrderDate,sum(OrderDetail.OrderQty) FROM Orders INNER JOIN  OrderDetail ON Orders.OrderId = OrderDetail.OrderId GROUP BY OrderDate");
        while (rst.next()) {
            arrayList2.add(new CustomDTO(rst.getString(1), rst.getInt(2)));
        }
        return arrayList2;
    }

    @Override
    public ArrayList<CustomDTO> getMonthlyOrderIncome() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> arrayList2 = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery(" SELECT extract(MONTH FROM(OrderDate)) ,sum(OrderDetail.OrderQty)  FROM Orders INNER JOIN  OrderDetail ON Orders.OrderId = OrderDetail.OrderId GROUP BY OrderDate");
        while (rst.next()) {
            arrayList2.add(new CustomDTO(rst.getString(1), rst.getInt(2)));
        }
        return arrayList2;
    }

    @Override
    public ArrayList<CustomDTO> getYearlyOrderIncome() throws SQLException, ClassNotFoundException {
        ArrayList<CustomDTO> arrayList2 = new ArrayList<>();
        ResultSet rst = CrudUtil.executeQuery(" SELECT extract(YEAR FROM(OrderDate)) ,sum(OrderDetail.OrderQty)  FROM Orders INNER JOIN  OrderDetail ON Orders.OrderId = OrderDetail.OrderId GROUP BY OrderDate");
        while (rst.next()) {
            arrayList2.add(new CustomDTO(rst.getString(1), rst.getInt(2)));
        }
        return arrayList2;
    }
}
