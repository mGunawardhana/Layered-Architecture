package controller;

import bo.BoFactory;
import bo.CustomerReportBo;
import dto.CustomDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import view.UILoader;
import view.tm.CustomerWiseTm;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerWiseFormController {
    public Button btnBack;
    public TableView<CustomerWiseTm> tblCustomer;
    public TableColumn ColName;
    public TableColumn ColId;
    public TableColumn ColIncome;

    CustomerReportBo customerReportBo = (CustomerReportBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.CUSTOMER_REPORT);

    ArrayList<CustomerWiseTm> customerWiseTmArrayList = new ArrayList<>();
    ArrayList<CustomerWiseTm> arrayList2 = new ArrayList<>();
    ObservableList<CustomerWiseTm> ObList = FXCollections.observableArrayList();
    ArrayList<CustomerWiseTm> arrayListReturned;
    int index;
    int secondindex;

    public void initialize() {

        ColName.setCellValueFactory(new PropertyValueFactory<>("name"));
        ColId.setCellValueFactory(new PropertyValueFactory<>("CustId"));
        ColIncome.setCellValueFactory(new PropertyValueFactory<>("cost"));

        try {
            loadData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void loadData() throws SQLException, ClassNotFoundException {


        ArrayList<CustomDTO> orderDetails = customerReportBo.getOrderDetails();


        for (CustomDTO o : orderDetails) {
            customerWiseTmArrayList.add(new CustomerWiseTm(o.getCustId(), o.getCost()));
        }


        arrayListReturned = getName();


        for (CustomerWiseTm tm : customerWiseTmArrayList) {

            if (ifExists(tm) == -1) {

            } else {
                index = ifExists(tm);
                tm.setName(arrayListReturned.get(index).getName());
            }

        }
        load();


    }

    private void load() {
        for (CustomerWiseTm temp : customerWiseTmArrayList) {
            if (ifExists2(temp) == -1) {
                ObList.add(temp);
            } else {
                secondindex = ifExists2(temp);
                CustomerWiseTm teWiseTm = ObList.get(secondindex);
                CustomerWiseTm newTM = new CustomerWiseTm(temp.getName(), temp.getCustId(), temp.getCost() + teWiseTm.getCost());
                ObList.remove(secondindex);
                ObList.add(newTM);
            }
            ObList.sort((o1, o2) -> Double.compare(o2.getCost(), o1.getCost()));
        }
        tblCustomer.setItems(ObList);

    }

    private int ifExists2(CustomerWiseTm temp) {
        for (int i = 0; i < ObList.size(); i++) {
            if (temp.getCustId().equals(ObList.get(i).getCustId())) {
                return i;
            }
        }
        return -1;
    }


    private int ifExists(CustomerWiseTm tm) {
        for (int i = 0; i < arrayListReturned.size(); i++) {
            if (tm.getCustId().equals(arrayListReturned.get(i).getCustId())) {
                return i;
            }
        }
        return -1;
    }

    public ArrayList<CustomerWiseTm> getName() throws SQLException, ClassNotFoundException {
        ArrayList<CustomerWiseTm> arrayList2 = new ArrayList<>();
        ArrayList<CustomDTO> customerName = customerReportBo.getCustomerName();
        for (CustomDTO c : customerName) {
            arrayList2.add(new CustomerWiseTm(c.getName(), c.getCustId()));
        }
        return arrayList2;
    }

    public void BackOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnBack, "AdminReportForm");
    }
}
