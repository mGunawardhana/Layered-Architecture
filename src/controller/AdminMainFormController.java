package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import view.UILoader;

import java.io.IOException;

public class AdminMainFormController {

    public Button btnManage;
    public Button btnReports;
    public Button btnBack;

    public void MangeItemsOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnManage, "AdminItemsForm");
    }

    public void ReportsOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnManage, "AdminReportForm");
    }

    public void BackOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnManage, "logInForm");
    }
}
