package com.example.ewallet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class CashOutController {

    @FXML private ChoiceBox<String> methodChoiceBox;
    @FXML private TextField amountField;
    @FXML private PasswordField pinField;
    @FXML private Label errorLabel;
    @FXML private Label balanceHintLabel;
    @FXML private Button confirmButton;
    @FXML private Button backButton;

    @FXML
    private void initialize() {
        methodChoiceBox.getItems().addAll("Bank Transfer", "Over-the-Counter");
    }

    @FXML
    private void handleConfirm() {
        MainApp.switchScene("dashboard-view.fxml");
    }

    @FXML
    private void handleBack() {
        MainApp.switchScene("dashboard-view.fxml");
    }
}
