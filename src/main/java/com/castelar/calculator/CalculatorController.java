package com.castelar.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    double bufferDouble=0;
    String bufferString="";
    boolean operacion=false;

    private static String button_string;

    private static String cadena_entrada="";// getText
    private static String cadena_salida = "0"; // setText

    private static boolean primera = true; // Control: Primer operando mo inicio
    // Controlar posibles entradas erróneas por ejemplo + + = =
    private static boolean bandera_operacion = false; // Control: Se esta realizando una operación
    private static String operador = ""; // Operador

    private static double valor_primer_operando = 0.0;
    private static double valor_segundo_operando = 0.0;

    private static double resultado = 0.0;

    @FXML
    TextField txtField;

    // RESET
    public static void casoAC(){
        System.out.println("Caso AC");

        cadena_salida = "0";
        primera=true;
    }

    // Si pulso 0 y hay un 0
    public static void caso0(){
        System.out.println("Caso 0");

        if (!primera){ //Si no es el primero
            cadena_salida = cadena_salida + cadena_entrada;
        }
        else {
            cadena_salida = "0";
        }
    }

    // Si pulso n y hay n, desplazo a la izquierda
    public static void casoNumeroPunto(){
        System.out.println("Caso Numero o Punto");

        cadena_salida = cadena_salida + cadena_entrada;
        primera=false;
    }

    // si pulso operador me voy quedando con el último, si
    public static void casoOperador(){
        System.out.println("Caso Operador");


        operador = cadena_entrada;
        valor_primer_operando = Double.parseDouble(cadena_salida);
        bandera_operacion = true;
        primera=true;
    }

    // obtengo el resultado siempre que haya operando
    // si hay segundo operando actuaría como un igual controlar esta situación.
    public static void casoIgual(){
        //Falta comprobación

        System.out.println("Caso Igual");


        valor_segundo_operando =Double.parseDouble(cadena_salida);

        switch(operador)
        {
            case "+" :
                resultado = valor_primer_operando + valor_segundo_operando;
                break;
            case "-" :
                resultado = valor_primer_operando - valor_segundo_operando;
                break;
            case "*" :
                resultado = valor_primer_operando * valor_segundo_operando;
                break;
            case "/" :
                resultado = valor_primer_operando / valor_segundo_operando;
                break;
        }

        //Ver si es entero

        if((resultado-(int)resultado)==0){
            cadena_salida=(int)resultado+"";
        }
        else {
            cadena_salida=resultado+"";
        }

        primera=true;
    }




    @FXML
    private void onEveryButtonClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        button_string = button.getId().substring(3);
        //System.out.println(button.getId().substring(3));
        //System.out.println(primera);
        if(primera){
            cadena_salida="";
        }
        switch (button_string){
            case "AC": //reset
                casoAC();
                break;
            case "0":
                caso0();
                break;
            case "1","2","3","4","5","6","7","8","9","Coma":
                casoNumeroPunto();
                break;
            case "Add","Sub","Mul","Div","Perc": // operador
                //caso que debería contemplar 2 + 2 + 2 // El más actuaría como un igual // usar bandera
                casoOperador();
                break;
            case "=": //igual //comprobar que hay operación
                casoIgual();
        }
    }






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
