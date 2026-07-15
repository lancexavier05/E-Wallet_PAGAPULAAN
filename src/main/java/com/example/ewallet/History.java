package com.example.ewallet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class HistoryController {

    @FXML private TableView<?> historyTable;
    @FXML private TableColumn<?, ?> txnIdColumn;
    @FXML private TableColumn<?, ?> typeColumn;
    @FXML private TableColumn<?, ?> amountColumn;
    @FXML private TableColumn<?, ?> dateColumn;
    @FXML private TableColumn<?, ?> statusColumn;
    @FXML private Button backButton;

    @FXML
    private void handleBack() {
        MainApp.switchScene("dashboard-view.fxml");
    }
}
