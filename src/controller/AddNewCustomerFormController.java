package controller;

import bo.BoFactory;
import bo.CustomerBo;
import dto.CustomerDTO;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import utill.ValidationUtil;
import view.UILoader;

import java.io.IOException;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.regex.Pattern;

public class AddNewCustomerFormController {
    private final LinkedHashMap<TextField, Pattern> checker = new LinkedHashMap<>();

    public TextField txtId;
    public TextField txtName;
    public TextField txtAddress;
    public TextField txtTittle;
    public TextField txtCity;
    public TextField txtProvince;
    public Button btnCancel;
    public TextField txtPostalCode;
    public AnchorPane CustomerAnchorPane;
    public Button saveID;

    CustomerBo customerBo = (CustomerBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.CUSTOMER);

    public void initialize() {
        validation_Detail_Checked_On_AddNewCustomerFormController();
    }


    public void text_Field_Checker_In_New_Item_Form(KeyEvent keyEvent) {
        ValidationUtil.textFieldChecker(checker, saveID, keyEvent);
    }

    private void validation_Detail_Checked_On_AddNewCustomerFormController() {
        checker.put(txtId, Pattern.compile("^(C-)[0-9]{1,2}$"));
        checker.put(txtTittle, Pattern.compile("((mr)|(mrs))"));
        checker.put(txtName, Pattern.compile("^[A-z ]{3,20}$"));
        checker.put(txtAddress, Pattern.compile("^[A-z ]{5,20}$"));
        checker.put(txtCity, Pattern.compile("^[A-z ]{5,20}$"));
        checker.put(txtProvince, Pattern.compile("[A-z ]{2,}$"));
        checker.put(txtPostalCode, Pattern.compile("^[0-9]{4,5}$"));
    }

    public void SaveCustomerOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {

        CustomerDTO c1 = new CustomerDTO(
                txtId.getText(), txtTittle.getText(), txtName.getText(), txtAddress.getText(),
                txtCity.getText(), txtProvince.getText(), txtPostalCode.getText()
        );
        txtId.clear();
        txtName.clear();
        txtTittle.clear();
        txtAddress.clear();
        txtCity.clear();
        txtProvince.clear();
        txtPostalCode.clear();
        if (customerBo.addCustomer(c1))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
    }


    public void CancelOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnCancel, "CashierForm");
    }
}
