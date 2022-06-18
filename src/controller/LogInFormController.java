package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import view.UILoader;

import java.io.IOException;

public class LogInFormController {
    public TextField txtUsername;
    public TextField txtPassword;
    public Button btnLogin;

    public void loginButtonAction(ActionEvent event) throws IOException {

        if (txtUsername.getText().equalsIgnoreCase("Admin") && txtPassword.getText().equalsIgnoreCase("1234")) {

            UILoader.SetUI(btnLogin, "AdminMainForm");

        } else if (txtUsername.getText().equalsIgnoreCase("User") && txtPassword.getText().equalsIgnoreCase("1234")) {

            UILoader.SetUI(btnLogin, "CashierForm");

        } else {

            new Alert(Alert.AlertType.ERROR, "Incorrect Username Or Password.Try Again").show();
        }
    }
}
