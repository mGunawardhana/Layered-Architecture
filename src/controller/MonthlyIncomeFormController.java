package controller;

import bo.BoFactory;
import bo.MonthlyIncomeBo;
import dto.CustomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.UILoader;
import view.tm.DailyTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class MonthlyIncomeFormController {
    public TableColumn<Object, Object> colNumOfOrders;
    public TableColumn<Object, Object> colNumOfItemsSold;
    public TableColumn<Object, Object> colIncome;
    public Button btnBack;
    public TableView<DailyTm> tblMonthly;
    public TableColumn<Object, Object> colMonth;
    public Label lblTotal;

    MonthlyIncomeBo monthlyIncomeBo = (MonthlyIncomeBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.MONTHLY_INCOME);
    ArrayList<DailyTm> dailyTmArrayList = new ArrayList<>();
    ArrayList<DailyTm> arrayList2 = new ArrayList<>();
    int index = 0;
    ObservableList<DailyTm> obList = FXCollections.observableArrayList();
    double total;

    public void initialize() {
        colMonth.setCellValueFactory(new PropertyValueFactory<>("date"));
        colNumOfOrders.setCellValueFactory(new PropertyValueFactory<>("NoOfOrders"));
        colNumOfItemsSold.setCellValueFactory(new PropertyValueFactory<>("SoldQuantity"));
        colIncome.setCellValueFactory(new PropertyValueFactory<>("income"));
        try {
            loadData();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    private void loadData() throws SQLException, ClassNotFoundException {


        ArrayList<CustomDTO> monthlyIncome = monthlyIncomeBo.getMonthlyIncome();
        for (CustomDTO c : monthlyIncome) {
            dailyTmArrayList.add(new DailyTm(c.getDate(), c.getNoOfOrders(), c.getSoldQuantity(), c.getIncome()));
        }

        loadSecondData();
    }

    private void loadSecondData() throws SQLException, ClassNotFoundException {


        ArrayList<CustomDTO> monthlyOrderIncome = monthlyIncomeBo.getMonthlyOrderIncome();

        for (CustomDTO c : monthlyOrderIncome) {
            arrayList2.add(new DailyTm(c.getDate(), c.getNoOfOrders(), c.getSoldQuantity(), c.getIncome()));
        }

        for (DailyTm tm : arrayList2) {
            if (ifExists(tm) == -1) {

            }
            index = ifExists(tm);
            DailyTm temp = dailyTmArrayList.get(index);
            DailyTm newTm = new DailyTm(tm.getDate(), temp.getNoOfOrders() + tm.getNoOfOrders(), tm.getSoldQuantity() + tm.getSoldQuantity(), temp.getIncome() + tm.getIncome());
            dailyTmArrayList.remove(index);
            dailyTmArrayList.add(newTm);
        }

        for (DailyTm TM : dailyTmArrayList) {
            if (ifExists2(TM) == -1) {
                obList.add(TM);
            } else {
                int num = ifExists2(TM);
                DailyTm TEMP = obList.get(num);
                DailyTm newTm = new DailyTm(TEMP.getDate(), TEMP.getNoOfOrders() + TM.getNoOfOrders(), TEMP.getSoldQuantity() + TM.getSoldQuantity(), TEMP.getIncome() + TM.getIncome());
                obList.remove(num);
                obList.add(newTm);
            }
        }

        tblMonthly.setItems(obList);

        for (DailyTm temp : dailyTmArrayList) {
            total += temp.getIncome();
            lblTotal.setText(String.valueOf(total));
        }
    }

    private int ifExists2(DailyTm tm) {
        for (int i = 0; i < obList.size(); i++) {
            if (tm.getDate().equals(obList.get(i).getDate())) {
                return i;
            }
        }
        return -1;
    }

    private int ifExists(DailyTm tm) {
        for (int i = 0; i < dailyTmArrayList.size(); i++) {
            int tempMonth = Integer.parseInt(dailyTmArrayList.get(i).getDate().split("-")[1]);
            if (tm.getDate().equals(String.valueOf(tempMonth))) {
                return i;
            }
        }
        return -1;
    }


    public void BackOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnBack, "AdminReportForm");
    }

}
