package Instituicao;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;


public class Adicional {

    static NumberFormat formatandoNumeros = new DecimalFormat("R$ #,##0.00");
    static SimpleDateFormat formatandoData = new SimpleDateFormat("dd/MM/yyyy");

   
    public static String doubleToString(Double valor) {
        return Adicional.formatandoNumeros.format(valor);
    }

}
