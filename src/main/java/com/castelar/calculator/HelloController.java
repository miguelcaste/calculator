package com.castelar.calculator;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private TextField txtField;

    @FXML
    protected void on0ButtonClick() {
        txtField.setText(Double.toString(0));
    }
}