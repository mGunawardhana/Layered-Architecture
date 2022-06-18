package controller;

import bo.BoFactory;
import bo.LowestMovableBo;
import dto.OrderDetailDTO;
import entity.OrderDetail;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.UILoader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;

public class LowestMovableFormController {
    public TableView<OrderDetail> tblItem;
    public TableColumn<Object, Object> ColItemCode;
    public TableColumn<Object, Object> ColSoldQuantity;
    public TableColumn<Object, Object> ColRevenueEarned;
    public TableColumn<Object, Object> ColDiscount;
    public Button btnBack;
    ArrayList<OrderDetail> orderDetail = new ArrayList<>();
    int index = 0;


    LowestMovableBo lowestMovableBo = (LowestMovableBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.LOWEST_MOVABLE);
    ObservableList<OrderDetail> tmObservableList = FXCollections.observableArrayList();

    public void initialize() throws SQLException, ClassNotFoundException {
        ColItemCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        ColSoldQuantity.setCellValueFactory(new PropertyValueFactory<>("OrderQty"));
        ColRevenueEarned.setCellValueFactory(new PropertyValueFactory<>("Price"));
        ColDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));

        getData();

    }

    public void getData() throws SQLException, ClassNotFoundException {

        ArrayList<OrderDetailDTO> allOrderDetails = lowestMovableBo.getAllOrderDetails();
        for (OrderDetailDTO a : allOrderDetails) {
            orderDetail.add(new OrderDetail(a.getOrderId(), a.getItemCode(), a.getOrderQty(), a.getPrice(), a.getDiscount()));
        }

        for (OrderDetail dtl : orderDetail) {

            if (isExists(dtl) == -1) {
                tmObservableList.add(dtl);
            } else {
                index = isExists(dtl);
                OrderDetail temp = tmObservableList.get(index);
                OrderDetail newTm = new OrderDetail(temp.getOrderId(), temp.getItemCode(), temp.getOrderQty() + dtl.getOrderQty(),
                        temp.getPrice() * temp.getOrderQty(), temp.getDiscount() + dtl.getDiscount());

                tmObservableList.remove(index);
                tmObservableList.add(newTm);

                tmObservableList.sort(new Comparator<OrderDetail>() {
                    @Override
                    public int compare(OrderDetail o1, OrderDetail o2) {
                        return Integer.compare(o1.getOrderQty(), o2.getOrderQty());
                    }
                });

            }
        }
        tblItem.setItems(tmObservableList);
    }


    private int isExists(OrderDetail dtl) {

        for (int i = 0; i < tmObservableList.size(); i++) {
            if (dtl.getItemCode().equals(tmObservableList.get(i).getItemCode())) {
                return i;
            }
        }
        return -1;
    }


    public void BackOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnBack, "AdminReportForm");
    }
}
