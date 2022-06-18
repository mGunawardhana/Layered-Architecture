package view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class UILoader {

    public static void SetUI(Button A, String formName) throws IOException {
        Stage window = (Stage) A.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(UILoader.class.getResource("../view/" + formName + ".fxml"))));
        window.centerOnScreen();
    }
}
