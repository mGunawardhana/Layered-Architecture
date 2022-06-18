package controller;


import bo.BoFactory;
import bo.NewItemBo;
import entity.Item;
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

public class NewItemFormController {
    private final LinkedHashMap<TextField, Pattern> checkBox = new LinkedHashMap<>();
    public TextField txtItemCode;
    public TextField txtPackSize;
    public TextField txtUnitPrice;
    public TextField txtQuantityOnHand;
    public Button btnAddItem;
    public Button btnCancel;
    public TextField txtDescription;
    public TextField txtDiscount;
    public AnchorPane itemAnchorPane;
    NewItemBo newItemBo = (NewItemBo) BoFactory.getBoFactory().getBo(BoFactory.BoTypes.NEW_ITEM);

    public void initialize() {
        validation_Detail_Checked_OnNewItemFormController();
    }

    public void text_Field_Checker_In_New_Item_Form(KeyEvent keyEvent) {
        ValidationUtil.textFieldChecker(checkBox, btnAddItem, keyEvent);
    }

    private void validation_Detail_Checked_OnNewItemFormController() {
        checkBox.put(txtItemCode, Pattern.compile("^I-(0)[0-9]{2,5}$"));
        checkBox.put(txtDescription, Pattern.compile("^[A-z]{2,10}$"));
        checkBox.put(txtPackSize, Pattern.compile("^(small|medium|large)"));
        checkBox.put(txtUnitPrice, Pattern.compile("^([0-9]{2,6}.[0-9]{1,2})$"));
        checkBox.put(txtQuantityOnHand, Pattern.compile("^([0-9]{1,6})$"));
        checkBox.put(txtDiscount, Pattern.compile("^[0-9]{1}$"));
    }

    public void AddNewItemOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String discount = null;

        if (txtDiscount.getText().isEmpty()) {
            discount = "0";
        } else {
            discount = txtDiscount.getText();
        }
        Item i = new Item(
                txtItemCode.getText(), txtDescription.getText(), txtPackSize.getText(),
                Double.parseDouble(txtUnitPrice.getText()), Integer.parseInt(txtQuantityOnHand.getText()),
                Double.parseDouble(discount)
        );

        if (newItemBo.SaveItems(i))
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..").show();
        else
            new Alert(Alert.AlertType.WARNING, "Try Again..").show();
        txtItemCode.clear();
        txtDescription.clear();
        txtPackSize.clear();
        txtUnitPrice.clear();
        txtQuantityOnHand.clear();
        txtDiscount.clear();

    }

    public void BackOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnCancel, "AdminItemsForm");
    }
}
