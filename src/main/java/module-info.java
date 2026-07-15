module com.example.ewallet {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ewallet to javafx.fxml;
    exports com.example.ewallet;
}