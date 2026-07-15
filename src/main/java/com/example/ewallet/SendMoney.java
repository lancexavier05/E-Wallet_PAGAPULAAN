package com.example.ewallet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class SendMoneyController {

    @FXML private TextField recipientField;
    @FXML private TextField amountField;
    @FXML private PasswordField pinField;
    @FXML private Label errorLabel;
    @FXML private Label balanceHintLabel;
    @FXML private Button sendButton;
    @FXML private Button backButton;

    @FXML
    private void handleSend() {
        MainApp.switchScene("dashboard-view.fxml");
    }

    @FXML
    private void handleBack() {
        MainApp.switchScene("dashboard-view.fxml");
    }
}
