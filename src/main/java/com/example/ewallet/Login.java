package com.example.ewallet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML private TextField phoneField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;
    @FXML private Button loginButton;
    @FXML private Button goToRegisterButton;

    @FXML
    private void handleLogin() {
        MainApp.switchScene("dashboard-view.fxml");
    }

    @FXML
    private void handleGoToRegister() {
        MainApp.switchScene("register-view.fxml");
    }
}
