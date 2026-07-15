package com.example.ewallet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class AdminController {

    @FXML private TableView<?> usersTable;
    @FXML private TableColumn<?, ?> userIdColumn;
    @FXML private TableColumn<?, ?> userNameColumn;
    @FXML private TableColumn<?, ?> userPhoneColumn;
    @FXML private TableColumn<?, ?> userStatusColumn;
    @FXML private Button suspendUserButton;

    @FXML private TableView<?> allTxnsTable;
    @FXML private TableColumn<?, ?> txnIdColumn2;
    @FXML private TableColumn<?, ?> fromColumn;
    @FXML private TableColumn<?, ?> toColumn;
    @FXML private TableColumn<?, ?> amountColumn2;
    @FXML private TableColumn<?, ?> statusColumn2;

    @FXML private Button backButton;

    @FXML
    private void handleSuspendUser() {
    }

    @FXML
    private void handleBack() {
        MainApp.switchScene("dashboard-view.fxml");
    }
}
