package com.example.uppgift2objektivering;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private Label test;

    @FXML
    protected void onHelloButtonClick() {
        test.setText("Vi testar detta!");
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}