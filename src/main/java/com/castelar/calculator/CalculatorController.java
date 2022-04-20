package com.castelar.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

// Falta poder controlar que el usuario no pueda introducir caracteres extraños
// Controlar caracteres no numericos


public class CalculatorController {

    // Variables gráficas: txtField, button_string
    @FXML
    private TextField txtField; // Caja de Texto de la calculadora
    private static String button_string; // Id del botón pulsado


    // Variables internas: valor_primer_operando, operador
    private static Double valor_primer_operando; // valor primer operando
    private static String operador;


    // Variables Lógicas: introduciendo_valores, operacion_introducida
    private static boolean borrar_valores = true; // Control: Primer operando del inicio
    private static boolean operacion_introducida = false; // Control: Primer operando del inicio

    // Te pinta un entero sin decimales
    public void arreglar_entero(double resultado){
        String s="";
        if ((resultado - (int) resultado) == 0) {
            txtField.setText((int) resultado + "");
        } else {
            s=resultado+"";
            s=s.replace('.',',');
            txtField.setText(s);
        }
    }

    // RESET
    public void casoAC() {
        // System.out.println("Caso AC");
        txtField.setText("0");
        borrar_valores = true;
        operacion_introducida = false;
    }

    // Si pulso 0 y hay un 0
    private void caso0() {
        //    System.out.println("Caso 0");
//        String s=txtField.getText();
//
//        if (!primera) { //Si no es el primero
//            txtField.setText(txtField.getText() + button_string);
//        } else {
//            txtField.setText("0");
//        }
    }

    // Si pulso n y hay n, desplazo a la izquierda
    private void casoNumero() {
        //System.out.println("Caso Numero o Punto");
        String s=txtField.getText();
        if(borrar_valores==true){
            txtField.setText(button_string);
        }
        else{
            if(s.equals("")||s.equals("0")){
                txtField.setText(button_string);
            }else {
                txtField.setText(s + button_string);
            }
        }
        borrar_valores = false;
    }

    // No puedo poner mas de una coma
    private void casoComa() {
        String s = txtField.getText();

        if(borrar_valores==true){
            txtField.setText("0,");
        }
        else{
            if (s.indexOf(",") == -1) {
                txtField.setText(s + ",");
            }
        }

        borrar_valores = false;
    }


    //no afecta si hay una operación aunque tendriamos un caso (2+(+/-))
    private void casoCambioSigno() {
        System.out.println("Caso Cambio Signo");
        String s=txtField.getText();
        if(s.equals("")){
            txtField.setText("0");
        }else {
            Double n=Double.parseDouble(s);
            n=n*-1;
            arreglar_entero(n);
        }
    }

    private void casoPorcentaje() {
        System.out.println("Caso Porcentaje");
    }

    // si pulso operador me voy quedando con el último, si
    private void casoOperador() {
        //    System.out.println("Caso Operador");
        operador = button_string;
        String s=txtField.getText();

        if(s.equals("")){
            txtField.setText("0");
        }

        s=s.replace(',','.');

        //if (!primera) {
        valor_primer_operando = Double.parseDouble(s);
        operacion_introducida = true;
        //}
        borrar_valores =true;
    }

    // obtengo el resultado siempre que haya operando
    // si hay segundo operando actuaría como un igual controlar esta situación.
    private void casoIgual() {
        //    System.out.println("Caso Igual"+operador);

        //Falta comprobación

        double resultado = 0;
        String s=txtField.getText();


        if (operacion_introducida) {
            // si hay dos operadores
            s=s.replace(',','.');

            double valor_segundo_operando = Double.parseDouble(s);
//
            switch (operador) {
                case "Add":
                    resultado = valor_primer_operando + valor_segundo_operando;
                    break;
                case "Sub":
                    resultado = valor_primer_operando - valor_segundo_operando;
                    break;
                case "Mult":
                    resultado = valor_primer_operando * valor_segundo_operando;
                    break;
                case "Div":
                    resultado = valor_primer_operando / valor_segundo_operando;
                    break;
            }
//
            //Ver si es entero
            arreglar_entero(resultado);
        }
        borrar_valores = true;
        operacion_introducida=false;
    }


    @FXML
    private void onEveryButtonClick(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();
        button_string = button.getId().substring(3); //Obtenemos el Id (String) del botón que se ha pulsado
        //System.out.println(button_string);
        //System.out.println(primera);

        switch (button_string) {
            case "AC": //reset
                casoAC();
                break;
            case "0": // 0
                casoNumero();
                break;
            case "1", "2", "3", "4", "5", "6", "7", "8", "9": //Número
                casoNumero();
                break;
            case "Coma": // Coma
                casoComa();
                break;
            //Case +/- //Cambio de signo
            case "ChangeSigned": // Coma
                casoCambioSigno();
                break;
            //Case Percentage
            case "Percentage": // Coma
                casoPorcentaje();
                break;
            case "Add", "Sub", "Mult", "Div": // operador
                //caso que debería contemplar 2 + 2 + 2 // El más actuaría como un igual // usar bandera
                casoOperador();
                break;
            case "Equals": //igual //comprobar que hay operación
                casoIgual();
        }
    }




}