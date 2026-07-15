package com.example.ewallet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class PayMerchantController {

    @FXML private TextField merchantField;
    @FXML private TextField amountField;
    @FXML private PasswordField pinField;
    @FXML private Label errorLabel;
    @FXML private Button payButton;
    @FXML private Button backButton;

    @FXML
    private void handlePay() {
        MainApp.switchScene("dashboard-view.fxml");
    }

    @FXML
    private void handleBack() {
        MainApp.switchScene("dashboard-view.fxml");
    }
}
