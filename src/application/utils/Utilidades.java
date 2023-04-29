package application.utils;

import  java.text.NumberFormat;
import  java.text.DecimalFormat;


public class Utilidades {

    public static NumberFormat formatNum = new DecimalFormat("R$ #,##0.00"); 

    public static String doubleToString(double valor) {
        return formatNum.format(valor);
    }    
}