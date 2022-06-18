package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import view.UILoader;

import java.io.IOException;

public class AdminItemsFormController {

    public Button btnNewItem;
    public Button btnModify;
    public Button btnRemoveItems;
    public Button btnBack;

    public void newItemOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnBack, "NewItemForm");
    }

    public void ModifyItemOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnModify, "ModifyItemForm");
    }

    public void removeItemsOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnRemoveItems, "RemoveItems");
    }

    public void BackOnAction(ActionEvent event) throws IOException {
        UILoader.SetUI(btnBack, "AdminMainForm");
    }


}
