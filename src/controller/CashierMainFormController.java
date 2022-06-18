package controller;

import bo.BoFactory;
import bo.PlaceOrderBo;
import dto.OrderDTO;
import dto.OrderDetailDTO;
import entity.Customer;
import entity.Item;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import view.UILoader;
import view.tm.ListsTm;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CashierMainFormController {
    public Label lblDate;
    public Label lblTime;
    public ComboBox<String> cmbItemCode;
    public ComboBox<String> cmbCid;
    public TextField txtName;
    public TextField txtTittle;
    public TextField txtCity;
    public TextField txtQtyOnHand;
    public TextField txtUnitPrice;
    public TextField txtDiscount;
    public TableView<ListsTm> tblList;
    public TableColumn<Object, Object> colCode;
    public TableColumn<Object, Object> colDesc;
    public TableColumn<Object, Object> ColUnitPrice;
    public TableColumn<Object, Object> colDiscount;
    public TableColumn<Object, Object> ColDelete;
    public TableColumn<Object, Object> colQuantity;
    public TableColumn<Object, Object> ColTotal;
    public TextField txtDesc;
    public TextField txtQty;
    public Label txtTtl;
    public Label lblOrderId;
    public Button lblLogOUT;


    PlaceOrderBo placeOrderBo = (PlaceOrderBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.PLACE_ORDER);
    ObservableList<ListsTm> tmObservableList = FXCollections.observableArrayList();
    ArrayList<OrderDetailDTO> itemDetails = new ArrayList<>();

    public void initialize() {

        colCode.setCellValueFactory(new PropertyValueFactory<>("ItemCode"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        ColUnitPrice.setCellValueFactory(new PropertyValueFactory<>("UnitPrice"));
        colDiscount.setCellValueFactory(new PropertyValueFactory<>("Discount"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        ColTotal.setCellValueFactory(new PropertyValueFactory<>("Total"));
        ColDelete.setCellValueFactory(new PropertyValueFactory<>("btn"));

        loadDateAndTime();
        try {
            setOrderId();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }

        try {
            loadCustomerIds();
            loadItemCodes();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        cmbCid.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    setCustomerData(newValue);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
        cmbItemCode.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    setItemData(newValue);
                } catch (SQLException | ClassNotFoundException throwables) {
                    throwables.printStackTrace();
                }
            }
        });
    }

    private void setOrderId() throws SQLException, ClassNotFoundException {
        lblOrderId.setText(placeOrderBo.getOrderId());
    }

    private void setItemData(String newValue) throws SQLException, ClassNotFoundException {
        Item i = placeOrderBo.searchItem(newValue);
        if (i == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Customer data");
        } else {
            txtDesc.setText(i.getDescription());
            txtUnitPrice.setText(String.valueOf(i.getUnitPrice()));
            txtQtyOnHand.setText(String.valueOf(i.getQtyOnHand()));
            txtDiscount.setText(String.valueOf(i.getDiscount()));
        }
    }

    private void setCustomerData(String ID) throws SQLException, ClassNotFoundException {
        Customer c1 = placeOrderBo.getCustomer(ID);
        if (c1 == null) {
            new Alert(Alert.AlertType.WARNING, "Empty Customer data");
        } else {
            txtName.setText(c1.getCustomerName());
            txtTittle.setText(c1.getCustomerTittle());
            txtCity.setText(c1.getCity());
        }
    }

    private void loadDateAndTime() {
        Date date = new Date();
        SimpleDateFormat d = new SimpleDateFormat("yyyy-MM-dd");
        lblDate.setText(d.format(date));

        Timeline time = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            LocalTime currentTime = LocalTime.now();
            lblTime.setText(
                    currentTime.getHour() + " : " + currentTime.getMinute() +
                            " : " + currentTime.getSecond()
            );
        }),
                new KeyFrame(Duration.seconds(1))
        );
        time.setCycleCount(Animation.INDEFINITE);
        time.play();
    }

    public void loadCustomerIds() throws SQLException, ClassNotFoundException {
        List<String> ids = placeOrderBo.getCustomerIds();
        cmbCid.getItems().addAll(ids);

    }

    public void loadItemCodes() throws SQLException, ClassNotFoundException {
        ArrayList<String> ItemCodes = placeOrderBo.getItemCodes();
        cmbItemCode.getItems().addAll(ItemCodes);

    }

    public void addToListOnAction(ActionEvent event) {
        if (txtQty.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Please select Amount to purchase").show();
            return;
        }

        String description = txtDesc.getText();
        int qtyOnHnd = Integer.parseInt(txtQtyOnHand.getText());
        double unitPrice = Double.parseDouble(txtUnitPrice.getText());
        double discountOfOne = Double.parseDouble(txtDiscount.getText());
        int QtyOfCustomer = Integer.parseInt(txtQty.getText());
        double total = (unitPrice - discountOfOne) * QtyOfCustomer;
        double discount = discountOfOne * QtyOfCustomer;

        if (qtyOnHnd < QtyOfCustomer) {
            new Alert(Alert.AlertType.ERROR, "Not Enough Quantity for order").show();
            return;
        }

        Button btn = new Button("Delete");

        ListsTm listTM = new ListsTm(cmbItemCode.getValue(), description, unitPrice, discount, QtyOfCustomer, total, btn);

        int rowNumber = ifExists(listTM);

        if (rowNumber == -1) {
            tmObservableList.add(listTM);
        } else {
            ListsTm TEMP = tmObservableList.get(rowNumber);
            ListsTm newTm = new ListsTm(TEMP.getItemCode(), TEMP.getDescription(), unitPrice, TEMP.getDiscount() + discount,
                    TEMP.getQuantity() + QtyOfCustomer, TEMP.getTotal() + total, btn);
            if (qtyOnHnd < TEMP.getQuantity() + QtyOfCustomer) {
                new Alert(Alert.AlertType.ERROR, "Not Enough Quantity for order").show();
                return;
            }
            tmObservableList.remove(rowNumber);
            tmObservableList.add(newTm);
        }

        for (ListsTm tm : tmObservableList) {
            btn.setOnAction((e) -> {
                tmObservableList.remove(tm);
                calculateCost();
            });

        }

        tblList.setItems(tmObservableList);
        calculateCost();
        clear();
    }

    private int ifExists(ListsTm tm) {
        for (int i = 0; i < tmObservableList.size(); i++) {
            if (tm.getItemCode().equals(tmObservableList.get(i).getItemCode())) {
                return i;
            }
        }
        return -1;
    }

    void calculateCost() {
        double ttl = 0;
        for (ListsTm tm : tmObservableList) {
            ttl += tm.getTotal();
        }
        txtTtl.setText(ttl + " /=");
    }

    void clear() {
        txtDesc.clear();
        txtQtyOnHand.clear();
        txtUnitPrice.clear();
        txtDiscount.clear();
        txtQty.clear();
    }

    public void PlaceOrderOnAction(ActionEvent event) {
        double discount = 0;

        double ttl = 0;

        for (ListsTm tm : tmObservableList) {
            ttl += tm.getTotal();
            discount = tm.getDiscount();
            itemDetails.add(new OrderDetailDTO(tm.getItemCode(), tm.getUnitPrice(), tm.getQuantity(), discount));
        }

        OrderDTO order = new OrderDTO(lblOrderId.getText(), lblDate.getText(), cmbCid.getValue(), ttl, String.valueOf(discount), itemDetails);


        if (placeOrder(order)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Successful").show();
            try {
                setOrderId();
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
            tblList.getItems().clear();
            cmbCid.getSelectionModel().clearSelection();
            cmbItemCode.getSelectionModel().clearSelection();
            txtName.clear();
            txtTittle.clear();
            txtCity.clear();

        } else {
            new Alert(Alert.AlertType.ERROR, "Try again").show();
        }
    }

    public boolean placeOrder(OrderDTO order) {
        return placeOrderBo.placeOrder(order);
    }


    public void logOutOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(lblLogOUT, "logInForm");
    }
}
