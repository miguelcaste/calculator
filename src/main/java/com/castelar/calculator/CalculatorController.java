package com.castelar.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class CalculatorController {
    double bufferDouble=0;
    String bufferString="";
    boolean operacion=false;



    @FXML
    TextField txtField;


    @FXML
    public void on0ButtonClick(ActionEvent actionEvent) {
        // Comprobar si es 0
        double variable=0;
        if(txtField.getText()!="0") {
            txtField.setText(txtField.getText()+"0");
        }
    }
    @FXML
    public void onComaButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onEqualsButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void on1ButtonClick(ActionEvent actionEvent) {
        int variable=1;
        txtField.setText(txtField.getText()+ variable);
    }
    @FXML
    public void on2ButtonClick(ActionEvent actionEvent) {
        int variable=2;
        txtField.setText(txtField.getText()+ variable);
    }
    @FXML
    public void on3ButtonClick(ActionEvent actionEvent) {
        int variable=3;
        txtField.setText(txtField.getText()+"3");
    }
    @FXML
    public void onAddButtonClick(ActionEvent actionEvent) {


    }
    @FXML
    public void on4ButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void on5ButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void on6ButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onRestButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onSevenButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void on8ButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void on9ButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onMultiplicationButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onACButtonClick(ActionEvent actionEvent) {
        txtField.setText("0");
        operacion=false;
    }
    @FXML
    public void onChangeSignedButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onPercentageButtonClick(ActionEvent actionEvent) {
    }
    @FXML
    public void onDivisionButtonClick(ActionEvent actionEvent) {
    }
}
