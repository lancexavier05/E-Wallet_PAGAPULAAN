package com.example.ewallet;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {

    @FXML private TextField nameField;
    @FXML private TextField phoneField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label errorLabel;
    @FXML private Button registerButton;
    @FXML private Button backToLoginButton;

    @FXML
    private void handleRegister() {
        MainApp.switchScene("login-view.fxml");
    }

    @FXML
    private void handleBackToLogin() {
        MainApp.switchScene("login-view.fxml");
    }
}
