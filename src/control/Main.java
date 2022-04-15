package control;

import util.Lector;


/***
 * Calculadora estándar que ofrece operaciones básicas y evalúa los comandos inmediatamente a medida que se ingresan.
 * author: Miguel Castelló Sosa
 */
public class Main {
    private static String cadena_entrada="";// getText
    private static String cadena_salida = "0"; // setText

    private static boolean primera = true; // Control: Primer operando mo inicio
    // Controlar posibles entradas erroneas por ejemplo + + = =
    private static boolean bandera_operacion = false; // Control: Se esta realizando una operación
    private static String operador = ""; // Operador

    private static double valor_primer_operando = 0.0;
    private static double valor_segundo_operando = 0.0;

    private static double resultado = 0.0;

    // RESET
    public static void casoAC(){
        cadena_salida = "0";
        primera=true;
    }

    // Si pulso 0 y hay un 0
    public static void caso0(){
        if (!primera){ //Si no es el primero
            cadena_salida = cadena_salida + cadena_entrada;
        }
        else {
            cadena_salida = "0";
        }
    }

    // Si pulso n y hay n, desplazo a la izquierda
    public static void casoNumerosYPunto(){
        cadena_salida = cadena_salida + cadena_entrada;
        primera=false;
    }

    // si pulso operador me voy quedando con el último, si
    public static void casoOperador(){
        operador = cadena_entrada;
        valor_primer_operando = Double.parseDouble(cadena_salida);
        bandera_operacion = true;
        primera=true;
    }

    // obtengo el resultado siempre que haya operando
    // si hay segundo operando actuaría como un igual controlar esta situación.
    public static void casoIgual(){
        //Falta comprobación

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

    // Ejemplo
    // ENTRADA POR PANTALLA 1 -> 10 -> 100


    //CREAR LA ESTRUCTURA OPERANDO
    //Operando
    //Atributos
    // String
    // Numerico
    //Métodos
    // Suma
    // Resta

    // Objetos
    //primer
    //segundo
    //resultado


    //Quiza estructura operación
    //Atributos
    //Primer operando

    //Segundo operando

    //Operación

    // Métodos

    //Calcular resultado


    public static void main(String[] args) {
        while(true){
            cadena_entrada = Lector.leerLinea("Dame número o operación:");
            if(primera){
                cadena_salida="";
            }
            switch (cadena_entrada){
                case "AC": //reset
                    casoAC();
                    break;
                case "0":
                    caso0();
                    break;
                case "1","2","3","4","5","6","7","8","9",".":
                    casoNumerosYPunto();
                    break;
                case "+","-","*","/","%": // operador
                    //caso que deberia contemplar 2 + 2 + 2 // El mas actuaría como un igual // usar bandera
                    casoOperador();
                    break;
                case "=": //igual //comprobar que hay operación
                    casoIgual();
           }
        }
    }
}
