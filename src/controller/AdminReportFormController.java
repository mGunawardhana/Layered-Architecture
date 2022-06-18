package controller;

import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import view.UILoader;

import java.io.IOException;

public class AdminReportFormController {
    public Button btnItemStatus;
    public Button btnLeastMv;
    public Button btnCusWise;
    public Button btnBack;
    public Button btnDailyI;
    public Button btnMonthly;
    public Button btnYearly;

    public void ItemStatusOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnItemStatus, "MostMovableItemForm");
    }

    public void leastMvOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnLeastMv, "lowestMovableForm");
    }

    public void CustomerWiseIncomeOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnLeastMv, "CustomerWiseForm");
    }

    public void BackOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnBack, "AdminMainForm");
    }

    public void DailyIncomeOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnDailyI, "DailyIncomeForm");
    }

    public void MonthlyIncomeOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnMonthly, "MonthlyIncomeForm");
    }

    public void YearlyIncomeOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnYearly, "MonthlyIncomeForm");
    }

    public void playMouseEnterAnimation(MouseEvent mouseEvent) {
        if (mouseEvent.getSource() instanceof Button) {
            Button btn = (Button) mouseEvent.getSource();

            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), btn);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

            DropShadow glow = new DropShadow();
            glow.setColor(Color.BLUE);
            glow.setWidth(20);
            glow.setHeight(20);
            glow.setRadius(20);
            btn.setEffect(glow);
        }
    }

    public void playMouseExitedAnimation(MouseEvent mouseEvent) {

        if (mouseEvent.getSource() instanceof Button) {
            Button btn = (Button) mouseEvent.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), btn);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            btn.setEffect(null);
        }
    }
}
