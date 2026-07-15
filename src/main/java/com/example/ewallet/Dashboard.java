package com.example.ewallet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class DashboardController {

    @FXML private Label welcomeLabel;
    @FXML private Label balanceLabel;
    @FXML private Button logoutButton;

    @FXML
    private void handleCashIn() {
        MainApp.switchScene("cashin-view.fxml");
    }

    @FXML
    private void handleSendMoney() {
        MainApp.switchScene("send-money-view.fxml");
    }

    @FXML
    private void handlePayMerchant() {
        MainApp.switchScene("pay-merchant-view.fxml");
    }

    @FXML
    private void handleCashOut() {
        MainApp.switchScene("cashout-view.fxml");
    }

    @FXML
    private void handleViewHistory() {
        MainApp.switchScene("history-view.fxml");
    }

    @FXML
    private void handleAdminPanel() {
        MainApp.switchScene("admin-view.fxml");
    }

    @FXML
    private void handleLogout() {
        MainApp.switchScene("login-view.fxml");
    }
}
