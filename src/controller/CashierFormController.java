package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import view.UILoader;

import java.io.IOException;

public class CashierFormController {
    public Button backBtn;

    public void addNewCustomerOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(backBtn, "addNewCustomerForm");
    }

    public void manageOrdersOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(backBtn, "CashierMainForm");
    }

    public void backBtnOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(backBtn, "loginForm");
    }
}
